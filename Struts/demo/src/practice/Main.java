package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    	
        List<String> list = new ArrayList<>();
        list.add("����");
        list.add("�λ�");
        list.add("����");
        list.add("����");

        System.out.println(list);
        List<String> result = list.stream() // ��Ʈ�� ����
                                  .limit(2) //�߰� ����
                                  .collect(Collectors.toList()); // ���� ����
        System.out.println(result);

        System.out.println("list -> transformation -> set");
        Set<String> set = list.stream()
                              .filter("����"::equals)
                              .collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}