CREATE TABLE products
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    type               VARCHAR(50)              NOT NULL,
    serial_number      VARCHAR(50)              NOT NULL,
    manufacturer       VARCHAR(50)              NOT NULL,
    price              BIGINT CHECK (price > 0) NOT NULL,
    amount             INT CHECK (amount > 0)   NOT NULL,
    pc_form_factor     VARCHAR(50),
    laptop_screen_size VARCHAR(50),
    screen_size        VARCHAR(50),
    hard_disk_size     VARCHAR(50)
);
