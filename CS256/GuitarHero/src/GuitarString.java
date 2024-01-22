public class GuitarString {
    private RingBuffer buffer;
    private int N;
    private int time;


    /**
     * Creates a constructor for a given frequency
     * sets time to 0
     * creates new RingBuffer for N
     * fills buffer with 0's
     *
     * @param frequency has a sample rate of 44100
     */
    public GuitarString(double frequency){
        this.N = (int) Math.ceil(44100 / frequency);
        this.buffer = new RingBuffer(this.N); // create a new guitar string
        this.time = 0;
        for (int i = 0; i < N; i++){
            this.buffer.enqueue(0);
        }
    }

    /**
     * creates constructor whose values are within an array
     * @param init an array of doubles
     * using enqueue it adds each element in the init array to
     *             the buffer
     */
    public GuitarString(double[] init) {
        this.N = init.length;
        this.buffer = new RingBuffer(N);
        for (int i = 0; i < N; i++){
            this.buffer.enqueue(init[i]);
        }
        this.time = 0;

    }

    //assigns a random value
    public void pluck()    {
        for (int i = 0; i < this.buffer.size(); i++){
            this.buffer.dequeue();
            this.buffer.enqueue(Math.random() -0.5); // random value
        }
    }

    // advance the simulation one time step
    public void tic() {
        double first = this.sample();
        this.buffer.dequeue();

        double second = this.sample();

        double updated = 0.994 * (0.5 * (first + second));
        this.buffer.enqueue(updated);

        this.time++;
    }

    // returning the sample
    public double sample() {
        return this.buffer.peek();
    }

    //returning the number of tics
    public int time() {
        return this.time;
    }
}
