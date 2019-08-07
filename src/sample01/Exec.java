package sample01;

//2. どのように、与えられた二分木で行きがけ順の走査を行いますか？（解答）
//行きがけ順preorder、通り掛け順in-order、帰りがけ順探索postorder

class Node {
	int value;
	Node left;//自分のクラス型を使う。Node型。nodeは節という意味。カプセル化はしていない。
	Node right;
	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}

public class Exec {

	public static void main(String[] args) {
		// どのように、二分探索木を実装しますか？　ウィキペディアの二分探索木
		Node root = new Node(8, //root根っこに8開始点
				new Node(3,//nullをリーフと呼ぶ。nodeとreifがあるね。
						new Node(1,null,null),
						new Node(6,
								new Node(4,null,null),
								new Node(7, null, null))),//左側に伸びる枝
				new Node(10,
						null,
						new Node(14,
								new Node(13,null,null),
								null))
				);//右側に伸びる枝
	}

}
