package Lesson11.View;

import Lesson11.Controller.BookController;
import Lesson11.Model.DTO.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookView {

    BookController bookController = BookController.getInstance();
    Scanner sc = new Scanner(System.in);

    public void execute() throws SQLException {
        while (true) {
            boolean response;
            System.out.println("1. Show book");
            System.out.println("2. Add book");
            System.out.println("3. Delete book");
            System.out.println("4. Update book");
            System.out.println("0. Exit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    ArrayList<Book> listBook = bookController.getAllBook();
                    for (int i = 0; i < listBook.size(); i++) {
                        System.out.println("STT " + i + ": " + listBook.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.print("Enter name book: ");
                    String name = sc.next();
                    System.out.print("Enter price book: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    Book book = new Book(name, price);
                    if (bookController.addBook(book)) {
                        System.out.println("Succes");
                    } else {
                        System.out.println("Fail");
                    }
                    break;
//                case 3:
//                    System.out.println("Nhap vao STT sach muon xoa: ");
//                    try {
//                        int stt = sc.nextInt();
//                        response = bookController.deleteBookBySTT(stt);
//                        System.out.println(response);
//                    } catch (Exception e) {
//                        System.out.println("STT phai dang so nguyen!");
//                    } finally {
//
//                    }
//                    break;
//                case 4:
//                    System.out.print("Nhap vao STT sach muon update: ");
//                    int newStt = sc.nextInt();
//                    if (!bookController.isBookExist(newStt)) {
//                        break;
//                    }
//                    System.out.print("Enter name book: ");
//                    String newName = sc.next();
//                    System.out.print("Enter price book: ");
//                    int newPrice = sc.nextInt();
//                    sc.nextLine();
//                    Book book2 = new Book(newName, newPrice);
//
//                    if (bookController.updateBookBySTT(newStt, book2)) {
//                        System.out.println("Succes");
//                    } else {
//                        System.out.println("Fail");
//                    }
//                    break;

                default:
                    //Exit
                    return;
            }
        }

//    public void renderView(){
//        ArrayList<Book> list = BookController.getInstance().getAllBook();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }
    }
}
