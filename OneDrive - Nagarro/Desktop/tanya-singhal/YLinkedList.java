class Node {

    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;

    }
}
class LinkedList {
    static Node head;
    public static Node insertAtFront(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }


    public static Node insertAtEnd(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
        return head;
    }
public static int size() {
    if(head == null) {
        return 0;
    }
    int count = 0;
    Node node = head;
    while(node != null) {
        count++;
        node = node.next;
    }
    return count;
}

    public static Node insertAtPosition(int position, int data) {
        if (position == 0) {
            head = LinkedList.insertAtFront(data);
        } else if (position >= size()) {
            head = LinkedList.insertAtEnd(data);
        } else {
            Node currentNode = head.next, prev = head;
            int currentIndex = 1;
            while (currentNode != null) {
                if (currentIndex == position) {
                    Node newNode = new Node(data);
                    newNode.next = currentNode;
                    prev.next = newNode;
                }
                prev = currentNode;
                currentNode = currentNode.next;
                currentIndex++;
            }
        }
        return head;
    }

    public static Node deleteFront() {
        if (head == null) {
            return head;
        }
        head = head.next;
        return head;
    }

    public static Node deleteEnd() {
        if (head == null) {
            return head;
        }

        Node currentNode = head;
        Node prev = null;
        while (currentNode.next != null) {
            prev = currentNode;
            currentNode = currentNode.next;
        }
        prev.next = null;

        return head;
    }
    public void sortList()
    {
        Node current = head, index = null;

        int temp;

        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    public static boolean contain(int searchval) {
        if(head == null) {
            return false;
        }
        Node currNode = head;
        while(currNode != null){
            if(currNode.data == searchval) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }
    public static Node center() {
        if(head == null) {
            return head;
        }
        Node slow, fast;
        slow = fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
    public static Node deleteAtPosition(int position, int dataDeleted) {
        if (head == null)
            return head;

        if (head.data == dataDeleted) {
            head = head.next;
        } else {
            Node currentNode = head.next;
            Node prev = null;
            while (currentNode != null) {
                if (currentNode.data == dataDeleted) {
                    prev.next = currentNode.next;
                    break;
                }
                prev = currentNode;
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static void reverse() {
        if(head == null || head.next == null) {
            return;
        }
        Node currentNode = head.next;
        Node prev = head;
        while( currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = prev;

            //update
            prev = currentNode;
            currentNode = nextNode;
        }
        head.next =null;
        head = prev;
    }
    public static Node iterator() {
        Node ptr = head;
        return ptr;
    }

    public static void printList() {
        if(head == null) {
            System.out.println("List is empty");
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("\n");
    }
}
public class YLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int data;
        data = LinkedList.size();
        list.insertAtFront(3);
        list.insertAtFront(5);
        list.insertAtEnd(7);
        list.insertAtFront(10);
        list.insertAtFront(19);
        list.insertAtFront(50);
        list.printList();
        list.reverse();
        list.printList();
        list.deleteAtPosition(0,5);
        list.printList();
        list.deleteFront();
        list.printList();
        list.deleteEnd();
        list.printList();
        list.insertAtPosition(0,100);
        list.printList();
        System.out.println("The size is: "+ data);
        list.sortList();
        list.printList();
    }
}

