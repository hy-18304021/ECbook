OPTIONS (ERRORS=50)
LOAD DATA 
INFILE 'EBFAVORITE_DATA_TABLE.ldr' "str '\r\n'"
APPEND
CONTINUEIF NEXT(1:1) = '#'
INTO TABLE "EBTEST"."EBFAVORITE"
FIELDS TERMINATED BY','
OPTIONALLY ENCLOSED BY '"' AND '"'
TRAILING NULLCOLS ( 
"USER_ID" CHAR (30),
"BOOK_ISBN" CHAR (13))
