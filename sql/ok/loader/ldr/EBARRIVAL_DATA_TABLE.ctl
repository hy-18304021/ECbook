OPTIONS (ERRORS=50)
LOAD DATA 
INFILE 'C:\ECbook\sql\ok\loader\ldr\EBARRIVAL_DATA_TABLE.ldr' "str '\r\n'"
APPEND
CONTINUEIF NEXT(1:1) = '#'
INTO TABLE "EBTEST"."EBARRIVAL"
FIELDS TERMINATED BY','
OPTIONALLY ENCLOSED BY '"' AND '"'
TRAILING NULLCOLS ( 
"ARRIVAL_ID" ,
"ARRIVAL_PRICE" ,
"BOOK_ISBN" CHAR (13),
"ARRIVAL_AMOUNT" )
