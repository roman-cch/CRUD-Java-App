
public class Producto {
	
	protected int id;
	protected String nombre;
	protected float precio;
	protected int cantidad;
	
	public Producto() {
		this.nombre = "-";
		this.precio = 0;
		this.cantidad = 0;
	}
	public Producto(String n, float p, int uds) {
		this.nombre = n;
		this.precio = p;
		this.cantidad = uds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}