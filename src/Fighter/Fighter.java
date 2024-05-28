package Fighter;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import Card.Card;
import Item.Item;
public abstract class Fighter implements FighterInter {
    //체력 방어
    //아이템
    //카드 사용
    //카드를 고를 수 있는 개수
    Map<String,Integer> resource;
    Set<Card> deckSet;//파이터가 가질 수 있는 카드의 종류
    List<Card> deckList;//파이터가 가진 카드들
    Set<Item> itemSet;
    List<Item> itemsList;
    int deckremain=0;
    int deckoffset=0;
    int hand;//한번 턴에 낼 수 있는 카드
    @Override
    public Card[] chooseCards() {
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
    public Card[] chooseCards(Boolean isEnemy) {
        Card[] cards=new Card[hand];
        System.out.println("Choose Cards");//choose card random for decide enemy action
        return cards;
    }

    public Set<Card> getDeckSet() {
        return deckSet;
    }
    public Map<String,Integer> getResource(){
        return resource;
    }
    @Override
    public void showFighterInform() {
        /*Set<String> keySet = resource.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + resource.get(key));
        }*/
        System.out.println("show information");//카드를 고르는 도중에 캐릭터의 정보 보여주기
    }

    @Override
    public void setFighterResource(Map<String,Integer> change) {
        //카드로 인한 캐릭터의 정보가 바뀜(hp-1과 같은)
    }

    @Override
    public void showInventory() {
        //캐릭터가 가진 카드와 장착된 아이템 보여주기
    }

    @Override
    public void getreward(int[] reward) {
        //내 카드를 강화하거나 카드를 추가하거나 아이템을 얻음(3가지 모두 일수도 있고 일부일수도)
    }
}