package br.com.faber.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faber.service.ClientService;

/**
 */
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  nameClient, birthClient, addressClient, phoneClient, celularClient, emailClient, obsClient; 
		String msg = "";
		String jspDestino = "registerclient.jsp";
		ClientService client = new ClientService();
		
		nameClient = request.getParameter("nameClient");
		birthClient = request.getParameter("birthClient");
		addressClient = request.getParameter("addressClient");
		phoneClient = request.getParameter("phoneClient");
		celularClient = request.getParameter("celularClient");
		emailClient = request.getParameter("emailClient");
		obsClient = request.getParameter("obsClient");
		
		if(!nameClient.equalsIgnoreCase("") && !birthClient.equalsIgnoreCase("")){
			if(client.isValidatesBirth(birthClient)){
				if((client.isValidatesPhone(phoneClient) || phoneClient.equalsIgnoreCase("")) && (client.isValidatesPhone(celularClient) || celularClient.equalsIgnoreCase(""))){
					client.saveClient(nameClient, birthClient, addressClient, phoneClient, celularClient, emailClient, obsClient);
					msg = " Cliente cadastrado com sucesso! ";
				}else{
					msg = " Telefone Inválido!";
				}
			
			}else{
				msg = " Nascimento inválido! formato dd/mm/aaaa (ex. 01/01/2010)";
			}
		}else{
			msg = " * Campos Obrigatório!";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(jspDestino).forward(request, response);
	}

}
