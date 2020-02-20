OPTIONS (ERRORS=50)
LOAD DATA 
INFILE 'EBBOOK_DATA_TABLE.ldr' "str '\r\n'"
APPEND
CONTINUEIF NEXT(1:1) = '#'
INTO TABLE "EBTEST"."EBBOOK"
FIELDS TERMINATED BY','
OPTIONALLY ENCLOSED BY '"' AND '"'
TRAILING NULLCOLS ( 
"BOOK_AMOUNT" ,
"BOOK_PRICE" ,
"GENRE_ID" ,
"BOOK_ISBN" CHAR (13),
"BOOK_NAME" CHAR (100),
"PUBLISHER" CHAR (100),
"SERIES" CHAR (100),
"VOLUME" ,
"AUTHOR" CHAR (100),
"RELEASE_DATE" DATE "YYYY-MM-DD HH24:MI:SS" ,
"AUDIENCE" CHAR (100),
"LABEL" CHAR (100),
"TEXT_CONTENT" CHAR (4000))
