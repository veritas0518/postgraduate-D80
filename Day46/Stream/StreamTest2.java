package Day46.Stream;

import Day46.Reference.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: StreamTest2
 * @Description: 测试Stream的终止操作
 * @Author: TianXing.Xue
 * @Date: 2021/8/11 22:51
 **/

public class StreamTest2 {

    //1.匹配与查找
    @Test
    public void test1() {
        //检查是否匹配所有元素
        //练习：是否所有的员工的年龄都大于18岁
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        //检查是否至少匹配一个元素
        //练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        //检查是否没有匹配的元素
        //练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        //返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

        //返回当前流中的任意元素
        Optional<Employee> employee1 = employees.stream().findAny();
        System.out.println(employee1);
    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();

        //返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        //返回流中最大值
        //练习：返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = salaryStream.max(Double::compareTo);
        System.out.println(max);

        //返回流中最小值
        //练习：返回最低工资的员工
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);

        //内部迭代
        employees.stream().forEach(System.out::println);

        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    //2.归约
    @Test
    public void test3(){
        //可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1:计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        //练习2：计算公司中所有员工的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> sumMoney = salaryStream.reduce((d1,d2)->d1+d2);
        System.out.println(sumMoney);
    }

    //3-收集
    @Test
    public void test4(){
        //将流转换为其他形式。接收一个Collector接口的实现
        //练习1：查找工资大于6000的员工，结果返回为一个list或set

        //有序
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());//转化为list

        employeeList.forEach(System.out::println);

        System.out.println();

        //无序
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());//转化为list
        employeeSet.forEach(System.out::println);

    }
}
