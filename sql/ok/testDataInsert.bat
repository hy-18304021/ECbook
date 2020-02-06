call StartOracle.bat
cd loader/ldr

cd sql
sqlplus -s ebtest/ebpass@orcl @insert.sql
sqlplus -s ebtest/ebpass@orcl