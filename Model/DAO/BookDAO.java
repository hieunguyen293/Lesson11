package Lesson11.Model.DAO;

import Lesson11.Helper.DatabaseUtil;
import Lesson11.Model.DTO.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {

    DatabaseUtil dbUtil = new DatabaseUtil();

    public ArrayList<Book> getAllBook() throws SQLException {
        String sql = "Select * from Book;";
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = dbUtil.executeQuery(sql);
        while (rs.next()) {
            Book temp = new Book();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setPrice(rs.getInt("price"));
            bookList.add(temp);
        }
        return bookList;
    }

    public boolean addBook(Book book) throws SQLException {
        String sql = "SELECT name FROM Book WHERE EXISTS (SELECT name FROM Book WHERE name = '" + book.getName() + "');";
        try {
            ResultSet rs = dbUtil.executeQuery(sql);
            if (rs.next()) {
                return false;
            } else {
                sql = "Insert into Book(name,price) values('" + book.getName() + "','" + book.getPrice() + "');";

                try {
                    dbUtil.updateQuery(sql);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean updateBookByName(String name, Book book) throws SQLException {
        String sql = "SELECT name FROM Book WHERE EXISTS (SELECT name FROM Book WHERE name = '" + name + "');";
        try {
            ResultSet rs = dbUtil.executeQuery(sql);
            if (rs.next()) {
                sql = "UPDATE Book SET name = '" + book.getName() + "', price = '" + book.getPrice() + "' WHERE name = '" + name + "' ";
//                sql = "Insert into Book(name,price) values('" + book.getName() + "','" + book.getPrice() + "');";

                try {
                    dbUtil.updateQuery(sql);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean deleteBookByName(String name) throws SQLException {
        String sql = "SELECT name FROM Book WHERE EXISTS (SELECT name FROM Book WHERE name = '" + name + "');";
        try {
            ResultSet rs = dbUtil.executeQuery(sql);
            if (rs.next()) {
                
                try {
                    dbUtil.updateQuery(sql);
                    return true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

}
