package cheatsheat;

class Node {
	Node next;
	int val;
	
	Node(int val) {
		this.val=val;
	}
}

public class LinkedListPbm {

	public static void main(String[] args) {
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		
		LinkedList l=new LinkedList();
		l.reverse(head);
		
		
		
	}

}


class LinkedList {

	public void reverse(Node head) {
		Node pre=null;
		Node cur=head;
		
		while(cur!=null) {
			Node next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		head=pre;
		printll(head);
	}

	public void printll(Node head) {
		Node temp=head;
		
		while(temp!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
	}
	
	
}