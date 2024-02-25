package test1;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class movieExample {
	public static void main(String[] args) {
		boolean run = true;
		boolean seatArray[][] = new boolean[4][5]; //좌석 배열. 예매안됐으면 false
		Map<String, String> reservation = new HashMap<>();
		
		while(run) {
			System.out.println("***********************");
			System.out.println("******영화 예매 시스템*****");
			System.out.println("***********************");
			System.out.println("1. 예매하기");
			System.out.println("2. 예매조회");
			System.out.println("3. 예매취소");
	
			Scanner scan = new Scanner(System.in);
			int selNum = Integer.parseInt(scan.nextLine());
	
			//예매하기
			if(selNum == 1) { 
				System.out.println("*******좌석 현황*******");
				for(int i = 0; i <4; i++) {
					for(int j = 0; j < 5; j++) {
						if(!seatArray[i][j]) {
							System.out.print("[" + (i+1) + "-" + (j+1) + "]");
						}
						else {
							System.out.print("예매");
						}
						System.out.println();
					}
				}
				System.out.println("---------------------");
				System.out.println("좌석을 선택해주세요. 예) 1-1");
				System.out.println("이미 예매된 좌석은\"예매\"라고 표시됩니다. ");
				
				String seatNum = scan.nextLine();
				
				String[] seat = seatNum.split("-");
				int x = Integer.parseInt(seat[0]) - 1;
				int y = Integer.parseInt(seat[1]) - 1;
				//-1하는 이유 : 인덱스는 0 부터고 좌석 표시는 1부터라서 입력받은 좌석보다 -1해서 저장
				
				
				if(!seatArray[x][y]) {
					System.out.println("예매 가능합니다. 예매하시겠습니까?");
					System.out.println("네(1), 아니오(2), 초기화면(0) 중 하나를 입력하세요");
					int reserveChoice = scan.nextInt();
					if(reserveChoice == 1) {
						seatArray[x][y] = true;
						String reserveNum = makeRanNum();
						reservation.put(seatNum, reserveNum);
						System.out.println("예매가 완료되었습니다");
						System.out.println("예매한 좌석 번호: [" + x + "-" + y + "] / 예매번호: [" + reserveNum + "]" );
						System.out.println("감사합니다.");
					}
				}
			}
			
			//예매 확인
			else if(selNum == 2) { 
				System.out.println("예매번호를 입력해 주세요");
				String userNum = scan.nextLine();
				String userSeat = "";
				/*
				 List<String> UserSeat = reservation.entrySet().stream() //map의 Key를 모두 꺼내온 뒤 Stream 타입으로 변환
		                .filter(entry -> Objects.equals(entry.getValue(), userNum)) //Key를 가지고 Value를 가져온 뒤 "찾는값"과 동일한 값만 가져옴
		                .map(Map.Entry::getKey) //맞는 조건이었을 경우 Key를 가져옴
		                .collect(Collectors.toList());//조건에 해당되는 Key를 List 형태로 만든 후 반환
		                오류가 생기는 이유: "["가 포함되어서 나옴..이유는모르겠당
				*/
				 Set<Entry<String, String>> entrySet = reservation.entrySet();       
				 for (Entry<String, String> entry : entrySet) {            
					 if (entry.getValue().equals(userNum)) {
						 userSeat = entry.getKey();
				 }
				}
				 
				System.out.println("고객님이 예매하신 좌석은 [" + userSeat + "] 입니다");
			}
			
			//예매 취소
			else if(selNum == 3) {
				System.out.println("예매번호를 입력해 주세요");
				String reservationNum = scan.nextLine();
				String reservationSeat = "";
				/*
				List<String> reservationSeat = reservation.entrySet()
		                .stream()
		                .filter(entry -> Objects.equals(entry.getValue(), reservationNum))
		                .map(Map.Entry::getKey)
		                .collect(Collectors.toList());
		                */
				Set<Entry<String, String>> entrySet = reservation.entrySet();       
				 for (Entry<String, String> entry : entrySet) {            
					 if (entry.getValue().equals(reservationNum)) {
						 reservationSeat = entry.getKey();
				 }
				}
				System.out.println("고객님이 예매하신 좌석은 [" + reservationSeat + "] 입니다");
				System.out.println("예매를 취소하시겠습니까?");
				System.out.println("네(1), 아니오(2) 중 하나를 입력해주세요.");
				int cancleNum = scan.nextInt();
				String[] Myseat = reservationSeat.toString().split("-");
				int x1 = Integer.parseInt(Myseat[0]) - 1;
				int y1 = Integer.parseInt(Myseat[1]) - 1;
				if(cancleNum == 1) {
					seatArray[x1][y1] = false;
				}
				System.out.println("예매가 취소되었습니다. 감사합니다.");
			}
			else { System.out.println("잘못 입력했습니다."); }
			
			if(!run) {
				scan.close();
			}
		}
	}
	
	//예매번호 생성
	public static String makeRanNum() {
		Random random = new Random();
		int firstNum = 0;  			//1자리 난수
		String firstNumString = ""; //String 으로 변환
		String resultNum = ""; 
		for (int i = 0; i < 8; i++) { 
			firstNum = random.nextInt(9); //0~9까지 수 중에 하나 랜덤으로 고르기
			firstNumString =  Integer.toString(firstNum); //고른 수를 문자열로 변환
			resultNum += firstNumString; //문자열로 변환한 수 이어 붙이기
		}	
        return resultNum;
	}
}
