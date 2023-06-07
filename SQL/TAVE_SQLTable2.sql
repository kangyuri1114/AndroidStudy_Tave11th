CREATE TABLE STUDENT 
( 
    ST_ID         INT    IDENTITY (1, 1)	NOT NULL,
    ST_NAME    VARCHAR(20)    NOT NULL,
    HIRE_YMD         DATE    NOT NULL,
    TL_CODE         INT    NOT NULL,
	PRIMARY KEY (ST_ID)
	 FOREIGN KEY (TL_CODE) REFERENCES TEAM_LEADER(TL_CODE)
    
); 

INSERT INTO 	STUDENT (ST_ID, ST_NAME, HIRE_YMD, TL_CODE)
     VALUES 	(1, 'kangyuri1114', '2023-03-18', 101);
     
INSERT INTO 	STUDENT (ST_ID, ST_NAME, HIRE_YMD, TL_CODE)
     VALUES 	(2, 'seogaeun', '2023-03-18', 101);
     
INSERT INTO 	STUDENT (ST_ID, ST_NAME, HIRE_YMD, TL_CODE)
     VALUES 	(3, 'sxmvx', '2023-03-18', 102);
     
INSERT INTO 	STUDENT (ST_ID, ST_NAME, HIRE_YMD, TL_CODE)
     VALUES 	(4, 'arinming', '2023-03-18', 102);