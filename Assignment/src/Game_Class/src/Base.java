
public class Base {
	int hp;  //체력
	int power; //공격력
	int defense; //방어력
	String name;
	int mp;
	
	public boolean isLive() {
		if(this.hp < 1) {
			return false;
		}
		return true;
	}


}
