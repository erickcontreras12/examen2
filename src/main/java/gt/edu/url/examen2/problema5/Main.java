package gt.edu.url.examen2.problema5;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicStack<String> lista = new DynamicStack<String>();
		
		lista.push("a");
		lista.push("b");
		lista.push("c");
		lista.pop();
		lista.push("d");
		
		System.out.println(lista.top());
		
		System.out.println("\nListado");
		System.out.println("=============");
		do {
			System.out.println(lista.pop());
		}while(!lista.isEmpty());
	}

}
