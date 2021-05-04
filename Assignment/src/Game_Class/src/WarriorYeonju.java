
public class WarriorYeonju extends Player3{
	
	WarriorYeonju(String name){
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {
		int damage = this.power * 2 - Player1.defense;
		Player1.hp = Player1.hp - damage;		
		System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + "의 피해를 입혔다.");

	}

	@Override
	public void attackP2(Base Player2) {
		int damage = this.power * 2 - Player2.defense;
		Player2.hp = Player2.hp - damage;
		System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");

		
	}

	@Override
	public void healing(Base Player3) {
		// TODO Auto-generated method stub
		
	}
}
