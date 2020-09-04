package CardsWithPower;

public class Card {
    private String type;
    private String suit;

    public Card(String type, String suit) {
        this.type = type;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.type,
                this.suit,
                calculatePower());
    }
    private int calculatePower(){
        return Power.valueOf(this.type).getValue()+
                Suits.valueOf(suit).getValue();
    }
}
