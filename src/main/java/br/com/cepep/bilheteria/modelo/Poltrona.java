package br.com.cepep.bilheteria.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Poltrona {
	@Id
	@GeneratedValue
	private int id;
	private char fila;
	private char coluna;
	@Enumerated(EnumType.STRING)
	private Status status;
	private boolean meia;
	@ManyToOne
	private Espetaculo espetaculo;
	@ManyToOne
	private Usuario modificadoPor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getFila() {
		return fila;
	}

	public void setFila(char fila) {
		this.fila = fila;
	}

	public char getColuna() {
		return coluna;
	}

	public void setColuna(char coluna) {
		this.coluna = coluna;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isMeia() {
		return meia;
	}

	public void setMeia(boolean meia) {
		this.meia = meia;
	}

	public Espetaculo getEspetaculo() {
		return espetaculo;
	}

	public void setEspetaculo(Espetaculo espetaculo) {
		this.espetaculo = espetaculo;
	}

	public Usuario getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(Usuario modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

}
