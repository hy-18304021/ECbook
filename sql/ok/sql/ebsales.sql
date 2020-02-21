CREATE TABLE ebsales(
  sales_id      NUMBER(10)        DEFAULT sales_id_seq.nextval,
  user_id       VARCHAR2(30)      NOT NULL,
  sales_date    date              DEFAULT sysdate,
  address_id    NUMBER(10)        NOT NULL,
  pay_method    VARCHAR2(100)     DEFAULT 'ÉJÅ[Éhåàçœ',
  CONSTRAINT  pk_ebsales_sales       PRIMARY KEY(sales_id),
  CONSTRAINT  fk_ebsales_user_id        FOREIGN KEY(user_id) REFERENCES ebuser(id),
  CONSTRAINT  fk_ebsales_address_id     FOREIGN KEY(address_id) REFERENCES ebaddress(address_id)
);
