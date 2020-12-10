package ec.edu.ups.controller.phone;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PhoneDAO;
import ec.edu.ups.dao.PhoneTypeDAO;
import ec.edu.ups.dao.ProviderDAO;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.Phone;
import ec.edu.ups.model.PhoneType;
import ec.edu.ups.model.Provider;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class CreatePhone
 */
@WebServlet("/CreatePhone")
public class CreatePhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PhoneDAO phoneDAO;
	private PhoneTypeDAO phoneTypeDAO;
	private ProviderDAO providerDAO;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePhone() {
        super();
        phoneDAO = DAOFactory.getFactory().getPhoneDAO();
        phoneTypeDAO = DAOFactory.getFactory().getPhoneTypeDAO();
        providerDAO = DAOFactory.getFactory().getProviderDAO();
        userDAO = DAOFactory.getFactory().getUserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			int providerID = Integer.parseInt(request.getParameter("providerID"));
			int phoneTypeID = Integer.parseInt(request.getParameter("phoneTypeID"));
			String userDNI = request.getParameter("dni");
			String number = request.getParameter("number");
			
			Provider provider = providerDAO.read(providerID);
			PhoneType phoneType = phoneTypeDAO.read(phoneTypeID);
			User user;
			
			String[][] attributes = {{"dni"}};
			String[] values = {"equal&" + userDNI};
			user = userDAO.findByPath(attributes, values, null, 0, 1, false).get(0);
			
			Phone phone = new Phone(number, provider, phoneType);
			phone.setUser(user);
			
			phoneDAO.create(phone);
			
			String msg = "El telefono se ha registrado al usuario";
			response.getWriter().append(msg);
		} catch (Exception e) {
			String msg = "Hubo un problema al registrar el telefono";
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
