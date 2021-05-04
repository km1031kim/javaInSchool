package memberManage;
import java.util.Calendar;
import java.util.Scanner;

public class ExecClass {
	public static void main(String[] args) {
		// 사원 관리 프로그램을 만들어 보자!

		Scanner scanner = new Scanner(System.in);
		Party[] partyList = { new Party("영업팀"), new Party("개발팀"), new Party("인사팀") };

		for (int i = 0; i < 9999; i++) {
			System.out.println("--------KOPO 직원 데이터 조회 프로그램입니다. 메뉴를 입력해주세요--------");
			System.out.println("1. 사원 데이터 입력");
			System.out.println("2. 사원 정보 검색");
			System.out.println("3. 사원 정보 전체 출력");
			System.out.println("4. 사원 데이터 수정");
			System.out.println("quit. 종료");
			System.out.println("--------------------------------------------------------------");
			String userInput = scanner.nextLine();

			if (userInput.equals("1")) {
				System.out.println("사원 데이터를 입력합니다.");
				System.out.println("이름을 입력해주세요");
				String username = scanner.nextLine();
				System.out.println("부서를 입력해주세요(1 : 영업팀, 2 : 개발팀, 3 : 인사팀)");
				String partyNumber = scanner.nextLine();
				System.out.println("직급을 입력해주세요");
				String userRank = scanner.nextLine();
				System.out.println("업무를 입력해주세요");
				String userTask = scanner.nextLine();
				// 사번 발급
				long personalNumber = Calendar.getInstance().getTimeInMillis();

				if (partyNumber.equals("1")) {
					System.out.println("영업팀에 새 직원을 배정합니다.");
					partyList[0].people.add(new People(username, userRank, userTask, personalNumber));
					System.out.println("사원 추가 완료");
					continue;
				} else if (partyNumber.equals("2")) {
					System.out.println("개발팀에 새 직원을 배정합니다.");
					partyList[1].people.add(new People(username, userRank, userTask, personalNumber));
					System.out.println("사원 추가 완료");
					continue;
				} else if (partyNumber.equals("3")) {
					System.out.println("인사팀에 새 직원을 배정합니다.");
					partyList[2].people.add(new People(username, userRank, userTask, personalNumber));
					System.out.println("사원 추가 완료");
					continue;
				} else {
					System.out.println("잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
					continue;
				}

			} else if (userInput.equals("2")) {
				System.out.println("사원 정보를 검색합니다.");
				System.out.println("검색하실 사원의 이름을 입력해주세요");
				String searchName = scanner.nextLine();
				System.out.println("검색하실 사원의 부서를 입력해주세요(1 : 영업팀, 2 : 개발팀, 3 : 인사팀)");
				String searchPart = scanner.nextLine();

				People temp = null;
				if (searchPart.equals("1")) {
					for (int j = 0; j < partyList[0].people.size(); j++) {
						if (searchName.equals(partyList[0].people.get(j).name)) {
							temp = partyList[0].people.get(j);

						}
					}
				} else if (searchPart.equals("2")) {
					for (int j = 0; j < partyList[1].people.size(); j++) {
						if (searchName.equals(partyList[1].people.get(j).name)) {
							temp = partyList[1].people.get(j);
						}
					}
				} else if (searchPart.equals("3")) {
					for (int j = 0; j < partyList[2].people.size(); j++) {
						if (searchName.equals(partyList[2].people.get(j).name)) {
							temp = partyList[2].people.get(j);
						}
					}
				}

				if (temp != null) {
					System.out.println(temp);
					continue;
				} else
					System.out.println("등록된 사원이 아닙니다. 메인 메뉴로 돌아갑니다.");
				continue;

			} else if (userInput.equals("3")) {
				System.out.println("전체 사원 정보를 출력합니다.");
				for (int j = 0; j < partyList.length; j++) {
					System.out.println(partyList[j].name + "소속 직원 목록입니다.");
					for (int k = 0; k < partyList[j].people.size(); k++) {
						System.out.println(partyList[j].people.get(k));
					}

				}

			} else if (userInput.equals("4")) {
				System.out.println("사원 정보를 수정합니다");
				System.out.println("정보를 수정할 사원의 이름을 입력해주세요");
				String memberName = scanner.nextLine();
				System.out.println("정보를 수정할 사원의 부서를 입력해주세요. (1 : 영업팀, 2 : 개발팀, 3 : 인사팀)");
				String memberPart = scanner.nextLine();

				People temp = null;
				int partyNumber = 0;
				String partyName = null;
				// 빈 값을 만들어 놓고 전체를 훓는다. 훓은 후에 빈 값이 채워져 있으면, 존재하는 사원이기에 수정 가능.

				if (memberPart.equals("1")) {
					for (int j = 0; j < partyList[0].people.size(); j++) {
						if (memberName.equals(partyList[0].people.get(j).name)) {
							temp = partyList[0].people.get(j);
							partyNumber = 1;
							partyName = "영업팀";
						}
					}
				} else if (memberPart.equals("2")) {
					for (int j = 0; j < partyList[1].people.size(); j++) {
						if (memberName.equals(partyList[1].people.get(j).name)) {
							temp = partyList[1].people.get(j);
							partyNumber = 2;
							partyName = "개발팀";
						}
					}
				} else if (memberPart.equals("3")) {
					for (int j = 0; j < partyList[2].people.size(); j++) {
						if (memberName.equals(partyList[2].people.get(j).name)) {
							temp = partyList[2].people.get(j);
							partyNumber = 3;
							partyName = "인사팀";
						}
					}
				}
				if (temp != null) {
					System.out.println(temp.name + "님은 현재 " + partyName + "소속입니다.");
					System.out.println("이동시킬 부서를 선택해주세요. (1 : 영업팀, 2 : 개발팀, 3 : 인사팀)");
					String changePart = scanner.nextLine();
					int partNum = Integer.parseInt(changePart);
					if (partyNumber==partNum) {
						System.out.println(temp.name + "님은 이미 " + partyName + "소속입니다." + " 메인 메뉴로 돌아갑니다.");
						continue;
					} else if (changePart.equals("1")) {
						System.out.println(temp.name + "님의 부서를 영업팀으로 옮깁니다.");

						// 먼저 해당 부서에서 빼자.
						for (int j = 0; j < partyList[partyNumber - 1].people.size(); j++) {
							if (partyList[partyNumber - 1].people.get(j).name.equals(temp.name)) {
								partyList[partyNumber - 1].people.remove(j);
							}
						}
						// 그러고 추가하자.
						partyList[0].people.add(temp);
						continue;

					} else if (changePart.equals("2")) {
						System.out.println(temp.name + "님의 부서를 개발팀으로 옮깁니다.");

						// 먼저 해당 부서에서 빼자.
						for (int j = 0; j < partyList[partyNumber - 1].people.size(); j++) {
							if (partyList[partyNumber - 1].people.get(j).name.equals(temp.name)) {
								partyList[partyNumber - 1].people.remove(j);
							}
						}
						// 그러고 추가하자.
						partyList[1].people.add(temp);
						continue;

					} else if (changePart.equals("3")) {
						System.out.println(temp.name + "님의 부서를 인사팀으로 옮깁니다.");

						// 먼저 해당 부서에서 빼자.
						for (int j = 0; j < partyList[partyNumber - 1].people.size(); j++) {
							if (partyList[partyNumber - 1].people.get(j).name.equals(temp.name)) {
								partyList[partyNumber - 1].people.remove(j);
							}
						}
						// 그러고 추가하자.
						partyList[2].people.add(temp);
						continue;

					}

				} else {
					System.out.println("등록된 사원이 아닙니다.");
					continue;
				}

			} if(userInput.equals("quit")) {
				break;
			}

		}

	}
}
