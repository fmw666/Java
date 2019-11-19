public class AnonymousInnerClass{
    public static void main(String []args){
        Person p=new Person();
        //Animal dog=new Dog();
        //p.feed(dog);

        new IAnimal(){
        	private String name="aa";
        	//static{
        	//	name="哈哈";
        	//}
        	public void eat(){
				System.out.println("啃骨头");
			}
			public void show(){
				System.out.println(name);
			}
		}.show();

        //p.feed(dog);
        //dog.show(); 
        //p.feed(dog);

        p.feed(new IAnimal(){
			public void eat(){
				System.out.println("吃鱼肉");
			}
        });
    }
}

class Person{
	public void feed(IAnimal animal){
		animal.eat();
	}
}

/*abstract class Animal{
	public abstract void eat();
}*/

interface IAnimal{
	public abstract void eat();
}

/*class Dog extends Animal{
	public void eat(){
		System.out.println("啃骨头");
	} 
}*/
