package src.pl;

import src.bll.BookBO;
import src.dto.BookDTO;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSearchApp extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea resultArea;
    private BookBO bookBO;

    public BookSearchApp() {
        bookBO = new BookBO();
        setTitle("Book Search Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Search for a book: "));
        searchField = new JTextField(20);
        topPanel.add(searchField);
        searchButton = new JButton("Search");
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchBooks();
            }
        });
    }

    private void searchBooks() {
        String title = searchField.getText();
        List<BookDTO> books = bookBO.searchBooks(title);
        resultArea.setText("");
        if (books.isEmpty()) {
            resultArea.append("No books found.");
        } else {
            for (BookDTO book : books) {
                resultArea.append(book.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookSearchApp().setVisible(true);
            }
        });
    }
}