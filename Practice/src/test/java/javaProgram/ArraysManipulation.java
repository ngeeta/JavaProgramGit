package javaProgram;

import java.util.Arrays;

public class ArraysManipulation {
	public void findDup(String[] a) {
		for (String f : a) {
			System.out.print(f + ", ");
		}
		System.out.println("\n");
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			count = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j] && a[i] != null) {
					count++;
					a[j] = null;
				}
			}
			if (count > 1 && a[i] != null) {
				System.out.println(a[i] + " " + count);
			}
		}

	}

	public void removeDup() {
		String[] a = { "A", "B", "C", "A", "B", "D", "A", "B", "C" };
		Arrays.sort(a);
		for (String f : a) {
			System.out.print(f + ", ");
		}

		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != a[j]) {
				j++;
				a[j] = a[i];
			}
		}
		System.out.println("\n");
		for (int i = 0; i < j + 1; i++) {
			System.out.println(a[i]);
		}

	}

	public void twoDimensionalArray() {
		String s[][] = { { "A", "B", "C" }, { "1", "2", "3" } };
		System.out.println("No of rows : " + s.length);
		System.out.println("No of Col : " + s[0].length);
	}

	public void reverseArray() {
		String a[] = { "A", "B", "C", "D" };
		for (String f : a) {
			System.out.print(f + ", ");
		}
		System.out.println("\n");
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i]);
		}

	}

	public void largestNumber() {
		int a[] = { 2, 4, 6, 5, 3, 2 };
		for (int f : a) {
			System.out.print(f + ", ");
		}
		int max = a[0];
		System.out.println("\nMax number is");
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		System.out.println(max);

	}

	public void smallestNumber() {
		int a[] = { 2, 4, 6, 5, 3, 2 };
		for (int f : a) {
			System.out.print(f + ", ");
		}
		int min = a[0];
		System.out.println("\nSmallest number is");
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		System.out.println(min);

	}

	public void secondLargestNum() {
		int a[] = { 1, 2, 3, 4, 5 };
		for (int f : a) {
			System.out.print(f);
		}

		System.out.println("\n");
		int max = a[0];
		int secMax = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		System.out.println("Max No " + max);

		for (int i = 0; i < a.length; i++) {
			if (a[i] > secMax && a[i] != max) {
				secMax = a[i];
			}
		}
		System.out.println("2nd largest No " + secMax);

	}

	public static void main(String[] args) {
		String a[] = { "A", "B", "C", "A", "B", "D", "A", "B", "C" };
		ArraysManipulation mp = new ArraysManipulation();
		System.out.println("---------find Duplicate------------");
		mp.findDup(a);

		System.out.println("---------remove Duplicate------------");
		mp.removeDup();

		System.out.println("--------------2D array---------");
		mp.twoDimensionalArray();
		System.out.println("--------------Reverse Array---------");
		mp.reverseArray();
		System.out.println("--------------Largest no Array---------");
		mp.largestNumber();
		System.out.println("--------------2nd Largest no Array---------");
		mp.secondLargestNum();
		System.out.println("--------------Smallest no Array---------");
		mp.smallestNumber();

	}

}
