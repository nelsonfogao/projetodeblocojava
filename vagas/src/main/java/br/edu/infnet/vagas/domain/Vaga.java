package br.edu.infnet.vagas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TVaga")
public class Vaga implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cargo;
	private String cidade;
	@Column(name = "forma_contratacao")
	private String formaContratacao;
	@Column(name = "id_usuario")
	private Integer idUsuario;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaga")
	private List <Criterio> criterioList;
	
	public Vaga() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getFormaContratacao() {
		return formaContratacao;
	}
	public void setFormaContratacao(String formaContratacao) {
		this.formaContratacao = formaContratacao;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public List<Criterio> getCriterioList() {
		return criterioList;
	}
	public void setCriterioList(List<Criterio> criterioList) {
		this.criterioList = criterioList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
