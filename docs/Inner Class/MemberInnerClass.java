public class MemberInnerClass{
    public static void main(String []args){
        //�����ⲿ��Ķ���
        Outer1 outer=new Outer1();
        //�����ڲ���Ķ���
        Outer1.Inner1 inner=outer.new Inner1();
        inner.innerShow();
        //outer.outerShow(); 
    }
}

class Outer1{
    private String name="����";
    private int num1=10;
    public void outerShow(){
        System.out.println(name);
        System.out.println(num1);
        //Inner1 inner1=new Inner1();
        //inner1.innerShow();
        //System.out.println(num2);//�ⲿ�಻��ֱ�ӷ����ڲ���ĳ�Ա
    }
    public class Inner1{
        private String name="����";
        private int num2=20;
        private static final int num3=10;//��̬�������ڲ������ǿ��Ե�
        //private static int num3=30;//�ڳ�Ա�ڲ����в���������̬�ĳ�Ա���������Ժͷ���
        public void innerShow(){
            System.out.println(Outer1.this.name);
            System.out.println(num2);
            //System.out.println(num1);

            //outerShow();//��Ա�ڲ������ֱ�ӷ����ڲ�������Ժͷ���������˽�е�
        }
    }
}