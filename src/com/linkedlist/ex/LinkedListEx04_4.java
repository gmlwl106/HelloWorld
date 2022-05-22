package com.linkedlist.ex;

//단방향 LinkedList의 끝에서 k번째의 노드를 찾는 알고리즘
//방법3-포인터

public class LinkedListEx04_4 {
	
	private static class Node {
		int data;
		Node next = null;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		
		ll.retrieve();
		
		int k = 3;
		Node found = kthToLast(ll.header, k);

		System.out.println("Last k(" + k + ")th data is " + found.data);
		
	}
	//p1는 k에서 시작하고 p2는 시작지점에서 시작
	//p1이 끝까지(null) 가면 p2는 k지점에 도착
	private static Node kthToLast(Node first, int k) {
		Node p1 = first;
		Node p2 = first;
		
		for(int i=0; i<k; i++) {
			if(p1 == null) return null;
			p1 = p1.next;
		}
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
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


