package vista;

import java.util.Scanner;

import modelo.dao.ComponenteDao;
import modelo.data.Componente;
import modelo.data.Tipo;

public class Menu {
	   private Scanner scanner;

	   public Menu() {
	       scanner = new Scanner(System.in);
	   }

	   public void displayMenu() {
	       int option;
	       do {
	           System.out.println("1. Crea un nuevo componente");
	           System.out.println("2. Lista los componentes");
	           System.out.println("3. Salir");
	           System.out.print("Introduce la opcion ");
	           option = scanner.nextInt();

	           switch (option) {
	               case 1:
	                  crearComponente();
	                  break;
	               case 2:
	                  listarComponentes();
	                  break;
	               case 3:
	                  System.out.println("Saliendo...");
	                  break;
	               default:
	                  System.out.println("Opcion Incorrecta.");
	           }
	       } while (option != 3);
	   }

	   private void crearComponente() {
		   Scanner scanner = new Scanner(System.in);

		   System.out.println("Introduce el ID del componente:");
		   int id = scanner.nextInt();

		   System.out.println("Introduce el nombre del componente:");
		   scanner.nextLine(); 
		   String nombre = scanner.nextLine();

		   System.out.println("Introduce el fabricante del componente:");
		   String fabricante = scanner.nextLine();

		   System.out.println("Introduce el precio del componente:");
		   double precio = scanner.nextDouble();

		   System.out.println("Introduce la descripción del componente:");
		   scanner.nextLine(); 
		   String descripcion = scanner.nextLine();

		   System.out.println("Introduce el id del tipo del componente:");
		   int idTipo = scanner.nextInt();
		   
		   System.out.println("Introduce el tipo del componente:");
		   String tipo = scanner.nextLine();

		   
		   Componente c = new Componente(id, nombre, fabricante, precio, descripcion, new Tipo(idTipo, tipo));
		   ComponenteDao.insertarUnComponente(c);
		
	   	}

	private void listarComponentes() {
		ComponenteDao.seleccionarComponente().forEach(System.out::println);
	   }
	}

