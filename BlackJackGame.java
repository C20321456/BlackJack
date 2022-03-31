package blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJackGame {
	
///////////////////////////////////////////////////////////////	
	private int indexOfCard;
	
	private int playerCard1;
	private int playerCard2;
	
	private int dealerCard1;
	private int dealerCard2;
	
	private int playerTotal;
	private int dealerTotal;
	
	private List<Integer> deckOfCards;
	private List<Integer> playingCards;
	
	private Random randomCard;
	
////////////////////////////////////////////////////////////////////////////////	
	
	public BlackJackGame() {
		deckOfCards = new ArrayList<Integer>(
				List.of(1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10));
		
		indexOfCard = 0;
		
		playerCard1 = 0;
		playerCard2 = 0;
		
		dealerCard1 = 0;
		dealerCard2 = 0;
		
		playerTotal = 0;
		dealerTotal = 0;
		
		playingCards = new ArrayList<Integer>(deckOfCards);
		
		randomCard = new Random();	
	}
////////////////////////////////////////////////////////////////////////////////	
	public void FirstRound() {
		
		playerTotal = 0;
		dealerTotal = 0;
		
		playingCards = new ArrayList<Integer>(deckOfCards);
		
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		playerCard1 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		playerCard2 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		dealerCard1 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		dealerCard2 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		playerTotal = playerCard1 + playerCard2;
		dealerTotal = dealerCard1 + dealerCard2;
		
		System.out.println("\n\nDealers first card: " + dealerCard1);
		
		System.out.println("Your cards: " + playerCard1 + " and " + playerCard2);
		System.out.println("The card total is: " + playerTotal);
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////
	
	public int getPlayerTotal() {
		return playerTotal;
	}
//////////////////////////////////////////////////////////////////////////////////////

	public void hit() {
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		playerCard1 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		playerTotal += playerCard1;
		
		System.out.println("\nYour new card is: " + playerCard1);
		System.out.println("The card total is: " + playerTotal);
	}
	
///////////////////////////////////////////////////////////////////////////////////////
	public String getPlayerCard() {
		return playerCard1 + " and  " + playerCard2;
	}
	
	public int getDealerCard() {
		return dealerCard1;
	}
	
	
	public int getNewCard() {
		return playerCard1;
	}
	
///////////////////////////////////////////////////////////////////////////////////////
	
	public boolean isBust() {
		if(playerTotal > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean dealerWins() {
		if(dealerTotal > playerTotal && dealerTotal < 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean playerWins() {
		if(dealerTotal < playerTotal && playerTotal < 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean blackJackWin() {
		if(playerTotal == 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////
	public void stand() {
		System.out.println("Your total is: " + playerTotal);
		
		while (dealerTotal < 17) {
			indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
			dealerCard1 = playingCards.get(indexOfCard);
			playingCards.remove(indexOfCard);
			
			System.out.println("dealer got: " + dealerCard1);
			
			dealerTotal += dealerCard1;
			
			System.out.println("Dealers total: " + dealerTotal);
		}
		
		if (playerTotal > 21) {
			System.out.println("You bust, you went over 21");
			System.out.println("Click new game to play again");
		}
		
		if(dealerTotal < playerTotal && playerTotal < 21) {
			System.out.println("You win by having the biggest hand!");
			System.out.println("Click new game to play again");
		}
		
		if(dealerTotal > playerTotal && dealerTotal < 21) {
			System.out.println("Dealer had a bigger hand. you lost");
			System.out.println("Click new game to play again");
		}
		
		if(playerTotal == 21) {
			System.out.println("BlackJack!!! you win!");
			System.out.println("Click new game to play again");
		}
	}
//////////////////////////////////////////////////////////////////////////////////
}
