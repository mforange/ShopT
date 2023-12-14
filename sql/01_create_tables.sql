create table if not exists t_products
(
    id    BIGSERIAL PRIMARY KEY,
    type  text,
    name  text,
    price double precision
);


insert into t_products values()