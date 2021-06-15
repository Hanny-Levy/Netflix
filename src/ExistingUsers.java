import java.util.Scanner;

public class ExistingUsers {
    private User [] users ;
    public ExistingUsers() {
        this.users = new User[0];
    }

    public User[] getUsers() {
        return users;
    }
    public void setUsers(User[] users) {
        this.users = users;
    }

    public void addUser(User user){
        User [] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        newArray[this.users.length] = user;
        this.users = newArray;
    }
    public void loggIn(){
        System.out.println("Username : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while (!this.searchUser(name)){
            System.out.println("Username does not exist Try again!");
            System.out.println("Username : ");
            name = scanner.nextLine();
        }
        System.out.println("Password : ");
        String password = scanner.nextLine();
        if (this.getUsers()[this.userIndex(name)].getPassword().equals(password))
            System.out.println("Welcome back " + name);
        else {
            while (!this.getUsers()[this.userIndex(name)].getPassword().equals(password)){
                System.out.println("Incorrect password Please try again!");
                password = scanner.nextLine();
            }

        }
    }

    public boolean searchUser(String name){
        for (int i=0 ; i < this.getUsers().length ; i++){
            if (this.getUsers()[i].getName().equals(name))
                return true ;
        }
        return false;
    }

    public int userIndex(String userName) {
        if (this.searchUser(userName)) {
            for (int i = 0; i < this.getUsers().length; i++) {
                if (this.getUsers()[i].getName().equals(userName))
                    return i;
            }
        }
        return -1;
    }

}
