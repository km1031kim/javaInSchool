import java.util.Random;

public class Tankerjunhyeong extends Player1 {

	public Tankerjunhyeong(String name) {

		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	public void attackP2(Base Player2) {
		Random r = new Random();
		int damage = this.power - Player2.defense;
		if (this.hp <= 80 && r.nextInt(3) + 1 == 1) {

			System.out.println("돌진 스킬 발동 " + this.name + "은(는) " + Player2.name + "에게" + damage * 2 + "의 피해를 입혔다.");
			Player2.hp = Player2.hp - damage * 2;
		} else
			Player2.hp = Player2.hp - damage;
		System.out.println(this.name + "의 공격! " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");

		if (!Player2.isLive()) {
			System.out.println(this.name + "은(는) " + Player2.name + "을(를) 파괴했다");
		}

	}

	public void attackP3(Base Player3) {
		Random r = new Random();
		int damage = this.power - Player3.defense;
		if (this.hp <= 80 && r.nextInt(3) + 1 == 1) {

			System.out.println("돌진 스킬 발동 " + this.name + "은(는) " + Player3.name + "에게 " + damage * 2 + "의 피해를 입혔다.");
			Player3.hp = Player3.hp - damage * 2;
		} else
			Player3.hp = Player3.hp - damage;
		System.out.println(this.name + "의 공격! " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");

		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는) " + Player3.name + "을(를) 파괴했다");
		}

	}

	public void healing(Base Player1) {

	}

}
