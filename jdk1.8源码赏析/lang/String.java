package lang;

/**
 * 阅读jdk有感，把一些重要的方法记录下来，做的一个注解。
 * @author 张文康
 *
 */
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
	
	private final char value[];
	
	private static final long serialVersionUID = -6849794470754667710L;
	
	
	public String(String original){
		this.value = original.value;
	}
	/**
	 * 该方法继承自Object类，作用是比较两个字符串是否值相等。
	 */
	public boolean equals(Object anObject){
		if(this == anObject){
			return true;
		}
		if(anObject instanceof String){
			String anotherString = (String)anObject;
			int n = value.length;
			if(n == anotherString.value.length){
				char v1[] = value;
				char v2[] = anotherString.value;
				int i = 0;
				while(n-- != 0){
					if(v1[i] != v2[i]){
						return false;
					}
					i++;
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * 该方法为Comparable<?>接口的实现方法，该接口其实也就compareTo(T o)这一个方法
	 * 比较两个String，是先把两个String转化成数组，循环比较两个数组的每个对应位置，当两个数组的每个位置的Unicode码都相同时，返回数组的长度差，
	 * 当返回的长度差等于0时，string1.equals(string2)。循环比较时，当两个数组的某个或多个位置Unicode不相同时，该函数返回第一个不相同的
	 * 位置
	 */
	public int compareTo(String anotherString){
		int len1 = value.length;
		int len2 = anotherString.value.length;
		int lim = Math.min(len1, len2);
		char v1[] = value;
		char v2[] = anotherString.value;
		
		int k = 0;
		while(k < lim){
			char c1 = v1[k];
			char c2 = v2[k];
			if(c1 != c2){
				return c1 - c2;
			}
			k++;
		}
		return len1 - len2;
	}
	
	public int length(){
		return value.length;
	}
	
	public char charAt(int index){
		if((index < 0) || (index >= value.length))
			throw new StringIndexOutOfBoundsException(index);
		return value[index];
	}
	/**
	 * 该方法继承自CharSequence，重写方法时返回值为String的substring方法
	 */
	public CharSequence subSequence(int beginIndex, int endIndex){
		return this.substring(beginIndex, endIndex);
	}
	
	public String substring(int beginIndex, int endIndex){
		if(beginIndex < 0){
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if(endIndex > value.length){
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		int subLen = endIndex - beginIndex;
		if(subLen < 0){
			throw new StringIndexOutOfBoundsException(subLen);
		}
		return ((beginIndex == 0) && (endIndex ==value.length)) ? this 
				:new String(value, beginIndex, subLen);
	}
	
	

}
