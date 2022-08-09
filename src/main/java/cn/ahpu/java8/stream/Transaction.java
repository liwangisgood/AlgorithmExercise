package cn.ahpu.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    //@Data 编译后的字节码无法跳转到Trader类的@Data的equals()方法中  源代码是可以跳转的
    //@Data 都重写equals() 和hashCode()方法依旧不行
    private Trader trader;//比较该引用字段是否相等 不能引用@Data Trader类内的
    private int year;
    private int value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (year != that.year) return false;
        if (value != that.value) return false;
        if (trader==null){
            if (that.trader==null) return true;
            else return false;
        }else {
            return trader.equals(that.trader);
        }
    }

    @Override
    public int hashCode() {
        int result = trader != null ? trader.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + value;
        return result;
    }
}
