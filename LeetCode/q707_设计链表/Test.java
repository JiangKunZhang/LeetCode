package q707_设计链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/7 23:25
 */
public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(2,9);
        //System.out.println(myLinkedList.get(3));
        myLinkedList.display();
        myLinkedList.deleteAtIndex(0);
        myLinkedList.display();
        myLinkedList.deleteAtIndex(3);
        myLinkedList.display();
    }
}
