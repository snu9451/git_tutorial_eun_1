package my.practice;

public class ThreadTest {

	private static Thread t1;

	public static void main(String[] args) {

		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int a = 0; a < 100000; a++) {
					for (int b = 0; b < 10000; b++) {
						for (int c = 0; c < 10000; c++) {
						}
					}
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (int i = 0; i < 1000000; i++) {
					for (int a = 0; a < 1000000; a++) {
						for (int b = 0; b < 100000; b++) {
						}
					}
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread thread_state = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					Thread.State state = t1.getState(); // t1 스레드 상태 얻기
					System.out.println("t1스레드의 상태: " + state);

					// t1 스레드가 객체 생성 상태일 경우 실행 대기 상태로 만듬
					if (state == Thread.State.NEW) {
						t1.start();
					}

					// t1 스레드가 종료 사애일 경우 while문 종료
					if (state == Thread.State.TERMINATED) {
						System.out.println("[최종] t1스레드의 상태: " + state);
						break;
					}

					try {
						Thread.sleep(500); // 0.5초간 일시 정지
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		thread_state.start();
	}
}