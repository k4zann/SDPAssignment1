package decorator_design_pattern;

// Create an interface called Dress
interface Dress {
	public void assemble(); // Declare a method to assemble the dress
}

// Create a class called BasicDress that implements Dress
class BasicDress implements Dress {
	@Override
	public void assemble() {
		System.out.println("Basic Dress Features"); // Print basic dress features
	}
}

// Create an abstract class called DressDecorator that implements Dress
class DressDecorator implements Dress {
	protected Dress dress;

	public DressDecorator(Dress c) {
		this.dress = c;
	}

	@Override
	public void assemble() {
		this.dress.assemble();
	}
}

// Create a class called CasualDress that extends DressDecorator
class CasualDress extends DressDecorator {
	public CasualDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Casual Dress Features"); // Print additional casual dress features
	}
}

// Create a class called SportyDress that extends DressDecorator
class SportyDress extends DressDecorator {
	public SportyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Sporty Dress Features"); // Print additional sporty dress features
	}
}

// Create a class called FancyDress that extends DressDecorator
class FancyDress extends DressDecorator {
	public FancyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Fancy Dress Features"); // Print additional fancy dress features
	}
}

// Create a public class called DecoratorPattern
public class DecoratorPattern {
	public static void main(String[] args) {
		// Create a SportyDress that wraps a BasicDress and assemble it
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		// Create a FancyDress that wraps a BasicDress and assemble it
		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		// Create a CasualDress that wraps a BasicDress and assemble it
		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		// Create a SportyDress that wraps a FancyDress, which in turn wraps a BasicDress, and assemble it
		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		// Create a CasualDress that wraps a FancyDress, which in turn wraps a BasicDress, and assemble it
		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
