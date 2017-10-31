# examen2
Espacio resolucion examen 2

Documentacion
--------------
--------------


Problema No. 2
----------------
El problema 2 consistia en crear una lista de tipo ArrayList, es decir una estructura dinamica (aunque poco eficiente) que contiene un 
arreglo de cierto tipo de elemento que al llegar al tope de su capacidad, esta última es reasignada para poder hacer un arreglo 
autoincrementable. Con la interfaz DemoList se creo una clase que llamará al método que crea una lista de la siguiente manera:

    public List<Integer> crearDemoLista() {
		  listaarr<Integer> aux = new listaarr<Integer>(); 
		  aux.add(0, 4);
		  aux.add(0, 3);
		  aux.add(0, 2);
		  aux.add(2, 1);
		  aux.add(1, 5);
		  aux.add(1, 6);
		  aux.add(3, 7);
		  aux.add(0, 8);
		  return aux;
	  }

Por lo que al final al correr el programa e imprimir la lista queda de la siguiente manera:

![](https://image.ibb.co/gg6bfm/Problema2.png)




Problema No. 3
----------------
El tercer problema consistia en la implementación de un método denominado "swap" que recibiera como paramétros dos posiciones de
referencia de una lista e intercambiara los valores de las dos posiciones sin modificar la dirección de memoria a la que apuntaban ambas
posiciones. Para esto se implemento el método "set" propio de una lista posicional, en el que obtuvimos el valor que antes poseia la primera posicion a cambiar para luego asignarla a la segunda posicion.


    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
	      E answer = node.getElement();
        node.setElement(e);
	      return answer;
     }

    public void swap(Position<E> p, Position<E> q) {
		  E aux = null;
		  aux = set(p, validate(q).getElement());
		  set(q, aux);
	  }

La lista inicialmente tiene las valores de: a, b, c y d. En ese orden respectivo y utilizando las posiciones que apuntan  a los valores 'a' y 'b se hace el respectivo cambio, haciendo que al imprimir la lista la letra b aparezca en el lugar que ocupaba a, y la letra a el lugar que ocupada b.
![](https://image.ibb.co/mgFrD6/Problema3.png)





Problema No. 4
----------------
El problema 4 de igual forma implementaba una lista posicional en la que se agregaba un método denominado "positionAtIndex" que recibe
como paramétro un número que representaría un lugar de la lista y el método devuelve como resultado la posicion que apunta al indice 
ingresado. Ya que una lista posicional funciona por referencia y no por indices, utilizo un contador que inicia la cuenta desde 0 y 
aumenta de secuencial hasta que llegue a la posicion del indice deseado; De manera que el contador avanza el nodo temporal va cambiando,
apuntando hacia el siguiente valor de la lista.

    public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException{
		  int index = 0;
		  Node<E> temp = validate(first());
		  if(i == 0) {
			  return position(temp);
		  }else if(i < size){
			  while(index!= (i-1)){
				index++;
				temp = temp.getNext();
			  };
		  }else if(i > size) {
			  throw new IndexOutOfBoundsException();
		  }
		  return position(temp);
	  }
    
En este caso particular, dentro de la clase Main.java se implementa la lista posicional y se agregan los elementos a, b, c y d. Al 
probar el método usando como indice 2, el contador llega hasta el indice ingresado menos 1, ya que el programa empieza a contar desde 0
asi que apuntando al indice 2, el valor que se imprime al compilar es el de la letra 'b'.
![](https://image.ibb.co/dcgnmR/Problema4.png)




Problema No. 5
----------------
El problema 5 consistia en implementar una estructura de datos dinamica con la disciplina de una pila. Por lo que utilice una lista doblemente enlazada que implementaba la interfaz Stack para tener los métodos de una pila.

![](https://image.ibb.co/bLHSmR/Problema5.png)
