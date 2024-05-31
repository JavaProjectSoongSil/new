package Card;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
public abstract class Card implements CardInter {
    protected Map<String, List<Integer>> cardInfo;

    public Card() {
        cardInfo = new HashMap<>();
    }
    @Override
    public Map<String,List<Integer>> getCardInform() {
        return null;
    }
}