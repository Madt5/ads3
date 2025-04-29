package Asik3;

public class MyTestingClass{
    private int id;

    public MyTestingClass(){};

    public MyTestingClass(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public int hashCode(){
        int result = 7;
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj==null || getClass()!= obj.getClass()) {
            return false;
        }
        MyTestingClass another = (MyTestingClass) obj;
        return this.id== another.id;
    }
}
