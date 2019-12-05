cd sql
type nul > dammy.sql

for /f %%a in (sqlfilelist.txt) do (
  copy dammy.sql+%%a.sql composite.sql
  copy composite.sql dammy.sql
)
del dammy.sql