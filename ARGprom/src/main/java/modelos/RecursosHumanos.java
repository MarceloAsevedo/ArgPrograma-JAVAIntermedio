package modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "recursosHumanos")
public class RecursosHumanos {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idrrhh")
	    private int idrrhh;
	 
	 	@Column(name = "nombre")
	    private String nombre;
	 	
	 	@Column(name = "apellido")
	    private String apellido;
	 	
	 	@Column(name = "dni")
	    private String dni;
	 	
	 	@Column(name = "email")
	    private String email;
	 	
	 	@Column(name = "telefono")
	    private String telefono;

		public int getIdrrhh() {
			return idrrhh;
		}

		public void setIdidrrhh(int idrrhh) {
			this.idrrhh = idrrhh;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
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
		public RecursosHumanos() {};
		public RecursosHumanos(String n, String a, String d, String e, String t) {
			nombre = n;
			apellido = a;
			dni = d;
			email = e;
			telefono = t;
		};
	 	
}
