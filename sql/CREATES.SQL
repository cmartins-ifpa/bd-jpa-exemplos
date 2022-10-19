
	CREATE TABLE PESSOA (
	 ID   	IDENTITY NOT NULL PRIMARY KEY ,  -- ⬅ `identity` = auto-incrementing long integer.
	 NOME 	VARCHAR(60),
	 CIDADE VARCHAR(30),
	 UF   	VARCHAR(2)
	);