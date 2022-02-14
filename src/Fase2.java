import java.util.ArrayList;
import java.util.Scanner;

public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		UserDB db = new UserDB();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		// contador para recorrer el arraylist
		int i = 0;

		// ************ CONEXION ***************
		if (db.conectar()) {
			System.out.println("Conexión correcta");

		} else {
			System.out.println("Error en la conexión");
		}

		int opcion;
		boolean salir = true; // esta variable solo puede ser verdadero o falso

		while (salir) {
			/*
			 * mientras la variable salir se mantenga verdadera se ejecutará lo que viene a
			 * continuación en bucle
			 */

			System.out.println("1.Crear");
			System.out.println("2.Mostrar");
			System.out.println("3.Modificar");
			System.out.println("4.Borrar");
			System.out.println("0.Salir");

			System.out.println("Introduce una opción");
			opcion = scn.nextInt();

			if (opcion == 1) {
				System.out.println("Has seleccionado Crear");
				// ************** CREATE **************
				if (db.Create("carlos", "222") == 1) {
					System.out.println("Usuario creado correctamente");
				} else {
					System.out.println("No se pudo crear usuario");
				}
			}

			if (opcion == 2) {
				System.out.println("Has seleccionado Mostrar");
				// ************** READ **************

				usuarios = db.read();
				// recorremos el arraylist con un bucle for para corroborar que se ha llenado
				// con los datos del select
				if (usuarios != null) {
					for (i = 0; i < usuarios.size(); i++) {
						// cada vez que itera obtiene uno de los objetos del arraylist.
						// usuarios.get(i) es el objeto y a partir de ahí accedemos a sus atributos
						System.out.println(usuarios.get(i).getId() + " - " + usuarios.get(i).getLogin() + " - "
								+ usuarios.get(i).getPassword());
					}
				}

			}

			if (opcion == 3) {
				System.out.println("Has seleccionado  Modificar");
				// ************** UPDATE **************
				if (db.Update("toni", "333", "11") == 1) {
					System.out.println("Usuario modificado correctamente");
				} else {
					System.out.println("No se pudo modificar usuario");
				}
			}

			if (opcion == 4) {
				System.out.println("Has seleccionado Borrar");
				// ************** DELETE **************
				if (db.Delete("16") == 1) {
					System.out.println("Usuario borrado correctamente");
				} else {
					System.out.println("No se pudo borrar usuario");
				}
			}

			if (opcion > 5) {
				System.out.println("Opcion invalida");

			}

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
