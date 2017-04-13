package uebung2;
/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht
 * als zyklisch geschlossen betrachtet wird.
 *
 * @author Holger Vogelsang
 */
public class GameOfLifeLogic {

	private boolean startGeneration [][];
	private boolean nextGeneration [][];
	
	public void setStartGeneration(boolean[][] generation) {
		  startGeneration = generation;
		  nextGeneration = new boolean [generation.length][generation[1].length];
	}

	public void nextGeneration() {
		for (int i = 0; i < startGeneration.length; i++) {
			for (int j = 0; j < startGeneration[1].length; i++) {
				if (isCellAlive(i,j)) {
					if (getNeigbors(i,j)>1 && getNeigbors(i,j)<4) {
						nextGeneration[i][j] = true;
					} else {
						nextGeneration[i][j] = false;
					}
				} else {
					if (getNeigbors(i,j)==3) {
						nextGeneration[i][j] = true;
					} else {
						nextGeneration[i][j] = false;
					}
				}
			}
		}
		startGeneration = nextGeneration;
	}

	private int getNeigbors(int x, int y) {
		int neighbors = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!(i==0 && j==0) || isCellAlive(x + i, y + j)) {
					neighbors++;
				}
			}
		}
		return neighbors;
	}

	public boolean isCellAlive(int x, int y) {
		if (x<0 || y<0 || x>startGeneration.length || y>startGeneration[1].length) {
			return false;
		} else {
			return startGeneration[x][y];
		}
	}
}