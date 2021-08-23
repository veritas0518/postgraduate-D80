package Day46.Stream;

import Day46.Reference.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: EmployeeData
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/11 16:44
 **/

public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "马化腾", 31, 7834));
        list.add(new Employee(1002, "刘强东", 89, 4323));
        list.add(new Employee(1002, "马  云", 33, 8658));
        list.add(new Employee(1003, "小马哥", 56, 6656));
        list.add(new Employee(1004, "周杰伦", 35, 9633));
        list.add(new Employee(1005, "张  杰", 21, 7493));
        list.add(new Employee(1006, "柳传志", 18, 7133));

        return list;
    }
}
