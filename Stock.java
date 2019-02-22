import java.util.Scanner;

public class Stock{
	
	private int maxProductos=8;
	private int capacidadRiel=10;
	private int marxMonedas=50;
	private int corte;
	private int tipoMonedas=4;
	private Refresco rieles[]=new Refresco[maxProductos];
	private Dinero monedero[]=new Dinero[tipoMonedas];
	private Dinero ranura[]=new Dinero[tipoMonedas];
	private Dinero cambioBandeja[]=new Dinero[tipoMonedas];
	
	public Stock(){
		rieles[0]=new Refresco("Coca Cola      ",13);
		rieles[1]=new Refresco("Sprite         ",12);
		rieles[2]=new Refresco("Agua Mineral   ",10);
		rieles[3]=new Refresco("Fanta          ",12);
		rieles[4]=new Refresco("Coca Light     ",13);
		rieles[5]=new Refresco("Coca Zero      ",12);
		rieles[6]=new Refresco("Coca sin azucar",10);
		rieles[7]=new Refresco("Limon y nada   ",12);	

		monedero[0]=new Dinero("Un Peso",1,30);
		monedero[1]=new Dinero("Dos pesos",2,20);
		monedero[2]=new Dinero("Cinco pesos",5,20);
		monedero[3]=new Dinero("Diez pesos",10,0);
		
		/*ranura[0]=new Dinero("Un Peso",1,0);
		ranura[1]=new Dinero("Dos pesos",2,0);
		ranura[2]=new Dinero("Cinco pesos",5,0);
		ranura[3]=new Dinero("Diez pesos",10,0);
		
		cambioBandeja[0]=new Dinero("Un Peso",1,0);
		cambioBandeja[1]=new Dinero("Dos pesos",2,0);
		cambioBandeja[2]=new Dinero("Cinco pesos",5,0);
		cambioBandeja[3]=new Dinero("Diez pesos",10,0);*/
		
		for(int i=0; i<tipoMonedas;i++){
		corte += monedero[i].getDenominacion()*monedero[i].getCantidad();
		}
	}
	
	public boolean despachar(int indice){
		
		
		if(rieles[indice].getCant()>0){
			rieles[indice].setCant(rieles[indice].getCant()-1);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean cobrar(int indice){
		Scanner leer = new Scanner(System.in);
		
		int moneda,saldo,deuda;
		
		saldo=0;
		deuda=rieles[indice].getPrecio();
		
		do{
			System.out.println("\nA pagar: "+(deuda-saldo));
			System.out.println("\nSeleccione la moneda a ingresar.");
			for(int i=0; i<tipoMonedas;i++){
				System.out.print((i+1)+") "+monedero[i].getNombre()+"\t");
			}
			System.out.print("5)Cancelar\tOpción: ");
			
			moneda = leer.nextInt();
			
			switch(moneda){
				case 1:
					if(monedero[0].getCantidad()<=marxMonedas)
						saldo+=monedero[0].getDenominacion();
					else
						System.out.println("Monedero lleno, pruebe con otra moneda o cancele la operación.");
					break;
				case 2:
					if(monedero[1].getCantidad()<=marxMonedas)
						saldo+=monedero[1].getDenominacion();
					else
						System.out.println("Monedero lleno, pruebe con otra moneda o cancele la operación.");
					break;
				case 3:
					if(monedero[2].getCantidad()<=marxMonedas)
						saldo+=monedero[2].getDenominacion();
					else
						System.out.println("Monedero lleno, pruebe con otra moneda o cancele la operación.");
					break;
				case 4:
					if(monedero[3].getCantidad()<=marxMonedas)
						saldo+=monedero[3].getDenominacion();
					else
						System.out.println("Monedero lleno, pruebe con otra moneda o cancele la operación.");
					break;
				case 5:
					return false;
				default:
					System.out.println("Moneda no reconocida.");
			}
		}while(saldo<deuda);
		
		return true;
	}
	
	public void darCambio(int indice){
		
	}
	
	/*public boolean despachar(int indice){
		boolean flag;
		if(rieles[indice].getCant()>0){
			flag = true;
			rieles[indice].setCant(rieles[indice].getCant()-1);
			
			if(cobrar(indice)){
				System.out.println("Se ha despachado un "+rieles[indice].getNombre());
				for(int i=0;i<tipoMonedas;i++){
					monedero[i].setCantidad(monedero[i].getCantidad()+ranura[i].getCantidad());
					monedero[i].setCantidad(monedero[i].getCantidad()-cambioBandeja[i].getCantidad());
					ranura[i].setCantidad(0);
				}
			}
			for(int i =0;i<tipoMonedas;i++)
				cambioBandeja[i].setCantidad(0);
			actualizarCorte();
			
		} else {
			flag = false;
		}
		return flag;
	}
	
	public boolean cobrar(int indice){
		Scanner leer = new Scanner(System.in);
		int op,cambio,pago=0,costo = rieles[indice].getPrecio();
		boolean cancelar=false,cambiando;
		boolean cambioSuficiente[]={true,true,true,true};
		int corteLocal=0;
		do{
			System.out.println("Ingrese la moneda que va a insertar\n1)Un peso\t2)Dos pesos\t3)Cinco pesos\t4)Diez pesos\t5)Cancelar operación");
			System.out.print("Moneda: ");
			op = leer.nextInt();
			switch(op){
				case 1:
					ranura[0].setCantidad(ranura[0].getCantidad()+1);
					break;
				case 2:
					ranura[1].setCantidad(ranura[1].getCantidad()+1);
					break;
				case 3:
					ranura[2].setCantidad(ranura[2].getCantidad()+1);
					break;
				case 4:
					ranura[3].setCantidad(ranura[3].getCantidad()+1);
					break;
				case 5:
					System.out.println("Cancelando operación");
					for(int i=0;i<tipoMonedas;i++){
						cambioBandeja[i].setCantidad(ranura[i].getCantidad());
						ranura[i].setCantidad(0);
					}
					cancelar=true;
					break;
				default:
					System.out.print("Error, moneda no aceptada.");
			}
			pago=0;
			for(int i = 0; i<tipoMonedas; i++){
				System.out.println("[FOR] "+pago+", "+ranura[i].getCantidad()+", "+ranura[i].getDenominacion());
				pago+=ranura[i].getCantidad()*ranura[i].getDenominacion();
			}
			
		}while(pago<costo && !cancelar);
		
		System.out.println(pago);
		System.out.println(costo);
		
		cambio=pago-costo;
		
		while(cambio>0){
			cambiando=true;
			
			for(int i=tipoMonedas-1;i>=0;i--){
				
				if(cambio>monedero[i].getDenominacion())
					cambioSuficiente[i]=true;
				else
					cambioSuficiente[i]=false;
			}
			
			
			for(int i=0;i<4;i++){
				System.out.print(cambioSuficiente[i]+"\t");
				if(cambioSuficiente[i]){
					corteLocal+=monedero[i].getCantidad()*monedero[i].getDenominacion();
				}
			}
			
			
			System.out.println(cambio+", "+corteLocal+", "+corte);
			if(cambio>=10 && cambiando && monedero[3].getCantidad()>0){
				cambioBandeja[3].setCantidad(cambioBandeja[3].getCantidad()+1);
				cambio-=10;
				cambiando=false;
			} else if(cambio >=5 && cambiando && monedero[2].getCantidad()>0){
				cambioBandeja[2].setCantidad(cambioBandeja[2].getCantidad()+1);
				cambio-=5;
				cambiando=false;
			} else if(cambio >=2 && cambiando && monedero[1].getCantidad()>0){
				cambioBandeja[1].setCantidad(cambioBandeja[1].getCantidad()+1);
				cambio-=2;
				cambiando=false;
			} else if(cambio >=1 && cambiando && monedero[0].getCantidad()>0){
				cambioBandeja[0].setCantidad(cambioBandeja[0].getCantidad()+1);
				cambio-=1;
				cambiando=false;
			} else if(cambio >=1 && corteLocal<=0){
				
				System.out.println("No hay cambio suficiente, cancelando operacion.");
				cambio=0;
				cancelar=true;
			}
		}
		//Falta reducir cantidad de monedas en mondero segun el cambio, aumentar cantidad de monedas en monderero segun el pago, hacer el caso de que no haya cambio y dar la misma cantidad del pago, de cambio, reiniciar cambio y ranura
		System.out.println("Su cambio es:");
		for(int i=0;i<tipoMonedas;i++)
			System.out.println(cambioBandeja[i].getCantidad() + " monedas de " + cambioBandeja[i].getNombre()+"\n");
		
		return !cancelar;
		
	}*/
	
	public void llenarRieles(){
		for(int i=0;i<maxProductos;i++)
			rieles[i].setCant(capacidadRiel);			
	}
	
	public void mostrarPrecio(){
		System.out.println("\n");
		for(int i=0;i<maxProductos;i++)
			System.out.println((i+1)+")"+rieles[i].getNombre()+" $"+rieles[i].getPrecio());
	}
	
	public void mostrarStock(){
		for(int i=0;i<maxProductos;i++)
			System.out.println((i+1)+")"+rieles[i].getNombre()+" -> "+rieles[i].getCant());
	}	
	
	public void actualizarCorte(){
		corte = 0;
		for(int i=0; i<tipoMonedas;i++){
			corte += monedero[i].getDenominacion()*monedero[i].getCantidad();
		}
	}
	
	public void mostrarMonedas(){
		for(int i=0; i<tipoMonedas;i++){
			System.out.println(monedero[i].getNombre()+":\t"+monedero[i].getCantidad());
		}
		System.out.println("La cantidad total de dinero es: $"+corte);
	}
	
	public int getMaxProductos(){
		return maxProductos;
	}
	
	public void setMaxProductos(int maxProductos){
		this.maxProductos=maxProductos;
	}
	
}








