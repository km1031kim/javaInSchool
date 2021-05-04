

import java.util.Random;

// 이혜진
public class AssassinHyejin extends Player1 {
	
	//  전사에 맞게 설정(파워는 랜덤)
	public AssassinHyejin(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP2(Base Player2) {
		Random random = new Random();
		this.power = random.nextInt(6) + 20;  // 20~25 (파워에 랜덤을 줘서 최소 20 최대 25으로 설정함!)
		if (this.power == 20) {
			int damage = this.power - Player2.defense;
			Player2.hp = Player2.hp - damage;
			System.out.println(this.name + "은(는) " + Player2.name + "에게 " + damage + "의 피해를 입혔다.");
		}
		else {
			int damage = this.power;
			Player2.hp = Player2.hp - damage;
			System.out.println(this.name + "이(가) " + Player2.name + "에게 " + damage + "의 치명상을 입혔다.");
		}
//		DeadOrLive(Player2);
	}

	@Override
	public void attackP3(Base Player3) {
		Random random = new Random();
		this.power = random.nextInt(6) + 20;
		if (this.power == 20) {
			int damage = this.power - Player3.defense;
			Player3.hp = Player3.hp - damage;
			System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");
		}
		else {
			int damage = this.power;
			Player3.hp = Player3.hp - damage;
			System.out.println(this.name + "이(가) " + Player3.name + "에게 " + damage + "의 치명상을 입혔다.");
		}
//		DeadOrLive(Player3);
		
	}

	@Override
	public void healing(Base Player1) {
		
	}


}
