package br.com.faber.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faber.entity.Supplier;
import br.com.faber.service.SupplierService;

/**
 * Servlet implementation class ServletSearchRegister
 */
public class ServletSearchRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSearchRegister() {
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
	/*SelectList values: client = 1, supplier = 2, employee = 3  --  Opt values: all, id, name, address*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspDestino ="searchregister.jsp", msg="";
		String opt, id, name, address;
		Integer selectList;
		selectList = 1; //Integer.parseInt(request.getParameter("selectList")); 
		opt = request.getParameter("opt");
		id = request.getParameter("idTxt");
		name = request.getParameter("nameTxt");
		address = request.getParameter("addressTxt");
//		System.out.println("SelectList: " + selectList + " opt: " + opt);
		
		if(selectList == 2){
			request.setAttribute("selectList", selectList);	
		}
		request.setAttribute("msg", msg);
		
		SupplierService service = new SupplierService();
		List<Supplier> supliers = service.doSearchAllSupplier();
		request.setAttribute("supliers", supliers);
		
		request.getRequestDispatcher("viewsupplier.jsp").forward(request, response);

	}

}
