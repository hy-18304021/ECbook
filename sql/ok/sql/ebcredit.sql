CREATE TABLE ebcredit(
  user_id     VARCHAR2(30) NOT NULL,
  card_name  VARCHAR2(30)     NOT NULL,
  card_number  VARCHAR2(16)  ,
  security_number   VARCHAR2(3)  NOT NULL,
  card_expiration    VARCHAR2(11)     NOT NULL,

  CONSTRAINT  pk_ebcredit       PRIMARY KEY(card_number),
  CONSTRAINT  fk_ebcredit_user_id FOREIGN KEY(user_id) references EBUSER(id),
);

/*insert into ebbook (book_isbn,genre_id)values(
'9784798125831',
''
);*/
commit;
exit
