call StartOracle.bat
cd sql
sqlplus -s ebtest/ebpass@orcl @insert.sql
sqlplus -s ebtest/ebpass@orcl