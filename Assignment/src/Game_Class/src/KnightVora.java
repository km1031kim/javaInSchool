
public class KnightVora extends Player2{
	 KnightVora(String name) { // 우장산돌주먹
			this.hp = 100;
			this.power = 5;
			this.name = name;
			this.defense = 1;
		}
      
      @Override
      public void attackP1(Base Player1) {
         
        int damage = this.power - Player1.defense;
        Player1.hp = Player1.hp - damage;
         if (this.hp > 50) {
            System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage + "의 피해를 입혔다.");
            }
         
            else {
               int damage2 = this.power*3 - Player1.defense;
               Player1.hp = Player1.hp - damage2;
               System.out.println(this.name + "은(는) " + Player1.name + "에게 " + damage2 + "의 엄청난 피해를 입혔다.");
         
               if (!Player1.isLive()) {
                  System.out.println(this.name + "은(는) " + Player1.name + "에게 승리했다.");
               }
            }
      }
      
      @Override
      public void attackP3(Base Player3) {
         
        int damage = this.power - Player3.defense;
        Player3.hp = Player3.hp - damage;
         if (this.hp > 50) {
            System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage + "의 피해를 입혔다.");
            }
         
            else {
               int damage2 = this.power*3 - Player3.defense;
               Player3.hp = Player3.hp - damage2;
               System.out.println(this.name + "은(는) " + Player3.name + "에게 " + damage2 + "의 엄청난 피해를 입혔다.");
         
               if (!Player3.isLive()) {
                  System.out.println(this.name + "은(는) " + Player3.name + "에게 승리했다.");
               }
            }
      }

	@Override
	public void healing(Base Player2) {
		// TODO Auto-generated method stub
		
	}
 }
