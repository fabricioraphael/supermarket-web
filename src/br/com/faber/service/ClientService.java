package br.com.faber.service;

import java.util.Vector;

import br.com.faber.dao.ClienteDao;
import br.com.faber.entity.Client;


public class ClientService {

	public void saveClient(String nome, String nascimento, String endereco, String telefone, String celular, String email, String descricao){
		ClienteDao clienteDao = new ClienteDao();
		Client cliente = new Client();
		Integer intTelefone = Integer.parseInt(telefone);
		Integer intCelular = Integer.parseInt(celular);

		cliente.setName(nome);
		cliente.setBirth(nascimento);
		cliente.setAddress(endereco);
		cliente.setPhone(intTelefone);
		cliente.setCelular(intCelular);
		cliente.setEmail(email);
		cliente.setDescricao(descricao);
		clienteDao.insereUsuario(cliente);
	}

	@SuppressWarnings("unchecked")
	public Vector<Client> PesquisaTodosClientes(){
		ClienteDao clienteDao = new ClienteDao();
		Vector<Client> valor = new Vector<Client>();
		valor = clienteDao.consultaTodosClientes();
		return valor;
	}
	public Vector<Client> PesquisaUmCliente(String stgColuna, String stgValor){
		ClienteDao clienteDao = new ClienteDao();
		Vector<Client> valores = new Vector<Client>();
		valores = clienteDao.consultaUmCliente(stgColuna, stgValor);
		return valores;
	}
	public Vector<Client> PesquisaUmCliente(int id){
		ClienteDao clienteDao = new ClienteDao();
		Vector<Client> cliente = new Vector<Client>();
		cliente = clienteDao.consultaUmCliente(id);
		return cliente;
	}


	/*
	 * Metodos
	 */
	public boolean isValidatesBirth(String birth){
		String nascimento[];
		Integer dia, mes, ano;
		try {
			nascimento = birth.split("\\/");
			dia = Integer.parseInt(nascimento[0]);
			mes = Integer.parseInt(nascimento[1]);
			ano = Integer.parseInt(nascimento[2]);
			if ((dia <= 0) || (dia > 31) || (nascimento[0].length() <= 0 || nascimento[0].length() > 2 )){
				return false;
			}if((mes <= 0) || (mes >12) || (nascimento[1].length() <= 0 || nascimento[1].length() > 2 )){
				return false;
			}if(((ano <= 0) || (ano > 2010)) ||  (nascimento[2].length() != 4 && nascimento[2].length() != 2)){
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isValidatesPhone(String telefone){
		try {
			if((telefone.length() < 8 || telefone.length() > 8)){
				return false;
			}else{
				Integer intTelefone = Integer.parseInt(telefone);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
