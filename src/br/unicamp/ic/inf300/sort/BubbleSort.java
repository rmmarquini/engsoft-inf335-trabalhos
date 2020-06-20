package br.unicamp.ic.inf300.sort;

public class BubbleSort extends Sorter {
	
	@Override
	public void sort(int[] vector) {
		boolean switched = true;
		while (switched) {
			switched = false;
			for (int i = 0; i < vector.length - 1; i++) {
				if (vector[i] > vector[i + 1]) {
					swap(vector, i);
					switched = true;
				}
			}
		}
	}

	private void swap(int[] vector, int i) {
		int aux;
		aux = vector[i];
		vector[i] = vector[i + 1];
		vector[i+1] = aux;
	}
}

