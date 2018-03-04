package 算法;

public class 简单选择排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,4,2,5,1,6,9,7,8};
		System.out.println("交换之前：");
		for(int num:array){
			System.out.print(num+" ");
		}
		for(int i=0; i<array.length; i++){
			int k = i;
			for(int j=k+1; j<array.length; j++){
				if(array[j]<array[k]){
					k = j; //记录目前找到的最小值的位置
				}
			}
			if(i != k){
				int temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
		System.out.println();
		System.out.println("交换后：");
		for(int num:array){
			System.out.print(num+" ");
		}

	}

}
