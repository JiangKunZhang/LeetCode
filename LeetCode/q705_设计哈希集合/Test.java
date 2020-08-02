package q705_设计哈希集合;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 22:50
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));

    }
}
