package com.linkedlist.ex;


//LinkedList에 있는 노드들을 x값을 기준으로 값이 작은 것들은 왼쪽, 큰것들은 오른쪽, 두 파트로 나누시오
//단, x는 오른쪽 파트 어디에 놔도 상관없음
//방법2-포인터 2개로 앞뒤로 붙이기

public class LinkedListEx05_2 {
	
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
		
		//head와 tail이 처음에는 첫n을 가리키고 x보다 작으면 n이 head의 앞으로 x보다 크거나 같으면 tail 다음으로 오게 정렬
		private static Node Partition(Node n, int x) {
			Node head = n;
			Node tail = n;
			
			while(n != null) {
				Node next = n.next;
				
				if(n.data < x) {
					n.next = head;
					head = n;
				} else {
					tail.next = n;
					tail = n;
				}
				n = next;
			}
			tail.next = null;
			
			return head;
			
			
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
