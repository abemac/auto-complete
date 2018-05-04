import java.util.ArrayList;
import java.util.HashMap;

//based roughly on https://en.wikipedia.org/wiki/Trie
public class Trie {
	private Node root;

	public Trie() {
		root = new Node();
	}

	//inserts new string into trie
	public void insert(String val) {
		Node n = root;
		for (char c : val.toCharArray()) {
			if (n.getChildren().containsKey(c)) {//node exists
				n = n.getChildren().get(c);
			} else {
				n.getChildren().put(c, new Node());//node does not exist, create it
				n = n.getChildren().get(c);
			}
		}
		n.increaseCount();//the leaf node count is incremented to symbolize occurrence of the key in training data
	}

	//returns list of candidates (unordered)
	public ArrayList<Candidate> getPossibilites(String fragment) {
		ArrayList<Candidate> result = new ArrayList<Candidate>();
		Node n = root;
		for (char c : fragment.toCharArray()) {
			if (n.getChildren().containsKey(c)) {
				n = n.getChildren().get(c);
			} else
				return result;//will be empty
		}
		dfs(n, fragment, result);//perfoms DFS on the remaining portion of the structure to determine possible words that begin with fragment
		return result;
	}

	private void dfs(Node n, String key, ArrayList<Candidate> result) {
		if (n.getCount() > 0) {// count indicates confidence
			result.add(new Candidate(key, n.getCount()));
		}
		for (char c : n.getChildren().keySet()) {
			dfs(n.getChildren().get(c), key + c, result);
		}
	}
}

class Node {
	private HashMap<Character, Node> children;
	private int count;//count of occurrences of the key associated with this Node

	public Node() {
		children = new HashMap<Character, Node>();
		count = 0;
	}

	public HashMap<Character, Node> getChildren() { return children; }
	public int getCount() { return count; }
	public void increaseCount() { count++; }
}