import java.util.*;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }
}

class SocialMedia {
    private User head = null;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriendship(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeFriendship(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + "'s Friends: " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            ArrayList<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
            mutualFriends.retainAll(user2.friendIds);
            System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID - " + temp.userId + ", Age - " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        int choice, userId1, userId2, age;
        String name;

        while (true) {
            System.out.println("\nSocial Media Friend Connections Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of a User");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by Name");
            System.out.println("7. Count Friends of Each User");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    userId1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    age = scanner.nextInt();
                    sm.addUser(userId1, name, age);
                    break;
                case 2:
                    System.out.print("Enter First User ID: ");
                    userId1 = scanner.nextInt();
                    System.out.print("Enter Second User ID: ");
                    userId2 = scanner.nextInt();
                    sm.addFriendship(userId1, userId2);
                    break;
                case 3:
                    System.out.print("Enter First User ID: ");
                    userId1 = scanner.nextInt();
                    System.out.print("Enter Second User ID: ");
                    userId2 = scanner.nextInt();
                    sm.removeFriendship(userId1, userId2);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    userId1 = scanner.nextInt();
                    sm.displayFriends(userId1);
                    break;
                case 5:
                    System.out.print("Enter First User ID: ");
                    userId1 = scanner.nextInt();
                    System.out.print("Enter Second User ID: ");
                    userId2 = scanner.nextInt();
                    sm.findMutualFriends(userId1, userId2);
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.print("Enter Name to Search: ");
                    name = scanner.nextLine();
                    sm.searchUserByName(name);
                    break;
                case 7:
                    sm.countFriends();
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
