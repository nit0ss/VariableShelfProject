package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BottomShelve {

	private final double zAxis = 20.0;
	protected static final double width = 5;
	private double totalLength;
	private final double shelveLength;

	public BottomShelve(double totalLength, double shelveLength) {
		this.totalLength = totalLength;
		this.shelveLength = shelveLength;
	}

	public  String getObjVector() {

		String result = "\n";
		
		//8 vertex 8 duples
		double x1 = 0.00 ;
		double y1 = width;
		double z1 = zAxis;

		double x2 = 0.00;
		double y2 = width;
		double z2 = 0.00;

		double x3 = shelveLength+LateralPlates.width;
		double y3 = width;
		double z3 = 0.00;

		double x4 = shelveLength+LateralPlates.width;
		double y4 = width;
		double z4 = zAxis;

		double x5 = 0.00;
		double y5 = 0.00;
		double z5 = zAxis;

		double x6 = 0.00;
		double y6 = 0.00;
		double z6 = 0.00;

		double x7 = shelveLength+LateralPlates.width;
		double y7 = 0.00;
		double z7 = 0.00;

		double x8 = shelveLength+LateralPlates.width;
		double y8 = 0.00;
		double z8 = zAxis;
		
		result += "\n#Vertex for BottomShelve\n";
		result += "v " + x1 + " " + y1 + " " + z1 + "\n";
        result += "v " + x2 + " " + y2 + " " + z2 + "\n";
        result += "v " + x3 + " " + y3 + " " + z3 + "\n";
        result += "v " + x4 + " " + y4 + " " + z4 + "\n";
        result += "v " + x5 + " " + y5 + " " + z5 + "\n";
        result += "v " + x6 + " " + y6 + " " + z6 + "\n";
        result += "v " + x7 + " " + y7 + " " + z7 + "\n";
        result += "v " + x8 + " " + y8 + " " + z8 + "\n";
        
		// Define the face indices for the cube
        int face1v1 = 9, face1v2 = 10, face1v3 = 11, face1v4 = 12;
        int face2v1 = 13, face2v2 = 14, face2v3 = 15, face2v4 = 16;
        int face3v1 = 9, face3v2 = 10, face3v3 = 14, face3v4 = 13;
        int face4v1 = 10, face4v2 = 11, face4v3 = 15, face4v4 = 14;
        int face5v1 = 11, face5v2 = 12, face5v3 = 16, face5v4 = 15;
        int face6v1 = 9, face6v2 = 12, face6v3 = 16, face6v4 = 13;

		// Append the face indices to the result string
        result += "\n#Faces for BottomShelve\n";
		result += "f " + face1v1 + " " + face1v2 + " " + face1v3 + " " + face1v4 + "\n";
		result += "f " + face2v1 + " " + face2v2 + " " + face2v3 + " " + face2v4 + "\n";
		result += "f " + face3v1 + " " + face3v2 + " " + face3v3 + " " + face3v4 + "\n";
		result += "f " + face4v1 + " " + face4v2 + " " + face4v3 + " " + face4v4 + "\n";
		result += "f " + face5v1 + " " + face5v2 + " " + face5v3 + " " + face5v4 + "\n";
		result += "f " + face6v1 + " " + face6v2 + " " + face6v3 + " " + face6v4 + "\n";


		System.out.println("Created Bottom Shelve with the coordinates :\n" + result);
		return result;
	}
}