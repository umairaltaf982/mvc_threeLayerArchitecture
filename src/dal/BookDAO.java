package src.dal;

import src.dto.BookDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<BookDTO> searchBooksByTitle(String title) {
        List<BookDTO> books = new ArrayList<>();
        String query = "SELECT * FROM books WHERE title LIKE ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                books.add(new BookDTO(rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
