package LinkedList;

import java.util.*;


class Node {
	Node next;
	int data;
	Node(int data) {
		this.data=data;
	}
}

class LinkedList {
	Node head,tail;
	
	public void insert(int data) {
		Node n=new Node(data);
		if(head==null) {
			head=n;
			tail=n;
		} else {
			tail.next=n;
			tail=tail.next;
		}
	}
	
	
	public Node reverse(Node head) {
        Node pre=null;
        Node current=head;
        
        while(current!=null) {
            Node next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        
        return pre;  
    }
	
	 public void print() {
	        Node temp=head;
	        while(temp!=null) {
	            System.out.print(temp.data+" ");
	            temp=temp.next;
	        }
	        System.out.println();
	  }

   //detect-loop
	public boolean detectLoop(Node head) {
		Node slow=head,fast=head;
		
		while(slow!=null && fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast)
				return true;
		}
		return false;
	}

	
   //remove-Pos from end
	public Node removeEndll(Node head, int n) {
		 int count=0;
		 Node temp=head;
		 
		 while(temp!=null) {
			 count++;
			 temp=temp.next;
		 }
		 
		 if(count==n)
		 return head.next;
		 
		 int pos=count-n;
		 Node temp1=head;
		 
		 for(int i=0;i<pos-1;i++)
			 temp1=temp1.next;
		 
		 if(temp1!=null && temp1.next!=null)
			 temp1.next=temp1.next.next;
		 
		 return head;
		 
	}
	
	
	//reorder
   void reorderlist(Node head) {
        
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
         
        Node dummy=null;
        
        while(slow!=null) {
            Node next=slow.next;
            slow.next=dummy;
            dummy=slow;
            slow=next;
        }
        
        while(dummy.next!=null) {
            Node temp1=head.next;
            head.next=dummy;
            head=temp1;
            
            Node temp2=dummy.next;
            dummy.next=head;
            dummy=temp2;
        }
         
    }
   
   
   // add +1 to LL
   
   public Node addOne(Node head) {
	    head=reverse(head);
	    
	    int carry=1;
	    Node temp=head;
	    Node pre=null;
	    
	    while(temp!=null) {
	    	int sum=temp.data+carry;
	    	carry=sum/10;
	    	temp.data=sum%10;
	    	pre=temp;
	    	temp=temp.next;	
	    }
	    
	    if(carry>0)
	    	pre.next=new Node(carry);
	    
	    head=reverse(head);
	    
	    return head;
	    
   }
   
   public int middleLL() {
	   Node slow=head;
	   Node fast=head;
	   
	   while(fast!=null && fast.next!=null) {
		   slow=slow.next;
		   fast=fast.next.next;
	   }
	   
	   return slow.data;
   }
	
}
public class BasicsLL {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LinkedList l=new LinkedList();
//		System.out.println("Enter n:");
//		int n=sc.nextInt();
//		int i=0;
//		while(i<n) {
//			int x=sc.nextInt();
//			l.insert(x);
//			i++;
//		}
		
		Node head=new Node(10);
		head.next=new Node(20);
		head.next.next=new Node(30);
		head.next.next.next=new Node(40);
		//head.next.next.next.next=head.next;
		
		int n=2;
		
		Node temp=l.removeEndll(head,n);
		
		while(temp!=null) {
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
		
		//System.out.println(l.detectLoop(head));
		l.print();
		
        // l.reverse();
        // l.print();
	}

	
}
