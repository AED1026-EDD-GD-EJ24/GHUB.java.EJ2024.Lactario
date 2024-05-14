
package datos;


import listaDoble.ListaDoblementeEnlazada;
import arbolAVL.Comparable;

// implemente la clase Mama como Comparable
public class Mama {
	
	
	private String id;
	private String nombre;
	private int edad;
	private Fecha fechaNacimiento;
	//Se agrego un atributo Lista para que guarde a los hijos
	private ListaDoblementeEnlazada<Hijo> hijos;
	
	
	public Mama(String id, String nombre, int edad, Fecha fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento=fechaNacimiento;
		
	}
	
	public Mama(String id, String nombre, int edad, Fecha fechaNacimiento, ListaDoblementeEnlazada<Hijo> hijos) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento=fechaNacimiento;
		this.hijos=hijos;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public ListaDoblementeEnlazada<Hijo> getHijos() {
		return hijos;
	}
	public void setHijos(ListaDoblementeEnlazada<Hijo> hijos) {
		this.hijos = hijos;
	}
	

	@Override
	public String toString() {
		//return  "Id:"+id + "," + nombre +","+edad+" anios,"+"Fecha:"+fechaNacimiento ;
	    return id+"-"+nombre;
	}
	
	
}
