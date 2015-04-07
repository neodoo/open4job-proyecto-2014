package es.opensigad.model.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
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
	
	protected void loadDataSet(String filename) throws IOException, DataSetException {
		File file = file(filename);
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		IDataSet ds = builder.build(file);
		ReplacementDataSet dataSet = new ReplacementDataSet(ds);
		dataSet.addReplacementObject("[NULL]", null);

		executeDbunitOp(DatabaseOperation.CLEAN_INSERT, dataSet);
	}
	
	protected void beginTransaction() {
		EntityTransaction trans = em.getTransaction();
		if (trans.isActive()) {
			trans.rollback();
		}
		trans.begin();
	}
	
	protected void commitTransaction() {
		em.getTransaction().commit();
	}

	private void execute(Work work) {
		Session sess = (Session) em.getDelegate();
		sess.doWork(work);
	}

	private File file(String filename) throws IOException {
		URL url = getClass().getResource(filename);
		if (url == null) {
			throw new IOException("File not found: " + filename);
		}
		return new File(url.getPath());

	}

	private void executeDbunitOp(final DatabaseOperation op, final IDataSet dataSet) {
		execute(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					IDatabaseConnection con = new DatabaseConnection(connection);
					op.execute(con, dataSet);

				} catch (DatabaseUnitException e) {
					throw new SQLException(
							"Error while executing DBUnit operation", e);
				}
			}
		});
	}
}
