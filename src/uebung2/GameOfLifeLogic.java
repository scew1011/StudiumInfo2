package uebung2;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht als zyklisch
 * geschlossen betrachtet wird.
 *
 * @author scew1011
 */
public class GameOfLifeLogic {

	private boolean startGeneration[][];
	private boolean nextGeneration[][];

	/**
	 * Sets up startGeneration boolean array with given generation and creates
	 * nextGeneration boolean array so that it has the same size as given
	 * generation
	 * 
	 * @param generation
	 *            boolean array telling where on the board is an alive cell
	 */
	public void setStartGeneration(boolean[][] generation) {
		startGeneration = new boolean[generation.length][generation[1].length];
		copy(generation, startGeneration);
		nextGeneration = new boolean[generation.length][generation[1].length];
	}

	/**
	 * runs startGeneration through GOL rules and creates it to nextGeneration
	 * afterwards startGeneration has nextGeneration copied in
	 */
	public void nextGeneration() {
		for (int i = 0; i < startGeneration.length; i++) {
			for (int j = 0; j < startGeneration[1].length; j++) {
				if (isCellAlive(i, j)) {
					if (getNeigbors(i, j) > 1 && getNeigbors(i, j) < 4) {
						nextGeneration[i][j] = true;
					} else {
						nextGeneration[i][j] = false;
					}
				} else {
					if (getNeigbors(i, j) == 3) {
						nextGeneration[i][j] = true;
					} else {
						nextGeneration[i][j] = false;
					}
				}
			}
		}
		copy(nextGeneration, startGeneration);
	}

	/**
	 * Checks how many neighbors a cell with given coordinates has
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @return number of neighbors
	 */
	private int getNeigbors(int x, int y) {
		int neighbors = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!(i == 0 && j == 0) && (isCellAlive(x + i, y + j))) {
					neighbors++;
				}
			}
		}
		return neighbors;
	}

	/**
	 * Checks if given cell is alive or dead
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @return true for alive, false for dead
	 */
	public boolean isCellAlive(int x, int y) {
		if (x < 0 || y < 0 || x >= (startGeneration.length) || y >= (startGeneration[1].length)) {
			return false;
		} else {
			return startGeneration[x][y];
		}
	}

	/**
	 * Necessary to avoid Call-By-Reference and copies data from one boolean
	 * array to another
	 * 
	 * @param gen1
	 *            copied from
	 * @param gen2
	 *            copied into
	 */
	private void copy(boolean[][] gen1, boolean[][] gen2) {
		for (int i = 0; i < gen1.length; i++) {
			for (int j = 0; j < gen1[1].length; j++) {
				gen2[i][j] = gen1[i][j];
			}
		}
	}
}