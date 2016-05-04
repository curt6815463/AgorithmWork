
import java.util.*;

public class Test {

	public static void main(String[] args) {		
		String input = "((1000+(5*2))/(2+3))";	
		Stack<BinaryTree> s = new Stack<BinaryTree>();		
		BinaryTree tree;
		BinaryTree tree1;
		BinaryTree tree2;
		
		BinaryTree treeTemp;
		String temp = "";
		int tempIndex = 0;
		for(int i = 0 ; i < input.length() ; i++)
		{		
			char c = input.charAt(i);
			
			if(Character.isDigit(c))
			{
				temp += c;
				tempIndex++;
			}
			if (tempIndex > 0)
			{
				if(!Character.isDigit(c))
				{
					treeTemp = new BinaryTree();
					treeTemp.addNode(i, String.valueOf(temp));
					s.push(treeTemp);				
					tempIndex = 0;
					temp = "";
				}
			}
			if((int)c == 43 
					|| (int)c == 45 || (int)c == 47 
					|| (int)c == 42)
			{
				treeTemp = new BinaryTree();
				treeTemp.addNode(i,String.valueOf(c));
				s.push(treeTemp);
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

}
