package br.com.faber.entity;

public class Client extends Person{
	
	public String email;
	public String descricao;

	public Client(){
		super();
	}
	public Client(int id, String nome, String nascimento, String endereco, Integer telefone, String email, String descricao){
		this.setId(id);
		this.setName(nome);
		this.setBirth(nascimento);
		this.setAddress(endereco);
		this.setPhone(telefone);
		this.setEmail(email);
		this.setDescricao(descricao);
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
