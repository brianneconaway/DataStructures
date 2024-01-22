package EditDistanceHW;

public class Test {
    public static void main(String[] args) {

        StopWatch s = new StopWatch();
        EditDistance editDistance = new EditDistance(10000, 10000);

        s.start();
        //editDistance.computeRecursion();
        editDistance.computeDynamicProgramming();
        s.stop();

        System.out.println(s.getElapsedTimeNanos());
    }
    }

