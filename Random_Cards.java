package blackJack;

import java.util.Random;

public class Random_Cards {
	
	public static Random theInstance = null;
	
	public Random_Cards() {
		
	}
	
	public static Random getInstance() {
		if(theInstance == null) {
			theInstance = new Random();
		}
		return theInstance;
	}
	
	public static boolean nextBoolean() {
		return Random_Cards.getInstance().nextBoolean();
	}
	
	public static boolean nextBoolean(double probability){
		return Random_Cards.nextDouble() < probability;
	}
	
	
	public static int nextInt(){
		return Random_Cards.getInstance().nextInt();
	}

	
	public static int nextInt(int n){
		return Random_Cards.getInstance().nextInt(n);
	}

	
	public static int nextInt(int min, int max){
		return min + Random_Cards.nextInt(max - min + 1);
	}

	private static double nextDouble() {
		return Random_Cards.getInstance().nextDouble();
	}
	
	public static double nextDouble(double min, double max){
		return min + (max - min) * Random_Cards.nextDouble();
	}
	
	
}
