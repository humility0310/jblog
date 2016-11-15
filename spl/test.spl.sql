DROP SEQUENCE guestbook_seq;

CREATE SEQUENCE members_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999;

INSERT INTO MEMBERS
     VALUES (members_seq.NEXTVAL,
             '11',
             'yj',
             '11',
             SYSDATE);

COMMIT;

DELETE FROM MEMBERS
      WHERE ID = 11;

DELETE FROM BLOG
      WHERE NO =26;

INSERT INTO BLOG
     VALUES (1, '11', '11');

INSERT INTO BLOG
     VALUES (21, 'default_title', 'default_content');

INSERT INTO BLOG
     VALUES (no, 'title', 'logo');

SELECT *
  FROM MEMBERS m;

SELECT *
  FROM BLOG b;