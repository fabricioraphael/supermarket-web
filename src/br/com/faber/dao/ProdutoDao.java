package br.com.faber.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.com.faber.entity.Product;

public class ProdutoDao {
	public ProdutoDao(){
		Banco banco = new Banco();
	}
	public void insereProduto (Product produto){
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableProduct(NameComplete, NameAbbreviated, Unit, Quantity, ValueCost, ValueCharged, IDSupplier, NameSupplier, DescriptionProduct)" +
			" VALUES ('"+ produto.getNameComplete() + "','"+ produto.getNameAbbreviated() + "','"+ produto.getUnit() + "','"+ produto.getQuantity() + "','"+ produto.getValueCost() + "','"+ produto.getValueCharged() + "','" + produto.getIdSupplier() + "','"+ produto.getNameSupplier() + "','"+ produto.getDescription() + "') ";
			stmt.executeUpdate(comandoSQL );

			stmt.close();
			//			con.commit();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}
	}


	//	Pesquisar UM cliente Expecifico
	public Vector<Product> consultaUmProduto(int id){
		Vector<Product> listaProduto = new Vector<Product>();
		Product produto = new Product();
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableProduct where id = "+id+" ;";
			ResultSet res = stat.executeQuery(query);
			if(res.next()) {
				produto = new Product(res.getInt("ID"), res.getString("NameComplete"), res.getString("NameAbbrevited"),res.getString("Unit"), res.getInt("Quantity") , res.getDouble("ValueCost"), res.getDouble("ValueCharged"), res.getInt("IDSupplier"), res.getString("NameSupplier"), res.getString("DescricaoProduto"));
				listaProduto.add(produto);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaProduto;
	}


	//  Pesquisa UM Por NOME ou ENDERECO 
	public Vector<Product> consultaUmProduto(String stgColuna, String stgValor){
		Vector listaProduto = new Vector();
		Product produto = null;
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableProduct where "+ stgColuna +" like '%"+stgValor+"%' ;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				produto = new Product(res.getInt("ID"), res.getString("NameComplete"), res.getString("NameAbbrevited"),res.getString("Unit"), res.getInt("Quantity") , res.getDouble("ValueCost"), res.getDouble("ValueCharged"), res.getInt("IDSupplier"), res.getString("NameSupplier"), res.getString("DescricaoProduto"));
				listaProduto.add(produto);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaProduto;
	}

	//  Pesquisa todos os Clientes
	public Vector consultaTodosProduto(){
		Vector listaProduto = new Vector();
		Product produto = null;
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tableProduct" ;
			ResultSet res = stmt.executeQuery(query);
			while (res.next() ){
				produto = new Product(res.getInt("ID"), res.getString("NameComplete"), res.getString("NameAbbrevited"),res.getString("Unit"), res.getInt("Quantity") , res.getDouble("ValueCost"), res.getDouble("ValueCharged"), res.getInt("IDSupplier"), res.getString("NameSupplier"), res.getString("DescricaoProduto"));
				listaProduto.add(produto);
			}
			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao consultar no BD. erro = "+ e.getMessage()); 
		}
		return listaProduto; 
	}


	public int deleteProdutos(int id)
	{
		try{
			Connection con = Banco.getConexao();
			Statement stat;
			stat = con.createStatement();
			stat.executeUpdate("Delete FROM tableCliente WHERE id = "+id);
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
