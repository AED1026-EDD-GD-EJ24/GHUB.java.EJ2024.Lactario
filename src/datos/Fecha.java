package datos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
	private Integer dia; //se cambia de int a Integer para poder asignar null
	private Integer mes; //se cambia de int a Integer para poder asignar null
	private Integer anio; //se cambia de int a Integer para poder asignar null
	public Fecha(String s) {
		//buscamos la primera ocurrencia
		int pos1 = s.indexOf('/');
		//buscamos la ultima ocurrencia
		int pos2 = s.lastIndexOf('/');
		//Procesamos el dia
		String sDia = s.substring(0,pos1);
		dia = Integer.parseInt(sDia);
		//Procesamos el mes
		String sMes = s.substring(pos1+1,pos2);
		mes = Integer.parseInt(sMes);
		//Procesamos el anio
		String sAnio=s.substring(pos2+1);
		anio = Integer.parseInt(sAnio);
	}
	public Fecha() {
		this.dia = null;//1;
		this.mes = null;//1;
		this.anio = null;//2000;
		
	}
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Fecha obtenerFechaSistema() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        String fechaFormateada = fechaActual.format(formatter);
		return new Fecha(fechaFormateada);
		
    }
	public int calcularEdadMeses(Fecha fechaNacimiento) {
		int edadMeses = 0;
		//Calculamos la edad en meses
		edadMeses = (this.anio - fechaNacimiento.anio) * 12;
		edadMeses += this.mes - fechaNacimiento.mes;
		//Si el dia de nacimiento es mayor al dia actual
		if (this.dia < fechaNacimiento.dia) {
			edadMeses--;
		}
		return edadMeses;
	}
	public int calcularEdadDias(Fecha fechaNacimiento) {
		
		int edadDias = 0;
		//Calculamos la edad en dias
		edadDias = (this.anio - fechaNacimiento.anio) * 365;
		edadDias += (this.mes - fechaNacimiento.mes) * 30;
		edadDias += this.dia - fechaNacimiento.dia;
		return edadDias;
	}
	@Override
	public String toString() {
		//return "Fecha [dia=" + dia + ", mes=" + mes + ", anio=" + anio + "]";
		return dia+"/"+mes+"/"+anio;
	}
	
	
	
	
	

}
