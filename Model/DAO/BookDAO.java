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
        String sql = "Select * from Book";
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

        String sql = "Insert into Book values('" + book.getName() + "','" + book.getPrice() + "')";
//            ResultSet rs = dbUtil.executeQuery(sql);
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateBook(String name) throws SQLException {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
