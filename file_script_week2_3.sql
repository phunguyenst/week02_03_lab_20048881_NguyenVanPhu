CREATE DATABASE IF NOT EXISTS `storedb`;
USE storedb;

-- Chèn dữ liệu vào bảng Employee
INSERT INTO `employee` (full_name, dob, email, phone, address, status)
VALUES
    ('Nguyen An', '1990-01-15', 'an@gmail.com', '123456789', '123 Main St', 1),
    ('Nguyen Khoi', '1985-05-20', 'khoi@gmail.com', '987654321', '456 Elm St', 1);

-- Chèn dữ liệu vào bảng Product
INSERT INTO product (name, description, unit, manufacturer_name, status)
VALUES
    ('Nước ngọt Coca-Cola', 'Nước uống có ga', 'Lon', 'Coca-Cola Company', 1),
    ('Nước ngọt Fanta', 'Nước uống có ga', 'Lon', 'The Coca-Cola Company', 1),
   ('Nước ngọt Pepsi', 'Nước uống có ga', 'Lon', 'PepsiCo', 1),
    ('Nước ngọt 7UP', 'Nước uống có ga', 'Lon', 'PepsiCo', 1),
    ('Nước ngọt Mirinda', 'Nước uống có ga', 'Lon', 'PepsiCo',0),
    ('Nước ngọt Sprite', 'Nước uống có ga', 'Lon', 'The Coca-Cola Company', 0),
    ('Nước ngọt Mountain Dew', 'Nước uống có ga', 'Lon', 'PepsiCo', 1),
    ('Nước ngọt Dr. Pepper', 'Nước uống có ga', 'Lon', 'Dr. Pepper Snapple Group', 1),
    ('Nước ngọt Schweppes', 'Nước uống có ga', 'Lon', 'Schweppes', 1),
    ('Nước ngọt Canada Dry', 'Nước uống có ga', 'Lon', 'Dr. Pepper Snapple Group', 1),
    ('Nước ngọt Sunkist', 'Nước uống có ga', 'Lon', 'Sunkist Growers', 1),
    ('Nước ngọt A&W', 'Nước uống có ga', 'Lon', 'A&W Restaurants', 1),
    ('Nước ngọt Crush', 'Nước uống có ga', 'Lon', 'Dr. Pepper Snapple Group', 1),
    ('Nước ngọt Barq''s', 'Nước uống có ga', 'Lon', 'The Coca-Cola Company', 1),
    ('Nước ngọt Hawaiian Punch', 'Nước uống có ga', 'Lon', 'Dr. Pepper Snapple Group', 1),
    ('Nước ngọt Shasta', 'Nước uống có ga', 'Lon', 'Shasta Beverages', 1),
    ('Nước ngọt Stewart''s', 'Nước uống có ga', 'Lon', 'Stewart''s Restaurants', 1),
    ('Nước ngọt Jarritos', 'Nước uống có ga', 'Lon', 'Jarritos', 1),
    ('Nước ngọt Jones Soda', 'Nước uống có ga', 'Lon', 'Jones Soda Co.', 1);

-- Chèn dữ liệu vào bảng Customer
INSERT INTO customer (cust_name, email, phone, address)
VALUES
    ('Nguyễn Phú', 'phu@gmail.com', '111222333', '789 Oak St'),
    ('Nguyễn Quý', 'quy@gmail.com', '444555666', '987 Pine St');

-- Chèn dữ liệu vào bảng Product_Image
INSERT INTO product_image (product_id, path, alternative)
VALUES
   (1, 'images/sp1.jpg', 'Hình ảnh 1 cho Coca-Cola'),
(2, 'images/sp2.jpg', 'Hình ảnh 1 cho Fanta'),
(3, 'images/sp3.jpg', 'Hình ảnh 1 cho Pepsi'),
(4, 'images/sp4.jpg', 'Hình ảnh 1 cho 7UP'),
(5, 'images/sp5.jpg', 'Hình ảnh 1 cho Mirinda'),
(6, 'images/sp6.jpg', 'Hình ảnh 1 cho Sprite'), 
(7, 'images/sp7.jpg', 'Hình ảnh 1 cho Mountain Dew'),
(8, 'images/sp8.jpg', 'Hình ảnh 1 cho Dr. Pepper'),
(9, 'images/sp9.jpg', 'Hình ảnh 1 cho Schweppes'),
(10, 'images/sp10.jpg', 'Hình ảnh 1 cho Canada Dry'),
(11, 'images/sp11.jpg', 'Hình ảnh 1 cho Sunkist'),
(12, 'images/sp12.jpg', 'Hình ảnh 1 cho A&W'),
(13, 'images/sp13.jpg', 'Hình ảnh 1 cho Crush'),
(14, 'images/sp14.jpg', 'Hình ảnh 1 cho Barq''s'),
(15, 'images/sp15.jpg', 'Hình ảnh 1 cho Hawaiian Punch'),
(16, 'images/sp16.jpg', 'Hình ảnh 1 cho Shasta'),
(17, 'images/sp17.jpg', 'Hình ảnh 1 cho Stewart''s'),
(18, 'images/sp18.jpg', 'Hình ảnh 1 cho Jarritos'),
(19, 'images/sp19.jpg', 'Hình ảnh 1 cho Jones Soda');


-- Chèn dữ liệu vào bảng Order
INSERT INTO `orders` (order_date, emp_id, cust_id)
VALUES
    ('2023-09-20', 1, 1),
    ('2023-09-21', 2, 2),
    ('2023-09-22', 1, 2);

-- Chèn dữ liệu vào bảng Order_Detail
INSERT INTO order_detail (order_id, product_id, quantity, price, note)
VALUES
   (2, 3, 4, 8.99, 'Ghi chú cho Đơn hàng 2, Sản phẩm 3'),
    (2, 5, 2, 7.99, 'Ghi chú cho Đơn hàng 2, Sản phẩm 5'),
    (3, 1, 1, 10.99, 'Ghi chú cho Đơn hàng 3, Sản phẩm 1'),
    (3, 4, 5, 6.99, 'Ghi chú cho Đơn hàng 3, Sản phẩm 4');


INSERT INTO product_price (product_id, price_date_time, price, note)
VALUES
(1, '2023-09-20 12:00:00', 10.99, 'Giá ban đầu cho Coca-Cola'),
    (2, '2023-09-20 12:00:00', 15.99, 'Giá ban đầu cho Fanta'),
    (3, '2023-09-22 12:00:00', 9.99, 'Giá mới cho Pepsi'),
    (5, '2023-09-23 12:00:00', 8.49, 'Giá mới cho Mirinda'),
    (4, '2023-09-25 12:00:00', 7.49, 'Giá mới cho Sprite'),
    (5, '2023-09-20 12:00:00', 9.49, 'Giá ban đầu cho Mirinda'),
    (6, '2023-09-20 12:00:00', 6.99, 'Giá ban đầu cho Sprite'),
    (7, '2023-09-20 12:00:00', 8.99, 'Giá ban đầu cho Mountain Dew'),
    (8, '2023-09-20 12:00:00', 12.99, 'Giá ban đầu cho Dr. Pepper'),
    (9, '2023-09-20 12:00:00', 11.99, 'Giá ban đầu cho Schweppes'),
    (10, '2023-09-20 12:00:00', 14.99, 'Giá ban đầu cho Canada Dry'),
    (11, '2023-09-20 12:00:00', 13.99, 'Giá ban đầu cho Sunkist'),
    (12, '2023-09-20 12:00:00', 10.49, 'Giá ban đầu cho A&W'),
    (13, '2023-09-20 12:00:00', 9.49, 'Giá ban đầu cho Crush'),
    (14, '2023-09-20 12:00:00', 7.49, 'Giá ban đầu cho Barq''s'),
    (15, '2023-09-20 12:00:00', 8.49, 'Giá ban đầu cho Hawaiian Punch'),
    (16, '2023-09-20 12:00:00', 6.49, 'Giá ban đầu cho Shasta'),
    (17, '2023-09-20 12:00:00', 5.49, 'Giá ban đầu cho Stewart''s'),
    (18, '2023-09-20 12:00:00', 10.49, 'Giá ban đầu cho Jarritos'),
    (19, '2023-09-20 12:00:00', 9.49, 'Giá ban đầu cho Jones Soda');
    
