DROP TABLE ebsales_ref;
CREATE TABLE ebsales_ref(
  sales_id      NUMBER(10)       NOT NULL,
  book_isbn     VARCHAR2(13)     NOT NULL,
  sales_amount  NUMBER(4)        NOT NULL,
  
  CONSTRAINT  uq_ebsales_ref_sales       UNIQUE(sales_id,book_isbn),
  CONSTRAINT  fk_ebsales_ref_sales_id       FOREIGN KEY(sales_id) REFERENCES EBsales(sales_id),
  CONSTRAINT  fk_ebsales_ref_book_isbn      FOREIGN KEY(book_isbn) REFERENCES EBbook(book_isbn)
);

/*insert into ebbook (sales_id,book_isbn,sales_amount)values(
1,
'9784798125831',
1
);*/
commit;
exit
