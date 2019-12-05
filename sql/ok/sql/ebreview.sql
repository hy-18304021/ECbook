CREATE TABLE ebreview(
  book_isbn     VARCHAR2(13)    ,
  user_id       VARCHAR2(30)    ,
  review_text   VARCHAR2(4000)  NOT NULL,
  review_star   NUMBER(1)       NOT NULL,
  review_date   date            default sysdate,
  CONSTRAINT  pk_ebreview_ebview            PRIMARY KEY(book_isbn,user_id),
  CONSTRAINT  fk_ebreview_book_isbn         FOREIGN KEY(book_isbn) REFERENCES ebbook(book_isbn),
  CONSTRAINT  fk_ebreview_user_id           FOREIGN KEY(user_id) REFERENCES ebuser(id)
);
