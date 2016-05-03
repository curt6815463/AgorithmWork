
import java.util.*;

public class Test {

	public static void main(String[] args) {		
		String input = "((7+(5*5))/(5+9))";	
		Stack<BinaryTree> s = new Stack<BinaryTree>();		
		BinaryTree tree;
		BinaryTree tree1;
		BinaryTree tree2;
			
		for(int i = 0 ; i < input.length() ; i++)
		{		
			char c = input.charAt(i);		
			if(Character.isDigit(c) || (int)c == 43 
					|| (int)c == 45 || (int)c == 47 
					|| (int)c == 42)
			{
				tree = new BinaryTree();
				
				tree.addNode(i,String.valueOf(c));
				s.push(tree);
			}
			else
			{
				if(c == ')'){ 
					tree2 = s.pop();			
					tree = s.pop();
					tree1 = s.pop();
					tree.attach(tree, tree1, tree2);
					s.push(tree);
				}				
			}			
		}
		tree = s.pop();
		System.out.println(tree.sum(tree.root));
	}

//	public void change(String s)
//	{
//		int i = 0;
//		Character c = null;
//		Character[] input = new Character[s.length()];
//		while (i < s.length())
//		{
//			if(Character.isDigit(s.charAt(i)))
//			{
//				int temp = i;
//				while(Character.isDigit(s.charAt(i)))
//				{
//					c = (char)(c + s.charAt(i));
//					i = i + 1;
//				}
//				
//			}
//			else
//			{
//				input[i] = s.charAt(i);
//			}
//			
//		}
//	}
}
