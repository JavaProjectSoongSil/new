package Fighter;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import Card.Card;
public abstract class Fighter implements FighterInter {
    //체력 방어
    //아이템
    //카드 사용
    //카드를 고를 수 있는 개수
    Map<String,Integer> resource;//hand,"HP"
    Set<Card> deckSet;//파이터가 가질 수 있는 카드의 종류
    List<Card> deckList;//파이터가 가진 카드들
    int deckremain=0;
    int deckoffset=0;
    int hand;//한번 턴에 낼 수 있는 카드

    public Card[] chooseCards(Boolean isEnemy) {
        // 이 메서드는 카드를 선택하는 로직을 담당합니다.
        // isEnemy가 true인 경우, 적이 카드를 선택하는 로직을 수행합니다.
        // isEnemy가 false인 경우, 사용자가 카드를 선택하는 로직을 수행합니다.
        if(isEnemy) {
            Card[] cards = new Card[hand];
            System.out.println("Choose Cards");//choose card random for decide enemy action
            return cards;
        }
        else{

            Card[] cards=new Card[hand];
            deckremain=deckList.size();
            //덱에서 카드 뽑기
            for(int i=deckoffset;deckoffset<i+hand;deckoffset++){
                cards[deckoffset-i]=deckList.get(deckoffset%deckremain);
            }
            deckoffset=deckoffset%deckremain;
            deckremain-=hand;
            if(deckremain<0){
                deckremain=deckList.size()-deckremain;
            }
            //카드 정보를 번호를 부여해 보여주기
            //choose card
            System.out.println("Choose Cards");
            return cards;
        }
    }

    public Set<Card> getDeckSet() {
        // 이 메서드는 파이터가 가질 수 있는 카드의 종류를 반환합니다.
        return deckSet;
    }
    public Map<String,Integer> getResource(){
        // 이 메서드는 파이터의 자원을 반환합니다.
        return resource;
    }

    @Override
    public void showDescript() {
        // 이 메서드는 파이터의 소개 정보를 출력합니다.
        //파이터의 소개정보 출력
    }

    /*Set<String> keySet = resource.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + resource.get(key));
        }*/

    @Override
    public void setFighterResource(Map<String,Integer> change) {
        // 이 메서드는 카드의 효과에 따라 파이터의 자원을 변경합니다.
        // 예를 들어, 카드의 효과로 체력이 1 감소한다면, "HP"의 값을 1 감소시킵니다.
        //카드로 인한 캐릭터의 정보가 바뀜(hp-1과 같은)
    }

    @Override
    public void showInventory() {
        // 이 메서드는 파이터가 가진 카드를 출력합니다.
        //캐릭터가 가진 카드를 보여주기
    }

    @Override
    public void getreward(Card reward) {
        // 이 메서드는 보상으로 카드를 받는 로직을 담당합니다.
        // reward로 받은 카드를 deckList에 추가합니다.
    }
}