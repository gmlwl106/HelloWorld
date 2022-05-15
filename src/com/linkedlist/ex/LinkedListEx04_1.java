package com.linkedlist.ex;

//단방향 LinkedList의 끝에서 k번째의 노드를 찾는 알고리즘
//방법1

public class LinkedListEx04_1 {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		
		ll.retrieve();
		
		int k = 3;
		Node kth = kthToLast(ll.header, k);
		System.out.println("Last k(" + k + ")th data is " + kth.data);
	}

	private static Node kthToLast(Node first, int k) {
		Node n = first;
		int total = 1;
		
		while(n.next != null) {
			total++;
			n = n.next;
		}
		n = first;
		
		for(int i = 1; i < total-k+1; i++) {
			n = n.next;
		}
		
		return n;
	}
	

	static class LinkedList {
		Node header;
		
		LinkedList() {
			header = new Node();
		}

		//node 추가
		public void append(int d) {
			Node end = new Node();
			end.data = d;
			Node n = header; //시작노드
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		//node 삭제 ->첫번째 노드는 삭제되지 않는 코드
		public void delete(int d) {
			Node n = header; //시작노드
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
			Node n = header.next; //시작노드
			while(n.next != null) {
				System.out.print(n.data+"->");
				n=n.next;
			}
			
			System.out.println(n.data);
		}
	}
}


