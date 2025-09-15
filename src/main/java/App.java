
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
        Reader u = new Reader("Thien", 2);
        int result = dao.insert(u);
        if (result > 0) {
            System.out.println("Them thanh cong");
        } else {
            System.out.println("Them that bai");
        }

    }
}
