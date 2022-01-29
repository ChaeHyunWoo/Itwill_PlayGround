-- SCOTT는 문제풀이 공간
select * from tab;

SELECT * FROM EMP;

SELECT * FROM DEPT; --회사 정보

SELECT * FROM SALGRADE;

--1월24일 문제--------------------------------------------------------------------------------------------------------------------

--2. EMP 테이블에서 급여가 3000이상인 사원의 정보를 사원번호,이름,담당업무,급여를 출력하는 SELECT 문장을 작성하시오.
SELECT EMPNO, ENAME, JOB, SAL FROM EMP
WHERE SAL >= 3000;
 

--3. EMP 테이블에서 사원번호가 7782인 사원의 이름과 부서번호를 출력하는 SELECT 문장을 작성하시오.
SELECT ENAME, DEPTNO FROM EMP
WHERE EMPNO = 7782;
 

--4. EMP 테이블에서 입사일이 February 20, 1981과 May 1, 1981 사이에 입사한 사원의 이름,업무,입사일을 출력하는 SELECT 문장을 작성하시오. 단 입사일 순으로 출력하시오.
SELECT ENAME, JOB, HIREDATE FROM EMP
WHERE HIREDATE BETWEEN '1981-02-20' AND '1981-03-01'
ORDER BY HIREDATE;
 

--5. EMP 테이블에서 부서번호가 10,20인 사원의 모든 정보를 출력하는 SELECT 문장을 작성하시오. 단 이름순으로 정렬하여라.
SELECT * FROM EMP
WHERE DEPTNO IN(10,20)
ORDER BY ENAME;
 

--6. EMP 테이블에서 급여가 1500이상이고 부서번호가 10,30인 사원의 이름과 급여를 출력하는 SELECT 문장을 작성하여라. 
--   단 HEADING을 Employee과 Monthly Salary로 출력하여라.
SELECT ENAME "Employee", SAL "Monthly Salary" FROM EMP
WHERE SAL >= 1500 AND DEPTNO = 10 OR DEPTNO = 30;
 

--7. EMP 테이블에서 1982년에 입사한 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP
WHERE HIREDATE BETWEEN '1982-01-01' AND '1982-12-31';

--8. EMP 테이블에서 COMM에 NULL이 아닌 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP
WHERE COMM IS NOT NULL;
 

--9. EMP 테이블에서 보너스가 급여보다 10%가 많은 모든 종업원에 대하여 이름,급여,보너스를 출력하는 SELECT 문을 작성하여라.
SELECT ENAME, SAL, COMM FROM EMP
WHERE COMM > NVL(SAL * 1.1, 0);
 

--10. EMP 테이블에서 업무가 Clerk이거나 Analyst이고 급여가 1000,3000,5000이 아닌 모든 사원의 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP
WHERE JOB IN('CLERK','ANALYST') AND SAL NOT IN(1000, 3000, 5000);
 

--11. EMP 테이블에서 이름에 L이 두 자가 있고  부서가 30이거나 또는 관리자가 7782인 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP
WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;


---------------------1월 25일 문제----------------------------------------------------------------------------------------------
SELECT * FROM EMP;

--1. 현재 날짜를 출력하고 열 레이블은 Current Date로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE AS "Current Date" FROM DUAL;
 

--2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장을 기술하시오.
SELECT EMPNO, ENAME, JOB, SAL*1.15 AS "New Salary", SAL*0.15 AS "Increase" FROM EMP;

 

--3. EMP 테이블에서 이름,입사일,입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD')입사일, TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,6),'월요일'), 'YYYY-MM-DD')
"6개월 후 월요일" FROM EMP;
 

--4. EMP 테이블에서 이름,입사일, 입사일로부터 현재까지의 월수,급여, 입사일부터 현재까지의 급여의 총계를 출력하는 SELECT 문장을 기술하시오.

SELECT ENAME, HIREDATE, ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "현재까지의 월 수", SAL, 
ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL"현재까지의 급여" FROM EMP;



--5. EMP 테이블에서 다음의 결과가 출력되도록 작성하시오.


/*
Dream Salary

------------------------------------------------------------

KING earns $5,000.00 monthly but wants $15,000.00

BLAKE earns $2,850.00 monthly but wants $8,550.00

CLARK earns $2,450.00 monthly but wants $7,350.00

. . . . . . . . . .

14 rows selected
 */
 --CONCAT - ||와 동일한 의미( 두 문자열 연결)
SELECT ENAME || ' earns '||TO_CHAR(SAL, '$9,999.00')  || '  monthly but wants' || TO_CHAR(SAL*3, '$99,999.00') FROM EMP;

--6. EMP 테이블에서 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈곳은 “*”로 대치)를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP;
 

--7. EMP 테이블에서 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') FROM EMP;
 

--8. EMP 테이블에서 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP
WHERE LENGTH(ENAME) >= 6;
 
--9. EMP 테이블에서 모든 사원의 정보를 이름,업무,급여,보너스,급여+보너스를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, SAL, COMM, NVL(COMM, 0) + SAL FROM EMP;


----------------1월 26일 문제 --------------------------------------------------------------------------


-- 1. EMP 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력하는 SELECT 문장을 작성하여라.
SELECT COUNT(*),MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;
 

-- 2. EMP 테이블에서 각 업무별로 최대 급여,최소 급여,급여의 합을 출력하는 SELECT 문장을 작성하여라.
SELECT JOB, MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP
GROUP BY JOB;
 

-- 3. EMP 테이블에서 업무별 인원수를 구하여 출력하는 SELECT 문장을 작성하여라.
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;
 

-- 4. EMP 테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력하는 SELECT 문장을 작성하여라.
SELECT MAX(SAL) - MIN(SAL) FROM EMP;
 

-- 5. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(group by)

/*
H_YEAR  COUNT(*)  MIN(SAL)  MAX(SAL)  AVG(SAL)  SUM(SAL)

------ --------- --------- --------- --------- ---------

    81       10       950      5000    2282.5	  22825

    82        1      1300      1300      1300      1300

    80        1       800       800       800       800
 
*/
 
SELECT TO_CHAR(HIREDATE,'YY') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
FROM EMP GROUP BY TO_CHAR(HIREDATE,'YY');

-- 6. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(case,sum,EXTRACT)

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

--7. EMP 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(SUM, CASE, GROUP BY)

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


--------------------------------------- 1월 27일 문제 ----------------------------------------------------------------------


-- 1. EMP 테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 SELECT 문장을 작성하여라.

SELECT * FROM EMP;
SELECT * FROM DEPT;
-------------------------------------
SELECT A.ENAME,A.DEPTNO,B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO;

-- 2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT A.ENAME, A.JOB, A.SAL, B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND LOC = 'NEW YORK';
 

-- 3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력하는 SELECT 문장을 작성하여라.
SELECT A.ENAME, B.DNAME, B.LOC
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND COMM > 0;
 

-- 4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력하는 SELECT 문장을 작성하여라.
SELECT A.ENAME, A.JOB, B.LOC
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND A.ENAME LIKE '%L%'; 


/*
5. 아래의 결과를 출력하는 SELECT 문장을 작성하여라.(관리자가 없는 King을 포함하여 모든 사원을 출력)

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




-- 6. EMP 테이블에서 그들의 관리자 보다 먼저 입사한 사원에 대하여 이름,입사일,관리자 이름, 관리자 입사일을 출력하는 SELECT 문장을 작성하여라.

SELECT A.ENAME 사원이름, A.HIREDATE 입사일, B.ENAME 관리자이름, B.HIREDATE 관리자입사일
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO AND A.HIREDATE < B.HIREDATE;

/*
7. EMP 테이블에서 사원의 급여와 사원의 급여 양만큼 “*”를 출력하는 SELECT 문장을 작성하여라. 단 “*”는 100을 의미한다.

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
-- LPAD(X, 글자수, "*")


------------------- 1월 28일 -----------------------------------------------------------------------------------------------
--푸는 시간 체크해보기 (1시간이내로 풀면 잘푼것)
SELECT * FROM EMP;
SELECT * FROM DEPT;
-- 1. EMP 테이블에서 Blake와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력하는 SELECT문을 작성하시오.

SELECT ENAME,HIREDATE FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

-- 2. EMP 테이블에서 평균 급여 이상을 받는 모든 종업원에 대해서 종업원 번호와 이름을 출력하는 SELECT문을 작성하시오. 단 급여가 많은 순으로 출력하여라.

SELECT EMPNO,ENAME FROM EMP
WHERE SAL > (SELECT AVG(SAL)FROM EMP)ORDER BY SAL DESC;

-- 3. EMP 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 종업원에 대해 사원 번호,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사원번호 순으로 출력하여라.

SELECT EMPNO,ENAME,SAL FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
ORDER BY DEPTNO;

-- 4. EMP 테이블에서 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력하는 SELECT문을 작성하시오.

SELECT A.ENAME,A.JOB,A.SAL,B.DNAME
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND LOC = 'DALLAS';

-- 5. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문을 작성하시오.

SELECT EMPNO FROM EMP WHERE ENAME = 'KING';

SELECT ENAME,SAL FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
 
-- 6. EMP 테이블에서 SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.

SELECT A.ENAME,A.JOB
FROM EMP A, DEPT B
WHERE A.DEPTNO = B.DEPTNO AND DNAME = 'SALES';

-- 7. EMP 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력하는 SELECT문을 작성하시오.

SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- 8. EMP 테이블에서 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력하는 SELECT문을 작성하시오.

SELECT ENAME,JOB FROM EMP
WHERE JOB IN(SELECT JOB FROM EMP WHERE DEPTNO=30) AND DEPTNO=10;

-- 9. EMP 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력하는 SELECT문을 작성하시오.

SELECT * FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'FORD') AND
SAL = (SELECT SAL FROM EMP WHERE ENAME = 'FORD');

-- 10. EMP 테이블에서 업무가 JONES와 같거나 월급이 FORD이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성하시오.
--     단 업무별, 월급이 많은 순으로 출력하여라.

SELECT ENAME,JOB,DEPTNO,SAL FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') OR
SAL > (SELECT SAL FROM EMP WHERE ENAME = 'FORD');


-- 11. EMP 테이블에서 SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력하는 SELECT문을 작성하시오.

SELECT ENAME,JOB,SAL FROM EMP
WHERE SAL IN(SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME='WARD');

-- 12. EMP 테이블에서 CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.

SELECT ENAME,JOB FROM EMP
WHERE JOB IN(SELECT JOB FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='CHICAGO'));

-- 13. EMP 테이블에서 부서별로 월급이 평균 월급보다 높은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.

SELECT A.DEPTNO,ENAME,SAL FROM EMP A,(SELECT DEPTNO,AVG(SAL) FROM EMP GROUP BY DEPTNO)B
WHERE A.DEPTNO, B.DEPTNO(+) AND SAL > AVG(SAL);


-- 14. EMP 테이블에서 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.


 

 

-- 15. EMP 테이블에서 적어도 한명 이상으로부터 보고를 받을 수 있는 사원을 업무,이름,사원번호,부서번호를 출력하는 SELECT문을 작성하시오.

 

 

-- 16. EMP 테이블에서 말단 사원의 사원번호,이름,업무,부서번호를 출력하는 SELECT문을 작성하시오.