CREATE TABLE IF NOT EXISTS roles
(
    id      bigint(8)   NOT NULL AUTO_INCREMENT,
    roleName varchar(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id      bigint(8)   NOT NULL AUTO_INCREMENT,
    name    varchar(45) NOT NULL,
    password varchar(100) NOT NULL,
    email   varchar(45) NOT NULL,
    PRIMARY KEY (id),
);

CREATE TABLE IF NOT EXISTS USER_ROLE
(
    USER_ID BIGINT,
    ROLE_ID BIGINT,
    FOREIGN KEY (USER_ID) REFERENCES USERS (ID),
    FOREIGN KEY (ROLE_ID) REFERENCES ROLES (ID)
);

CREATE TABLE IF NOT EXISTS producers
(
    id          bigint(8)   NOT NULL AUTO_INCREMENT,
    companyName varchar(45) NOT NULL,
    email       varchar(45) NOT NULL,
    country     varchar(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products
(
    id          bigint(8)   NOT NULL AUTO_INCREMENT,
    productName varchar(45) NOT NULL,
    cost        double      NOT NULL,
    user_id     bigint(8)   NOT NULL,
    PRIMARY KEY (id, user_id),
    CONSTRAINT fk_products_Users1 FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS products_producers
(
    product_id  bigint(8) NOT NULL,
    producer_id bigint(8) NOT NULL,
    foreign key (producer_id) references producers (id),
    foreign key (product_id) references products (id)
);
INSERT INTO roles VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO users VALUES (1, 'Tom','$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K','tom@mail.ru'),(2,'Peter','$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K','peter@gmail.com');

INSERT INTO USER_ROLE (USER_ID, ROLE_ID)VALUES (1, 1);
INSERT INTO USER_ROLE (USER_ID, ROLE_ID)VALUES (2, 2);

INSERT INTO producers VALUES (1,'Samsung','samsung@gmail.com','China'),(2,'Apple','apple@gmail.com','China'),(3,'Nokia','nokia@gmail.com','China'),(4,'Nokia','nokia@gmail.org','Sweden');

INSERT INTO products VALUES (1,'samsung',355,2),(2,'apple',700,2),(3,'nokia',500,1);

INSERT INTO products_producers VALUES (1,1),(2,2),(3,3),(3,4);
