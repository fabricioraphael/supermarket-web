package br.com.faber.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.com.faber.entity.Client;




public class ClienteDao {

	public ClienteDao(){
		Banco banco = new Banco();
	}

	public void insereUsuario (Client usu){
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableClient(Name, Birth, address, Phone, Celular,  Email, Description)" +
			" VALUES ('"+ usu.getName() + "','"+ usu.getBirth() + "','"+ usu.getAddress() + "','"+ usu.getPhone() + "','" + usu.getCelular() + "','"+ usu.getEmail() + "','"+ usu.getDescricao() + "') ";
			stmt.executeUpdate(comandoSQL );

			stmt.close();
			//			con.commit();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}

	}
	//	Pesquisar UM cliente Expecifico
	public Vector<Client> consultaUmCliente(int id){
		Vector<Client> listaCliente = new Vector<Client>();
		Client cliente = new Client();
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableClient where id = "+id+" ;";
			ResultSet res = stat.executeQuery(query);
			if(res.next()) {
				cliente = new Client(res.getInt("ID"), res.getString("Name"), res.getString("Birth") ,res.getString("Address"), res.getInt("Phone"),res.getString("Email"), res.getString("Description"));
				listaCliente.add(cliente);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaCliente;
	}

	//  Pesquisa UM Por NOME ou ENDERECO 
	public Vector<Client> consultaUmCliente(String stgColuna, String stgValor){
		Vector listaClientes = new Vector();
		Client usu = null;
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableClient where "+ stgColuna +" like '%"+stgValor+"%' ;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				usu = new Client(res.getInt("ID"), res.getString("Name"), res.getString("Birth") ,res.getString("Address"), res.getInt("Phone"),res.getString("Email"), res.getString("Description"));
				listaClientes.add(usu);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaClientes;
	}
	//  Pesquisa todos os Clientes
	public Vector consultaTodosClientes(){
		Vector listaClientes = new Vector();
		Client usu = null;
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tableClient" ;
			ResultSet res = stmt.executeQuery(query);
			while (res.next() ){
				usu = new Client(res.getInt("ID"), res.getString("Name"), res.getString("Birth") ,res.getString("Address"), res.getInt("Phone"),res.getString("Email"), res.getString("Description"));
				listaClientes.add(usu);
			}
			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao consultar no BD. erro = "+ e.getMessage()); 
		}
		return listaClientes; 
	}

	public int deleteUsuario(int id)
	{
		try{
			Connection con = Banco.getConexao();
			Statement stat;
			stat = con.createStatement();
			stat.executeUpdate("Delete FROM tableClient WHERE id = "+id);
			stat.close();
			return(0);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Problemas ao deletar no BD. erro = "+ e.getMessage());
			return(1);
		}
	}


}
