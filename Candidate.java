
public class Candidate {
	private String word;
	private int confidence;

	public Candidate(String word, int confidence) {
		this.word = word;
		this.confidence = confidence;
	}

	public String getWord() {
		return word;
	}

	public int getConfidence() {
		return confidence;
	}
}