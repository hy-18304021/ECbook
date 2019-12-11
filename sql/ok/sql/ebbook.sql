CREATE TABLE ebbook(
  book_amount   NUMBER(4)     DEFAULT 0,
  book_price    NUMBER(6)     NOT NULL,
  genre_id      NUMBER(3)     NOT NULL,
  book_isbn     VARCHAR2(13)  NOT NULL,
  book_name     VARCHAR2(100) NOT NULL,
  publisher     VARCHAR2(100) NOT NULL,
  series        VARCHAR2(100),
  volume        NUMBER(3),
  author        VARCHAR2(100) NOT NULL,
  release_date  DATE          NOT NULL,
  audience      VARCHAR2(100),
  label         VARCHAR2(100),
  text_content  VARCHAR2(4000),
  CONSTRAINT  ck_ebbook_book_amount
  CHECK(book_amount>=0),
  CONSTRAINT  fk_ebbook_genre_id
  FOREIGN KEY(genre_id) REFERENCES EBGENRE(genre_id),
  CONSTRAINT  pk_ebbook
  PRIMARY KEY(book_isbn)
);
