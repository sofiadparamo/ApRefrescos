public class Dinero{
	
	private int denominacion;
	private String nombre;
	private int cantidad;
	
	public Dinero(String nombre, int denominacion,int cantidad){
		this.nombre=nombre;
		this.denominacion=denominacion;
		this.cantidad=cantidad;
	}
	
	public void setDenominacion(int denominacion){
		this.denominacion=denominacion;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public int getDenominacion(){
		return denominacion;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getCantidad(){
		return cantidad;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad=cantidad;
	}	
	
}