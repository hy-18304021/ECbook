CREATE TABLE ebgenre(
  genre_id     NUMBER(3) DEFAULT genre_id_seq.nextval,
  genre_name  VARCHAR2(36)     NOT NULL,
  CONSTRAINT  pk_ebgenre       PRIMARY KEY(genre_id)
);
