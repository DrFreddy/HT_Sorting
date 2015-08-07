import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Universidad del valle de Guatemala
 * @author Freddy Ruíz 14592/ Pedro Joaquí 14224 /Cristopher Chiroy 14411 /Boris Cifuentes 14150
 * 
 * 
 * Clase: sortingTest
 * Está destinada para realizar las pruebas JUnit de cada uno de los sorting.
 * Se usará en el documento de texto el siguiente arreglo:
 * Arreglo a utilizar: 34 67 98 23 89 76 65 43 21 0
 * Orden esperado: 0 21 23 35 67 43 64 76 89 98
 */
public class sortingTest1 {

	Ordenamientos sorting= new Ordenamientos(10,9);
    /**
     * Método: ordenSelectionTest()
     * Funcionalidad:
     * Lee del documento de texto la cadena establecida al inicio y
     * realiza el ordenamiento especificado. Despué mediante el método
     * "retornoValores" se revisa en la posición indicada el valor
     * contenido y se verifica que sea el correcto.
     * 
     */
    @Test
	public void ordenSelectionTest() {
    	sorting.leer();
    	sorting.ordenSelection();
    assertEquals(0, sorting.retornoValores(0));
    }
    /**
     * Método: insertionSortTest()
     * Funcionalidad:
     * Lee del documento de texto la cadena establecida al inicio y
     * realiza el ordenamiento especificado. Despué mediante el método
     * "retornoValores" se revisa en la posición indicada el valor
     * contenido y se verifica que sea el correcto.
     * 
     */
    
    @Test
   	public void insertionSortTest() {
    	sorting.leer();
    	sorting.ordenInsertion();
    	assertEquals(0,sorting.retornoValores(0) );

   	}
    /**
     * Método: ordenSelectionTest()
     * Funcionalidad:
     * Lee del documento de texto la cadena establecida al inicio y
     * realiza el ordenamiento especificado. Despué mediante el método
     * "retornoValores" se revisa en la posición indicada el valor
     * contenido y se verifica que sea el correcto.
     * 
     */
    @Test
   	public void quickSortTest() {
       	sorting.leer();
       	sorting.quickSort(0,9);
       assertEquals(0, sorting.retornoValores(0));
       }
 
    /**
     * Método: mergeSort()
     * Funcionalidad:
     * Lee del documento de texto la cadena establecida al inicio y
     * realiza el ordenamiento especificado. Despué mediante el método
     * "retornoValores" se revisa en la posición indicada el valor
     * contenido y se verifica que sea el correcto.
     * 
     */
    @Test
    public void mergeSort(){
    	sorting.leer();
    	sorting.ordenamientoMergeSort();
        assertEquals(0, sorting.retornoValores(0));
    	
    }
}
