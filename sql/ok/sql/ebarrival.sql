CREATE TABLE ebarrival(
  arrival_id     NUMBER(10)    DEFAULT arrival_id_seq.nextval,
  arrival_price  NUMBER(7)     NOT NULL,
  book_isbn  VARCHAR2(13)      ,
  arrival_amount   NUMBER(4)   NOT NULL,
  CONSTRAINT  pk_ebarrival_arrival       PRIMARY KEY(arrival_id),
  CONSTRAINT  fk_ebarrival_book_isbn        FOREIGN KEY(book_isbn) REFERENCES ebbook(book_isbn)
);
