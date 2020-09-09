CREATE DATABASE jwd_banca_digital
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
 
 CREATE TABLE public.cliente
(
    id serial,
    nombres character varying(100) NOT NULL,
    documento character varying(15) NOT NULL,
    fecha_nacimiento date NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (id),
    CONSTRAINT cliente_uc_documento UNIQUE (documento)
)

TABLESPACE pg_default;

ALTER TABLE public.cliente
    OWNER to postgres;