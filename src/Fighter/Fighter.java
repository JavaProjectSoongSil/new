package Fighter;

import java.util.*;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;

public abstract class Fighter implements FighterInter {
    protected String name;
    protected Map<String, Integer> resource = new HashMap<>(); // "HP", "attackPower", "defensePower", "hand"
    protected Set<Card> cardSet = new HashSet<>();

    public Fighter(String name, int HP, int attackPower, int defensePower, int hand) {
        this.name = name;
        resource.put("HP", HP);
        resource.put("attackPower", attackPower);
        resource.put("defensePower", defensePower);
        resource.put("hand", hand);
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
                System.out.println("==================================");
                for (int i = 0; i < handLimit; i++) {
                    Card card = cardList.get(i);
                    System.out.print((i + 1) + ": ");
                    for (Map.Entry<String, List<Integer>> entry : card.getCardInform().entrySet()) {
                        System.out.println("타입: " + entry.getKey() + ", 능력치: " + entry.getValue().get(0));
                    }
                    System.out.println("설명: " + card.getCardDescription());
                }
                System.out.println("==================================");

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
                        "파이터 이름: %s\n" +
                        "===========================\n" +
                        "HP        : %s\n" +
                        "공격력    : %s\n" +
                        "방어력    : %s\n" +
                        "손패      : %s\n" +
                        "===========================",
                name,
                resource.get("HP"),
                resource.get("attackPower"),
                resource.get("defensePower"),
                resource.get("hand")
        );
        System.out.println(description);
    }

    @Override
    public void setFighterResource(Map<String, Integer> change) {
        this.resource = change;
    }

    @Override
    public void showInventory() {
        System.out.println("인벤토리: ");
        for (Card card : cardSet) {
            System.out.println(card.getCardInform());
        }
    }

    @Override
    public void getreward(Card reward) {
        // 카드를 추가합니다.
        cardSet.add(reward);

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
}