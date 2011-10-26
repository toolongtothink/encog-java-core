package org.encog.ml.linear;

import junit.framework.TestCase;

import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.util.Format;

public class TestLinearRegression extends TestCase {
	public void testLinear1() {
		double[][] INPUT = { {3}, {6}, {4}, {5} };
		double[][] IDEAL = { {0}, {-3}, {-1}, {-2} };
		
		MLDataSet data = new BasicMLDataSet(INPUT,IDEAL);
		LinearRegression lin = new LinearRegression(data);
		System.out.println("w0 = " + Format.formatDouble(lin.getW()[0],2));
		System.out.println("w1 = " + Format.formatDouble(lin.getW()[1],2));
	}
	
	public void testLinear2() {
		double[][] INPUT = { {2}, {4}, {6}, {8} };
		double[][] IDEAL = { {2}, {5}, {5}, {8} };
		
		MLDataSet data = new BasicMLDataSet(INPUT,IDEAL);
		LinearRegression lin = new LinearRegression(data);
		System.out.println("w0 = " + Format.formatDouble(lin.getW()[0],2));
		System.out.println("w1 = " + Format.formatDouble(lin.getW()[1],2));
	}
}
