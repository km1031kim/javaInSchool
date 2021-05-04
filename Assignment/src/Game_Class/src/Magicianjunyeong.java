import java.util.Random;

public class Magicianjunyeong extends Player1 {
	Magicianjunyeong(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	public void attackP2(Base Player2) {
		Random r = new Random();
		int damage;
		if (this.hp <= 50 && r.nextInt(3) + 1 == 1) {
			damage = 2 * (this.power - Player2.defense);
			Player2.hp = Player2.hp - damage;

			System.out.println("크리티컬 스킬 발동 " + this.name + "은(는)" + Player2.name + " 에게 " + (this.power - Player2.defense)
					+ "X2 의 피해를 입혔다.");
		} else {
			damage = this.power - Player2.defense;
			System.out.println(this.name + "은(는) " + Player2.name + " 에게 " + damage + "의 피해를 입혔다.");
		}
		if (!Player2.isLive()) {
			System.out.println(this.name + "은(는) " + Player2.name + "을(를) 파괴했다");
		}

	}
	
	public void attackP3(Base Player3) {
		Random r = new Random();
		int damage;
		if (this.hp <= 50 && r.nextInt(3) + 1 == 1) {
			damage = 2 * (this.power - Player3.defense);
			Player3.hp = Player3.hp - damage;

			System.out.println("크리티컬 스킬 발동 " + this.name + "은(는)" + Player3.name + " 에게 " + (this.power - Player3.defense)
					+ "X2 의 피해를 입혔다.");
		} else {
			damage = this.power - Player3.defense;
			System.out.println(this.name + "은(는) " + Player3.name + " 에게 " + +damage + "의 피해를 입혔다.");
		}
		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는) " + Player3.name + "을(를) 파괴했다");
		}

	}
	public void healing(Base Player1) {

	}

	
	
}

//	@Override
//	public void attackP2(Base player3) {
//		Random r = new Random();
//		int damage;
//		if(this.hp<=50&&r.nextInt(3)+1==1) {
//			damage = 2*(this.power - player3.defense);
//			player2.hp = player2.hp -damage;
//			
//			System.out.println("크리티컬 스킬 발동 "+this.name+"은(는)"+ player3.name + "에게"+(this.power-player3.defense)+"X 2 의 피해를 입혔다.");
//		}else {
//			damage = this.power - player3.defense;
//			System.out.println(this.name+"은(는)"+ player3.name+"에게"+ + damage +"의 피해를 입혔다.");
//		}
//		if (!player2.isLive()) {
//			System.out.println(this.name+"은(는)"+ player3.name+"을(를) 파괴했다");
//		
//	}
//	
//}
