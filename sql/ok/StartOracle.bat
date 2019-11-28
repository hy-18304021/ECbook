set oracle_sid = orcl
net start OracleVssWriterORCL
net start OracleOraDB12Home1MTSRecoveryService
net start OracleOraDB12Home1TNSListener
net start OracleServiceORCL
sqlplus -s ebtest/ebpass@orcl