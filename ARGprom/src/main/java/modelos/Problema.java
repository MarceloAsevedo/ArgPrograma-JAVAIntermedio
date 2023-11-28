package modelos;
import javax.persistence.*;

@Entity
@Table(name = "problemas")
public class Problema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproblema")
    private int idproblema;
    
    @Column(name = "problema")
    private String problema;

    @Column(name = "tiempoEstimado")
    private String tiempoEstimado;

	public int getIdproblema() {
		return idproblema;
	}

	public void setIdproblema(int idproblema) {
		this.idproblema = idproblema;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	public Problema() {};
	public Problema(String p, String t) {
		problema = p;
		tiempoEstimado = t;
	};
    
    
}