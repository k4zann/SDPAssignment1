package proxy_design_pattern;

// Create an interface called DatabaseExecuter
interface DatabaseExecuter {
	public void executeDatabase(String query) throws Exception;
}

// Create a class DatabaseExecuterImpl that implements the DatabaseExecuter interface
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

// Create a class DatabaseExecuterProxy that implements the DatabaseExecuter interface
class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin; // Flag to check if the user is an admin
	DatabaseExecuterImpl dbExecuter; // Instance of the real database executer

	public DatabaseExecuterProxy(String name, String passwd) {
		if (name.equals("Admin") && passwd.equals("Admin@123")) {
			ifAdmin = true; // Check if the user is an admin
		}
		dbExecuter = new DatabaseExecuterImpl(); // Create an instance of the real database executer
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			dbExecuter.executeDatabase(query); // If the user is an admin, allow executing any query
		} else {
			if (query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user"); // If the user is not an admin, block DELETE queries
			} else {
				dbExecuter.executeDatabase(query); // Allow executing other queries for non-admin users
			}
		}
	}
}

// Create a public class called ProxyPattern
public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		// Create a non-admin database executer using the proxy
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE"); // Attempt to execute an invalid query

		// Create another non-admin database executer using the proxy
		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE"); // Attempt to execute a DELETE query

		// Create an admin database executer using the proxy
		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE"); // Execute a DELETE query successfully
	}
}
