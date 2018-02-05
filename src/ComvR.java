import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ComvR<T> extends Mix<T>{
	private List<T[]> ans;
	private T[] S;

	@Override
	@SuppressWarnings("unchecked")
	public List<T[]> mix(int t,T[] k) {
		this.S=k;
		ans=new ArrayList<>(com(k.length + t -1, t));
		comv(0, t, (T[]) Array.newInstance(k.getClass().getComponentType(), t));
		return ans;
	}
	
	private int com(int s,int t) {
		int ans = 1;
		for(int i=s;i>s-t;i--)ans*=i;
		for (int i=1;i<=t;i++)ans/=i;
		return ans;
	}

	private void comv(int ind, int tam, T[] list) {
		if(tam == 0)
			ans.add(list);
		else {
			for(int i=ind; i< S.length; i++) {
				T[] list2 = list.clone();
				list2[tam-1]=S[i];
				comv(i,tam-1,list2);
			}
		}
	}
}
