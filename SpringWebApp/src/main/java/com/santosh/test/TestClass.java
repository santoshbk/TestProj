package com.santosh.test;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
	
	public static void main(String[] args) {
		
		/*Integer[] intt = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		int count = 0;
		int size = intt.length;
		for (Object entity : intt)
		{
			count++;
			System.out.println("outside if "+count);
			if (count % 10 == 0 || size == count) 
			{
				System.out.println("inside if " + count);
			}
		}*/
		/*Integer ab =null;
		AA aa = new AA();
		System.out.println(aa);*/
		List<AA> a = new ArrayList<AA>();
		a.add(null);
		a.add(null);
		a.add(null);
		a.add(null);
		System.out.println(a.size());
		for (AA aa : a) {
			System.out.println(aa);
		}

		
		
	}

}

class AA{
	
}
