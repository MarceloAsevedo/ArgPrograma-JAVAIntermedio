package controladores;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import modelos.Servicio;
import java.util.List;
import jakarta.persistence.criteria.CriteriaQuery;


public class ServicioControlador {
 


    public String CrearServicio(String nombre) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	Servicio servicio = new Servicio(nombre);
            session.beginTransaction();
            session.persist(servicio);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "Servicio creado" + servicio.toString();
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al crear servicio";
      //me gustaría generar un vinculo con ella pero solo puedo generar una base de datos
   }
    
        
	
	public String VerServicio (int idservicio) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, idservicio);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Servicio ID: " + idservicio + " :"+ servicio.getNombre();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al leer el servicio";
	}
	
	public String ActualizarServicio (int idservicio, String nombre) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, idservicio);
			servicio.setNombre(nombre);
			
			session.persist(servicio);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Servicio ID: "+idservicio+" a sido actualizado a: "+ servicio.getNombre();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al actualizar el servicio";
		
	}
	public String MostrarServicios() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	
try {
			
			session.beginTransaction();
			
			CriteriaQuery <Servicio> cqry = session.getCriteriaBuilder().createQuery(Servicio.class);
			cqry.from(Servicio.class);
			List <Servicio> servicio = session.createQuery(cqry).getResultList();
			System.out.println("NUESTROS SERVICIOS");
			System.out.println("------------------");
			for(Servicio i : servicio) {
				System.out.println("");
				System.out.println("ID: "+i.getIdservicio()+" Servicio: "+i.getNombre());
				
			}
			sessionFactory.close();
	} catch (Exception exc) {
		exc.printStackTrace();
		return "Error al mostrar servicios";
	}
return "Fin lista de servicios";
}
	 public String EliminarServicio(int idservicio) {
	    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
	        Session session = sessionFactory.openSession();
	        
	        try {
	        	
	            session.beginTransaction();
	            Servicio servicio = session.get(Servicio.class, idservicio);
	            session.remove(servicio);
	            session.getTransaction().commit();
	        	sessionFactory.close();

	            return "Servicio Eliminado ID: "+idservicio;
	        } catch (Exception e) {
	            
	            e.printStackTrace();         
	        }
	        return "Error al eliminar servicio";
	     
	   }
}
