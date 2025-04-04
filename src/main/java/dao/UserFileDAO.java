package dao;

import model.User;
import java.io.*;
import java.util.*;

public class UserFileDAO {

    private static final String USER_FILE = "users.txt"; // File to store users

    // Reads all users from the file
    public static List<User> getAllUsersFromFile() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    users.add(new User(Integer.parseInt(data[0]), data[1], data[2], data[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Adds a new user to the file
    public static boolean addUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            String line = user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getRole();
            writer.write(line);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
