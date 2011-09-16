package br.com.faber.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.faber.dao.LoginDao;
import br.com.faber.entity.Log;


public class LoginService {

	public LoginService() {
	}
	// Metodo para armazenar (criar logins) no Banco de Dados.
	public void armazenaUsuario(String user, String password, String usuario, String cargo, Integer type) throws Exception{
		Log userLog = new Log();
		LoginDao loginDao = new LoginDao();

		userLog.setUser(user);
		userLog.setPassword(password);
		userLog.setUsuario(usuario);
		userLog.setCargo(cargo);
		userLog.setType(type);
		loginDao.insereLog(userLog);
	}
	// Metodo para consulta/busca um Login no Banco de Dados.
	public Log pesquisaUmUsuario(int id) throws Exception{
		LoginDao loginDao = new LoginDao();
		Log log = new Log();

		log = loginDao.consultaUmLog(id);

		if (log == null){
			System.out.println("pesquisaUmUsuario null!!!");
//			throw new Exception("Usuario ou senha invalidos! pesquisa um");
			return null;
		}
		return log;
	}


	// Função para criar hash do valor informado. 
	public static String doCriptografa(String valor){
		String sen = "";  
		StringBuffer stg = new StringBuffer();
		try {
			stg.append(valor);
			stg.reverse();
			sen = stg.toString();
		} catch (Exception e) {
			System.out.println("DEU MERDA! n rolo de separa as paradas. =/");
		}
		MessageDigest md = null;  
		try {  
			md = MessageDigest.getInstance("MD5");  
		} catch (NoSuchAlgorithmException e) {  
			e.printStackTrace();  
		}  
		BigInteger hash = new BigInteger(1, md.digest(sen.getBytes()));  
		sen = hash.toString(16);   
		System.out.println("Valor Recebido: " + valor + "     Valor reverse(); " + stg + " \nValor criptografado: " + sen + "\n");
		return sen;  
	}

	public Integer doSeparaID(String user){
		String idSeparado[];
		Integer id = 0;
		//		System.out.println("\n\nLogin[0]: " + idSeparado[0] + "        Login[1]: " + idSeparado[1] + " \nID: " + id + " \n");
		try {
			idSeparado = user.split("\\.");
			id = Integer.parseInt(idSeparado[1]);
		} catch (Exception e) {
			throw new IllegalArgumentException("Usuario informado inválido! throw \n");
		} 
		return id;
	}
	
	@SuppressWarnings("static-access")
	public Log doPickLog(String usuario, String senha) throws Exception{
		Log log = new Log();
		
		String user, password;
		Integer id;
		
		user = this.doCriptografa(usuario);
		password = this.doCriptografa(senha);
		id = this.doSeparaID(usuario);
		log = this.pesquisaUmUsuario(id);
		
		return log;
	}

	/*
	 * 
	 * User: fabricio.001
	 * Password: asdasd
	 * 
	 */

	@SuppressWarnings("static-access")
	public boolean isValidaLoggin(String usuario, String senha) throws Exception{
		Log log = new Log();
		String user = "";
		String password = "";
		
		user = this.doCriptografa(usuario);
		password = this.doCriptografa(senha);
		
		log = this.doPickLog(usuario, senha);
//		System.out.println("\ngetUser: " + log.getUser() + " User: " + user + "  getPassword: " + log.getPassword() + " senha: " + password + "\n");
		if(log.getUser().trim().equalsIgnoreCase(user) && log.getPassword().trim().equalsIgnoreCase(password) && log != null){
			return true;
		}else
			return false;
	}

}//fim//







