
public class Chopstick{
		private int index;//��������
		private boolean use = false;
		public Chopstick(int index){
			super();
			this.index = index;
		}
		@Override
		public String toString() {
			return "Chopstick[index="+index+"]";
		}
		
		//��ÿ���
		public synchronized void take() throws InterruptedException{
			while(use){
				wait();
			}
			use = true;
		}
		
		//�黹����
		public synchronized void drop(){
			use = false;
			notifyAll();
		}
	}