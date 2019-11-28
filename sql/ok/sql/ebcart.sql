CREATE TABLE ebcart(
  user_id     VARCHAR2(20) NOT NULL,
  book_isbn  VARCHAR2(13)     NOT NULL,
  cart_amount  NUMBER(4)  DEFAULT 1,

  CONSTRAINT  fk_ebcart_user_id  FOREIGN KEY(user_id) references EBUSER(id),
  CONSTRAINT  fk_ebcart_book_isbn FOREIGN KEY(book_isbn) references EBBOOK(book_isbn),
  CONSTRAINT  uq_ebcart_user_id UNIQUE(user_id,book_isbn)
);

/*insert into ebcart (book_isbn,genre_id)values(
'9784798125831',
''
);*/
commit;
exit
