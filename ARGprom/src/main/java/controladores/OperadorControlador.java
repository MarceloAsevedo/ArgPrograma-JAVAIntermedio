package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import modelos.Operador;

public class OperadorControlador {
	public String CrearOperador(String nombre, String apellido, String dni, String email, String telefono) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operador.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	Operador operador = new Operador(nombre, apellido, dni , email, telefono);
            session.beginTransaction();
            session.persist(operador);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "operador creado" + operador.toString();
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al crear operador";
     
   }
	public String VerOperador(int idoperador) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operador.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Operador operador = session.get(Operador.class, idoperador);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Operador ID: " + idoperador + "| Nombre:"+ operador.getNombre()+" "+ operador.getApellido() +"| DNI: "+operador.getDni()+"| Correo Electrónico: "+operador.getEmail()+"| Teléfono: "+operador.getTelefono();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al leer el operador";
	}
    
	public String ActualizarOperador (int idoperador, String nombre, String apellido,String dni, String email, String telefono) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operador.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Operador operador = session.get(Operador.class, idoperador);
			operador.setNombre(nombre);
			operador.setApellido(apellido);
			operador.setDni(dni);
			operador.setEmail(email);
			operador.setTelefono(telefono);
			
			session.persist(operador);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Operador ID: " + idoperador + "A sido actualizado con la siguiente información | Nombre:"+ operador.getNombre()+" "+ operador.getApellido() +"| DNI: "+operador.getDni()+"| Correo Electrónico: "+operador.getEmail()+"| Teléfono: "+operador.getTelefono();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al actualizar operador";
		
	}
	
	public String MostrarTodosLosOperadores() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operador.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	
try {
			
			session.beginTransaction();
			
			CriteriaQuery <Operador> cqry = session.getCriteriaBuilder().createQuery(Operador.class);
			cqry.from(Operador.class);
			List <Operador> operador = session.createQuery(cqry).getResultList();
			System.out.println("NUESTROS OPERADORES");
			System.out.println("------------------");
			for(Operador i : operador) {
				System.out.println("");
				System.out.println("Técnico ID: " + i.getIdoperador() + "| Nombre:"+ i.getNombre()+" "+ i.getApellido() +"| DNI: "+i.getDni()+"| Correo Electrónico: "+i.getEmail()+"| Teléfono: "+i.getTelefono());
				
			}
			sessionFactory.close();
	} catch (Exception exc) {
		exc.printStackTrace();
		return "Error al mostrar los operadores";
	}
	return "Fin lista de operadores";
}
	public String EliminarOperador(int idoperador) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operador.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	
            session.beginTransaction();
            Operador operador = session.get(Operador.class, idoperador);
            session.remove(operador);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "Operador Eliminado ID: "+idoperador;
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al eliminar operador";
     
   }
}