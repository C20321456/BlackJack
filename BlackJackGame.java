package blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJackGame {
	
///////////////////////////////////////////////////////////////	
	//the variables I gave for this class
	
	private int indexOfCard;
	
	private int playerCard1;
	private int playerCard2;
	
	private int dealerCard1;
	private int dealerCard2;
	
	private int playerTotal;
	private int dealerTotal;
	
	//these are the arraylists, one is going to copy the other
	private List<Integer> deckOfCards;
	private List<Integer> playingCards;
	
	//this variable will randomise the cards
	private Random randomCard;
	
////////////////////////////////////////////////////////////////////////////////	
	
	//we are starting the class off by creating out array and putting in the values
	public BlackJackGame() {
		deckOfCards = new ArrayList<Integer>( 			//the 1 represents an ace and the 4 tens are the face cards
				List.of(1,2,3,4,5,6,7,8,9,10,10,10,10,	//hearts
			            1,2,3,4,5,6,7,8,9,10,10,10,10,	//spades		
			            1,2,3,4,5,6,7,8,9,10,10,10,10,	//Clubs
			            1,2,3,4,5,6,7,8,9,10,10,10,10)); //diamonds
		
		//we set all of our int values to zero so they wont have anything random in them
		indexOfCard = 0;
		
		playerCard1 = 0;
		playerCard2 = 0;
		
		dealerCard1 = 0;
		dealerCard2 = 0;
		
		playerTotal = 0;
		dealerTotal = 0;
		
		//we use the playing cards array to copy the deck of cards array
		//because we dont want to close the app in order for the array to regenerate
		//so we will be taking cards from the playingCards array
		playingCards = new ArrayList<Integer>(deckOfCards);
		
		//we initiate our random Card
		randomCard = new Random();	
	}
////////////////////////////////////////////////////////////////////////////////	
	public void FirstRound() {
		
		//on the first round the total is set to zero as to make it a new game
		playerTotal = 0;
		dealerTotal = 0;
		
		//we copy the deck of cards array
		playingCards = new ArrayList<Integer>(deckOfCards);
		
		//we pick a random cards from 0 to the size of the array. we pick the position of that array
		//then we get its value when the randomiser picks a position
		//after that we delete it, so we dont get that card again for this round
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		playerCard1 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		//same logic applies here too
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		playerCard2 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		
		//as well as here for both the dealers cards
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		dealerCard1 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		dealerCard2 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		//we add up the cards values to get our total
		playerTotal = playerCard1 + playerCard2;
		dealerTotal = dealerCard1 + dealerCard2;
		
		//we show the player/user the dealers first card
		System.out.println("\n\nDealers first card: " + dealerCard1);
		
		//we show the player their cards and the total they got
		System.out.println("Your cards: " + playerCard1 + " and " + playerCard2);
		System.out.println("The card total is: " + playerTotal);
	}
//////////////////////////////////////////////////////////////////////////////////////

	public void hit() {
		//for this method hit. we give the user another card from the array and remove it after
		indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
		playerCard1 = playingCards.get(indexOfCard);
		playingCards.remove(indexOfCard);
		
		//we add the value to the players total
		playerTotal += playerCard1;
		
		//we display what card the player got and their new total
		System.out.println("\nYour new card is: " + playerCard1);
		System.out.println("The card total is: " + playerTotal);
	}
	
///////////////////////////////////////////////////////////////////////////////////////
	//these methods are for displaying info to the GUI
	//like the getplayerTotal displays the total value the player has
	public int getPlayerTotal() {
		return playerTotal;
	}
	
	public int getDealerTotal() {
		return dealerTotal;
	}
	
	//this displays what values the player got
	public String getPlayerCard() {
		return playerCard1 + " and  " + playerCard2;
	}
	
	//this displays what values the dealer got
	public int getDealerCard() {
		return dealerCard1;
	}
	
	//and this displays what new card the player got after they hit
	public int getNewCard() {
		return playerCard1;
	}
	
///////////////////////////////////////////////////////////////////////////////////////
	//these logics make sure that the game knows who wins or loses
	//isBust makes sure if the player exceeds 21 or not
	public boolean isBust() {
		if(playerTotal > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean dealerBust() {
		if(dealerTotal > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//dealerWins makes sure if the dealer won or lost. so for the dealer to win
	//they should have a total greater then the player but shouldnt exceed 21
	public boolean dealerWins() {
		if(dealerTotal > playerTotal && dealerTotal <= 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//same logic applies as with dealerWins. but its for the player
	public boolean playerWins() {
		if(dealerTotal < playerTotal && playerTotal < 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//this is to see if the player hit 21 or Blackjack
	public boolean blackJackWin() {
		if(playerTotal == 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean draw() {
		if(playerTotal == dealerTotal) {
			return true;
		}
		else {
			return false;
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////
	public void stand() {
		//when a user hits stand. the dealer starts to get cards one by one until he exceeds 17
		while (dealerTotal < 17) {
			indexOfCard = randomCard.nextInt(0, playingCards.size() + 1);
			dealerCard1 = playingCards.get(indexOfCard);
			playingCards.remove(indexOfCard);
			
			//we print out the dealers total
			System.out.println("dealer got: " + dealerCard1);
			
			//we add the card value to the total
			dealerTotal += dealerCard1;
		}
		
		//if the player goes over 21. we print the following messages
		if (playerTotal > 21) {
			System.out.println("You bust, you went over 21");
			System.out.println("Click new game to play again");
		}
		
		//if the player wins by having the greater total and not exceeding 21. we print the following messages
		if(dealerTotal < playerTotal && playerTotal < 21) {
			System.out.println("You win by having the biggest hand!");
			System.out.println("Click new game to play again");
		}
		
		//if the dealer wins by having the greater total and not exceeding 21. we print the following messages
		if(dealerTotal > playerTotal && dealerTotal < 21) {
			System.out.println("Dealer had a bigger hand. you lost");
			System.out.println("Click new game to play again");
		}
		
		//if the player wins by having a perfect 21. we print the following messages
		if(playerTotal == 21) {
			System.out.println("BlackJack!!! you win!");
			System.out.println("Click new game to play again");
		}
		
		//we print the total of the player and the dealer in the terminal
		System.out.println("Your total is: " + playerTotal);
		System.out.println("Dealers total: " + dealerTotal);
	}
//////////////////////////////////////////////////////////////////////////////////
}
