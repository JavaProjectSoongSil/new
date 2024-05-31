package Fighter;

import java.util.*;

import Card.Card;
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
            for (int i = 0; i < handLimit && i < cardList.size(); i++) {
                chosenCards.add(cardList.get(i));
            }
        } else {
            Scanner scanner = new Scanner(System.in);
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
            System.out.print("카드를 선택하세요 (1-" + cardList.size() + "): ");
            int choice = scanner.nextInt();
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
        for (Map.Entry<String, Integer> entry : change.entrySet()) {
            resource.put(entry.getKey(), resource.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
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
        cardSet.add(reward);
        System.out.println("보상으로 받은 카드: " + reward.getCardInform());
    }
}