
public class Chopstick{
		private int index;//筷子数量
		private boolean use = false;
		public Chopstick(int index){
			super();
			this.index = index;
		}
		@Override
		public String toString() {
			return "Chopstick[index="+index+"]";
		}
		
		//获得筷子
		public synchronized void take() throws InterruptedException{
			while(use){
				wait();
			}
			use = true;
		}
		
		//归还筷子
		public synchronized void drop(){
			use = false;
			notifyAll();
		}
	}