import java.util.*;

public class QuickUnion {
	static int[] union;

	QuickUnion(int size) {
		this.union = new int[size];
		for (int i = 0; i < size; i++) {
			union[i] = i;
		}
	}

	// connect a to b
	static public void connect(int a, int b) {
		int aRoot = root(a);
		int bRoot = root(b);
		union[aRoot] = union[bRoot];
	}

	// check if a is connected to b
	static public boolean isConnected(int a, int b) {
		return root(a) == root(b);
	}

	// find the root of a
	private static int root(int a) {
		while (a != union[a]) {
			// Point to grandparent. Compress 2 layers down
			union[a] = union[union[a]];
			a = union[a];
		}
		return a;
	}

	public static void main(String []args){

		QuickUnion qu = new QuickUnion(5);
		connect(0, 1);
		connect(0, 2);

		System.out.println(isConnected(0, 1));
		System.out.println(isConnected(0, 2));
		System.out.println(isConnected(1, 2));
		System.out.println(isConnected(1, 3));
	}
}