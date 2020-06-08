package br.com.farmaciajsf.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmaciajsf.DAO.FornecedorDAO;
import br.com.farmaciajsf.domain.Fornecedor;

@ManagedBean(name = "MBFornecedor")
@ViewScoped()
public class FornecedorBean {
	private Fornecedor fornecedor;
	private ListDataModel<Fornecedor> fornecedores;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ListDataModel<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(ListDataModel<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedorDAO fdao = new FornecedorDAO();
			ArrayList<Fornecedor> fornecedores = fdao.findAll();
			this.fornecedores = new ListDataModel<Fornecedor>(fornecedores);
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
