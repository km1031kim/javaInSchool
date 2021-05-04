
public class WarriorReakwon extends Player2 {
	WarriorReakwon(String name) { // "가미가제영현"
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}
	@Override
	public void attackP1(Base Player1) {
		int damage = this.power - Player1.defense;
		Player1.hp = Player1.hp - damage * damage * damage * damage * damage;
		this.hp = this.hp - 1;
		System.out.println(this.name + "의 가!미!가!제!");
		if (!Player1.isLive()) {
			System.out.println(Player1.name + " D!E!A!T!H!");
			System.out.println(this.name + "은 " + Player1.name + "과 함께 자폭했다");
			this.hp = 0;
			
		}
	}

	@Override
	public void attackP3(Base Player3) {
		int damage = this.power * 2 - Player3.defense;
		Player3.hp = Player3.hp - damage * damage * damage * damage * damage;
		this.hp = this.hp - 1;
		System.out.println(this.name + "의 가!미!가!제!");
		if (!Player3.isLive()) {
			System.out.println(Player3.name + " D!E!A!T!H!");
			System.out.println(this.name + "은 " + Player3.name + "과 함께 자폭했다");
			this.hp = 0;
		}
	}

	@Override
	public void healing(Base Player2) {
		// TODO Auto-generated method stub
		
	}

}
