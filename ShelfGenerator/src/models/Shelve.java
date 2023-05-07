package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Shelve {

	private final double zAxis = 20.0;

	private final double width = 5.0;
	private double totalLength;
	private final double shelveLength;
	private double shelveYPosition;
	private int numberIdShelves = 1;

	public Shelve(double totalLength, double shelveLength, double shelveYPosition, int numberIdShelves) {
		this.totalLength = totalLength;
		this.shelveLength = shelveLength;
		this.shelveYPosition = shelveYPosition;
		this.numberIdShelves += numberIdShelves;
	}

	public double getShelveYPosition() {
		return this.shelveYPosition;
	}

	public String getObjVector() {

		String result = "\n";

		// 8 vertex 8 duples
		double x1 = LateralPlates.width;
		double y1 = shelveYPosition + width;
		double z1 = zAxis;

		double x2 = 0.0;
		double y2 = shelveYPosition + width;
		double z2 = 0.0;

		double x3 = shelveLength;
		double y3 = shelveYPosition + width;
		double z3 = 0.0;

		double x4 = shelveLength;
		double y4 = shelveYPosition + width;
		double z4 = zAxis;

		double x5 = 0.0;
		double y5 = shelveYPosition;
		double z5 = zAxis;

		double x6 = 0.0;
		double y6 = shelveYPosition;
		double z6 = 0.0;

		double x7 = shelveLength;
		double y7 = shelveYPosition;
		double z7 = 0.0;

		double x8 = shelveLength;
		double y8 = shelveYPosition;
		double z8 = zAxis;

		result += "\n#Vertex for Shelve \n";
		result += "v " + x1 + " " + y1 + " " + z1 + "\n";
		result += "v " + x2 + " " + y2 + " " + z2 + "\n";
		result += "v " + x3 + " " + y3 + " " + z3 + "\n";
		result += "v " + x4 + " " + y4 + " " + z4 + "\n";
		result += "v " + x5 + " " + y5 + " " + z5 + "\n";
		result += "v " + x6 + " " + y6 + " " + z6 + "\n";
		result += "v " + x7 + " " + y7 + " " + z7 + "\n";
		result += "v " + x8 + " " + y8 + " " + z8 + "\n";

		// Define the face indices for the cube
		int face1v1 = 33 + 8 * numberIdShelves;    // face1v1 = 41
		int face1v2 = 34 + 8 * numberIdShelves;    // face1v2 = 42
		int face1v3 = 35 + 8 * numberIdShelves;    // face1v3 = 43
		int face1v4 = 36 + 8 * numberIdShelves;    // face1v4 = 44

		int face2v1 = 37 + 8 * numberIdShelves;    // face2v1 = 45
		int face2v2 = 38 + 8 * numberIdShelves;    // face2v2 = 46
		int face2v3 = 39 + 8 * numberIdShelves;    // face2v3 = 47
		int face2v4 = 40 + 8 * numberIdShelves;    // face2v4 = 48

		int face3v1 = 33 + 8 * numberIdShelves;    // face3v1 = 41
		int face3v2 = 34 + 8 * numberIdShelves;    // face3v2 = 42
		int face3v3 = 38 + 8 * numberIdShelves;    // face3v3 = 46
		int face3v4 = 37 + 8 * numberIdShelves;    // face3v4 = 45

		int face4v1 = 34 + 8 * numberIdShelves;    // face4v1 = 42
		int face4v2 = 35 + 8 * numberIdShelves;    // face4v2 = 43
		int face4v3 = 39 + 8 * numberIdShelves;    // face4v3 = 47
		int face4v4 = 38 + 8 * numberIdShelves;    // face4v4 = 46

		int face5v1 = 35 + 8 * numberIdShelves;    // face5v1 = 43
		int face5v2 = 36 + 8 * numberIdShelves;    // face5v2 = 44
		int face5v3 = 40 + 8 * numberIdShelves;    // face5v3 = 48
		int face5v4 = 39 + 8 * numberIdShelves;    // face5v4 = 47

		int face6v1 = 33 + 8 * numberIdShelves;    // face6v1 = 41
		int face6v2 = 36 + 8 * numberIdShelves;    // face6v2 = 44
		int face6v3 = 40 + 8 * numberIdShelves;    // face6v3 = 48
		int face6v4 = 37 + 8 * numberIdShelves;    // face6v4 = 45

		result += "\n#Faces for Shelve \n";
		// Append the face indices to the result string
		result += "f " + face1v1 + " " + face1v2 + " " + face1v3 + " " + face1v4 + "\n";
		result += "f " + face2v1 + " " + face2v2 + " " + face2v3 + " " + face2v4 + "\n";
		result += "f " + face3v1 + " " + face3v2 + " " + face3v3 + " " + face3v4 + "\n";
		result += "f " + face4v1 + " " + face4v2 + " " + face4v3 + " " + face4v4 + "\n";
		result += "f " + face5v1 + " " + face5v2 + " " + face5v3 + " " + face5v4 + "\n";
		result += "f " + face6v1 + " " + face6v2 + " " + face6v3 + " " + face6v4 + "\n";

		System.out.println("Created LateralPlate2 Shelve with the coordinates :\n" + result);
		return result;
	}

}
