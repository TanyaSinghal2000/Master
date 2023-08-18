import java.util.Iterator;

public class MyStack {
    private MyNode top;
    private int size;

    MyStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(int data) {
        MyNode myNode = new MyNode(data);
        myNode.setNext(top);
        top = myNode;
        size++;
    }

    public int pop() {
        if (top == null)
            return -1;
        MyNode myNode = top;
        top = top.getNext();
        size--;
        return myNode.getData();
    }

    public int peek() {
        if (top == null)
            return -1;
        return top.getData();
    }

    public boolean contains(int data) {
        boolean res = false;
        MyNode myNode = top;
        while (myNode != null) {
            if (myNode.getData() == data) {
                res = true;
                break;
            }
            myNode = myNode.getNext();
        }
        return res;
    }

    public int size() {
        return size;
    }

    public int center() {
        if (top == null)
            return -1;
        MyNode slow = top;
        MyNode fast = top;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }

    public void sort() {
        MyStack tmpStack = new MyStack();

        while (size() != 0) {
            int tmp = pop();

            while ((tmpStack.size() != 0) && tmpStack.peek() > tmp) {
                push(tmpStack.pop());
            }

            tmpStack.push(tmp);
        }
        top = tmpStack.top;
        size = tmpStack.size;
    }

    public void reverse() {
        MyStack tmpStack = new MyStack();

        while (size() != 0) {
            int tmp = pop();
            tmpStack.push(tmp);
        }
        top = tmpStack.top;
        size = tmpStack.size;
    }

    public Iterator iterator() {
        return new Iterator() {
            MyNode myNode = top;

            public boolean hasNext() {
                return myNode != null;
            }

            public Integer next() {
                if (myNode == null)
                    return -1;
                int data = myNode.getData();
                myNode = myNode.getNext();
                return data;
            }
        };
    }

    public void print() {
        MyNode myNode = top;
        while (myNode != null) {
            System.out.print(myNode.getData() + " ");
            myNode = myNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(16);
        myStack.push(34);
        myStack.print();
        myStack.push(9);
        myStack.print();
        myStack.push(11);
        myStack.push(4);
        myStack.print();
        System.out.println(myStack.center());
        System.out.println(myStack.size());
        myStack.sort();
        myStack.print();
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        myStack.reverse();
        myStack.print();
        Iterator itr = myStack.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

class MyNode {
    private int data;
    private MyNode next;

    MyNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
