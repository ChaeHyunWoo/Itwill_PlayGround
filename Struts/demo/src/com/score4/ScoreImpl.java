package com.score4;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score {
	
	//key는 학번 / value 는 ScoreVO
	private Map<String, ScoreVO> hMap = new TreeMap<>();
	
	Scanner sc = new Scanner(System.in);
	
	String hak;
	
	@Override
	public void input() {
		
		System.out.print("학번 : ");
		hak = sc.next();
		
		if(searchHak(hak)) {
			System.out.println("학번이 존재합니다 추가 실패!!");
			return; //존재하지않으면 탈출
		}
		
		ScoreVO vo = new ScoreVO();
		
		System.out.print("이름 : ");
		vo.setName(sc.next());
		
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학 : ");
		vo.setEng(sc.nextInt());
		
		//List는 add Map은 put
		hMap.put(hak, vo);
		
		System.out.println("추가 성공!");
	}

	@Override
	public boolean searchHak(String hak) {
		
		//값이 존재하는지 검사
		if(hMap.containsKey(hak)) {
			return true;
		}
		
		return false;
	}

	@Override
	public void print() {
							//Map에서 Iterator쓸려면 하단 코드밖에없음 외워야함.(우회도로)
		Iterator<String> it = hMap.keySet().iterator();//map은 이터레이터가 없기에 keyset한테 빌려와서 쓴다.
		
	while(it.hasNext()) {
			
			String hak = it.next();
			ScoreVO vo = hMap.get(hak);
			
			System.out.println(hak + " " + vo.toString());
		}
	}

	@Override
	public void delete() {
		String del;
		System.out.print("삭제할 학번?");
		del = sc.next();

		if (hMap.containsKey(del)) {
			hMap.remove(del); // remove에 키(del)를 준다.
			System.out.println("삭제완료");
		} else {
			System.out.println("해당 학번 없음");
		}
	}

	@Override
	public void update() {
		System.out.print("이름, 점수를 수정할 학번 : ");
		hak = sc.next();
		//수정할 학번이 있으면 !를 통해 true를  false로 바꿔서 if문 아래로 / 없으면 수정 실패!
		if (!searchHak(hak)) {	// 앞에 !가 있는게  아래 국영수묻는곳이 true인데 true 코딩이 더 많아서/ 코딩이 많은게 안에 적은게 밖으로 하는게좋음
										// 그래서 true가 나왔을때 !를 통해 false로 바꿔줘서 if문을 빠져나오게 해준다.
			System.out.println("수정 실패!!");
			return;
		}
		
			String key = hak;
			
			ScoreVO vo1 = hMap.get(key); 
			String preName = vo1.getName();
			
			vo1.setName(preName); //이름을 기존값대로 넣어주지 않으면 NULL값이 설정되게 됨	
			
			System.out.print("국어");
			vo1.setKor(sc.nextInt());
			System.out.print("영어");
			vo1.setEng(sc.nextInt());
			System.out.print("수학");
			vo1.setMat(sc.nextInt());

			hMap.put(key, vo1);
			System.out.println("수정 성공!");
	}
	

	@Override
	public void findHak() {
		System.out.print("검색할 학번 : ");
		hak = sc.next();
		
		if (hMap.containsKey(hak)) {
		
			ScoreVO value = hMap.get(hak);
			System.out.println(hak + ":" + value);
			return;
		
		} else {
		
			System.out.println(hak + ": 학번이 존재하지 않습니다. 검색 실패!!");
		}
	}

	@Override
	public void findName() {
		System.out.print("검색하고 싶은 이름 : ");
		String fName = sc.next();

		Iterator<String> it2 = hMap.keySet().iterator();
		
		boolean flag = false; //찾는 이름이 있는지 flag 사용
		while (it2.hasNext()) { //동일 이름이 여러개일 수 있음. break 쓰면 안됨. 가지고 있는 데이터 다 돌려봐야 함.
		
			String key = it2.next();
			ScoreVO vo = hMap.get(key);
			
			if (vo.getName().equals(fName)) { // vo에 있는 네임과 fName과 이름이 같으면
			
				System.out.println("학번:" + key + "점수 :" + vo);
				flag = true; //한번이라도 동일한 이름이 있으면 flag를 true로 변경
			
			}
		
		}
		
		if (!flag) {
			System.out.println("이름이 존재하지 않습니다. 검색 실패!");
		} else {
			System.out.println("검색 성공!!");
		}
	}

}