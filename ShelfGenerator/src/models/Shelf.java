package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Shelf {

	private double lenght;

	private double thicknessShelves;
	private int numShelves;
	private final double minseparation;
	private final double minthickness = 1;
	private final double maxthickness;
	private final double xAxis = 20.0;
	public double width;
	Scanner sc = new Scanner(System.in);
	
	public Shelf(double lenght, double width, double thicknessShelves, int numShelves) {
		super();
		this.lenght = lenght;
		this.thicknessShelves = thicknessShelves;
		this.numShelves = numShelves;
		this.minseparation = lenght/numShelves;
		
		this.maxthickness = (thicknessShelves)*numShelves;
		//minimo de cada balda de grososr tiene que ser 1 cm, entonces para 170cm,7baldas->no podria haber 24 baldas por el grosor
			
	}
	
	



}
