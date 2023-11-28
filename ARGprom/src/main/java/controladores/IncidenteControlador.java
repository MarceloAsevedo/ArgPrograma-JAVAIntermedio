package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import modelos.Incidente;

import modelos.EstadoIncidente;
import java.time.LocalDateTime;

public class IncidenteControlador {

	public String CrearIncidente(LocalDateTime fi, LocalDateTime ff, int c, int t, int s, int p, String obs, EstadoIncidente e) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	Incidente Incidente = new Incidente(fi, ff, c ,t, s, p, obs, e);
            session.beginTransaction();
            session.persist(Incidente);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "Incidente creado" + Incidente.toString();
        } catch (Exception ex) {
            
            ex.printStackTrace();         
        }
        return "Error al crear técnico";
     
   }
	public String VerIncidente (int idIncidente) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Incidente Incidente = session.get(Incidente.class, idIncidente);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Incidente ID: " + idIncidente + "| Fecha de aceptado:"+ Incidente.getFechaHoraInicio()+"| Fecha Finalizado: "+Incidente.getFechaHoraFin() +"| Cliente: "+Incidente.getCliente()+"| Técnico: "+Incidente.getTecnico()+"| Servicio: "+Incidente.getServicio()+"| Problema: "+Incidente.getProblema()+"| Observaciones: "+Incidente.getObservaciones()+"| Estado: "+Incidente.getEstado();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al leer el Incidente";
	}
    
	public String ActualizarIncidente (int idIncidente, LocalDateTime fi, LocalDateTime ff, int c, int t, int s, int p, String obs, EstadoIncidente e) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Incidente Incidente = session.get(Incidente.class, idIncidente);
			Incidente.setFechaHoraInicio(fi);
			Incidente.setFechaHoraFin(ff);
			Incidente.setCliente(c);
			Incidente.setTecnico(t);
			Incidente.setServicio(s);
			Incidente.setProblema(p);
			Incidente.setObservaciones(obs);
			Incidente.setEstado(e);
			
			session.persist(Incidente);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Incidente Actualizado ID: " + idIncidente + "| Fecha de aceptado:"+ Incidente.getFechaHoraInicio()+"| Fecha Finalizado: "+Incidente.getFechaHoraFin() +"| Cliente: "+Incidente.getCliente()+"| Técnico: "+Incidente.getTecnico()+"| Servicio: "+Incidente.getServicio()+"| Problema: "+Incidente.getProblema()+"| Observaciones: "+Incidente.getObservaciones()+"| Estado: "+Incidente.getEstado();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al actualizar Incidente";
		
	}
	
	public String MostrarTodosLosIncidentes() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	
try {
			
			session.beginTransaction();
			
			CriteriaQuery <Incidente> cqry = session.getCriteriaBuilder().createQuery(Incidente.class);
			cqry.from(Incidente.class);
			List <Incidente> Incidente = session.createQuery(cqry).getResultList();
			
			
			
			System.out.println("LISTA DE INCIDENTES");
			System.out.println("------------------");
			
			
			for(Incidente i : Incidente) {
			
				
			
				System.out.println("ID Incidente:"+ i.getIdincidente());
				System.out.println("ID Cliente: "+i.getCliente());
				System.out.println("ID Servicio: "+i.getServicio());
				System.out.println("ID Técnico: "+i.getTecnico());
				System.out.println("ID Problema: "+i.getProblema());
				System.out.println("Observaciones: "+i.getObservaciones());
				System.out.println("Fecha y hora de inicio:"+ i.getFechaHoraInicio());
				System.out.println("Fecha y hora de finalizado: "+i.getFechaHoraFin());
				System.out.println("Estado: "+i.getEstado());
				
			}
			sessionFactory.close();
	} catch (Exception exc) {
		exc.printStackTrace();
		return "Error al mostrar los Incidentes";
	}
	return "Fin lista de Incidentes";
}
	public String EliminarIncidente(int idIncidente) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	
            session.beginTransaction();
            Incidente Incidente = session.get(Incidente.class, idIncidente);
            session.remove(Incidente);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "Incidente Eliminado ID: "+idIncidente;
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al eliminar Incidente";
     
   }
}
