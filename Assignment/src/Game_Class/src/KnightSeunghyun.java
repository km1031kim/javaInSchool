import java.util.Random;

public class KnightSeunghyun extends Player2 {
	public KnightSeunghyun(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {

		Random r = new Random();
		int damage;
		int notDamage;
		if (this.hp <= 50 && r.nextInt(3) + 1 == 1) {
			damage = 2 * (this.power - Player1.defense);
			Player1.hp = Player1.hp - damage;

			System.out.println("크리티컬 스킬 발동 " + this.name + "은(는) " + Player1.name + "에게 " + (this.power - Player1.defense)
					+ " x 2의 피해를 입혔다.");
		} else if (this.hp > 1 && r.nextInt(5) + 1 == 2) {
			notDamage = Player1.power;
			this.hp = this.hp + notDamage;

			System.out.println(
					"방어 스킬 발동 " + this.name + "은(는) " + Player1.name + "에게 " + Player1.power + " 만큼 일회성으로 방어력이 상승했다.");
		} else {
			damage = this.power - Player1.defense;
			System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + "의 피해를 입혔다. ");
		}
		if (!Player1.isLive()) {
			System.out.println(this.name + "은(는)" + Player1.name + "을(를) 파괴했다. ");
		}

	}



	@Override
	public void attackP3(Base Player3) {
		Random r = new Random();
		int damage;
		int notDamage;
		if (this.hp <= 50 && r.nextInt(3) + 1 == 1) {
			damage = 2 * (this.power - Player3.defense);
			Player3.hp = Player3.hp - damage;

			System.out.println("크리티컬 스킬 발동 " + this.name + "은(는) " + Player3.name + "에게 " + (this.power - Player3.defense)
					+ " x 2의 피해를 입혔다.");
		} else if (this.hp > 1 && r.nextInt(5) + 1 == 2) {
			notDamage = Player3.power;
			this.hp = this.hp + notDamage;

			System.out.println(
					"방어 스킬 발동 " + this.name + "은(는) " + Player3.name + "에게 " + Player3.power + " 만큼 일회성으로 방어력이 상승했다.");
		} else {
			damage = this.power - Player3.defense;
			System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다. ");
		}
		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는)" + Player3.name + "을(를) 파괴했다. ");
		}
		
	}

	@Override
	public void healing(Base player) {
		// TODO Auto-generated method stub
		
	}
}
