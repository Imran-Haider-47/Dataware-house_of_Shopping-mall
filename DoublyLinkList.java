
package Dataware;

//A complete working Java program to demonstrate all

//Class for Doubly Linked List
public class DoublyLinkList {
	Node head; // head of list

	/* Doubly Linked list Node*/
	class Node {
		String data;
		Node prev;
		Node next;

		// Constructor to create a new node
		// next and prev is by default initialized as null
		Node(String d) { data = d; }
	}

	// Adding a node at the front of the list
	public void push(String new_data)
	{
		/* 1. allocate node 
		* 2. put in the data */
		Node new_Node = new Node(new_data);

		/* 3. Make next of new node as head and previous as NULL */
		new_Node.next = head;
		new_Node.prev = null;

		/* 4. change prev of head node to new node */
		if (head != null)
			head.prev = new_Node;
		
		/* 5. move the head to point to the new node */
		head = new_Node;
	}



	// Add a node at the end of the list
	public String Get_Last()
	{
		
	
		// set last node equal to head and then traverse the last node
		Node last = head;
		
		//travese till the end
		while(last.next!=null)
		{
			last=last.next;
		}
		
		String Last=last.data; // Return the data at the last node
		return Last;

	}
	
	 void deleteNode(Node head_ref, Node del) 
	    { 
	  
	        // Base case 
	        if (head == null || del == null) { 
	            return; 
	        } 
	  
	        // If node to be deleted is head node 
	        if (head == del) { 
	            head = del.next; 
	        } 
	  
	        // Change next only if node to be deleted 
	        // is NOT the last node 
	        if (del.next != null) { 
	            del.next.prev = del.prev; 
	        } 
	  
	        // Change prev only if node to be deleted 
	        // is NOT the first node 
	        if (del.prev != null) { 
	            del.prev.next = del.next; 
	        } 
	  
	        // Finally, free the memory occupied by del 
	        return; 
	    } 
	

	// This function prints contents of linked list starting from the given node
	public void printLinkedlist()
	{
		Node current =head;
		
		while(current!=null)
		{
			if(current.next==null)
			{
				System.out.println(current.data);
				break;
			}
			System.out.print(current.data+"--> ");
			current=current.next;
		}
		System.out.println();
	}


}


///* Driver program to test above functions*/
//public static void main(String[] args)
//{
//
//	DoublyLinkList DLL = new DoublyLinkList();
//
//	DLL.push(6);
//	
//
//	DLL.push(7);
//
//
//	DLL.push(1);
//
//	DLL.push(5);
//
//	System.out.println("Product id at the last is : "+DLL.Get_Last());
//	DLL.printLinkedlist();
//	
//	int id =5;
//	Node current=DLL.head;
//	while(current.data!=id)
//	{
//		current=current.next;
//	}
//	
//	DLL.deleteNode(DLL.head, current ); 
//	
//	DLL.printLinkedlist();	
//}



