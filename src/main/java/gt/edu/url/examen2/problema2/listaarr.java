package gt.edu.url.examen2.problema2;

import java.util.Iterator;

public class listaarr<E> implements List<E>{
	

	public static final int CAPACITY = 1;
	private int size = 0;
	private E data[];
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo constructor de un ArrayList
	 */
	public listaarr() {
		data = (E[]) new Object[CAPACITY];
	}
	
	@Override
	/**
	 * Metodo que devuelve el tamano del valor
	 */
	public int size() {
		return size;
	}

	@Override
	/**
	 * Metodo que dice que si la lista esta vacia
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	/**
	 * Metodo que devuelve el valor de un indice
	 */
	public E get(int i) {
		checkIndex(i, size);
		return data[i];
	}

	@Override
	/**
	 * Metodo que modifica el valor de un indice especifico de la lista
	 */
	public E set(int i, E e) {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	@Override
	/**
	 * Metodo que agrega en una posicion de la lista
	 */
	public void add(int i, E e) {
		checkIndex(i, size + 1);
		if(size == data.length) {
			resize(2 * data.length);
		}
		for(int k = size - 1; k >= i; k--) {
			data[k+1] = data[k];
		}
		data[i] = e;
		size++;
	}

	@Override
	/**
	 * Metodo que elimina el valor del indice indicado
	 */
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++)
			data[k] = data[k + 1];
		data[size - 1] = null;
		size--;
		return temp;
	}
	
	/**
	 * Metodo que reasigna la capacidad de la lista
	 * @param capacity
	 */
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int k=0; k < size; k++)
			temp[k] = data[k];
		data = temp;
	}
	
	/**
	 * Metodo que verifica la existencia del indice indicado
	 * @param i
	 * @param n
	 * @throws IndexOutOfBoundsException
	 */
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}
}
