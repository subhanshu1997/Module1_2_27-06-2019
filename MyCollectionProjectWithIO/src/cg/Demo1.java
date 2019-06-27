package cg;
import java.util.*;
public class Demo1 {

	public static void main(String[] args) {
		// nongeneric collection
		Set col=new HashSet();
		col.add("Ram");
		col.add("Sham");
		col.add("Abdul");
		col.add("55");//new integer(55); //autoboxing
		col.add(null);
		col.add("Ganesh");
		col.add("Ram");
		System.out.println(col);
		System.out.println(col.size());

	}

}
