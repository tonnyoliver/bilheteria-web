package br.com.cepep.bilheteria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class OlaMundoBean {
	
	private String mensagem = "Olá, qual seu nome?";
	private String nome;
	private String saudacao;
	private String msg = "JSF - Java Server Faces";
	
	public String getMsg() {
		return msg;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void ola(){
		saudacao = "";
		System.out.println("Chamou o metódo olá!");
		saudacao = "Olá "+ nome + ", seja bem vindo!";
	}
	
	public String getSaudacao() {
		return saudacao;
	}
	
}
