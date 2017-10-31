package gt.edu.url.examen2.problema3;

public class Main {

	public static void main(String[] args) {
		LinkedPositionalList<String> lista = new LinkedPositionalList<String>();
		Position<String> p0, p1, p2;

		p0 = lista.addFirst("a");
		p1 = lista.addAfter(p0, "b");
		p2 = lista.addAfter(p1, "c");
		p2 = lista.addAfter(p2 , "d");
		
		lista.swap(p0, p1);
		
		System.out.println("Lista");
		System.out.println("-----------------");
		String valor = "";
		do {
			valor = lista.removeFirst();
			System.out.println(valor);
		}while(valor!=null);
		
		
	}

}
