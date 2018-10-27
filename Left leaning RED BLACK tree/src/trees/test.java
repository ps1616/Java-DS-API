package trees;

import java.util.Random;

public class test {

	public static void main(String[] args)
	{
		BST<Integer,String> bst=new BST<>();
		
		bst.add(1, "one");
		bst.add(2, "two");
		bst.add(5, "five");
		bst.add(6, "six");
		bst.add(7, "seven");
		
	//	Random r=new Random();
	/*	for(int i=0;i<100;i++)
		{
			bst.add(r.nextInt(100), "someValue");
		}
	*/	
		
/*		
		
*/	
	//	System.out.println(bst.get(1));
	//	System.out.println(bst.get(8));
		
		System.out.println(bst.height());
	}
}
