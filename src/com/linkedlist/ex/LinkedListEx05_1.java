package com.linkedlist.ex;


//LinkedList에 있는 노드들을 x값을 기준으로 값이 작은 것들은 왼쪽, 큰것들은 오른쪽, 두 파트로 나누시오
//단, x는 오른쪽 파트 어디에 놔도 상관없음
//방법1 -4개의 포인터를 이용해서 큰 숫자와 작은 숫자를 나누고 마지막에 합친다.

public class LinkedListEx05_1 {
	
	private static class Node {
		int data;
		Node next = null;
	}
	
	private static class LinkedList {
		Node header;
		
		private static class Node {
			int data;
			Node next = null;
		}
		
		LinkedList() {
			header = new Node();
		}
		
		
		//Node 추가
		void append(int d) {
			Node end = new Node();
			end.data = d;
			Node n = header;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		Node get(int d) {
			Node n = header;
			int count = 0;
			while(count < d) {
				n = n.next;
				count++;
			}
			
			return n;
		}

		
		//Node 출력
		void retrieve() {
			Node n = header.next; //시작노드
			while(n.next != null) {
				System.out.print(n.data+"->");
				n=n.next;
			}
			
			System.out.println(n.data);
		}
		
		private static Node Partition(Node n, int x) {
			Node s1 = null;
			Node e1 = null;
			Node s2 = null;
			Node e2 = null;
			
			
			
			
			while(n != null) {
				Node next = n.next;
				n.next = null;

				if(n.data < x) {
					if(s1 == null) {
						s1 = n;
						
						e1 = s1;
					} else {
						e1.next = n; // e1의 다음 주소값으로 n을 갖게 하고
						e1 = n; // e1도 n 노드의 위치로 이동한다
					}
				} else {
					if(s2 == null) {
						s2 = n;
						e2 = s2;
					} else {
						e2.next = n;
						e2 = n;
					}
				}
				n = next;
			}
			
			if(s1 == null) {
				return s2;
			}
			
			e1.next = s2;
			return s1;
			
		}
		
		public static void main(String[] args) {
			LinkedList ll = new LinkedList();
			ll.append(8);
			ll.append(5);
			ll.append(2);
			ll.append(7);
			ll.append(3);
			ll.append(4);
			ll.retrieve();
			
			Node n = Partition(ll.get(1), 5);
			while(n.next != null) {
				System.out.print (n.data + "->");
				n = n.next;
			}
			System.out.println(n.data);
			

		}
		
	}
}
