public class MemberInnerClass{
    public static void main(String []args){
        //创建外部类的对象
        Outer1 outer=new Outer1();
        //创建内部类的对象
        Outer1.Inner1 inner=outer.new Inner1();
        inner.innerShow();
        //outer.outerShow(); 
    }
}

class Outer1{
    private String name="张三";
    private int num1=10;
    public void outerShow(){
        System.out.println(name);
        System.out.println(num1);
        //Inner1 inner1=new Inner1();
        //inner1.innerShow();
        //System.out.println(num2);//外部类不能直接访问内部类的成员
    }
    public class Inner1{
        private String name="李四";
        private int num2=20;
        private static final int num3=10;//静态常量在内部类中是可以的
        //private static int num3=30;//在成员内部类中不能声明静态的成员，包括属性和方法
        public void innerShow(){
            System.out.println(Outer1.this.name);
            System.out.println(num2);
            //System.out.println(num1);

            //outerShow();//成员内部类可以直接访问内部类的属性和方法，包括私有的
        }
    }
}