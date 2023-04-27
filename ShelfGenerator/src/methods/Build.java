package methods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Build {

	public static void build() throws IOException {
		try {

			PrintWriter pw = new PrintWriter("salida.txt", "UTF-8");
			/*
			 * 
			 * AQUI VA LA MATEMATICA VECTORIAL
			 * 
			 * 
			 * 
			 * */

		} catch (FileNotFoundException e) {
			System.out.println("------------------------");
			System.out.println("Archivo no encontrado!");
			System.out.println("------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}