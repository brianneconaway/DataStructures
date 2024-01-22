public class Test {
    public static void main(String[] args) {

        RingBuffer test1 = new RingBuffer(5);
        System.out.println(test1.isEmpty());
        System.out.println(test1.isFull());

        test1.enqueue(1);
        test1.enqueue(2);
        test1.enqueue(3);

        System.out.println(test1.peek() == 3.0);
        System.out.println(test1.size() == 3);
        System.out.println(!test1.isEmpty());
        System.out.println(!test1.isFull());

        System.out.println(test1.peek() == 3.0);
        test1.dequeue();
        System.out.println(test1.peek() == 4.0);
        System.out.println(test1.dequeue() == 4.0);


    }
}
