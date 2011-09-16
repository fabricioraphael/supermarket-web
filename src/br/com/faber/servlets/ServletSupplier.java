package br.com.faber.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faber.entity.Supplier;
import br.com.faber.service.SupplierService;

/**
 * Servlet implementation class ServletSupplier
 */
public class ServletSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SupplierService supplierService = new SupplierService();
		String nameSupplier, nameComplete, address, email, namePComplete, namePAbbreviated, quantity, unit = "Uni", valueCost, valueCharged;
		String msg ="", jspDestino = "registerproduct.jsp";
		Integer phone1, phone2;
		Vector<Supplier> vSupplier = new Vector<Supplier>();

		nameSupplier = request.getParameter("nameSupplier");
		namePComplete = request.getParameter("nameProductComplete");
		namePAbbreviated = request.getParameter("nameProductAbbreviated");
		unit = request.getParameter("unit");
		quantity = request.getParameter("quantity");
		valueCost = request.getParameter("valueCost");
		valueCharged = request.getParameter("valueCharged");

		if( !(nameSupplier.trim().equalsIgnoreCase("") || nameSupplier == null ) ){
			vSupplier = supplierService.doSearchSupplierByName("NameComplete", nameSupplier);
		
			nameComplete = vSupplier.get(0).getNameComplete();
			address = vSupplier.get(0).getAddress();
			phone1 = vSupplier.get(0).getPhone1();
			phone2 = vSupplier.get(0).getPhone2();
			email = vSupplier.get(0).getEmail();
			
			request.setAttribute("namePComplete", namePComplete);
			request.setAttribute("namePAbbreviated", namePAbbreviated);
			request.setAttribute("quantity", quantity);
			request.setAttribute("unit", unit);
			request.setAttribute("valueCost", valueCost);
			request.setAttribute("valueCharged", valueCharged);
			request.setAttribute("msg", msg);
			request.setAttribute("nameComplete", nameComplete);
			request.setAttribute("address", address);
			request.setAttribute("phone1", phone1);
			request.setAttribute("phone2", phone2);
			request.setAttribute("email", email);
		}else{
			msg = ("Campos * obrigatorio!");
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(jspDestino).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("\nENTROU AQUI!!!\n");
		SupplierService serviceS = new SupplierService();
		String nameComplete, nameAbbreviated, address, cnpj, phone1, phone2, email, obs;
		String jspDestino = "registersupplier.jsp", msg = " ";
		
		nameComplete = request.getParameter("nameComplete");
		nameAbbreviated = request.getParameter("nameAbbreviated");
		address = request.getParameter("address");
		cnpj = request.getParameter("CNPJ");
		phone1 = request.getParameter("phoneOne");
		phone2 = request.getParameter("phoneTwo");
		email = request.getParameter("email");
		obs = request.getParameter("obs");
		
		if( !( nameComplete.equalsIgnoreCase("") || nameAbbreviated.equalsIgnoreCase("") || address.equalsIgnoreCase("") || phone1.equalsIgnoreCase("") ||
				phone2.equalsIgnoreCase("") || email.equalsIgnoreCase("") ) ){
			if(serviceS.isValidatesPhone(phone1) && serviceS.isValidatesPhone(phone2)){
				if(serviceS.isValidatesCNPJ(cnpj)){
					serviceS.saveSupplier(nameComplete, nameAbbreviated, cnpj, address, phone1, phone2, email, obs);
					msg = ("Cadastrado com sucesso!");
				}else{msg = ("CNPJ Invalido!");}
			}else{msg = ("Telefone Invalido!");}
		}else{msg = ("Campos * obrigatorio!");}
		System.out.println(msg);
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(jspDestino).forward(request, response);
	}
}