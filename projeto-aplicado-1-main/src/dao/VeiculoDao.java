package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {
	
	private static VeiculoDao instance;

	private Connection con = ConnectionUtil.getConnection();
	
	/*
	 * Singleton
	 */
	
	public static VeiculoDao getInstance() {
		if (instance==null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		try {
			String sql = "insert into veiculo "
					+ "(placa, modelo, km, consumo) "
					+ "values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setString(2, veiculo.getModelo());
			pstmt.setInt(3, veiculo.getKm());
			pstmt.setFloat(4, veiculo.getConsumo());
			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "update veiculo set "
					+ "placa = ?, "
					+ "modelo = ?, "
					+ "km = ?, "
					+ "consumo = ? "
					+ "where idVeiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);	
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setString(2, veiculo.getModelo());
			pstmt.setInt(3, veiculo.getKm());
			pstmt.setFloat(4, veiculo.getConsumo());
			pstmt.setInt(5, veiculo.getIdVeiculo());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int idVeiculo) {
		try {
			String sql = "delete from veiculo where idVeiculo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);	
			pstmt.setInt(1, idVeiculo);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> listar(){
		List<Veiculo> listaVeiculo = new ArrayList<>();
		try {
			String sql = "select * from veiculo";
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Veiculo v = new Veiculo(0, sql, sql, 0, 0);
				v.setIdVeiculo(rs.getInt("idVeiculo"));
				v.setPlaca(rs.getString("placa"));
				v.setModelo(rs.getString("modelo"));
				v.setKm(rs.getInt("km"));
				v.setConsumo(rs.getFloat("consumo"));
				listaVeiculo.add(v);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listaVeiculo;
	}
	
}
