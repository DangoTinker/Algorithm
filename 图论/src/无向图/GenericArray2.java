package ����ͼ;

public class GenericArray2<T> {
    private Object[] array;  //ά��Object[]��������
    public GenericArray2(int sz) {
        array = new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) { return (T)array[index]; }//����������ǿת
    public T[] rep() { return (T[])array; } //����ʱ������������Object[]���� 
   
}