
public class User {
	
	/**
	 * Create a user with the defined name.
	 * @param aName A string to be assign as name
	 * of the user.
	 */
	public User(String aName) {
		setName(aName);
	}

	/**
	 * Get the name of the current user.
	 * @return A String that specifies the name of the
	 * current user.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of the user.
	 * @param name A String that specifies the name of the user.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	private String name;
}
