package ec.edu.ups.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PhoneDAO;
import ec.edu.ups.dao.PhoneTypeDAO;
import ec.edu.ups.dao.ProviderDAO;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.model.Phone;
import ec.edu.ups.model.PhoneType;
import ec.edu.ups.model.Provider;
import ec.edu.ups.model.User;

public class CreateTables {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		
		PhoneDAO phoneDAO = DAOFactory.getFactory().getPhoneDAO();
		PhoneTypeDAO phoneTypeDAO = DAOFactory.getFactory().getPhoneTypeDAO();
		ProviderDAO providerDAO = DAOFactory.getFactory().getProviderDAO();
		UserDAO userDAO = DAOFactory.getFactory().getUserDAO();
		
		
		List<Provider> providerList = providerDAO.find(null, 0, 0);
//		System.out.println(providerList.get(1));
//		System.out.println(providerList.get(2));
//		System.out.println(providerList.get(3));
//		System.out.println(providerList.get(0));
		Provider provider1 = providerList.get(0);
		Provider provider2 = providerList.get(1);
		Provider provider3 = providerList.get(2);
		Provider provider4 = providerList.get(3);

		List<PhoneType> phoneTypeList = phoneTypeDAO.find(null, 0, 0);
//		System.out.println(phoneTypeList.get(1));
//		System.out.println(phoneTypeList.get(0));
		PhoneType phoneType1 = phoneTypeList.get(0);
		PhoneType phoneType2 = phoneTypeList.get(1);
		
		// USUARIOS
		User bryan = new User("1400668180", "Bryan", "Sarmiento", "bryansb.297@gmail.com", "123");
		User martin = new User("1400783278", "Martin", "Orellana", "martin@gmail.com", "123");
		User fernanda = new User("1400709224", "Fernanda", "Pasquel", "fernanda@gmail.com", "123");
		User liam = new User("1401325384", "Liam", "Sinchi", "liam@gmail.com", "123");
		User belen = new User("1718922436", "Belen", "Lopez", "belen@gmail.com", "123");
		
		try {
			em.getTransaction().begin();
			em.persist(bryan);
			em.persist(martin);
			em.persist(fernanda);
			em.persist(liam);
			em.persist(belen);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
		// TELEFONOS
		Phone phone1 = new Phone("096917211", bryan, provider1, phoneType1);
		Phone phone2 = new Phone("072525193", bryan, provider3, phoneType2);
		
		Phone phone3 = new Phone("098654651", fernanda, provider2, phoneType1);
		Phone phone4 = new Phone("098162513", fernanda, provider4, phoneType2);
		
		Phone phone5 = new Phone("098162133", martin, provider1, phoneType1);
		Phone phone6 = new Phone("082132133", martin, provider2, phoneType2);
		
		Phone phone7 = new Phone("056168665", liam, provider3, phoneType1);
		Phone phone8 = new Phone("086516213", liam, provider3, phoneType2);
		
		Phone phone9 = new Phone("0656156546", belen, provider2, phoneType1);
		Phone phone10 = new Phone("0984651665", belen, provider1, phoneType2);
		
		try {
			em.getTransaction().begin();
			em.persist(phone1);
			em.persist(phone2);
			em.persist(phone3);
			em.persist(phone4);
			em.persist(phone5);
			em.persist(phone6);
			em.persist(phone7);
			em.persist(phone8);
			em.persist(phone9);
			em.persist(phone10);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
		
	}

}
