package lang;

/**
 * �Ķ�jdk�иУ���һЩ��Ҫ�ķ�����¼����������һ��ע�⡣
 * @author ���Ŀ�
 *
 */
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
	
	private final char value[];
	
	private static final long serialVersionUID = -6849794470754667710L;
	
	
	public String(String original){
		this.value = original.value;
	}
	/**
	 * �÷����̳���Object�࣬�����ǱȽ������ַ����Ƿ�ֵ��ȡ�
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
	 * �÷���ΪComparable<?>�ӿڵ�ʵ�ַ������ýӿ���ʵҲ��compareTo(T o)��һ������
	 * �Ƚ�����String�����Ȱ�����Stringת�������飬ѭ���Ƚ����������ÿ����Ӧλ�ã������������ÿ��λ�õ�Unicode�붼��ͬʱ����������ĳ��Ȳ
	 * �����صĳ��Ȳ����0ʱ��string1.equals(string2)��ѭ���Ƚ�ʱ�������������ĳ������λ��Unicode����ͬʱ���ú������ص�һ������ͬ��
	 * λ��
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
	 * �÷����̳���CharSequence����д����ʱ����ֵΪString��substring����
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
