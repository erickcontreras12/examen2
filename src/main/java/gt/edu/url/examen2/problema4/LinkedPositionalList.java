package gt.edu.url.examen2.problema4;


public class LinkedPositionalList<E> implements PositionalList<E>{
	/**
	 * 
	 * @author Erick Contreras
	 *
	 * Clase estatica para usarse, en una lista enlazada
	 *
	 * @param <E> Clase que funciona con cualquier tipo de objeto
	 */
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;// Anterior
		private Node<E> next;// Siguiente

		
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
		public E getElement() throws IllegalStateException {
			if (next == null) // Nodo no valido
				throw new IllegalStateException("Posicion invalida");
			return element;
		}
		
		public void setElement(E e) {
			element = e;
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
    
    private int size;
    private Node<E> header;
    private Node<E> trailer;
    
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
	if (!(p instanceof Node)){
		throw new IllegalArgumentException("P invalido");
        }
	Node<E> node = (Node<E>) p;
	if (node.getNext() == null){
		throw new IllegalArgumentException("p ya no se encuentra en la lista");
        }
	return node;
    }
    
    private Position<E> position(Node<E> node) {
	if (node == header || node == trailer){
            return null;
        }
	return node;
	}
    
    public LinkedPositionalList(){
        size = 0;
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.setNext(trailer);
    }
    
    
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    
    @Override
    public Position<E> first(){
        return position(header.getNext());
    }
    
    @Override
    public Position<E> last(){
        return position(trailer.getPrev());
    }
       
    public Position<E> addBetween(E e, Node<E> pred, Node<E> suc){
        Node<E> newest = new Node(e,pred,suc);
        pred.setNext(newest);
        suc.setPrev(newest);
        size++;
        return newest;
    }
    
    @Override
    public Position<E> addFirst(E e){
        return addBetween(e, header, header.getNext());
    }
        
    @Override
    public Position<E> addLast(E e){
            return addBetween(e, trailer.getPrev(), trailer);
    }
       
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
	Node<E> node = validate(p);
	return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
	Node<E> node = validate(p);
	return position(node.getNext());
    }
        
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
	return addBetween(e, node.getPrev(), node);
    }
	
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
        Node<E> node = validate(p);
	return addBetween(e, node, node.getNext());
    }
        
    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
	E answer = node.getElement();
        node.setElement(e);
	return answer;
    }
        
    @Override
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
	Node<E> predecessor = node.getPrev();
	Node<E> successor = node.getNext();
	predecessor.setNext(successor);
	successor.setPrev(predecessor);
	size--;
	E answer = node.getElement();
	node.setElement(null);
	node.setNext(null);
	node.setPrev(null);
	return answer;
    }
    
    public E removeFirst() {
    	if(header.getNext() == null) {
    		return null;
    	}else {
    		return remove(header.getNext());
    	}
    	
    }

	@Override
	/**
	 * Metodo que recibe como parametro un indice y con un contador busca el 
	 * nodo contenido en ese indice y devuelve el valor de la posicion
	 */
	public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException{
		int index = 0;
		Node<E> temp = validate(first());
		if(i == 0) {
			return position(temp);
		}else if(i < size){
			//Por si esta adelante
			while(index!= (i-1)){
				index++;
				temp = temp.getNext();
				
			};
		}else if(i > size) {
			throw new IndexOutOfBoundsException();
		}
		
		
		return position(temp);
	}
}
