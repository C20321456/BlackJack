package blackJack;

public class Card {
	
	
	private static final int hearts = 0;
	private static final int diamonds = 1;
	private static final int spades = 2;
	private static final int clubes = 3;
	    
	private static final int jack = 11;
	private static final int queen = 12;
	private static final int king = 13;
	private static final int ace = 14;
	
	private int the_Rank;
	private int suit;
	private int value;
	
	private String[] ranks = {"Covered", "Covered", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	private String[] suits = {"Hearts", "Diamonds", "Spades", "Clubes"};
	
	public Card(int r, int s) {
		the_Rank = r;
		suit = s;
	}
	
	public int getRank() {
		return the_Rank;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public int getValue() {
		int value = the_Rank;
		if(the_Rank > 10) {
			value = 10;
		}
		
		if(the_Rank == ace) {
			value = 11;
		}
		return value;
	}
	
	public String rankToString(int r)
    {
        return ranks[r];
    }
    
    
    public String suitToString(int s)
    {
        return suits[s];
    }
    
    
    public String getSuitAsString()
    {
        return suitToString(suit);
    }
    
    
    public String getRankAsString()
    {
        return rankToString(the_Rank);
    }
    
  
    public String toString()
    {
        
        String rankString = ranks[the_Rank];
        
        
        String suitString = suits[suit];
        
        return rankString + suitString;
    }

}
