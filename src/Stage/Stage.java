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
    public void setEnemyAndReward( int difficulty,Fighter user) {
        List<Card> cards=new ArrayList<>(user.getDeckSet());
        Random rand=new Random();
        int randomNum=rand.nextInt(cards.size());
        reward=cards.get(randomNum);//보상용 카드 선택
    }

    @Override
    public boolean battleResult(Fighter user) {
        Scanner scanner=new Scanner(System.in);
        user.showFighterInform();
        enemy.showFighterInform();
        System.out.println("카드를 고르세요");
        scanner.next();
        Card[] userCard=user.chooseCards();
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
        user.getreward(reward);
    }

    @Override
    public void showEnemyInform() {
        enemy.showFighterInform();
    }

    @Override
    public void showUserInform(Fighter user) {
        user.showFighterInform();
    }

}
