import java.util.Arrays;

public class GenArrayListCustom<T>{
    private Object[] data;
    private static int DEFAULT_SIZE=10;
    private int size =0;

    public GenArrayListCustom(){
        data=new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if(isFull()) resize();
        data[size++]=num;
    }

    private boolean isFull(){
        return size==data.length;
    }

    private void resize(){
        Object[] temp=new Object[data.length*2];
        //System.arraycopy(data, 0, temp, 0, data.length);
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

    public T get(int index){
        return (T)data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index,T value){
        data[index]=value;
    }

    @Override
    public String toString(){
        return "GenArrayListCustom{"+
        "data="+Arrays.toString(data)+
        ",size="+size+
        "}";
    }

    public static void main(String[] args){
        GenArrayListCustom<String> list=new GenArrayListCustom<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        String str=list.get(0);
        System.out.println(str);
    }


    
}
