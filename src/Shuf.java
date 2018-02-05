import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Shuf<T> extends Mix<T> {
	private  List<T[]> ans;
	private T[] S;

	@Override
	@SuppressWarnings("unchecked")
	public List<T[]> mix(int t, T[] k) {
		ans=new ArrayList<>(shuf(k.length, t));
		this.S=k;
		shuflee(t, (T[]) Array.newInstance(k.getClass().getComponentType(), t));
		return ans;
	}
	
	public void shuflee(int t,T[] list) {
		if(t==0)
			ans.add(list);
		else {
			for (T t2 : S) {
				T[] list2=list.clone();
				list2[t-1]=t2;
				shuflee(t-1, list2);
			}
		}
	}

	
	private int shuf(int k,int t) {
		return (int) Math.pow(k, t);
	}
}
