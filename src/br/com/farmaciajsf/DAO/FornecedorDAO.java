package br.com.farmaciajsf.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.farmaciajsf.domain.Fornecedor;
import br.com.farmaciajsf.factory.ConexaoFactory;

public class FornecedorDAO {

	public void salvar(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedor ");
		sql.append("(descricao) ");
		sql.append("VALUES (?) " );
		
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fornecedor.getDescricao());
		comando.executeUpdate();
		
	}
	
	
	
	
	public void excluir (Fornecedor fornecedor) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedor ");
		sql.append("WHERE id = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fornecedor.getId());
		comando.executeUpdate();

	}
	
	
	
	
	
	public static void main(String[] args) {
		/*Fornecedor f1 = new Fornecedor();
		f1.setDescricao("Teste 1");
		Fornecedor f2 = new Fornecedor();
		f2.setDescricao("Teste 2");
		
		FornecedorDAO fdao= new FornecedorDAO();
		
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Gravado no DB com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao gravar no DB!");
			e.printStackTrace();
		}*/
		
		Fornecedor f1 = new Fornecedor();
		f1.setId(2);
		
		FornecedorDAO fdao= new FornecedorDAO();
		
		try {
			fdao.excluir(f1);
			System.out.println("Deletado do DB com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao Deletar do DB!");
			e.printStackTrace();
		}
	}
}
