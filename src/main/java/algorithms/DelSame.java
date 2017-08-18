package algorithms;

import lombok.Data;

public class DelSame {

    private static void delSame(SqList sqList) {
        if (sqList.length > 0) {
            int j = 0;
            int[] data = sqList.getData();
            for (int i = 1; i < sqList.length; i++) {
                /*int k = 0;
                while (k <= j && data[k] != data[j]) {
                    k++;
                }*/
                if (data[i] != data[j]) {
                    j++;
                    data[j] = data[i];
                }
            }
            sqList.setLength(j + 1);
        }
    }

    public static void main(String[] args) {
//        int data[] = new int[] {1 , 2, 2, 2,  3, 3, 4, 4, 4, 5};
//        int data[] = new int[] { 2, 2, 2, 2, 2, 5,5};
        int data[] = new int[] { -2, 2, 2, 2, 2, 5,5};
        SqList sqList = new SqList();
        sqList.setData(data);
        sqList.setLength(data.length);
        delSame(sqList);
        System.out.println(sqList);
    }


    @Data
    public static class SqList {
        int[] data;
        int length;
    }

}
