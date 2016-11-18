DROP SEQUENCE guestbook_seq;

CREATE SEQUENCE members_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999;

CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999;

CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999;

INSERT INTO MEMBERS
     VALUES (members_seq.NEXTVAL,
             '11',
             'yj',
             '11',
             SYSDATE);

INSERT INTO CATEGORY
     VALUES (category_seq.NEXTVAL,
             57,
             '미분류',
             SYSDATE);

COMMIT;

DELETE FROM MEMBERS;

DELETE FROM BLOG;

INSERT INTO BLOG
     VALUES (1, '11', '11');

INSERT INTO BLOG
        VALUES (
                  21,
                  '블로그 제목을 입력해 주세요.',
                  'spring-logo.jpg');

INSERT INTO BLOG
     VALUES (no, 'title', 'logo');

SELECT *
  FROM MEMBERS m;

SELECT *
  FROM BLOG b;

SELECT *
  FROM CATEGORY c;

UPDATE BLOG
   SET title = '블로그제목을 입력해 주세요.'
 WHERE NO = 35;

INSERT INTO CATEGORY
     VALUES (category_seq.NEXTVAL,
             57,
             '앙분류띠2',
             '두번째 카테고리입니다',
             SYSDATE);

COMMIT;


SELECT c.name, c.DESCRIPTION, c.REG_DATE
  FROM BLOG b, CATEGORY c, MEMBERS m
 WHERE m.NO = b.NO AND b.No = c.BLOG_ID AND m.ID = '11';

COMMIT;

SELECT blog.*
  FROM BLOG, MEMBERS
 WHERE MEMBERS.NO = BLOG.NO AND MEMBERS.ID = '11';

SELECT board.*
  FROM BOARD,
       CATEGORY,
       BLOG,
       MEMBERS
 WHERE     MEMBERS.NO = BLOG.NO
       AND BLOG.NO = CATEGORY.BLOG_ID
       AND CATEGORY.NO = BOARD.CATEGORY_NO
       AND MEMBERS.ID = '11';

SELECT * FROM CATEGORY;

SELECT * FROM BOARd;

INSERT INTO BOARD
     VALUES (board_seq.NEXTVAL,
             5,
             '두째카테두글',
             '둘앤둘',
             SYSDATE);

SELECT board.TITLE, board.CONTENT
  FROM BOARD, CATEGORY
 WHERE CATEGORY.NO = BOARD.CATEGORY_NO AND category.NO = 4 AND board.no = 1;

UPDATE BLOG
   SET TITLE = '바꿨다', LOGo = '로고따리고로따	'
 WHERE no = 28;
 
 select * FROM BLOG b;
 
commit;