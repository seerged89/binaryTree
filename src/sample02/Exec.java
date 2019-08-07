package sample02;

class Node{
	String value;
	Node left;
	Node right;
	public Node(String value, Node left, Node right) {//行きがけ順　DBA(B)C(B)(D)FE(F)Gという流れになる。()は出力されないけど流れがある。
		//行きがけ順：根　左　右
		//通り掛け： 左　根　右
		//帰りがけ：　左　右　根
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public void preOrder(){
		System.out.print(value+"\t");//こちらにヒットした時の処理がプリント
		if(left != null){//ACEGのnullの検査　leftでpre.orderするよ。
				left.preOrder();//これで左のほうに進めるようになる。
		}
		if(right !=null){
			right.preOrder();
		}
	}
}
public class Exec {


	public static void main(String[] args) {
		/**
		 * A B C D E F G
		 * 			D(root)
		 * 		B		F
		 * A	　C	　E		G
		 */
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
		root.preOrder();
	}
}
/*
 * new Node インスタンスを発生させる → メモリ内に、インスタンスがポンと生まれる。
 * その処理が実行される。
 * 処理が終わったら、消えて、通常の流れに戻るイメージ。
 *
 *
 * */


/*	この並びにすると、DBACFEGになる。
 * 		if(left != null){//ACEGのnullの検査　leftでpre.orderするよ。
				left.preOrder();//これで左のほうに進めるようになる。
		}
		if(right !=null){
			right.preOrder();
		}
 *
 *
 *
 * 	この並びだと、DFGEBCAになる。
 * 		if(right !=null){
			right.preOrder();
		}
 * 		if(left != null){//ACEGのnullの検査　leftでpre.orderするよ。
				left.preOrder();//これで左のほうに進めるようになる。
		}

 *
 *
 *
 * */
