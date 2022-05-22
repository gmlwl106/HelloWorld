package com.linkedlist.ex;

//단방향 LinkedList의 끝에서 k번째의 노드를 찾는 알고리즘
//방법2 -재귀호출

public class LinkedListEx04_2 {
	
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
		kthToLast(ll.header, k);
		
	}

	//count와 같은 값을 가지고 있는 노드가 나타날때까지 1씩 증가시키고
	//나오지 않으면 0을 반환
	private static int kthToLast(Node n, int k) {
		if(n == null) {
			return 0;
		}
		
		int count = kthToLast(n.next, k) +1;
		if(count == k) {
			System.out.println("Last k(" + k + ")th data is " + n.data);
		}
		
		return count;
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


