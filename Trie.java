import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private Node root;

	public Trie() {
		root = new Node();
	}

	public void insert(String val) {
		Node n = root;
		for (char c : val.toCharArray()) {
			if (n.getChildren().containsKey(c)) {
				n = n.getChildren().get(c);
			} else {
				n.getChildren().put(c, new Node());
				n = n.getChildren().get(c);
			}
		}
		n.increaseCount();
	}

	public ArrayList<Candidate> getPossibilites(String fragment) {
		ArrayList<Candidate> result = new ArrayList<Candidate>();
		Node n = root;
		for (char c : fragment.toCharArray()) {
			if (n.getChildren().containsKey(c)) {
				n = n.getChildren().get(c);
			} else
				return result;//will be empty
		}
		dfs(n, fragment, result);
		return result;
	}

	private void dfs(Node n, String key, ArrayList<Candidate> result) {
		if (n.getCount() > 0) {
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

	public HashMap<Character, Node> getChildren() {
		return children;
	}

	public int getCount() {
		return count;
	}

	public void increaseCount() {
		count++;
	}
}