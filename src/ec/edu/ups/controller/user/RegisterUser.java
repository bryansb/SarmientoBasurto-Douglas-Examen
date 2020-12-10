package ec.edu.ups.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PhoneTypeDAO;
import ec.edu.ups.dao.ProviderDAO;
import ec.edu.ups.model.PhoneType;
import ec.edu.ups.model.Provider;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PhoneTypeDAO phoneTypeDAO;
	private ProviderDAO providerDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        phoneTypeDAO = DAOFactory.getFactory().getPhoneTypeDAO();
        providerDAO = DAOFactory.getFactory().getProviderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			
			List<PhoneType> phoneTypes = phoneTypeDAO.find(null, 0, 0);
			List<Provider> providers = providerDAO.find(null, 0, 0);

			request.setAttribute("providers", providers);
			request.setAttribute("phoneTypes", phoneTypes);
			
			getServletContext().getRequestDispatcher("/JSPs/user_register.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
