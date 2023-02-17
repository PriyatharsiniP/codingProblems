import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*Given a string, count the frequency of each character in it and print the count uniquely in a descending order.
Example i/p:"aaabfferxggxghaxx" o/p:4321*/
public class CountFrequencyOfLetter {

	public static void main(String[] args) {
		String string = "aaabfferxggxghaxx";
		countFrequency(string);
	}

	private static void countFrequency(String string) {
		Map<Character,Integer> mapCount = new HashMap<>();
		Set<Integer> intSet = new HashSet<>();
		for(int i=0;i<string.length();i++) {
			if(mapCount.containsKey(string.charAt(i))) {
				int count=mapCount.get(string.charAt(i));
				mapCount.put(string.charAt(i),count+1);
			}else {
				mapCount.put(string.charAt(i),1);
			}
		}
		for(Map.Entry<Character,Integer> mapLoop:mapCount.entrySet()) {
			intSet.add(mapLoop.getValue());
		}
		intSet.stream().sorted((set1,set2)->set2-set1).forEach(s->System.out.println(s));
	}
}
