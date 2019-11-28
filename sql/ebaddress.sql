DROP TABLE EBADDRESS;
CREATE TABLE EBADDRESS(
  address_id     NUMBER(10) DEFAULT address_id_seq.nextval,
  user_id  VARCHAR2(30)     NOT NULL,
  receiver_name  VARCHAR2(100)  NOT NULL,
  postal_code   NUMBER(7)  NOT NULL,
  address    VARCHAR2()     NOT NULL,
  tel      VARCHAR2(11) NOT NULL

  CONSTRAINT  pk_ebaddress_address_id   PRIMARY KEY(address_id),
  CONSTRAINT  fk_ebaddress_user_id FOREIGN KEY(user_id) references EBUSER(id),
);

/*insert into ebbook (book_isbn,genre_id)values(
'9784798125831',
''
);*/
commit;
exit
