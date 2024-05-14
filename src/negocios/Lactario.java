package negocios;

import java.util.Iterator;

import java.util.TreeSet;
import java.util.Enumeration;
import java.util.Hashtable;

import listaDoble.ListaDoblementeEnlazada;
import listaDoble.PosicionIlegalException;
import arbolAVL.ArbolAVL;
import arbolAVL.Nodo;
import datos.Mama;

import datos.Fecha;

import datos.Hijo;

import datos.LectorArchivo;

public class Lactario {

	//cree una listadoblemente enlazada parametrizada que contenga objetos hijos y nómbrela ListaHijos
	
	//cree un arbol AVL y nómbrelo abo
	
	//cree una Hastable formada por un String y objetos de la clase Mama. El string deberá guardar los id de las madres
	// y nómbrela ht
	
	
	public Lactario() {
		
		ht = new Hashtable<String,Mama>();
		listaHijos = new ListaDoblementeEnlazada<Hijo>();
		
		LectorArchivo lector = new LectorArchivo();
		//invoque al método leerArchivo de la clase LectorArchivo
        
		
	}
	
	public ArbolAVL getAbo() {
		//retorne el árbol
	}

	public boolean agregar_mama(String id, String nombre,
			   int edad, Fecha fecha, ListaDoblementeEnlazada<Hijo> hijos) throws Exception {
		Mama mama =null;
		//invoque al método buscarMama
		mama = //
		if(mama == null){
			//Agrega un registro mujer al árbol
			//inserte a la mama en el árbol
			

			//Agrega un registro mujer a la Tabla Hash
			//inserte el registro en la hash table
			 
			//retorne verdadero

		}
		//retorne falso
	
	}

	public Mama buscarMama(String id){
		//Busque el id de la mama en la hashtable y retorne el objeto mama
		
		
	}
	public Hijo buscaHijo(String id )throws PosicionIlegalException {
		//busque al hijo en la lista listahijos por id y retorne el objeto buscado, 
		//si no lo encuentra regreso null
		
		
	}

	public boolean agregar_hijos(String Id, String nombre, int edadMeses, int edadDias, Fecha fecha, String idMama, String nombreMama	) {
		//agrege un hijo en la listaHijos
		//retorne verdadero
		
	}

	//filtra los hijos por el id de la madre
	public ListaDoblementeEnlazada<Hijo> getHijos(String idMadre) throws PosicionIlegalException {
		ListaDoblementeEnlazada<Hijo> hijos = new ListaDoblementeEnlazada<Hijo>();
		//busque las coinsidencias en la listahijos y creo otra lista de nombre hijos, que contenga
		//solamente los objetos hijo del idMadre
		hijos.limpiar();

		//retorne la lista hijos

		
	}

	//devuelve una lista de mamas por una parte del nombre a partir de la hashTable
	public ListaDoblementeEnlazada<Mama> buscarMamaPorNombreParcial(String nombre) throws Exception{
		//cree un lista de tipo ListaDoblementeEnlazada que contengo objetos Mama

		

		mamas.limpiar();

		//busque las conisidencias en la hashtable y agrega a la lista
		
		
		//retorma la lista mamas que contendrá una lista de mamas en cuyo nombre aparezcan las coinsidencias de nombre
	}

	//elimina del árbol AVL y de la tabla Hash
	public boolean eliminar_mama(String id) throws Exception{
		Mama mama= buscarMama(id);
		if(mama != null){
			//elimine al objeto del árbol
			
			//elimine el objeto de la hashtable
			
			
			return true;
		}else{	
			return false;
		}

	}

	//elimina de la lista de hijos
	public boolean eliminar_hijo(String id) throws PosicionIlegalException{
		//elimine de la lista listaHijos al hijo id
		//retorne verdadero si lo pudo eliminar
		//retorne falso si no lo encontró
		

	}

	//elimina de la lista de hijos por el id de la madre
	public boolean eliminar_hijo_mama(String idMama) throws PosicionIlegalException{
		int eliminados =0;
		//complete el códifo dentro del for para que elimien de la listaHijos a los que tengan
		//como el idMama
		//cuente cuántos son
		for(int i=0; i<listaHijos.getTamanio(); i++){
			
				
			}
		}
	
		if (eliminados >0)
		  	return true;
		else 
		   return false;

	}
	
	//busca en el árbol AVL por nombre
	public Mama buscar_mama(String id, String nombre,
			int edad, Fecha fecha) throws Exception{
		//Coloque aquí el código para que busque el objeto Mujer
		// y regrese verdadero si lo encuentra y falso si no
		
	}

	
	public void recorrer_arbolAVL() {
		//coloque el código necesario para recorrer el árbol AVL
		//utilizando el Iterador Mujer, 
		//y muestre los elementos en pantalla
		System.out.println("\n Recorrido en inorden");
		abo.inordenIterativo();
		System.out.println("\n Recorrido en inorden");
		abo.inorden();

	}

	public ListaDoblementeEnlazada<Hijo> obtenerListaLactantes() {
		return listaHijos;
		
	}
		
}
		
	
	





