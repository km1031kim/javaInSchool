import java.util.Random;

public class Archerjeongyeon extends Player1 {

	public Archerjeongyeon(String name) {

		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
		this.mp = 100;

	}

	public void attackP2(Base Player2) {
		Random r = new Random();
		int damage = 0;
		if (r.nextInt(3) + 1 == 1) {
			if (this.mp > 0) {
				damage = 2 * this.power;
				Player2.hp = Player2.hp - damage;
				this.mp = this.mp - 20;
			} else {
				this.mp = this.mp + 5;
				System.out.println("mp 가 부족합니다.");
			}
			System.out.println("더블샷 스킬 발동 " + this.name + "은(는) " + Player2.name + "에게 " + damage + " 의 피해를 입혔다.");
		}

		if (!Player2.isLive()) {
			System.out.println(this.name + "은(는) " + Player2.name + "을(를) 파괴했다");
		}

	}

	public void attackP3(Base Player3) {
		Random r = new Random();
		int damage;
		if (r.nextInt(3) + 1 == 1) {
			if (this.mp > 0) {
				damage = 2 * this.power;
				Player3.hp = Player3.hp - damage;
				this.mp = this.mp - 20;
			} else {
				this.mp = this.mp + 5;
				System.out.println("mp 가 부족합니다.");
			}
			System.out.println("더블샷 스킬 발동 " + this.name + "은(는) " + Player3.name + "에게 " + this.power * 2 + " 의 피해를 입혔다.");
		}

		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는) " + Player3.name + "을(를) 파괴했다");
		}

	}

	public void healing(Base Player1) {

	}

	

}
