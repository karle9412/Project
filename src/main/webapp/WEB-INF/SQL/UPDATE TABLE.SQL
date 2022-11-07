// 테이블에 칼럼 추가할 때
// ALTER TABLE 테이블명 ADD (테이블에 추가할 칼럼    데이터 타입(타입 길이));
ALTER TABLE BOARD ADD(BOARD_CHECK VARCHAR2(10));


//칼럼 유니크 변경
//ALTER TABLE 테이블명 ADD unique(unique추가할 칼럼);
ALTER TABLE BOARD ADD (BOARD_CHECK VARCHAR2(10));

ALTER TABLE 테이블명 ADD constraint 제약 조건 (추가할 칼럼);

//칼럼 외래키 지정
//ALTER TABLE 테이블명 ADD CONSTRAINT (외래키 이름으로 지정)
//ADD FOREIGN KEY (외래키로 지정할 칼럼 이름) REFERENCES 외래키로 가져올 테이블 이름(가져올 테이블에서 부모키가 될 칼럼)
//이해가 안 되는 부분이 있다면 바로 물어보기
//ex
ALTER TABLE BOARD ADD CONSTRAINT FK_WRITER
ADD FOREIGN KEY WRITER REFERENCES USERS(NICKNAME);

//칼럼 삭제
//ALTER TABLE 테이블 명 DROP COLUMN 칼럼명;
//ex
ALTER TABLE BOARD DROP COLUMN USERID;

//외래키 삭제
//ALTER TABLE 테이블 명 DROP CONSTRAINT 지정해둔 외래키 이름;
//ex
ALTER TABLE BOARD DR OP CONSTRAINT FK_WRITER