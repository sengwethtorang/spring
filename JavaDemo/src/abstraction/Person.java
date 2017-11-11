package abstraction;

public abstract class Person {
	public abstract void speak();
}
class Son extends Person{

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Son speak khmer");
		
	}
	
}

