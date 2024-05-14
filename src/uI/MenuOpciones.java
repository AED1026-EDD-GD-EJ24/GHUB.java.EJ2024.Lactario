package uI;

import java.util.Scanner;


import datos.Hijo;

import datos.Fecha;
import datos.Mama;
import listaDoble.ListaDoblementeEnlazada;
import listaDoble.PosicionIlegalException;
import negocios.Lactario;
import arbolAVL.BTreePrinter;


public class MenuOpciones {
	static Scanner entrada = new  Scanner(System.in);
	private Lactario lact = new Lactario();
	static Fecha fechaActual = new Fecha("00/00/0000").obtenerFechaSistema();
	
	
	/**
	 * Agregar un elemento al árbol AVL, validando que no exista
	 * Agregar un elemento en un TreeSet
	 */
	public void agregar_mama() {
		try {
			String id;
			String nombre;
			int edad;
			Fecha fecha;
			ListaDoblementeEnlazada<Hijo> hijosMama = new ListaDoblementeEnlazada<Hijo>();
			
			System.out.println(" *** INGRESAR MADRE ***");
			System.out.println("\t\tFecha Actual:"+fechaActual);
			do {
				System.out.println("DEBE INGRESAR UN ID QUE NO EXISTA");
				System.out.print("Introduce ID:");
				id = entrada.next();
			}while (lact.buscarMama(id)!=null);

			System.out.print("Introduce Nombre MADRE:");
			nombre=entrada.next();
			System.out.print("Introduce Edad MADRE:");
			edad=entrada.nextInt();
			System.out.print("Introduce Fecha Nacimiento MADRE (DD/MM/AAAA):");
			fecha = new Fecha(entrada.next());
	
			final String CENTINELA="99";
			String idHijo;
			String nombreHijo;
			
			Fecha fechaHijo;
			System.out.println(" *** CAPTURA DE HIJO/HIJA DE LA MADRE ***");
			System.out.print("Introduce ID Hijo/Hija (99 para Salir): ");
			idHijo = entrada.next();
			
			while(!idHijo.equals(CENTINELA)) {
				//Valida que el ID del hijo no exista
				while (lact.buscaHijo(idHijo)!=null) {
					System.out.println("DEBE INGRESAR UN ID QUE NO EXISTA");
					System.out.print("Introduce ID Hijo/Hija:");
					idHijo = entrada.next();
				} 

				System.out.print("Introduce Nombre Hijo/Hija:");
				nombreHijo=entrada.next();
					
				System.out.print("Introduce Fecha Nacimiento (MM/DD/AAAA) Hijo/Hija:");
				fechaHijo = new Fecha(entrada.next());
					
				int edadMeses = fechaActual.calcularEdadMeses(fechaHijo);
				int edadDias = fechaActual.calcularEdadDias(fechaHijo	)-edadMeses*30;
				System.out.println("Edad en Meses:"+edadMeses);
				System.out.println("Edad en Dias:"+edadDias);
					
				//Agrego objeto hijo a una lista de hijos
					
				lact.agregar_hijos(idHijo, nombreHijo, edadMeses, edadDias,fechaHijo,id,nombre);
				//Agrego objeto hijo a una lista de hijos de la mama
				hijosMama.agregar(new Hijo(idHijo, nombreHijo, edadMeses, edadDias, fechaHijo, id));
					
				System.out.print("Introduce ID Hijo/Hija (99 para Salir): ");
				idHijo = entrada.next();


			}
			//Agrega un objeto mama al árbol AVL y al hashTable
			lact.agregar_mama(id, nombre, edad, fecha,lact.getHijos(id));
			
			System.out.println("Captura Hijos/Hijas Finalizada");
			ListaDoblementeEnlazada<Hijo> hijos = lact.obtenerListaLactantes();
			System.out.println("Historial de Hijos/Hijas: "+hijos);
			
			System.out.println("Insertado con éxito");
			
		}
		catch (Exception e) {
			e.printStackTrace();
				
		}
		
	}
	/**
	 * Elimina un elemento del árbol AVLL validando que el elemento exista
	 * Elimina un elemento de un TreeSet
	 */
	public void eliminar_mama() {
		try {
			String id;
			Mama objMama = null;

			System.out.println(" *** ELIMINAR MADRE ***");
			System.out.println("\t\tFecha Actual:"+fechaActual);

			do {
				System.out.println("DEBE INGRESAR UN ID QUE EXISTA");
				System.out.print("Introduce ID:");
				id = entrada.next();
				objMama= lact.buscarMama(id);

			}while (objMama==null);
			
			System.out.println("Nombre:"	+objMama.getNombre());
			System.out.println("Edad:"+objMama.getEdad());
			System.out.println("Fecha (MM/DD/AAAA):"+objMama.getFechaNacimiento());

			if (objMama.getHijos().getTamanio()==0) {
				System.out.println("No tiene Hijos registrados");
			}
			else{
				System.out.println("Número de Hijos:"+objMama.getHijos().getTamanio());
				for(int i=0;i<objMama.getHijos().getTamanio();i++) {
					System.out.println(objMama.getHijos().getValor(i));
			}
		}

		System.out.print("¿Está seguro de eliminar este registro? (S/N)");
		String respuesta = entrada.next();
		if (respuesta.equalsIgnoreCase("S")) {
			lact.eliminar_mama(id);
			lact.eliminar_hijo_mama(id);
			System.out.println("Eliminado con éxito");
		}
		else
			System.out.println("Operación Cancelada");
		
		   
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	/*
	 * Edita un elemento del árbol AVL
	 */
	public void editar_mama() {
		try {
			String id;
			Mama objMama = null;

			System.out.println(" *** EDITAR MAMA ***");
			System.out.println("\t\tFecha Actual:"+fechaActual);

			do {
				System.out.println("DEBE INGRESAR UN ID QUE  EXISTA");
				System.out.print("Introduce ID:");
				id = entrada.next();
				//busca en Hashtable
				objMama= lact.buscarMama(id);

			}while (objMama==null);
			String nombre = objMama.getNombre();
			Fecha fechaNacimiento = objMama.getFechaNacimiento();
			int edad = objMama.getEdad();
			
			System.out.println("Nombre:"	+nombre);
			System.out.println("Edad:"+edad);
			System.out.println("Fecha (MM/DD/AAAA):"+fechaNacimiento);

			if (objMama.getHijos().getTamanio()==0) {
				System.out.println("No tiene Hijos registrados");
			}
			
			else{
				System.out.println("Número de Hijos:"+objMama.getHijos().getTamanio());
				for(int i=0;i<objMama.getHijos().getTamanio();i++) {
					System.out.println(objMama.getHijos().getValor(i));
				}
			}
			System.out.print("¿Está es el registro que quiere editar? (S/N)");
			String respuesta = entrada.next();
			if (respuesta.equalsIgnoreCase("S")) {
					
				System.out.print("Introduce Nombre MADRE:");
				String nombre2=entrada.next();
				System.out.print("Introduce Edad MADRE:");
				int edad2=entrada.nextInt();
				System.out.print("Introduce Fecha Nacimiento MADRE (DD/MM/AAAA):");
				Fecha fechaNacimiento2 = new Fecha(entrada.next());
				System.out.print("¿Procede edición? (S/N)");
				String respuesta2 = entrada.next();
				if (respuesta2.equalsIgnoreCase("S")) {
					Mama mama =lact.buscar_mama(id,nombre,edad,fechaNacimiento);
					
					if(mama !=null){
						//modifica el objeto mama del arbol AVL
						mama.setNombre(nombre2);
					    mama.setEdad(edad2);
					    mama.setFechaNacimiento(fechaNacimiento2);

					}
					//modifica el objeto mama del hashTable
					objMama.setNombre(nombre2);
					objMama.setEdad(edad2);
					objMama.setFechaNacimiento(fechaNacimiento2);
					System.out.println("Editado con éxito");
				}
		
			}
			else
				System.out.println("Operación Cancelada");
		
		   
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 * Busca un elemento en el árbolAVL  
	 */
	
	public void buscar_mama_id() {
		try {
			String id;
			Mama objMama = null;

			System.out.println(" *** BUSCAR MAMA ***");
			System.out.println("\t\tFecha Actual:"+fechaActual);

			do {
				System.out.println("DEBE INGRESAR UN ID QUE  EXISTA");
				System.out.print("Introduce ID:");
				id = entrada.next();
				//busca en Hashtable
				objMama= lact.buscarMama(id);

			}while (objMama==null);
			String nombre = objMama.getNombre();
			Fecha fechaNacimiento = objMama.getFechaNacimiento();
			int edad = objMama.getEdad();
			
			System.out.println("Nombre:"	+nombre);
			System.out.println("Edad:"+edad);
			System.out.println("Fecha (MM/DD/AAAA):"+fechaNacimiento);

			if (objMama.getHijos().getTamanio()==0) {
				System.out.println("No tiene Hijos registrados");
			}
			
			else{
				System.out.println("Número de Hijos:"+objMama.getHijos().getTamanio());
				for(int i=0;i<objMama.getHijos().getTamanio();i++) {
					System.out.println(objMama.getHijos().getValor(i));
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();

			
		}
		
	}

	public void buscarMamaPorNombreParcial() {
		try {
			String nombre;
			System.out.print("Introduce Nombre:");
			nombre = entrada.next();
			ListaDoblementeEnlazada<Mama> mamas = lact.buscarMamaPorNombreParcial(nombre);
			if (mamas.getTamanio()>0) {
				System.out.println("Mamás encontradas con el nombre parcial:"+nombre);
				for(int i=0;i<mamas.getTamanio();i++) {
					System.out.println(mamas.getValor(i));
				}
			}
			else
				System.out.println("¡NO Existen datos con esas características!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrar_arbol_mamas() throws Exception{
		System.out.println("\n MOSTRAR ARBOL DE MAMAS\n");
		BTreePrinter.printNode(lact.getAbo().getRaiz());

	}
	public void mostrar_lista_mamas() throws Exception{
		System.out.println("\n MOSTRAR LISTA DE MAMAS\n");
		lact.getAbo().inorden();
	}
	
	
	public void mostrar_lista_lactantes() throws Exception{
		System.out.println("\n MOSTRAR LISTA DE LACTANTES\n");
		ListaDoblementeEnlazada<Hijo> lista = lact.obtenerListaLactantes();
		for (int i = 0; i < lista.getTamanio(); i++) {
			try {
				System.out.println(lista.getValor(i));
			} catch (PosicionIlegalException e) {
				System.out.println("Error: PosicionIlegalException occurred.");
				e.printStackTrace();
			}
		}
	}
	
	
	
}
	

	

