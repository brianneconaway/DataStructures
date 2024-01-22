package Tree;

import java.util.Collections;
import java.util.LinkedList;

public class TreeBenchmark {

	public static void main(String[] args) {
		BinarySearchTree<Integer> largeTree = new BinarySearchTree<Integer>();
		TwoThreeTree<Integer> ttTree = new TwoThreeTree<Integer>();
		int limit = 10000000;
		
		LinkedList<Integer> values = new LinkedList<Integer>();
		for (int num = 1; num <= limit; num++) {
			values.add(num);
		}
		// shuffle
		Collections.shuffle(values);

		// compare heights
		int count = 0;
		for (Integer value: values) {
			largeTree.add(value);
			ttTree.add(value);
			count++;
			if (count % 1000000 == 0) 
				System.out.println(ttTree.count() + " " + largeTree.height() + " " + ttTree.height());
		}



	}

}
