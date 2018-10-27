package stackAPI;

public class testClass {

	public static void main(String[] args)
	{
		stackImp<String> s=new stackImp<String>(5);
		s.push("hello");
		s.push("hi");
		s.push("hey");
		System.out.println(s.pop());
		
	}
}
