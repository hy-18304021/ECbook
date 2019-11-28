DROP TABLE ebbook;
CREATE TABLE ebbook(
  book_id     NUMBER(7),
  book_count  NUMBER(4)     DEFAULT 0,
  book_image  VARCHAR2(40)  ,
  book_isbn   VARCHAR2(13)  NOT NULL,
  genre_id    NUMBER(4)     NOT NULL,

  CONSTRAINT  pk_ebbook       PRIMARY KEY(book_id),
  CONSTRAINT  ck_ebbook_count CHECK(book_count>=0),
  CONSTRAINT  fk_ebbook_isbn  FOREIGN KEY(book_isbn) REFERENCES ISBN_DATA(book_isbn),
  CONSTRAINT  fk_ebbook_genre_id   FOREIGN KEY(genre_id) REFERENCES EBGENRE_S(small_genre_id),
);

insert into ebbook values(
'watashidesu',
'わたし',
'mypass',
'mail@mail.com',
1,
'2000/11/20'
);
commit;
exit
