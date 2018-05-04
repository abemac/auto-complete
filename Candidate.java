
public class Candidate {
	private String word;
	private int confidence;

	public Candidate(String word, int confidence) {
		this.word = word;
		this.confidence = confidence;
	}

	//returns the autocomplete candidate
	public String getWord() {
		return word;
	}
	
	//returns the confidence for the candidate
	public int getConfidence() {
		return confidence;
	}
}