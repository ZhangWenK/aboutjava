
public class buytickets {
	private static int count = 100;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				while(true){
					if(count>0){
						System.out.println("t1窗口，火车票卖出第"+count--+"张");
					}else{
						break;
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				while(true){
					if(count>0){
						System.out.println("t2窗口，火车票卖出第"+count--+"张");
					}else{
						break;
					}
				}
			}
		});
		
		t1.start();
		t2.start();

	}

}
