package br.com.faber.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faber.entity.Log;
import br.com.faber.service.LoginService;


/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static String nome = "";
	private static String perfil = "";
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user, password;
		String msg = "";
		String jspDestino = "index.jsp";
		LoginService loginS = new LoginService();
		Log log = new Log();
		boolean valida;

		user = request.getParameter("login");
		password = request.getParameter("password");
		
		if( !( user.equalsIgnoreCase("") || password.equalsIgnoreCase("") ) ){
			try {
				valida = loginS.isValidaLoggin(user, password);
				if(valida){
					
					jspDestino = "home.jsp";
					log = loginS.doPickLog(user, password);
					nome = log.getUsuario();
					perfil = log.getCargo();
				}else{
					msg = ("Usuário ou senha inválidos!");
					jspDestino = "index.jsp";
				}
	
			} catch (Exception e) {
				//			e.printStackTrace();
				msg = ("Usuário ou senha inválidos!");
				jspDestino = "index.jsp";
			}	
		}else{
			msg = ("* Campos Obrigatorio!");
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("nome", nome);
		request.setAttribute("perfil", perfil);
		request.getRequestDispatcher(jspDestino).forward(request, response);

	}
}
