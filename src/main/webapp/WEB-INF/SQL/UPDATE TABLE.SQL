// 테이블에 칼럼 추가할 때
// ALTER TABLE 테이블명 ADD (테이블에 추가할 칼럼    데이터 타입(타입 길이));
ALTER TABLE BOARD ADD(BOARD_CHECK VARCHAR2(10));


//칼럼 유니크 변경
//ALTER TABLE 테이블명 ADD unique(unique추가할 칼럼);
ALTER TABLE BOARD ADD unique (BOARD_CHECK VARCHAR2(10));

ALTER TABLE 테이블명 ADD constraint 제약 조건 (추가할 칼럼);