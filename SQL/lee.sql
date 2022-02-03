SELECT * FROM TAB;

--��絥���� ��������
/* ���� �ּ� */
SELECT * FROM CUSTOM;

SELECT * FROM COMPANY;

SELECT USERID, PAY, ROUND(PAY, -4) PAY FROM COMPANY;

SELECT * FROM CUSTOM;

--770322-1****** --�ֹι�ȣ �̱�
SELECT RPAD(SUBSTR(JUMIN, 1, 8), 14, '*') JUMIN FROM CUSTOM;


SELECT COUNT(*) INWON FROM CUSTOM
WHERE JOB = 'ȸ���'; -- 177

SELECT COUNT(*) INWON FROM CUSTOM
WHERE SCHOL = '����'; -- 43

SELECT COUNT(*) INWON FROM CUSTOM
WHERE ADDR1 LIKE '����%';

SELECT COUNT(*) INWON FROM CUSTOM
WHERE POINT >= 200;


--���̺��� �̸��� �÷��� �̸��� �ߺ��Ǹ� �ȵȴ�.
SELECT * FROM COMPANY;

--�������� �븮�� ����� ����̳�
SELECT COUNT(PAY) FROM COMPANY
WHERE POSIT = '�븮';

--�������� �븮�� ����� �޴� PAY�� ����?
SELECT SUM(PAY) FROM COMPANY
WHERE POSIT = '�븮';


SELECT * FROM CUSTOM;

--���� �� �ο��� ���ϱ�
SELECT JOB, COUNT(*) INWON FROM CUSTOM
GROUP BY JOB;

--�з� �� POINT�� ��� ���ϱ�
SELECT SCHOL, ROUND(AVG(POINT)) INWON FROM CUSTOM
GROUP BY SCHOL;

--������ POINT �հ� ���ϱ� -- ""���� ������ MAX�� MIN�� �Լ��� �νĵɱ�� ����
SELECT ADDR1, ROUND(SUM(POINT)) INWON, MAX(POINT) "MAX", MIN(POINT) "MIN" FROM CUSTOM
GROUP BY ADDR1;


--���� ������ ���, �ο��� ���ϱ�
SELECT SEX,ROUND(AVG(AGE))"AVG", COUNT(*) "CNT" FROM CUSTOM GROUP BY SEX;


SELECT
CASE SEX
WHEN '1' THEN '����'
WHEN '0' THEN '����'
END GENDER
, ROUND(AVG(AGE)) "AVG", COUNT(*) "CNT"
FROM CUSTOM
GROUP BY SEX;

/*
SELECT 
CASE �÷���                         
	WHEN 1 THEN 100                          
	WHEN 2 THEN 200                         
	WHEN 3 THEN 300                         
	WHEN 4 THEN 400                          
	ELSE 500                        
END AS RESULT             
FROM DUAL;
*/



SELECT * FROM COMPANY;

--��å�� ������ ��, ���, MAX, MIN
SELECT POSIT, COUNT(*) CNT, ROUND(AVG(PAY)) ���, MAX(PAY) �ִ�, MIN(PAY) �ּ�
FROM COMPANY GROUP BY POSIT; -- DB�� ���� �÷����� ���� �� �������� �Ļ� ���̺��̴�.


--��å�� ������ ��, ���, MAX, MIN (HAVING ����ϱ�)
--ORDER BY�� ��Ī�� �ᵵ ���ĵ����� �������� �ȵȴ�. 
SELECT POSIT, COUNT(*) CNT, ROUND(AVG(PAY)) ���, MAX(PAY) �ִ�, MIN(PAY) �ּ�
FROM COMPANY GROUP BY POSIT 
HAVING COUNT(*) > 60;

--------------------1�� 25�� --------------------------------------------------------------------------------------------

--JOIN��
/*
EQUI JOIN(INNER JOIN)
NON-EQUI JOIN -- �̰� ����Ŭ���� ����.
OUTER JOIN
CROSS JOIN -- ��� ���� ����
SELF JOIN
INNER(EQUI)�� 90%  SELF �� 10% �� 2���� ���� �����
*/


--EQUI JOIN(INNER JOIN) -- ����Ŭ SQL
SELECT A.USERID, USERNAME, ADDR1, B.USERID, COMPANY, DEPT, POSIT, PAY
FROM CUSTOM A, COMPANY B --�÷����� AS�� �Ἥ ��Ī�� ������ ���̺� ��Ī�� AS ���� X
WHERE A.USERID = B.USERID;

--INNER JOIN - ǥ�� SQL
SELECT A.USERID, USERNAME, ADDR1, B.USERID, COMPANY, DEPT, POSIT, PAY
FROM CUSTOM A INNER JOIN COMPANY B  -- INNER�� �����ϰ� �ص� ���� ����
ON A.USERID = B.USERID;

--���̺� 'CUSTOM'���� UserID, UserName�� �˻��ϰ�
--POINT ���̺��� ��ǰ ����, �α��ο� ����� POINT ����(Product, Login)�� �˻�
SELECT * FROM POINT;

--EQUI JOIN���� Ǯ��
SELECT A.USERID,USERNAME, PRODUCT, LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID AND LOGIN >= 10;

--INNER JOIN���� Ǯ��
SELECT A.USERID,USERNAME, PRODUCT, LOGIN  --���� ���� ���
FROM CUSTOM A INNER JOIN POINT B -- INNER ��������
ON A.USERID = B.USERID -- AND LOGIN >= 10; -> ����� �ᵵ �ǰ�
WHERE LOGIN >= 10; -- ����� �ᵵ �ȴ�.




--OUTER JOIN(�ܺ� ����)
--Ư�� ���̺��� �����̵Ǽ� �����͸� ã�ƿ�. ( ���� ���X �׷��� �⺻�� �˰��־����)

SELECT COUNT(*) FROM CUSTOM; --459
SELECT COUNT(*) FROM COMPANY; --464

SELECT A.USERID, USERNAME, ADDR1, COMPANY, DEPT
FROM CUSTOM A, COMPANY B -- COMPANY A�� �������� �ϸ� (+)�� �ڿ� ����.
WHERE A.USERID = B.USERID(+);

--���� ANSIǥ������ �����(���� ����)
SELECT A.USERID, USERNAME, ADDR1, COMPANY, DEPT
FROM CUSTOM A LEFT OUTER JOIN COMPANY B -- COMPANY A�� �������� �ϸ� (+)�� �ڿ� ����.
ON A.USERID = B.USERID(+);

-------------------------------------------------------------------------
SELECT A.USERID, USERNAME, ADDR1, COMPANY, DEPT
FROM CUSTOM A, COMPANY B -- COMPANY B�� �������� �ϸ� (+)�� �տ� ����
WHERE A.USERID(+) = B.USERID;

--���� ANSI ǥ������ �����
SELECT A.USERID, USERNAME, ADDR1, COMPANY, DEPT
FROM CUSTOM A RIGHT OUTER JOIN COMPANY B -- COMPANY B�� �������� �ϸ� (+)�� �տ� ����
ON A.USERID(+) = B.USERID;


SELECT * FROM RESEARCH;

SELECT COUNT(*) FROM RESEARCH;

SELECT A.USERID, USERNAME, ANSWER
FROM CUSTOM A, RESEARCH B
WHERE A.USERID = B.USERID(+) AND ANSWER IS NULL;

SELECT A.USERID, USERNAME, ANSWER
FROM CUSTOM A LEFT OUTER JOIN RESEARCH B
ON A.USERID = B.USERID 
WHERE ANSWER IS NULL;

-----------��������� OUTER JOIN---------------------------------------------------------


--CROSS JOIN(��ȣ ����)
SELECT COUNT(*) FROM CUSTOM; --459
SELECT COUNT(*) FROM COMPANY; -- 464



SELECT A.USERID, USERNAME, ADDR1, COMPANY, DEPT 
FROM CUSTOM A, COMPANY B;
--WHERE A.USERID = B.USERID; -- CROSS JOIN�� INNER JOIN���� �� ���� ���� �ȴ�.



-- SELF JOIN

SELECT * FROM CUSTOM;

DESC CUSTOM;

--�������� ��Ƴ��� ����
SELECT DISTINCT A.*
FROM CUSTOM A, CUSTOM B
WHERE A.USERNAME = B.USERNAME
AND A.USERID<>B.USERID -- A.USERID�� B.USERID�� Ʋ������
ORDER BY A.USERNAME;


-- 'CUSTOM' ���̺��� '���ֵ�'�� ��� �ִ� ��� �߿� ������ �̸��� ���� ���� �˻�

SELECT * FROM CUSTOM WHERE ADDR1 = '���ֵ�'; -- 14����


SELECT DISTINCT A.* -- ���ֵ��� ��� ����� ���� 3���̻��̸� DISTINCT�� ���ش�. 2�α����� �Ƚᵵ�ȴ�.
FROM CUSTOM A INNER JOIN CUSTOM B
ON A.USERNAME = B.USERNAME
AND A.USERID<>B.USERID
AND A.ADDR1 = '���ֵ�' AND B.ADDR1 = '���ֵ�'
ORDER BY A.USERNAME;



SELECT A.USERID, USERNAME, COMPANY, DEPT, PRODUCT, LOGIN
FROM CUSTOM A, COMPANY B, POINT C
WHERE A.USERID = B.USERID AND A.USERID = C.USERID;

SELECT A.USERID, USERNAME, COMPANY, DEPT, PRODUCT, LOGIN
FROM CUSTOM A INNER JOIN COMPANY B
ON A.USERID = B.USERID INNER JOIN POINT C
ON A.USERID = C.USERID;

--UNION/ALL

SELECT * FROM CUSTOM;


CREATE TABLE JEJU
AS
SELECT * FROM CUSTOM WHERE ADDR1 = '���ֵ�';

SELECT * FROM JEJU;


CREATE TABLE KYUNG
AS
SELECT * FROM CUSTOM WHERE ADDR1 = '��⵵';

SELECT * FROM KYUNG;


CREATE TABLE SEOUL
AS
SELECT * FROM CUSTOM WHERE ADDR1 = '����Ư����';

SELECT * FROM SEOUL;

----------------
SELECT * FROM JEJU
UNION
SELECT * FROM KYUNG
UNION
SELECT * FROM SEOUL;




--  SUB-QUERY(��������) : ���� �ȿ� ������ �ִ´�.          - ���� ������ �ݵ�� ��ȣ�� ��������Ѵ�.

-- 'COMPANY' ���̺��� UserID, Company, Dept, Pay�� ��� ������ �˻�
SELECT USERID, COMPANY, DEPT, PAY AVG(PAY)FROM COMPANY; -- X ������ �ذ����� �Ʒ�


SELECT ROUND(AVG(PAY)) FROM COMPANY;

SELECT USERID, COMPANY, DEPT, PAY, 1782888 AVG_PAY FROM COMPANY; -- �̷��� �ϸ� ���� �ޱ����� 2���� �����ϴ� �̷��� �ϸ� X


--���� ���
SELECT USERID, COMPANY, DEPT, PAY,
(SELECT ROUND(AVG(PAY)) FROM COMPANY) AVG_PAY, --���������� ���� ����
PAY - (SELECT ROUND(AVG(PAY)) FROM COMPANY) ����
FROM COMPANY;

--'CUSTOM' ���̺��� ��� ���� �̻��� ����� �˻��Ͻÿ�.

SELECT AVG(AGE) FROM CUSTOM;

SELECT * FROM CUSTOM WHERE AGE>= 28;


--->
SELECT * FROM CUSTOM WHERE AGE>= (SELECT AVG(AGE) FROM CUSTOM);

--'COMPANY' ���̺��� ��� ���޺��� ���� ������ �޴� ���� �˻�

SELECT * FROM COMPANY 
WHERE  PAY < (SELECT AVG(PAY) FROM COMPANY);


-- '�����ڵ���' ȸ�翡 �ٹ��ϴ� ���� UserID, UserName, Addr1, Schol ���� �˻�

SELECT USERID FROM COMPANY WHERE COMPANY LIKE '�����ڵ���%';

SELECT * FROM CUSTOM
WHERE USERID IN('EE9224', 'el3409');
--WHERE USERID = 'EE9224' OR USERID = 'el3409';

SELECT * FROM CUSTOM
WHERE USERID IN (SELECT USERID FROM COMPANY WHERE COMPANY LIKE '�����ڵ���%');


--JOIN������ �ٲ㼭 �ϸ� ( ���� ������ JOIN������ �ٲ㼭 �� �� �ִ�.)
--SELECT A. *, COMPANY
SELECT A.USERID,USERNAME, ADDR1,SCHOL, COMPANY
FROM CUSTOM A, COMPANY B
WHERE A.USERID = B.USERID AND COMPANY LIKE '�����ڵ���%';


--SALSE ���̺��� 4ȸ �̻� �Ǹ� ����� �ִ� ������ �⺻ ������ �˻�

SELECT * FROM SALES -- SALES���̺�
ORDER BY USERID;



--SALES ���̺��� 4ȸ �̻� �Ǹ� ����� �ִ� ��
SELECT USERID, COUNT(*) CNT FROM SALES
GROUP BY USERID
HAVING COUNT(*) >= 4;


SELECT * FROM CUSTOM
WHERE USERID IN
(SELECT USERID FROM SALES
GROUP BY USERID
HAVING COUNT(*) >= 4);

--> JOIN������ �ٲٸ�

--INLINE VIEW
SELECT A.*,CNT
FROM CUSTOM A, 
(SELECT USERID, COUNT(*) CNT FROM SALES
GROUP BY USERID
HAVING COUNT(*) >= 4) B
WHERE A.USERID = B.USERID;

/*
SELECT A.*
FROM () A, () B
WHERE A.USERID = B.USERID;
*/



-- �� �Ǹ� �ݾ��� 100���� �̻��� 'CUSTOM' ���̺��� ���� �⺻ ����

--���� 100���� �̻��� ��� ã��
SELECT USERID, COUNT(*) CNT, SUM(PRICE) HAP FROM SALES
GROUP BY USERID
HAVING SUM(PRICE) >= 1000000;



--���� ����
SELECT * FROM CUSTOM
WHERE USERID IN 
(SELECT USERID FROM SALES
GROUP BY USERID
HAVING SUM(PRICE) >= 1000000);

--JOIN

SELECT A.*, CNT, HAP
FROM CUSTOM A, 
(SELECT USERID, COUNT(*) CNT, SUM(PRICE) HAP FROM SALES
GROUP BY USERID
HAVING SUM(PRICE) >= 1000000) B
WHERE A.USERID = B.USERID;


--ANY, ALL

--ANY�� �������� ������ �����ϰ� �־���ϰ�, ALL�� �������� ���� X

SELECT POINT FROM CUSTOM WHERE ADDR1 = '���ֵ�' ORDER BY POINT;

/*
132 ~ 269
>ANY : 132���� ū ������
<ANY : 269���� ���� ������
>ALL : 269���� ū ������
<ANY : 132���� ���� ������
*/

--ANY�� MIN���� ����ӵ��� �ξ� ������.
SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT > ANY (SELECT POINT FROM CUSTOM WHERE ADDR1 = '���ֵ�');


SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT > (SELECT MIN(POINT) FROM CUSTOM WHERE ADDR1 = '���ֵ�');
--------------------------------------------------------------------------------
SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT < ANY (SELECT POINT FROM CUSTOM WHERE ADDR1 = '���ֵ�');


SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT < (SELECT MAX(POINT) FROM CUSTOM WHERE ADDR1 = '���ֵ�');
--------------------------------------------------------------------------------
SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT > ALL ANY (SELECT POINT FROM CUSTOM WHERE ADDR1 = '���ֵ�');


SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT < (SELECT MAX(POINT) FROM CUSTOM WHERE ADDR1 = '���ֵ�');
--------------------------------------------------------------------------------
SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT < ALL (SELECT POINT FROM CUSTOM WHERE ADDR1 = '���ֵ�');


SELECT USERID, USERNAME, POINT FROM CUSTOM
WHERE POINT < (SELECT MIN(POINT) FROM CUSTOM WHERE ADDR1 = '���ֵ�');
--------------------------------------------------------------------------------


SELECT * FROM CUSTOM WHERE POINT = 131;

UPDATE CUSTOM SET POINT = 131 WHERE USERID = 'nn4942';


--------------------------------------------------------------------------------
-- IN�� =ANY �����ڴ� ����
--�����ڵ����� �ٹ��ϴ� �����?

SELECT USERID, USERNAME, ADDR1, SCHOL FROM CUSTOM
WHERE USERID IN (SELECT USERID FROM COMPANY WHERE COMPANY LIKE '�����ڵ���%');

SELECT USERID, USERNAME, ADDR1, SCHOL FROM CUSTOM
WHERE USERID = ANY (SELECT USERID FROM COMPANY WHERE COMPANY LIKE '�����ڵ���%');

--------------------------------------------------------------------------------
SELECT USERID, USERNAME, ADDR1, SCHOL FROM CUSTOM
WHERE USERID NOT IN (SELECT USERID FROM COMPANY WHERE COMPANY LIKE '�����ڵ���%');

SELECT USERID, USERNAME, ADDR1, SCHOL FROM CUSTOM
WHERE USERID <> ALL (SELECT USERID FROM COMPANY WHERE COMPANY LIKE '�����ڵ���%');

--------------------------------------------------------------------------------
--���⸦ �ϴ� ��� ������ �ٲ�
SELECT USERID, USERNAME, ADDR1, SCHOL FROM CUSTOM
WHERE USERID NOT IN (SELECT USERID FROM COMPANY WHERE COMPANY LIKE '�����ڵ���%');

--��� ����(�����常 ������) - EXISTS
SELECT USERID, USERNAME, ADDR1, SCHOL FROM CUSTOM
WHERE EXISTS -- �ٹ����� �ʴ� ����� ã���Ÿ� WHERE NOT EXISTS�� �ϸ� �ȴ�.
(SELECT * FROM COMPANY 
WHERE USERID = CUSTOM.USERID AND COMPANY LIKE '�����ڵ���%');
--------------------------------------------------------------------------------
--��� ����(�����常 ������) - NOT EXISTS
SELECT USERID, USERNAME, ADDR1, SCHOL FROM CUSTOM
WHERE NOT EXISTS -- �ٹ����� �ʴ� ����� ã���Ÿ� WHERE NOT EXISTS�� �ϸ� �ȴ�.
(SELECT * FROM COMPANY 
WHERE USERID = CUSTOM.USERID AND COMPANY LIKE '�����ڵ���%');
--��������� ���������� ����X

--------------------------------------------------------------------------------
--��⵵�� ��鼭 ���̰� 20���� ���� ���
SELECT * FROM CUSTOM WHERE ADDR1 = '��⵵' AND AGE <= 20;


SELECT * FROM (SELECT * FROM CUSTOM WHERE ADDR1 = '��⵵') A;

--���� �ٸ����
SELECT * FROM (SELECT * FROM CUSTOM WHERE ADDR1 = '��⵵') A
WHERE A.AGE<=20;


---------------------------------------------------2�� 3��------------------------------------------------------------------



create table ���
(�����ȣ number(10),
����� varchar2(10),
�μ���ȣ number(2),
���� varchar2(10),
�����ȣ char(7),
�ּ� varchar2(50),
��ȭ��ȣ char(15),
�޿� number(5),
Ŀ�̼� number(5),
�Ի��� date,
���� char(6),
�����ȣ number(10)
);


insert into ��� values(2001,'�̼���',10,'����','125-365','���� ��걸','02-985-1254',3500,100,'1980-12-01','����',null);
insert into ��� values(2002,'ȫ�浿',10,'�븮','354-865','���� ������','02-865-1254',4000,'','2000-01-25','����',2004);
insert into ��� values(2003,'������',20,'���','587-456','�λ� �ؿ�뱸','051-256-9874',2500,100,'2002-05-24','����',2002);
insert into ��� values(2004,'������',30,'����','987-452','���� ������','02-33-6589',5000,'','1997-03-22','����',2001);
insert into ��� values(2005,'���',10,'�븮','123-322','���� ������','02-888-9564',3000,100,'1999-07-15','����',2004);
insert into ��� values(2006,'������',20,'���','154-762','���� ���ı�','02-3369-9874',2000,'','2003-05-22','����',2005);
insert into ��� values(2007,'�ڼֹ�',30,'�븮','367-985','���� ��������','02-451-2563',3000,100,'2006-01-25','����',2004);
insert into ��� values(2008,'��ȿ��',40,'���','552-126','���� �߱�','02-447-3256',2000,'','2001-02-02','����',2007);

select * from ���;
DESC ���; --��� ���̺��� �ڷ����� ����
commit;

-----------------------------------------�̰� PL SQL�̴�.
--select,insert,update,delete�� ��밡��
DECLARE
TYPE FIRSTTYPE IS RECORD
--(A VARCHAR2, B VARCHAR2, C NUMBER); -- �̷��� �ᵵ ������ 
(A ���.�����%TYPE,B ���.����%TYPE, C ���.�޿�%TYPE); -- ���� ���� ���� �ִ� 

CUS FIRSTTYPE;--CUS��� ������ �����ϰ� FORSTTYPE�� CUS�� �ִ´� 

BEGIN --������ �����ϰ� 
SELECT �����,����,�޿� INTO CUS FROM ��� WHERE �����ȣ=2001;--����� ���� �޿� INTO�ؼ� CUS�� �ִ´� 

DBMS_OUTPUT.PUT_LINE('--------------------------');
DBMS_OUTPUT.PUT_LINE('����� ���� �޿�');
DBMS_OUTPUT.PUT_LINE(CUS.A||'  '||CUS.B||'  '||TO_CHAR(CUS.C));
DBMS_OUTPUT.PUT_LINE('���� ������ ������ '||USER||'�Դϴ�');--���⼭ USER�� SYSTEM �����̴� 
DBMS_OUTPUT.PUT_LINE('���� ������ �ð��� '||TO_CHAR(SYSDATE,'YYYY-MM-DD HH:MM:SS'));--SYDATE�� �о�ͼ� ���� ���ϴ� �Ը����� ǥ���Ѵ� 
END;--������

SELECT * FROM ���;

SELECT �����ȣ,�����,����,�޿�,Ŀ�̼�,F_TAX(2001) TAX FROM ��� -- �Լ��κ� CMDĸó�Ѱ� ���⼭ ����
WHERE �����ȣ=2001;


--���ݺ����ϴ� �ڵ���  SCRIPT(����)�� �����Ѵ�
ACCEPT ID PROMPT '�˻��� ���̵� �Է��ϼ���: ';--ID�� ��������� ����

DECLARE

TYPE GOGAK IS RECORD --GOGAK�̶�� ������Ÿ��(RECORD)�� ����
(A CUSTOM.USERID%TYPE, --A��� ������ ����� 
B CUSTOM.USERNAME%TYPE,
C NUMBER(12,2),
D NUMBER(5));

CUS GOGAK;

BEGIN
SELECT C.USERID, C.USERNAME, S.�հ�, S.����Ƚ�� INTO CUS
FROM CUSTOM C, --CUSTOM�� C�� �ϰ�
(SELECT USERID, SUM(PRICE) �հ�, COUNT(*) ����Ƚ��
FROM SALES
GROUP BY USERID) S --�� ��ȣ�� S�� ����
WHERE C.USERID = S.USERID AND C.USERID ='&ID';--ACCEPT ID PROMPT ���� ID���� ������

DBMS_OUTPUT.PUT_LINE('���̵�: '||CUS.A);
DBMS_OUTPUT.PUT_LINE('��  ��: '||CUS.B);
DBMS_OUTPUT.PUT_LINE('�Ǹž�: '||CUS.C);
DBMS_OUTPUT.PUT_LINE('��  ��: '||CUS.D);

END;

SELECT * FROM CUSTOM;


--��å�� �Է� �޾� �� ��å�� �޿��� �Ѿ�,��տ���,�ο����� ã���ÿ�

CREATE OR REPLACE PROCEDURE SEARCHJIK
(JIK IN VARCHAR2)
IS --IS�� �������� �Ʒ��� �� �ȿ��� ����� ����
A NUMBER;=0;
B NUMBER(12,2);=0; --���� �ڸ����� ����
C NUMBER:=0;
BEGIN
SELECT SUM(PAY),AVG(PAY),COUNT(*) INTO A,B,C
FROM COMPANY WHERE POSIT=JIK;

DMBS_OUTPUT.PUT.LINE('�޿��Ѿ�: '||A||'��');
DMBS_OUTPUT.PUT.LINE('��տ���: '||B||'��');
DMBS_OUTPUT.PUT.LINE('�ο���: '||C||'��');
END SEARCHJIK; --END�ڿ� SEARCHJIK��������


SELECT * FROM COMPANY;

SELECT SUM(PAY),ROUND(AVG(PAY)),COUNT(*)
FROM COMPANY WHERE POSIT=JIK;
GROUP BY POSIT;





--CUSTOM ���̺� INSERT ��Ű�� ���ν���(CUS_IN)
CREATE OR REPLACE PROCEDURE CUS_IN
(A VARCHAR2,B VARCHAR2,C VARCHAR2,D NUMBER,E VARCHAR2,
F VARCHAR2,G VARCHAR2,H VARCHAR2,I VARCHAR2,J VARCHAR2,
K VARCHAR2,L VARCHAR2,M NUMBER,N DATE,)
IS
BEGIN
INSERT INTO CUSTOM VALUES (A,B,C,D,E,F,G,H,I,J,K,L,M,N);
COMMIT;
END;

EXEC CUS_IN('A002','INNA','123',27,'0','123-123','����',
'������','���ﵿ','010-123-1234','����','����',123,SYSDATE);

--CUSTOM ���̺� UPDATE ��Ű�� ���ν���(CUS_UP)
CREATE OR REPLACE PROCEDURE CUS_UP
(A VARCHAR2,B VARCHAR2,C VARCHAR2,D NUMBER,E VARCHAR2,
F VARCHAR2,G VARCHAR2,H VARCHAR2,I VARCHAR2,J VARCHAR2,
K VARCHAR2,L VARCHAR2,M NUMBER,N DATE,)
IS
BEGIN
UPDATE CUSTOM SET USERNAME=B, JUMIN=C, AGE=D, SEX=E,
ZIP=F, ADDR1=G, ADDR2=H, ADDR3=I, TEL=J, JOB=K, SCHOL=L,
POINT=M, REGDATE=N
WHERE USERID=A;
COMMIT;
END;



--CUSTOM ���̺� DELETE ��Ű�� ���ν���(CUS_DEL)
CREATE OR REPLACE PROCEDURE CUS_DEL
(A VARCHAR2)
IS
BEGIN
DELETE CUSTOM WHERE USERNAME=B, JUMIN=C, AGE=D, SEX=E,
ZIP=F, ADDR1=G, ADDR2=H, ADDR3=I, TEL=J, JOB=K, SCHOL=L,











