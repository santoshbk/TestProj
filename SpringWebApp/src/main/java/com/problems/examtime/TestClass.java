package com.problems.examtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class TestClass {

	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String args[]) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			String lne = br.readLine();
			int K = Integer.parseInt(lne);
			int count = 0;
			if (K < 1) {
				System.out.println(0);
			} else if (K == 1) {
				System.out.println(1);
			} else {
				for (int j = 1; j < K; j++) {
					if(GCD(j, K) == 1){
						count++;
					}
				}
				System.out.println(count);
				
			}
			
			/*if (K < 1) {
				System.out.println(0);
			} else if (K == 1) {
				System.out.println(1);
			} else {

				for (int j = 2; j < K; j++) {
					if (isPrime(j)) {
						list.add(j);
					}
				}
				List<Integer> lista = new ArrayList<Integer>();
				for (int j = 0; j < list.size(); j++) {
					if (K % list.get(j) == 0) {
						lista.add(list.get(j));
					}
				}
				if (isPrime(K)) {
					list.add(K);
				}
				list.removeAll(lista);
			}
			System.out.println(list.size() + 1);
			list.clear();*/
		}

	}

	static boolean isPrime(int n) {
		if (n == 1)
			return true;
		if (n == 2)
			return true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static int GCD(int a, int b) {
		return b == 0 ? a : GCD(b, a % b);
	}
	
	static int gcdd(int num1, int num2)
	{
	    boolean found=false;
	    int test=0;
	    
	    //Determining which num has the smallest absolute value.
	    //test will be the starting point for testing divisibility.
	    if( Math.abs(num1) < Math.abs(num2))
	        test= Math.abs(num1);
	    else
	        test= Math.abs(num2);
	    
	    //Using the integer with the smallest absolute value to test for even
	    //    divisibility.  decrementing it by 1 and re-testing each time
	    //    it does not divide evenly.
	    while( !found )
	    {
	        if( num1 % test==0 && num2 % test==0)  //If the number divides evenly into both.
	        {
	            found=true;
	        }
	        else
	            test--;
	    }
	    return(test); 
	}

}
