package javaProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayListManipulation {
	public void listIsEmptyOrNot(List<String> stringList) {
		System.out.println(stringList.isEmpty());
	}

	public void elementPresentOrNot(List<String> stringList) {
		System.out.println(stringList.contains("Geeta"));
	}

	public void positionOfelement(List<String> stringList) {
		System.out.println("First Index of Geeta :: " + stringList.indexOf("Geeta"));
		System.out.println("First Index of Geeta :: " + stringList.lastIndexOf("Geeta"));

	}

	
	public void arrayListToArray(List<String> stringList) {
		Object obj[] = stringList.toArray();
		for (Object o : obj) {
			System.out.print(o + ", ");
		}
	}
	
	public void replaceTheElement(List<String> stringList) {
		stringList.set(0, "Your");
		System.out.println(stringList);
	}
	public void subList(List<String> stringList) {
		List<String> subList=stringList.subList(3,6);//Dipali, Gita, shital
		System.out.println(subList);
		stringList.set(4, "Geeta");
		System.out.println(subList);
		stringList.addAll(4, subList);
		System.out.println(stringList);

	}
	public void joinTwoArray(List<String> stringList) {
		//List<String> stringList1=new ArrayList<String>(stringList);
		List<String> lm=new ArrayList<String>(Arrays.asList("Your"));
		System.out.println(stringList);

		System.out.println(lm);
		stringList.addAll(lm);
		System.out.println(stringList);	
	}
	public void reverseArrayList(List<String> stringList) {
		for (int i = stringList.size() - 1; i >= 0; i--) {
			System.out.print(stringList.get(i) + ", ");
		}
	}

	public void removeDuplicateFromArray(List<String> stringList) {
		System.out.println("Original list is:: ");
		System.out.println(stringList);
		ArrayList<String> dup=new ArrayList<String>();
		ArrayList<String> unq=new ArrayList<String>();

		Set<String> set = new LinkedHashSet<String>(); 
		set.addAll(stringList);
		System.out.println("Using set \n"+set);
		for(String s:stringList) {
			if(!dup.contains(s)) {
				dup.add(s);
			}
			else {
				unq.add(s);
			}
		}
		System.out.println("After removing");
		System.out.println(dup);
		System.out.println(unq);


		
		
	}
	public void findDuplicateFromArray(List<String> stringList) {
		System.out.println("Original list is:: ");
		System.out.println(stringList);
		
	}

	public static void main(String[] args) {
		ArrayListManipulation mp = new ArrayListManipulation();
		//List<String> stringList = Arrays.asList("Geeta", "Deepali", "Sheetal", "Dipali", "Gita", "shital", "Geeta",
	//			"deepali");
	List<String> stringList = new ArrayList<String>(Arrays.asList("Geeta", "Deepali", "Sheetal", "Dipali", "Gita", "shital", "Geeta",
						"deepali"));
		System.out.println(stringList);
		System.out.println("-----------------listIsEmptyOrNot:isEmpty-----------");
		mp.listIsEmptyOrNot(stringList);
		System.out.println("-----------------reverseArrayList----------");
		mp.reverseArrayList(stringList);
		System.out.println("\n-----------------elementPresentOrNot:contains-----------");
		mp.elementPresentOrNot(stringList);
		System.out.println("-----------------positionOfelement:indexOf or lastIndexOf-----------");
		mp.positionOfelement(stringList);
		System.out.println("-----------------arrayListToArray:Object obj[]-----------");
		mp.arrayListToArray(stringList);
		System.out.println("\n-----------------replaceTheElement:set(0, \"Your Wish\")-----------");
		mp.replaceTheElement(stringList);
		System.out.println("-----------------subList-----------");
mp.subList(stringList);
		System.out.println("-----------------joinTwoArray:addAll()-----------");
		mp.joinTwoArray(stringList);

		System.out.println("-----------------removeDuplicateFromArray-----------");
mp.removeDuplicateFromArray(stringList);
	}

}
