

import java.util.Random;

// 송혁중
public class ArcherHyukjung extends Player1 {
	
	public ArcherHyukjung(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}
	
	@Override
	public void attackP2(Base Player2) {
		int damage;
		if (bonus()) {
			damage = this.power*2 - Player2.defense;
			Player2.hp = Player2.hp - damage;
			System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + "의 치명상을 입혔다. (>>> 불화살 공격!!)");
		} else {
			damage = this.power - Player2.defense;
			Player2.hp = Player2.hp - damage;
			System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");
		}
//		DeadOrLive(Player2);
	}

	@Override
	public void attackP3(Base Player3) {
		int damage;
		if (bonus()) {
			damage = this.power*2 - Player3.defense;
			Player3.hp = Player3.hp - damage;
			System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 치명상을 입혔다. (>>> 불화살 공격!!)");
		} else {
			damage = this.power - Player3.defense;
			Player3.hp = Player3.hp - damage;
			System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");
		}
//		DeadOrLive(Player3);
	}

	@Override
	public void healing(Base Player1) {		
	}
	
	
	// 궁수는 이렇게 랜덤방식 넣음.
	public boolean bonus() {
		Random r = new Random();
		if (r.nextInt() >= 0.8) {
			return true;
		}
		return false;
	}

	


}
