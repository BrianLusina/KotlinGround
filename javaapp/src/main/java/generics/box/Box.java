package java.generics.box;

/**
 * java.generics
 * Created by lusinabrian on 25/12/16.
 * Description:Demo of Java Generics
 * @param <T> The type of the value being boxed
 */
public class Box<T> {
    // T stands for type
    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

}
