public class StaticInnerClass{
    public static void main(String []args){
        //Outer2.Inner2 inner=new Outer2.Inner2();//构造一个静态内部类对象
        //inner.innerShow();
        Outer2 outer=new Outer2();
        outer.outerShow();
    }
}

class Outer2{
    private String name="张三";
    private int num1=10;
    private static int num3=100;
    public void outerShow(){
        System.out.println(name);
        System.out.println(num1);
        Inner2 inner2=new Inner2();
        System.out.println(inner2.name);
        System.out.println(Inner2.num3);
    }
    public static class Inner2{
        private String name="李四";
        private int num2=20;
        private static int num3=10;

        public void innerShow(){
            //System.out.println(Outer2.this.name);
            //静态内部类不能访问外部类的非静态成员
            System.out.println(num2); 
            System.out.println(Outer2.num3);
        }
    }
}