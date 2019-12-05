call StartOracle.bat
cd sql
sqlplus -s ebtest/ebpass@orcl @truncatetable.sql
sqlplus -s ebtest/ebpass@orcl