package methods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import models.BackPlate;
import models.BottomShelve;
import models.LateralPlates;
import models.Shelf;
import models.Shelve;
import models.TopShelve;

public class Build {

	public static void build(Shelf shelf, String decissionIn) throws InterruptedException {
		String decission = decissionIn;
		System.out.println("Building " + shelf.toString() + "\n\n\n");
		Shelve shelve;
		String vertexString = "";
		double[] checkpoints = null;
		try {

			System.out.println("Generating top shelve....\n");
			Thread.sleep(1000);
			TopShelve topShelveOBJ = new TopShelve(shelf.getTotalLength(), shelf.getShelveLength());
			vertexString += topShelveOBJ.getObjVector();
			System.out.println("topShelve generated sucessfully ref: " + topShelveOBJ.toString() + "\n\n");

			System.out.println("Generating bottom shelve....\n");
			Thread.sleep(1000);
			BottomShelve bottomShelveOBJ = new BottomShelve(shelf.getTotalLength(), shelf.getShelveLength());
			vertexString += bottomShelveOBJ.getObjVector();
			System.out.println("bottomShelve generated sucessfully ref: " + bottomShelveOBJ.toString() + "\n\n");

			System.out.println("Generating back plate.....\n");
			Thread.sleep(2900);
			BackPlate backPlateOBJ = new BackPlate(shelf.getTotalLength(), shelf.getShelveLength());
			vertexString += backPlateOBJ.getObjVector();
			System.out.println("backPlate generated sucessfully ref: " + backPlateOBJ.toString() + "\n\n");

			System.out.println("Generating lateral materials....\n");
			Thread.sleep(3800);
			LateralPlates lateralPlates = new LateralPlates(shelf.getTotalLength(), shelf.getNumShelves(),
					shelf.getShelveLength(), decission);
			vertexString += lateralPlates.getObjVector1();
			vertexString += lateralPlates.getObjVector2();
			System.out.println("lateralPlates generated sucessfully ref: " + lateralPlates.toString() + "\n\n");

			System.out.println("Calculating separation between shelves....\n");
			Thread.sleep(2000);
			shelf.setMinSeparation(shelf.getTotalLength(), shelf.getNumShelves(), shelf.getThickness());
			Thread.sleep(1000);
			System.out.println("Separation recommended for the formatting: " + shelf.getMinseparation() + "\n\n");

			if (decission.equals("nonsymmetric")) {
				checkpoints = lateralPlates.getCheckpointsNotRounded();
			} 
			
			if(decission.equals("rounded")){
				checkpoints = lateralPlates.getCheckpointsRounded();
			}

			for (int i = 0; i < lateralPlates.getCheckpointsAmmount(); i++) {
				shelve = new Shelve(shelf.getTotalLength(), shelf.getShelveLength(), checkpoints[i], i );
				vertexString += shelve.getObjVector();
			}

			System.out.println("\n\nGenerating all the Shelves models .. .. ..\n\n\n ");
			Thread.sleep(3800);

		} catch (Exception e) {
			System.out.println("ERROR TRYING TO CREATE THE 3D OBJECT");
			e.printStackTrace();
		}

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
