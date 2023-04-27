package builder;

import java.io.IOException;
import java.util.Scanner;

import methods.Build;
public class main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Elija una opcion \n");
		int opcion = sc.nextInt();

		do {
			System.out.println("---- MENÚ ----");
			System.out.println("1. Crear nuevo objeto");
			System.out.println("2. Visualizar objeto");
			System.out.println("3. Ver reglas");
			System.out.println("4. Salir");
			System.out.print("Elige una opción: ");

			switch (opcion) {
			case 1:
				System.out.println("Has elegido crear un nuevo objeto.");
				try {
					Build.build();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("\n Something went wrong! \n");
				}
				break;
			case 2:
				System.out.println("Has elegido visualizar un objeto.");
				
				break;
			case 3:
				System.out.println("Has elegido ver las reglas.");
				
				break;
			case 4:
				System.out.println("Adiós!");
				break;
			default:
				System.out.println("Opción no válida.");
			}

		} while (opcion != 4);
	}

}
