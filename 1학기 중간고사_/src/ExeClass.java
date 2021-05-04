import java.util.ArrayList;
import java.util.Scanner;

public class ExeClass {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Voter> v1 = new ArrayList<Voter>();
		ArrayList<PartyA> p1 = new ArrayList<PartyA>();
		ArrayList<PartyB> p2 = new ArrayList<PartyB>();
		ArrayList<PartyC> p3 = new ArrayList<PartyC>();

		for (int i = 0; i < 999; i++) {
			System.out.println("-------환영합니다 유권자님. 메뉴를 입력해주세요.-------");
			System.out.println("숫자 '1' 입력 = 유권자 정보 입력");
			System.out.println("숫자 '2' 입력 = 유권자 전체 정보 출력");
			System.out.println("숫자 '3' 입력 = 유권자 통계 출력");
			System.out.println("숫자 '4' 입력 = 선호 정당 입력");
			System.out.println("숫자 '5' 입력 = 선호 정당 통계 출력");
			System.out.println("'stop' 입력 = 시스템 종료");
			String menuNumber = s.nextLine();

			if (menuNumber.equals("1")) {
				// 유권자 정보 입력받기/
				System.out.println("유권자 정보를 입력합니다.");

				System.out.println("이름을 입력해주세요.");
				String name = s.nextLine();
				System.out.println("주소를 입력해주세요");

				String address = s.nextLine();
				System.out.println("나이를 입력해주세요");

				String ageString = s.nextLine();
				int age = Integer.parseInt(ageString);

				// v1에 데이터 넣기.
				v1.add(new Voter(name, address, age));

				System.out.println(name + "님 환영합니다. 메인 메뉴로 돌아갑니다");
				System.out.println();
				continue;

			} else if (menuNumber.equals("2")) {
				// 유권자 전체 정보 출력받기.
				System.out.println("유권자의 전체 정보를 출력합니다");
				for (int j = 0; j < v1.size(); j++) {
					System.out.println(v1.get(j).name + "님의 나이는" + " " + v1.get(j).age + ", 주소는" + " "
							+ v1.get(j).address + "입니다.");
				}
				System.out.println("메인 메뉴로 돌아갑니다.");
				System.out.println();
				continue;
			} else if (menuNumber.equals("3")) {
				System.out.println("등록된 유권자분들의 통계를 출력합니다");

				// 등록된 유권자의 수
				int voterCount = v1.size();

				// 등록된 유권자의 나이 평균 구하기
				int voterAgeSum = 0; // 나이 총합
				double voterAvgAge = 0; // 나이 평균
				// 나이 총합 구하기.
				for (int j = 0; j < v1.size(); j++) {
					voterAgeSum = voterAgeSum + v1.get(j).age;
				}
				// 나이 평균 구하기.
				voterAvgAge = voterAgeSum / (double) v1.size();
				double avgAge = Math.round(voterAvgAge * 10) / (double) 10; // 소수점 첫째짜리까지 표시.

				// 연령대별 유권자의 수 구하기. 20대부터 80대까지.
				int Twenties = 0;
				int Thirties = 0;
				int Fourties = 0;
				int Fifties = 0;
				int Sixties = 0;
				int Seventies = 0;
				int Eighties = 0;

				for (int j = 0; j < v1.size(); j++) {
					if (v1.get(j).generation.equals("20대")) {
						Twenties++;
					} else if (v1.get(j).generation.equals("30대")) {
						Thirties++;
					} else if (v1.get(j).generation.equals("40대")) {
						Fourties++;
					} else if (v1.get(j).generation.equals("50대")) {
						Fifties++;
					} else if (v1.get(j).generation.equals("60대")) {
						Sixties++;
					} else if (v1.get(j).generation.equals("70대")) {
						Seventies++;
					} else if (v1.get(j).generation.equals("80대")) {
						Eighties++;
					}

				}

				System.out.println("현재 전체 등록된 유권자의 수는 총" + " " + voterCount + "분 입니다.");
				System.out.println("현재 등록된 유권자분들의 평균 나이는" + " " + avgAge + "세 입니다.");
				System.out.println("연령대별 유권자의 수는." + "\n" + "20대" + " " + Twenties + "명" + "\n" + "30대" + " " + Thirties
						+ "명" + "\n" + "40대" + " " + Fourties + "명" + "\n" + "50대" + " " + Fifties + "명" + "\n" + "60대"
						+ " " + Sixties + "명" + "\n" + "70대" + " " + Seventies + "명" + "\n" + "80대" + " " + Eighties
						+ "명 입니다.");
				System.out.println();
				continue;
			} else if (menuNumber.equals("4")) {
				System.out.println("선호 정당을 입력합니다. 이미 등록된 유권자인지 확인합니다.");
				String existName = "";
				String existAddress = "";
				int existAge = 0;
				String existGeneration = "";

				System.out.println("유권자님의 이름을 입력해주세요");
				String voterName = s.nextLine();

				System.out.println("유권자님이 등록한 주소를 입력해주세요(띄어쓰기 없이 전체주소 입력)");
				String voterAddress = s.nextLine();

				System.out.println("유권자님이 등록한 나이를 입력해주세요(숫자로만)");
				String voterageString = s.nextLine();
				int voterAge = Integer.parseInt(voterageString);

				// 등록된 유권자인지 확인
				for (int j = 0; j < v1.size(); j++) {
					if (v1.get(j).name.equals(voterName) && v1.get(j).address.equals(voterAddress)
							&& v1.get(j).age == voterAge) {
						existName = voterName;
						existAddress = voterAddress;
						existAge = voterAge;
						existGeneration = v1.get(j).generation; // 연령대도 입력.

					}
				}

				// 이미 선호 정당을 선택한 유권자인지 확인.
				String partyA = "";
				String partyB = "";
				String partyC = "";

				// A 정당을 선택한 사람인지
				for (int j = 0; j < p1.size(); j++) {
					if (p1.get(j).name.equals(existName) && p1.get(j).address.equals(existAddress)
							&& p1.get(j).age == existAge) {
						partyA = "A";

					}
				}

				// B 정당을 선택한 사람인지
				for (int j = 0; j < p2.size(); j++) {
					if (p2.get(j).name.equals(existName) && p2.get(j).address.equals(existAddress)
							&& p2.get(j).age == existAge) {
						partyB = "B";

					}
				}

				// C 정당을 선택한 사람인지
				for (int j = 0; j < p3.size(); j++) {
					if (p3.get(j).name.equals(existName) && p3.get(j).address.equals(existAddress)
							&& p3.get(j).age == existAge) {
						partyC = "C";

					}
				}

				if (partyA.equals("A")) {
					System.out.println(voterName + "님은 이미 A정당을 선택하셨습니다.");
					System.out.println("선호 정당을 수정하시겠습니까?(yes or no) 입력");
					String changeParty = s.nextLine();
					if (changeParty.equals("no")) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						System.out.println();
						System.out.println();
						continue;
					} else if (changeParty.equals("yes")) {
						System.out.println("선호 정당을 변경합니다. 선호 정당을 입력해주세요.(B or C)");
						String reselectParty = s.nextLine();

						if (reselectParty.equals("B")) { // B 정당 선호시 B정당 클래스에 추가.

							p2.add(new PartyB(existName, existAddress, existAge, existGeneration));

						} else if (reselectParty.equals("C")) { // C 정당 선호시 C정당 클래스에 추가.

							p3.add(new PartyC(existName, existAddress, existAge, existGeneration));

						} else {
							System.out.println("올바른 입력값이 아닙니다. 메인 메뉴로 돌아갑니다");
							continue;
						}

						// 선호 정당 재 선택 후 원래 선호 정당 클래스에서 제외시킨다. B,C를 선택 했을 경우에만 원래 정당에서 탈퇴해야 하기에 등록 후
						// 제외시킨다.

						if (reselectParty.equals("B") || reselectParty.equals("C")) {
							// A 정당 클래스에서 제외.
							for (int j = 0; j < p1.size(); j++) {
								if (p1.get(j).name.equals(existName) && p1.get(j).address.equals(existAddress)
										&& p1.get(j).age == existAge && p1.get(j).generation.equals(existGeneration)) {
									p1.remove(j);
									System.out.println(existName + "님 선호 정당 변경 완료");
									System.out.println();
									break;

								}
							}
						}
					} else
						System.out.println("올바른 입력값이 아닙니다. 메인 메뉴로 돌아갑니다.");
					System.out.println();
					continue;

				} else if (partyB.equals("B")) {
					System.out.println(voterName + "님은 이미 B정당을 선택하셨습니다.");
					System.out.println("선호 정당을 수정하시겠습니까?(yes or no) 입력");
					String changeParty = s.nextLine();
					if (changeParty.equals("no")) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						System.out.println();
						continue;
					} else if (changeParty.equals("yes")) {
						System.out.println("선호 정당을 변경합니다. 선호 정당을 입력해주세요.(A or C)");
						String reselectParty = s.nextLine();

						if (reselectParty.equals("A")) { // A 정당 선호시 A정당 클래스에 추가.

							p1.add(new PartyA(existName, existAddress, existAge, existGeneration));

						} else if (reselectParty.equals("C")) { // C 정당 선호시 C정당 클래스에 추가.

							p3.add(new PartyC(existName, existAddress, existAge, existGeneration));

						} else {
							System.out.println("올바른 입력값이 아닙니다. 메인 메뉴로 돌아갑니다");
							continue;
						}

						// 선호 정당 재 선택 후 원래 선호 정당 클래스에서 제외시킨다. A,C를 선택 했을 경우에만 원래 정당에서 탈퇴해야 하기에 등록 후
						// 제외시킨다.

						// B 정당 클래스에서 제외.
						if (reselectParty.equals("A") || reselectParty.equals("C")) {
							for (int j = 0; j < p2.size(); j++) {
								if (p2.get(j).name.equals(existName) && p2.get(j).address.equals(existAddress)
										&& p2.get(j).age == existAge && p2.get(j).generation.equals(existGeneration)) {
									p2.remove(j);
									System.out.println(existName + "님 선호 정당 변경 완료");
									System.out.println();
									break;

								}
							}
						}
					} else
						System.out.println("올바른 입력값이 아닙니다. 메인 메뉴로 돌아갑니다.");
					System.out.println();
					continue;

				} else if (partyC.equals("C")) {

					System.out.println(voterName + "님은 이미 C정당을 선택하셨습니다.");
					System.out.println("선호 정당을 수정하시겠습니까?(yes or no) 입력");
					String changeParty = s.nextLine();
					if (changeParty.equals("no")) {
						System.out.println("메인 메뉴로 돌아갑니다.");
						System.out.println();
						continue;
					} else if (changeParty.equals("yes")) {
						System.out.println("선호 정당을 변경합니다. 선호 정당을 입력해주세요.(A or B)");
						String reselectParty = s.nextLine();

						if (reselectParty.equals("A")) { // A 정당 선호시 A정당 클래스에 추가.

							p1.add(new PartyA(existName, existAddress, existAge, existGeneration));

						} else if (reselectParty.equals("B")) { // B 정당 선호시 B정당 클래스에 추가.

							p2.add(new PartyB(existName, existAddress, existAge, existGeneration));

						} else {
							System.out.println("올바른 입력값이 아닙니다. 메인 메뉴로 돌아갑니다");
							continue;
						}

						// 선호 정당 재 선택 후 원래 선호 정당 클래스에서 제외시킨다. A,B를 선택 했을 경우에만 원래 정당에서 탈퇴해야 하기에 등록 후
						// 제외시킨다.

						// C 정당 클래스에서 제외.
						if (reselectParty.equals("A") || reselectParty.equals("B")) {
							for (int j = 0; j < p3.size(); j++) {
								if (p3.get(j).name.equals(existName) && p3.get(j).address.equals(existAddress)
										&& p3.get(j).age == existAge && p3.get(j).generation.equals(existGeneration)) {
									p3.remove(j);
									System.out.println(existName + "님 선호 정당 변경 완료");
									System.out.println();
									break;

								}
							}
						}
					} else
						System.out.println("올바른 입력값이 아닙니다. 메인 메뉴로 돌아갑니다.");
					System.out.println();
					continue;

				}

				else if (existName.equals("") && existAddress.equals("") && existAge == 0) {
					System.out.println("등록된 유권자가 아닙니다. 메인 메뉴로 돌아갑니다.");
					continue;
				} else {

					// 등록된 유권자이고, 선호 정당을 입력 안 한 유권자일 경우.
					System.out.println(existName + "님 환영합니다. 선호 정당을 입력해주세요('A', 'B', 'C' 중 입력해주세요)");
					String selectParty = s.nextLine();
					if (selectParty.equals("A")) {
						System.out.println(existName + "님 A 정당 선택");
						// A 정당 클래스에 추가
						p1.add(new PartyA(existName, existAddress, existAge, existGeneration));
						System.out.println("선호 정당 입력 완료");
						System.out.println();
						continue;
					}
					if (selectParty.equals("B")) {
						System.out.println(existName + "님 B 정당 선택");
						// B 정당 클래스에 추가
						p2.add(new PartyB(existName, existAddress, existAge, existGeneration));
						System.out.println("선호 정당 입력 완료");
						System.out.println();
						continue;
					}
					if (selectParty.equals("C")) {
						System.out.println(existName + "님 C 정당 선택");
						// C 정당 클래스에 추가
						p3.add(new PartyC(existName, existAddress, existAge, existGeneration));
						System.out.println("선호 정당 입력 완료");
						System.out.println();
						continue;
					} else
						System.out.println("올바른 입력값이 아닙니다. 메인 메뉴로 돌아갑니다.");
					System.out.println();
					continue;

				}

			} else if (menuNumber.equals("5")) {
				System.out.println("유권자들의 선호 정당에 대한 통계를 출력합니다");
				// 전체 유권자 대비 선호 정당을 입력한 사람의 수 및 비율
				// 정당 별 선호자 수 및 비율
				// 연령대 별 선호 정당의 수 및 비율 - 미구현.
				// 권역대 별 선호 정당의 수 및 비율 - 미구현.

				int voterCount = v1.size();
				int PartyAcount = p1.size();
				int PartyBcount = p2.size();
				int PartyCcount = p3.size();
				int totalParty = PartyAcount + PartyBcount + PartyCcount;
				double partyInsertPercent = voterCount / (double) totalParty * 100;

				System.out.println("전체 유권자 대비 선호 정당을 입력한 사람의 수 및 비율 " + partyInsertPercent + "퍼센트");

				int totalPartyMember = PartyAcount + PartyBcount + PartyCcount;
				double PartyAPercent = Math.round((PartyAcount * 100) / (double) voterCount);
				double PartyBPercent = Math.round((PartyBcount * 100) / (double) voterCount);
				double PartyCPercent = Math.round((PartyCcount * 100) / (double) voterCount);

				System.out.println(
						"A 정당 선호자 수 = " + PartyAcount + " 전체 선호자 대비 A 정당이 차지하는 비율은 " + PartyAPercent + "퍼센트 입니다");
				System.out.println(
						"B 정당 선호자 수 = " + PartyBcount + " 전체 선호자 대비 B 정당이 차지하는 비율은 " + PartyBPercent + "퍼센트 입니다");
				System.out.println(
						"C 정당 선호자 수 = " + PartyCcount + " 전체 선호자 대비 C 정당이 차지하는 비율은 " + PartyCPercent + "퍼센트 입니다");

			}

			else if (menuNumber.equals("stop")) {
				System.out.println("시스템을 종료합니다");
				break;
			} else
				System.out.println("올바른 입력값이 아닙니다. 다시 입력해주세요");
			System.out.println();
			continue;

		}

	}

}
