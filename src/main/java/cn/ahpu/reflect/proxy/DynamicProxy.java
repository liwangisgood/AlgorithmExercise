package cn.ahpu.reflect.proxy;

import java.lang.reflect.*;

public class DynamicProxy {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //要代理的真实对象(该对象实现接口)
        People people = new Teacher();

        //代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，最终代理对象的调用处理程序会调用真实对象的方法
        InvocationHandler handler = new WorkHandler(people);
        /**
         * 通过Proxy类的newProxyInstance方法创建代理对象，我们来看下方法中的参数
         * 第一个参数：people.getClass().getClassLoader()，使用handler对象的classloader对象来加载我们的代理对象
         * 第二个参数：people.getClass().getInterfaces()，这里为代理类提供的接口是真实对象实现的接口，这样代理对象就能像真实对象一样调用接口中的所有方法
         * 第三个参数：handler，我们将代理对象关联到上面的InvocationHandler对象上
         */
        People proxy = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        //System.out.println(proxy.toString());
        System.out.println(proxy.work());

        System.out.println("----------------------------------");

        Class<Teacher> aClass = Teacher.class;
        Constructor<Teacher> constructor = aClass.getConstructor(String.class);
        Teacher teacher = constructor.newInstance("李旺");
        teacher.other();
    }
}

class WorkHandler implements InvocationHandler {

    //代理类中的真实对象
    private Object obj;

    public WorkHandler() {
        // TODO Auto-generated constructor stub
    }
    //构造函数，给我们的真实对象赋值
    public WorkHandler(Object obj) {
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

class Teacher implements People{

    public void other() {//非接口实现类方法 代理类不会去代理
        System.out.println("我是other方法");
    }

    public Teacher(){
        System.out.println("Teacher无参构造器");
    }

    public Teacher(String name){
        System.out.println("Teacher类一个参数构造器:"+name);
    }

    @Override
    public String work() {
        System.out.println("老师教书育人...");
        return "教书";
    }
}

interface People {
    public String work();
}