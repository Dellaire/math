package de.bearishcode.math.sle;

import java.util.List;

import de.bearishcode.math.matrix.Matrix;

public class SystemOfLinearEquations
{
	private Matrix matrix;

	public SystemOfLinearEquations(List<List<Double>> content)
	{
		this.matrix = new Matrix(content);
	}

	public List<Double> solve()
	{
		Matrix newMatrix = this.matrix.copy();

		newMatrix.reduceToRForm();

		return null;
	}
}
