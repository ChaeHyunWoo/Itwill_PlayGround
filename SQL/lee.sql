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


