CREATE TABLE accounts (
    id UUID NOT NULL,
    email varchar(256) UNIQUE NOT NULL,
    password varchar(100) NOT NULL,
    CONSTRAINT account_id PRIMARY KEY (id)
);

-- CREATE TABLE Addresses (
--     id serial  NOT NULL,
--     zip_code varchar(8)  NOT NULL,
--     state varchar(20)  NOT NULL,
--     city varchar(40)  NOT NULL,
--     street varchar(50)  NOT NULL,
--     neighborhood varchar(50)  NOT NULL,
--     number varchar(10)  NULL,
--     complement varchar(50)  NULL,
--     main_address boolean  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT address_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Brands (
--     id serial  NOT NULL,
--     brand varchar(30)  NOT NULL,
--     CONSTRAINT brand_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Cart_Products (
--     id serial  NOT NULL,
--     quantity int  NOT NULL,
--     cart_id int  NOT NULL,
--     product_id int  NOT NULL,
--     CONSTRAINT cart_product_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Carts (
--     id serial  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT cart_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Categories (
--     id serial  NOT NULL,
--     category varchar(30)  NOT NULL,
--     CONSTRAINT category_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Colors (
--     id serial  NOT NULL,
--     color varchar(20)  NOT NULL,
--     CONSTRAINT color_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Credit_Cards (
--     id serial  NOT NULL,
--     holder_name varchar(50)  NOT NULL,
--     number varchar(16)  NOT NULL,
--     expiration_date date  NOT NULL,
--     cvv varchar(3)  NOT NULL,
--     main_credit_card boolean  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT credit_card_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Cupom_Status (
--     id serial  NOT NULL,
--     status varchar(20)  NOT NULL,
--     CONSTRAINT cupom_status_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Cupons (
--     id serial  NOT NULL,
--     code varchar(30)  NOT NULL,
--     discount decimal(4,2)  NOT NULL,
--     expiration_date date  NOT NULL,
--     CONSTRAINT cupom_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Customer_Cupons (
--     id serial  NOT NULL,
--     status_cupom_id int  NOT NULL,
--     cupom_id int  NOT NULL,
--     customer_id int  NOT NULL,
--     order_id int  NULL,
--     CONSTRAINT customer_cupom_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Customers (
--     id serial  NOT NULL,
--     cpf varchar(11) UNIQUE NOT NULL,
--     first_name varchar(30)  NOT NULL,
--     last_name varchar(30)  NOT NULL,
--     CONSTRAINT customer_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Items (
--     id serial  NOT NULL,
--     quantity int  NOT NULL,
--     unit_price decimal(8,2)  NOT NULL,
--     product_id int  NOT NULL,
--     order_id int  NOT NULL,
--     CONSTRAINT item_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Materials (
--     id serial  NOT NULL,
--     material varchar(30)  NOT NULL,
--     CONSTRAINT material_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Order_Payments (
--     id serial  NOT NULL,
--     payment varchar(25)  NOT NULL,
--     CONSTRAINT order_payment_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Order_Reviews (
--     id serial  NOT NULL,
--     rating smallint  NOT NULL,
--     text varchar(256)  NULL,
--     order_id int  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT order_review_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Order_Status (
--     id serial  NOT NULL,
--     status varchar(25)  NOT NULL,
--     CONSTRAINT order_status_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Orders (
--     id serial  NOT NULL,
--     tracking_code varchar(30)  NOT NULL,
--     total_price decimal(10,2)  NOT NULL,
--     order_date timestamp  NOT NULL,
--     order_status_id int  NOT NULL,
--     payment_id int  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT order_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Phones (
--     id serial  NOT NULL,
--     phone_number varchar(12)  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT phone_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Preference_Brands (
--     id serial  NOT NULL,
--     preference_id int  NOT NULL,
--     brand_id int  NOT NULL,
--     CONSTRAINT preference_brand_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Preference_Categories (
--     id serial  NOT NULL,
--     preference_id int  NOT NULL,
--     category_id int  NOT NULL,
--     CONSTRAINT preference_category_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Preference_Colors (
--     id serial  NOT NULL,
--     preference_id int  NOT NULL,
--     color_id int  NOT NULL,
--     CONSTRAINT preference_color_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Preference_Materials (
--     id serial  NOT NULL,
--     preference_id int  NOT NULL,
--     material_id int  NOT NULL,
--     CONSTRAINT preference_material_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Preference_Segmentations (
--     id serial  NOT NULL,
--     preference_id int  NOT NULL,
--     segmentation_id int  NOT NULL,
--     CONSTRAINT preference_segmentation_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Preferences (
--     id serial  NOT NULL,
--     age smallint  NOT NULL,
--     shoe_size varchar(2)  NOT NULL,
--     min_price decimal(8,2)  NOT NULL,
--     max_price decimal(8,2)  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT preference_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Product_Colors (
--     id serial  NOT NULL,
--     color_id int  NOT NULL,
--     product_id int  NOT NULL,
--     CONSTRAINT product_color_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Product_Reviews (
--     id serial  NOT NULL,
--     rating smallint  NOT NULL,
--     title varchar(30)  NULL,
--     text varchar(256)  NULL,
--     product_id int  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT product_review_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Product_Segmentations (
--     id serial  NOT NULL,
--     segmentation_id int  NOT NULL,
--     product_id int  NOT NULL,
--     CONSTRAINT product_segmentation_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Product_Sizes (
--     id serial  NOT NULL,
--     quantity int  NOT NULL,
--     size_id int  NOT NULL,
--     product_id int  NOT NULL,
--     CONSTRAINT product_size_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Product_Status (
--     id serial  NOT NULL,
--     status varchar(25)  NOT NULL,
--     CONSTRAINT product_status_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Products (
--     id serial  NOT NULL,
--     name varchar(60)  NOT NULL,
--     description varchar(256)  NOT NULL,
--     unit_price decimal(8,2)  NOT NULL,
--     stock_quantity int  NOT NULL,
--     rating int  NULL,
--     picture bytea  NULL,
--     product_category_id int  NOT NULL,
--     product_status_id int  NOT NULL,
--     brand_id int  NOT NULL,
--     material_id int  NOT NULL,
--     CONSTRAINT product_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Segmentation_Categories (
--     id serial  NOT NULL,
--     segmentation_id int  NOT NULL,
--     category_id int  NOT NULL,
--     CONSTRAINT segmentation_category_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Segmentations (
--     id serial  NOT NULL,
--     segmentation varchar(30)  NOT NULL,
--     CONSTRAINT segmentation_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Sizes (
--     id serial  NOT NULL,
--     size varchar(10)  NOT NULL,
--     CONSTRAINT size_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Wishlist_Products (
--     id serial  NOT NULL,
--     wishlist_id int  NOT NULL,
--     product_id int  NOT NULL,
--     CONSTRAINT whishlist_product_id PRIMARY KEY (id)
-- );

-- CREATE TABLE Wishlists (
--     id serial  NOT NULL,
--     customer_id int  NOT NULL,
--     CONSTRAINT wishlist_id PRIMARY KEY (id)
-- );

-- ALTER TABLE Accounts ADD CONSTRAINT Accounts_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Addresses ADD CONSTRAINT Addresses_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Cart_Products ADD CONSTRAINT Cart_Products_Carts
--     FOREIGN KEY (cart_id)
--     REFERENCES Carts (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Cart_Products ADD CONSTRAINT Cart_Products_Products
--     FOREIGN KEY (product_id)
--     REFERENCES Products (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Carts ADD CONSTRAINT Carts_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Credit_Cards ADD CONSTRAINT Credit_Cards_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Customer_Cupons ADD CONSTRAINT Customer_Cupons_Cupom_Status
--     FOREIGN KEY (status_cupom_id)
--     REFERENCES Cupom_Status (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Customer_Cupons ADD CONSTRAINT Customer_Cupons_Cupons
--     FOREIGN KEY (cupom_id)
--     REFERENCES Cupons (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Customer_Cupons ADD CONSTRAINT Customer_Cupons_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Customer_Cupons ADD CONSTRAINT Customer_Cupons_Orders
--     FOREIGN KEY (order_id)
--     REFERENCES Orders (id)  
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Items ADD CONSTRAINT Items_Orders
--     FOREIGN KEY (order_id)
--     REFERENCES Orders (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Items ADD CONSTRAINT Items_Products
--     FOREIGN KEY (product_id)
--     REFERENCES Products (id)
--     ON DELETE  SET NULL 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Order_Reviews ADD CONSTRAINT Order_Reviews_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  SET NULL 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Order_Reviews ADD CONSTRAINT Order_Reviews_Orders
--     FOREIGN KEY (order_id)
--     REFERENCES Orders (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Orders ADD CONSTRAINT Orders_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Orders ADD CONSTRAINT Orders_Order_Payments
--     FOREIGN KEY (payment_id)
--     REFERENCES Order_Payments (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Orders ADD CONSTRAINT Orders_Order_Status
--     FOREIGN KEY (order_status_id)
--     REFERENCES Order_Status (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Phones ADD CONSTRAINT Phones_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Brands ADD CONSTRAINT Preference_Brands_Brands
--     FOREIGN KEY (brand_id)
--     REFERENCES Brands (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Brands ADD CONSTRAINT Preference_Brands_Preferences
--     FOREIGN KEY (preference_id)
--     REFERENCES Preferences (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Categories ADD CONSTRAINT Preference_Categories_Categories
--     FOREIGN KEY (category_id)
--     REFERENCES Categories (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Categories ADD CONSTRAINT Preference_Categories_Preferences
--     FOREIGN KEY (preference_id)
--     REFERENCES Preferences (id) 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Colors ADD CONSTRAINT Preference_Colors_Colors
--     FOREIGN KEY (color_id)
--     REFERENCES Colors (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Colors ADD CONSTRAINT Preference_Colors_Preferences
--     FOREIGN KEY (preference_id)
--     REFERENCES Preferences (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Materials ADD CONSTRAINT Preference_Materials_Materials
--     FOREIGN KEY (material_id)
--     REFERENCES Materials (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Materials ADD CONSTRAINT Preference_Materials_Preferences
--     FOREIGN KEY (preference_id)
--     REFERENCES Preferences (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Segmentations ADD CONSTRAINT Preference_Segmentations_Preferences
--     FOREIGN KEY (preference_id)
--     REFERENCES Preferences (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preference_Segmentations ADD CONSTRAINT Preference_Segmentations_Segmentations
--     FOREIGN KEY (segmentation_id)
--     REFERENCES Segmentations (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Preferences ADD CONSTRAINT Preferences_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Colors ADD CONSTRAINT Product_Colors_Colors
--     FOREIGN KEY (color_id)
--     REFERENCES Colors (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Colors ADD CONSTRAINT Product_Colors_Products
--     FOREIGN KEY (product_id)
--     REFERENCES Products (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Reviews ADD CONSTRAINT Product_Reviews_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  SET NULL 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Reviews ADD CONSTRAINT Product_Reviews_Products
--     FOREIGN KEY (product_id)
--     REFERENCES Products (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Segmentations ADD CONSTRAINT Product_Segmentations_Products
--     FOREIGN KEY (product_id)
--     REFERENCES Products (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Segmentations ADD CONSTRAINT Product_Segmentations_Segmentations
--     FOREIGN KEY (segmentation_id)
--     REFERENCES Segmentations (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Sizes ADD CONSTRAINT Product_Sizes_Products
--     FOREIGN KEY (product_id)
--     REFERENCES Products (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Product_Sizes ADD CONSTRAINT Product_Sizes_Sizes
--     FOREIGN KEY (size_id)
--     REFERENCES Sizes (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Products ADD CONSTRAINT Products_Brands
--     FOREIGN KEY (brand_id)
--     REFERENCES Brands (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Products ADD CONSTRAINT Products_Categories
--     FOREIGN KEY (product_category_id)
--     REFERENCES Categories (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Products ADD CONSTRAINT Products_Materials
--     FOREIGN KEY (material_id)
--     REFERENCES Materials (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Products ADD CONSTRAINT Products_Status_Products
--     FOREIGN KEY (product_status_id)
--     REFERENCES Product_Status (id)
--     ON DELETE  RESTRICT 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Segmentation_Categories ADD CONSTRAINT Segmentation_Categories_Categories
--     FOREIGN KEY (category_id)
--     REFERENCES Categories (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Segmentation_Categories ADD CONSTRAINT Segmentation_Categories_Segmentations
--     FOREIGN KEY (segmentation_id)
--     REFERENCES Segmentations (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Wishlist_Products ADD CONSTRAINT Wishlist_Products_Products
--     FOREIGN KEY (product_id)
--     REFERENCES Products (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Wishlist_Products ADD CONSTRAINT Wishlist_Products_Wishlists
--     FOREIGN KEY (wishlist_id)
--     REFERENCES Wishlists (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;

-- ALTER TABLE Wishlists ADD CONSTRAINT Wishlists_Customers
--     FOREIGN KEY (customer_id)
--     REFERENCES Customers (id)
--     ON DELETE  CASCADE 
--     ON UPDATE  CASCADE 
--     NOT DEFERRABLE 
--     INITIALLY IMMEDIATE
-- ;
