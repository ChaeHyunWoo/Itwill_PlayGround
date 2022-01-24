-- SCOTT는 문제풀이 공간
select * from tab;

SELECT * FROM EMP;

SELECT * FROM DEPT; --회사 정보

SELECT * FROM SALGRADE;


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
