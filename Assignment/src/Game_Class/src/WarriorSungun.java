import java.util.Random;

public class WarriorSungun extends Player2 {

	public WarriorSungun(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {

		Random r = new Random();
		int damage;

		if (this.hp <= 50 && r.nextInt(5) + 1 == 2) {
			this.defense = this.defense + 2;
			System.out.println("방어 스킬 발동 " + this.name + "의 방어력이 2만큼 영구적으로 증가했다.");

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

		if (this.hp <= 50 && r.nextInt(5) + 1 == 2) {
			this.defense = this.defense + 2;
			System.out.println("방어 스킬 발동 " + this.name + "의 방어력이 2만큼 영구적으로 증가했다.");

		} else {
			damage = this.power - Player3.defense;
			System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다. ");
		}
		if (!Player3.isLive()) {
			System.out.println(this.name + "은(는)" + Player3.name + "을(를) 파괴했다. ");
		}
		
	}
	
	@Override
	public void healing(Base player) {
		// TODO Auto-generated method stub

	}



}
