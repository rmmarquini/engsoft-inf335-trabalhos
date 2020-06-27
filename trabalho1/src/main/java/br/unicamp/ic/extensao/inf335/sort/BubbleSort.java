package br.unicamp.ic.extensao.inf335.sort;

public class BubbleSort extends Sorter {
	
	@Override
	public void sort(int[] vector) {
		int aux = 0;
		for (int i=0; i<vector.length; i++) {
			for (int j=0; j<vector.length; j++) {
				if (vector[i] < vector[j]) {
					aux = vector[i];
					vector[i] = vector[j];
					vector[j] = aux;
				}
			}
		}
	}
}

