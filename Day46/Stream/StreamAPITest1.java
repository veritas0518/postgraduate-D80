package Day46.Stream;

import Day45.exercise1.Person;
import Day46.Reference.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: StreamAPITest1
 * @Description: 测试Stream的中间操作
 * @Author: TianXing.Xue
 * @Date: 2021/8/11 17:03
 **/

public class StreamAPITest1 {

    //1.筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();

        //从流中排除某些元素
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        //截断流，使其元素不超过给定数量
        //需要新生成一个新的
        list.stream().limit(3).forEach(System.out::println);

        //跳过元素，返回一个扔到了前n个元素的流。若流中元素不足n个，则返回一个空流
        list.stream().skip(3).forEach(System.out::println);

        //筛选，通过流所生成元素的hashCode()和equals() 去除重复元素
        list.add(new Employee(1010, "刘强东", 40, 10000));
        //System.out.println(list);

        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){

        //映射
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);

        //练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name->name.length()>3).forEach(System.out::println);
        System.out.println();

        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s->{
            s.forEach(System.out::println);
        });

        //flatMap():将流中的每个值都转换成另一个流，然后把所有流里的元素都
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.add(list2);
        System.out.println(list1);
        list1.addAll(list2);
        System.out.println(list1);
    }

    //3.排序
    @Test
    public void test4(){
        //sorted()--自然排序
        List<Integer> list = Arrays.asList(1, 34, 4353, 236, 23476, 22, -65, 0);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
    }
}
