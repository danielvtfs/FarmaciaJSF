package br.com.farmaciajsf.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmaciajsf.DAO.FornecedorDAO;
import br.com.farmaciajsf.DAO.ProdutoDAO;
import br.com.farmaciajsf.domain.Fornecedor;
import br.com.farmaciajsf.domain.Produto;
import br.com.farmaciajsf.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped()
public class ProdutoBean {

	private Produto produto;
	private ArrayList<Produto> produtos;
	private ArrayList<Produto> produtosFiltrados;
	private ArrayList<Fornecedor> comboFornecedores;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public ArrayList<Fornecedor> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedor> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			this.produtos = pdao.findAll();

		} catch (SQLException e) {
			JSFUtil.mensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo() {

		try {
			produto = new Produto();
			FornecedorDAO fdao = new FornecedorDAO();
			comboFornecedores = fdao.findAll();
		} catch (SQLException e) {
			JSFUtil.mensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			fdao.salvar(produto);
			
			this.produtos = fdao.findAll();
			
			JSFUtil.mensagemSucesso("Produto gravado com sucesso.");
		} catch (SQLException e) {
			JSFUtil.mensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			fdao.excluir(produto);
			
			this.produtos = fdao.findAll();
			
			JSFUtil.mensagemSucesso("Produto excluído com sucesso.");
		} catch (SQLException e) {
			JSFUtil.mensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararEditar() {

		try {
			produto = new Produto();
			FornecedorDAO fdao = new FornecedorDAO();
			comboFornecedores = fdao.findAll();
		} catch (SQLException e) {
			JSFUtil.mensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			ProdutoDAO fdao = new ProdutoDAO();
			fdao.editar(produto);
			
			this.produtos = fdao.findAll();
			
			JSFUtil.mensagemSucesso("Produto Editado com sucesso");
			
		} catch (Exception e) {
			JSFUtil.mensagemErro("e.getMessage()");
		}
	}
}
