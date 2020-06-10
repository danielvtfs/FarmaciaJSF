package br.com.farmaciajsf.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmaciajsf.DAO.FornecedorDAO;
import br.com.farmaciajsf.domain.Fornecedor;
import br.com.farmaciajsf.util.JSFUtil;

@ManagedBean(name = "MBFornecedor")
@ViewScoped()
public class FornecedorBean {
	private Fornecedor fornecedor;
	private ArrayList<Fornecedor> fornecedores;
	private ArrayList<Fornecedor> fornecedoresFiltrados;
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedor> getFornecedoresFiltrados() {
		return fornecedoresFiltrados;
	}

	public void setFornecedoresFiltrados(ArrayList<Fornecedor> fornecedoresFiltrados) {
		this.fornecedoresFiltrados = fornecedoresFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedorDAO fdao = new FornecedorDAO();
			this.fornecedores = fdao.findAll();

		} catch (SQLException e) {
			JSFUtil.mensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo() {
		fornecedor = new Fornecedor();
	}
	
	public void novo() {
		
		try {
			FornecedorDAO fdao = new FornecedorDAO();
			fdao.salvar(fornecedor);
			
			this.fornecedores = fdao.findAll();
			
			JSFUtil.mensagemSucesso("Fornecedor gravado com sucesso.");
		} catch (SQLException e) {
			JSFUtil.mensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	

	
	public void excluir() {
		try {
			FornecedorDAO fdao = new FornecedorDAO();
			fdao.excluir(fornecedor);
			
			this.fornecedores = fdao.findAll();
			
			JSFUtil.mensagemSucesso("Fornecedor excluído com sucesso.");
		} catch (SQLException e) {
			JSFUtil.mensagemErro("Não é possível excluir um fornecedor que tenha um produto associado!");
			e.printStackTrace();
		}
	}
	
	
	public void editar() {
		try {
			FornecedorDAO fdao = new FornecedorDAO();
			fdao.editar(fornecedor);
			
			this.fornecedores = fdao.findAll();
			
			JSFUtil.mensagemSucesso("Fornecedor Editado com sucesso");
			
		} catch (Exception e) {
			JSFUtil.mensagemErro("e.getMessage()");
		}
	}
}
