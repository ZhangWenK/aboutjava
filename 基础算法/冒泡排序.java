package À„∑®;

public class √∞≈›≈≈–Ú {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {5,2,4,3,9,1,8,7};
		int temp;
		for(int i=1; i<num.length; i++){
			for(int j=1; j<num.length; j++){
				if(num[j-1]>num[j]){
					temp = num[j-1];
					num[j-1] = num[j];
					num[j] = temp;
				}
			}
		}
		for(int a=0; a<num.length; a++){
			System.out.println(num[a]);
		}

	}

}
