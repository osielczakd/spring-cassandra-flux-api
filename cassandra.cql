CREATE KEYSPACE sample WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

DELETE TABLE sample.product;

CREATE TABLE sample.product (
  sku text PRIMARY KEY,
  recommendations Map<text, int>
);