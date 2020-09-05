package Lesson11.View;

import Lesson11.Controller.AuthorController;
import Lesson11.Model.DTO.Author;
import Lesson11.Model.DTO.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AuthorView {

    AuthorController authorController = AuthorController.getInstance();
    Scanner sc = new Scanner(System.in);

    public void execute() throws SQLException {
        while (true) {
            boolean response;
            System.out.println("1. Show author");
            System.out.println("2. Add author");
            System.out.println("3. Delete author");
            System.out.println("4. Update author");
            System.out.println("0. Exit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    ArrayList<Author> listAuthor = authorController.getAllAuthor();
                    for (int i = 0; i < listAuthor.size(); i++) {
                        System.out.println("STT " + i + ": " + listAuthor.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.print("Enter name author: ");
                    String name = sc.next();
                    System.out.print("Enter age author: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    Author author = new Author(name, age);
                    if (authorController.addAuthor(author)) {
                        System.out.println("Succes");
                    } else {
                        System.out.println("Fail");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    return;
            }
        }

    }
}
