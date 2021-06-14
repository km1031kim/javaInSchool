import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int lineNum = Integer.parseInt(sc.nextLine());
		int startNum = Integer.parseInt(sc.nextLine());
		int cnt = 0;

		Graph g = new Graph();

		for (int i = 0; i < N; i++) {
			char nodeN = (char) ++cnt;

			Node nnodeN = new Node(nodeN);
			g.addNode(nnodeN);

			if (i == startNum) {
				g.setRootNode(nnodeN);
			}
		}

		for (int i = 0; i < lineNum; i++) {
		
			
			// 입력값과 해당 노드의 인덱스가 같응면 connectNode 실행
			
			// 입력값 - 1 = 노드의 indexOf
			
			String[] arr = sc.nextLine().split(" ");
			int num1 = Integer.parseInt(arr[0]) - 1;
			int num2 = Integer.parseInt(arr[1]) - 1;
		
			
			 //g.connectNode(g.nodes.indexOf(num1 ), g.nodes.indexOf(num2));
		}

		// Lets create nodes as given as an example in the article
		Node nA = new Node('A'); // label = 'A', visited = false
		Node nB = new Node('B'); // label = 'B', visited = false
		Node nC = new Node('C'); // label = 'C', visited = false
		Node nD = new Node('D'); // label = 'D', visited = false
		Node nE = new Node('E'); // label = 'E', visited = false
		Node nF = new Node('F'); // label = 'F', visited = false

		// Create the graph, add nodes, create edges between nodes
		// Graph g=new Graph();
		g.addNode(nA); // nodes.add(nA)
		g.addNode(nB); // nodes.add(nB)
		g.addNode(nC); // nodes.add(nC)
		g.addNode(nD); // nodes.add(nD)
		g.addNode(nE); // nodes.add(nE)
		g.addNode(nF); // nodes.add(nF)
		g.setRootNode(nA); // this.rootNode = nA;

		g.connectNode(nA, nB); // size는 node크기만큼. 현재 6이다. nA랑 nB랑 연결. [6][6]의 adjMatrix 생성. nA의 인덱스 =
								// startindex, nB의 인덱스 = endIndex. 0,1 1,0 = 1로 바꾼다
		g.connectNode(nA, nC); // 0,2 2,0 -> 1
		g.connectNode(nA, nD); // 0,3 3,0 -> 1

		g.connectNode(nB, nE); // 1,4 4,1 -> 1
		g.connectNode(nB, nF); // 1,5 5,1 -> 1
		g.connectNode(nC, nF); // 2,5 5,2 -> 1

		// 이걸로 66 배열에서 0,1로 이루어진 배열이 생성.

		System.out.println(g.nodes);

		// Perform the traversal of the graph
		System.out.println("DFS Traversal of a tree is ------------->");
		g.dfs();

		System.out.println("\nBFS Traversal of a tree is ------------->");
		g.bfs();

	}

}
