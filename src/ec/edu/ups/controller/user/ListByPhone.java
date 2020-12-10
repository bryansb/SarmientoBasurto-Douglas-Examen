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
 * Servlet implementation class ListByPhone
 */
@WebServlet("/ListByPhone")
public class ListByPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;
	private PhoneDAO phoneDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListByPhone() {
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
			String[][] userAttributes = {{"phoneList", "number"}};
			String[] userValues = {"like&%" + searchKey + "%"};
			
			List<User> userList = userDAO.findByPath(userAttributes, userValues, null, 0, 0, true);
//			List<User> userList = userDAO.find(null, 0, 0);
			
			for (User user : userList) {
				String[][] phoneAttributes = {{"user", "id"}, {"number"}};
				String[] phoneValues = {"equal&" + user.getId(), "like&%" + searchKey + "%"};
				
				List<Phone> phoneList = phoneDAO.findByPath(phoneAttributes, phoneValues, "number", 0, 0, false);
				user.setPhoneList(phoneList);
			}
			
			request.setAttribute("users", userList);
			
			getServletContext().getRequestDispatcher("/JSPs/user_search_byphone.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
