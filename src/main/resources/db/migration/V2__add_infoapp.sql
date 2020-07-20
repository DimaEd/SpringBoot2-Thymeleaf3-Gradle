INSERT INTO roles VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO users VALUES (1, 'Tom','$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K','tom@mail.ru'),(2,'Peter','$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K','peter@gmail.com');

INSERT INTO USER_ROLE (USER_ID, ROLE_ID)VALUES (1, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID)VALUES (2, 2);

INSERT INTO producers VALUES (1,'Samsung','samsung@gmail.com','China'),(2,'Apple','apple@gmail.com','China'),(3,'Nokia','nokia@gmail.com','China'),(4,'Nokia','nokia@gmail.org','Sweden');

INSERT INTO products VALUES (1,'samsung',355,2),(2,'apple',700,2),(3,'nokia',500,1);

INSERT INTO products_producers VALUES (1,1),(2,2),(3,3),(3,4);
