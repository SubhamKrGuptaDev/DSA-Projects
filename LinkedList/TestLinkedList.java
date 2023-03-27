package firstLinkedList;

public class TestLinkedList {

    public static void main(String[] args) {

        MyLinkedList<String> myLinked = new MyLinkedList<>();

        myLinked.add("subham");
        myLinked.add("gupta");
        myLinked.add("sathi");
        myLinked.add("bera");
        System.out.println(myLinked);

        myLinked.removeLast();
        System.out.println(myLinked);
        myLinked.removeFirst();

        System.out.println(myLinked);

        myLinked.remove(1);
        System.out.println(myLinked);
        System.out.println(myLinked.isPresent("subham"));

        MyLinkedList<Integer> intLinked = new MyLinkedList<>();
        intLinked.add(12);
        intLinked.add(22);
        intLinked.add(32);
        intLinked.add(42);
        intLinked.add(52);

        Boolean present = intLinked.isPresent(32);
        System.out.println(present);

    }

}
