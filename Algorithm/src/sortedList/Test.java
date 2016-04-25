package sortedList;

import java.util.Iterator;

import sortedList.FavoriteList.Entry;
import java.util.*;

public class Test 
{
	public static void main(String[] args) throws Exception 
	{
		FavoriteList<String> list = new FavoriteList<String>();
		System.out.println("add is add new element \n"
				+ "remove is remove a element \n"
				+ "size is return the number of elements \n"
				+ "isEmpty is return whether the List is empty\n"
				+ "top is return an iterable collection of the element accessed elements");
		System.out.println("Please start to add function\n");
		System.out.println("===============================");
		Scanner scan = new Scanner(System.in);
		String input_function = scan.nextLine();
		while(input_function != "exit")
		{
			String input_element;
			int count;
			switch(input_function)
			{
				case "add" :
					input_element = scan.nextLine();
					list.addElement(input_element);
					break;
				case "access" :
					input_element = scan.nextLine();
					list.access(input_element);
					break;
				case "remove" :
					input_element = scan.nextLine();
					list.remove(input_element);
					break;
				case "size" :
					System.out.println(list.size());
					break;
				case "isEmpty" :
					System.out.println(list.isEmpty());
					break;
				case "top" :
					count = scan.nextInt();
					Iterator<String> itr2 = list.top(2).iterator();
					while(itr2.hasNext())
					{
						System.out.println(itr2.next());
					}	
					break;
				case "print" :
					Iterator<Entry<String>> itr = list.fList.iterator();
					while(itr.hasNext())
					{
						System.out.println(itr.next());
					}
					break;
				default:
					System.out.println("Not the instruction");
			}
			input_function = scan.nextLine();	
		}
//		FavoriteList<String> list = new FavoriteList<String>();
//		list.addElement("asdf");
//		list.addElement("asd");
//		list.addElement("af");
//		list.addElement("affff");
//		list.addElement("afffff");
//		list.remove("affff");
//		list.access("asd");
//		list.access("asd");
//		list.access("asd");
//		list.access("asdaaaaaa");
//		list.access("asdaaaaaa");
//		list.access("asdaaaaaa");
//		list.access("asdaaaaaa");
//		list.access("asdaaaaaa");
//		list.access("asdaaaaaa");
//		list.remove("af");		
//		Iterator<Entry<String>> itr = list.fList.iterator();
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//		}
//		System.out.println(list.size());
//		System.out.println(list.isEmpty());
//		Iterator<String> itr2 = list.top(2).iterator();
//		while(itr2.hasNext())
//		{
//			System.out.println(itr2.next());
//		}
//		
	}


}
