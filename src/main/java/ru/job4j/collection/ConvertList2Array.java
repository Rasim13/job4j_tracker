package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int index = 0;
        System.out.println(list.size());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(index >= list.size()){
                    array[i][j] = 0;
                } else {
                    array[i][j] = list.get(index++);
                }
            }
            System.out.println();
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
