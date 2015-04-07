package es.opensigad.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class JPABaseTest {
	
	protected EntityManager em;
	private static EntityManagerFactory factory;
	
	public EntityManager getEm() {
		return em;
	}
	
	@BeforeClass
	public static void createEMF() {
		factory = Persistence.createEntityManagerFactory("opensigadUnit");
	}

	@Before
	public void setUpEm(){
		em = JPABaseTest.factory.createEntityManager();
	}
	
	@AfterClass
	public static void destroyEMF() {
		factory.close();
	}
	
	protected void beginTransaction() {
		em.getTransaction().begin();
	}
	
	protected void commitTransaction() {
		em.getTransaction().commit();
	}

}
