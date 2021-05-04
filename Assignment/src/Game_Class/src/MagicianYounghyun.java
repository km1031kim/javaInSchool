
import java.util.Random;

// 배영현
public class MagicianYounghyun extends Player1 {

	public MagicianYounghyun(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	
		this.mp = 150;
		 
	}

	@Override
	public void attackP2(Base Player2) {
		Random r1 = new Random();
		int spellNumber = r1.nextInt(2);

		int damage = this.power - this.defense;
		Player2.hp = Player2.hp - damage;

		int intel = 2; // 지능 추가
		if (this.mp > 30 && spellNumber == 0) {
			this.mp = this.mp - 30;
			Player2.hp = Player2.hp - intel * 5;
			System.out.println((this.name + "은(는) " + Player2.name + "에게 메테오를 시전하여 " + (intel * 5) + "의 피해를 주고 구워버렸다!"));
		} else if ((this.mp > 15 && spellNumber == 1) || mp == 15) {
			this.mp = this.mp - 15;
			Player2.hp = Player2.hp - intel * 3;
			System.out.println(
					(this.name + "은(는) " + Player2.name + "에게 고드름 떨구기를 시전하여 " + (intel * 3) + "의 피해를 주고 얼려버렸다!"));
		}

		if (this.mp < 15) {
			System.out.println(
					("아... 마나가 없다. " + this.name + "은(는) " + Player2.name + "를 지팡이로 때려 " + damage + " 의 피해를 주었다!"));
		}
	}

	@Override
	public void attackP3(Base Player3) {
		Random r1 = new Random();
		int spellNumber = r1.nextInt(2);

		int damage = this.power - this.defense;
		Player3.hp = Player3.hp - damage;
		
		int intel = 2; // 지능 추가
		if (this.mp > 30 && spellNumber == 0) {
			this.mp = this.mp - 30;
			Player3.hp = Player3.hp - intel * 5;
			System.out.println((this.name + "은(는) " + Player3.name + "에게 메테오를 시전하여 " + (intel * 5) + "의 피해를 주고 구워버렸다!"));
		} else if ((this.mp > 15 && spellNumber == 1) || mp == 15) {
			this.mp = this.mp - 15;
			Player3.hp = Player3.hp - intel * 3;
			System.out.println(
					(this.name + "은(는) " + Player3.name + "에게 고드름 떨구기를 시전하여 " + (intel * 3) + "의 피해를 주고 얼려버렸다!"));
		}

		if (this.mp < 15) {
			System.out.println(
					("아... 마나가 없다. " + this.name + "은(는) " + Player3.name + "를 지팡이로 때려 " + damage + " 의 피해를 주었다!"));
		}

	}

	@Override
	public void healing(Base Player1) {
	}

	
}
