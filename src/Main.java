import java.util.Random;

public class Main {
public static void main(String args[]) {
	int numbers[] = new int[200000000];
	Random rand = new Random();
	for (int i=0; i<200000000;i++) {
		numbers[i]= rand.nextInt(10)+1;
		
	}
	int sum = 0;
	long start = System.currentTimeMillis();
	for (int i=0; i<200000000;i++) {
		sum += numbers[i];
		
	}
	long finish = System.currentTimeMillis();
	System.out.println("Serial: "+ (finish-start)+ " ms - "+ sum);
	 start = System.currentTimeMillis();

	Threadsummer threads[]= new Threadsummer[10];
	for(int i=0;i<10;i++) {
		threads[i]= new Threadsummer(numbers,i*200000000,(i+1)*20000000);
		threads[i].run();
	}
	boolean ready = true;
	do {
	if(Thread.activeCount()>1)	
		ready =false;
	else
		ready = true;
	}
	while(!ready);
	 sum = 0;
	for(int i=0; i<10; i++) {
		sum+=threads[i].sum;
	}
	 finish = System.currentTimeMillis();
	System.out.println("Threaded: "+ (finish-start)+ " ms - "+ sum);
}
}
