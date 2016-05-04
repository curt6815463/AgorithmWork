import java.util.regex.*;
public class BinaryTree 
{
	Node root;
	public boolean isNum(String str)
	{
		 Pattern pattern = Pattern.compile("[0-9]*");
		 return pattern.matcher(str).matches();
	}
	int k = 0;
	public float sum(Node n)
	{
		float x,y;
		if(isNum(n.name))
		{
			return Float.parseFloat(n.name);
		}
		if (n.name.equals("+"))
			{
				
				x = sum(n.leftChild);
				y = sum(n.rightChild);
			
				return x+y;
			}
			else if (n.name.equals("-"))
			{
				x = sum(n.leftChild);
				y = sum(n.rightChild);
		
				return x-y;
			}
			else if (n.name.equals("*"))
			{
				x = sum(n.leftChild);
				y = sum(n.rightChild);
			
				return x*y;
			}
			else if (n.name.equals("/"))
			{
				x = sum(n.leftChild);
				y = sum(n.rightChild);
				
				return x/y;
			}
		return 0;
	}
	
	public boolean isInternalNode(Node n)
	{
		if (n.leftChild == null && n.rightChild == null)
		{
			return false;
		}
		return true;
	}
	
	public void attach(BinaryTree t1, BinaryTree t2, BinaryTree t3)
	{
		t1.root.leftChild = t2.root;
		t1.root.rightChild = t3.root;
	}
	
	public void postOrderTraverse(Node n)
	{
		if(n != null){
		
			postOrderTraverse(n.leftChild);
			postOrderTraverse(n.rightChild);
			System.out.println(n.name);
		}
		
	}
	
	public void addNode(int key, String name)
	{
		Node newNode = new Node(key,name);
		
		if(root == null)
		{
			root = newNode;
		}
		
		else
		{
			Node focusNode = root;
			Node parent;
			
			while(true)
			{
				parent = focusNode;
				if(key < focusNode.key)
				{
					focusNode = focusNode.leftChild;
					if(focusNode == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
					focusNode = focusNode.rightChild;
					if(focusNode == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
}
