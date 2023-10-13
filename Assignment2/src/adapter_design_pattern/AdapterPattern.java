package adapter_design_pattern;

// Define an interface called WebDriver
interface WebDriver {
	public void getElement(); // Declare a method to get an element
	public void selectElement(); // Declare a method to select an element
}

// Create a class called ChromeDriver that implements the WebDriver interface
class ChromeDriver implements WebDriver {
	@Override
	public void getElement() {
		System.out.println("Get element from ChromeDriver"); // Print a message when getting an element
	}

	@Override
	public void selectElement() {
		System.out.println("Select element from ChromeDriver"); // Print a message when selecting an element
	}
}

// Create a class called IEDriver
class IEDriver {
	public void findElement() {
		System.out.println("Find element from IEDriver"); // Print a message when finding an element
	}

	public void clickElement() {
		System.out.println("Click element from IEDriver"); // Print a message when clicking an element
	}
}

// Create a class called WebDriverAdapter that implements the WebDriver interface
class WebDriverAdapter implements WebDriver {
	IEDriver ieDriver; // Use the IEDriver class for the adapter

	public WebDriverAdapter(IEDriver ieDriver) {
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement() {
		ieDriver.findElement(); // Adapt the getElement method to IEDriver's findElement
	}

	@Override
	public void selectElement() {
		ieDriver.clickElement(); // Adapt the selectElement method to IEDriver's clickElement
	}
}

// Create a public class AdapterPattern
public class AdapterPattern {
	public static void main(String[] args) {
		ChromeDriver a = new ChromeDriver();
		a.getElement(); // Call the getElement method for ChromeDriver
		a.selectElement(); // Call the selectElement method for ChromeDriver

		IEDriver e = new IEDriver();
		e.findElement(); // Call the findElement method for IEDriver
		e.clickElement(); // Call the clickElement method for IEDriver

		// Create an adapter instance to use IEDriver as if it were a WebDriver
		WebDriver wID = new WebDriverAdapter(e);
		wID.getElement(); // Call the adapted getElement method using the adapter
		wID.selectElement(); // Call the adapted selectElement method using the adapter
	}
}
