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

	public Matrix swapRows(int row1, int row2)
	{
		double[] tmpRow = this.matrix[row1];
		this.matrix[row1] = this.matrix[row2];
		this.matrix[row2] = tmpRow;

		return this;
	}

	public Matrix multiplyAndAddLine(double factor, int sourceRow, int targetRow)
	{
		for (int column = 0; column < matrix[targetRow].length; column++)
		{
			matrix[targetRow][column] += factor * matrix[sourceRow][column];
		}

		return this;
	}

	public Matrix reduceColumn(int column)
	{
		for (int row = column + 1; row < this.rows; row++)
		{
			double factor = (matrix[row][column] / matrix[column][column]) * -1.0;
			this.multiplyAndAddLine(factor, column, row);
		}

		return this;
	}

	public Matrix reduceToTriangleForm()
	{
		for (int row = 0; row < this.rows; row++)
		{
			this.reduceColumn(row);
		}

		return this;
	}

	public double get(int row, int column)
	{
		return this.matrix[row][column];
	}
}
