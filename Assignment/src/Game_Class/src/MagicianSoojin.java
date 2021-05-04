

public class MagicianSoojin extends Player2 {
	MagicianSoojin(String name) { // 양천구마법사
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}
	@Override
	public void attackP1(Base Player1) {
		int damage;

		if (Player1.hp > 20) {
			damage = this.power - Player1.defense;
			Player1.hp = Player1.hp - 4 * damage;
			System.out.println(this.name + "은 " + Player1.name + "에게 " + 4 * damage + "의 피해를 입혔다.");
		} else {
			damage = this.power - Player1.defense;
			Player1.hp = Player1.hp - 2*damage;
			System.out.println(this.name + "은 " + Player1.name + "에게 " + 2*damage + " 의 피해를 입혔다.");
		}
		if (!Player1.isLive()) {
			System.out.println(this.name + "은 " + Player1.name + "을(를) 파괴했다.");
		}

	}

	@Override
	public void attackP3(Base Player3) {
		int damage;

		if (Player3.hp > 20) { 
			damage = this.power - Player3.defense;
			Player3.hp = Player3.hp - 4 * damage;
			System.out.println(this.name + "은 " + Player3.name + "에게 " + 4 * damage + "의 피해를 입혔다.");
		} else {
			damage = this.power - Player3.defense;
			Player3.hp = Player3.hp - 2*damage;
			System.out.println(this.name + "은 " + Player3.name + "에게 " + 2*damage + " 의 피해를 입혔다.");
		}
		if (!Player3.isLive()) {
			System.out.println(this.name + "은 " + Player3.name + "을(를) 파괴했다.");
		}

	}

	@Override
	public void healing(Base Player2) {
		// TODO Auto-generated method stub
		
	}

}
