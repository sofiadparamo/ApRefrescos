import java.util.Scanner;
public class ApRefrescos{
	
	private static final int opcioncredito=9;
	
	
	public static void main(String[] args){
		int op,op1;
		boolean salir=false;
		Scanner leer=new Scanner(System.in);
		//EJEMPLO DE SOBRECARGA DE CONSTRUCTOR
		Stock miStock,miStockVacio;
		miStock=new Stock();
		miStock.llenarRieles(); 
		miStockVacio= new Stock(8,10,50,4);
	
		do
		{	
			if(!miStock.consularEstado()){
				System.out.println("Maquina fuera de servicio");
				op=leer.nextInt();
				if(op==25565){
					System.out.println("\n\tSeleccione opción\n\t1.-Mostrar stock\n\t2.-Rellenar stock\n\t3.-Mostrar monedas\n\t4.-Modo debug\n\t5.-Configuración inicial\n\t6.-Apagar maquina");
					System.out.print("Opción: ");
					op1=leer.nextInt();
					System.out.println();
					switch(op1){
						case 1:
							miStock.mostrarStock();
							System.out.println("Regresando al menú principal...\n");
							break;
						case 2:
							miStock.llenarRieles();
							System.out.println("Regresando al menú principal...\n");
							break;
						case 3:
							miStock.mostrarMonedas();
							System.out.println("Regresando al menú principal...\n");
							break;
						case 4:
							if(!miStock.getDebugProfile())miStock.setDebugProfile(true);
							else miStock.setDebugProfile(false);
							break;
						case 6:
							salir=true;
							System.out.println("Apagando maquina");
							break;
						default:
							System.out.println("Opción no valida");
					}
				}
			} else {
				miStock.mostrarPrecio();
				System.out.print("Producto: ");
				op=leer.nextInt();
				if(op==25565){
					System.out.println("\n\tSeleccione opción\n\t1.-Mostrar stock\n\t2.-Rellenar stock\n\t3.-Mostrar monedas\n\t4.-Modo debug\n\t5.-Configuración inicial\n\t6.-Apagar maquina");
					System.out.print("Opción: ");
					op1=leer.nextInt();
					System.out.println();
					switch(op1){
						case 1:
							miStock.mostrarStock();
							System.out.println("Regresando al menú principal...\n");
							break;
						case 2:
							miStock.llenarRieles();
							System.out.println("Regresando al menú principal...\n");
							break;
						case 3:
							miStock.mostrarMonedas();
							System.out.println("Regresando al menú principal...\n");
							break;
						case 4:
							if(!miStock.getDebugProfile())miStock.setDebugProfile(true);
							else miStock.setDebugProfile(false);
							break;
						case 6:
							salir=true;
							System.out.println("Apagando maquina");
							break;
						default:
							System.out.println("Opción no valida");
					}
				} else if(op>=1 && op<=miStock.getMaxProductos()){
					
					if(miStock.getCredito()>0){
						
						//Usando credito
						
						if(miStock.despachar(op-1)){
							if(!miStock.usarCredito(op-1)){
								System.out.println("\nCredito insuficiente\n");
							} else {
								System.out.println("\nSe ha despachado correctamente 1 "+miStock.getNombreRefresco(op-1));
							}
						} else {
							System.out.println("\nProducto agotado\n");
						}
						
					} else {
						
						//Sin usar credito
						
						if(miStock.despachar(op-1)){
							if(!miStock.cobrar(op-1)){
								System.out.println("\nOperación cancelada\n");
							}
						} else {
							System.out.println("\nProducto agotado\n");
						}
					}				
				} else if(op==opcioncredito) { 
					miStock.cobrar(false);
				} else {
					System.out.println("\nProducto no existente\n");
				}
			}
		}while(!salir);
		
		
	}

}