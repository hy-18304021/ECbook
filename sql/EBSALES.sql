DROP TABLE ebsales;
CREATE TABLE ebsales(
  sales_id      NUMBER(10)        DEFAULT arrival_id_seq.nextval,
  user_id       VARCHAR2(30)      NOT NULL,
  sales_date    date              DEFAULT sysdate,
  address_id    NUMBER(10)        NOT NULL,
  pay_method    VARCHAR2(100)     DEFAULT 'ÉJÅ[Éhåàçœ',

  CONSTRAINT  pk_ebsales_sales       PRIMARY KEY(sales_id),
  CONSTRAINT  fk_ebsales_user_id        FOREIGN KEY(book_isbn) REFERENCES ebuser(id),
  CONSTRAINT  fk_ebsales_address_id     FOREIGN KEY(address_id) REFERENCES ebaddress(address_id)
);

/*insert into ebsales (book_isbn,genre_id)values(
'9784798125831',
''
);*/
commit;
exit
