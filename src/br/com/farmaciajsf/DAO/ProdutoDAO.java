package br.com.farmaciajsf.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmaciajsf.domain.Fornecedor;
import br.com.farmaciajsf.domain.Produto;
import br.com.farmaciajsf.factory.ConexaoFactory;

public class ProdutoDAO {

	public void salvar(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produto ");
		sql.append("(descricao, quantidade, preco, fornecedor_id) ");
		sql.append("VALUES (?, ?, ?, ?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, produto.getDescricao());
		comando.setInt(2, produto.getQuantidade());
		comando.setDouble(3, produto.getPreco());
		comando.setLong(4, produto.getFornecedor().getId());
		
		comando.executeUpdate();
		
	}
	
	public ArrayList<Produto> findAll() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.id, p.descricao, p.quantidade, p.preco, f.id, f.descricao ");
		sql.append("FROM produto p ");
		sql.append("INNER JOIN fornecedor f ");
		sql.append("ON f.id = p.fornecedor_id ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while (resultado.next()) {
			Fornecedor f = new Fornecedor();
			f.setId(resultado.getLong("f.id"));
			f.setDescricao(resultado.getString("f.descricao"));
			
			Produto p = new Produto();
			p.setId(resultado.getLong("p.id"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setQuantidade(resultado.getInt("p.quantidade"));
			p.setPreco(resultado.getDouble("p.preco"));
			p.setFornecedor(f);

			lista.add(p);
		}

		return lista;
	}
	
	public void excluir(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produto ");
		sql.append("WHERE id = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, produto.getId());
		comando.executeUpdate();
	}
	
	public void editar(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produto ");
		sql.append("SET descricao = ?, quantidade = ?, preco = ?, fornecedor_id = ? ");
		sql.append("WHERE id = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, produto.getDescricao());
		comando.setInt(2, produto.getQuantidade());
		comando.setDouble(3, produto.getPreco());
		comando.setLong(4, produto.getFornecedor().getId());
		comando.setLong(5, produto.getId());
		comando.executeUpdate();
	}
	
}
