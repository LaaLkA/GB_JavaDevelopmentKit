package Sems.Sem4.Ex2;

import java.util.*;

/**
 * �������� ��������� ������� ���� � ������� ���� � ������� ����������� List - �������� ���������
 * �������� ���������� ������ Set �� ������ List
 * ���������� ���������� ������� (���������� �������)
 * ���������� ���������� ������� (�� ���������� ���� � �����, �� � �������� �������)
 * ������� ��� ��������, ���������� ����� "�"
 */
public class Program {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                Arrays.asList("����", "���������", "������", "�����", "��������", "����", "��������"));
        minLength(convertListToSet(names));
        minmaxLength(convertListToSet(names));
        Set<String> set = convertListToSet(names);
        deleteNamesByChar(set, '�');
        System.out.println(set);


    }

    public static Set<String> convertListToSet(List<String> names) {
        return new HashSet<>(names);
    }

    public static void minLength(Set<String> names) {
        System.out.println(names.stream().min(Comparator.naturalOrder()).orElse(null));
    }

    public static void minmaxLength(Set<String> names) {
        List<String> res = new ArrayList<>();
        res.add(names.stream().min(Comparator.comparing(String::length)).orElse(null));
        res.add(names.stream().max(Comparator.comparing(String::length)).orElse(null));
        System.out.println("min - max: " + res.get(0) + " " + res.get(1));
    }
    public static void deleteNamesByChar(Set<String> names, char symbol) {
        names.removeIf(name -> name.contains(String.valueOf(symbol)));
    }
}
