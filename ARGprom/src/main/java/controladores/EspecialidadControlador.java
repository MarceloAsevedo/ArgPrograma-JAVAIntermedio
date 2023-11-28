package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import modelos.Especialidad;
import modelos.Tecnico;

public class EspecialidadControlador {

	 public String  CrearEspecialidad(String nombre, int idtecnico) {
	    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
	        Session session = sessionFactory.openSession();
	        
	        Especialidad especialidad = null;
	        
	        try {
	        	especialidad = new Especialidad(nombre, idtecnico);
	        	session.beginTransaction();
	            session.persist(especialidad);
	            session.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();  
	            sessionFactory.close();
	        }

	       return "Creado";
	    }
	    
	        
		
		public String VerEspecialidad (int idespecialidad) {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			try {
				
				session.beginTransaction();
				Especialidad especialidad = session.get(Especialidad.class, idespecialidad);
				session.getTransaction().commit();
				sessionFactory.close();
			return "Especialidad ID: " + idespecialidad + " :"+ especialidad.getEspecialidad();
		} catch (Exception ex) {
			ex.printStackTrace();
			}
			return "Error al leer la Especialidad";
		}
		
		public String ActualizarEspecialidad (int idespecialidad, String nombre, int idtecnico) {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			try {
				
				session.beginTransaction();
				Especialidad especialidad = session.get(Especialidad.class, idespecialidad);
				especialidad.setEspecialidad(nombre);
				especialidad.setTecnico(idtecnico);
				
				session.persist(especialidad);
				session.getTransaction().commit();
				sessionFactory.close();
			return "Especialidad ID: "+idespecialidad+" a sido actualizado a: "+ especialidad.getEspecialidad()+"| ID Tecnico: "+especialidad.getTecnico();
		} catch (Exception ex) {
			ex.printStackTrace();
			}
			return "Error al actualizar la Especialidad";
			
		}
		public String MostrarEspecialidades() {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
			Session session = sessionFactory.openSession();
		
	try {
				
				session.beginTransaction();
				
				CriteriaQuery <Especialidad> cqry = session.getCriteriaBuilder().createQuery(Especialidad.class);
				cqry.from(Especialidad.class);
				List <Especialidad> servicio = session.createQuery(cqry).getResultList();
				System.out.println("NUESTRAS ESPECIALIDADES");
				System.out.println("------------------------");
				for(Especialidad i : servicio) {
					System.out.println("");
					System.out.println("ID: "+i.getIdespecialidad()+" Especialidad: "+i.getEspecialidad()+"| ID Técnico: "+i.getTecnico());
					
				}
				sessionFactory.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			return "Error al mostrar Especialidad";
		}
	return "Fin lista de Especialidades";
	}
		 public String EliminarEspecialidad(int idEspecialidad) {
		    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
		        Session session = sessionFactory.openSession();
		        
		        try {
		        	
		            session.beginTransaction();
		            Especialidad especialidad = session.get(Especialidad.class, idEspecialidad);
		            session.remove(especialidad);
		            session.getTransaction().commit();
		        	sessionFactory.close();

		            return "Especialidad Eliminado ID: "+idEspecialidad;
		        } catch (Exception e) {
		            
		            e.printStackTrace();         
		        }
		        return "Error al eliminar Especialidad";
		     
		   }
	}