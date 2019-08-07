package sample04;

class Node{
	String value;
	Node left;
	Node right;
	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public void postOrder(){
		if(left!=null){
			left.postOrder();
		}
		if(right!=null){
			right.postOrder();
		}
		System.out.print(value+"\t");

	}
}

public class Exec {

	public static void main(String[] args) {
		//6. どのように、帰りがけ順の走査のアルゴリズムを実装しますか？（解答）

		Node root = new Node("D",//Dがroot　始まり
				new Node("B",//2層目 左 new がポイント！。
						new Node("A",null,null),//3層目 左　null,nullで末端
						new Node("C",null,null)//3層目 右
						),
				new Node("F",//2層目 右
						new Node("E",null,null),//3層目 左
						new Node("G",null,null)//3層目 右
						)
				);
		root.postOrder();
	}

}
