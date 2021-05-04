import java.util.Random;

public class GameManager {
	public void play() {
		Player1[] Group1 = { new Archerjeongyeon("1팀.정연"), new Healerjaemin("1팀.재민"), new Magicianjunyeong("1팀.준영"),
				new Tankerjunhyeong("1팀.준형"), new Warriornamdeok("1팀.남덕"), new ArcherHyukjung("1팀.혁중"),
				new AssassinHyejin("1팀.혜진"), new GunmanYoungsun("1팀.영선"), new HealerArim("1팀.아림"),
				new MagicianYounghyun("1팀.영현") };
		Player2[] Group2 = { new ArcherDuyong("2팀.두용"), new HealerSungun("2팀.성건"), new KnightSeunghyun("2팀.승현"),
				new MagicianSijin("2팀.시진"), new WarriorSungun("2팀.성건2"), new KnightVora("2팀.보라"),
				new MagicianSoojin("2팀.수진"), new WarriorJingyu("2팀.GM진규킴"), new WarriorReakwon("2팀.래권"),
				new MagicianChaiWeon("2팀.채원") };
		Player3[] Group3 = { new ArcherKyungryul("3팀.경율"), new KnightJihyo("3팀.지효"), new MagicianSungchul("3팀.성철"),
				new WarriorHana("3팀.하나"), new ArcherEunhye("3팀.은혜"), new KnightDongki("3팀.동기"),
				new KnightJaeHyun("3팀.재현"), new WarriorYeonju("3팀.연주") }; //

		Random r = new Random();

		for (int i = 0; i < 999; i++) {
			System.out.println("\n\n");
			System.out.println("/////////////////////////////////////// " + (i + 1)
					+ " 턴 ///////////////////////////////////////" + "\n\n");

			for (int Group1Index = 0; Group1Index < Group1.length; Group1Index++) {
				int attackWhere = r.nextInt(2);

				if (attackWhere == 0) { // 1조의 2조 공격

					
					// 힐러는 Index말고. 
					// if (player[PlayerIndex].name.equals("힐러)"{힐링메소드}
					if (Group1Index == 1 || Group1Index == 8) { // 힐링 메소드 구현을 위해 치유사의 인덱스는 따로 잡기.
//						System.out.println("-------1조 힐러의 차례-------");
						int healTarget = r.nextInt(Group1.length);
						if (Group1[Group1Index].isLive() && Group1[healTarget].isLive()) { // 치유사 본인이 살아있어야 치유 메소드 사용

//							System.out.println(Group1[Group1Index].name + "이(가)" + Group1[healTarget].name + " 을(를)치유했습니다.");
							Group1[Group1Index].healing(Group1[healTarget]);
						} else if (Group1[Group1Index].isLive() && !Group1[healTarget].isLive()) {
							System.out.println("죽어있는 팀원은 살릴 수 없습니다. 다른 팀원을 고르세요!");
							for (int Group1healtarget = 0; Group1healtarget < Group1.length; Group1healtarget++) {
								if (Group1[Group1healtarget].isLive()) {
									System.out.println(Group1[Group1Index].name + "이(가)" + " 이미 죽은 팀원 대신 "
											+ Group1[Group1healtarget].name + "을 치료합니다");
									Group1[Group1Index].healing(Group1[Group1healtarget]);
									break;
								}
							}
						}
					} else {

						int attackTarget = r.nextInt(Group2.length); // 힐러를 제외한 직업들의 일반 공격.
						if (Group1[Group1Index].isLive() && Group2[attackTarget].isLive()) {
//							System.out.println("----------1조의 2조 공격----------");
							Group1[Group1Index].attackP2(Group2[attackTarget]);
						} else if (Group1[Group1Index].isLive() && !Group2[attackTarget].isLive()) {
//							System.out.println("이미 죽은 2조의 조원입니다.");
							for (int Group2target = 0; Group2target < Group2.length; Group2target++) {
								if (Group2[Group2target].isLive()) {
									System.out.println(Group1[Group1Index].name + "이(가) 살아있는 다른 2조 조원 "
											+ Group2[Group2target].name + "을(를) 공격했습니다.");
									Group1[Group1Index].attackP2(Group2[Group2target]);

									break;
								}
							}
						}
					}
				}
				// 1조 -> 3조 공격
				if (attackWhere == 1) {

					if (Group1Index == 1 || Group1Index == 8) {
//						System.out.println("-------1조 힐러의 차례-------");
						int healTarget = r.nextInt(Group1.length);
						if (Group1[Group1Index].isLive() && Group1[healTarget].isLive()) { // 치유사 본인이 살아있어야 치유 메소드 사용
																							// 가능.
//							System.out.println(Group1[Group1Index].name + "이(가)" + Group1[healTarget].name + "을(를)치유했습니다.");
							Group1[Group1Index].healing(Group1[healTarget]);
						} else if (Group1[Group1Index].isLive() && !Group1[healTarget].isLive()) {
							System.out.println("죽어있는 팀원은 살릴 수 없습니다. 다른 팀원을 고르세요!");
							for (int Group1healtarget = 0; Group1healtarget < Group1.length; Group1healtarget++) {
								if (Group1[Group1healtarget].isLive()) {
									System.out.println(Group1[Group1Index].name + "이(가)" + " 이미 죽은 팀원 대신 "
											+ Group1[Group1healtarget].name + "을 치료합니다");
									Group1[Group1Index].healing(Group1[Group1healtarget]);
									break;
								}
							}
						}
					} else {

						int attackTarget = r.nextInt(Group3.length); // 일반 공격.
						if (Group1[Group1Index].isLive() && Group3[attackTarget].isLive()) {
//							System.out.println("----------1조의 3조 공격----------");
							Group1[Group1Index].attackP3(Group3[attackTarget]);
						} else if (Group1[Group1Index].isLive() && !Group3[attackTarget].isLive()) {
//							System.out.println("이미 죽은 3조의 조원입니다.");
							for (int Group3target = 0; Group3target < Group3.length; Group3target++) {
								if (Group3[Group3target].isLive()) {
									System.out.println(Group1[Group1Index].name + "이(가) 살아있는 다른 3조 조원 "
											+ Group3[Group3target].name + "을(를) 공격했습니다.");
									Group1[Group1Index].attackP3(Group3[Group3target]);

									break;
								}
							}

						}
					}
				}
			}

			// 2조 - 1조 공격
			for (int Group2Index = 0; Group2Index < Group2.length; Group2Index++) {

				int attackWhere = r.nextInt(2);

				if (attackWhere == 0) {

					if (Group2Index == 1) { // 힐링 메소드 구현을 위해 치유사의 인덱스는 따로 잡기.
//						System.out.println("-------2조 힐러의 차례-------");
						int healTarget = r.nextInt(Group2.length);
						if (Group2[Group2Index].isLive() && Group2[healTarget].isLive()) { // 치유사 본인이 살아있어야 치유 메소드 사용
																							// 가능.
							System.out.println(
									Group2[Group2Index].name + "이(가)" + Group2[healTarget].name + "을(를)치유했습니다.");
							Group2[Group2Index].healing(Group2[healTarget]);
						} else if (Group2[Group2Index].isLive() && !Group2[healTarget].isLive()) {
							System.out.println("죽어있는 팀원은 살릴 수 없습니다. 다른 팀원을 고르세요!");
							for (int Group2healtarget = 0; Group2healtarget < Group2.length; Group2healtarget++) {
								if (Group2[Group2healtarget].isLive()) {
									System.out.println(Group2[Group2Index].name + "이(가)" + " 이미 죽은 팀원 대신 "
											+ Group2[Group2healtarget].name + "을 치료합니다");
									Group2[Group2Index].healing(Group2[Group2healtarget]);
									break;
								}
							}
						}
					} else {

						int attackTarget = r.nextInt(Group1.length); // 일반공격
						if (Group2[Group2Index].isLive() && Group1[attackTarget].isLive()) {
//							System.out.println("----------2조의 1조 공격----------");
							Group2[Group2Index].attackP1(Group1[attackTarget]);
						} else if (Group2[Group2Index].isLive() && !Group1[attackTarget].isLive()) {
//							System.out.println("이미 죽은 1조의 조원입니다.");
							for (int Group1target = 0; Group1target < Group1.length; Group1target++) {
								if (Group1[Group1target].isLive()) {
									System.out.println(Group2[Group2Index].name + "이(가) 살아있는 다른 1조 조원 "
											+ Group1[Group1target].name + "을(를) 공격했습니다.");
									Group2[Group2Index].attackP1(Group1[Group1target]);

									break;
								}
							}

						}
					}
				}
				// 2조 - 3조 공격
				if (attackWhere == 1) {

					if (Group2Index == 1) { // 힐링 메소드 구현을 위해 치유사의 인덱스는 따로 잡기.
//						System.out.println("-------2조 힐러의 차례-------");
						int healTarget = r.nextInt(Group2.length);
						if (Group2[Group2Index].isLive() && Group2[healTarget].isLive()) { // 치유사 본인이 살아있어야 치유 메소드 사용
																							// 가능.
							System.out.println(
									Group2[Group2Index].name + "이(가)" + Group2[healTarget].name + "을(를)치유했습니다.");
							Group2[Group2Index].healing(Group2[healTarget]);
						} else if (Group2[Group2Index].isLive() && !Group2[healTarget].isLive()) {
							System.out.println("죽어있는 팀원은 살릴 수 없습니다. 다른 팀원을 고르세요!");
							for (int Group2healtarget = 0; Group2healtarget < Group2.length; Group2healtarget++) {
								if (Group2[Group2healtarget].isLive()) {
									System.out.println(Group2[Group2Index].name + "이(가)" + " 이미 죽은 팀원 대신 "
											+ Group2[Group2healtarget].name + "을 치료합니다");
									Group2[Group2Index].healing(Group2[Group2healtarget]);
									break;
								}
							}
						}

					} else {

						int attackTarget = r.nextInt(Group3.length);
						if (Group2[Group2Index].isLive() && Group3[attackTarget].isLive()) {
//							System.out.println("----------2조의 3조 공격----------");
							Group2[Group2Index].attackP3(Group3[attackTarget]);

						} else if (Group2[Group2Index].isLive() && !Group3[attackTarget].isLive()) {
//							System.out.println("이미 죽은 3조의 조원입니다.");
							for (int Group3target = 0; Group3target < Group3.length; Group3target++) {
								if (Group3[Group3target].isLive()) {
									System.out.println(Group2[Group2Index].name + "이(가) 살아있는 다른 3조 조원 "
											+ Group3[Group3target].name + "을(를) 공격했습니다.");
									Group2[Group2Index].attackP3(Group3[Group3target]);

									break;
								}
							}

						}
					}
				}
			}

			// 3조(힐러 없음) 1조 공격
			for (int Group3Index = 0; Group3Index < Group3.length; Group3Index++) {

				int attackWhere = r.nextInt(2);

				if (attackWhere == 0) {

					int attackTarget = r.nextInt(Group1.length);
					if (Group3[Group3Index].isLive() && Group1[attackTarget].isLive()) {
//						System.out.println("----------3조의 1조 공격----------");
						Group3[Group3Index].attackP1(Group1[attackTarget]);

					} else if (Group3[Group3Index].isLive() && !Group1[attackTarget].isLive()) {
//						System.out.println("이미 죽은 1조의 조원입니다.");
						for (int Group1target = 0; Group1target < Group1.length; Group1target++) {
							if (Group1[Group1target].isLive()) {
								System.out.println(Group3[Group3Index].name + "이(가) 살아있는 다른 1조 조원 "
										+ Group1[Group1target].name + "을(를) 공격했습니다.");
								Group3[Group3Index].attackP1(Group1[Group1target]);

								break;
							}
						}

					}
				}

				// 3조(힐러 없음) - 2조 공격
				else if (attackWhere == 1) {
//					System.out.println("----------3조의 2조 공격----------");

					int attackTarget = r.nextInt(Group2.length);
					if (Group3[Group3Index].isLive() && Group2[attackTarget].isLive()) {
//						System.out.println("----------3조의 2조 공격----------");
						Group3[Group3Index].attackP2(Group2[attackTarget]);

					} else if (Group3[Group3Index].isLive() && !Group2[attackTarget].isLive()) {
//						System.out.println("이미 죽은 2조의 조원입니다.");
						for (int Group2target = 0; Group2target < Group2.length; Group2target++) {
							if (Group2[Group2target].isLive()) {
								System.out.println(Group3[Group3Index].name + "이(가) 살아있는 다른 2조 조원 "
										+ Group2[Group2target].name + "을(를) 공격했습니다.");
								Group3[Group3Index].attackP2(Group2[Group2target]);

								break;
							}
						}
					}
				}
			}

			// 게임 종료 여부 확인
			boolean isGroup1Live = false;
			for (int Group1Index = 0; Group1Index < Group1.length; Group1Index++) {
				if (Group1[Group1Index].isLive()) {
					isGroup1Live = true; // 하나라도 살아있으면 트루!
				}
			}
			boolean isGroup2Live = false;
			for (int Group2Index = 0; Group2Index < Group2.length; Group2Index++) {
				if (Group2[Group2Index].isLive()) {
					isGroup2Live = true;
				}
			}

			boolean isGroup3Live = false;
			for (int Group3Index = 0; Group3Index < Group3.length; Group3Index++) {
				if (Group3[Group3Index].isLive()) {
					isGroup3Live = true;
				}
			}

			if (isGroup1Live && !isGroup2Live && !isGroup3Live) {
				System.out.println("////////////////////////// 축하합니다.1조 승리! //////////////////////////");
				break;
			} else if (!isGroup1Live && isGroup2Live && !isGroup3Live) {
				System.out.println("////////////////////////// 축하합니다.2조 승리! //////////////////////////");
				break;
			} else if (!isGroup1Live && !isGroup2Live && isGroup3Live) {
				System.out.println("////////////////////////// 축하합니다.3조 승리! //////////////////////////");
				break;
			}
			try {
				Thread.sleep(100); // 1초마다 텀주기
			} catch (InterruptedException e) {
			}
		}
	}
}
