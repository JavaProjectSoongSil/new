package Stage;
import java.util.*;

import Fighter.Fighter;
import Card.Card;

public class Stage implements StageInter{
    Map<String,Integer> userChange;
    Map<String,Integer> enemyChange;
    Fighter enemy;
    Card reward;
    int stagenum=0;
    @Override
    public void setEnemyAndReward(Fighter user) {
        List<Card> cards=new ArrayList<>(user.getDeckSet());
        Random rand=new Random();
        int randomNum=rand.nextInt(cards.size());
        reward=cards.get(randomNum);//보상용 카드 선택
    }

    @Override
    public boolean battleResult(Fighter user) {
        Scanner scanner=new Scanner(System.in);
        //getResource로 캐릭터의 요소 보여주기
        System.out.print("상대방의 카드를 보실려면 enemy를 입력하고 자신의 카드를 보려면 user를 입력하세요");
        System.out.println("카드를 고르세요");
        //입력을 받고 상대방 카드를 보여주거나 내카드를 보여주거나 카드를 골랐다면 다음 흐름으로
        Card[] userCard=user.chooseCards(false);
        Card[] enemyCard=enemy.chooseCards(true);
        //카드의 작업에 따라 userChage와 enemyChange를 업데이트
        user.setFighterResource(userChange);
        enemy.setFighterResource(enemyChange);
        int userHp=user.getResource().get("HP");
        int enemyHp=enemy.getResource().get("HP");
        return userHp<=0||enemyHp<=0;
    }

    @Override
    public void endStage(Fighter user) {
        //추가될 카드 정보 출력
        user.getreward(reward);
    }


}
