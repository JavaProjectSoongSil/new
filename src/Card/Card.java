package Card;

import java.util.Map;
import java.util.List;
public abstract class Card implements CardInter {
    //카드 뽑기
    Map<String,List<Integer>> cardAbility;//상대방이나 자신에게도 효과
    Map<String,List<Integer>> enforcement;//강화할때마다 얼마나 강해지는 수치,강화해줄 부분
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

    @Override
    public void enforceCard(Card card) {
        //강화하기;
    }
}