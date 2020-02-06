call StartOracle.bat
cd loader/ldr
sqlldr ebtest/ebpass@orcl control='EBUSER_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBADDRESS_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBCREDIT_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBGENRE_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBBOOK_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBCART_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBFAVORITE_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBREVIEW_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBSALES_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBSALES_REF_DATA_TABLE.ctl'
sqlldr ebtest/ebpass@orcl control='EBARRIVAL_DATA_TABLE.ctl'
sqlplus -s ebtest/ebpass@orcl