package Tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> CJ =
                new BinarySearchTree<>(1, new BinarySearchTree<>(), new BinarySearchTree<>());

        BinarySearchTree<Integer> Dez =
                new BinarySearchTree<>(12, new BinarySearchTree<>(), new BinarySearchTree<>());

        BinarySearchTree<Integer> Bri2 =
                new BinarySearchTree<>(14, new BinarySearchTree<>(), new BinarySearchTree<>());


        BinarySearchTree<Integer> Bri =
                new BinarySearchTree<>(14, Bri2, new BinarySearchTree<>());


        BinarySearchTree<Integer> Dan =
                new BinarySearchTree<>(9, CJ, new BinarySearchTree<>());


        BinarySearchTree<Integer> Richard =
                new BinarySearchTree<>(15, Bri, new BinarySearchTree<>());


        BinarySearchTree<Integer> Michael =
                new BinarySearchTree<>(13, Dez, Richard);

        BinarySearchTree<Integer> Casey =
                new BinarySearchTree<>(10, Dan, Michael);

        System.out.println(Casey.height()); // 4
        System.out.println(Michael.height()); // 3
        System.out.println(Dan.height()); // 2
        System.out.println(Bri.height()); // 1
        System.out.println(CJ.getLeftSubtree().height()); //0

        //test for level function
        System.out.println(Casey.level(14)); // expect 4
        System.out.println(Michael.level(14)); // 3
        System.out.println(Richard.level(14)); // 2
        System.out.println(Bri.level(14)); // 1
        System.out.println(Dan.level(14)); //-1

        System.out.println(Casey.count(14));
        System.out.println(Casey.count(20));



    }
}
