package object.threads;

public class TestThreadPool {
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();

		for (int i = 0; i < 12; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// System.out.println("执行任务");
					// 任务可能是打印一句话
					// 可能是访问文件
					// 可能是做排序
				}
			};

			pool.add(task);

//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}
}
