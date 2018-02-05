import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
public class Main {
	private final static Consumer<String[]> imp=(a) -> {for (String b : a)System.out.print(b+" ");System.out.println();};
	private final static Predicate<String[]> filtro=(a)->{
		return a[0].equals("a");
	};
	
	
	public static void main(String[] args) throws IOException {	
		Mix<String> mix2=new Shuf<>();

		String[] t = {"a","b","c","d"};		
		List<String[]> ans2= mix2.mix(2, t);
		
		System.out.println(ans2.stream().filter(filtro).count()+"/"+ans2.size());
		ans2.stream().filter(filtro).forEach(imp);
		

	}
}
