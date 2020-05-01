package workshop.person.control;

import java.util.*;

import workshop.person.entity.PersonEntity;

public class PersonManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		if(args.length < 1 ) {
//			System.out.println("성별 값을 입력하세요");
//			System.exit(0);
//		}
		PersonManager pManager = new PersonManager();	
		PersonEntity[] persons = new PersonEntity[10];	
		pManager.fillPersons(persons);
		pManager.showPersons(persons);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("성별을 입력하세요 : ");
		char gender = sc.next().charAt(0);
		
		System.out.println("\n 입력된 성별 값은 " + gender);
		System.out.println("성별 " + gender + "(은)는 " + pManager.findbyGender(persons,gender) + "명 입니다. \n");
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("\n 이름 " + name + " 으로 찾기 결과입니다.");
		pManager.showPersons(persons,name);
		sc.close();
		

	}

	public void showPersons(PersonEntity[] persons, String name) {
		for (PersonEntity item : persons) {
			if(name.equals(item.getName())) {
				System.out.println("[이름] " + item.getName());
				System.out.println("[성별] " + item.getGender());
				System.out.println("[전화번호] " + item.getPhone());
				
			}
			
		}
	}

	public int findbyGender(PersonEntity[] persons, char gender) {
		int cnt=0;
		for (PersonEntity item : persons) {
			if(item.getGender() == gender) {
				cnt ++;
			}
		}
		return cnt;
	}

	public void showPersons(PersonEntity[] persons) {
		
		//foreach 입력 후, ctrl + space 하면 for each 문장 자동완성
		for(PersonEntity item:persons) {
			System.out.println("[이름] " + item.getName() + "\t [성별] " + item.getGender() + "\t [전화번호] " + item.getPhone());
		}
		// TODO Auto-generated method stub
		
	}

	public void fillPersons(PersonEntity[] persons) {
		// TODO Auto-generated method stub
		persons[0]=new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
		persons[1]=new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
		persons[2]=new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542");
		persons[3]=new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223");
		persons[4]=new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333");
		persons[5]=new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934");
		persons[6]=new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932");
		persons[7]=new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939");
		persons[8]=new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202");
		persons[9]=new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832");
	}

}
