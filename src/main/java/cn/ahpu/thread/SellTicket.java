package cn.ahpu.thread;

/**
 * @author:liwang
 * @date: 2022/3/31 20:42
 * @Description:TODO
 * @Algorithm Design：TODO
 * 两个窗口买票的分别相互变换的
 */
public class SellTicket {

	public static void main(String[] args) {
		MyRunnable mr1 = new MyRunnable();
		Thread t1 = new Thread(mr1);
		t1.setName("1号窗口");
		Thread t2 = new Thread(mr1);
		t2.setName("2号窗口");
		Thread t3 = new Thread(mr1);
		t3.setName("3号窗口");

		System.out.println("main start");
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main over");

	}
}

class MyRunnable implements Runnable {

	private Integer ticket = 1000;
	private Integer count = 0;

	@Override
	public void run() {
		boolean flag = true;
		Thread thread = Thread.currentThread();

			synchronized (this) {
				while (ticket > 0) {
					{
						this.notifyAll();
						System.out.println(thread.getName() + "卖出一张票,票号+" + ++count + "+还剩票数" + --ticket);
						System.out.println(thread.getName() + "待售中……");
						if (ticket==0){
							break;
						}
						try {
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
/*		else if ("2号窗口".equals(thread.getName())){
			synchronized (this) {
				while (ticket > 0) {
					{
						this.notify();
						System.out.println(thread.getName() + "卖出一张票,票号+" + ++count + "+还剩票数" + --ticket);
						System.out.println(thread.getName() + "待售中……");
						if (ticket==0){
							break;
						}

						try {
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}*/


	}
}


class Ticket {

	public Integer ticketNum;

	public Ticket(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}

	public Integer getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}
}
