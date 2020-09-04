package q841_钥匙和房间;

import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/31 12:19
 */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] book = new boolean[rooms.size()];
        boolean[] room = new boolean[rooms.size()];
        dfs(rooms, 0, book, room);
        for (boolean canEnter : room) {
            if (canEnter == false) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int id, boolean[] book, boolean[] room) {
        book[id] = true;
        room[id] = true;
        for (int x : rooms.get(id)) {
            if (book[x] == false) {
                dfs(rooms, x, book, room);
            }
        }
    }
}
