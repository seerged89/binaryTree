package sample06;

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
		// 7. どのように、再帰を使わずに帰りがけ順で、二分木の走査を行いますか？（解答）
		//つまり、A	C	B	E	G	F	D	の順
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

//		System.out.println("再帰");
//		root.postOrder();
		System.out.println();
		System.out.println();


		System.out.println("再帰じゃない");
		Stack<Node> stack = new Stack<>();

		stack.push(root);//スタックに入った。一番下になる。


		while(!stack.isEmpty()){//stack boxが空じゃないなら、繰り返す
//			Node current = stack.pop();//一番上に積まれたものを取り出す。
			Node current = stack.peek();//取り除かずに中のものを見る。取り出さないので、stackの中身はそのまま。下でpopされたからstackの中身が変化している。
			//currentの中にはrootが入っている状態
			Node left = current.left;//rootのleftに当たるnew nodeが入る。下のほうでnullが代入されたら、2回目はnullが入ることになる。
			Node right = current.right;//rootのrightに当たるnew nodeが入る。下のほうでnullが代入されたら、2回目はnullが入ることになる。
			//葉っぱだった場合は、出力する
			if(left == null && right ==null){
				System.out.print(current.value+"\t");
				//表示させたらポップさせる。
				current = stack.pop();//積んだものを今度はまたcurrentに入れなおす。
			}else{
				if(right != null){
					stack.push(right);//積んで
					current.right = null;//これで葉っぱに近づけていく。
				}
				if(left != null){
					stack.push(left);
					current.left = null;
				}
			}

		}



	}

}
