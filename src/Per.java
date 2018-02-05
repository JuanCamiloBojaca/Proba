import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Per<T> extends Mix<T> {
	private List<T[]> ans;
	private T[] S;

	@Override
	@SuppressWarnings("unchecked")
	public List<T[]> mix(int t, T[] k) {
		ans = new ArrayList<>(per(k.length,t));
		this.S=k;
		perm(t,new HashSet<>(t),(T[]) Array.newInstance(k.getClass().getComponentType(), t));
		return ans;
	}
	
	public void perm(int t,HashSet<T> ya,T[] list) {
		if(t==0){
			ans.add(list);
		}else {
			for (T t2 : S) {
				if(!ya.contains(t2)) {
					T[] list2=list.clone();
					list2[t-1]=t2;
					HashSet<T> ya2=new HashSet<>(ya);
					ya2.add(t2);
					perm(t-1,ya2,list2);
				}
			}
		}
		
	}
	
	private int per(int k,int t) {
		int ans=1;
		for(int i=k;i>k-t;i--)ans*=i;
		return ans;
	}
	
	

}
