package firstLinkedList;

import firstLinkedList.exception.LinkedListNullPointerException;
import firstLinkedList.exception.LinkedListOutOfBoundException;

public class MyLinkedList<T> {

    Node<T> node=null;

//    Add Section
//    Add From First
    public void addFirst(T data) {
        if(node == null) {
            this.node = new Node<>(data);
        }
        else {
            Node<T> newNode = new Node<>(data);
            newNode.next = this.node;
            node = newNode;
        }
    }

//    Add From Last
    public void add(T data) {

        if(this.node == null) {
            this.node = new Node<>(data);
        }
        else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = node;

            while(current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

    }

//    Add From Any index
    public void addAnyIndex(T data, int index) {

        if(this.node == null && index == 0) {
            this.node = new Node<>(data);
        }
        else {
            int i = 1;
            Node<T> current = node;

            while(current.next != null && i < index) {
                current = current.next;
                i++;
            }

            if(current.next == null && i != index) {
                throw new LinkedListOutOfBoundException(i);
            }

            Node<T> newNode = new Node<>(data);

            newNode.next = current.next;
            current.next = newNode;
        }
    }

//    Remove Section
//    Remove
    public T remove(int index) {
        if(node == null || (size() < index)) {
            throw new LinkedListNullPointerException();
        }
        else {
            T data = null;
            if(index == 0) {
                if(this.node.next == null) {
                    data = node.data;
                    node = null;
                    return data;
                }
                else {
                    Node<T> store = node.next;
                    data = node.data;
                    node = null;
                    node = store;
                    return data;
                }
            }
            else if(index == 1) {
                if(node.next != null) {
                    if(node.next.next != null) {
                        Node<T> store = node.next;
                        data = store.data;
                        node.next = node.next.next;
                        return data;
                    }
                    else {
                        data = (T) node.next.data;
                        node.next = null;
                        return data;
                    }
                }
                else {
                    return null;
                }
            }
            int i = 1;
            Node<T> current = node;
            current = current.next;
            while (current.next.next != null && i<index-1) {
                current = current.next;
                i++;
            }
            if(current.next.next == null) {
                data = (T) current.next.data;
                current.next = null;
                return data;
            }
            else {
                data = (T) current.next.data;
                current.next = current.next.next;
                return data;
            }

        }
    }

//    Remove First
    T removeFirst() {
        if(node == null) {
            throw new LinkedListNullPointerException();
        }
        T data = node.data;
        node = node.next;
        return data;
    }
    
//    Remove Last
    T removeLast() {
        if(node == null) {
            throw new LinkedListNullPointerException();
        }
        Node<T> current = node;
        T data;
        if(node.next == null) {
            data = node.data;
            node = null;
            return data;
        }
        while(current.next.next != null) {
            current = current.next;
        }
        data = current.data;
        current.next = null;
        return data;
    }

//    Contains
    int contains(T data) {
        Node<T> current = node;
        int index = 0;
        while(current != null) {
            if(current.data.equals(data)) return index;
            index++;
            current = current.next;
        }
        return -1;
    }

//    Is Present
    Boolean isPresent(T data) {
        Node<T> current = node;
        while (current != null) {
            if(current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

//    Size
    int size() {
        Node<T> current = this.node;
        int i = 0;
        while (current != null) {
            current = current.next;
            i++;
        }
        return i;
    }

//   Print Section
//   Print with other node
    void print(Node node) {
        Node<T> current = node;

        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }

//   Print
    void print() {
        Node<T> current = this.node;

        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }

//    ToString
    @Override
    public String toString() {
        String str = "MyLinkedList[";
        Node<T> current = this.node;
        while(current != null) {
            str += current.data;
            if(current.next != null) {
                str += ",";
            }
            current = current.next;
        }
        return str + "]";
    }
}

//  Node Class
class Node <T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

}