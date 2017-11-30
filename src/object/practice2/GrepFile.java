package object.practice2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import object.threads.ThreadPool;

public class GrepFile {

	public static class FileThread extends Thread {
		File f;

		public FileThread(File f) {
			this.f = f;
		}

		@Override
		public void run() {
			try {
				byte[] bs = new byte[200];
				FileInputStream in = new FileInputStream(f);
				in.read(bs);
				System.out.format("[%s]文件中内容 [%s]\n", f.getName(), new String(bs));
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static class StaticInner {

	}

	public static void main(String args[]) {

		String dirPath = "D:/work_download/tmp/生产处理/20171124_DHL包裹统计";
		File dir = new File(dirPath);

		ThreadPool pool = new ThreadPool();

		for (final File f : dir.listFiles()) {
			if (f.isDirectory())
				continue;
			if (!f.getName().endsWith(".txt"))
				continue;
			System.out.println("get file: " + f.getName());
			FileThread ft = new FileThread(f);

			pool.add(ft);
			// try {
			// t.join();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}

		// if(last_t!=null)
		// try {
		// last_t.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("main end");
	}

}
