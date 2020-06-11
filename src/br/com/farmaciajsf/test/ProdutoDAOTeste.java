package br.com.farmaciajsf.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmaciajsf.DAO.ProdutoDAO;
import br.com.farmaciajsf.domain.Fornecedor;
import br.com.farmaciajsf.domain.Produto;

public class ProdutoDAOTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException {
		Produto produto = new Produto();
		produto.setDescricao("hoje");
		produto.setQuantidade(5);
		produto.setPreco(120.00);
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(23);
		produto.setFornecedor(fornecedor);

		ProdutoDAO pdao = new ProdutoDAO();

		try {
			pdao.salvar(produto);
			System.out.println("Gravado no DB com Sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao gravar no DB!");
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void findByDescricao() throws SQLException {
		ProdutoDAO pdao = new ProdutoDAO();
		ArrayList<Produto> produtos = pdao.findAll();
		
		for (Produto produto : produtos) {
			System.out.println(produto);
		}

	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException{
		Produto p = new Produto();
		p.setId(5L);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.excluir(p);
	}
	
	@Test
	public void editar() throws SQLException{
		Produto p = new Produto();
		p.setId(3L);
		p.setDescricao("Descricao teste");
		p.setQuantidade(20);
		p.setPreco(500);
		
		Fornecedor f = new Fornecedor();
		f.setId(22);
		p.setFornecedor(f);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.editar(p);
	}
}
