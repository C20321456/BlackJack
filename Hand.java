package blackJack;

import java.util.ArrayList;

public class Hand {
	
	private static final int hearts = 0;
    private static final int diamonds = 1;
    private static final int spades = 2;
    private static final int clubes = 3;

    private static final int jack = 11;
    private static final int queen = 12;
    private static final int king = 13;
    private static final int ace = 14;
    
    private ArrayList<Card> cards;
    
    public Hand() {
    	cards = new ArrayList<Card>();
    }
    
    public void addAcard(Card c) {
    	cards.add(c);
    }
    
    public int getValue() {
    	int val = 0;
    	int count = 0;
    	
    	for(Card c: cards) {
    		val += c.getValue();
    		
    		if(c.getRank() == ace) {
    			count++;
    		}
    	}
    	
    	while(val > 21 && count > 0) {
    		val -= 10;
    		count--;
    	}
    	return val;
    }
    
    public boolean 21()

}
