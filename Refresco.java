public class Refresco{
	private int precio;
	private String nombre;
	private int cant;
	
	public Refresco(String nombre, int precio){
		this.nombre=nombre;
		this.precio=precio;
		this.cant=0;
	}

	public void setCant(int cant){
		this.cant=cant;
	}
	public int getCant(){
		return cant;
	}
	public void setPrecio(int precio){
		this.precio=precio;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public int getPrecio(){
		return precio;
	}
	public String getNombre(){
		return nombre;
	}
}