package Card;

import java.util.Map;
import java.util.List;
public interface CardInter {
    void showCard();
    Map<String,List<Integer>> getCardInform();
    void enforceCard(Card card);
}
