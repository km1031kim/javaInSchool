import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	
	public Node rootNode; // 루트노드
	public ArrayList nodes = new ArrayList(); // 노드리스트. addNode를 통해 배열로 node가 들어온다.
	public int[][] adjMatrix;// Edges will be represented as adjacency Matrix. 배열. 방문
	int size; // 배열 사이즈

	public void setRootNode(Node n) {
		this.rootNode = n; // 루트노드 설정(시작)
	}

	public Node getRootNode() {
		return this.rootNode; // 루트노드 리턴
	}

	public void addNode(Node n) {
		nodes.add(n); //노드 추가.
	}

	// This method will be called to make connect two nodes
	public void connectNode(Node start, Node end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}

	private Node getUnvisitedChildNode(Node n) {
		
		

		int index = nodes.indexOf(n); // 노드의 인덱스 가져오기.
		int j = 0; // 0으로 시작
		while (j < size) { // 현재 사이즈는 6.
			// 0,0 = 1 이고, 0,0이 false 인 경우 해당 노드 리턴. j++;
			// 결론 -> 1이고 false인 위치 리턴
		
			if (adjMatrix[index][j] == 1 && ((Node) nodes.get(j)).visited == false) {
				return (Node) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	// BFS traversal of a tree is performed by the bfs() function
	public void bfs() {

		// BFS uses Queue data structure
		Queue q = new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			Node child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	
	// DFS traversal of a tree is performed by the dfs() function
	public void dfs() {
		// DFS uses Stack data structure
		
		Stack s = new Stack(); // 스택 생성
		s.push(this.rootNode); // 루트노드 넣기 
		rootNode.visited = true; // 루트노드 true.
		
		printNode(rootNode); // 루트노드 print
		
		while (!s.isEmpty()) { // empty면 반복문 탈출. 인접노드있을시 1 추가됫으니 다시한번 반복.
			 
			
			Node n = (Node) s.peek(); //현재 루트노드
			
			Node child = getUnvisitedChildNode(n); //루트노드 인덱스에서 인접한 1 리턴.
			if (child != null) {
				child.visited = true;
				printNode(child);
				s.push(child); // 인접한 곳이 있다면 스택에 추가.
			} else {
				s.pop(); // 인접한 곳이 없다면 더이상 내려가지 않으니 pop.
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	// Utility methods for clearing visited property of node
	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	// Utility methods for printing the node's label
	private void printNode(Node n) {
		System.out.print(n.label + " ");
	}

}
