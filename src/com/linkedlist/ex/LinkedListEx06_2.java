package com.linkedlist.ex;


//어떤 숫자의 자리수 별로 한개씩 LinkedList에 담았다. 1의 자리가 헤더에 오도록 거꾸로 담고
//같은 식으로 2개의 LinkedList를 받아서 합산하고 LinkedList에 담아서 반환하라
//(
class Storage {
	int carry =0;
	Node result = null;
}
public class LinkedListEx06_2 {

	private static class LinkedList {
		Node header;
		
		private static class Node {
			int data;
			Node next = null;
			
			
		}
		
		LinkedList() {
			header = new Node();
		}
		
		void append(int d) {
			Node end = new Node();
			end.data = d;
			Node n = header;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		void retrieve() {
			Node n = header.next;
			
			while(n.next != null) {
				System.out.print(n.data + "->");
				n = n.next;
			}
			System.out.println(n.data);
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
		
		public static void main(String[] args) {
			LinkedList l1 = new LinkedList();
			LinkedList l2 = new LinkedList();
			
			//l1 = 543
			l1.append(3);
			l1.append(4);
			l1.append(5);
			//l2 = 876
			l2.append(6);
			l2.append(7);
			l2.append(8);
			
			l1.retrieve();
			l2.retrieve();
			
			Node n = sumLists(l1.get(1), l2.get(1), 0);
			while(n.next != null) {
				System.out.print(n.data+"->");
				n = n.next;
			}
			System.out.println(n.data);
		}
		
		private static Node sumLists(Node l1, Node l2) {
			int len1 = getListLength(l1);
			int len2 = getListLength(l2);
			
			if(len1 < len2) {
				l1 = LPadList(l2, len2 - len1);
			} else {
				l2 = LPadList(l2, len1 - len2);
			}
			
			Storage storage = addLists(l1, l2);
			
			if(storage.carry == 0) {
				return storage.result;
			} else {
				storage.result = insertBefore(storage.result, storage.carry);
			}
			return storage.result;
		}
		
		
		
		private static Storage addLists(Node l1, Node l2) {
			if(l1 == null && l2 == null) {
				Storage storage = new Storage();
				return storage;
			}
			Storage storage = addLists(l1.next, l2.next);
			int value = storage.carry + l1.data + l2.data;
			int data = value % 10;
			storage.result = insertBefore(storage.result, data);
			storage.carry = value / 10;
			return storage;
		}

		private static int getListLength(Node l) {
			int total = 0;
			while(l != null) {
				total++;
				l = l.next;
			}
			return total;
		}
		
		private static Node insertBefore (Node result, int data) {
			Node before = new Node(data);
			if(result != null) {
				before.next = result;
			}
			return before;
		}
		
		private static Node LPadList(Node l, int length) {
			Node head = l;
			for (int i = 0; i < length; i++) {
				head = insertBefore(head, 0);
			}
			return head;
		}
		
	}
}
