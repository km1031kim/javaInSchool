
public class MagicianChaiWeon extends Player2 {

	public MagicianChaiWeon(String name) {
		this.hp = 100;
		this.power = 5;
		this.name = name;
		this.defense = 1;
	}

	@Override
	public void attackP1(Base Player1) {
		int damage = this.power - Player1.defense;
		Player1.hp = Player1.hp - damage;

		if (this.hp < 50) { // player, 즉 나의 hp가 50밑으로 떨어지면 상대방은 0으로
			Player1.hp = 0; // 자폭
			System.out.println(this.name + " 자폭 " + Player1.name + " 공중분해 ");
			System.out.println(this.name + "은 자폭했다");
			this.hp = 0;
		}
	}

	@Override
	public void attackP3(Base Player3) {
		int damage = this.power - Player3.defense;
		Player3.hp = Player3.hp - damage;

		if (this.hp < 50) { // player, 즉 나의 hp가 50밑으로 떨어지면 상대방은 0으로
			Player3.hp = 0; // 자폭

			System.out.println(this.name + " 자폭 " + Player3.name + " 공중분해 ");
			System.out.println(this.name + "은 자폭했다");
			this.hp = 0;

		}

	}

	@Override
	public void healing(Base Player2) {
		// TODO Auto-generated method stub

	}
}
