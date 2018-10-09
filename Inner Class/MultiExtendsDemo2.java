public class MultiExtendsDemo2{
	public static void main(String[] args) {
		Son son=new Son();
		son.show();
		son.show1();
	}
}

abstract class Parent{
	public abstract void show();
}

interface IShow{
	public abstract void show();
}

/*class Son extends Parent implements IShow{
	public void show(){

	}	
	public void show1(){

	}
}*/

class Son extends Parent{
	public void show(){
		System.out.println("抽象类中的show方法");
	}
	private class Inner2 implements IShow{
		public void show(){
			System.out.println("接口中的show方法");
		}
	}
	public void show1(){
		new Inner2().show();
	}
}