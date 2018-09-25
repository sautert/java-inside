package fr.umlv.javainside.labone;

public class Sums {
	public static int loopSum(int limit) {
		int ret;
		
		for (ret = 0; limit > 0; limit--) {
			ret += limit;
		}
		System.out.println("loopSum : " + ret);
		return (ret);
	}
	
	public static int streamSum(int limit) {
		int ret = 0;
		
		
		System.out.println("streamSum : " + ret);
		return (ret);
	}
}
