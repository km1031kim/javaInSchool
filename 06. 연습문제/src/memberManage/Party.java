package memberManage;
import java.util.ArrayList;

public class Party {
	String name;
	ArrayList<People> people =  new ArrayList<People>();

	Party(String name){
		this.name = name;
	}
}
