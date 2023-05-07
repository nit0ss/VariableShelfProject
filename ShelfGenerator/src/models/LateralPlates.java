package models;

public class LateralPlates {

	private final double zAxis = 20.0;

	protected final static double width = 4; // thiner than normal shelve but thicker than backplate, gotta look ROBUST
	private double totalLength;
	private int numShelves;
	private double shelveLength;
	private String decission;
	private double firstSeparation;
	private double normalSeparation;
	private double effectiveLength;
	protected int numberOfCheckpoints;

	// protected double separationSum;

	private double[] checkpoints;

	public LateralPlates(double totalLength, int numShelves, double shelveLength, String decission) {
		this.totalLength = totalLength;
		this.numShelves = numShelves;
		this.decission = decission;
		this.shelveLength = shelveLength;
		effectiveLength = (totalLength - numShelves * 5);

		
		this.normalSeparation = effectiveLength / numShelves;

		System.out.println("Separation going to be used = " + normalSeparation);

		checkpoints = new double[numShelves];

		switch (decission) {
		case "rounded":
			System.out.println("You selected rounded.\n");

			setCheckpointsRounded();
			break;

		case "nonsymmetric":
			System.out.println(
					"You selected nonsymmetric. 20% of the total length will be reserved for the first space\n");

			

			firstSeparation = Math.round((totalLength) * 0.20);
			//normalSeparation = (effectiveLength - firstSeparation) / numShelves;
			setCheckpointsNotRounded();
			break;
		case "notRounded":
			System.out.println("Settings not accepted. \n");
			// TODO: Implement notRounded logic
			break;
		default:
			System.out.println("Skipping...\n");
		}

	}

	public void setCheckpointsRounded() {

		double addition = 5.0;

		for (int i = 0; i < numShelves; i++) {

			numberOfCheckpoints++;
			addition += normalSeparation;

			checkpoints[i] = addition;

			System.out.println("Checkpoint " + i + ":  implemented at: " + checkpoints[i]);

		}

	}

	public void setCheckpointsNotRounded() {
		double addition = 0.0;
		
		System.out.println("First separation : " + firstSeparation);
		System.out.println("Next separations : " + normalSeparation);
		
		numberOfCheckpoints++;
		addition += firstSeparation;
		checkpoints[0] = firstSeparation;
		System.out.println("Checkpoint " + "0" + ":  implemented at: " + checkpoints[0]);
		

		for (int i = 1; i < numShelves; i++) {

			numberOfCheckpoints++;
			addition += normalSeparation;
			checkpoints[i] = addition;

			System.out.println("Checkpoint " + i + ":  implemented at: " + checkpoints[i]);
		}

	}

	public double[] getCheckpointsRounded() {
		return checkpoints;
	}

	public double[] getCheckpointsNotRounded() {
		return checkpoints;
	}

	public int getCheckpointsAmmount() {return numberOfCheckpoints;}
	
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

		double x4 = width;
		double y4 = totalLength;
		double z4 = zAxis;

		double x5 = 0.00;
		double y5 = BottomShelve.width;
		double z5 = zAxis;

		double x6 = 0.00;
		double y6 = BottomShelve.width;
		double z6 = 0.00;

		double x7 = width;
		double y7 = BottomShelve.width;
		double z7 = 0.00;

		double x8 = width;
		double y8 = BottomShelve.width;
		double z8 = zAxis;

		result += "\n#Vertex for Lateral Shelve 1\n";
		result += "v " + x1 + " " + y1 + " " + z1 + "\n";
		result += "v " + x2 + " " + y2 + " " + z2 + "\n";
		result += "v " + x3 + " " + y3 + " " + z3 + "\n";
		result += "v " + x4 + " " + y4 + " " + z4 + "\n";
		result += "v " + x5 + " " + y5 + " " + z5 + "\n";
		result += "v " + x6 + " " + y6 + " " + z6 + "\n";
		result += "v " + x7 + " " + y7 + " " + z7 + "\n";
		result += "v " + x8 + " " + y8 + " " + z8 + "\n";

		// Define the face indices for the cube
		int face1v1 = 25, face1v2 = 26, face1v3 = 27, face1v4 = 28;
		int face2v1 = 29, face2v2 = 30, face2v3 = 31, face2v4 = 32;
		int face3v1 = 25, face3v2 = 26, face3v3 = 30, face3v4 = 29;
		int face4v1 = 26, face4v2 = 27, face4v3 = 31, face4v4 = 30;
		int face5v1 = 27, face5v2 = 28, face5v3 = 32, face5v4 = 31;
		int face6v1 = 25, face6v2 = 28, face6v3 = 32, face6v4 = 29;

		result += "\n#Faces for Lateral Shelve 1\n";
		// Append the face indices to the result string
		result += "f " + face1v1 + " " + face1v2 + " " + face1v3 + " " + face1v4 + "\n";
		result += "f " + face2v1 + " " + face2v2 + " " + face2v3 + " " + face2v4 + "\n";
		result += "f " + face3v1 + " " + face3v2 + " " + face3v3 + " " + face3v4 + "\n";
		result += "f " + face4v1 + " " + face4v2 + " " + face4v3 + " " + face4v4 + "\n";
		result += "f " + face5v1 + " " + face5v2 + " " + face5v3 + " " + face5v4 + "\n";
		result += "f " + face6v1 + " " + face6v2 + " " + face6v3 + " " + face6v4 + "\n";

		System.out.println("\nCreated LateralPlate1 Shelve with the coordinates :\n" + result);
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

		double x3 = shelveLength + width;
		double y3 = totalLength;
		double z3 = 0.00;

		double x4 = shelveLength + width;
		double y4 = totalLength;
		double z4 = zAxis;

		double x5 = shelveLength;
		double y5 = BottomShelve.width;
		double z5 = zAxis;

		double x6 = shelveLength;
		double y6 = BottomShelve.width;
		double z6 = 0.00;

		double x7 = width + shelveLength;
		double y7 = BottomShelve.width;
		double z7 = 0.00;

		double x8 = width + shelveLength;
		double y8 = BottomShelve.width;
		double z8 = zAxis;

		result += "\n#Vertex for Lateral Shelve 2\n";
		result += "v " + x1 + " " + y1 + " " + z1 + "\n";
		result += "v " + x2 + " " + y2 + " " + z2 + "\n";
		result += "v " + x3 + " " + y3 + " " + z3 + "\n";
		result += "v " + x4 + " " + y4 + " " + z4 + "\n";
		result += "v " + x5 + " " + y5 + " " + z5 + "\n";
		result += "v " + x6 + " " + y6 + " " + z6 + "\n";
		result += "v " + x7 + " " + y7 + " " + z7 + "\n";
		result += "v " + x8 + " " + y8 + " " + z8 + "\n";

		// Define the face indices for the cube
		int face1v1 = 33, face1v2 = 34, face1v3 = 35, face1v4 = 36;
		int face2v1 = 37, face2v2 = 38, face2v3 = 39, face2v4 = 40;
		int face3v1 = 33, face3v2 = 34, face3v3 = 38, face3v4 = 37;
		int face4v1 = 34, face4v2 = 35, face4v3 = 39, face4v4 = 38;
		int face5v1 = 35, face5v2 = 36, face5v3 = 40, face5v4 = 39;
		int face6v1 = 33, face6v2 = 36, face6v3 = 40, face6v4 = 37;
		result += "\n#Faces for Lateral Shelve 2\n";
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
