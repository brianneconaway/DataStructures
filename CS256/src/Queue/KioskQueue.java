package Queue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class KioskQueue {
	// instance variable
	private Queue<Customer> line;
	
	// constructor
	public KioskQueue() {
		line = new ArrayBlockingQueue<Customer>(100);
	}
	
	// simulate method
	public void simulate() {
		// simulate an hour (60 minutes)
		// compute the average waiting time of customers
		int totalWaitTime = 0;
		int totalCustomersServed = 0;
		
		Random randomizer = new Random();
		
		// keep track of the next available time
		int nextAvailableTime = 0;
		
		int gone= 0;
		// generate the current time from 0 to 60 minutes
		for (int currentTime = 0; currentTime <= 60; currentTime++) {
			// compute the number of customers arriving at current time
			int numberOfArrivals = randomizer.nextInt(5);
			
			// create and add the customers to the line
			for (int customer = 0; customer < numberOfArrivals; customer++) {
				// create a customer
				Customer aNewCustomer = new Customer(currentTime);
				// add this customer to the line
				if (!line.offer(aNewCustomer)) {
					gone++;
				}
			}
			
			// check if there is a customer waiting AND
			// the kiosk is free (currentTime >= nextAvailableTime)
			if ( !line.isEmpty() && currentTime >= nextAvailableTime) {
				// get the first customer in line off the queue
				Customer kioskUser = line.poll();
				// compute next available time
				nextAvailableTime = currentTime + kioskUser.getServiceTime();
				// compute the customer's wait time
				int waitTime = currentTime - kioskUser.getArrivalTime();
				// add the wait time to the total
				totalWaitTime += waitTime;
				// increment number of customers served
				totalCustomersServed++;
			}
			
		}
		
		//print out some statistics
		System.out.println("Average wait time: " 
				+ (double)totalWaitTime / totalCustomersServed);
		System.out.println("Customers served: " + totalCustomersServed);
		System.out.println("Customers still in line: " 
				+ line.size());
		System.out.println("Customers turned away: " 
				+ gone);
	}
}









