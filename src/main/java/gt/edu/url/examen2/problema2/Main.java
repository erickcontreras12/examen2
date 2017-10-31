package gt.edu.url.examen2.problema2;

public class Main {

	public static void main(String[] args) {
		DemostracionLista lista = new DemostracionLista();
		List<Integer> dem = lista.crearDemoLista();
		
		Integer imp = 0;
		do {
			imp = dem.remove(0);
			System.out.println(imp);
		}while(!dem.isEmpty());
		
	}

}
