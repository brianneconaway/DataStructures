package MyList;

import MyLinkListHW.MyLinkedList;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> aList = new MyLinkedList<>();
        System.out.println(aList.isEmpty()); //true
        System.out.println(aList.size()); //0
        aList.add("A");
        System.out.println(aList); // [A]
        System.out.println(aList.size()); // 1
//        System.out.println(aList.isEmpty()); // false
        aList.add("B");
        System.out.println(aList); // [B, A]
        System.out.println(aList.size()); // 2
//        System.out.println(aList.get(1)); // A
        aList.add("C");
        System.out.println(aList); // [B, A, C]


        // goes before the B, because D is replacing the middle Node
        aList.add(1,"D");
        System.out.println(aList);

        // goes before the D because it is middle, so E is replacing the middle Node
        aList.add(2, "E");
        System.out.println(aList);

        aList.add(2,"F");
        System.out.println(aList);


//        System.out.println(aList.size()); // 3
//        System.out.println(aList.get(2)); // C
//        System.out.println(aList.remove(0)); //B
//        System.out.println(aList); // [B, A]
//        System.out.println(aList.size()); // 2
//        System.out.println(aList);
    }

}
