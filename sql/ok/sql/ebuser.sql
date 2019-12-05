CREATE TABLE ebuser(
  id    VARCHAR2(100),
  name  VARCHAR2(100)     NOT NULL,
  pass  VARCHAR2(255)     NOT NULL,
  mail  VARCHAR2(30)      NOT NULL,
  sex   NUMBER(1)         DEFAULT 0,
  birth DATE              NOT NULL,
  CONSTRAINT  pk_ebuser   PRIMARY KEY(id)
);
insert into ebuser values(
  'watashidesu',
  'Ž„',
  'mypass',
  'mail@mail.com',
  1,
  '2000/11/20'
);
commit;
