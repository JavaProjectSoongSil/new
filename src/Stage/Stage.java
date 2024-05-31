package Stage;
import java.util.*;

import Fighter.Fighter;
import Card.Card;

public class Stage implements StageInter{
    Map<String,Integer> userChange; // 사용자의 상태 변화를 저장하는 맵입니다. 예를 들어, 체력 감소, 방어력 증가 등의 변화를 저장할 수 있습니다.
    Map<String,Integer> enemyChange; // 적의 상태 변화를 저장하는 맵입니다. 예를 들어, 체력 감소, 방어력 증가 등의 변화를 저장할 수 있습니다.
    Fighter enemy; // 현재 스테이지의 적을 나타내는 변수입니다.
    Card reward; // 스테이지를 클리어했을 때 얻을 수 있는 보상을 나타내는 변수입니다.
    @Override
    public void setEnemyAndReward(Fighter user,Set<Fighter> enemyset) {
        // 이 메서드는 적과 보상을 설정합니다.
        // 사용자의 덱에서 무작위로 카드를 선택하여 보상으로 설정합니다.
        List<Card> cards=new ArrayList<>(user.getDeckSet());
        Random rand=new Random();
        int randomNum=rand.nextInt(cards.size());
        reward=cards.get(randomNum);//보상용 카드 선택
    }

    @Override
    public boolean battleResult(Fighter user) {
        // 이 메서드는 전투 결과를 계산하고 반환합니다.
        // 사용자와 적이 각각 카드를 선택하고, 그 결과에 따라 상태 변화를 적용합니다.
        // 사용자나 적의 체력이 0 이하가 되면 전투가 종료되고, 그 결과를 반환합니다.
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
        // 이 메서드는 스테이지 종료 시 처리를 합니다.
        // 스테이지를 클리어한 사용자에게 보상 카드를 제공합니다.
        //추가될 카드 정보 출력
        user.getreward(reward);
    }


}
