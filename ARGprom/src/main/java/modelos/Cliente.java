package modelos;
import jakarta.persistence.*;


@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private int idcliente;
	
	@Column(name = "razonSocial")
    private String razonSocial;
	
	@Column(name = "cuit")
    private String cuit;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "telefono")
    private String telefono;
	
	
    public Cliente(String rs, String cu, String e, String tel){
    	razonSocial = rs;
    	cuit = cu;
    	email = e;
    	telefono = tel;
    };
    public Cliente () {};
    
    
  public int getIdcliente() {
		return idcliente;
	}


	public void setIdCliente(int idcliente) {
		this.idcliente = idcliente;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	

}

