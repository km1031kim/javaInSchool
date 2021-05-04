import java.util.Random;

public class WarriorJingyu extends Player2 {
	public WarriorJingyu(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {

		Random r = new Random();

		int damage;

		// 체력이 50 이하일 때 1/3 확률로 두배 공격력을 입힐 수 있다.

		if (this.hp <= 50 && r.nextInt(3) + 1 == 1) {

			damage = 2 * (this.power - Player1.defense);
			Player1.hp = Player1.hp - damage;

			System.out.println("김효관교수님의 구글 설문지 작성 공격! " + this.name + "은(는) " + Player1.name + "에게 "
					+ (this.power - Player1.defense) + " X 2의 정신적 피해를 입혔다.");
		} else
			damage = this.power - Player1.defense;
		System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + "의 피해를 입혔다.");

	}

	@Override
	public void attackP3(Base Player3) {
		// TODO Auto-generated method stub
		Random r = new Random();

		int damage;

		// 체력이 50 이하일 때 1/3 확률로 두배 공격력을 입힐 수 있다.

		if (this.hp <= 50 && r.nextInt(3) + 1 == 1) {

			damage = 2 * (this.power - Player3.defense);
			Player3.hp = Player3.hp - damage;

			System.out.println("황원용교수님의 해쉬 공격! " + this.name + "은(는) " + Player3.name + "에게 "
					+ (this.power - Player3.defense) + " X 2 정신적 피해를 입혔다.");
		} else
			damage = this.power - Player3.defense;
		System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");

	}

	@Override
	public void healing(Base Player2) {
		// TODO Auto-generated method stub

	}
}
