package models;

public class BackPlate {

	private final double zAxis = 20.0;

	protected final static double width = 2;
	private double totalLength;
	private final double shelveLength;

	public BackPlate(double totalLength, double shelveLength) {
		this.totalLength = totalLength;
		this.shelveLength = shelveLength;
	}

	public  String getObjVector() {

		String result = "\n";
		
		//8 vertex 8 duples
		double x1 = 0.00;
		double y1 = totalLength;
		double z1 = 0.00;

		double x2 = 0.00;
		double y2 = totalLength;
		double z2 = -width;

		double x3 = shelveLength + LateralPlates.width;
		double y3 = totalLength;
		double z3 = -width;

		double x4 = shelveLength + LateralPlates.width;
		double y4 = totalLength;
		double z4 = 0.00;

		double x5 = 0.00;
		double y5 = 0.00;
		double z5 = 0.00;

		double x6 = 0.00;
		double y6 = 0.00;
		double z6 = -width;

		double x7 = shelveLength + LateralPlates.width;
		double y7 = 0.00;
		double z7 = -width;

		double x8 = shelveLength + LateralPlates.width;
		double y8 = 0.00;
		double z8 = 0.00;
		
		result += "\n#Vertex for Back Shelve 1\n";
		result += "v " + x1 + " " + y1 + " " + z1 + "\n";
        result += "v " + x2 + " " + y2 + " " + z2 + "\n";
        result += "v " + x3 + " " + y3 + " " + z3 + "\n";
        result += "v " + x4 + " " + y4 + " " + z4 + "\n";
        result += "v " + x5 + " " + y5 + " " + z5 + "\n";
        result += "v " + x6 + " " + y6 + " " + z6 + "\n";
        result += "v " + x7 + " " + y7 + " " + z7 + "\n";
        result += "v " + x8 + " " + y8 + " " + z8 + "\n";
        
		// Define the face indices for the cube
        int face1v1 = 17, face1v2 = 18, face1v3 = 19, face1v4 = 20;
        int face2v1 = 21, face2v2 = 22, face2v3 = 23, face2v4 = 24;
        int face3v1 = 17, face3v2 = 18, face3v3 = 22, face3v4 = 21;
        int face4v1 = 18, face4v2 = 19, face4v3 = 23, face4v4 = 22;
        int face5v1 = 19, face5v2 = 20, face5v3 = 24, face5v4 = 23;
        int face6v1 = 17, face6v2 = 20, face6v3 = 24, face6v4 = 21;
        result += "\n#Faces for Lateral Shelve 1\n";
		// Append the face indices to the result string
		result += "f " + face1v1 + " " + face1v2 + " " + face1v3 + " " + face1v4 + "\n";
		result += "f " + face2v1 + " " + face2v2 + " " + face2v3 + " " + face2v4 + "\n";
		result += "f " + face3v1 + " " + face3v2 + " " + face3v3 + " " + face3v4 + "\n";
		result += "f " + face4v1 + " " + face4v2 + " " + face4v3 + " " + face4v4 + "\n";
		result += "f " + face5v1 + " " + face5v2 + " " + face5v3 + " " + face5v4 + "\n";
		result += "f " + face6v1 + " " + face6v2 + " " + face6v3 + " " + face6v4 + "\n";


		System.out.println("Created BackPlate Shelve with the coordinates :\n" + result);
		return result;
	}
}
