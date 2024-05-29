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
    Map<String,Integer> resource;
    Set<Card> deckSet;//파이터가 가질 수 있는 카드의 종류
    List<Card> deckList;//파이터가 가진 카드들
    int deckremain=0;
    int deckoffset=0;
    int hand;//한번 턴에 낼 수 있는 카드

    public Card[] chooseCards(Boolean isEnemy) {
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
            //choose card
            System.out.println("Choose Cards");
            return cards;
        }
    }

    public Set<Card> getDeckSet() {
        return deckSet;
    }
    public Map<String,Integer> getResource(){
        return resource;
    }

    @Override
    public void showdescript() {
        //파이터의 소개정보 출력
    }

    /*Set<String> keySet = resource.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + resource.get(key));
        }*/

    @Override
    public void setFighterResource(Map<String,Integer> change) {
        //카드로 인한 캐릭터의 정보가 바뀜(hp-1과 같은)
    }

    @Override
    public void showInventory() {
        //캐릭터가 가진 카드를 보여주기
    }

    @Override
    public void getreward(Card reward) {
        //카드를 추가
    }
}