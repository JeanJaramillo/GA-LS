package pe.edu.certus.producto.producto.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GUEST")
public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "GUEST_ID")
		private long id;
		@Column(name = "FIRST_NAME")
		private String nombres;
		@Column(name = "LAST_NAME")
		private String apellidos;
		@Column(name = "EMAIL_ADDRESS")
		private String email;
		@Column(name = "COUNTRY")
		private String pais;
		@Column(name = "STATE")
		private String ciudad;
		@Column(name = "PHONE_NUMBER")
		private String telefono;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
					+ ", pais=" + pais + ", ciudad=" + ciudad + ", telefono=" + telefono + "]";
		}

		
}
