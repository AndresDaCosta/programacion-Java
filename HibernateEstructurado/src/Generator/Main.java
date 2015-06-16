package Generator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean salir = false;
		do {
			System.out.println("system conect ");
			System.out.println("Bienvenido al menu de empleado");
			System.out.println(""
					+ "	***************************************************************	"+"\n"
					+ "				MENU DE SERVICIOS DE EMPLEADO						"+"\n"
					+ "		marque un numero para seleccionar la opcion que desea		"+"\n"
					+ "																	"+"\n"
					+ "		1- aumento de sueldo un 20%	.								"+"\n"
					+ "		2- mostrar empleadoas que mas cobran por departamento.		"+"\n"
					+ "		3- mostrar todos los empleados de cada departamento.		"+"\n"
					+ "		4- bajar el sueldo con porcentaje seleccionado.				"+"\n"
					+ "		5- salir 													"+"\n"
					+ "	*************************************************************** ");
					
			
			EmpleadoServicios empleadoservicios = new EmpleadoServicios();
			Scanner in = new Scanner(System.in);
			int numero = in.nextInt();
			switch (numero) {
			case 1:
				System.out.println("Has seleccionado aumento de suledo del 20%");
				empleadoservicios.incrementarsalarios();
				break;
			case 2:
				System.out.println("Has seleccionado mostrar el empleado que mas cobra de cada departamento");
				empleadoservicios.maximoempleado();
				break;
			case 3:
				System.out.println("Has seleccionado que se muestre todos los empleados de un departamento");
				empleadoservicios.empleadosDep();
				break;
			case 4:
				System.out.println("has seleccionado bajar los sueldos");
				empleadoservicios.bajarsueldos();
			case 5:
				System.out.println("se va a salir del programa ");
				salir = true;
				
				
			default:
				System.out.println("system disconect");
				
				break;
			}	
		} while (salir == false);
		
		
		
		
		
	}

	
		
}
