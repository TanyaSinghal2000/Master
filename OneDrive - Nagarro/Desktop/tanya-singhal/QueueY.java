public class QueueY {
        static class Node {
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next = null;
        }
        public int getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
    }
    static class Queue {
            static Node head = null;
            static Node tail = null;

        public static boolean isEmpty(){
            return head == null & tail == null;

        }
        public static void add(int data){
            Node newNode = new Node(data);
            if (tail == null) {
                tail = head = newNode;
                return;
            }
            tail.next= newNode;
            tail = newNode;
        }


        //dequeue
        public int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;
            if (head == tail) {
                tail = null;
            }
            head = head.next;
            return front;
        }

        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
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

                prev = currentNode;
                currentNode = nextNode;
            }
            head.next =null;
            head = prev;
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
        public void print(){
            Node newNode = head;
            while(newNode != null){
                System.out.println(newNode.getData()+" ");
                 newNode = newNode.getNext();
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Queue q=new Queue();
            boolean n;
            int data;
            q.add(10);
            q.add(3);
            q.add(90);
            q.add(40);
            q.add(56);
            q.print();
            q.remove();
            q.print();
            q.reverse();
            n=Queue.contain(40);
            System.out.println("contains: "+ n);
            data = Queue.size();
            System.out.println("Size: "+ data);
            q.sortList();
            q.print();
            }
        }
    }

