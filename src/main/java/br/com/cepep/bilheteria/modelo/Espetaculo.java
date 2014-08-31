package br.com.cepep.bilheteria.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Espetaculo {
	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	private String classificacao;
	private String genero;
	private double preco;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "espetaculo",
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Poltrona> poltronas = new ArrayList<Poltrona>();
	@ManyToOne
	private Usuario criadoPor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Poltrona> getPoltronas() {
		return poltronas;
	}

	public void setPoltronas(List<Poltrona> poltronas) {
		this.poltronas = poltronas;
	}

	public Usuario getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Usuario criadoPor) {
		this.criadoPor = criadoPor;
	}

}
