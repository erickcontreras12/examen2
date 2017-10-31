package gt.edu.url.examen2.problema4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedPositionalList<String> lista = new LinkedPositionalList();
		Position<String> p0, p1;
		
		p0 = lista.addFirst("a");
		p0 = lista.addAfter(p0, "b");
		p1 = lista.addAfter(p0, "c");
		p1 = lista.addAfter(p1, "d");
		
		System.out.println(p1.getElement());
		
		System.out.println(lista.positionAtIndex(2).getElement());
	}

}
