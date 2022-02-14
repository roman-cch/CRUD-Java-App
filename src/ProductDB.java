import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ProductDB {
	protected String server;
	protected String puerto;
	protected String usuario;
	protected String nombreDB;
	protected String password;
	// declaramos la conexión como un atributo para poder usarla en todos los
	// metodos que creemos como variable global
	protected Connection conexion;
	protected Statement peticion;
	protected ResultSet rs;
	

	// creamos cponstructor y le asignamos a los atributos los valores por defecto
	public ProductDB() {

		this.server = "localhost";
		this.puerto = "3306";
		this.usuario = "root";
		this.nombreDB = "tienda";
		this.password = "";

	}

	// ***GETTERS Y SETTERS****

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreDB() {
		return nombreDB;
	}

	public void setNombreDB(String nombreDB) {
		this.nombreDB = nombreDB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// creamos el método para la conexión
	public boolean conectar() {
		try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + this.server + "/" + this.nombreDB,
					usuario, password);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	// creamos las funciones del CRUD

	// ************** MÉTODO CREATE **************
	public int Create(String nombre, float p, int uds) {
		if (conexion != null) {
			try {
				peticion = (Statement) conexion.createStatement();
				return peticion.executeUpdate("INSERT INTO productos ( nombre, precio, cantidad) VALUES ('" + nombre
						+ "','" + p + "','" + uds + "')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}

		}

		return 0;
	}

	// ************** MÉTODO READ **************

	// como es un SELECT devuelve un array bidimensional (tabla), de tipo usuario,
	// cuyos atributos son los mismos que los nombres de las columnads de la tabla
	// usuario
	public ArrayList<Producto> read() {

		if (conexion != null) {

			ArrayList<Producto> productos = new ArrayList<Producto>();

			try {
				peticion = (Statement) conexion.createStatement();

				rs = (ResultSet) peticion.executeQuery("SELECT * FROM productos");

				while (rs.next()) {

					Producto p = new Producto();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setPrecio(rs.getFloat("precio"));
					p.setCantidad(rs.getInt("cantidad"));

					productos.add(p);
				}

				rs.close();
				peticion.close();
				return productos;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		} else {
			return null;
		}

	}

	// ************** MÉTODO UPDATE **************
	public int Update(int id, String nombre, float p, int uds) {
		if (conexion != null) {
			try {
				peticion = (Statement) conexion.createStatement();
				return peticion.executeUpdate("UPDATE productos SET nombre = '" + nombre + "', precio = '" + p
						+ "', cantidad = '" + uds + "' WHERE id = '" + id + "'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}

		return 0;

	}

	// ************** MÉTODO DELETE **************
	public int Delete(int id) {
		if (conexion != null) {
			try {
				peticion = (Statement) conexion.createStatement();
				return peticion.executeUpdate("DELETE FROM productos WHERE id = '" + id + "'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}

		return 0;

	}

	// ************** MÉTODO VALIDATE **************

	// como es un SELECT devuelve un array bidimensional (tabla), de tipo usuario,
	// cuyos atributos son los mismos que los nombres de las columnads de la tabla
	// usuario
	public boolean Validar(String usuario, String password) {

		if (conexion != null) {
			try {
				peticion = (Statement) conexion.createStatement();

				rs = (ResultSet) peticion.executeQuery("SELECT * FROM usuarios");

				while (rs.next()) {

					Usuario u = new Usuario();
					u.setLogin(rs.getString("login"));
					u.setPassword(rs.getString("password"));

					if (usuario.equalsIgnoreCase(u.getLogin()) && password.equals(u.getPassword())) {
						return true;
					}
				}

				rs.close();
				peticion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
		return false;

	}

}
