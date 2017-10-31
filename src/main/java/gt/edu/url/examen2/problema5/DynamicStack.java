package gt.edu.url.examen2.problema5;


public class DynamicStack<E> implements Stack<E>{
	
	/**
	 * 
	 * @author Erick Contreras
	 *
	 * Clase estatica para usarse, en una lista enlazada
	 *
	 * @param <E> Clase que funciona con cualquier tipo de objeto
	 */
	private static class Node<E> {
		private E element;
		private Node<E> prev;//Anterior
		private Node<E> next;//Siguiente

		/**
		 * Metodo constructor de nodos
		 * @param e Valor del nodo
		 * @param p Nodo anterior al actual
		 * @param n Nodo siguiente al actual
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		/**
		 * Obtiene el elemento que almacene el Nodo
		 * @return valor
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Obtener el nodo anterior
		 * @return direccion del nodo anterior
		 */
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * Declarar el nodo anterior
		 * @param prev Nodo que estara previo al actual
		 */
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		/**
		 * Obtener el valor del nodo siguiente
		 * @return valor del nodo next
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * Declarar el nodo siguiente
		 * @param next nodo siguiente al actual
		 */
		public void setNext(Node<E> next) {
			this.next = next;
		}

	}

	private Node<E> header = null;//Referencia
	private Node<E> trailer = null;
	private int size = 0;

	/**
	 * Metodo constructor para la clase dinamica que funcione como una
	 * disciplina de pila
	 */
	public DynamicStack() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	/**
	 * Metodo que devuelve el primer valor de la lista
	 * @return valor del siguiente al header
	 */
	public E first() {
		if (isEmpty())
			return null;
		return header.getNext().getElement();
	}

	/**
	 * Metodo que devuelve el ultimo valor de la lista
	 * @return valor del previo al trailer
	 */
	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}

	/**
	 * Metodo que agrega al inicio de la lista
	 * @param e valor que tendra el nodo a crear
	 */
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	/**
	 * Metodo que agrega al fin de la lista
	 * @param e valor que tendra el nodo a crear
	 */
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	/**
	 * Metodo que elimina el primer valor de la lista
	 * @return retorna el valor eliminado
	 */
	public E removeFirst() {
		if (isEmpty())
			return null;
		return remove(header.getNext());
	}
	
	/**
	 * Elimina el ultimo valor de la lista
	 * @return valor eliminado
	 */
	public E removeLast() {
		if (isEmpty())
			return null;
		return remove(trailer.getPrev());
	}
	
	/**
	 * Metodo para agregar en cualquier posicion de la lista
	 * @param e valor del nodo
	 * @param predecessor anterior del nodo actual
	 * @param successor siguiente del nodo actual
	 */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	/**
	 * Metodo para eliminar un valor de la lista
	 * @param node nodo a eliminar
	 * @return nodo eliminado
	 */
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev( );
		Node<E> successor = node.getNext( );
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement( );
	}

	//Metodos implementados de la clase Stack
	
	/**
	 * Metodo que devuelve el tamano de la lista
	 */
	@Override
	public int size() {
		return size;
	}
	
	@Override
	/**
	 * Metodo que devuelve si la lista esta vacia
	 */
	public boolean isEmpty() { 
		return size == 0;
	}
	
	@Override
	/**
	 * Metodo que implementa el metodo push que agrega al final de la lista
	 */
	public void push(E e) {
		// TODO Auto-generated method stub
		this.addLast(e);
	}

	@Override
	/**
	 * Metodo que devuelve el ultimo valor de la lista
	 */
	public E top() {
		// TODO Auto-generated method stub
		return this.last();
	}

	@Override
	/**
	 * Metodo que que implementa pop para eliminar el ultimo valor de la lista
	 */
	public E pop() {
		// TODO Auto-generated method stub
		return this.removeLast();
	}

}
