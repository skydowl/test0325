SELECT * FROM JAVASQL
-- [ALT] + [X]

CREATE TABLE JAVASQL1 (
    TEST3           NVARCHAR2(10),
    TEST4           NVARCHAR2(10)
)

SELECT * FROM JAVASQL1

-- NAVER테이블
-- 아이디, 비밀번호, 이름, 나이, 성별, 이메일, 연락처
-- 아이디를 PK로 지정하기

DROP TABLE NAVER

CREATE TABLE NAVER (
    NID           				NVARCHAR2(10),
    NPW           				NVARCHAR2(10),
    NNAME					NVARCHAR2(5),
    NAGE						NUMBER,
    NGENDER				NVARCHAR2(6),
    NEMAIL					NVARCHAR2(20),
    NPHONE					NVARCHAR2(13),
    CONSTRAINT NA_ID_PK PRIMARY KEY(NID)
)

SELECT * FROM NAVER
