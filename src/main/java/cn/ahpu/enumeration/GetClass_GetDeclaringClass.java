package cn.ahpu.enumeration;

//https://blog.csdn.net/DaJian35/article/details/79705193?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166437899716781432949961%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=166437899716781432949961&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-5-79705193-null-null.142^v50^control,201^v3^control_1&utm_term=getClass%E5%92%8CgetDecalredClass&spm=1018.2226.3001.4187
//java 枚举类 getClass和getDeclaringClass的区别
public class GetClass_GetDeclaringClass {
}

//getDeclaring()与getSuperClass()可以保证获取的当前自定义枚举类型父类为Enum类型，解决枚举内部类问题（在枚举中定义一个内部类 如含有方法）
enum FruitEnum{
    BANANA,APPLE;

    public static void main(String[] args) {
        System.out.println(BANANA.getDeclaringClass()+"   "+BANANA.getDeclaringClass().getSuperclass());
        System.out.println(BANANA.getClass()+"   "+BANANA.getClass().getSuperclass());
    }
}

enum FruitEnum02{
    BANANA{
        String getName() {
            return "香蕉";
        }
    },APPLE{
        String getName() {
            return "苹果";
        }
    };

    abstract String getName();

    public static void main(String[] args) {
        System.out.println(BANANA.getDeclaringClass()+"   "+BANANA.getDeclaringClass().getSuperclass()+" "+(BANANA instanceof FruitEnum02));
        System.out.println(BANANA.getClass()+"   "+BANANA.getClass().getSuperclass());
    }
}