package cn.ahpu.reflect.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy01 {
    public static void main(String[] args) {
        //要代理的真实对象(该对象实现接口)
        People01 student = new Student();

        //代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，最终代理对象的调用处理程序会调用真实对象的方法
        InvocationHandler handler = new WorkHandler01(student);
        /**
         * 通过Proxy类的newProxyInstance方法创建代理对象，我们来看下方法中的参数
         * 第一个参数：people.getClass().getClassLoader()，使用handler对象的classloader对象来加载我们的代理对象
         * 第二个参数：people.getClass().getInterfaces()，这里为代理类提供的接口是真实对象实现的接口，这样代理对象就能像真实对象一样调用接口中的所有方法
         * 第三个参数：handler，我们将代理对象关联到上面的InvocationHandler对象上
         */
        People01 proxy = (People01) Proxy.newProxyInstance(handler.getClass().getClassLoader(), student.getClass().getInterfaces(), handler);
        //System.out.println(proxy.toString());
        System.out.println(proxy.work("学习,看饭局"));//无法代理使用非接口实现类

    }
}

class WorkHandler01 implements InvocationHandler {

    //代理类中的真实对象
    private Object obj;

    public WorkHandler01() {
        // TODO Auto-generated constructor stub
    }

    //构造函数，给我们的真实对象赋值
    public WorkHandler01(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在真实的对象执行之前我们可以添加自己的操作
        System.out.println("before invoke。。。");
        Object invoke = method.invoke(obj, args);//在一个完整的对象前后添加了操作 封装在一个对象中
        //在真实的对象执行之后我们可以添加自己的操作
        System.out.println("after invoke。。。");
        return invoke;
    }
}

class Student implements People01 {

    public void other() {//非接口实现类方法 代理类不会去代理
        System.out.println("我是other方法");
    }

    @Override
    public People01 work(String workName) {
        System.out.println("工作内容是" + workName);
        return this;
    }

    @Override
    public String time() {
        return "2018-06-12";
    }
}

interface People01 {
    People01 work(String workName);

    String time();
}
