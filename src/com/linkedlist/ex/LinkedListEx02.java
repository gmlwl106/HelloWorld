package com.linkedlist.ex;

//LinkedList의 Node header를 만들어서
//첫번째 노드가 삭제되지 않는 문제를 해결
public class LinkedListEx02 {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		
		ll.retrieve();
		
		ll.delete(1);
		
		ll.retrieve();
	}
	
}

class LinkedList {
	Node header;
	
	static class Node {
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
}