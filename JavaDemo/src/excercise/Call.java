package excercise;

public class Call {
	public static void main(String[] args) {
		Animal an = null;
		String animal = "dog";
		switch (animal) {
		case "dog":
			an = new Dog();
			break;

		case "cat":
			an = new Cat();
			break;
		
		case "pig":
			an = new Pig();
			break;
		}
		
		an.speak();
	}
}
