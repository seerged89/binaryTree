package sample03;

class Node{
	String value;
	Node left;
	Node right;
	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	void inOrder(){
		if(left != null){
			left.inOrder();
		}
		System.out.print(value+"\t");

		if(right != null){
			right.inOrder();
		}
	}
}

public class Exec {

	public static void main(String[] args) {
		// 4. どのように、与えられた二分木で通りがけ順の走査を行いますか？（解答）
		// programming-place.net/ppp/con
		//左→根→右　inOrder
		// D B A B C B D F E F G　というような動きをしている。　一般にinOrderが使われる。検索が速くなる。

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

		root.inOrder();



	}

}
