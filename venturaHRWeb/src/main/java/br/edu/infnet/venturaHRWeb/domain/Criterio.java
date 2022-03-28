package br.edu.infnet.venturaHRWeb.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Criterio {
	
	private Integer id;
	private String descricao;
	private int perfil;
	private int peso;
	@JsonIgnore
	private Vaga vaga;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
}
