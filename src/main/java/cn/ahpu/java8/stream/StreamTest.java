package cn.ahpu.java8.stream;

import cn.ahpu.java8.entity.Student;
import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        //不定参数还是数组 也可直接使用数组
        Integer[] ins = {3, 2, 2, 3, 7, 3, 5};
        List<Integer> numbers = Arrays.asList(ins);//参数也可以 3, 2, 2, 3, 7, 3, 5
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//        List<Integer> squaresList = numbers.stream()
//                .map(i -> i * i)
//                .sorted((x, y) -> y - x)
//                .collect(Collectors.toList());
//        squaresList.forEach(System.out::println);
//            num++;
        squaresList.forEach(System.out::println);

        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
        Map<Integer, String> strMap = new HashMap<Integer, String>();

        strMap = strList.stream()
                .collect(Collectors.toMap(strList::indexOf, str -> str));

        strMap.forEach((key, value) -> {
            System.out.println(key + "::" + value);
        });
    }

    //创建流四种
    @Test
    public void test05() {
        ArrayList<Student> list = new ArrayList<>();
        Stream<Student> stream1 = list.stream();

        Student[] stuArray = new Student[3];
        Stream<Student> Stream2 = Arrays.stream(stuArray);

        Stream<Student> stream3 = Stream.of(new Student("小三", 3));//底层Arrays.stream(values)

        BiFunction<String, Integer, Student> biFunction = Student::new;//方法引用 省去了参数
        Student stu = null;
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 1);
        stream4.limit(20).forEach(x -> System.out.print(x + " "));

        Stream.generate(Math::random).limit(20).forEach(x -> System.out.println(x + " "));
    }

    /**
     * Stream流操作 filter limit skip  distinct
     * 筛选与切片 filter过滤 skip跳过 limit限数 distinct去重
     * map flatmap对流的处理
     * map对每个流单独处理 flatmap对获取的流进行整合
     * add addAll添加元素 集合
     */
    @Test
    public void test06() {
        List<String> asList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        asList.stream().map(StreamTest::filterCharacter).forEach(x -> x.forEach(y -> System.out.print(y + " ")));
        System.out.println();
        System.out.println("---------------------------");
        asList.stream().flatMap(StreamTest::filterCharacter).forEach(x -> System.out.print(x + " "));
    }

    public static Stream<Character> filterCharacter(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 查找与匹配
     * allMatch 匹配所有元素 true
     * anyMatch 匹配至少一个元素 true
     * noneMatch 没有匹配元素 true
     * count 流中元素的总个数
     * <p>
     * 会返回Optional类型对象 极大程度减少 NullPointerException
     * findFirst 返回第一个元素
     * findAny 返回流中任意元素
     * max流中最大值
     * min流中最小值
     */
    @Test
    public void test07() {
        ArrayList<Student> list = Util.MyListStudents();
        System.out.println(list.stream().allMatch(x -> "Amy".equals(x.getName())));//全部匹配返回true
        System.out.println(list.stream().anyMatch(x -> "李旺".equals(x.getName())));//存在匹配元素返回true
        System.out.println(list.stream().noneMatch(x -> "李旺".equals(x.getName())));//没有匹配到元素返回true

        Optional<Student> first = list.stream().findFirst();
        Student student = first.get();
        System.out.println(first);
        System.out.println(student);

        System.out.println(list.stream().findAny());
        System.out.println((long) list.size());
        //max 选择条件：年龄最大 薪资最大
        System.out.println(list.stream().max((x, y) -> (x.getAge() == y.getAge()) ? (int) (x.getSalary() - y.getSalary()) : (x.getAge() - y.getAge())));//多个比较条件相同时 返回第一个
        System.out.println(list.stream().min((x, y) -> (x.getAge() == y.getAge()) ? (int) -(x.getSalary() - y.getSalary()) : -(x.getAge() - y.getAge())));//多个比较条件相同时 返回第一个

        "de".length();
    }

    /**
     * reduce(T identity,BinaryOperator<T> accumulator) 可以将流中元素反复结合起来，汇总得到一个值
     * Optional 尽量减少NullPointerException
     */
    @Test
    public void test08() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        String s = list.stream().reduce("666", (x, y) -> x + y);//有起始值“666” 不返回Optional
        System.out.println(s);
        Optional<String> op = list.stream().reduce((x, y) -> x + y);
        System.out.println(op.get());
        Optional<String> op1 = list.stream().filter("a"::equalsIgnoreCase).reduce((x, y) -> x + y);//无起始值不返回Optional
        System.out.println(op1);
    }

    /**
     * collect 收集-将流转换成其他形式 接收一个Collector接口的实现 用于给Stream中元素做汇总操作
     * 收集成特定类型集合 平均值 总和 平均值 最大值 最小值
     * 分组
     */
    @Test
    public void test09() {
        ArrayList<Student> list = Util.MyListStudents();
        Set<String> set = list.stream().map(Student::getName).collect(Collectors.toSet());
        System.out.println(set);

        list.stream().map(Student::getName).collect(Collectors.toCollection(HashSet::new));//自定义指定集合收集元素 相当于实现Supplier<C> 接口方法C get()

        //求个数
        Long count = list.stream().count();//三种写法
        int count1 = list.size();
        Long count2 = list.stream().collect(Collectors.counting());

        //求和
        double sumSalary = list.stream().mapToDouble(Student::getSalary).sum();
        double sumSalary1 = list.stream().collect(Collectors.summingDouble(Student::getSalary));

        //求平均值
        Double avgSalary = list.stream().collect(Collectors.averagingDouble(Student::getSalary));


        //求最大值
        Optional<Student> maxSalary = list.stream().max((x, y) -> (int) (x.getSalary() - y.getSalary()));// 先map出Salary Student：：getSalary再 Double::compare
        Optional<Student> maxSalary1 = list.stream().collect(Collectors.maxBy((x, y) -> (int) (x.getSalary() - y.getSalary())));
        double maxSalary2=list.stream().map(Student::getSalary).max(Double::compare).get();


        //求最小值
        Optional<Student> minSalary = list.stream().min((x, y) -> (int) (x.getSalary() - y.getSalary()));
        Optional<Student> minSalary2 = list.stream().collect(Collectors.minBy((x, y) -> (int) (x.getSalary() - y.getSalary())));

        //更方便获取以上值
        DoubleSummaryStatistics collect = list.stream()
                .collect(Collectors.summarizingDouble(Student::getSalary));
        System.out.println("collect-max:" + collect.getMax());
        System.out.println("collect-min:" + collect.getMin());
        System.out.println("collect-average:" + collect.getAverage());

        //连接
        String collect1 = list.stream().map(Student::getName).distinct().collect(Collectors.joining(","));
        System.out.println("连接：" + collect1);

        //分组
        Map<Student.Status, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getStatus));//x->x.getStatus()
        System.out.println(map);

        //多级分组
        Map<Student.Status, Map<String, List<Student>>> map1 = list.stream().collect(Collectors.groupingBy(Student::getStatus, Collectors.groupingBy(x -> {
            if (x.getSalary() < 750) {
                return "贫困户";
            } else if (x.getSalary() < 1150) {
                return "中等户";
            } else if (x.getSalary() >= 1200) {
                return "富裕户";
            }
            return "其他";
        })));
        System.out.println(map1);
        //多级分组结果
        /**
         * {
         * 	BUSY = {
         * 		贫困户 = [Student(name = 1, age = 23, salary = 500.0, status = BUSY), Student(name = 2, age = 21, salary = 600.0, status = BUSY)],
         * 		中等户 = [Student(name = Tom, age = 22, salary = 800.0, status = BUSY)]
         *        },
         * 	FREE = {
         * 		富裕户 = [Student(name = 李旺, age = 23, salary = 1200.0, status = FREE)],
         * 		贫困户 = [Student(name = 2, age = 22, salary = 700.0, status = FREE)],
         * 		中等户 = [Student(name = Andy, age = 21, salary = 900.0, status = FREE), Student(name = Amy, age = 23, salary = 1000.0, status = FREE)]
         *    },
         * 	VOCATION = {
         * 		富裕户 = [Student(name = 祁仪, age = 21, salary = 1300.0, status = VOCATION), Student(name = 杜华森, age = 21, salary = 1400.0, status = VOCATION)],
         * 		中等户 = [Student(name = Amy, age = 22, salary = 1100.0, status = VOCATION)]
         *    }
         * }
         */

        //分区(满足条件的分为一个区)
        Map<Boolean, List<Student>> map2 = list.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 1000));
        System.out.println(map2);//分为两个区 true false区
        /**
         * {
         * 	false = [Student(name = 1, age = 23, salary = 500.0, status = BUSY),
         * 			Student(name = 2, age = 21, salary = 600.0, status = BUSY),
         * 			Student(name = 2, age = 22, salary = 700.0, status = FREE),
         * 			Student(name = Tom, age = 22, salary = 800.0, status = BUSY),
         * 			Student(name = Andy, age = 21, salary = 900.0, status = FREE),
         * 			Student(name = Amy, age = 23, salary = 1000.0, status = FREE)],
         * 	true = [Student(name = Amy, age = 22, salary = 1100.0, status = VOCATION),
         *             Student(name = 李旺, age = 23, salary = 1200.0, status = FREE),
         *             Student(name = 祁仪, age = 21, salary = 1300.0, status = VOCATION),
         *             Student(name = 杜华森, age = 21, salary = 1400.0, status = VOCATION)]
         * }
         */

    }

    /**
     * Stream API的一些练习
     */
    @Test
    public void test10() {
//        1.给定一个数字列表 返回由每一个数的平方构成的列表 map
        Stream.of(1, 2, 3, 4, 5).map(x -> x * x).forEach(x -> System.out.print(x + " "));
        //2.使用map reduce方法数一数流中有多少个元素
        ArrayList<Student> list = Util.MyListStudents();
        Integer count = list.stream().map(x -> 1).reduce(0, Integer::sum);
        System.out.println("map-count:" + count);
        //3.2011年发生的所有交易 并按交易额排序(从低到高
        List<Transaction> list0 = Util.myTrans();
        Stream<Transaction> stream1 = list0.stream().filter(x -> x.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue));

        stream1.forEach(x -> System.out.print(x + " "));
        System.out.println();
        //4.交易员都在那些不同城市工作过?
        Stream<String> stream2 = list0.stream().map(x -> x.getTrader().getCity()).distinct();
        System.out.print("4:");
        stream2.forEach(x-> System.out.print(x+" "));
        System.out.println();
        //5.查找所有来自剑桥的交易员 并按姓名排序
        Stream<Trader> stream3 = list0.stream().map(Transaction::getTrader).filter(x -> x.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName));
        stream3.forEach(x -> System.out.println(x + " "));
        System.out.println();
        //6.返回所有交易员的姓名字符串 ,按字母顺序排序
        Stream<String> stream4 = list0.stream().map(Transaction::getTrader).map(Trader::getName).sorted(String::compareTo);
        stream4.forEach(x -> System.out.print(x + " "));
        System.out.println();
        //7.有没有交易员在米兰工作的
        Stream<Transaction> stream5 = list0.stream().filter(x -> "Milan".equals(x.getTrader().getName()));//
        System.out.println("7:" + stream5);
        System.out.println();
        //8.打印生活在剑桥的交易员的所有交易额
        DoubleStream sum = list0.stream().filter(x -> "Cambridge".equals(x.getTrader().getCity())).mapToDouble(Transaction::getValue);//Integer::sum
        Double sum1 = list0.stream().filter(x -> "Cambridge".equals(x.getTrader().getCity())).collect(Collectors.summingDouble(Transaction::getValue));
        System.out.println("8:" + sum.sum() + " " + sum1);
        System.out.println();
        //9.所有交易中,最高的交易额是多少
        Stream<Transaction> stream6 = list0.stream().sorted((x, y) -> (x.getValue() - y.getValue()));//Integer.compare(x,y)
        Stream<Transaction> stream7 = stream6.limit(1);
        Optional<Transaction> op = stream7.findFirst();
        if (op != null) {
            System.out.println("9:" + op.get());
        } else {
            System.out.println("9:op为null");
        }

    }

    @Test
    public void test11(){
        Integer i1 = Integer.valueOf("A", 16);
        System.out.println(i1);
    }


    @Test
    public void test01() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(x -> System.out.print(x + " "));
        System.out.println();
        String s = filtered.stream().collect(Collectors.joining("/", "[", "]"));
        System.out.println(s);
        Set<String> set = filtered.stream().collect(Collectors.toSet());//等价于new HashSet<>(filtered)
        System.out.println(set);
        Map<String, String> map = filtered.stream().distinct().collect(Collectors.toMap(k -> "key" + k, v -> "value" + v));//java.lang.IllegalStateException: Duplicate key valuejkl
        System.out.println(map);
    }

    @Test
    public void test02() {
        Random random = new Random();
        random.ints(10).sorted().forEach(x -> System.out.print(x + " "));
    }

    @Test
    public void test03() {
        Random random = new Random(20);
        for (int i = 1; i <= 100; i++) {
            System.out.print(random.nextInt(10) + " ");
        }
    }

    /**
     *
     */
    @Test
    public void test04() {
        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
        Map<Integer, String> strMap = new HashMap<Integer, String>();
        strMap = strList.stream()
                .collect(Collectors.toMap(strList::indexOf, str -> str));//str -> strList.indexOf(str) 对集合中每一个元素进行去下标索引
        strMap.forEach((key, value) -> {
            System.out.println(key + "::" + value);
        });
    }

}


