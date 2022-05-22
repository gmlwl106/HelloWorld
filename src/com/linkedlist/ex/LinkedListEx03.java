package com.linkedlist.ex;


public class LinkedListEx03 {
	
	private static class LinkedList {
		Node header;
		
		private static class Node {
			int data;
			Node next = null;
		}
		
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
		
		//포인터를 이용해서 중복값 삭제
		//r이 움직이면서 중복값이 있는지 확인한다
		void removeDups() {
			Node n = header;
			while(n.next != null) {
				Node r = n;
				while(n != null && r.next != null) {
					if(n.data == r.next.data) {
						r.next = r.next.next;
					} else {
						r = r.next;
					}
				}
				
				n = n.next;
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(6);
		ll.append(4);
		ll.append(1);
		ll.append(9);
		
		
		ll.retrieve();
		
		ll.removeDups();
		
		ll.retrieve();
	}
	
}



