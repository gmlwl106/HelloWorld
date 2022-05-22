package com.linkedlist.ex;

//단방향 LinkedList의 끝에서 k번째의 노드를 찾는 알고리즘
//방법2 -재귀호출

public class LinkedListEx04_3 {
	
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
		Referance r = new Referance();
		Node found = kthToLast(ll.header, k, r);
		
		System.out.println("Last k(" + k + ")th data is " + found.data);
		
	}
	
	//count를 클래스에 만들어서 저장하고 노드의 주소값을 전달
	static class Referance {
		int count = 0;
	}
	
	private static Node kthToLast(Node n, int k, Referance r) {
		if(n == null) {
			return null;
		}
		
		Node found = kthToLast(n.next, k, r);
		r.count++;
		if(r.count == k) {
			return n;
		}
		
		return found;
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


