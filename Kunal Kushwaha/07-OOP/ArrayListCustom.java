import java.util.Arrays;

public class ArrayListCustom {
    private int[] data;
    private static int DEFAULT_SIZE=10;
    private int size = 0;//it also work as index value

    public ArrayListCustom(){
        this.data=new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }

    private void resize(){
        int[] temp =new int[data.length*2];
        //copy the current items in the new array
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

    private boolean isFull(){
        return size==data.length;
    }

    public int remove(){
        int removed=data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index,int value){
        data[index]=value;
    }

    @Override
    public String toString(){
        return "ArrayListCustom{"+
        "data="+Arrays.toString(data)+
        ",size="+size+
        "}";
    }

    public static void main(String[] args){
        //ArrayList list = new ArrayList();
        ArrayListCustom list=new ArrayListCustom();
        list.add(3);

        for(int i=0;i<12;i++){
            list.add(2*i);
        }

        System.out.println(list);

        //we cant add anything apart from integers in this arrayListcutom
    }
}
