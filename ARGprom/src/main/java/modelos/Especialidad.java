package modelos;
import jakarta.persistence.*;

@Entity
@Table(name = "especialidades")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idespecialidad")
    private int idespecialidad;

    @Column(name = "especialidad")
    private String especialidad;

   
    @Column(name = "idtecnico")
    private int tecnico;

	public int getIdespecialidad() {
		return idespecialidad;
	}

	public void setIdespecialidad(int idespecialidad) {
		this.idespecialidad = idespecialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getTecnico() {
		return tecnico;
	}

	public void setTecnico(int tecnico) {
		this.tecnico = tecnico;
	}

	public Especialidad() {};
	public Especialidad(String e,int tec) {
		especialidad = e;
		tecnico = tec;
	};
    
}