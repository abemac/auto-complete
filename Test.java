
public class Test {

	public static void main(String[] args) {
		AutocompleteProvider ac = new AutocompleteProvider(new Trie());
		
		ac.train("The third thing that I need to tell you is that this thing does not think thoroughly");
		
		System.out.print("thi --> ");
		for (Candidate c : ac.getWords("thi")) {
			System.out.print(c.getWord() + "(" + c.getConfidence()+") ");
		}
		System.out.println();
		
		System.out.print("nee --> ");
		for (Candidate c : ac.getWords("nee")) {
			System.out.print(c.getWord() + "(" + c.getConfidence()+") ");
		}
		System.out.println();
		
		System.out.print("th --> ");
		for (Candidate c : ac.getWords("th")) {
			System.out.print(c.getWord() + "(" + c.getConfidence()+") ");
		}
		System.out.println();

	}

}
