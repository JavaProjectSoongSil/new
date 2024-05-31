package Card;

import java.util.Map;
import java.util.List;
public abstract class Card implements CardInter {
    //카드 뽑기
    // 'cardAbility'는 카드의 능력을 나타내는 맵입니다.
    // 키는 능력의 이름을 나타내고, 값은 해당 능력의 효과를 나타내는 정수 리스트입니다.
    // 예를 들어, "damage"라는 능력이 있다면, 이 능력의 효과는 상대방의 체력을 감소시키는 것일 수 있습니다.
    Map<String,List<Integer>> cardAbility;//상대방이나 자신에게도 효과

    /*Set<String> keySet = cardAbility.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + resource.get(key));
        }*/
    @Override
    public Map<String,List<Integer>> getCardInform() {
        // 'getCardInform' 메서드는 카드의 능력 정보를 반환합니다.
        return cardAbility;
    }

}