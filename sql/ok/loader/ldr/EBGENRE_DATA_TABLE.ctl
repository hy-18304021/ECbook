OPTIONS (ERRORS=50)
LOAD DATA 
INFILE 'EBGENRE_DATA_TABLE.ldr' "str '\r\n'"
APPEND
CONTINUEIF NEXT(1:1) = '#'
INTO TABLE "EBTEST"."EBGENRE"
FIELDS TERMINATED BY','
OPTIONALLY ENCLOSED BY '"' AND '"'
TRAILING NULLCOLS ( 
"GENRE_ID" ,
"GENRE_NAME" CHAR (36))
