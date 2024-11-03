package src.bll;

import src.dal.BookDAO;
import src.dto.BookDTO;

import java.util.List;

public class BookBO {
    private BookDAO bookDAO;
    public BookBO() {
        this.bookDAO = new BookDAO();
    }
    public List<BookDTO> searchBooks(String title) {
        return bookDAO.searchBooksByTitle(title);
    }
}
