package br.com.faber.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.com.faber.entity.Supplier;

public class SupplierDao {

	public SupplierDao(){
		Banco banco = new Banco();
	}
	public void insereFornecedor(Supplier supplier){
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableSupplier(NameComplete, NameAbbreviated, CNPJ, Address, Phone1, Phone2, Email, Description)" +
			" VALUES ('"+ supplier.getNameComplete() + "','"+ supplier.getNameAbbreviated() + "','"+supplier.getCNPJ()+"','"+ supplier.getAddress()+ "','"+ supplier.getPhone1() + "','"+ supplier.getPhone2() + "','"+ supplier.getEmail() + "','"+ supplier.getDescription() + "') ";
			stmt.executeUpdate(comandoSQL );

			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}

	}
	//	Pesquisar UM cliente Expecifico
	public Vector<Supplier> consultaUmFornecedor(int id){
		Vector<Supplier> listaFornecedor= new Vector<Supplier>();
		Supplier fornecedor = new Supplier();
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableSupplier where id = "+id+" ;";
			ResultSet res = stat.executeQuery(query);
			if(res.next()) {
				fornecedor = new Supplier (res.getInt("ID"), res.getString("NameComplete"), res.getString("NameAbbreviated"), res.getString("CNPJ") ,res.getString("Address"), res.getInt("Phone1"), res.getInt("Phone2"),res.getString("Email"), res.getString("Description"));
				listaFornecedor.add(fornecedor);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaFornecedor;
	}

	//  Pesquisa UM Por NOME ou ENDERECO 
	public Vector<Supplier> doConsultSupplierByName(String stgColuna, String stgValor){
		Vector listaFornecedor = new Vector();
		Supplier fornecedor = null;
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableSupplier where "+ stgColuna +" like '%"+stgValor+"%' ;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				fornecedor = new Supplier(res.getInt("ID"), res.getString("NameComplete"), res.getString("NameAbbreviated"), res.getString("CNPJ") ,res.getString("Address"), res.getInt("Phone1"), res.getInt("Phone2"),res.getString("Email"), res.getString("Description"));
				listaFornecedor.add(fornecedor);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaFornecedor;
	}
	
//  Pesquisa todos os Clientes
	public Vector consultaTodosFornecedores(){
		Vector listaFornecedor = new Vector();
		Supplier fornecedor = null;
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tableSupplier" ;
			ResultSet res = stmt.executeQuery(query);
			while (res.next() ){
				fornecedor = new Supplier(res.getInt("ID"), res.getString("NameComplete"), res.getString("NameAbbreviated"), res.getString("CNPJ") ,res.getString("Address"), res.getInt("Phone1"), res.getInt("Phone2"),res.getString("Email"), res.getString("Description"));
				listaFornecedor.add(fornecedor);
			}
			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao consultar no BD. erro = "+ e.getMessage()); 
		}
		return listaFornecedor; 
	}

	public int deleteUsuario(int id)
	{
		try{
			Connection con = Banco.getConexao();
			Statement stat;
			stat = con.createStatement();
			stat.executeUpdate("Delete FROM tableSupplier WHERE id = "+id);
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
