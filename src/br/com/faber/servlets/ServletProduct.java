package br.com.faber.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faber.service.ProductService;

/**
 * Servlet implementation class ServletProduct
 */
public class ServletProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			
//			System.out.println(request.getMethod());
//			String name;
//			
//			name = request.getParameter("nameSupplier");
//			
//			String vCost = request.getParameter("valueCost");
//			String vCharged = request.getParameter("valueCharged");
//			
//			System.out.println("Name: " + name);
			this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameComplete, nameAbbreviated, unit, quantity, valueCost, valueCharged, nameSupplier, addressSupplier, phoneOneSupplier, phoneTwoSupplier, emailSupplier, obsProduct;
		ProductService product = new ProductService();
		String msg="";
		String jspDestino = "registerproduct.jsp";
		Integer idSupplier = 1;
		
		nameComplete = request.getParameter("nameProductComplete");
		nameAbbreviated = request.getParameter("nameProductAbbreviated");
		unit = request.getParameter("unit");
		quantity = request.getParameter("quantity");
		valueCost = request.getParameter("valueCost");
		valueCharged = request.getParameter("valueCharged");
		nameSupplier = request.getParameter("nameSupplier");
		
		addressSupplier = request.getParameter("addressSupplier");
		phoneOneSupplier = request.getParameter("phoneOneSupplier");
		phoneTwoSupplier = request.getParameter("phoneTwoSupplier");
		emailSupplier = request.getParameter("emailSupplier");
		
		obsProduct = request.getParameter("description");

		
		System.out.println("Values: " + nameComplete + nameAbbreviated + unit + quantity + valueCost + valueCharged + nameSupplier + addressSupplier + phoneOneSupplier + phoneTwoSupplier + emailSupplier + obsProduct);
		
		
		if(!( (nameComplete.equalsIgnoreCase("")) || (nameAbbreviated.equalsIgnoreCase("")) || (unit.equalsIgnoreCase("Null")) || (quantity.equalsIgnoreCase("")) ||
			(valueCost.equalsIgnoreCase("")) || (valueCharged.equalsIgnoreCase("")) || (nameSupplier.equalsIgnoreCase("")) || (addressSupplier.equalsIgnoreCase("")) || 
			(phoneOneSupplier.equalsIgnoreCase("")) || (phoneTwoSupplier.equalsIgnoreCase("")) || (emailSupplier.equalsIgnoreCase("")) )){
			if( !( (product.isValidateCost(valueCost)) && (product.isValidateCost(valueCharged)) ) ){
				msg = "Valores Inválidos!!!";
			}else{
				product.saveProduct(nameComplete, nameAbbreviated, unit, quantity, valueCost, valueCharged, idSupplier, nameSupplier, obsProduct);
				msg = "Cadastrados com sucesso.";
			}
		}else{    //principal//
			msg = "Campos * Obrigatorios!!!";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(jspDestino).forward(request, response);
	}
}
