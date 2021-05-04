public class KnightJaeHyun extends Player3 {
	public KnightJaeHyun(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}
	
	@Override
	public void attackP1(Base Player1) {
		int damage = this.power - Player1.defense;
		Player1.hp = Player1.hp - damage;
		this.hp = hp + damage;
		// enemy의 hp에 damage를 가산하여 흡혈 메커니즘 구현
		System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + "의 피해를 입혔다.");
		System.out.println(this.name + "은(는) " + Player1.name + "을(를) 흡혈하여 " + this.hp + "로 회복하였다.");


		if (!Player1.isLive()) {
			System.out.println(this.name + "은(는) " + Player1.name + "을(를) 파괴했다.");
		}
	}
	
	public void attackP2(Base Player2) {
		int damage = this.power - Player2.defense;
		Player2.hp = Player2.hp - damage;
		this.hp = hp + damage;
		// enemy의 hp에 damage를 가산하여 흡혈 메커니즘 구현
		System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");
		System.out.println(this.name + "은(는) " + Player2.name + "을(를) 흡혈하여 " + this.hp + "로 회복하였다.");


		if (!Player2.isLive()) {
			System.out.println(this.name + "은(는) " + Player2.name + "을(를) 파괴했다.");
		}
	}

	@Override
	public void healing(Base Player3) {
		// TODO Auto-generated method stub
		
	}

}
