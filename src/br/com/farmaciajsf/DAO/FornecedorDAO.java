package br.com.farmaciajsf.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmaciajsf.domain.Fornecedor;
import br.com.farmaciajsf.factory.ConexaoFactory;

public class FornecedorDAO {

	public void salvar(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedor ");
		sql.append("(descricao) ");
		sql.append("VALUES (?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fornecedor.getDescricao());
		comando.executeUpdate();

	}

	public void excluir(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedor ");
		sql.append("WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fornecedor.getId());
		comando.executeUpdate();

	}

	public void editar(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedor ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fornecedor.getDescricao());
		comando.setLong(2, fornecedor.getId());
		comando.executeUpdate();

	}

	public Fornecedor findByid(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, descricao ");
		sql.append("FROM fornecedor ");
		sql.append("WHERE id = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, fornecedor.getId());

		ResultSet resultado = comando.executeQuery();
		Fornecedor retorno = null;

		if (resultado.next()) {
			retorno = new Fornecedor();
			retorno.setId(resultado.getLong("id"));
			retorno.setDescricao(resultado.getString("descricao"));
		}

		return retorno;
	}

	public ArrayList<Fornecedor> findByDescricao(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, descricao ");
		sql.append("FROM fornecedor ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY id ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + fornecedor.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		while (resultado.next()) {
			Fornecedor item = new Fornecedor();
			item.setId(resultado.getLong("id"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);
		}

		return lista;
	}

	public ArrayList<Fornecedor> findAll() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, descricao ");
		sql.append("FROM fornecedor ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		while (resultado.next()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(resultado.getLong("id"));
			fornecedor.setDescricao(resultado.getString("descricao"));

			lista.add(fornecedor);
		}

		return lista;
	}

	public static void main(String[] args) {

		Fornecedor f1 = new Fornecedor();
		f1.setDescricao("Oracle");
		Fornecedor f2 = new Fornecedor();
		f2.setDescricao("Apache");

		FornecedorDAO fdao = new FornecedorDAO();

		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Gravado no DB com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao gravar no DB!");
			e.printStackTrace();
		}

//		Fornecedor f1 = new Fornecedor();
//		f1.setId(2);
//
//		FornecedorDAO fdao = new FornecedorDAO();
//
//		try {
//			fdao.excluir(f1);
//			System.out.println("Deletado do DB com Sucesso!");
//		} catch (SQLException e) {
//			System.out.println("Erro ao Deletar do DB!");
//			e.printStackTrace();
//		}

//		Fornecedor f1 = new Fornecedor();
//		f1.setId(1);
//		f1.setDescricao("Descricao teste");
//
//		FornecedorDAO fdao = new FornecedorDAO();
//
//		try {
//			fdao.editar(f1);
//			System.out.println("Editado com Sucesso!");
//
//		} catch (SQLException e) {
//			System.out.println("Erro ao editar!");
//			e.printStackTrace();
//		}

//		Fornecedor f1 = new Fornecedor();
//		Fornecedor f2 = new Fornecedor();
//		f1.setId(1);
//		f2.setId(2);
//		
//
//		FornecedorDAO fdao = new FornecedorDAO();
//
//		try {
//			Fornecedor f3 = fdao.findByid(f1);
//			Fornecedor f4 = fdao.findByid(f2);
//			System.out.println("Resultado 1: " + f3);
//			System.out.println("Resultado 1: " + f4);
//		} catch (SQLException e) {
//			System.out.println("Erro ao buscar no DB!");
//			e.printStackTrace();
//		}

//		FornecedorDAO fdao = new FornecedorDAO();
//
//		try {
//
//			ArrayList<Fornecedor> lista = fdao.findAll();
//
//			for (Fornecedor fornecedor : lista) {
//				System.out.println("Resultado: " + fornecedor);
//			}
//
//		} catch (SQLException e) {
//			System.out.println("Erro ao buscar no DB!");
//			e.printStackTrace();
//		}

//		Fornecedor f1 = new Fornecedor();
//		f1.setDescricao("des");
//		
//		FornecedorDAO fdao = new FornecedorDAO();
//
//		try {
//
//			ArrayList<Fornecedor> lista = fdao.findByDescricao(f1);
//
//			for (Fornecedor fornecedor : lista) {
//				System.out.println("Resultado: " + fornecedor);
//			}
//
//		} catch (SQLException e) {
//			System.out.println("Erro ao buscar no DB!");
//			e.printStackTrace();
//		}
	}
}
