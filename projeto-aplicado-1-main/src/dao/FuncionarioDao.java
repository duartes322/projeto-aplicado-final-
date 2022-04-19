package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import util.ConnectionUtil;

public class FuncionarioDao {
	
	private static FuncionarioDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	/*
	 * Singleton
	 */
	
	public static FuncionarioDao getInstance() {
		if (instance==null) {
			instance = new FuncionarioDao();
		}
		return instance;
	}
	
	public void salvar(Funcionario funcionario) {
		try {
			String sql = "insert into funcionario "
					+ "(nome, aniversario, ingresso, endereco, habilitacao) "
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setDate(2,(Date) (funcionario.getAniversario()));
			pstmt.setDate(3, (Date) (funcionario.getIngresso()));
			pstmt.setString(4, funcionario.getEndereco());
			pstmt.setString(5, funcionario.getHabilitacao());
			pstmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void atualizar(Funcionario funcionario) {
		try {
			String sql = "update funcionario set "
					+ "nome = ?, "
					+ "aniversario = ?, "
					+ "ingresso = ?, "
					+ "endereco = ?, "
					+ "habilitacao = ? "
					+ "where idFuncionario = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);	
			pstmt.setString(1, funcionario.getNome());
			pstmt.setDate(2,(Date) (funcionario.getAniversario()));
			pstmt.setDate(3, (Date) (funcionario.getIngresso()));
			pstmt.setString(4, funcionario.getEndereco());
			pstmt.setString(5, funcionario.getHabilitacao());
			pstmt.setInt(6, funcionario.getIdFuncionario());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(int idFuncionario) {
		try {
			String sql = "delete from funcionario where idFuncionario = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);	
			pstmt.setInt(1, idFuncionario);
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> listar(){
		List<Funcionario> listaFuncionario = new ArrayList<>();
		try {
			String sql = "select * from funcionario";
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Funcionario f = new Funcionario(0, sql, null, null, sql, sql);
				f.setIdFuncionario(rs.getInt("idFuncionario"));
				f.setNome(rs.getString("nome"));
				f.setAniversario(rs.getDate("aniversario"));
				f.setIngresso(rs.getDate("ingresso"));
				f.setEndereco(rs.getString("endereco"));
				f.setHabilitacao(rs.getString("habilitacao"));
				listaFuncionario.add(f);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listaFuncionario;
	}
}
