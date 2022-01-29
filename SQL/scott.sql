-- SCOTT�� ����Ǯ�� ����
select * from tab;

SELECT * FROM EMP;

SELECT * FROM DEPT; --ȸ�� ����

SELECT * FROM SALGRADE;

--1��24�� ����--------------------------------------------------------------------------------------------------------------------

--2. EMP ���̺��� �޿��� 3000�̻��� ����� ������ �����ȣ,�̸�,������,�޿��� ����ϴ� SELECT ������ �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL FROM EMP
WHERE SAL >= 3000;
 

--3. EMP ���̺��� �����ȣ�� 7782�� ����� �̸��� �μ���ȣ�� ����ϴ� SELECT ������ �ۼ��Ͻÿ�.
SELECT ENAME, DEPTNO FROM EMP
WHERE EMPNO = 7782;
 

--4. EMP ���̺��� �Ի����� February 20, 1981�� May 1, 1981 ���̿� �Ի��� ����� �̸�,����,�Ի����� ����ϴ� SELECT ������ �ۼ��Ͻÿ�. �� �Ի��� ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE FROM EMP
WHERE HIREDATE BETWEEN '1981-02-20' AND '1981-03-01'
ORDER BY HIREDATE;
 

--5. EMP ���̺��� �μ���ȣ�� 10,20�� ����� ��� ������ ����ϴ� SELECT ������ �ۼ��Ͻÿ�. �� �̸������� �����Ͽ���.
SELECT * FROM EMP
WHERE DEPTNO IN(10,20)
ORDER BY ENAME;
 

--6. EMP ���̺��� �޿��� 1500�̻��̰� �μ���ȣ�� 10,30�� ����� �̸��� �޿��� ����ϴ� SELECT ������ �ۼ��Ͽ���. 
--   �� HEADING�� Employee�� Monthly Salary�� ����Ͽ���.
SELECT ENAME "Employee", SAL "Monthly Salary" FROM EMP
WHERE SAL >= 1500 AND DEPTNO = 10 OR DEPTNO = 30;
 

--7. EMP ���̺��� 1982�⿡ �Ի��� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP
WHERE HIREDATE BETWEEN '1982-01-01' AND '1982-12-31';

--8. EMP ���̺��� COMM�� NULL�� �ƴ� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP
WHERE COMM IS NOT NULL;
 

--9. EMP ���̺��� ���ʽ��� �޿����� 10%�� ���� ��� �������� ���Ͽ� �̸�,�޿�,���ʽ��� ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT ENAME, SAL, COMM FROM EMP
WHERE COMM > NVL(SAL * 1.1, 0);
 

--10. EMP ���̺��� ������ Clerk�̰ų� Analyst�̰� �޿��� 1000,3000,5000�� �ƴ� ��� ����� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP
WHERE JOB IN('CLERK','ANALYST') AND SAL NOT IN(1000, 3000, 5000);
 

--11. EMP ���̺��� �̸��� L�� �� �ڰ� �ְ�  �μ��� 30�̰ų� �Ǵ� �����ڰ� 7782�� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP
WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;


---------------------1�� 25�� ����----------------------------------------------------------------------------------------------
SELECT * FROM EMP;

--1. ���� ��¥�� ����ϰ� �� ���̺��� Current Date�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE AS "Current Date" FROM DUAL;
 

--2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL*1.15 AS "New Salary", SAL*0.15 AS "Increase" FROM EMP;

 

--3. EMP ���̺��� �̸�,�Ի���,�Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD')�Ի���, TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,6),'������'), 'YYYY-MM-DD')
"6���� �� ������" FROM EMP;
 

--4. EMP ���̺��� �̸�,�Ի���, �Ի��Ϸκ��� ��������� ����,�޿�, �Ի��Ϻ��� ��������� �޿��� �Ѱ踦 ����ϴ� SELECT ������ ����Ͻÿ�.

SELECT ENAME, HIREDATE, ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "��������� �� ��", SAL, 
ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL"��������� �޿�" FROM EMP;



--5. EMP ���̺��� ������ ����� ��µǵ��� �ۼ��Ͻÿ�.


/*
Dream Salary

------------------------------------------------------------

KING earns $5,000.00 monthly but wants $15,000.00

BLAKE earns $2,850.00 monthly but wants $8,550.00

CLARK earns $2,450.00 monthly but wants $7,350.00

. . . . . . . . . .

14 rows selected
 */
 --CONCAT - ||�� ������ �ǹ�( �� ���ڿ� ����)
SELECT ENAME || ' earns '||TO_CHAR(SAL, '$9,999.00')  || '  monthly but wants' || TO_CHAR(SAL*3, '$99,999.00') FROM EMP;

--6. EMP ���̺��� ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ ����� ��*���� ��ġ)�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP;
 

--7. EMP ���̺��� ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') FROM EMP;
 

--8. EMP ���̺��� �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP
WHERE LENGTH(ENAME) >= 6;
 
--9. EMP ���̺��� ��� ����� ������ �̸�,����,�޿�,���ʽ�,�޿�+���ʽ��� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, SAL, COMM, NVL(COMM, 0) + SAL FROM EMP;


----------------1�� 26�� ���� --------------------------------------------------------------------------


-- 1. EMP ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT COUNT(*),MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;
 

-- 2. EMP ���̺��� �� �������� �ִ� �޿�,�ּ� �޿�,�޿��� ���� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB, MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP
GROUP BY JOB;
 

-- 3. EMP ���̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;
 

-- 4. EMP ���̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT MAX(SAL) - MIN(SAL) FROM EMP;
 

-- 5. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(group by)

/*
H_YEAR  COUNT(*)  MIN(SAL)  MAX(SAL)  AVG(SAL)  SUM(SAL)

------ --------- --------- --------- --------- ---------

    81       10       950      5000    2282.5	  22825

    82        1      1300      1300      1300      1300

    80        1       800       800       800       800
 
*/
 
SELECT TO_CHAR(HIREDATE,'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
FROM EMP GROUP BY TO_CHAR(HIREDATE,'YY');

-- 6. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(case,sum,EXTRACT)

/*
    TOTAL      1980      1981      1982      1983

--------- --------- --------- --------- ---------

       12         1        10         1         0
 
 */
SELECT SUM(COUNT(*)) TOTAL,
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1980' THEN COUNT(*) END),0) "1980",
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1981' THEN COUNT(*) END),0) "1981",
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1982' THEN COUNT(*) END),0) "1982",
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1983' THEN COUNT(*) END),0) "1983"
FROM EMP
GROUP BY HIREDATE;


SELECT SUM(COUNT(HIREDATE))TOTAL,
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1980' THEN COUNT(*) END),0) "1980",
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1981' THEN COUNT(*) END),0) "1981",
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1982' THEN COUNT(*) END),0) "1982",
NVL(SUM(CASE TO_CHAR(EXTRACT(YEAR FROM HIREDATE)) WHEN '1983' THEN COUNT(*) END),0) "1983"
FROM EMP
GROUP BY HIREDATE;


SELECT
COUNT(*) TOTAL,
SUM(CASE WHEN EXTRACT (YEAR FROM HIREDATE) = '1980' THEN '1' ELSE '0' END)"1980",
SUM(CASE WHEN EXTRACT (YEAR FROM HIREDATE) = '1981' THEN '1' ELSE '0' END)"1981",
SUM(CASE WHEN EXTRACT (YEAR FROM HIREDATE) = '1982' THEN '1' ELSE '0' END)"1982",
SUM(CASE WHEN EXTRACT (YEAR FROM HIREDATE) = '1983' THEN '1' ELSE '0' END)"1983"
FROM EMP;

--7. EMP ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(SUM, CASE, GROUP BY)

/*

JOB         Deptno 10    Deptno 20     Deptno 30     Total

---------   ---------    ---------     ---------     ---------

CLERK            1300         1900           950          4150

SALESMAN                                    5600          5600

PRESIDENT	 5000                                     5000

MANAGER	         2450         2975          2850          8275

ANALYST	                      6000                        6000

*/
SELECT JOB,
SUM(CASE DEPTNO WHEN 10 THEN SAL END) "DEPTNO10",
SUM(CASE DEPTNO WHEN 20 THEN SAL END) "DEPTNO20",
SUM(CASE DEPTNO WHEN 30 THEN SAL END) "DEPTNO30",
SUM(SAL) Total
FROM EMP
GROUP BY JOB;


--------------------------------------- 1�� 27�� ���� ----------------------------------------------------------------------


-- 1. EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT * FROM EMP;
SELECT * FROM DEPT;
-------------------------------------
SELECT A.ENAME,A.DEPTNO,B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO;

-- 2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT A.ENAME, A.JOB, A.SAL, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND LOC = 'NEW YORK';
 

-- 3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT A.ENAME, B.DNAME, B.LOC
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND COMM > 0;
 

-- 4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT A.ENAME, A.JOB, B.LOC
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND A.ENAME LIKE '%L%'; 


/*
5. �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.(�����ڰ� ���� King�� �����Ͽ� ��� ����� ���)

Employee        Emp# Manager         Mgr#

---------- --------- ---------- ---------

KING            7839

BLAKE           7698 KING            7839

CLARK           7782 KING            7839

. . . . . . . . . .

14 rows selected.
 */
SELECT A.ENAME Employee,A.EMPNO Emp#,B.ENAME Manager,B.EMPNO Mgr#
FROM EMP A,EMP B
WHERE A.MGR = B.EMPNO(+)
ORDER BY B.EMPNO DESC;




-- 6. EMP ���̺��� �׵��� ������ ���� ���� �Ի��� ����� ���Ͽ� �̸�,�Ի���,������ �̸�, ������ �Ի����� ����ϴ� SELECT ������ �ۼ��Ͽ���.

SELECT A.ENAME ����̸�, A.HIREDATE �Ի���, B.ENAME �������̸�, B.HIREDATE �������Ի���
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO AND A.HIREDATE < B.HIREDATE;

/*
7. EMP ���̺��� ����� �޿��� ����� �޿� �縸ŭ ��*���� ����ϴ� SELECT ������ �ۼ��Ͽ���. �� ��*���� 100�� �ǹ��Ѵ�.

Employee and their salary

-----------------------------------------------------------------

KING      **************************************************

BLAKE     ****************************

CLARK     ************************

JONES     *****************************

MARTIN    ************

ALLEN     ****************

TURNER    ***************

. . . . . . . . . .

14 rows selected.
 */
SELECT RPAD(ename,10,' ')||RPAD(' ',sal/100 + 1,'*') AS "Employee and their salary"
FROM EMP ORDER BY SAL ASC;
-- LPAD(X, ���ڼ�, "*")


------------------- 1�� 28�� -----------------------------------------------------------------------------------------------
--Ǫ�� �ð� üũ�غ��� (1�ð��̳��� Ǯ�� ��Ǭ��)
SELECT * FROM EMP;
SELECT * FROM DEPT;
-- 1. EMP ���̺��� Blake�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT ENAME,HIREDATE FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

-- 2. EMP ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� ������ ��ȣ�� �̸��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �޿��� ���� ������ ����Ͽ���.

SELECT EMPNO,ENAME FROM EMP
WHERE SAL > (SELECT AVG(SAL)FROM EMP)ORDER BY SAL DESC;

-- 3. EMP ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ���� ��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.

SELECT EMPNO,ENAME,SAL FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
ORDER BY DEPTNO;

-- 4. EMP ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT A.ENAME,A.JOB,A.SAL,B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND LOC = 'DALLAS';

-- 5. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT EMPNO FROM EMP WHERE ENAME = 'KING';

SELECT ENAME,SAL FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
 
-- 6. EMP ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT A.ENAME,A.JOB
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND DNAME = 'SALES';

-- 7. EMP ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- 8. EMP ���̺��� �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT ENAME,JOB FROM EMP
WHERE JOB IN(SELECT JOB FROM EMP WHERE DEPTNO=30) AND DEPTNO=10;

-- 9. EMP ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT * FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'FORD') AND
SAL = (SELECT SAL FROM EMP WHERE ENAME = 'FORD');

-- 10. EMP ���̺��� ������ JONES�� ���ų� ������ FORD�̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
--     �� ������, ������ ���� ������ ����Ͽ���.

SELECT ENAME,JOB,DEPTNO,SAL FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') OR
SAL > (SELECT SAL FROM EMP WHERE ENAME = 'FORD');


-- 11. EMP ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT ENAME,JOB,SAL FROM EMP
WHERE SAL IN(SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME='WARD');

-- 12. EMP ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT ENAME,JOB FROM EMP
WHERE JOB IN(SELECT JOB FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='CHICAGO'));

-- 13. EMP ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.

SELECT A.DEPTNO,ENAME,SAL FROM EMP A,(SELECT DEPTNO,AVG(SAL) FROM EMP GROUP BY DEPTNO)B
WHERE A.DEPTNO, B.DEPTNO(+) AND SAL > AVG(SAL);


-- 14. EMP ���̺��� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.


 

 

-- 15. EMP ���̺��� ��� �Ѹ� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.

 

 

-- 16. EMP ���̺��� ���� ����� �����ȣ,�̸�,����,�μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.