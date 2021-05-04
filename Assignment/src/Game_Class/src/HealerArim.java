
public class HealerArim extends Player1 {

	public HealerArim(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	
		this.mp = 100;
	}

	@Override  
	// 우리조는 아얘 힐러는 attack이 없었는데 일단 추가함~! 
	public void attackP2(Base Player2) {
		int damage = this.power - Player2.defense;
		Player2.hp = Player2.hp - damage;
		System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");
	}

	@Override
	public void attackP3(Base Player3) {
		int damage = this.power - Player3.defense;
		Player3.hp = Player3.hp - damage;
		System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");
	}

	@Override
	public void healing(Base Player1) {
		if (this.mp >= 20) {
			this.mp = this.mp - 20;
			Player1.hp = Player1.hp + 20;
			System.out.println(this.name + "은(는) " + Player1.name + "에게 " + "20만큼 치유시켰습니다.");
		} else {
			System.out.println(this.name + "은(는) mp가 부족하여 치유할 수 없습니다.");
		}

	}

	
}
