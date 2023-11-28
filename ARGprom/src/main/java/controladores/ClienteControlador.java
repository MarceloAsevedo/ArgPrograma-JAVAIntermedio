package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import modelos.Cliente;


public class ClienteControlador {

	public String CrearCliente(String razonSocial, String cuit, String email, String telefono) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	Cliente cliente = new Cliente(razonSocial, cuit, email, telefono);
            session.beginTransaction();
            session.persist(cliente);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "Cliente creado" + cliente.toString();
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al crear cliente";
     
   }
	public String VerCliente (int idcliente) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Cliente cliente = session.get(Cliente.class, idcliente);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Cliente ID: " + idcliente + "| Razón Social:"+ cliente.getRazonSocial() +"| CUIT: "+cliente.getCuit()+"| Correo Electrónico: "+cliente.getEmail()+"| Teléfono: "+cliente.getTelefono();
		
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al leer el cliente";
	}
    
	public String ActualizarServicio (int idcliente, String razonSocial, String cuit, String email, String telefono) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Cliente cliente = session.get(Cliente.class, idcliente);
			cliente.setRazonSocial(razonSocial);
			cliente.setCuit(cuit);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			
			session.persist(cliente);
			session.getTransaction().commit();
			sessionFactory.close();
		return "Cliente ID: "+idcliente+" a sido actualizado con lo siguiente: Razón Social:"+ cliente.getRazonSocial()+"| CUIT: "+cliente.getCuit()+"| Correo Electrónico: "+cliente.getEmail()+"| Teléfono: "+cliente.getTelefono();
	} catch (Exception ex) {
		ex.printStackTrace();
		}
		return "Error al actualizar cliente";
		
	}
	
	public String MostrarTodosLosClientes() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	
try {
			
			session.beginTransaction();
			
			CriteriaQuery <Cliente> cqry = session.getCriteriaBuilder().createQuery(Cliente.class);
			cqry.from(Cliente.class);
			List <Cliente> cliente = session.createQuery(cqry).getResultList();
			System.out.println("NUESTROS CLIENTES");
			System.out.println("------------------");
			for(Cliente i : cliente) {
				System.out.println("");
				System.out.println("Cliente ID: " + i.getIdcliente()+ "| Razón Social:"+ i.getRazonSocial() +"| CUIT: "+i.getCuit()+"| Correo Electrónico: "+i.getEmail()+"| Teléfono: "+i.getTelefono());
				
			}
			sessionFactory.close();
	} catch (Exception exc) {
		exc.printStackTrace();
		return "Error al mostrar clientes";
	}
	return "Fin lista de clientes";
}
	public String EliminarCliente(int idcliente) {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
        	
            session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, idcliente);
            session.remove(cliente);
            session.getTransaction().commit();
        	sessionFactory.close();

            return "Cliente Eliminado ID: "+idcliente;
        } catch (Exception e) {
            
            e.printStackTrace();         
        }
        return "Error al eliminar cliente";
     
   }
}
