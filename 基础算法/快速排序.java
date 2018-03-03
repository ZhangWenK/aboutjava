package 算法;

public class 快速排序 {
	public static int partition(int []array, int lo, int hi){
		int key = array[lo];
		while(lo<hi){
			while(array[hi]>key && hi>lo){
				hi--;
			}
			array[lo] = array[hi];
			while(array[lo]<key && lo<hi){
				lo++;
			}
			array[hi] = array[lo];
		}
		array[hi] = key;
		System.out.println(key+"的位置是"+(hi+1));
		return hi;
	}
	public static void sort(int[] array, int lo, int hi){
		if(lo>hi){
			return;
		}
		int index = partition(array, lo ,hi);
		sort(array, lo, index-1);
		sort(array, index+1, hi);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {4,5,3,1,7,2,6,9,8,10};
		sort(array, 0, 9);

	}

}
