import java.util.Random;

public class Warriornamdeok extends Player1 {

	public Warriornamdeok(String name) {
		// "쾌걸근육맨"

		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP2(Base Player2) {
		Random r = new Random();
		int damage;
		// 10%의 확률로 공격력 2배 증가
		if (r.nextInt(10) + 1 == 1) {
			damage = (2 * this.power) - Player2.defense;
			Player2.hp = Player2.hp - damage;

			System.out.println("[근육 펌핑!] " + this.name + "은(는) " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");
		} else {
			damage = this.power - Player2.defense;
			System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");
		}

		if (!Player2.isLive()) {
			System.out.println(this.name + "은(는)" + Player2.name + "을(를) 파괴했다.");
		}
	}
	
	@Override
	public void attackP3(Base Player3) {
		Random r = new Random();
		int damage;
		// 10%의 확률로 공격력 2배 증가
		if (r.nextInt(10) + 1 == 1) {
			damage = (2 * this.power) - Player3.defense;
			Player3.hp = Player3.hp - damage;

			System.out.println("[근육 펌핑!] " + this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");
		} else {
			damage = this.power - Player3.defense;
			System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");
		}

		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는)" + Player3.name + "을(를) 파괴했다.");
		}
	}
	

	@Override
	public void healing(Base Player1) {
		
	}

	
}
