import java.util.Scanner;

public class jingyu5 {

	public static void main(String[] args) {
		// 25인승 버스와 45인승 버스가 있다...

		Scanner sc = new Scanner(System.in);

		int people = sc.nextInt();

		int bus25 = 25;
		int bus45 = 45;
		
		
		int buscnt25 = 0;
		int buscnt45 = 0;

		// 25인승 버스로 커버가 쌉가능일때.
		if (people % bus25 == 0) {
			System.out.println("" + buscnt45 + " " + (people / bus25));
			return; // IF는 RETURN으로 멈춘다. 굿!
		}else if(people % bus45 == 0) {
			System.out.println("" + (people / bus45) + " " + buscnt25 );
			return; // IF는 RETURN으로 멈춘다. 굿!
		}
		while (true) {
			// 먼저 45인승으로 태워야 할 때.
			if (people >= bus45) {
				// 45와 같거나 크고 50보다 작으면 25인승 버스 하나 추가로 커버 쌉가능.
				if (people < 50) {
					people -= 25;
					buscnt25++;

				} else { // 50명 보다 많을 때
					people -= 45;
					buscnt45++;
					if (people % bus25 == 0) {
						System.out.println("" + buscnt45 + " " + (people / bus25));
						break;
					}

				}
			} else {
				int temp = (people <= 25) ? buscnt25++ : buscnt45++;
				System.out.println("" + buscnt45 + " " + buscnt25++);
				break;

			}
		}

	}
}