package Card;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
public abstract class Card implements CardInter {
    protected Map<String, List<Integer>> cardInfo;
    protected String description;

    public Card(Map<String, List<Integer>> cardInfo, String description) {
        this.cardInfo = cardInfo;
        this.description = description;
    }

    @Override
    public Map<String, List<Integer>> getCardInform() {
        return cardInfo;
    }

    public void showCardDescription() {
        System.out.println(description);
    }

}