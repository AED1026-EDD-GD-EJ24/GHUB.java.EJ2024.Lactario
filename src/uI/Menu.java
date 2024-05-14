package uI;
import java.util.Scanner;

public class Menu {
	static Scanner entrada = new  Scanner(System.in);
	
	static MenuOpciones  iOpc = new MenuOpciones();
	static int opcion;

		
		
	public void lectura() throws Exception {
			
		imprimirMenu();	
				
	}
	private static void imprimirMenu() throws Exception {
		do {
			System.out.println();
			System.out.println("\t************* MENU PRINCIPAL ****************");
			System.out.println("\t*  1. Ingresar nueva Mamá al Lactario        *");
			System.out.println("\t*  2. Baja Mamá del Lactario                 *");
			System.out.println("\t*  3. Editar Datos Generales Mamá            *");
			System.out.println("\t*  4. Buscar Mamá por Nombres                *");
			System.out.println("\t*  5. Mostrar Todas las Mamás por nombre     *");	
			System.out.println("\t*  6. Buscar Mamá por ID                     *");
			System.out.println("\t*  7. Mostar Arbol de Mamas                  *");	
			System.out.println("\t*  8. Mostrar Lista de Mamas por id          *");	
			System.out.println("\t*  9. Mostrar Lista de Lactantes             *");	
			System.out.println("\t*                                            *");
			System.out.println("\t* 99. Salir                                  *");
			System.out.println("\t*******************************************+**");
			System.out.print("Seleccione opción ->");
			opcion = entrada.nextInt();
			switch  (opcion) {
			case 1:
			    iOpc.agregar_mama();
				
				break;
			case 2:
				iOpc.eliminar_mama();
				break;
			case 3:
				iOpc.editar_mama();
				break;
			case 4:
				iOpc.buscarMamaPorNombreParcial();
				break;
			case 5:
				//iOpc.mostrarTodasMamas(); 
				break;
			case 6:
				iOpc.buscar_mama_id(); 
				break;
			case 7:
				iOpc.mostrar_arbol_mamas();
				break;

			case 8:
				iOpc.mostrar_lista_mamas();
				break;
			case 9:
			    iOpc.mostrar_lista_lactantes();	  
				break;
				
			case 99:
				salir();
				break;
			default:
				System.out.println("Opcion inválida");
						
			}
		} while (opcion != 99);
	}
	private static void salir() {
		System.out.println("Sesion Finalizada");
		System.out.println("Adios!");
		System.exit(0);
	}

}
	

	

