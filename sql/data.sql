-- CREARE DATABASE 
CREATE DATABASE	library_management;
USE library_management;

-- CREATE TABLE
CREATE TABLE users (
     id INT AUTO_INCREMENT PRIMARY KEY,
     email VARCHAR(20) NOT NULL UNIQUE,
     password VARCHAR(15) NOT NULL,
     role VARCHAR(6) NOT NULL DEFAULT 'reader'
);

-- Create admin
INSERT INTO users(email, password, role)
VALUES ('admin@gmail.com','123456', admin);


CREATE TABLE readers (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(20) NOT NULL,
     user_id INT NOT NULL,
     FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE books (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100) NOT NULL,
     author VARCHAR(30) NOT NULL,
     stock INt NOT NULL,
     category VARCHAR(50) NOT NULL
);

INSERT INTO books (name, author, stock, category) VALUES
('Clean Code', 'Robert C. Martin', 10, 'Programming'),
('Pride and Prejudice', 'Jane Austen', 12, 'Novel'),
('A Brief History of Time', 'Stephen Hawking', 7, 'Science'),
('The Art of War', 'Sun Tzu', 9, 'History'),
('Thinking, Fast and Slow', 'Daniel Kahneman', 6, 'Psychology');


CREATE TABLE borrows (
     id INT AUTO_INCREMENT PRIMARY KEY,
     reader_id int NOT NULL,
     book_id INT NOT NULL,
     quantity INT NOT NULL,
     borrowDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     returnDate TIMESTAMP DEFAULT NULL,
     status VARCHAR(10) NOT NULL DEFAULT 'borrowed',
	 FOREIGN KEY (reader_id) REFERENCES readers(id),
	 FOREIGN KEY (book_id) REFERENCES books(id)
);
-- Trigger delete user

DELIMITER //

CREATE TRIGGER deleteUser
BEFORE DELETE ON users
FOR EACH ROW
BEGIN
    DELETE FROM readers WHERE user_id = OLD.id;
END;
//

DELIMITER ;

DELIMITER //
CREATE TRIGGER deleteReader
BEFORE DELETE ON readers
FOR EACH ROW
BEGIN
    DELETE FROM borrows WHERE reader_id = OLD.id;
END;
//

DELIMITER ;


-- Trigger delete book

DELIMITER //

CREATE TRIGGER deleteBook
BEFORE DELETE ON books
FOR EACH ROW
BEGIN
    DELETE FROM borrows WHERE book_id = OLD.id;
END;
//

DELIMITER ;

-- Query
SELECT * FROM users;

SELECT * FROM readers;

SELECT * FROM books;

SELECT * FROM borrows;