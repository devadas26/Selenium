package com.Test;

import java.util.HashSet;
import java.util.Iterator;

public class Listcoll {

	public static void main()
	{
		HashSet<String> hs=new HashSet<String>();
		hs.add("one");
		hs.add("two");
		hs.add("three");
		Iterator<String> itr = hs.iterator();
		while(itr.hasNext())
		{
			System.out.println("reading from hash set"+itr.next());
		}
	}
}
