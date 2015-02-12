package es.opensigad.model.dao;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class AlumnoNotaDaoPoolDB extends AlumnoNotaDAO {
	public AlumnoNotaDaoPoolDB() {
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://192.168.26.67:3306/opensigad2";
		ds = setupDataSource(driver, user, password, url);
	}

	private DataSource setupDataSource(String driver, String user,
			String password, String url) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setUrl(url);
		return ds;
	}

}
