
public class Threadsummer extends Thread {
	int low;
	int high;
	int sum=0;
	int nums[];
	public void run() {
		for (int i=low; i<high;i++) {
			sum += nums[i];
			
		}
	}
	public Threadsummer(int nums[], int low, int high) {
		this.low=low;
		this.high=high;
		this.nums=nums;
	
	}
}
