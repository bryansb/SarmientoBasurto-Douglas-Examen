package ec.edu.ups.jpa;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PhoneDAO;
import ec.edu.ups.dao.PhoneTypeDAO;
import ec.edu.ups.dao.ProviderDAO;
import ec.edu.ups.dao.UserDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public UserDAO getUserDAO() {
		return new JPAUserDAO();
	}

	@Override
	public PhoneDAO getPhoneDAO() {
		return new JPAPhoneDAO();
	}

	@Override
	public PhoneTypeDAO getPhoneTypeDAO() {
		return new JPAPhoneTypeDAO();
	}

	@Override
	public ProviderDAO getProviderDAO() {
		return new JPAProviderDAO();
	}

}
