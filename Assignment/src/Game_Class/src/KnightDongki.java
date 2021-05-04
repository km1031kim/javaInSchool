import java.util.Random;

public class KnightDongki extends Player3 {
	public KnightDongki(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	public void attackP1(Base Player1) {
		Random rd = new Random();
		int dice = rd.nextInt(6);
		if(dice >= 4) {
			System.out.println("숫자는 " + dice);
			int damage = this.power * 2;
			System.out.println(this.name + "은(는) " + Player1.name + "에게" + damage + " 의 피해를 입혔다.");
		}
		
		else {int damage = this.power - Player1.defense;
		Player1.hp = Player1.hp - damage;
		System.out.println(this.name + "은(는) " + Player1.name + "에게" + damage + " 의 피해를 입혔다.");
		}
		
		if (!Player1.isLive()) {
			System.out.println(this.name + "은(는) " + Player1.name + "을(를) 파괴했다.");
		}
		}

	public void attackP2(Base Player2) {
		Random rd = new Random();
		int dice = rd.nextInt(6);
		if (dice >= 4) {
			System.out.println("숫자는 " + dice);
			int damage = this.power * 2;
			System.out.println(this.name + "은(는) " + Player2.name + "에게" + damage + " 의 피해를 입혔다.");
		}

		else {
			int damage = this.power - Player2.defense;
			Player2.hp = Player2.hp - damage;
			System.out.println(this.name + "은(는) " + Player2.name + "에게" + damage + " 의 피해를 입혔다.");
		}

		if (!Player2.isLive()) {
			System.out.println(this.name + "은(는) " + Player2.name + "을(를) 파괴했다.");
		}
		}

	@Override
	public void healing(Base Player3) {
		// TODO Auto-generated method stub
		
	}
		}
