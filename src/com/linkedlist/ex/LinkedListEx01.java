package com.linkedlist.ex;


public class LinkedListEx01 {

	static class Node {
		int data;
		Node next = null;
		
		Node (int d) {
			this.data = d;
		}
		
		
		//node 추가
		public void append(int d) {
			Node end = new Node(d);
			Node n = this; //head
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		//node 삭제 ->첫번째 노드는 삭제되지 않는 코드
		public void delete(int d) {
			Node n = this; //head
			while(n.next != null) {
				if(n.next.data == d) {
					n.next = n.next.next;
				} else {
					n = n.next;
				}
			}
		}
		
		//현재 노드들을 출력
		void retrieve() {
			Node n = this;
			while(n.next != null) {
				System.out.print(n.data+"->");
				n=n.next;
			}
			
			System.out.println(n.data);
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		
		head.retrieve();
		
		head.delete(2);
		
		head.retrieve();
		
	}

	
	
}


