package es.opensigad.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@SessionScoped
public class TutorDAO implements TutorDAOInterface {

	public static final Logger logger = Logger
			.getLogger(Alumno.class.getName());

	// @Resource(name="jdbc/myoracle")
	// private DataSource ds;

	private EntityManagerFactory emf;
	private EntityManager em;

	public TutorDAO() {
		/*
		 * try { Context ctx = new InitialContext(); ds = (DataSource)
		 * ctx.lookup("java:comp/env/jdbc/opensigad_definitivo"); } catch
		 * (NamingException e) { e.printStackTrace(); }
		 */

		emf = Persistence.createEntityManagerFactory("PersistenceUnit");
		em = emf.createEntityManager();

	}

	public List<AlumnoTutor> getlistaTutor(int idAlumno) {

		// Recuperamos el objeto relacion Alumno_tutor para recuperar todos los
		// datos
		Query q = em
				.createQuery("SELECT at FROM AlumnoTutor at INNER JOIN Tutor t "
						+ "ON at.idTutor = t.id"
						+ "WHERE at.alumno.id = :varAlumno");
		q.setParameter("varAlumno", idAlumno);
		List<AlumnoTutor> listAlumnoTutor = q.getResultList();

		return listAlumnoTutor;

	}

	// borra 1 tutor con el idTutor recibido
	public void deleteTutor(int id) {

		em.getTransaction().begin();

		AlumnoTutor alumnoTutor = new AlumnoTutor();
		Tutor tutor = new Tutor();
		tutor.setId(id);
		alumnoTutor.setTutor(tutor);

		em.remove(alumnoTutor);

		em.getTransaction().commit();
	}

	// modifica un tutor con el id recibido
	public void updateTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, java.sql.Date fechaNac, String parentesco,
			String sexo, String telefono, String email) {

		em.getTransaction().begin();

		AlumnoTutor alumnoTutor = new AlumnoTutor();
		Tutor tutor = new Tutor();
		Alumno alumno = new Alumno();

		alumno.setId(idAlumno);
		// rellenamos el objeto Tutor
		tutor.setId(idTutor);
		tutor.setNombre(nombre);
		tutor.setApellido1(apellido1);
		tutor.setApellido2(apellido2);
		tutor.setTipoDocumento(tipoDocumento);
		tutor.setDocumento(documento);
		tutor.setFechaNacimiento(fechaNac);
		tutor.setSexo(sexo);
		tutor.setTelefono(telefono);
		tutor.setEmail(email);

		// Rellenamos el objeto AlumnoTutor
		alumnoTutor.setAlumno(alumno);
		alumnoTutor.setTutor(tutor);
		alumnoTutor.setParentesco(parentesco);

		em.persist(alumnoTutor);

		em.getTransaction().commit();

	}

	public void insertarTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, java.sql.Date fechaNac, String parentesco,
			String sexo, String telefono, String email) {


		em.getTransaction().begin();

		AlumnoTutor alumnoTutor = new AlumnoTutor();
		Tutor tutor = new Tutor();
		Alumno alumno = new Alumno();

		alumno.setId(idAlumno);
		// rellenamos el objeto Tutor
		tutor.setId(idTutor);
		tutor.setNombre(nombre);
		tutor.setApellido1(apellido1);
		tutor.setApellido2(apellido2);
		tutor.setTipoDocumento(tipoDocumento);
		tutor.setDocumento(documento);
		tutor.setFechaNacimiento(fechaNac);
		tutor.setSexo(sexo);
		tutor.setTelefono(telefono);
		tutor.setEmail(email);

		// Rellenamos el objeto AlumnoTutor
		alumnoTutor.setAlumno(alumno);
		alumnoTutor.setTutor(tutor);
		alumnoTutor.setParentesco(parentesco);

		em.persist(alumnoTutor);

		em.getTransaction().commit();
	
	}

	public Tutor getDetalleTutor(int idTutor) {

		Tutor tutor = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			new ArrayList<Tutor>();

			ps = con.prepareStatement("SELECT * FROM tutor where id = ?");
			ps.setInt(1, idTutor);

			rs = ps.executeQuery();

			String aux = new String();
			PreparedStatement pt1 = con
					.prepareStatement("SELECT * FROM alumno_tutor WHERE idTutor = ?");
			pt1.setInt(1, idTutor);
			while (rs.next()) {
				aux = rs.getString("parentesco");
			}

			while (rs.next()) {
				tutor = new Tutor();
				tutor.setId(rs.getInt("idTutor"));
				tutor.setNombre(rs.getString("nombre"));
				tutor.setApellido1(rs.getString("apellido1"));
				tutor.setApellido2(rs.getString("apellido2"));
				tutor.setTipoDocumento(rs.getString("tipo_documento"));
				tutor.setDocumento(rs.getString("documento"));
				tutor.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				tutor.setSexo(rs.getString("sexo"));
				tutor.setTelefono(rs.getString("tlf"));
				tutor.setEmail(rs.getString("email"));

			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return tutor;

	}






}
