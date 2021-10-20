package assegnamento1;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("admin", "admin", "admin", "admin");
        System.out.println("System Initiated successfully !");

        Person FirstPerson = new Person();
        FirstPerson.setName("Elon Musk");;
        System.out.println(FirstPerson.name);
    }
}