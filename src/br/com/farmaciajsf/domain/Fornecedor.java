package br.com.farmaciajsf.domain;

public class Fornecedor {
	
	
	private Long id;
	private String descricao;
	

	public Long getId() {
		return id;
	}
	public void setId(long i) {
		this.id = i;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
