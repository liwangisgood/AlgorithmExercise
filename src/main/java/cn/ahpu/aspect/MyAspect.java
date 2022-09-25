package cn.ahpu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect {


    //    SLF4J获得logger对象：
    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);


    //环绕通知 可获取原方法返回值 并可修改值再次作为最终结果返回 无JoinPoint joinPoint作为参数 仅有如下
    //Object obj = pjp.proceed();执行改行代码 即调用目标方法发生异常 程序会终止 不会向下继续执行
//    @Around(value = "execution(* cn.ahpu.service.impl.StudentServiceImpl.*(..))"/*&& args(name,age)", argNames = "pjp,name,age"*/)
    @Around(value = "execution(* cn.ahpu..*.*(..))"/*&& args(name,age)", argNames = "pjp,name,age"*/)
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();//相当于调用method.invoke(target,args)
        long end = System.currentTimeMillis();
        System.out.println("环绕通知获取目标方法return返回的对象值" + obj);
        Signature signature = pjp.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        System.out.println(declaringTypeName+ " " + name);
        logger.info("{}.{}()耗时{}ms",declaringTypeName,name,end-start);
        return obj;
    }


}
