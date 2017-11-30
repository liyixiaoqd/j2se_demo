package object;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TestLog4j {
	static Logger logger = Logger.getLogger(TestLog4j.class);

	public static void main(String args[]) {
		// BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
		logger.info("info");
		logger.trace("trace");
		logger.error("error");

		Runnable t = new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("dddd");
			}
		};
		
		LinkedBlockingQueue lbq = new LinkedBlockingQueue<Runnable>();
		lbq.add(t);
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
				lbq);

		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("任务1");
			}

		});
		
		
		System.out.println("ac");
	}
}
