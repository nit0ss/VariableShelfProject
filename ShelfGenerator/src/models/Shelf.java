package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Shelf {

	private double totalLength;
	private int numShelves;
	private int minseparation;
	private final double thickness = 5.0; // each shelf has a prefab thickness
	private final double xAxis = 20.0; // each shelf is 20cm wide
	private double shelveLength;
	// public double width;
	Scanner sc = new Scanner(System.in);

	String topShelveOBJ;

	public Shelf(double totalLength, int numShelves, double shelveLength) {

		this.totalLength = totalLength;
		this.numShelves = numShelves;
		this.shelveLength = shelveLength;

		// this.maxthickness = (thicknessShelves)*numShelves;
		// minimo de cada balda de grososr tiene que ser 1 cm, entonces para
		// 170cm,7baldas->no podria haber 24 baldas por el grosor

	}

	public double getLenght() {
		return totalLength;
	}

	public int getNumShelves() {
		return numShelves;
	}

	public int getMinseparation() {
		return minseparation;
	}

	public double getTotalLength() {
		return totalLength;
	}

	public double getShelveLength() {
		return shelveLength;
	}

	public double getThickness() {
		return thickness;
	}

	public double getxAxis() {
		return xAxis;
	}
	
	public void setMinSeparation(double totalLength, int numShelves, double thickness){
		this.minseparation = (int) (totalLength / (numShelves - (2 * thickness)));
	}

	@Override
	public String toString() {
		return "Shelf [lenght=" + totalLength + ", numShelves=" + numShelves + ", minseparation=" + minseparation
				+ ", thickness=" + thickness + ", xAxis=" + xAxis + "]";
	}

}
