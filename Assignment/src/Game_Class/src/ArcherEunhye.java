
public class ArcherEunhye extends Player3 {
	public ArcherEunhye (String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}
	
	@Override
	public void attackP1(Base Player1) {

		int damage = this.power - Player1.defense;
		Player1.hp = Player1.hp - damage;
		System.out.println(this.name + "은(는) " + Player1.name + "에게 "+ damage + "의 피해를 입혔다.");
		
		if(this.hp < 30) {
		System.out.println(this.name + "은 위기에 처해, ▶궁◀을 사용했다!" );
		System.out.println("▶▶▶▶▶궁 : 상대에게 공격을 2번한다◀◀◀◀◀");
		int damageDamage = this.power - Player1.defense;
		int damageDamage2 = this.power - Player1.defense;
		Player1.hp = Player1.hp - damageDamage;
		Player1.hp = Player1.hp - damageDamage2;
		System.out.println(this.name + "은(는) " + Player1.name + "에게 "+ damageDamage + "의 피해를 입혔다.");
		System.out.println(this.name + "은(는) " + Player1.name + "에게 "+ damageDamage2 + "의 피해를 입혔다.");
		}
	
		if(!Player1.isLive()) {
			System.out.println(this.name + "은(는) " + Player1.name + "을 파괴했다");
		}
	}
	@Override
	public void attackP2(Base Player2) {
		int damage = this.power - Player2.defense;
		Player2.hp = Player2.hp - damage;
		System.out.println(this.name + "은(는) " + Player2.name + "에게 "+ damage + "의 피해를 입혔다.");
		
		if(this.hp < 30) {
		System.out.println(this.name + "은 위기에 처해, ▶궁◀을 사용했다!" );
		System.out.println("▶▶▶▶▶궁 : 상대에게 공격을 2번한다◀◀◀◀◀");
		int damageDamage = this.power - Player2.defense;
		int damageDamage2 = this.power - Player2.defense;
		Player2.hp = Player2.hp - damageDamage;
		Player2.hp = Player2.hp - damageDamage2;
		System.out.println(this.name + "은(는) " + Player2.name + "에게 "+ damageDamage + "의 피해를 입혔다.");
		System.out.println(this.name + "은(는) " + Player2.name + "에게 "+ damageDamage2 + "의 피해를 입혔다.");
		}
		
		if(!Player2.isLive()) {
			System.out.println(this.name + "은(는) " + Player2.name + "을 파괴했다");
		}
	}

	@Override
	public void healing(Base Player3) {
		// TODO Auto-generated method stub
		
	}
	}
