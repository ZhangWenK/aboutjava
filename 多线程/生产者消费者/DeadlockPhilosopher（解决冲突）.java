import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class DeadlockPhilosopher {

	@Test
	public void test() throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		int size = 5;
		int thinkingTime = 0;
		Chopstick[] chopstick = new Chopstick[size];
		for(int i=0;i<size;i++)
			chopstick[i] = new Chopstick(i);
		for(int i=0;i<size-1;i++)
			executor.execute(new Philosopher(chopstick[i], chopstick[(i+1)%size], i, thinkingTime));
		executor.execute(new Philosopher(chopstick[0], chopstick[size-1], size, thinkingTime));
		Thread.sleep(4*1000);
		executor.shutdownNow();
	}

}
