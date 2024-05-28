package Card;

import java.util.Map;
import java.util.List;
public abstract class Card implements CardInter {
    //카드 뽑기
    Map<String,List<Integer>> cardAbility;//상대방이나 자신에게도 효과
    @Override
    public void showCard() {
        /*Set<String> keySet = cardAbility.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + resource.get(key));
        }*/
        System.out.print("showcard");
    }

    @Override
    public Map<String,List<Integer>> getCardInform() {
        return cardAbility;
    }

}