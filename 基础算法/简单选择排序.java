package �㷨;

public class ��ѡ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,4,2,5,1,6,9,7,8};
		System.out.println("����֮ǰ��");
		for(int num:array){
			System.out.print(num+" ");
		}
		for(int i=0; i<array.length; i++){
			int k = i;
			for(int j=k+1; j<array.length; j++){
				if(array[j]<array[k]){
					k = j; //��¼Ŀǰ�ҵ�����Сֵ��λ��
				}
			}
			if(i != k){
				int temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
		System.out.println();
		System.out.println("������");
		for(int num:array){
			System.out.print(num+" ");
		}

	}

}
