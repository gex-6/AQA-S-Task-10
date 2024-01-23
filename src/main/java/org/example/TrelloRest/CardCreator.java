package org.example.TrelloRest;

public class CardCreator {

    public static CardDTO createCardOnlyRequired () {
        CardDTO card = new CardDTO();
        card.setCardName("Test Card");
        card.setListId("65abc037127ce2d368e380ae");
        card.setDescription("hello my friend");
        card.setComment("I'm a big commenter");
        return card;
    }
}
