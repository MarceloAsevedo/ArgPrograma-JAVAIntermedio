package modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "operadores")
public class Operador{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idoperador")
	    private int idoperador;
	 
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

		public int getIdoperador() {
			return idoperador;
		}

		public void setIdoperador(int idoperador) {
			this.idoperador = idoperador;
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
	 	
		public Operador() {};
		public Operador(String n, String a, String d, String e, String t) {
			nombre = n;
			apellido = a;
			dni = d;
			email = e;
			telefono = t;
		};
}
