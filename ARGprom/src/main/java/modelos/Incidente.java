package modelos;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author Marcelo Alejandro Asevedo
 */

@Entity
@Table(name = "incidentes")
public class Incidente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idincidente")
    private int idincidente;

    @Column(name = "fechaHoraInicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fechaHoraFin")
    private LocalDateTime fechaHoraFin;

    
    @Column(name = "idcliente")
    private int cliente;

    
    @Column(name = "idservicio")
    private int servicio;

   
    @Column(name = "idproblema")
    private int problema;

    @Column(name = "observaciones")
    private String observaciones;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoIncidente estado;
 
   
    @Column(name = "idtecnico")
    private int tecnico;

	public int getIdincidente() {
		return idincidente;
	}

	public void setIdincidente(int idincidente) {
		this.idincidente = idincidente;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getServicio() {
		return servicio;
	}

	public void setServicio(int servicio) {
		this.servicio = servicio;
	}

	public int getProblema() {
		return problema;
	}

	public void setProblema(int problema) {
		this.problema = problema;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public EstadoIncidente getEstado() {
		return estado;
	}

	public void setEstado(EstadoIncidente estado) {
		this.estado = estado;
	}

	public int getTecnico() {
		return tecnico;
	}

	public void setTecnico(int tecnico) {
		this.tecnico = tecnico;
	}

	public Incidente() {}
	public Incidente(LocalDateTime fi, LocalDateTime ff, int c, int t, int s, int p, String obs, EstadoIncidente e) {
	fechaHoraInicio =fi;
	fechaHoraFin = ff;
	cliente = c;
	servicio = s;
	problema = p;
	tecnico = t;
	observaciones = obs;
	estado = e;
}
}