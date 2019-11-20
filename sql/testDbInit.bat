sqlplus -s / as sysdba/orcl@orcl DROP USER ebtest CASCADE;
CREATE USER ebtest
   IDENTIFIED BY ebpass
   DEFAULT TABLESPACE users
   TEMPORARY TABLESPACE temp
   QUOTA 100M ON USERS;   
GRANT CREATE SESSION,CREATE TABLE,CREATE SEQUENCE,CREATE VIEW,CREATE ANY INDEX TO EBTEST;
conn ebtest/ebpass
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
insert into ebuser values(
'watashidesu',
'‚í‚½‚µ',
'mypass',
'mail@mail.com',
1,
'2000/11/20'
);
exit 

