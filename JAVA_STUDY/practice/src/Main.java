package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    	
        List<String> list = new ArrayList<>();
        list.add("서울");
        list.add("부산");
        list.add("속초");
        list.add("서울");

        System.out.println(list);
        List<String> result = list.stream() // 스트림 생성
                                  .limit(2) //중간 연산
                                  .collect(Collectors.toList()); // 최종 연산
        System.out.println(result);

        System.out.println("list -> transformation -> set");
        Set<String> set = list.stream()
                              .filter("서울"::equals)
                              .collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}