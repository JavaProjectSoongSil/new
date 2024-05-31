package Game;

import Fighter.Fighter;
import Stage.Stage;

import java.util.Map;
import java.util.Set;

public class Game implements GameInter{
    int rank; // 게임의 랭크를 나타내는 변수입니다. 게임이 진행됨에 따라 증가합니다.
    Set<Fighter> userset; // 사용자가 선택할 수 있는 파이터들의 집합입니다.
    Set<Fighter> enemyset; // 게임에서 만날 수 있는 적들의 집합입니다.
    Fighter user; // 사용자가 선택한 파이터입니다.
    Map<String,Integer> diff; // 난이도와 그에 따른 점수를 매핑하는 맵입니다. 예를 들어, "상"은 3, "중"은 2, "하"은 1과 같이 매핑될 수 있습니다.
    int difficulty; // 게임의 난이도를 나타내는 변수입니다. 'diff' 맵에서 해당 난이도의 점수를 가져와 저장합니다.
    String name; // 사용자의 이름을 저장하는 변수입니다.
    Stage stage = new Stage(); // 게임의 스테이지입니다. 각 스테이지에서는 사용자와 적이 싸웁니다.
    public Game(String difficulty,String name) {
        //set user and enemy
        //set diff
        this.difficulty=diff.get(difficulty);
        this.name = name;
        rank = 0;
        //difficulty로 user가 만들어진 캐릭터와 enemy의 초기값이 다름
    }

    @Override
    public void introduceFighter() {
        // 이 메서드는 파이터의 소개 정보를 출력합니다.
        // 사용자가 선택할 수 있는 파이터의 정보를 보여주는 로직이 필요합니다.
    }

    @Override
    public void chooseFighter(String fighter) {
// 이 메서드는 사용자가 선택한 파이터를 설정합니다.
        // 파라미터로 전달된 'fighter'를 이용하여 'user' 변수를 설정하는 로직이 필요합니다.
    }

    @Override
    public void makeStage() {
        // 이 메서드는 스테이지를 생성합니다.
        // 'stage' 객체의 'setEnemyAndReward' 메서드를 호출하여 적과 보상을 설정합니다.
        stage.setEnemyAndReward(user,enemyset);
    }

    @Override
    public String inCombat() {
        // 이 메서드는 전투를 진행하고 결과를 반환합니다.
        // 'stage' 객체의 'battleResult' 메서드를 호출하여 전투를 진행하고,
        // 사용자의 체력이 0 이하인 경우 "그만"을 반환하고, 그렇지 않은 경우 'endStage' 메서드를 호출하고 "진행"을 반환합니다.
        while(stage.battleResult(user));
        if(user.getResource().get("HP")<=0) {
            System.out.println("당신은 죽었습니다.");
            return "그만";
        }
        else {
            endStage();
            return "진행";
        }
    }

    @Override
    public void endStage() {
        // 이 메서드는 스테이지를 종료하고 보상을 받습니다.
        // 'stage' 객체의 'endStage' 메서드를 호출하여 보상을 받고, 랭크를 증가시킵니다.
        stage.endStage(user);
        rank+=difficulty*1;
        //현재 점수 출력
    }

    @Override
    public void endGame() {
        // 이 메서드는 게임을 종료하고 최종 랭크를 출력합니다.
        // 사용자의 이름과 최종 랭크를 출력합니다.
        System.out.print(name+"\nYour rank is" +rank);
    }
}
