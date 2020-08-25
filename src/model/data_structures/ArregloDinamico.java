package model.data_structures;


/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>>  implements IArregloDinamico<T>  {
	/** 
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */

	@SuppressWarnings("unchecked")
	public ArregloDinamico(int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {
		return elementos[i];
	}
	
	@SuppressWarnings("unchecked")
	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[])new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	@SuppressWarnings("unchecked")
	public void insertElement(T element, int pos) {
		--pos;
		T[] nuevo= (T[]) new Comparable[tamanoAct+1];
		boolean encontre=false;
		for (int i = 0; i < nuevo.length; ++i) {
			if(!encontre && i!=pos) {
				nuevo[i]=elementos[i];
			}else if(!encontre && i==pos) {
				nuevo[i]=element;
				encontre=true;
			}else {
				nuevo[i]=elementos[i-1];
			}
		}
		elementos=nuevo;
		++tamanoAct;
	}

	public T removeLast() {
		T este=elementos[tamanoAct];
		elementos[tamanoAct-1]=null;
		tamanoAct--;
		return este;
	}

	public T lastElement() {
		return elementos[tamanoAct-1];
	}

	public int isPresent(T element) {
		for(int i=0; i<tamanoAct;i++) {
			if(elementos[i].compareTo(element)==0)
				return i+1;
		}
		return -1;
	}

	public void changeInfo(int pos, T element) {
		--pos;
		elementos[pos]=element;
	}
	public void addFirst( T dato )
	{
		if ( tamanoAct == tamanoMax )
			// caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;

		T [ ] copia = elementos;
		elementos = (T[])new Comparable[tamanoMax];
		//a�ade el dato en primera casilla
		elementos[0] = dato;

		for ( int i = 0; i < tamanoAct; ++i)
		{
			elementos[i+1] = copia[i];
		} 

		tamanoAct++;
	}
	public void exchange(int pos1, int pos2 )
	{
		--pos1;
		--pos2;
		T temp = elementos[pos1];
		elementos[pos1] = elementos[pos2];
		elementos[pos2] = temp;
	}
	public T removeFirst() {
		T primer = firstElement();
		for(int i =1; i< tamanoAct; ++i)
		{
			elementos[i-1] = elementos[i]; 
			// Si el elemento a mover es el ultimo se convierte en null.
		}
		elementos[tamanoAct-1] = null;	
		--tamanoAct;
		return primer;
	}
	public boolean isEmpty()
	{
		return (tamanoAct==0)?true:false;
	}
	public T firstElement()
	{
		return elementos[0];
	}
}
