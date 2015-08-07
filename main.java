import java.util.Scanner;
/**
 * Universidad del valle de Guatemala
 * @author Freddy Ruíz 14592/ Pedro Joaquí 14224 /Cristopher Chiroy 14411 /Boris Cifuentes 14150
 * 
 * 
 * Clase: Main
 * Está destinada para la interacción del usuario con los tipos de ordenamientos
 */

public class main {
	public static void main(String args[]){
		Ordenamientos gen = new Ordenamientos(10, 9);
		Scanner teclado = new Scanner(System.in);
		gen.generar();
		System.out.println("Ingrese el tipo de ordenamiento: \n1. Selection \n2. Quick \n3. Insertion \n4. Merge \n0. Salir");
		int opcion=teclado.nextInt();
		while (opcion!=0){
			if(opcion==1){
				gen.leer();
				gen.ordenSelection();
				gen.imprimir("Selection");
			}
			else if(opcion==2){
				gen.leer();
				gen.quickSort(0, 9);
				gen.imprimir("Quick");
			}
			
			else if(opcion==3){
				gen.leer();
				gen.ordenInsertion();
				gen.imprimir("Insertion");
			}
			else if(opcion==4){
				gen.leer();
				gen.ordenamientoMergeSort();
				gen.imprimir("Merge");
			}
			
			else{
				System.out.println("Opcion no valida");
			}
			System.out.println();
			System.out.println("Ingrese el tipo de ordenamiento: \n1. Selection \n2. Quick \n3. Insertion \n0. Salir");
			opcion = teclado.nextInt();
		}
	}
}
