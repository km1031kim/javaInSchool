
public class HealerSungun extends Player2 {
	public HealerSungun(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {

		int damage = this.power - Player1.defense;
		System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + "의 피해를 입혔다. ");

		if (!Player1.isLive()) {
			System.out.println(this.name + "은(는)" + Player1.name + "을(를) 파괴했다. ");
		}

	}

	@Override
	public void attackP3(Base Player3) {
		int damage = this.power - Player3.defense;
		System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다. ");

		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는) " + Player3.name + "을(를) 파괴했다. ");
		}

	}

	@Override
	public void healing(Base Player2) {

		if (this.hp >= 20) {
			int heal = 5;
			Player2.hp = Player2.hp + heal;
			this.hp = this.hp - heal;
		}
	}
}
