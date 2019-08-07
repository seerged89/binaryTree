package sample09;

class Node {
	String value;
	Node left;
	Node right;
//	int count =0; ここだと数を数えられない。というのも、nodeがいろいろ移動して、葉っぱが右左といろいろ動いてしまうから。うまくcountされない。
//	instanceの中のcountになってしまい、消えたらカウントされない。
	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	void inOrder(){
		if(left != null){
			left.inOrder();
		}
		if(isLeaf()) {
			System.out.print(value +"\t");
			Exec.count++;//Exec.count!! ←実行された回数を求める。Execクラスのcount!で++。
		}
		if(right != null){
			right.inOrder();
		}
	}
	boolean isLeaf(){
		return (left ==null && right ==null);
	}
}

public class Exec {
	public static int count = 0;//staticの領域に、countを用意する。instanceが消えてもcountされるようになる。
	//instance領域は、動的で、増えたり減ったりする。

	public static void main(String[] args) {
		//9. どのように、与えられた二分木の葉のノードの数を数えますか？（解答）つまり葉っぱの数。答えは4つとわかっている。
		Node root = new Node("D",//Dがroot　始まり
				new Node("B",//2層目 左 new がポイント！
						new Node("A",null,null),//3層目 左　null,nullで末端
						new Node("C",null,null)//3層目 右
						),
				new Node("F",//2層目 右
						new Node("E",null,null),//3層目 左
						new Node("G",null,null)//3層目 右
						)
				);
		root.inOrder();
		System.out.println();
		System.out.println("leaves ="+count);

	}

}
