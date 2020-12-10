package ec.edu.ups.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.User;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        userDAO = DAOFactory.getFactory().getUserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		try {

			String dni = request.getParameter("dni");
			String names = request.getParameter("names");
			String lastnames = request.getParameter("lastnames");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user = new User(dni, names, lastnames, email, password);
			
			userDAO.create(user);
			
			String msg = "El usuario se ha registrado";
			response.getWriter().append(msg);
		} catch (Exception e) {
			String msg = "Hubo un error al crear un usuario. Revise los datos de nuevo.";
			response.getWriter().append(msg);
			System.out.println(e.getMessage());
		}
		
	}

}
