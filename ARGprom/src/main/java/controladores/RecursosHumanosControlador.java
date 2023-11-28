package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import modelos.RecursosHumanos;

public class RecursosHumanosControlador {

	public String CrearRecursosHumanos(String nombre, String apellido, String dni, String email, String telefono) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RecursosHumanos.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	RecursosHumanos RecursosHumanos = new RecursosHumanos(nombre, apellido, dni , email, telefono);
            session.beginTransaction();
            session.persist(RecursosHumanos);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "RecursosHumanos creado" + RecursosHumanos.toString();
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al crear RecursosHumanos";
     
   }
	public String VerRecursosHumanos (int idrrhh) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RecursosHumanos.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			RecursosHumanos rrhh = session.get(RecursosHumanos.class, idrrhh);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Técnico ID: " + idrrhh + "| Nombre:"+ rrhh.getNombre()+" "+ rrhh.getApellido() +"| DNI: "+rrhh.getDni()+"| Correo Electrónico: "+rrhh.getEmail()+"| Teléfono: "+rrhh.getTelefono();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al leer el técnico";
	}
    
	public String ActualizarRecursosHumanos (int idrrhh, String nombre, String apellido,String dni, String email, String telefono) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RecursosHumanos.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			RecursosHumanos rrhh = session.get(RecursosHumanos.class, idrrhh);
			rrhh.setNombre(nombre);
			rrhh.setApellido(apellido);
			rrhh.setDni(dni);
			rrhh.setEmail(email);
			rrhh.setTelefono(telefono);
			
			session.persist(rrhh);
			session.getTransaction().commit();
			sessionFactory.close();
		return "RecursosHumanos ID: " + idrrhh + "A sido actualizado con la siguiente información | Nombre:"+ rrhh.getNombre()+" "+ rrhh.getApellido() +"| DNI: "+rrhh.getDni()+"| Correo Electrónico: "+rrhh.getEmail()+"| Teléfono: "+rrhh.getTelefono();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al actualizar RecursosHumanos";
		
	}
	
	public String MostrarTodosLosRecursosHumanos() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RecursosHumanos.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	
try {
			
			session.beginTransaction();
			
			CriteriaQuery <RecursosHumanos> cqry = session.getCriteriaBuilder().createQuery(RecursosHumanos.class);
			cqry.from(RecursosHumanos.class);
			List <RecursosHumanos> rrhh = session.createQuery(cqry).getResultList();
			System.out.println("NUESTROS RECURSOS HUMANOS");
			System.out.println("-------------------------");
			for(RecursosHumanos i :rrhh) {
				System.out.println("");
				System.out.println("RecursosHumanos ID: " + i.getIdrrhh() + "| Nombre:"+ i.getNombre()+" "+ i.getApellido() +"| DNI: "+i.getDni()+"| Correo Electrónico: "+i.getEmail()+"| Teléfono: "+i.getTelefono());
				
			}
			sessionFactory.close();
	} catch (Exception exc) {
		exc.printStackTrace();
		return "Error al mostrar los RecursosHumanos";
	}
	return "Fin lista de RecursosHumanos";
}
	public String EliminarRecursosHumanos(int idrrhh) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RecursosHumanos.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	
            session.beginTransaction();
            RecursosHumanos rrhh = session.get(RecursosHumanos.class, idrrhh);
            session.remove(rrhh);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "RecursosHumanos Eliminado ID: "+idrrhh;
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al eliminar RecursosHumanos";
     
   }
}