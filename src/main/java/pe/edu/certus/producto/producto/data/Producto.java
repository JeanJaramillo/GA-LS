package pe.edu.certus.producto.producto.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTO_ID")
	private long id;
	@Column(name = "NOMBRE_PRODUCTO")
	private String name;
	@Column(name = "STOCK_PRODUCTO")
	private String stockProduc;
	@Column(name = "ALMACEN_PRODUCTO")
	private String almacenProducto;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStockProduc() {
		return stockProduc;
	}

	public void setStockProduc(String stockProduc) {
		this.stockProduc = stockProduc;
	}

	public String getAlmacenProducto() {
		return almacenProducto;
	}

	public void setAlmacenProducto(String almacenProducto) {
		this.almacenProducto = almacenProducto;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", stockProduc=" + stockProduc + ", almacenProducto="
				+ almacenProducto + "]";
	}

}
