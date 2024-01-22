package Queue;

import java.util.Random;

public class Customer {
	// instance variables
	private int arrivalTime;
	private int serviceTime;
	
	// constructor
	public Customer(int anArrivalTime) {
		arrivalTime = anArrivalTime;
		serviceTime = (new Random()).nextInt(5) + 1;
	}

	// accessors/getters
	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}
}
