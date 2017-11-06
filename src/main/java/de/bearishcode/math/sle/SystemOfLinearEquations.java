package de.bearishcode.math.sle;

import java.util.List;

import de.bearishcode.math.matrix.Matrix;
import de.bearishcode.math.vector.VectorEquation;

public class SystemOfLinearEquations
{
	private Matrix matrix;

	public SystemOfLinearEquations(double[][] content)
	{
		this.matrix = new Matrix(content);
	}

	public SystemOfLinearEquations(List<List<Double>> content)
	{
		this.matrix = new Matrix(content);
	}

	public SystemOfLinearEquations(VectorEquation vectorEquation1, VectorEquation vectorEquation2)
	{
		double[][] matrixContent = new double[vectorEquation1.getDimension()][3];
		for (int i = 0; i < vectorEquation1.getDimension(); i++)
		{
			matrixContent[i][0] = vectorEquation1.getDirection()[i];
			matrixContent[i][1] = -vectorEquation2.getDirection()[i];
			matrixContent[i][2] = vectorEquation2.getStartPoint()[i] - vectorEquation1.getStartPoint()[i];
		}

		this.matrix = new Matrix(matrixContent);
	}

	public double[] solve()
	{
		Matrix newMatrix = this.matrix.copy();

		newMatrix.reduceToDForm();

		return newMatrix.getVector(newMatrix.getRows());
	}

	public double getElement(int row, int column)
	{
		return this.matrix.getElement(row, column);
	}
}
