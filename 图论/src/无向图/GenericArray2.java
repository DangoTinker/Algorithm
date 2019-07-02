package 无向图;

public class GenericArray2<T> {
    private Object[] array;  //维护Object[]类型数组
    public GenericArray2(int sz) {
        array = new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) { return (T)array[index]; }//数组对象出口强转
    public T[] rep() { return (T[])array; } //运行时无论怎样都是Object[]类型 
   
}