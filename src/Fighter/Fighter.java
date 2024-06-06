package Fighter;

import java.util.*;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;

public abstract class Fighter implements FighterInter {
    protected String name;
    protected String job;
    protected Map<String, Integer> resource = new HashMap<>(); // "HP", "attackPower", "defensePower", "hand"
    protected Set<Card> cardSet = new HashSet<>();

    public Fighter(String name, String job, int HP, int attackPower, int defensePower, int hand) {
        this.name = name;
        this.job = job;
        resource.put("HP", HP);
        resource.put("attackPower", attackPower);
        resource.put("defensePower", defensePower);
        resource.put("hand", hand);
        resource.put("XP", 0);  // 경험치 초기화
        resource.put("level", 1);  // 레벨 1에서 시작
    }

    @Override
    public Card[] chooseCards(Boolean isEnemy) {
        List<Card> chosenCards = new ArrayList<>();
        List<Card> cardList = new ArrayList<>(cardSet);
        Collections.shuffle(cardList);
        int handLimit = resource.get("hand");
        if (isEnemy) {
            Random random = new Random();
            int randomIndex = random.nextInt(cardList.size());
            chosenCards.add(cardList.get(randomIndex));
        } else {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            boolean validInput = false;
            do {
                showInventory();

                System.out.print("카드를 선택하세요 (1-" + handLimit + "): ");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= handLimit) {
                    validInput = true;
                } else {
                    System.out.println("잘못된 입력입니다. 1-" + handLimit + " 사이의 숫자를 입력해주세요.\n");
                }
            } while (!validInput);
            chosenCards.add(cardList.get(choice - 1));
            cardList.remove(choice - 1); // 선택한 카드를 목록에서 제거
        }
        return chosenCards.toArray(new Card[0]);
    }

    @Override
    public Set<Card> getDeckSet() {
        return cardSet;
    }

    @Override
    public Map<String, Integer> getResource() {
        return resource;
    }

    @Override
    public void showDescript() {
        String description = String.format(
                "===========================\n" +
                        "파이터 직업 : %-10s\n" +
                        "===========================\n" +
                        "%-10s : %-5s\n" +
                        "%-10s : %-5s\n" +
                        "%-10s : %-5s\n" +
                        "%-10s : %-5s\n" +
                        "===========================",
                job,
                "HP", resource.get("HP"),
                "공격력", resource.get("attackPower"),
                "방어력", resource.get("defensePower"),
                "카드 덱 수", resource.get("hand")
        );
        System.out.println(description);
    }

    @Override
    public void setFighterResource(Map<String, Integer> change) {
        this.resource = change;
    }

    @Override
    public void showInventory() {
        List<Card> cardList = new ArrayList<>(cardSet);
        int handLimit = resource.get("hand");

        System.out.println("==================================");
        int limit = Math.min(handLimit, cardList.size());
        for (int i = 0; i < limit; i++) {
            Card card = cardList.get(i);
            System.out.print((i + 1) + ": ");
            for (Map.Entry<String, List<Integer>> entry : card.getCardInform().entrySet()) {
                System.out.println("타입: " + entry.getKey() + ", 능력치: " + entry.getValue().get(0));
            }
            System.out.println("설명: " + card.getCardDescription());
        }
        System.out.println("==================================");
    }

    @Override
    public void getreward(Card reward) {
        // 카드를 추가합니다.
        cardSet.add(reward);

        // 보상으로 받은 경험치 추가
        int xpReward = 100; // 경험치 보상
        int currentXP = resource.get("XP");
        int currentLevel = resource.get("level");
        resource.put("XP", currentXP + xpReward);

        // 레벨업 체크
        int xpThreshold = currentLevel * 150;  // 레벨업에 필요한 경험치
        if (resource.get("XP") >= xpThreshold) {
            resource.put("level", currentLevel + 1);
            resource.put("XP", resource.get("XP") - xpThreshold);  // 경험치 리셋 또는 초과분 이월

            // 선택적으로 스탯 증가
            resource.put("HP", resource.get("HP") + 100);  // 레벨업 시 HP 증가
            resource.put("attackPower", resource.get("attackPower") + 10);  // 공격력 증가
            resource.put("defensePower", resource.get("defensePower") + 3);  // 방어력 증가

            System.out.println("=================================");
            System.out.println("레벨 업! 지금 현재 레벨 : " + resource.get("level"));
            System.out.println("=================================");
        }

        // 카드 정보를 출력합니다.
        Map<String, List<Integer>> cardInfo = reward.getCardInform();
        for (Map.Entry<String, List<Integer>> entry : cardInfo.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue().get(0);
            System.out.println("=================================");
            System.out.println("보상으로 받은 카드 타입: " + key);
            System.out.println("능력치: " + value);
            System.out.println("=================================");
        }
    }

    // 캐릭터 특수능력 (현재 Mage만 존재함)
    public abstract void gainSpecialPower();
}