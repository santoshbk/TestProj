package com.problems.witches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Witch {

	static int totalSteps = 0;

	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		long N = 0;
		try {
			line = br.readLine();
			N = Long.parseLong(line);
			
			Witch w = new Witch();
			for (int i = 1; i <= N; i++) {
				try {
					String l = br.readLine();
					int o = Integer.parseInt(l);
					if (o < 0) {
						System.out.println(0);
						continue;
					}
					long k = w.getMinSteps(o);
					System.out.println(k);
				} catch (Exception e) {
				}

			}
		} catch (IOException e1) {
		} catch (Exception e) {
		}
	}

	long getMinSteps(long n) {
		// int [n+1]dp;
		long dp[] = new long[(int) (n+1)];
		dp[1] = 0; // trivial case
		for (int i = 2; i <= n; i++) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
		}
		return dp[(int) n];
	}

}
