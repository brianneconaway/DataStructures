package BigOh;

public class Test {

	public static void main(String[] args) {
		StopWatch s = new StopWatch();
		Search search = new Search(81920000);

		// Create the object to use for testing here.
		// For example,
		//InitArray x = new InitArray1D(10000);
		//InitArray2D x = new InitArray2D(35000);

		s.start();

		// Put the task to time here.
		// For example,
		//x.initialize();
		search.linearSearch(1);
		s.stop();

		System.out.println(s.getElapsedTimeNanos());
	}
}
