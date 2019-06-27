package cg;

public class Validator {
	public int getSizeinML(Size size) {
		System.out.println(size+" "+size.getML());
		return size.getML();
	}
public boolean validateNo(String data) {
	return data.matches("\\d+");
}
public boolean isPalindrome(String data) {
	StringBuffer sb=new StringBuffer(data);
	String reverseS=sb.reverse().toString();
	return data.equals(reverseS);
}
}
