INSERT INTO Products (name, description, unit_price, stock_quantity, rating, product_category_id, product_status_id, brand_id, material_id)
VALUES
    ('Tenis GEF Ultra SkyLine', 'Descrição do Ultra SkyLine', 129.99, 50, 4, 1, 1, 1, 1),
    ('Tenis GEF Premium Originals', 'Descrição do Premium Originals', 149.99, 30, 5, 2, 1, 2, 1),
    ('Tenis Yellow Garden', 'Descrição do Yellow Garden', 99.99, 20, 4, 3, 1, 3, 2),
    ('Tenis Warrior Man', 'Descrição do Warrior Man', 79.99, 40, 3, 1, 2, 1, 3),
    ('Tenis GEF Hype', 'Descrição do GEF Hype', 119.99, 25, 4, 2, 1, 2, 2),
    ('Tenis GEF Ultraboost Light', 'Descrição do Ultraboost Light', 169.99, 15, 5, 1, 1, 1, 3),
    ('Tenis GEF Hype One', 'Descrição do GEF Hype One', 139.99, 35, 4, 3, 2, 2, 1),
    ('Tenis GEF Pink', 'Descrição do Pink', 89.99, 10, 3, 1, 1, 3, 2),
    ('Tenis GEF Red', 'Descrição do Red', 99.99, 30, 4, 2, 2, 1, 3),
    ('Tenis GEF Bow', 'Descrição do Bow', 109.99, 20, 4, 3, 1, 2, 1),
    ('Tenis GEF Hype Premiere', 'Descrição do Hype Premiere', 159.99, 15, 5, 1, 1, 3, 2),
    ('Tenis GEF Hype', 'Descrição do GEF Hype', 119.99, 25, 4, 2, 1, 2, 2),
    ('Tenis GEF Ultraboost Light', 'Descrição do Ultraboost Light', 169.99, 15, 5, 1, 1, 1, 3),
    ('Tenis Yellow Garden', 'Descrição do Yellow Garden', 99.99, 20, 4, 3, 1, 3, 2),
    ('Tenis Warrior Man', 'Descrição do Warrior Man', 79.99, 40, 3, 1, 2, 1, 3),
    ('Tenis GEF Hype One', 'Descrição do GEF Hype One', 139.99, 35, 4, 3, 2, 2, 1),
    ('Tenis GEF Pink', 'Descrição do Pink', 89.99, 10, 3, 1, 1, 3, 2),
    ('Tenis GEF Red', 'Descrição do Red', 99.99, 30, 4, 2, 2, 1, 3),
    ('Tenis GEF Bow', 'Descrição do Bow', 109.99, 20, 4, 3, 1, 2, 1),
    ('Tenis GEF Hype Premiere', 'Descrição do Hype Premiere', 159.99, 15, 5, 1, 1, 3, 2)
;


INSERT INTO Categories (category)
VALUES
    ('Feminino'),
    ('Masculino'),
    ('Infantil'),
    ('Mundo GEF'),
    ('Esportes');


INSERT INTO Colors (color)
VALUES
    ('Branco'),
    ('Preto'),
    ('Azul'),
    ('Vermelho'),
    ('Verde'),
    ('Amarelo'),
    ('Rosa'),
    ('Cinza'),
    ('Marrom'),
    ('Laranja');


INSERT INTO Product_Colors (color_id, product_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);


INSERT INTO Segmentations (segmentation)
VALUES
    ('Masculino'),
    ('Feminino'),
    ('Infantil');


INSERT INTO Product_Segmentations (segmentation_id, product_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);


INSERT INTO Segmentation_Categories (segmentation_id, category_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);



INSERT INTO Materials (material)
VALUES
    ('Couro'),
    ('Borracha'),
    ('Mesh'),
    ('Sintético'),
    ('Tecido'),
    ('Cetim'),
    ('Lona'),
    ('Plástico'),
    ('Camurça'),
    ('Neoprene');


INSERT INTO Brands (brand)
VALUES
    ('Nike'),
    ('Adidas'),
    ('Puma'),
    ('Vans'),
    ('Reebok'),
    ('Converse'),
    ('New Balance'),
    ('Asics'),
    ('Fila'),
    ('Under Armour');


INSERT INTO Sizes (size)
VALUES
    ('18'),
    ('19'),
    ('20'),
    ('21'),
    ('22'),
    ('23'),
    ('24'),
    ('25'),
    ('26'),
    ('27'),
    ('28'),
    ('29'),
    ('30'),
    ('31'),
    ('32'),
    ('33'),
    ('34'),
    ('35'),
    ('36'),
    ('37'),
    ('38'),
    ('39'),
    ('40'),
    ('41'),
    ('42'),
    ('43'),
    ('44'),
    ('45'),
    ('46'),
    ('47'),
    ('48'),
    ('49');

INSERT INTO Product_Sizes (quantity, size_id, product_id) VALUES
                                                              (50, 1, 1),
                                                              (30, 2, 1),
                                                              (40, 1, 2),
                                                              (20, 3, 2);