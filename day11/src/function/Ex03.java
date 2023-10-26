package function;

import java.util.Random;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		// RPG게임의 아이템 강화 시뮬레이션
		
		// 아이템 강화할때 마다 아이템의 레벨이 올라간다.										
		// 아이템의 강화하는데는 일정량의 게임머니가소비된다.
		// 게임머니는 한정되어 있다.
		// 아이템의 레벨이 일정값을 넘어가면 강화 확률이 감소한다.
		// 레벨1 ~ 5까지는 100
		// 레벨6 : 80
		// 레벨7 : 90
		// 만약, 강화에 실패하면 게임머니는 그대로 소비하지만 아이템의 레벨은 오히려 떨어진다
		// 한정된 게임머니로 누가 제일 높은 레벨까지 도달하는지 겨루는 게임이다
		// 게임머니를 모두 소비하거나, 스스로 중단할 수 있다.
		
		Scanner sc = new Scanner(System.in);
		int money = 10000;
		int fee = 500;
		int lv = 1;
		int menu;
		boolean flag;
		
		LOOP : while(true) {
			System.out.println("==================================");
			System.out.println("현재 레벨 : " + lv);
			System.out.printf("현재 머니 : %,d원\n", money);
			System.out.println("1. 강화");
			System.out.println("0. 포기");
			System.out.println("메뉴선택 >>> ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				if(money < fee) {
					System.out.println("머니가 부족합니다.");
					break LOOP;
				}
				for(int i = 0; i < 3; i++) {
					System.out.print(".");
					try { Thread.sleep(500); } catch(Exception e) {}
				}
				System.out.println();
				flag = enhance(lv);				// 강화를 시도하고 결과를 반환한다. (현재 아이템 레벨에 따라 성공확률이 달라진다.)
				money -= fee;					// 강화비용을 받는다
				lv += flag ? 1 : -1;			// 성공하면 1이 더해지고, 실패하면 -1이 더해진다
				break;							// break 는 if를 제외한 중괄호 밖으로 나간다.
			case 0:
				break LOOP;						// LOOP라는 라벨을 걸어두어서 해당 중괄호 아래도 나가도록 만든다.
			}
		} // end of while : 이 안에 있는 내용만 반복된다.
			System.out.println("최종결과");
			System.out.println("현재 레벨 : " + lv);
			System.out.printf("현재 머니 : %,d원\n", money);
			System.out.println("점수  : " + (lv * 1000 + money));
			
		sc.close();
		
	}// end of main() : 프로그램 실행 시 가장 먼저 실행되는 함수이다.
	
//	static boolean enhance(int lv) {
//		// 아이템 레벨에 따라 커트라인을 정한다.
//		// 랜덤을 이용해서 1~100사이의 정수를 뽑는다.
//		// 랜덤값과 커트라인을 비교해서 랜덤값이 작거나 같으면 성공 아니면 실패
//		// 커트라인을 정하는식
//		Random ran = new Random();
//		int upGrade = 100;
//		upGrade = ran.nextInt(100) + 1;
//		
//		boolean success = true;
//		if(lv >= 5) {							// 식
//			upGrade -= (lv - 4) * 10;
//			
//		}
//		return success;
//	}
	static boolean enhance(int lv) {
		boolean success = true;
		// 0) 강화 결과는 랜덤값이 기준값 내에 들어야 한다.
		
		// 1) limit = 패턴을 기록하고 규칙성을 파악하여 수식으로 표현
		int limit = 100 - (lv - 4) * 10;
		
		// 2) value = 1에서 100사이 랜덤값
		Random ran = new Random();
		int value = ran.nextInt(100) + 1;
		
		// 3) lv이 5보다 작으면 successs =true
		//		만약 value가 line보다 작거나 같으면 true
		// 		아니면 success =false
		System.out.printf("%d / %d (%s)\n", value, limit value <= limit);
		success = value 
		return success;
				
 				
	}
	
	
	
}	// end of class : main()혹은 다른 함수들은 모두 class 내부에 있어야 한다.
