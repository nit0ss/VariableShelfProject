package builder;

import java.util.Scanner;

import models.Shelf;

public class main {

	public static void main(String[] args) {

		double length;
		int numShelves;
		double shelveWidth;
		int decission;
		// Shelf shelf = new Shelf(200, 7, 75);

		// methods.Build.build(shelf, "rounded");

		Scanner sc = new Scanner(System.in);
		System.out.println("3DM - SHELF GENERATOR - C.STRATU\n");
		System.out.println("------------- MENÚ -------------");

		System.out.print("-> Choose an option: \n");
		System.out.println("1. Create a new Shelf");
		System.out.println("2. Print shelf vectors");
		System.out.println("3. Rules");
		System.out.println("4. Exit");

		System.out.println("--------------------------------");
		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			System.out.println("---------------------------------");
			System.out.println("You have chosen to build a new Shelf.");
			System.out.println("---------------------------------");
			System.out.println("Insert desired length: ");
			length = sc.nextDouble();
			System.out.println("Insert desired number of shelves: ");
			numShelves = sc.nextInt();
			System.out.println("Insert desired width: ");
			shelveWidth = sc.nextDouble();
			System.out.println("Choose \n Symetric (1) \nAsymmetric (2)\n Choice: ");
			decission = sc.nextInt();
			System.out.println("---------------------------------");

			if (length < 0 || numShelves < 0 || shelveWidth < 0) {
				System.out.println("---------------------------------");
				System.out.println("RULE NUMBER 4 BROKEN! \n YOU CANT INTRODUCE NEGATIVE VALUES!!");
				System.out.println("---------------------------------");
			} else {
				try {
					Shelf shelf = new Shelf(length, numShelves, shelveWidth);
					if (decission == 1) {
						methods.Build.build(shelf, "rounded");
					} else {
						methods.Build.build(shelf, "nonsymmetric");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		case 2: System.out.println("----------UNNECCESARY----------"); break;
		case 3:
			System.out.println("---------------------------------");
			System.out.println("RULES:");
			System.out.println(
					"1: Recommended width will be displayed, do not insert more shelves than the ones suggested");
			System.out.println("2: Width and Length Values cant be negative");
			System.out.println("3: You can not choose symettry with an asymetric shelf");
			System.out.println(
					"4: Chosing an asymmetric shelf, will get you special first and last shelves in order to put different objects");
			System.out.println("---------------------------------");
			break;
		case 4:
			System.out.println("BYE!!");
			break;
		default:
			System.out.println("NOT VALID.");
		}
	}
}

/*
 * 
 * System.out.println("You have chosen Print shelf vectors.");
 * System.out.println("---------------------------------"); String fileName =
 * "result.txt"; // Nombre del archivo a leer
 * 
 * try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
 * String line; while ((line = br.readLine()) != null) {
 * System.out.println(line); } } catch (IOException e) {
 * System.out.println("Error al leer el archivo: " + e.getMessage()); }
 * 
 * break;
 * 
 */
