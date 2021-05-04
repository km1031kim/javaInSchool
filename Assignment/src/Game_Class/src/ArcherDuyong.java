import java.util.Random;

public class ArcherDuyong extends Player2 {
	public ArcherDuyong(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {

		Random r = new Random();
		int damage;
		if (this.hp <= 50 && r.nextInt(1) + 1 == 1) {
			damage = 3 * (this.power - Player1.defense);
			Player1.hp = Player1.hp - damage;

			System.out.println("크리티컬 스킬 발동 " + this.name + "은(는) " + Player1.name + "에게 " + (this.power - Player1.defense)
					+ " x 2의 피해를 입혔다.");
		} else {
			damage = this.power - Player1.defense;
			System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + "의 피해를 입혔다. ");
		}
		if (!Player1.isLive()) {
			System.out.println(this.name + "은(는)" + Player1.name + "을(를) 파괴했다. ");
		}

	}

	
	@Override
	public void attackP3(Base Player3) {
		Random r = new Random();
		int damage;
		if (this.hp <= 50 && r.nextInt(1) + 1 == 1) {
			damage = 3 * (this.power - Player3.defense);
			Player3.hp = Player3.hp - damage;

			System.out.println("크리티컬 스킬 발동 " + this.name + "은(는) " + Player3.name + "에게 " + (this.power - Player3.defense)
					+ " x 2의 피해를 입혔다.");
		} else {
			damage = this.power - Player3.defense;
			System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다. ");
		}
		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는)" + Player3.name + "을(를) 파괴했다. ");
		}

		
	}

	@Override
	public void healing(Base Player2) {
		// TODO Auto-generated method stub
		
	} 
	
}
