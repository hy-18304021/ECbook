call StartOracle.bat
sqlplus -s / as sysdba/orcl@orcl @testusercreate.sql
call sqlComposite.bat
sqlplus -s ebtest/ebpass@orcl @composite.sql
sqlplus -s ebtest/ebpass@orcl
