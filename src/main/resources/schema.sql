CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand_id BIGINT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list BIGINT,
    product_id BIGINT,
    priority int,
    price DECIMAL(10, 2),
    currency VARCHAR(255)
);