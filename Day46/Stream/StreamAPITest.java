package Day46.Stream;

import Day46.Reference.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName: StreamAPITest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/11 16:37
 *
 *  1.Stream关注的是对数据的运算，与Cpu打交道
 *    集合关注的是数据的存储，与内存打交道
 *
 *  2.
 *  ① Stream 自己不会存储元素。
 *  ② Stream 不会该笔那源对象。相反，他们会返回一个特有结果的新Stream
 *  ③ Stream 操作时延迟执行的。这意味着他们互等到需要结果的时候才执行
 *
 *  3.Stream执行流程
 *  ① Stream的实例化
 *  ② 一系列的中间操作(过滤、映射...)
 *  ③ 终止操作
 *
 *  4.说明
 *      4.1 一个中间操作链，对数据源的数据进行处理
 *      4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 **/

public class StreamAPITest {

    //创建Stream方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5, 6};

        //返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1001, "Jerry");

        Employee[] arr1 = new Employee[]{e1, e2}; //静态初始化

        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream的方式四：无限流
    @Test
    public void test4() {
        //迭代
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
