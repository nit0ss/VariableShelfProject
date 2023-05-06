package methods;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import models.Shelf;
import models.TopShelve;

public class Build {

	public void build(Shelf shelf) throws InterruptedException {
		System.out.println("Building " + shelf.toString() + "\n\n\n");
		try {

			TopShelve topShelveOBJ = new TopShelve(shelf.getTotalLength(), shelf.getShelveLength());

			System.out.println("Generating top shelve....\n");
			Thread.sleep(100);
			topShelveOBJ.getObjVector();
			System.out.println("topShelve generated sucessfully ref: " + topShelveOBJ.toString() + "\n\n");

			System.out.println("Generating bottom shelve....\n");
			Thread.sleep(100);

			System.out.println("Generating lateral1 material....\n");
			System.out.println("Generating lateral2 material....\n");
			Thread.sleep(100);

			System.out.println("Calculating separation between shelves....\n");
			shelf.setMinSeparation(shelf.getTotalLength(), shelf.getNumShelves(), shelf.getThickness());
			Thread.sleep(100);
			System.out.println("Separation implemented for the formatting: " + shelf.getMinseparation() + "\n");

			System.out.println("Generating bottom shelve....\n");

		} catch (Exception e) {
			System.out.println("ERROR TRYING TO CREATE THE 3D OBJECT");
			e.printStackTrace();
		}

		String vertexString = "";

		String fileName = "result.txt";

		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(vertexString);
			writer.close();
			System.out.println("Vertex string exported to " + fileName + " successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while exporting the vertex string to " + fileName + ".");
			e.printStackTrace();
		}

		try {
			BufferedWriter txtWriter = new BufferedWriter(new FileWriter("result.obj"));
			txtWriter.write(vertexString);
			txtWriter.close();
			System.out.println("Text file saved as result.obj");
		} catch (IOException e) {
			System.out.println("Error saving text file: " + e.getMessage());
		}
	}

}
