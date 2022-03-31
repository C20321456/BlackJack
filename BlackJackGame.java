package blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJackGame {
	
///////////////////////////////////////////////////////////////	
	private int pickedCard;
	
	private int player_card1;
	private int player_card2;
	
	private int dealer_card1;
	private int dealer_card2;
	
	private int player_Total;
	private int dealer_Total;
	
	private List<Integer> deckOfCards;
	private List<Integer> playingCards;
	
	private Random random_Card;
	
////////////////////////////////////////////////////////////////////////////////	
	
	public BlackJackGame() {
		deckOfCards = new ArrayList<Integer>(
				List.of(1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10));
		
		pickedCard = 0;
		
		player_card1 = 0;
		player_card2 = 0;
		
		dealer_card1 = 0;
		dealer_card2 = 0;
		
		player_Total = 0;
		dealer_Total = 0;
		
		playingCards = new ArrayList<Integer>(deckOfCards);
		
		random_Card = new Random();	
	}
////////////////////////////////////////////////////////////////////////////////	
	public void FirstRound() {
		pickedCard = random_Card.nextInt(0, playingCards.size() + 1);
		player_card1 = deckOfCards.get(pickedCard);
		deckOfCards.remove(pickedCard);
		
		pickedCard = random_Card.nextInt(0, playingCards.size() + 1);
		player_card2 = deckOfCards.get(pickedCard);
		deckOfCards.remove(pickedCard);
		
		
		pickedCard = random_Card.nextInt(0, playingCards.size() + 1);
		dealer_card1 = deckOfCards.get(pickedCard);
		deckOfCards.remove(pickedCard);
		
		pickedCard = random_Card.nextInt(0, playingCards.size() + 1);
		dealer_card2 = deckOfCards.get(pickedCard);
		deckOfCards.remove(pickedCard);
		
		player_Total = player_card1 + player_card2;
		dealer_Total = dealer_card1 + dealer_card2;
		
		System.out.println("Dealers first card: " + dealer_card1);
		
		System.out.println("Your cards: " + player_card1 + " and " + player_card2);
		System.out.println("The card total is: " + player_Total);
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////
	
	public String getPlayerCards() {
		return player_card1 + " and " + player_card2;
	}
	
	public String getDealerCards() {
		return dealer_card1 + " and " + player_card2;
	}
//////////////////////////////////////////////////////////////////////////////////////
	
	public void hit() {
		
		boolean bust;
		
		bust = false;
		
		if(player_Total > 21) {
			bust = true;
			
			System.out.print("You bust. you lost");
			System.out.println("Click new game to play again");
		}
		
		pickedCard = random_Card.nextInt(0, playingCards.size() + 1);
		player_card1 = deckOfCards.get(pickedCard);
		deckOfCards.remove(pickedCard);
		
		player_Total += player_card1;
		
		System.out.println("Your new card is: " + pickedCard);
		System.out.println("The card total is: " + player_Total);
	}
	
///////////////////////////////////////////////////////////////////////////////////
	public void stand() {
		System.out.println("Your total is: " + player_Total);
		System.out.println("Dealer total is: " + dealer_Total);
		
		if (player_Total > 21) {
			System.out.println("You bust, you went over 21");
			System.out.println("Click new game to play again");
		}
		
		if(dealer_Total < player_Total && player_Total < 21) {
			System.out.println("You win by having the biggest hand!");
			System.out.println("Click new game to play again");
		}
		
		if(dealer_Total > player_Total && dealer_Total < 21) {
			System.out.println("Dealer had a bigger hand. you lost");
			System.out.println("Click new game to play again");
		}
		
		if(player_Total == 21) {
			System.out.println("BlackJack!!! you win!");
			System.out.println("Click new game to play again");
		}
	}
//////////////////////////////////////////////////////////////////////////////////
}
