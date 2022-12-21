--liquibase formatted sql

-- changeset grisha:1:insertSQLChangeType
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (1, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 8000, 8, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 11 Pro', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (2, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 9000, 7, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 12 Pro', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (3, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 10000, 4, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 13 Pro', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (4, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 7000, 9, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone Xs', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (5, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 6000, 1, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone X', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (6, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 5000, 5, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 8', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (7, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 4000, 8, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 7', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (8, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 3000, 8, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 6', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (9, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 2000, 90, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 5S', 500);
INSERT INTO shop.product (id, created_date, updated_date, cost, count, expiration_date, manufacturer, name, weight)
VALUES (10, '2022-12-21 18:56:01.000000', '2022-12-21 18:56:02.000000', 1000, 3, '2022-12-21 18:56:02.000000', 'Apple',
        'IPhone 4S', 500);



