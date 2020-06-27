package br.unicamp.ic.extensao.inf335;

import org.apache.log4j.Logger;

import br.unicamp.ic.extensao.inf335.sort.*;

public class VectorSorter {
	
	static Logger logger = Logger.getLogger(VectorSorter.class.getName());

	private int[] vector;
	private static String[] parameters;

	public static void main(String[] args) {

		parameters = args;
		int[] numbers = parseParameters();
	
		VectorSorter sorter = new VectorSorter(numbers);
		logger.info("Input: ");
		sorter.print();
		sorter.sort();
		logger.info("Sorted: ");
		sorter.print();
	}
	
	public VectorSorter(int size) {
		vector = generateRandomVector(size);
	}
	
	public VectorSorter(int[] numbers) {
		vector = numbers;
	}
	
	public void sort() {
		Sorter s = new BubbleSort();
		s.sort(vector);
	}
	
	public static int[] parseParameters() {
		int[] numbers;
		if(parameters.length > 0) {
			numbers = new int[parameters.length];
			for(int k=0; k<parameters.length; k++) {
				numbers[k] = Integer.parseInt(parameters[k]);
			}
		} else {
			numbers = generateRandomVector(10);
		}
		return numbers;
	}
	
	private static int[] generateRandomVector(int size) {

		int[] vector = new int[size];

		for (int i = 1; i < vector.length ; i++) {
			vector[i] = (int) (Math.random()*100 + 1);
		}
		
		return vector;
	}
	
	public void print() {
		logger.info("[");
		logger.info(vector[0]);
		
		int i = 0;
		do {
			i++;
			logger.info(", ");
			logger.info(vector[i]);
		} while (i < vector.length - 1);

		logger.info("]");
	}
}
