package ec.edu.ups.controller.provider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProviderDAO;
import ec.edu.ups.model.Provider;

/**
 * Servlet implementation class CreateProvider
 */
@WebServlet("/CreateProvider")
public class CreateProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProviderDAO providerDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProvider() {
        super();
        providerDAO = DAOFactory.getFactory().getProviderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String msg = "";
			
			Provider cnt = new Provider("CNT");
			Provider movistar = new Provider("Movistar");
			Provider claro = new Provider("Claro");
			Provider tuenti = new Provider("Tuenti");
			
			if (providerDAO.find(null, 0, 0).size() == 0) {
				providerDAO.create(cnt);
				providerDAO.create(movistar);
				providerDAO.create(claro);
				providerDAO.create(tuenti);
				msg += "Se han creado las Operadoras";
			} else {
				msg += "Las Operadoras ya han sido creadas";
			}
			
			response.getWriter().append(msg);
		} catch (Exception e) {
			String msg = "No se han podido crear las Operadoras";
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
