package br.com.faber.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Banco {
	// Access
	private static String DRIVER_BD = "com.mysql.jdbc.Driver";
	private static String URL_BD = "jdbc:mysql://localhost:3306/DataBaseSGW";
	private static String usuario = "root";
	private static String senha = "";

	private static Connection con;

	public Banco(){
		try{
			Class.forName(DRIVER_BD);
		} catch (ClassNotFoundException e){
			System.out.println("Problemas ao carregar o driver");
		}
	}

	public static Connection getConexao(){
		ArrayList<String> query = new ArrayList<String>(createTables());
		try {
			//			senha = JOptionPane.showInputDialog("Senha:");	
			
			con = DriverManager.getConnection(URL_BD, usuario, senha);
			System.out.println("Conected!");

			try {
				Statement st = con.createStatement();
				st.executeUpdate("CREATE DATABASE if not exists DataBaseSGW");

				try {

					st.executeUpdate("use DataBaseSGW");
					//Cria as tabelas
					for(int i=0; i < query.size(); i++){
						st.executeUpdate(query.get(i));
//						System.out.println("passou aqui no metodo de criar tablelas\n" + i);
//						System.out.println("\n Table: " + i + "--> " + query.get(i) + "\n");
					}

				} catch (Exception e) {
					System.out.println("Err ao tentar criar a tabela." + e.getMessage());
				}

			} catch (SQLException e) {
				System.out.println("Err ao criar o banco de dados." + e.getMessage());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Err ao abrir conexao com o BD = " + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
	public void fecharConexao(Connection con){
		try {
			con.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Err ao fechar a conexao" + e.getMessage());
		}
	}

	public static ArrayList<String> createTables(){
		ArrayList<String> query = new ArrayList<String>();
		// 0 - Cria talbe Cliente
		query.add("CREATE table if not exists tableClient(" +
				" ID int(7) not null primary key auto_increment, " +
				" Name varchar(50) not null, Birth varchar(10) not null, " +
				" Address varchar(50), " +
				" Phone int(11), " +
				" Celular int(11), " +
		" Email varchar(50), Description varchar(150))");

		// 1 - Cria table Fornecedor CNPJ 99.999.999/9999-99
		query.add("CREATE TABLE if not exists tableSupplier(" +
				" ID int not null primary key auto_increment," +
				" NameComplete varchar(100) not null," +
				" NameAbbreviated varchar(50) not null," +
				" CNPJ varchar(18) not null," + 
				" Address varchar(50) not null," +
				" Phone1 int(11) not null," +
				" Phone2 int(11) not null," +
				" Email varchar(50) not null," +
		" Description varchar(150))");

		// 2 - Cria table Funcionário
		query.add("CREATE TABLE if not exists tableEmployee(" +
				" ID int not null primary key auto_increment, Name varchar(50) not null," +
				" Birth varchar(50) not null, Address varchar(50) not null," +
				" Phone int(11) not null, Celular int(11), Email varchar(50)," +
				" Post varchar(15) not null, DateAdmission varchar(11) not null," +
		" Salary double not null, Description varchar(150))");

		// 3 - Cria table Produto
		query.add("CREATE TABLE if not exists tableProduct(" +
				" ID int not null primary key auto_increment, NameComplete varchar(70) not null," +
				" NameAbbreviated varchar(50) not null, Unit varchar(5) not null," +
				" Quantity int not null, ValueCost double not null, ValueCharged double not null," +
		" IDSupplier int not null, NameSupplier varchar(100) not null, DescriptionProduct varchar(150))");
		// 4 - Cria table Login
		query.add("CREATE TABLE if not exists tableLogin(ID int not null primary key auto_increment," +
				" User varchar(32) not null, Password varchar(32) not null," +
		" NameUser varchar(50) not null, Post varchar(20) not null, Type int not null)");

		return query;
	}
}

















