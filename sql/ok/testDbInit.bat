set oracle_sid = orcl
net start OracleVssWriterORCL
net start OracleOraDB12Home1MTSRecoveryService
net start OracleOraDB12Home1TNSListener
net start OracleServiceORCL

cd sql
for /f %%a in (sqlfilelist.txt) do (
  sqlplus -s ebtest/ebpass@orcl @%%a.sql
)

sqlplus -s ebtest/ebpass@orcl