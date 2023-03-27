package firstLinkedList.exception;

public class LinkedListOutOfBoundException extends RuntimeException{
    public LinkedListOutOfBoundException() {
        super("Index Out Of Bound Exception!");
    }

    public LinkedListOutOfBoundException(int linkedListIndex) {
        super("index of " +linkedListIndex+" out of bound "+linkedListIndex);
    }

}
