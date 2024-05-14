
package datos;


import listaDoble.ListaDoblementeEnlazada;
import arbolAVL.Comparable;


public class Mama implements Comparable{
	
	
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
	public boolean esMenor(Object q) {
		Mama obj = (Mama)q;
		boolean valor =this.id.compareTo(obj.getId())<0?true:false;
		
		return valor;	
	}
	public boolean esMayor(Object q) {
        Mama obj = (Mama)q;	
		boolean valor =this.id.compareTo(obj.getId())>0?true:false;
		return valor;
	}
	public boolean esIgual(Object q) {
		Mama obj = (Mama)q;	
		boolean valor =this.id.compareTo(obj.getId())==0?true:false;
		return valor;
		
	}
		

	@Override
	public String toString() {
		//return  "Id:"+id + "," + nombre +","+edad+" anios,"+"Fecha:"+fechaNacimiento ;
	    return id+"-"+nombre;
	}
	
	
}
