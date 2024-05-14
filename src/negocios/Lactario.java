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
	
	private ListaDoblementeEnlazada<Hijo> listaHijos;
	private ArbolAVL abo = new ArbolAVL();
	private Hashtable<String,Mama> ht;
	
	public Lactario() {
		
		ht = new Hashtable<String,Mama>();
		listaHijos = new ListaDoblementeEnlazada<Hijo>();
		
		LectorArchivo lector = new LectorArchivo();
        lector.leerArchivo(abo, listaHijos, ht );
		
	}
	
	public ArbolAVL getAbo() {
		return abo;
	}

	public boolean agregar_mama(String id, String nombre,
			   int edad, Fecha fecha, ListaDoblementeEnlazada<Hijo> hijos) throws Exception {
		Mama mama =null;
		mama = buscarMama(id);
		if(mama == null){
			//Agrega un registro mujer al árbol
			abo.insertar(new Mama(id, nombre,edad,fecha,hijos));
			//Agrega un registro mujer a la Tabla Hash
			ht.put(id, new Mama(id,nombre,edad,fecha,hijos));
			return true;

		}
		return false;
	
	}

	public Mama buscarMama(String id){
		return ht.get(id);
		
	}
	public Hijo buscaHijo(String id )throws PosicionIlegalException {
		for (int i=0; i<listaHijos.getTamanio(); i++){
			if (listaHijos.getValor(i).getId().equals(id)){
				return listaHijos.getValor(i);
			}
		}
		return null;
		
	}

	public boolean agregar_hijos(String Id, String nombre, int edadMeses, int edadDias, Fecha fecha, String idMama, String nombreMama	) {
		listaHijos.agregar(new Hijo(Id,nombre,edadMeses, edadDias,fecha, idMama));
		return true;
	}

	//filtra los hijos por el id de la madre
	public ListaDoblementeEnlazada<Hijo> getHijos(String idMadre) throws PosicionIlegalException {
		ListaDoblementeEnlazada<Hijo> hijos = new ListaDoblementeEnlazada<Hijo>();
		hijos.limpiar();
		for(int i=0; i<listaHijos.getTamanio(); i++){
			if(listaHijos.getValor(i).getIdMama().equals(idMadre)){
				hijos.agregar(listaHijos.getValor(i));
			}
		}
		return hijos;
	}

	//devuelve una lista de mamas por una parte del nombre a partir de la hashTable
	public ListaDoblementeEnlazada<Mama> buscarMamaPorNombreParcial(String nombre) throws Exception{
		ListaDoblementeEnlazada<Mama> mamas = new ListaDoblementeEnlazada<Mama>();
		mamas.limpiar();
		String aux;
		Enumeration<String>  keys = ht.keys();
		while(keys.hasMoreElements()){
			aux = keys.nextElement();
			Mama mama = ht.get(aux);
			if (mama.getNombre().toLowerCase().contains(nombre.toLowerCase())) {

			   mamas.agregar(mama);
			}


			
		}
		
		
		return mamas;
	}

	//elimina del árbol AVL y de la tabla Hash
	public boolean eliminar_mama(String id) throws Exception{
		Mama mama= buscarMama(id);
		if(mama != null){
			abo.eliminar(mama);
			ht.remove(id);
			
			return true;
		}else{	
			return false;
		}

	}

	//elimina de la lista de hijos
	public boolean eliminar_hijo(String id) throws PosicionIlegalException{
		for(int i=0; i<listaHijos.getTamanio(); i++){
			if(listaHijos.getValor(i).getId().equals(id)){
				listaHijos.remover(i);
				return true;
			}
		}
		return false;

	}

	//elimina de la lista de hijos por el id de la madre
	public boolean eliminar_hijo_mama(String idMama) throws PosicionIlegalException{
		int eliminados =0;
		for(int i=0; i<listaHijos.getTamanio(); i++){
			if(listaHijos.getValor(i).getIdMama().equals(idMama)){
				listaHijos.remover(i);
				eliminados++;
				
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
		Nodo n = abo.buscar(new Mama(id, nombre, edad,fecha));
		if (n != null) {
			return (Mama) n.getValor();
		} else {
			return null;
		}
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
		
	
	





