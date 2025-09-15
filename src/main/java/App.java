
import dao.ReaderDAO;
import models.Reader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Test
        ReaderDAO dao = ReaderDAO.getInstance();
        Reader u = dao.selectById(1);
        System.out.println(u.getId());

    }
}
