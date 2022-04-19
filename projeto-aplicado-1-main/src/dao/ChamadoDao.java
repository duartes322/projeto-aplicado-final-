package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import model.Funcionario;
import model.Veiculo;
import util.ConnectionUtil;

public class ChamadoDao {
	
	private static ChamadoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static ChamadoDao getInstance() {
		if (instance==null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void salvar(Chamado chamado) {
		try {
			String sql = "insert into chamado "
					+ "(data, endereco, distancia, veiculo, funcionario) "
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, (Date) chamado.getData());
			pstmt.setString(2, chamado.getEndereco());
			pstmt.setFloat(3, chamado.getDistancia());
			pstmt.setObject(4, chamado.getVeiculo().getIdVeiculo());
			pstmt.setObject(5, chamado.getFuncionario().getIdFuncionario());
			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void atualizar(Chamado chamado) {
		try {
			String sql = "update chamado set "
					+ "data = ?, "
					+ "endereco = ?, "
					+ "distancia = ?, "
					+ "veiculo = ?, "
					+ "funcionario = ? "
					+ "where idChamado = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);	
			pstmt.setDate(1, (Date) chamado.getData());
			pstmt.setString(2, chamado.getEndereco());
			pstmt.setFloat(3, chamado.getDistancia());
			pstmt.setObject(4, chamado.getVeiculo().getIdVeiculo());
			pstmt.setObject(5, chamado.getFuncionario().getIdFuncionario());
			pstmt.setInt(6, chamado.getIdChamado());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int idChamado) {
		try {
			String sql = "delete from chamado where idChamado = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);	
			pstmt.setInt(1, idChamado);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Chamado> listar(){
		List<Chamado> listaChamado = new ArrayList<>();
		try {
			String sql = "select * from chamado";
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareCall("select * from veiculo where idVeiculo = ?");
			PreparedStatement pstmt2 = con.prepareCall("select * from funcionario where idFuncionario = ?");
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Chamado c = new Chamado(0, null, sql, 0, null, null);
				c.setIdChamado(rs.getInt("idChamado"));
				c.setData(rs.getDate("data"));
				c.setEndereco(rs.getString("endereco"));
				c.setDistancia(rs.getFloat("distancia"));
				//try {
					int veiculo = rs.getInt("veiculo");
					pstmt.setInt(1, veiculo);
					ResultSet rs2 = pstmt.executeQuery();
					if(rs2.next()) {
						Veiculo v = new Veiculo(veiculo,rs2.getString("placa"),rs2.getString("modelo"),rs2.getInt("km"), rs2.getFloat("consumo"));
						c.setVeiculo(v);
					}
					int funcionario = rs.getInt("funcionario");
					pstmt2.setInt(1, funcionario);
					ResultSet rs3 = pstmt2.executeQuery();
					if(rs3.next()) {
						Funcionario f = new Funcionario(funcionario, rs3.getString("nome"), rs3.getDate("aniversario"), rs3.getDate("ingresso"), rs3.getString("endereco"), rs3.getString("habilitacao"));
						c.setFuncionario(f);
					}
				//}catch(Exception e){
				//	e.printStackTrace();
				//}
				listaChamado.add(c);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listaChamado;
	}
}
