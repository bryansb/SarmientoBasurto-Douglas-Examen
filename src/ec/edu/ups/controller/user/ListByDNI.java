package ec.edu.ups.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PhoneDAO;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.Phone;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class ListByDNI
 */
@WebServlet("/ListByDNI")
public class ListByDNI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;
	private PhoneDAO phoneDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListByDNI() {
        super();
        phoneDAO = DAOFactory.getFactory().getPhoneDAO();
        userDAO = DAOFactory.getFactory().getUserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			
			String searchKey = request.getParameter("searchKey") == null ? "" : request.getParameter("searchKey");
			String[][] userAttributes = {{"dni"}};
			String[] userValues = {"like&%" + searchKey + "%"};
			
			List<User> userList = userDAO.findByPath(userAttributes, userValues, "dni", 0, 0, false);
			
			for (User user : userList) {
				String[][] phoneAttributes = {{"user", "id"}};
				String[] phoneValues = {"equal&" + user.getId()};
				
				List<Phone> phoneList = phoneDAO.findByPath(phoneAttributes, phoneValues, null, 0, 0, false);
				user.setPhoneList(phoneList);
			}
			
			request.setAttribute("users", userList);
			
			getServletContext().getRequestDispatcher("/JSPs/user_search_bydni.jsp").forward(request, response);
			
		} catch (Exception e) {
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
