public class RingBuffer<T> {
    private final double[] buffer;
    private final int capacity;
    private int size;
    private int head;
    private int tail;


    /**
     * constructor for the ring buffer function
     * buffer creates new double array
     * @param capacity allows for a specified max
     */
        public RingBuffer(int capacity) {
            this.capacity = capacity;
            this.buffer =  new double[capacity];
            this.size = 0;
            this.head = 0;
            this.tail = 0;
        }


        //number of items in buffer
    public int size() {
            return this.size;
    }

    //check if buffer is empty
    public boolean isEmpty() {
        return this.size() == 0;
    }

    //check if buffer is full
    public boolean isFull(){
        return this.size == capacity;
    }

    //adds item to the end of buffer
    public void enqueue(double x)  {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Buffer is full, cannot enqueue.");
        }
        this.buffer[tail] = x;
        this.tail = (this.tail + 1) % this.capacity;

        size++; //updates size
    }

    //adds item ot the front of buffer
    public double dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Buffer is empty, cannot dequeue.");
        }

        // Get the item from the front of the buffer.
        double item = this.buffer[this.head];
        this.buffer[this.head] = 0;
        this.head = (this.head + 1) % this.capacity;
        size--; //updates size

        return item;
    }

    // returns item from the front
    public double peek() {
            return this.buffer[this.head];
    }

}

