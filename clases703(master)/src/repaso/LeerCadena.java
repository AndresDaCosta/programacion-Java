package repaso;

import java.util.Scanner;

public class LeerCadena {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("introduce la cadena para analizar: ");		
		System.out.println("introduce el caracter para analizar en la cadena: ");
			String cadena = in.next();
			char caracter = in.next().charAt(0);
			/*tambien se puede implementar System.in.read */
		int i = 0;
		boolean comprobacion = false;
		/*declaro un boolean para que el bucle pare*/
		do {
			if (cadena.charAt(i) == caracter){
				System.out.println("el caracter pertenece a la cadena");
				comprobacion = true;
			}
				else{
					System.out.println("el caracter no pertenece a la cadena");
				}
			
		} while (comprobacion = false);
		/*declaro un bucle do-while */
	}
	
	
	
}
