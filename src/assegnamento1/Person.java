package assegnamento1;

public class Person {
    String name;
    String surname;
    String username;
    String password;

    public Person() {
        System.out.println("Person created with success !");
    }

    public Person(String name, String surname, String username, String password) {
        this.setName(name);
        this.setSurname(surname);
        this.setUsername(username);
        this.setPassword((password));
    }

    public Person(String username, String password) {
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void changePassword(final String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed with success!");
    }

    /**
     * This method checks if the password is correct for the user.
     *
     * @param password
     * @return true if the login is ok
     */
    public boolean checkLogin (String password) {
        if (password.equals(this.password)){
            return true;
        }
        else {
            return false;
        }
    }
}

