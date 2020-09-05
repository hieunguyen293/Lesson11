
package Lesson11.Model.DAO;

import Lesson11.Helper.DatabaseUtil;
import Lesson11.Model.DTO.Author;
import Lesson11.Model.DTO.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDAO {
    DatabaseUtil dbUtil = new DatabaseUtil();
    
    public ArrayList<Author> getAllAuthor() throws SQLException {
        String sql = "Select * from Author";
        ArrayList<Author> authorList = new ArrayList<>();
        ResultSet rs = dbUtil.executeQuery(sql);
        while (rs.next()) {
            Author temp = new Author();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setAge(rs.getInt("age"));
            authorList.add(temp);
        }
        return authorList;
        
    }
    
    public boolean addAuthor(Author author) throws SQLException {

        String sql = "Insert into Book values('" + author.getName() + "','" + author.getAge() + "')";
//            ResultSet rs = dbUtil.executeQuery(sql);
        try {
            dbUtil.updateQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateAuthor(String name) throws SQLException {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
}
