package sample05;

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

	public void preOrder(){
		System.out.print(value+"\t");
		if(left!=null){
			left.preOrder();
		}
		if(right!=null){
			right.preOrder();
		}


	}
}

public class Exec {

	public static void main(String[] args) {
		// 3. どのように、再帰を使わずに行きがけ順で、
		//与えられた二分木の走査を行いますか？（解答）

		//
		/*
		 * キュー　samuraiblog キューという箱の中にデータを積んでいく。
		 * ところてんみたいな感じで値を一つずつ出力していく。　買い物のレジの流れのイメージ。
		 *
		 * a →「a b c [d]」→d
		 *入れたもので押し出されて一番古いものが出力される。
		 *
		 *
		 * スタック変数 a=データ1
		 * a →「[a] b c d」→a
		 * ウェブのサーフィン　違うページへ飛んだ　戻った時にはスタックに戻る。
		 *入れたものを一番初めに取り出す。
		 *PCはもともとメモリはスタックで作られている。ヒープ領域。
		 *
		 *
		 * **/

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

		Stack<Node> stack = new Stack<>();//collectionと同じ感じ。スタックのインスタンスの箱を作るイメージ。


		//スタックの考え方を簡単に理解
		Node root2 = new Node("X",null,null);
		Node root3 = new Node("Y",null,null);
		Node root4 = new Node("Z",null,null);

		stack.push(root);//積んでいく作業 root4→「[root4], root3, root2, root」→root4　みたいになっていくイメージ
		stack.push(root2);//一番最初に入れたものが一番下になる。テトリスみたいな。だから432rootの順に積まれている。
		stack.push(root3);
		stack.push(root4);//これで積見終わった！　次は取り出していくぞ。　※参考：メモリをいじれる言語　アセンブラ　という

		while(!stack.isEmpty()){//スタックの中に値があるならtrue、繰り返し続ける
			Node current = stack.pop();//一番上のトップが取り出されたことになる。
			System.out.print(current.value+"\t");//トップを取り出していくの繰り返しをしていく。積んだものを削っていく感じ。
		}

		System.out.println();
		System.out.println();

		//↓再帰を使わずに行きがけ順。 再帰は使わないからpreOrderインスタンスメソッドは使っていない。
		stack.push(root);
		while(!stack.isEmpty()){
			Node current = stack.pop();
			System.out.print(current.value+"\t");
			if(current.right != null){
				stack.push(current.right);//右側が続くのであれば、それをvalueを積んでいきましょう。
			}
			if(current.left != null){
				stack.push(current.left);//右側が終わって、左側も続くのであればvalueを積んで。
			}
		}
		System.out.println();
		System.out.println();

		//再帰を使用した２分岐
		root.preOrder();

	}

}
