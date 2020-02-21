drop sequence address_id_seq;
drop sequence sales_id_seq;
drop sequence arrival_id_seq;
drop sequence genre_id_seq;
create sequence address_id_seq;
create sequence sales_id_seq;
create sequence arrival_id_seq;
create sequence genre_id_seq;
DROP TABLE ebarrival;
DROP TABLE ebsales_ref;
DROP TABLE ebsales;
DROP TABLE ebreview;
DROP TABLE ebfavorite;
DROP TABLE ebcart;
DROP TABLE ebbook;
DROP TABLE ebgenre;
DROP TABLE ebcredit;
DROP TABLE ebaddress;
DROP TABLE ebuser;
CREATE TABLE ebuser(
  id    VARCHAR2(100),
  name  VARCHAR2(100)     NOT NULL,
  pass  VARCHAR2(255)     NOT NULL,
  mail  VARCHAR2(30)      NOT NULL,
  sex   NUMBER(1)         DEFAULT 0,
  birth DATE              NOT NULL,
  CONSTRAINT  pk_ebuser   PRIMARY KEY(id)
);
CREATE TABLE EBADDRESS(
  address_id     NUMBER(10) DEFAULT address_id_seq.nextval,
  user_id  VARCHAR2(30)     NOT NULL,
  receiver_name  VARCHAR2(100)  NOT NULL,
  postal_code   NUMBER(7)  NOT NULL,
  address    VARCHAR2(150)     NOT NULL,
  tel      VARCHAR2(11) NOT NULL,
  CONSTRAINT  pk_ebaddress_address_id   PRIMARY KEY(address_id),
  CONSTRAINT  fk_ebaddress_user_id FOREIGN KEY(user_id) references EBUSER(id)
);
CREATE TABLE ebcredit(
  user_id     VARCHAR2(30) NOT NULL,
  card_name  VARCHAR2(30)     NOT NULL,
  card_number  VARCHAR2(16)  ,
  security_number   VARCHAR2(3)  NOT NULL,
  card_expiration    VARCHAR2(11)     NOT NULL,
  CONSTRAINT  pk_ebcredit       PRIMARY KEY(card_number),
  CONSTRAINT  fk_ebcredit_user_id FOREIGN KEY(user_id) references EBUSER(id)
);
CREATE TABLE ebgenre(
  genre_id     NUMBER(3) DEFAULT genre_id_seq.nextval,
  genre_name  VARCHAR2(36)     NOT NULL,
  CONSTRAINT  pk_ebgenre       PRIMARY KEY(genre_id)
);
CREATE TABLE ebbook(
  book_amount   NUMBER(4)     DEFAULT 0,
  book_price    NUMBER(6)     NOT NULL,
  genre_id      NUMBER(3)     NOT NULL,
  book_isbn     VARCHAR2(13)  NOT NULL,
  book_name     VARCHAR2(100) NOT NULL,
  publisher     VARCHAR2(100) NOT NULL,
  series        VARCHAR2(100),
  volume        NUMBER(3),
  author        VARCHAR2(100) NOT NULL,
  release_date  DATE          NOT NULL,
  audience      VARCHAR2(100),
  label         VARCHAR2(100),
  text_content  VARCHAR2(4000),
  CONSTRAINT  ck_ebbook_book_amount
  CHECK(book_amount>=0),
  CONSTRAINT  fk_ebbook_genre_id
  FOREIGN KEY(genre_id) REFERENCES EBGENRE(genre_id),
  CONSTRAINT  pk_ebbook
  PRIMARY KEY(book_isbn)
);
CREATE TABLE ebcart(
  user_id     VARCHAR2(20) NOT NULL,
  book_isbn  VARCHAR2(13)     NOT NULL,
  cart_amount  NUMBER(4)  DEFAULT 1,
  CONSTRAINT  fk_ebcart_user_id  FOREIGN KEY(user_id) references EBUSER(id),
  CONSTRAINT  fk_ebcart_book_isbn FOREIGN KEY(book_isbn) references EBBOOK(book_isbn),
  CONSTRAINT  uq_ebcart_user_id UNIQUE(user_id,book_isbn)
);
CREATE TABLE EBFAVORITE(
  user_id	VARCHAR2(30) NOT NULL,
  book_isbn	VARCHAR2(13)    NOT NULL,
  CONSTRAINT  uq_ebfavorite_user_id UNIQUE(user_id,book_isbn),
  CONSTRAINT  fk_ebfavorite_user_id FOREIGN KEY(user_id) references EBUSER(id),
  CONSTRAINT  fk_ebfavorite_book_isbn FOREIGN KEY(book_isbn) references EBBOOK(book_isbn)
);
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
CREATE TABLE ebsales(
  sales_id      NUMBER(10)        DEFAULT sales_id_seq.nextval,
  user_id       VARCHAR2(30)      NOT NULL,
  sales_date    date              DEFAULT sysdate,
  address_id    NUMBER(10)        NOT NULL,
  pay_method    VARCHAR2(100)     DEFAULT 'カード決済',
  CONSTRAINT  pk_ebsales_sales       PRIMARY KEY(sales_id),
  CONSTRAINT  fk_ebsales_user_id        FOREIGN KEY(user_id) REFERENCES ebuser(id),
  CONSTRAINT  fk_ebsales_address_id     FOREIGN KEY(address_id) REFERENCES ebaddress(address_id)
);
CREATE TABLE ebsales_ref(
  sales_id      NUMBER(10)       NOT NULL,
  book_isbn     VARCHAR2(13)     NOT NULL,
  sales_amount  NUMBER(4)        NOT NULL,
  CONSTRAINT  uq_ebsales_ref_sales       UNIQUE(sales_id,book_isbn),
  CONSTRAINT  fk_ebsales_ref_sales_id       FOREIGN KEY(sales_id) REFERENCES EBsales(sales_id),
  CONSTRAINT  fk_ebsales_ref_book_isbn      FOREIGN KEY(book_isbn) REFERENCES EBbook(book_isbn)
);
CREATE TABLE ebarrival(
  arrival_id     NUMBER(10)    DEFAULT arrival_id_seq.nextval,
  arrival_price  NUMBER(7)     NOT NULL,
  book_isbn  VARCHAR2(13)      ,
  arrival_amount   NUMBER(4)   NOT NULL,
  CONSTRAINT  pk_ebarrival_arrival       PRIMARY KEY(arrival_id),
  CONSTRAINT  fk_ebarrival_book_isbn        FOREIGN KEY(book_isbn) REFERENCES ebbook(book_isbn)
);
insert into ebuser values(
  'watashidesu',
  '私',
  'mypass',
  'mail@mail.com',
  1,
  '2000/11/20'
);
commit;
insert into ebgenre values(
  default,
  '少年コミック'
);
exit;
exit
