import java.util.Random;

public class MagicianSungchul extends Player3 {
	public MagicianSungchul(String name) {
		// Player3[] player = { new MagicianSungchul("박성철")
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {
		Random r = new Random();
		int choice = r.nextInt(3) + 1;
		int damage = this.power - Player1.defense;
		if (choice == 2) {
			damage = 2 * damage;
			Player1.hp = Player1.hp - damage;
			System.out
					.println("글라이딩 샤이닝 버스터! " + this.name + "은(는) " + Player1.name + "에게 " + damage + "X2 의 피해를 입혔다.");
		} else if (choice == 3) {
			damage = 3 * damage;
			System.out
					.println("글라이딩 샤이닝 버스터! " + this.name + "은(는) " + Player1.name + "에게 " + damage + "X3 의 피해를 입혔다.");
		} else {
			System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + " 의 피해를 입혔다.");
		}
		if (!Player1.isLive()) {
			System.out.println(this.name + "은(는) " + Player1.name + "을(를) 파괴했다.");
		}
	}

	@Override
	public void attackP2(Base Player2) {
		Random r = new Random();
		int choice = r.nextInt(3) + 1;
		int damage = this.power - Player2.defense;
		if (choice == 2) {
			damage = 2 * damage;
			Player2.hp = Player2.hp - damage;
			System.out.println("글라이딩 샤이닝 버스터! " + this.name + "은(는) " + Player2.name + "에게 " + damage + "X2 의 피해를 입혔다.");
		} else if (choice == 3) {
			damage = 3 * damage;
			System.out.println("글라이딩 샤이닝 버스터! " + this.name + "은(는) " + Player2.name + "에게 " + damage + "X3 의 피해를 입혔다.");
		} else {
			System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + " 의 피해를 입혔다.");
		}
		if (!Player2.isLive()) {
			System.out.println(this.name + "은(는) " + Player2.name + "을(를) 파괴했다.");
		}
	}

	public void healing(Base Player3) {
	}
}
