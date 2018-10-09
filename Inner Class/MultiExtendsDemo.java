public class MultiExtendsDemo{
    public static void main(String []args){
        C c=new C();
		c.showA();
		c.showB();
    }
}

class A{
	public void showA(){
		System.out.println("A");
	}
}
class B{
	public void showB(){
		System.out.println("B");
	}
}

class C{
	private class A1 extends A{
		public void showA(){
			super.showA();
		}
	}
	
	private class B1 extends B{
		public void showB(){
			super.showB();
		}
	}
	
	public void showA(){
		new A1().showA();
	}
	
	public void showB(){
		new B1().showB();
	}
}