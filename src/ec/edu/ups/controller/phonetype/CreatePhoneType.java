package ec.edu.ups.controller.phonetype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PhoneTypeDAO;
import ec.edu.ups.model.PhoneType;;

/**
 * Servlet implementation class CreatePhoneType
 */
@WebServlet("/CreatePhoneType")
public class CreatePhoneType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PhoneTypeDAO phoneTypeDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePhoneType() {
        super();
        phoneTypeDAO = DAOFactory.getFactory().getPhoneTypeDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String msg = "";
			
			PhoneType celular = new PhoneType("Celular");
			PhoneType convencional = new PhoneType("Convencional");
			
			if (phoneTypeDAO.find(null, 0, 0).size() == 0) {
				phoneTypeDAO.create(celular);
				phoneTypeDAO.create(convencional);
				msg = "Se han creado los Tipos de Telefono";
			} else {
				msg = "Los Tipos de Telefono ya han sido creados";				
			}
			
			response.getWriter().append(msg);
		} catch (Exception e) {
			String msg = "No se han podido crear los Tipos de Telefono";
			response.getWriter().append(msg);
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
