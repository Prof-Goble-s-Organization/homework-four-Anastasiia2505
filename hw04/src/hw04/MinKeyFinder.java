package hw04;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Find the key associated with the minimum value in a tree.
 */
public class MinKeyFinder implements CS232Visitor<String, Integer> {
	
	private String minKey;
	private int minValue;


	public MinKeyFinder() {
		minKey = null;
		minValue = Integer.MAX_VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	public void visit(String key, Integer value) {
		if(value < minValue) {
			minValue = value;
			minKey = key;
		}
	}

	/**
	 * Get the key associated with the minimum value in the tree.
	 * 
	 * @return the key associated with the minimum value.
	 */
	public String getMinKey() {
		return minKey;
	}
	
	public static void main(String[] args) {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N"};
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (int i=0; i<keys.length; i++) {
			vals.add(i);
		}
		Collections.shuffle(vals);
		CS232LinkedBinaryTree<String, Integer> tree =
				new CS232LinkedBinaryTree<String, Integer>(keys, vals.toArray(new Integer[] {}));
		
		MinKeyFinder mkf = new MinKeyFinder();
		tree.visitPreOrder(mkf);
		System.out.println(mkf.getMinKey());
		

	}
}
