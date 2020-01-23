CREATE TABLE EBFAVORITE(
  user_id	VARCHAR2(30) NOT NULL,
  book_isbn	VARCHAR2(13)    NOT NULL,
  CONSTRAINT  uq_ebfavorite_user_id UNIQUE(user_id,book_isbn),
  CONSTRAINT  fk_ebfavorite_user_id FOREIGN KEY(user_id) references EBUSER(id),
  CONSTRAINT  fk_ebfavorite_book_isbn FOREIGN KEY(book_isbn) references EBBOOK(book_isbn)
);
