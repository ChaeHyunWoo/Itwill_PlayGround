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

SELECT A.USERID,USERNAME, PRODUCT, LOGIN
FROM CUSTOM A, POINT B
WHERE A.USERID = B.USERID AND LOGIN >= 10;

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