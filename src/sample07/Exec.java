package sample07;

import java.util.Stack;

class Node{
	String value;
	Node left;
	Node right;
	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public void inOrder(){
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
		//5. どのように、再帰を使わずに通りがけ順で、与えられた二分木の全てのノードを表示しますか？（解答）
		//A	B	C	D	E	F	G 順だよ。 inOrder
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
		System.out.println("再帰使う場合");
		root.inOrder();
		System.out.println();
		System.out.println("再帰使わない場合");


		Stack<Node> stack = new Stack<>();//スタックのコレクションオブジェクトができた。今は空
		Node current = root;//先頭はrootが入った
		

		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);//左側をどんどんつんでいく。
				current = current.left;//左の枝のほうに進んでいく。
			}
			//一番下まで進んでくとcurrentがnullになってしまっている。
			current = stack.pop();//ポップすることで、nullじゃなくなる。ここで戻す。
			System.out.print(current.value+"\t");
			current = current.right;
			//左側下って行って　うえに上がって　右側の左側に下り、最後に右に行く。
		}

	}

}
