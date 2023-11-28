package modelos;
import jakarta.persistence.*;


@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservicio")
    private int idservicio;
    
    @Column(name = "nombre")
    private String nombre;

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	

	}

	public int getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
	}
	
	public Servicio () {};
	public Servicio (String n) {
	   nombre = n;
   };
   
}