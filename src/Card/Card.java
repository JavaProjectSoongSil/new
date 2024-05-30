package Card;

import java.util.Map;
import java.util.List;
public abstract class Card implements CardInter {
    //카드 뽑기
    Map<String,List<Integer>> cardAbility;//상대방이나 자신에게도 효과
    /*Set<String> keySet = cardAbility.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + resource.get(key));
        }*/
    @Override
    public Map<String,List<Integer>> getCardInform() {
        return cardAbility;
    }

}