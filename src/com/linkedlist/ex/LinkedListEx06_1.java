package com.linkedlist.ex;


//어떤 숫자의 자리수 별로 한개씩 LinkedList에 담았다. 1의 자리가 헤더에 오도록 거꾸로 담고
//같은 식으로 2개의 LinkedList를 받아서 합산하고 LinkedList에 담아서 반환하라
//(
public class LinkedListEx06_1 {

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
		
		private static Node sumLists(Node l1, Node l2, int carry) {
			if(l1 == null && l2 == null && carry == 0) {
				return null;
			}
			
			Node result = new Node();
			
			int value = carry;
			
			if(l1 != null) {
				value += l1.data;
			}
			if(l2 != null) {
				value += l2.data;
			}
			
			result.data = value%10;
			
			if(l1 != null || l2 != null) {
				Node next = sumLists(l1 == null? null : l1.next, //l1이 null이면? null반환:아니면 l1의 다음 노드 반환
									l2 == null? null : l2.next, //l2이 null이면? null반환:아니면 l2의 다음 노드 반환
									value >= 10? 1 : 0); //value의 값이 10 이상이면? carry값을 1로 반환:아니면 0 반환
				result.next = next;
			}
			
			return result;
		}
	}
}
