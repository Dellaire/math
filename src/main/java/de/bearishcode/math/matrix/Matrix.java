package de.bearishcode.math.matrix;

import java.util.List;

public class Matrix
{
	double[][] matrix;

	int rows;
	int columns;

	public Matrix(List<List<Double>> matrixContent)
	{
		if (!this.validate(matrixContent))
		{
			throw new RuntimeException("The rows of the specified matrix have different legths.");
		}

		this.rows = matrixContent.size();
		this.columns = matrixContent.get(0).size();

		this.matrix = new double[this.rows][this.columns];

		for (int row = 0; row < this.rows; row++)
		{
			for (int column = 0; column < this.columns; column++)
			{
				this.matrix[row][column] = matrixContent.get(row).get(column);
			}
		}
	}

	public Matrix(double[][] matrixContent)
	{
		this.rows = matrixContent.length;
		this.columns = matrixContent[0].length;

		this.matrix = new double[this.rows][this.columns];

		for (int row = 0; row < this.rows; row++)
		{
			for (int column = 0; column < this.columns; column++)
			{
				this.matrix[row][column] = matrixContent[row][column];
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

	public Matrix multiplyRow(double factor, int row)
	{
		for (int column = 0; column < this.columns; column++)
		{
			matrix[row][column] *= factor;
		}

		return this;
	}

	public Matrix multiplyAndAddRow(double factor, int sourceRow, int targetRow)
	{
		for (int column = 0; column < matrix[targetRow].length; column++)
		{
			matrix[targetRow][column] += factor * matrix[sourceRow][column];
		}

		return this;
	}

	public Matrix reduceColumnForward(int column)
	{
		for (int row = column + 1; row < this.rows; row++)
		{
			double factor = (matrix[row][column] / matrix[column][column]) * -1.0;
			this.multiplyAndAddRow(factor, column, row);
		}

		return this;
	}

	public Matrix reduceColumnBackward(int column)
	{
		for (int row = column - 1; row >= 0; row--)
		{
			double factor = (matrix[row][column] / matrix[column][column]) * -1.0;
			this.multiplyAndAddRow(factor, column, row);
		}

		return this;
	}

	public Matrix reduceToRForm()
	{
		for (int row = 0; row < this.rows; row++)
		{
			this.reduceColumnForward(row);
		}

		return this;
	}

	public Matrix reduceToLeftRForm()
	{
		for (int row = this.rows - 1; row >= 0; row--)
		{
			this.reduceColumnBackward(row);
		}

		return this;
	}

	public Matrix reduceToDForm()
	{
		this.reduceToRForm();
		this.reduceToLeftRForm();

		for (int row = 0; row < this.rows; row++)
		{
			this.multiplyRow(1 / this.matrix[row][row], row);
		}

		return this;
	}

	public int getRows()
	{
		return rows;
	}

	public int getColumns()
	{
		return columns;
	}

	public double getElement(int row, int column)
	{
		return this.matrix[row][column];
	}

	public double[] getVector(int column)
	{
		double[] vector = new double[this.rows];
		for (int row = 0; row < this.rows; row++)
		{
			vector[row] = this.matrix[row][column];
		}

		return vector;
	}

	public Matrix copy()
	{
		return new Matrix(this.matrix);
	}

	private boolean validate(List<List<Double>> matrix)
	{
		int columns = matrix.get(0).size();

		return !matrix.stream().filter(row -> row.size() != columns).findAny().isPresent();
	}
}
