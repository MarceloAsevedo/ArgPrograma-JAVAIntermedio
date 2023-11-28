package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import modelos.Tecnico;

public class TecnicoControlador {
	public Tecnico CrearTecnico(String nombre, String apellido, String dni, String email, String telefono) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Tecnico tecnico = null;

        try {
            tecnico = new Tecnico(nombre, apellido, dni, email, telefono);
            session.beginTransaction();
            session.persist(tecnico);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

        return tecnico;
    }
	public String VerTécnico (int idtecnico) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Tecnico tecnico = session.get(Tecnico.class, idtecnico);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Técnico ID: " + idtecnico + "| Nombre:"+ tecnico.getNombre()+" "+ tecnico.getApellido() +"| DNI: "+tecnico.getDni()+"| Correo Electrónico: "+tecnico.getEmail()+"| Teléfono: "+tecnico.getTelefono();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al leer el técnico";
	}
    
	public String ActualizarTecnico (int idtecnico, String nombre, String apellido,String dni, String email, String telefono) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Tecnico tecnico = session.get(Tecnico.class, idtecnico);
			tecnico.setNombre(nombre);
			tecnico.setApellido(apellido);
			tecnico.setDni(dni);
			tecnico.setEmail(email);
			tecnico.setTelefono(telefono);
			
			session.persist(tecnico);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Técnico ID: " + idtecnico + "A sido actualizado con la siguiente información | Nombre:"+ tecnico.getNombre()+" "+ tecnico.getApellido() +"| DNI: "+tecnico.getDni()+"| Correo Electrónico: "+tecnico.getEmail()+"| Teléfono: "+tecnico.getTelefono();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al actualizar técnico";
		
	}
	
	public String MostrarTodosLosTecnicos() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	
try {
			
			session.beginTransaction();
			
			CriteriaQuery <Tecnico> cqry = session.getCriteriaBuilder().createQuery(Tecnico.class);
			cqry.from(Tecnico.class);
			List <Tecnico> tecnico = session.createQuery(cqry).getResultList();
			System.out.println("NUESTROS TÉCNICOS");
			System.out.println("------------------");
			for(Tecnico i : tecnico) {
				System.out.println("");
				System.out.println("Técnico ID: " + i.getIdtecnico() + "| Nombre:"+ i.getNombre()+" "+ i.getApellido() +"| DNI: "+i.getDni()+"| Correo Electrónico: "+i.getEmail()+"| Teléfono: "+i.getTelefono());
				
			}
			sessionFactory.close();
	} catch (Exception exc) {
		exc.printStackTrace();
		return "Error al mostrar los técnicos";
	}
	return "Fin lista de técnicos";
}
	public String EliminarTecnico(int idtecnico) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tecnico.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	
            session.beginTransaction();
            Tecnico tecnico = session.get(Tecnico.class, idtecnico);
            session.remove(tecnico);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "Técnico Eliminado ID: "+idtecnico;
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al eliminar técnico";
     
   }
}
