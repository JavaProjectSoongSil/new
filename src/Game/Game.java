package Game;

import Fighter.Fighter;
import Fighter.impl.Archer;
import Fighter.impl.Knight;
import Fighter.impl.Mage;
import Stage.Stage;

import java.util.Map;
import java.util.Set;

import java.util.*;



public class Game implements GameInter {
    private Fighter player;
    private Stage stage;
    private int score;
    private int round; // 현재 라운드를 추적하는 변수
    private String difficulty;

    public Game(String difficulty) {
        this.score = 0; // 초기 점수 설정
        this.round = 1; // 초기 라운드 설정
        this.difficulty = difficulty;
    }

    @Override
    public void introduceFighter() {
        // 사용할 수 있는 모든 파이터의 정보를 출력
        Fighter[] fighters = {new Knight("중", 0), new Mage("중", 0), new Archer("중", 0)};
        System.out.println("사용할 수 있는 파이터:");
        for (Fighter fighter : fighters) {
            fighter.showDescript();
        }
    }

    @Override
    public void chooseFighter(String fighterName) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        do {
            switch (fighterName.toLowerCase()) {
                case "knight":
                    player = new Knight("중",0);
                    validInput = true;
                    break;
                case "mage":
                    player = new Mage("중", 0);
                    validInput = true;
                    break;
                case "archer":
                    player = new Archer("중", 0);
                    validInput = true;
                    break;
                default:
                    System.out.println("다시 캐릭터를 입력해주세요.");
                    fighterName = scanner.next();
            }
        } while (!validInput);
    }

    @Override
    public void makeStage() {
        stage = new Stage(difficulty,round);
        stage.setEnemyAndReward(player);
        System.out.println("라운드 " + round + "이 시작되었습니다.\n");
    }

    @Override
    public String inCombat() {
        Scanner scanner = new Scanner(System.in);

        boolean result = stage.battleResult(player); //라운드 진행

        if (!result) {
            System.out.println("플레이어가 패배했습니다.\n");
            return "그만";
        } else {
            System.out.println("플레이어가 승리했습니다.\n");
            endStage();
            return "계속";
        }
    }

    @Override
    public void endStage() {
        stage.endStage(player);
        round++; // 라운드 증가

        // 난이도에 따른 기본 점수 설정
        int baseScore;
        switch (difficulty) {
            case "하":
                baseScore = 10;
                break;
            case "중":
                baseScore = 20;
                break;
            case "상":
                baseScore = 30;
                break;
            default:
                baseScore = 0;
        }

        // 라운드 수에 따른 점수 계산
        int roundScore = baseScore * round;

        // 최종 점수에 더하기
        score += roundScore;
    }

    @Override
    public void endGame() {
        System.out.println("게임이 종료되었습니다.\n최종 점수: " + score);
    }
}