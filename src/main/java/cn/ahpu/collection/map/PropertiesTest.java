package cn.ahpu.collection.map;

import org.aspectj.weaver.ast.Var;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.*;


@Component
public class PropertiesTest {

    private static  String config="E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\resources\\test.properties";

    public static void main(String[] args) {
        PropertiesTest t = new PropertiesTest();
        t.writeProperties();
    }

    //写 *.properties key-value字符串内容
    public void writeProperties() {
        Properties properties = new Properties();
        OutputStream output = null;
        try {
            URL url = getClass().getClassLoader().getResource("test.properties");
            String path = url.getPath();
//            System.out.println(path);

            output = new FileOutputStream(path);
            properties.setProperty("url", "jdbc:mysql://localhost:3306/");
            properties.setProperty("username", "root");
            properties.setProperty("password", "root");
            properties.setProperty("databases", "music_player");
            //每次执行对文件覆盖
            properties.store(output, "Steven1997 modify " + new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //单元测试方法可以调用其他静态方法和非静态方法
    //静态方法 不能织入切面
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        PropertiesTest propertiesTest = (PropertiesTest)ac.getBean("propertiesTest");
        propertiesTest.writeProperties();
    }

    //读取*.properties key-value内容
    public  void loadProperties() {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
//            inputStream = new FileInputStream(config);//java.io.FileNotFoundException: config.properties (系统找不到指定的文件。)
//            inputStream=getClass().getClassLoader().getResourceAsStream("test.properties");
            inputStream=PropertiesTest.class.getClassLoader().getResourceAsStream("test.properties");
            properties.load(inputStream);
            //1.逐个key-value遍历*.properties配置文件内容
            System.out.println("url:" + properties.getProperty("url"));
            System.out.println("username:" + properties.getProperty("username"));
            System.out.println("password:" + properties.getProperty("password"));
            System.out.println("database:" + properties.getProperty("databases"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        PropertiesTest propertiesTest = (PropertiesTest)ac.getBean("propertiesTest");
        propertiesTest.loadProperties();
    }

    //遍历Properties类key-value键值对
    public void printAll() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String file = "test.properties";
            //缺少getclassLoader()无法加载文件
//            input = getClass().getClassLoader().getResourceAsStream(file);

            input = getClass().getResourceAsStream("/test.properties");

            if(input == null) {
                System.out.println("无法加载文件" + file);
                return ;
            }
            prop.load(input);
            // 方法一
            Set<Object> keys = prop.keySet();
            for(Object key:keys) {
                System.out.println("key:" + key.toString() + "|" + "value:" + prop.get(key));
            }
            System.out.println("--------------------------------");
            //方法二：
            Set<Map.Entry<Object, Object>> entrys =	prop.entrySet();//返回的属性键值对实体
            for(Map.Entry<Object, Object> entry:entrys){
                System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
            }
            System.out.println("--------------------------------");
            //方法三：
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key:" + key + ",Value:" + value);
            }
            System.out.println("--------------------------------");
            //方法四.获取key的set集合遍历
            Set<String> names = prop.stringPropertyNames();
            for (String name : names) {
                System.out.println(name + ":" + prop.getProperty(name));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(input != null) {
                try {
                    input.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test03(){
        PropertiesTest p = new PropertiesTest();
        p.printAll();
    }

    //System.getProperties()   方法获取的 java环境变量 ，查看java系统变量的方法如下
    public static String getProperties() {
        //获取所有的属性
        Properties properties = System.getProperties();
        //为了看看系统的属性有几个，加了一个计数器
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + "=" + properties.getProperty(key));
        }
        return null;
    }
    @Test
    public void test04(){
        String properties = getProperties();
        System.out.println(properties);
    }


}

