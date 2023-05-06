package models;

public class LateralPlates {

	private final double zAxis = 20.0;

	private final double width = 4; // thiner than normal shelve but thicker than backplate, gotta look ROBUST
	private double totalLength;
	private int numShelves;
	private double shelveLength;
	private String decission;
	private double firstSeparation;
	private double normalSeparation;
	private double effectiveLength;

	private double[] checkpoints;

	public LateralPlates(double totalLength, int numShelves, double shelveLength, String decission) {
		this.totalLength = totalLength;
		this.numShelves = numShelves;
		this.decission = decission;
		this.shelveLength = shelveLength;
		effectiveLength = (totalLength - numShelves * 5);

		double separation = effectiveLength / numShelves;

		if (separation < 20) {
			System.out.println("SEPARATION INFERIOR OF 20 SELECTED! BOOKS MIGHT NOT FIT IN");
		}

		checkpoints = new double[numShelves];

		switch (decission) {
		case "rounded":
			System.out.println("You selected rounded.");
			normalSeparation = separation;
			setCheckpointsRounded(checkpoints);
			break;

		case "nonsymmetric":
			System.out.println("You selected nonsymmetric."); // You will accept that the first shelve will take 25%
			setCheckpointsNotRounded(checkpoints);
			// space always
			// TODO: Implement nonsymmetric logic

			firstSeparation = Math.round((totalLength) * 0.25);
			normalSeparation = (effectiveLength - firstSeparation) / numShelves;
			break;
		case "notRounded":
			System.out.println("Settings not accepted");
			// TODO: Implement notRounded logic
			break;
		default:
			System.out.println("Invalid choice.");
		}

	}

	public void setCheckpointsRounded(double[] checkpoints) {

		double addition = 0.0;

		for (int i = 0; i < numShelves; i++) {

			checkpoints[i] = addition;
			addition += normalSeparation;
		}

	}

	public void setCheckpointsNotRounded(double[] checkpoints) {
		double addition = 0.0;

		for (int i = 1; i < numShelves ; i++) {

			checkpoints[i] = addition;
			addition += normalSeparation;
		}
		
		checkpoints[0] = firstSeparation;
	}

	public double[] getCheckpointsRounded() {
		return checkpoints;
	}

	public double[] getCheckpointsNotRounded() {
		return checkpoints;
	}

	public String getObjVector1() {

		String result = "\n";

		// 8 vertex 8 duples
		double x1 = 0.00;
		double y1 = totalLength;
		double z1 = zAxis;

		double x2 = 0.00;
		double y2 = totalLength;
		double z2 = 0.00;

		double x3 = width;
		double y3 = totalLength;
		double z3 = 0.00;

		double x4 = 0.00; 
		double y4 = totalLength;
		double z4 = zAxis;

		double x5 = 0.00;
		double y5 = 0.00;
		double z5 = -zAxis;

		double x6 = 0.00;
		double y6 = 0.00;
		double z6 = 0.00;

		double x7 = width;
		double y7 = 0.00;
		double z7 = 0.00;

		double x8 = width;
		double y8 = 0.00;
		double z8 = zAxis;

		result += "v " + x1 + " " + y1 + " " + z1 + "\n";
		result += "v " + x2 + " " + y2 + " " + z2 + "\n";
		result += "v " + x3 + " " + y3 + " " + z3 + "\n";
		result += "v " + x4 + " " + y4 + " " + z4 + "\n";
		result += "v " + x5 + " " + y5 + " " + z5 + "\n";
		result += "v " + x6 + " " + y6 + " " + z6 + "\n";
		result += "v " + x7 + " " + y7 + " " + z7 + "\n";
		result += "v " + x8 + " " + y8 + " " + z8 + "\n";

		// Define the face indices for the cube
		int face1v1 = 1, face1v2 = 2, face1v3 = 3, face1v4 = 4;
		int face2v1 = 5, face2v2 = 6, face2v3 = 7, face2v4 = 8;
		int face3v1 = 1, face3v2 = 2, face3v3 = 6, face3v4 = 5;
		int face4v1 = 2, face4v2 = 3, face4v3 = 7, face4v4 = 6;
		int face5v1 = 3, face5v2 = 4, face5v3 = 8, face5v4 = 7;
		int face6v1 = 1, face6v2 = 4, face6v3 = 8, face6v4 = 5;

		// Append the face indices to the result string
		result += "f " + face1v1 + " " + face1v2 + " " + face1v3 + " " + face1v4 + "\n";
		result += "f " + face2v1 + " " + face2v2 + " " + face2v3 + " " + face2v4 + "\n";
		result += "f " + face3v1 + " " + face3v2 + " " + face3v3 + " " + face3v4 + "\n";
		result += "f " + face4v1 + " " + face4v2 + " " + face4v3 + " " + face4v4 + "\n";
		result += "f " + face5v1 + " " + face5v2 + " " + face5v3 + " " + face5v4 + "\n";
		result += "f " + face6v1 + " " + face6v2 + " " + face6v3 + " " + face6v4 + "\n";

		System.out.println("Created LateralPlate1 Shelve with the coordinates :\n" + result);
		return result;
	}

	public String getObjVector2() {

		String result = "\n";

		// 8 vertex 8 duples
		double x1 = shelveLength;
		double y1 = totalLength;
		double z1 = zAxis;

		double x2 = shelveLength;
		double y2 = totalLength;
		double z2 = 0.00;

		double x3 = width + shelveLength;
		double y3 = totalLength;
		double z3 = 0.00;

		double x4 = width + shelveLength;
		double y4 = totalLength;
		double z4 = zAxis;

		double x5 = totalLength;
		double y5 = 0.00;
		double z5 = zAxis;

		double x6 = totalLength;
		double y6 = 0.00;
		double z6 = 0.00;

		double x7 = totalLength + width;
		double y7 = 0.00;
		double z7 = 0.00;

		double x8 = totalLength + width;
		double y8 = 0.00;
		double z8 = zAxis;

		result += "v " + x1 + " " + y1 + " " + z1 + "\n";
		result += "v " + x2 + " " + y2 + " " + z2 + "\n";
		result += "v " + x3 + " " + y3 + " " + z3 + "\n";
		result += "v " + x4 + " " + y4 + " " + z4 + "\n";
		result += "v " + x5 + " " + y5 + " " + z5 + "\n";
		result += "v " + x6 + " " + y6 + " " + z6 + "\n";
		result += "v " + x7 + " " + y7 + " " + z7 + "\n";
		result += "v " + x8 + " " + y8 + " " + z8 + "\n";

		// Define the face indices for the cube
		int face1v1 = 1, face1v2 = 2, face1v3 = 3, face1v4 = 4;
		int face2v1 = 5, face2v2 = 6, face2v3 = 7, face2v4 = 8;
		int face3v1 = 1, face3v2 = 2, face3v3 = 6, face3v4 = 5;
		int face4v1 = 2, face4v2 = 3, face4v3 = 7, face4v4 = 6;
		int face5v1 = 3, face5v2 = 4, face5v3 = 8, face5v4 = 7;
		int face6v1 = 1, face6v2 = 4, face6v3 = 8, face6v4 = 5;

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
