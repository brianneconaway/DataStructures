package ExamCorrections;


    public class Main {
        public static void main(String[] args) {
            OurQueue<Integer> queue = new OurQueue<>();

            // Testing offer() method
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);

            // Testing peek() and poll() methods
            Integer peekedElement = queue.peek();
            System.out.println("Peeked element: " + peekedElement);

            Integer polledElement = queue.poll();
            System.out.println("Polled element: " + polledElement);

            peekedElement = queue.peek();
            System.out.println("Peeked element: " + peekedElement);

            // Testing poll() method again
            polledElement = queue.poll();
            System.out.println("Polled element: " + polledElement);

            // Testing poll() on an empty queue
            polledElement = queue.poll();
            System.out.println("Polled element from an empty queue: " + polledElement);
        }
    }


