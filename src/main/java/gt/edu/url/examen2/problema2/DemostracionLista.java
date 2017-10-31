package gt.edu.url.examen2.problema2;

public class DemostracionLista implements DemoList{

	@Override
	/**
	 * Metodo que crea una lista con la siguiente sucesion de numeros
	 * 8,2,6,5,7,3,1,4
	 */
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

}
