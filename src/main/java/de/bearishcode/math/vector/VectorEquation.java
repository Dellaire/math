package de.bearishcode.math.vector;

import de.bearishcode.math.sle.SystemOfLinearEquations;

public class VectorEquation
{
	private double[] startPoint;
	private double[] direction;
	private int dimension;

	public VectorEquation(double[] startPoint, double[] endPoint)
	{
		this.dimension = startPoint.length;
		this.startPoint = new double[this.dimension];
		this.direction = new double[this.dimension];

		for (int i = 0; i < this.dimension; i++)
		{
			this.startPoint[i] = startPoint[i];
			this.direction[i] = endPoint[i] - this.startPoint[i];
		}
	}

	public double[] calculateIntersection(VectorEquation vectorEquation)
	{
		SystemOfLinearEquations systemOfLinearEquations = new SystemOfLinearEquations(this, vectorEquation);
		double[] resultVector = systemOfLinearEquations.solve();

		double[] intersection = new double[this.dimension];
		for (int i = 0; i < this.dimension; i++)
		{
			intersection[i] = this.startPoint[i] + (resultVector[i] * this.direction[i]);
		}

		return intersection;
	}

	public double[] getStartPoint()
	{
		return startPoint;
	}

	public double[] getDirection()
	{
		return direction;
	}

	public int getDimension()
	{
		return this.dimension;
	}
}
