package cg;

import java.util.*;
import java.util.Set;

public class Demo2 {

	public static void main(String[] args) {
		//generic collection
//		Set<String> col=new HashSet<String>();
//		Set<String> col=new LinkedHashSet<String>();//Ordered collection No duplicated
//		Set<String> col=new TreeSet<String>();//Tree Set does not allow null//No insertion order
		List<String> col=new ArrayList<String>();	
		col.add("Ram");
		col.add("Sham");
		col.add("Abdul");
		//col.add(55);//new integer(55); //autoboxing
		col.add(null);
		col.add("Ganesh");
		col.add("Ram");
		System.out.println(col);
		System.out.println(col.size());
		System.out.println("==========");
		for(String s:col) {
			System.out.println(s);
		}
		System.out.println("===========");
		Iterator<String> i=col.iterator();
		while(i.hasNext()) {
			String ss=i.next();
			System.out.println(ss);
		}
	}

}
