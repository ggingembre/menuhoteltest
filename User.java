/**
 * Created by guillaume on 4/26/17.
 */
public class User {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String userName;
    private String password;

    public User(String firstName, String lastName, String address, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }


    @Override
    public String toString() {
        return "First Name: " + firstName + "\nLast name: " + lastName + "\nAddress: " + address +
                "\nEmail: " + email + "\nUsername: " + userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!address.equals(user.address)) return false;
        if (!email.equals(user.email)) return false;
        if (!userName.equals(user.userName)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
