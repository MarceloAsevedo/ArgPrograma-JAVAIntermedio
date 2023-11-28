package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import modelos.Problema;
import modelos.Servicio;

public class ProblemaControlador {

	 public String CrearProblema(String descripcion, String tiempo) {
	    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Problema.class).buildSessionFactory();
	        Session session = sessionFactory.openSession();
	        
	        try {
	        	Problema problema = new Problema(descripcion,tiempo);
	            session.beginTransaction();
	            session.persist(problema);
	            session.getTransaction().commit();
	        	sessionFactory.close();

	            return "Problema creado" + problema.getProblema() +"Tiempo estimado: "+problema.getTiempoEstimado();
	        } catch (Exception e) {
	            
	            e.printStackTrace();         
	        }
	        return "Error al crear problema";
	      
	   }
	
	        public String MostrarProblemas() {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Problema.class).buildSessionFactory();
			Session session = sessionFactory.openSession();
		
	try {
				
				session.beginTransaction();
				
				CriteriaQuery <Problema> cqry = session.getCriteriaBuilder().createQuery(Problema.class);
				cqry.from(Problema.class);
				List <Problema> problema = session.createQuery(cqry).getResultList();
				System.out.println("NUESTROS PROBLEMAS");
				System.out.println("------------------");
				for(Problema i : problema) {
					System.out.println("");
					System.out.println("ID: "+i.getIdproblema()+" Problema: "+i.getProblema()+"| Tiempo estimado: " + i.getTiempoEstimado());
					
				}
				sessionFactory.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			return "Error al mostrar problemas";
		}
	return "Fin lista de problemas";
	}
		 public String EliminarProblema(int idproblema) {
		    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Problema.class).buildSessionFactory();
		        Session session = sessionFactory.openSession();
		        
		        try {
		        	
		            session.beginTransaction();
		            Problema problema = session.get(Problema.class, idproblema);
		            session.remove(problema);
		            session.getTransaction().commit();
		        	sessionFactory.close();

		            return "Problema Eliminado ID: "+idproblema;
		        } catch (Exception e) {
		            
		            e.printStackTrace();         
		        }
		        return "Error al eliminar problema";
		     
		   }
			public String ActualizarProblema (int idproblema, String nombre,String tiempoEstimado) {
				SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Problema.class).buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				try {
					
					session.beginTransaction();
					Problema problema = session.get(Problema.class, idproblema);
					problema.setProblema(nombre);
					problema.setTiempoEstimado(tiempoEstimado);
					
					session.persist(problema);
					session.getTransaction().commit();
					sessionFactory.close();
				return "Problema ID: "+idproblema+" a sido actualizado a: "+ problema.getProblema();
			} catch (Exception ex) {
				ex.printStackTrace();
				}
				return "Error al actualizar elproblema";
				
			}
			
			 public String VerProblema (int idproblema) {
					SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Problema.class).buildSessionFactory();
					Session session = sessionFactory.openSession();
					
					try {
						
						session.beginTransaction();
						Problema problema = session.get(Problema.class, idproblema);
						session.getTransaction().commit();
						sessionFactory.close();
					return "Problema ID: " + idproblema + " :"+ problema.getProblema();
				} catch (Exception ex) { 
					ex.printStackTrace();
					}
					return "Error al leer el problema";
				}
	}