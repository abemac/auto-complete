import java.util.ArrayList;

public class AutocompleteProvider{
	
	Trie data;

	public AutocompleteProvider(Trie data) {
		this.data=data;
	}
	
	//returns list of candidates ordered by confidence
	public ArrayList<Candidate> getWords(String fragment){
		ArrayList<Candidate> words = data.getPossibilites(fragment.toLowerCase());
		words.sort((Candidate c1, Candidate c2) ->  c2.getConfidence() - c1.getConfidence());
		return words;
	}
	
	//trains the algorithm with the provided passage
	public void train(String passage) {
		for (String word : passage.split(" ")) {
			data.insert(word.toLowerCase());
		}
	}

}