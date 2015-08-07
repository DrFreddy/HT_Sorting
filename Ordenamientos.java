import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Universidad del valle de Guatemala
  * Algoritmos y Estructura de Datos 
 * Seccion 10 
 * @author Freddy Ruíz 14592/ Pedro Joaquí 14224 /Cristopher Chiroy 14411 /Boris Cifuentes 14150
 * 
 * Clase: Ordanemiento
 * Está clase contiene todos los tipos de ordenamientos y cada uno de sus métodos.
 */
public class Ordenamientos {
	private int valor;
	private int repeticiones;
	private int[] arreglo;
	
	public Ordenamientos(int repeticiones, int valor){
		
		this.valor = valor;
		this.repeticiones = repeticiones;
		arreglo = new int[repeticiones];
	}
	
	/**
	 * @Genera numeros aleatorios para rellenar el arreglo que se ordenara posteriormente 
	 */
	public int aleatorio(){
		int num = 0;
		Random ran = new Random();
		num=ran.nextInt(valor+1);
		return num;
	}
	
	/**
	 * Llena el archivo de texto con los numeros desordenados
	 */
	public void generar(){
		int cont=0;
		for(int i=0;i<repeticiones; i++){
			try{
				cont++;
				
				File archivo=new File("src/texto.txt");
				FileWriter escribir=new FileWriter(archivo,true);
				escribir.write(aleatorio()+" ");
				escribir.close();
			}
			catch(Exception e){
				System.out.println("Error al escribir");
			}
			
		}
		
	}
	
	/**
	 * Se obtienen los datos del archivo de texto para rellenar el arreglo a ordenar
	 */
	public void leer(){
		String datos="";
		
		try{
			FileReader lector=new FileReader("src/texto.txt");
			BufferedReader contenido=new BufferedReader(lector);
			while((datos=contenido.readLine())!=null){
				System.out.println(datos);
				for(int i=0; i<datos.length(); i+=2){
					arreglo[i/2]=Integer.parseInt(datos.charAt(i)+"");
				}
			}
			
			
		}
		catch(Exception e){
			System.out.println("Error al leer");
		}

	}
	
	/**
	 * Ordena los numeros del arreglo mediante el metodo selection sort
	 */
	public void ordenSelection(){
		int recorridos = 0;
		int posicion = 0;
		int largo = arreglo.length;
		int n1, n2, n3, n4;
		
		while(recorridos<(largo)){
			n1=arreglo[recorridos];
			n4=n1;
			n3=recorridos;
			for(posicion=recorridos; posicion<largo-1; posicion++){
				n2=arreglo[posicion+1];
				
				if(n1>=n2){
					n1=n2;
					n3 = posicion+1;
				}
			}
			arreglo[recorridos]=n1;
			arreglo[n3]=n4;
			recorridos++;
		}
		
		System.out.println();
	}
	
	/**
* Método: partida
* Funcionalidad:
* Este método es el encargado de "dividir" la lista en 2. Del lado izquierdo al pivote estarán
* los números menores a el y del lado derecho del pivote estarán los números mayores a él. Y
* retornará la posición actual del indicador izquierdo.
* @param izq =Posición incial de la lista/der= posición length-1 del array
* @return izq
*/
	public int partida (int izq, int der){
		int pivot=((izq+der)/2);
		int swapVal=0;
		while(izq < der){ 
			while (arreglo[izq] < arreglo[pivot]){ //Si el valor izquierdo es menor que el pivote
				izq++;} //Mueve el puntero izquierdo
		
		   while (arreglo[der] > arreglo[pivot]){ //Si el valor derecho es mayor que el pivote
			   der--; //Mueve el puntero derecho
		   }
		    if (izq <= der){
		    	swapVal=arreglo[izq]; //Guarda en swapVal el valor izquierdo
		    	arreglo[izq]=arreglo[der]; //Almacena en el lugar izquierdo el valor derecho
		    	arreglo[der]=swapVal; //Almacena en el lugar derecho el valor izquierdo
		    	izq++; //Mueve uno la posición izqueirda
		    	der--; //Mueve uno la posición derecha
		    }  
		}
		  return izq;
	}
	/**
* Método: quickSort
* Funcionalidad:
* Después que el método "partida" divida la lista en 2. Y del lado izquierdo al pivote estén los números
* menores a el y a la derecha números mayores a él. Se encargará de realizar el sorting para obtener
* una lista ordenanda de los valores ingresados
* @param izq =Posición incial de la lista/der= posición length-1 del array
**/
	public void quickSort(int izq, int der) {
	    int indice = partida(izq, der);
	    if (izq < indice - 1){
	          quickSort(izq, indice-1);
	    }
	    if (indice < der){
	          quickSort(indice, der);
	    }
	
	}
	public void ordenInsertion(){
		int numerosYaOrdenados=1;
		int index;
		int longitud=arreglo.length;
		while(numerosYaOrdenados<longitud){
			int datotemporal=arreglo[numerosYaOrdenados];
			for (index=numerosYaOrdenados; index>0; index--){
				if(datotemporal<arreglo[index-1]){
					int temp=arreglo[index-1];
					arreglo[index-1]=arreglo[index];
					arreglo[index]=temp;
				}
			}
			numerosYaOrdenados++;
		}
	}
	
/**
	 * Ordena los numeros del arreglo mediante el metodo merge sort
	 */
	public void ordenamientoMergeSort(){
	        int[] tmp = new int[arreglo.length];
	        ordenamientoMergeSort(arreglo, tmp,  0,  arreglo.length - 1);
		}
	/**
	 * @param a
	 * @param tmp
	 * @param izquierda
	 * @param derecho
	 * realiza los cambios de las posiciones del arreglo
	 */
	private void ordenamientoMergeSort(int [ ] a, int [ ] tmp, int izquierda, int derecho){
	        if( izquierda < derecho )
	        {
	                int center = (izquierda + derecho) / 2;
	                ordenamientoMergeSort(a, tmp, izquierda, center);
	                ordenamientoMergeSort(a, tmp, center + 1, derecho);
	                merge(a, tmp, izquierda, center + 1, derecho);
	        }
	}
	/**
	 * @param a
	 * @param tmp
	 * @param izquierda
	 * @param derecho
	 * @param derechoEnd
	 * mueve las posiciones del arreglo para ordenarlo por el metodo merge sort
	 */
	private void merge(int[ ] a, int[ ] tmp, int izquierda, int derecho, int derechoEnd ){
		int izquierdaEnd = derecho - 1;
		int k = izquierda;
		int num = derechoEnd - izquierda + 1;
		
		while(izquierda <= izquierdaEnd && derecho <= derechoEnd)
		    if(a[izquierda]-(a[derecho]) <= 0)
		        tmp[k++] = a[izquierda++];
		    else
		        tmp[k++] = a[derecho++];
		
		while(izquierda <= izquierdaEnd) 
		    tmp[k++] = a[izquierda++];
		
		while(derecho <= derechoEnd)  
		    tmp[k++] = a[derecho++];
		
		for(int i = 0; i < num; i++, derechoEnd--)
		    a[derechoEnd] = tmp[derechoEnd];
	}
	
	/**
	 * @param ordenado
	 * Imprime el arreglo ordenado por cada metodo
	 */
	public void imprimir(String ordenado){
		System.out.println("El arreglo ordenado por "+ordenado+" es asi:");
		for (int i=0; i<arreglo.length;i++){
		    System.out.print(arreglo[i]+" "); 
		    }
		    System.out.println();
	}
	
	
	
}
