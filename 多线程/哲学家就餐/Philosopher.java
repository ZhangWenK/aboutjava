
public class Philosopher implements Runnable{
		private Chopstick right;
		private Chopstick left;
		private int index;
		private int thinkTime;
		public Philosopher(Chopstick right, Chopstick left, int index, int thinkTime) {
			super();
			this.right = right;
			this.left = left;
			this.index = index;
			this.thinkTime = thinkTime;
		}
		@Override
		public void run(){
			try{
				while(!Thread.interrupted()){
					System.out.println(this + "thing...");
					thinking();
					System.out.println(this + "start to eat and take right stick");
					right.take();
					System.out.println(this + "take left stick");
					left.take();
					System.out.println(this + "eating");
					thinking();//吃饭，和思考时间一样
					right.drop();
					left.drop();
				}
			}catch(InterruptedException e){
				System.out.println(this+"InterruptedException");
			}
		}
		//哲学家思考
		private void thinking() throws InterruptedException{
			Thread.sleep(thinkTime*100);
		}
		@Override
		public String toString(){
			return "Philosopher [index=" + index + "]";
		}
	}
