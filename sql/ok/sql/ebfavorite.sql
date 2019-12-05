CREATE TABLE EBFAVORITE(
  user_id	VARCHAR2(30) NOT NULL,
  book_isbn	VARCHAR2(13)    NOT NULL,
  CONSTRAINT  uq_ebfavorite_user_id UNIQUE(user_id,book_isbn)
);
