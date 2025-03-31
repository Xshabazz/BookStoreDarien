package test;

import dao.UserDAO;
import model.User;

import java.util.Scanner;

public class UserDAOTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test user registration
        System.out.println("Register a new user");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (CUSTOMER/ADMIN): ");
        String role = scanner.nextLine();

        boolean registrationSuccess = UserDAO.registerUser(username, password, role);
        if (registrationSuccess) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }

        // Test user login
        System.out.println("\nLogin:");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        User user = UserDAO.authenticateUser(loginUsername, loginPassword);
        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getUsername() + ". Role: " + user.getRole());
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }

        scanner.close();
    }
}

