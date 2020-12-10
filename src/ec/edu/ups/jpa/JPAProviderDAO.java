package ec.edu.ups.jpa;

import ec.edu.ups.dao.ProviderDAO;
import ec.edu.ups.model.Provider;

public class JPAProviderDAO extends JPAGenericDAO<Provider, Integer> implements ProviderDAO {

	public JPAProviderDAO() {
		super(Provider.class);
	}

}
