import Game.Game;
import Game.GameInter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> diffset=new HashSet<>();
        diffset.add("상");
        diffset.add("중");
        diffset.add("하");
        String diff;
        String name;
        String regame="다시";

        //이름 입력받고 난이도 입력받고
        while(regame.equals("다시")) {
            while (true) {
                System.out.print("이름과 난이도(상,중,하) 입력>>");
                name = scanner.next();
                diff = scanner.next();
                if (diffset.contains(diff))
                    break;
            }
            GameInter a = new Game();
            a.introduceFighter();
            System.out.print("캐릭터를 골라주세요");
            String fighter = scanner.next();//
            a.chooseFighter(fighter);
            String stop = "";
            while (!stop.equals("그만")) {
                System.out.print("스테이지가 생성됩니다.");
                a.makeStage();
                stop = a.inCombat();
                if (stop.equals("그만"))
                    break;
                System.out.print("그만하시려면 그만을 입력해주세요");
                stop = scanner.next();

            }
            a.endGame();
            System.out.print("다시 시작하시려면 다시를 입력해주세요");
            regame = scanner.next();
        }
    }
}