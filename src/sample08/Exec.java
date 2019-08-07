package sample08;

class Node{
	String value;
	Node left;
	Node right;
	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	void inOrder(){//通り掛け順 ABCDEFG
		if(left!=null){
			left.inOrder();
		}
		if(isLeaf()){
			System.out.println(value+"\t");
		}
		if(right!=null){
			right.inOrder();
		}
	}
	boolean isLeaf(){//葉っぱかどうかの判断をさせるメソッド
		return (left == null && right == null);//右左が全部nullだったら葉っぱだから、これで判別が可能に。
	}
}


public class Exec {

	public static void main(String[] args) {
		// 8. どのように、二分探索木の全ての葉を表示しますか？（解答）
		/*
		 * 　　　D
		 * 　　B　　F
		 * 　A　C　E G
		 *
		 * 葉　というのは、A C E Gのところ。枝が伸びていないところです。←メソッドを作って解決
		 *
		 * */
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


	}

}
