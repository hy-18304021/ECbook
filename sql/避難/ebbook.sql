DROP TABLE ebbook;
CREATE TABLE ebbook(
  book_isbn   VARCHAR2(13)  NOT NULL,
  genre_id    NUMBER(4)     NOT NULL,

  CONSTRAINT  pk_ebbook       PRIMARY KEY(book_isbn),
  CONSTRAINT  fk_ebbook_genre_id   FOREIGN KEY(genre_id) REFERENCES EBGENRE(genre_id),
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
