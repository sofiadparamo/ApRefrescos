import java.util.Scanner;
public class ApRefrescos{
	
	private static final int opcioncredito=9;
	
	
	public static void main(String[] args){
		int op,op1;
		boolean salir=false;
		Scanner leer=new Scanner(System.in);
		Stock miStock;
		miStock=new Stock();
		miStock.llenarRieles(); 
	
		do
		{	
			if(!miStock.consularEstado()){
				System.out.println("Maquina fuera de servicio");
				op=leer.nextInt();
				if(op==25565){
					System.out.println("\n\tSeleccione opción\n\t1.-Mostrar stock\n\t2.-Rellenar stock\n\t3.-Mostrar monedas\n\t4.-Apagar maquina");
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
					System.out.println("\n\tSeleccione opción\n\t1.-Mostrar stock\n\t2.-Rellenar stock\n\t3.-Mostrar monedas\n\t4.-Apagar maquina");
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
							if(!miStock.cobrarCredito(op-1)){
								System.out.println("\nCredito insuficiente\n");
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
					miStock.credito();
				} else {
					System.out.println("\nProducto no existente\n");
				}
			}
		}while(!salir);
		
		
	}

}