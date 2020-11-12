/*개발 환경에만 있는 테이블 실행 -> 운영환경일시 에러 발생 쿼리실행을 막는다.*/
SELECT * 
FROM NOT_EXISTS_IN_PRD;

/*DELETE users; 파일을 다 날린다음 다시 데이터를 넣어준다.*/
TRUNCATE TABLE users;

Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('2020/10/21','YYYY/MM/DD'),'곰2',null,null,null,'D:\profile\6fdeed16-e6ac-4096-8da2-d176be9f151f.png','brown.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('2020/10/21','YYYY/MM/DD'),'토끼',null,null,null,'D:\profile\cony.png','cony.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('2020/10/21','YYYY/MM/DD'),'병아리',null,null,null,'D:\profile\sally.png','sally.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('2020/10/21','YYYY/MM/DD'),'사람',null,null,null,'D:\upload\james.png','james.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',to_date('2020/11/10','YYYY/MM/DD'),'달',null,null,null,'D:\upload\moon.png','moon.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('leonard','레너드','leonardPass',to_date('2020/10/15','YYYY/MM/DD'),'개구리',null,null,null,'D:\upload\leonard.png','leonard.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('edward','에드워드','edwardPass',to_date('2020/10/15','YYYY/MM/DD'),'애벌레',null,null,null,'D:\upload\edward.png','edward.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('jessica','제시카','jessicaPass',to_date('2020/10/15','YYYY/MM/DD'),'고양이',null,null,null,'D:\upload\jessica','jessica');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('boss','보스','bossPass',to_date('2020/10/15','YYYY/MM/DD'),'사람',null,null,null,'D:\upload\boss.png','boss.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('choco','초코','chocoPass',to_date('2020/10/15','YYYY/MM/DD'),'곰2',null,null,null,'D:\upload\choco.jpg','choco.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pangyo','팡요','pangyoPass',to_date('2020/10/15','YYYY/MM/DD'),'판다',null,null,null,'D:\upload\pangyo.jpg','pangyo.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('muzi','무지','muziPass',to_date('2020/10/15','YYYY/MM/DD'),'토끼',null,null,null,'D:\upload\muzi.png','muzi.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('con','콘','conPass',to_date('2020/10/15','YYYY/MM/DD'),'악어',null,null,null,'D:\upload\conn.png','conn.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('apeach','어피치','apeachPass',to_date('2020/10/15','YYYY/MM/DD'),'복숭아','서울 강남구 봉은사로 404','ap','06153','D:\upload\apeach.png','apeach.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ryan','라이언 ','ryanPass',to_date('2020/10/15','YYYY/MM/DD'),'사자',null,null,null,'D:\upload\ryan.png','ryan.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('asd','asd','asd',to_date('2020/11/05','YYYY/MM/DD'),'asd','서울 강남구 봉은사로 403','ㅁㄴㅇ','06097',null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('테스트','테스트','qwe',to_date('2020/11/05','YYYY/MM/DD'),'테스트','서울 강남구 삼성로 38','영민빌딩 404호','06329','9c9e4a69-1cba-48ef-bb12-192d405367de',null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('aaaa','박주영^^','1234',to_date('2020/10/22','YYYY/MM/DD'),'주영','경기 성남시 분당구 판교역로 235','영민빌딩 404호','13494',null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('박주영','박주영','qkrwndud',to_date('2020/11/05','YYYY/MM/DD'),'박주영','서울 강남구 봉은사로 409','asd','06097','6e9e9beb-6ed2-4fc5-8647-0de086428b79','ryan.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('민','준','wns',to_date('2020/11/05','YYYY/MM/DD'),'쭈니','서울 강남구 남부순환로 2907','고속도로','06281','D:\upload\frodo.png','frodo.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('스누피','FAILTEST','pass',to_date('2020/11/11','YYYY/MM/DD'),'우롱차',null,null,null,null,null);

COMMIT;

