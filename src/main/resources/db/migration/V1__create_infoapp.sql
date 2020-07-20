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
