import java.util.Random;

public class Healerjaemin extends Player1 {
	public Healerjaemin(String name) {



		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	

	public void attackP2(Base Player2) {

		int damage = this.power - Player2.defense;
		Player2.hp = Player2.hp - damage;

		Random r = new Random();
		int random = r.nextInt(3);

		if (random == 0) {
			damage = damage * 2;
			System.out.println("♨타노스핑거스냅♨ " + this.name + "가 " + Player2.name + " 에게 " + damage + "의 피해를 입혔다.");

		} else {
			damage = damage * 1;
			System.out.println("♨진실의방으로♨ " + this.name + "가 " + Player2.name + " 에게 " + damage + "의 피해를 입혔다.");
		}

		if (!Player2.isLive()) {
			System.out.println(this.name + "가 " + Player2.name + " 를 부셔버렸다.");
		}
	}
	
	public void attackP3(Base Player3) {

		int damage = this.power - Player3.defense;
		Player3.hp = Player3.hp - damage;

		Random r = new Random();
		int random = r.nextInt(3);

		if (random == 0) {
			damage = damage * 2;
			System.out.println("♨타노스핑거스냅♨ " + this.name + "가 " + Player3.name + " 에게 " + damage + "의 피해를 입혔다.");

		} else {
			damage = damage * 1;
			System.out.println("♨진실의방으로♨ " + this.name + "가 " + Player3.name + " 에게 " + damage + "의 피해를 입혔다.");
		}

		if (!Player3.isLive()) {
			System.out.println(this.name + "가 " + Player3.name + " 를 부셔버렸다.");
		}
	}

	public void healing(Base Player1) {

	}

}
