/**
 * 
 */
package com.intw.prep.kit.warmup;

/**
 * @author AD79272
 *
 */
public class JumpingOnClouds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JumpingOnClouds main = new JumpingOnClouds();
		
		int[] c = new int[] {0,0,1,0,0,1,0};
		int jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
		
		c = new int[] {0,0,0,0,1,0};
		jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
		
		c = new int[] {0,0};
		jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
		
		c = new int[] {0,0,0};
		jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
		
		c = new int[] {0,0,0,0};
		jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
		
		c = new int[] {0,0,0,0,0,0};
		jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
		
		c = new int[] {0,0,0,0,0,0,0};
		jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
		
		c = new int[] {0,0,0,0,0,0,1,0};
		jumps = main.jumpingOnClouds(c);
		System.out.println("main.jumps : " + jumps);
	}

	static int jumpingOnClouds(int[] c) {
		if(c == null || c.length == 0)
		{
			return 0;
		}
		
		int jumps = 0;
		for (int i = 0; i < c.length - 1; i++) {
			if(i+2 < c.length && c[i+2] != 1)
			{
				i++;
			}
			jumps++;
		}
		
		return jumps;
	}

}
