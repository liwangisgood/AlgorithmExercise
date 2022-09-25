package cn.ahpu.generics.myinterface;

import org.springframework.stereotype.Component;

import java.util.Random;

//定义一个泛型接口
public interface Generator<T> {
    T getT();
}

@Component
class FruitGenerator<T> implements Generator<T>{

    private T t;
    public static void main(String[] args) {

    }

    @Override
    public T getT() {
        return t;
    }
}

class FruitGeneratorString implements Generator<String> {
    private String t;

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String getT() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
