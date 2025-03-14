package JavaPractice;

public class AddIntegerFromString {
 public void isDigit(String s,int sum) {
	 sum=0;
	 char c[]=s.toCharArray();
	 for(int i=0;i<c.length;i++) {
		 if(Character.isDigit(c[i])) {
		sum=sum+Integer.parseInt(String.valueOf(c[i]));	 
		 }
	 }
	 System.out.println("Addition of "+s +" is "+sum);
 }
	public void regex(String s,int sum) {
		
	}
	public static void main(String[] args) {
		AddIntegerFromString a=new AddIntegerFromString();
		String s="1My4World23"; //10
		int sum = 0;
		a.isDigit(s,sum);
		a.regex(s,sum);
	}

}
