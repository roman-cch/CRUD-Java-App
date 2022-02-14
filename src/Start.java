import java.util.ArrayList;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		ProductDB db = new ProductDB();
		ArrayList<Producto> productos = new ArrayList<Producto>();

		// contador para recorrer el arraylist
		int i = 0;

		// ************ CONEXION ***************
		if (db.conectar()) {
			System.out.println("Conexión correcta");

		} else {
			System.out.println("Error en la conexión");
		}

		int opcion;
		boolean salir = true;

		while (salir) {
			/*
			 * mientras la variable salir se mantenga verdadera se ejecutará lo que viene a
			 * continuación en bucle
			 */

			System.out.println("\n");
			System.out.println("***MENÚ PRINCIPAL***");
			System.out.println("1.Crear Producto");
			System.out.println("2.Mostrar Productos");
			System.out.println("3.Modificar Producto");
			System.out.println("4.Borrar Producto");
			System.out.println("0.Salir");
			System.out.println("\n");
			System.out.print("Introduce una opción : ");
			opcion = scn.nextInt();

			if (opcion == 1) {
				System.out.println("Has seleccionado Crear Productos");

				// ************** CREATE **************
				System.out.println("Introduce el nombre del producto -> ");
				String nomProd = scn.next();
				System.out.println("Introduce el precio del producto -> ");
				float costProd = scn.nextFloat();
				System.out.println("Introduce las unidades del producto -> ");
				int udsProd = scn.nextInt();
				if (db.Create(nomProd, costProd, udsProd) == 1) {
					System.out.println("Producto creado correctamente");
				} else {
					System.out.println("No se pudo crear Producto");
				}
				System.out.println("\n");
			}

			if (opcion == 2) {
				System.out.println("Has seleccionado Mostrar Productos");
				// ************** READ **************

				productos = db.read();
				// recorremos el arraylist con un bucle for para corroborar que se ha llenado
				// con los datos del select
				if (productos != null) {
					for (i = 0; i < productos.size(); i++) {
						// cada vez que itera obtiene uno de los objetos del arraylist.
						// usuarios.get(i) es el objeto y a partir de ahí accedemos a sus atributos
						System.out.println(productos.get(i).getId() + " - " + productos.get(i).getNombre() + " - "
								+ productos.get(i).getPrecio() + " - " + productos.get(i).getCantidad());
					}
				}
				System.out.println("\n");
			}

			if (opcion == 3) {
				System.out.println("Has seleccionado  Modificar Productos");
				//mostramos los productos
				productos = db.read();
				// recorremos el arraylist con un bucle for para corroborar que se ha llenado
				// con los datos del select
				if (productos != null) {
					for (i = 0; i < productos.size(); i++) {
						// cada vez que itera obtiene uno de los objetos del arraylist.
						// usuarios.get(i) es el objeto y a partir de ahí accedemos a sus atributos
						System.out.println(productos.get(i).getId() + " - " + productos.get(i).getNombre() + " - "
								+ productos.get(i).getPrecio() + " - " + productos.get(i).getCantidad());
					}
				}
				// ************** UPDATE **************
				System.out.println("Introduce el Id del producto -> ");
				int id = scn.nextInt();
				System.out.println("Introduce el nuevo nombre del producto -> ");
				String nombre = scn.next();
				System.out.println("Introduce el nuevo precio del producto -> ");
				float p = scn.nextFloat();
				System.out.println("Introduce las nuevas unidades del producto -> ");
				int uds = scn.nextInt();
				if (db.Update(id, nombre, p, uds) == 1) {
					System.out.println("Producto modificado correctamente");
				} else {
					System.out.println("No se pudo modificar producto");
				}
				System.out.println("\n");
			}

			if (opcion == 4) {
				System.out.println("Has seleccionado Borrar Productos");
				// ************** DELETE **************
				System.out.println("Introduce el Id del producto que quieres borrar -> ");
				int id = scn.nextInt();
				if (db.Delete(id) == 1) {
					System.out.println("Producto borrado correctamente");
				} else {
					System.out.println("No se pudo borrar producto");
				}
				System.out.println("\n");
			}

			if (opcion > 5) {
				System.out.println("Opcion invalida");

			}
			System.out.println("\n");

			if (opcion == 0) {
				salir = false;/*
								 * al seleccionar la opcion 5 la variable booleana cambia a falso, por lo tanto
								 * cuando volvamos al principio del bucle no volverá a entrar y el bucle acabará
								 */
				System.out.println("Hasta pronto");

			}

		}

	}

}
