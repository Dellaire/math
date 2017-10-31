package de.bearishcode.math.matrix;

import java.util.List;

public class Matrix
{
	double[][] matrix;

	int rows;
	int columns;

	public Matrix(List<List<Double>> matrix)
	{
		this.rows = matrix.size();
		this.columns = matrix.get(0).size();

		this.matrix = new double[this.rows][this.columns];

		for (int row = 0; row < this.rows; row++)
		{
			for (int column = 0; column < this.columns; column++)
			{
				this.matrix[row][column] = matrix.get(row).get(column);
			}
		}
	}

	public Matrix multiplyAndAddLine(double factor, int sourceRow, int targetRow)
	{
		for (int column = 0; column < matrix[targetRow].length; column++)
		{
			matrix[targetRow][column] += factor * matrix[targetRow][column];
		}

		return this;
	}

	public double get(int row, int column)
	{
		return this.matrix[row][column];
	}
}
