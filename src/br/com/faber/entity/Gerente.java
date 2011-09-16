package br.com.faber.entity;

public class Gerente extends Person {

	public Gerente(){
		super();
	}
	public Gerente(String nome,int id){
		this.setName(nome);
		this.setId(id);
	}
}
