
package Lesson11;

import Lesson11.View.AuthorView;
import Lesson11.View.BookView;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        BookView bookView = new BookView();
        AuthorView authorView = new AuthorView();
        
        //bookView.execute();
        authorView.execute();
    }
}
