package q690_员工的重要性;

import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/13 16:29
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee:employees) {
            if (employee.id == id) {
                if (employee.subordinates.size() == 0) { //没有子节点
                    return employee.importance;
                }
                for (int subId:employee.subordinates) { //深搜dfs
                    employee.importance += getImportance(employees,subId);
                }
                return employee.importance;
            }
        }
        return 0;
    }
}
