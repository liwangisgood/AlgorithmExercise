package cn.ahpu.designpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author:liwang
 * @date: 2022/4/1 17:35
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://www.runoob.com/design-pattern/singleton-pattern.html
 */

public class SingleTon {

	public static void main(String[] args) {

		//1.学会了导包
		//Student student = new Student();

//		2.private构造器不能在外不类创建对象
		//Car car = new Car();
//		System.out.println(car);

//		3.单列模式只会创建一个对象 在内存中 无论调用多次都只会有一个该类对象
		Car car = Car.getInstance();
		System.out.println(car);

	}
}

@Data
@AllArgsConstructor
class Car {

	private static Car car = new Car();
	String name;
	String color;

	//1.构造器设置privates属性 其他类不可new()构造 唯有通过在本类中创建对象 返回对象
	private Car() {
	}

	//2.创建方法返回实例单列对象
	public static Car getInstance(){
		return car;
	}


}
