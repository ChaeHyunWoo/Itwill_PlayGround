select * from tab;
SELECT * FROM PERSONNEL;
/*
1. query
   select data검색어

2. dml(data maipulation language)
    insert, update, delete
    
3. ddl(data difinition language)
    create, alter, drop, rename
    
4. tcl(transaction control language)
    commit (save랑 같다) , rollback (취소의 개념)
    
5. dcl(data control language)
    grant(권한을 줄 때), revoke(권한을 뺏을 때)
    */
    
select * from tab;

select * from personnel; 
select * from division;
select * from PAYGRADE; 
select * from BONUS;

SELECT * FROM PERSONNEL; -- 모든 컬럼이 다보임

SELECT PNO, PNAME, PAY, DNO FROM PERSONNEL; -- 컬럼에서 원하는 부분만 볼 때

SELECT PAY, PNAME, PNO, DNO FROM PERSONNEL;  -- 순서가 바껴도 상관 X

SELECT JOB FROM PERSONNEL; -- JOB이라는 컬럼만 검색

SELECT DISTINCT JOB FROM PERSONNEL; -- DISTINCT : 중복되는 데이터 삭제


SELECT PNO, PNAME, PAY FROM PERSONNEL 
ORDER BY PAY ASC; -- 오름차순으로 정렬

SELECT PNO, PNAME, PAY FROM PERSONNEL 
ORDER BY PNAME;

SELECT PNO, PNAME, PAY FROM PERSONNEL 
ORDER BY PAY DESC; -- 내림차순으로 정렬

SELECT * FROM PERSONNEL
ORDER BY STARTDATE; -- 날짜 순(오래된 사람순으로 정렬)

--사원번호가 높은 순서대로 정렬하시오
SELECT * FROM PERSONNEL
ORDER BY PNO DESC;

SELECT * FROM PERSONNEL; -- 우리는 데이터가 적기에 괜찮은데 회사에서는 데이터가
						 -- 엄청많기 때문에 신중하게 써야한다.

SELECT * FROM PERSONNEL;
DESC PERSONNEL; -- 컬럼에 대한 정보를 보여줌 실행안되면 위 문장을 써준다
						 
SELECT PNO, PNAME, PAY, PAY + 1000 AS 보너스 FROM PERSONNEL; -- 쿼리는 연산이 가능


SELECT PNO, PNAME, PAYM, PAY + 1000  보너스 FROM PERSONNEL -- AS는 생략가능
ORDER BY PAY+1000; -- ORDER BY만 별칭을 쓸 수 있다.

SELECT PNO, PNAME, PAY + 1000  보너스 FROM PERSONNEL -- AS는 생략가능
ORDER BY 보너스; -- ORDER BY만 별칭을 쓸 수 있다.

SELECT PNO, PNAME, PAY, PAY + 1000  보너스 FROM PERSONNEL -- AS는 생략가능
ORDER BY 4; -- 4번째 컬럼으로 정렬해라
--위 3개는 같은 거

SELECT * FROM PERSONNEL
ORDER BY 4;


SELECT DNO, PNO, PNAME FROM PERSONNEL
ORDER BY DNO DESC, PNO; --ASC는 생략가능

--부서번호(DNO)는 오름차순, 사원번호(PNO)는 내림차순 정렬

SELECT * FROM PERSONNEL
ORDER BY DNO, PNO DESC; -- DNO 오름차순(ASC)는 생략되어 있음


--NULL
--NULL은 어떠한 값을 연산해줘도 값은 NULL이 나온다. 

SELECT * FROM PERSONNEL --오라클에서는 작은값에서 큰값순으로 정렬하면 NULL이 마지막으로 나온다.
ORDER BY MANAGER ASC;

SELECT * FROM PERSONNEL
ORDER BY MANAGER DESC;


--사원의 급여와 1년치 연봉(ANNUAL)을 구하시오.
SELECT DNO,PNO,PNAME,PAY,(PAY*12) + NVL(BONUS,0) ANNUAL_PAY FROM PERSONNEL;
--NVL(BONUS,0) : 보너스가 있으면 더하고 없으면 0을 더한다.(NULL값 처리방법)


SELECT PAY, PAY-500 FROM PERSONNEL; -- PAY에서 5O0을 뺀 값

SELECT PNAME || PNO FROM PERSONNEL; -- 컬럼 2개를 연결할 때 사용

SELECT PNAME || ' ' || PNO FROM PERSONNEL; --세부주소할때 사용? 문자를 쓸 때' ' 사용

SELECT * FROM PERSONNEL; --모든 컬럼들을 보여줌

SELECT PNO, PNAME FROM PERSONNEL; --내가 보고싶은 컬럼(열) 보여줌

--행 
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN'; -- 소문자로 입력하면 안나옴.오라클은 내가 소문자로 입력해도 들어가면 대문자로 저장된다.

--연산자
-- =, >, <, ,<=, >=, <> --   <> :같지 않다.

--급여가 1600인 사원을 검색하시오
SELECT * FROM PERSONNEL
WHERE PAY = 1600;

--사원번호가 1116인 사원을 검색하시오.
SELECT * FROM PERSONNEL
WHERE PNO = 1116;

--사원의 급여가 2000이하인 사원을 검색하시오.
SELECT * FROM PERSONNEL
WHERE PAY<=2000;

--1990년 12월 17일에 입사한 사원 검색
SELECT * FROM PERSONNEL
WHERE STARTDATE = '1990/12/17'; -- '1990-12-17'이렇게 해도되지만 안될때가 있음 그래서 /로 해주는게 좋음 

SELECT * FROM NLS_SESSION_PARAMETERS; -- KIM이 가지고 있는 환경 세팅정보
-- RR/MM/DD


--업무가 CLERK인 사원을 찾으세요.
SELECT * FROM PERSONNEL
WHERE JOB = 'CLERK';

--이름이 JAMES인 사원을 찾으시오.
SELECT * FROM PERSONNEL
WHERE PNAME = 'JAMES';


--논리 연산자
--AND, OR, NOT(!)


--AND
--부서번호가 10번이고 급여가 3000이상인 사원을 찾으시오
SELECT * FROM PERSONNEL
WHERE DNO = 10 AND PAY >= 3000;

--직업이 SALESMAN이고 90년 이후에 입사한 직원을 찾으시오
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN' AND STARTDATE >= '1991/01/01'; -- STARTDATE > '1990/12/31';


--91년 9월에 입사한 직원을 찾으시오
SELECT * FROM PERSONNEL
WHERE STARTDATE >= '1991/09/01' AND STARTDATE <= '1991/09/30';


--OR
--부서번호가 10번이거나 급여가 3000이상인 사원을 찾으시오
SELECT * FROM PERSONNEL
WHERE DNO = 10 OR PAY >= 3000;

--직업이 MANAGER이거나 90년 이전에 입사한 직원을 찾으시오
SELECT * FROM PERSONNEL
WHERE JOB = 'MANAGER' OR STARTDATE < '1990/01/01';


--NOT(!) -문자열 연산자
--업무가 SALESMAN, CLERK인 직원을 찾으시오
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN' OR JOB = 'CLERK';

SELECT * FROM PERSONNEL
WHERE JOB IN('SALESMAN', 'CLERK'); -- IN연산자는  JOB이 SALESMAN이거나 CLERK인 데이터를 가져와라  위의 코딩과 동일



--업무가 SALESMAN, CLERK이 아닌 직원을 찾으시오
SELECT * FROM PERSONNEL
WHERE JOB NOT IN('SALESMAN', 'CLERK'); -- NOT은 NOT자신뒤쪽을 부정한다.

SELECT * FROM PERSONNEL
WHERE JOB<> 'SALESMAN' AND JOB<>'CLERK'; -- 위의 결과와 같다


--급여가 1000에서 2000 사이의 사원을 찾으시오
SELECT * FROM PERSONNEL
WHERE PAY >=1000 AND PAY<2000;

SELECT * FROM PERSONNEL
WHERE PAY BETWEEN 1000 AND 2000; -- 위와 같다  작은수부터 써야한다 -> 문자열 연산자 


--9월달에 입사한 사람을 찾으시오
SELECT * FROM PERSONNEL
WHERE STARTDATE BETWEEN '1991/09/01' AND '1991/09/30';


--부서번호가 20과 30사이가 아닌 사원을 찾으시오
SELECT * FROM PERSONNEL
WHERE DNO NOT IN(20,30); -- 애는 정확히 20과 30을 찾고


SELECT * FROM DIVISION;

SELECT * FROM PERSONNEL
WHERE DNO NOT BETWEEN 20 AND 30; -- 애는 20번부터 30번사이를 찾는다. 결론은 위와 다르다.


--91년 5월 1일부터 92년 2월24일 사이에 입사한 사원이 아닌 직원을 찾으시오
SELECT * FROM PERSONNEL
WHERE STARTDATE NOT BETWEEN '1991/05/01' AND '1992/02/24';


--이름이 A로 시작되는 사원 정보를 찾으세요
SELECT * FROM PERSONNEL
WHERE PNAME LIKE 'A%';  -- = WHERE PNAME = 'A%'; -> 이거는 A%를 찾는거다. 
                        --LIKE를 쓰면 A로 시작하는 것 %는 뒤에 뭐가오든 상관없다는 뜻 %A로 하면 마지막이 A인 사람 검색
                        
                        
                        
--사원번호가 111_인 사원을 찾으시오. _(언더바)이거는 자리를 뜻한다. 111_는 4자리인데 마지막 자리는 어떤 숫자가 와도 상관 X

SELECT * FROM PERSONNEL
WHERE PNO LIKE '111_'; -- 애는 한자리만 찾을때

SELECT * FROM PERSONNEL
WHERE PNO LIKE '11%'; -- 애는 11뒤에 몇자리가와도 상관없을 때 찾는 방법


SELECT * FROM PERSONNEL
WHERE PNO LIKE '1__1'; 


--90년도에 입사한 사원을 찾으시오
SELECT * FROM PERSONNEL
WHERE STARTDATE LIKE '90%';



--정규화 표현식
SELECT * FROM PERSONNEL
WHERE REGEXP_LIKE(PNO, '11[^2]'); --정규화 표현식 - 3째자리가 2가 아닌 것만 나옴

SELECT * FROM PERSONNEL
WHERE REGEXP_LIKE(PNO, '1[1,2]'); -- 정규화 표현식 - 첫째자리는 1이고 두번째가 1 혹은 2로 시작하는거만 나옴 


--이메일에서 아이디 추출하기 ( 정규화 표현식)
SELECT REGEXP_SUBSTR('SUZI@NAVER.COM', '[^@]+') 아이디 FROM DUAL; -- ^(꺽새) 앞부분과 뒷부분 데이터만 보여줌


SELECT * FROM DUAL; -- DUAL테이블 검색
 

SELECT 100+300 FROM DUAL; --DUAL자리에 PERSONNEL등 다른걸쓰면 테이블 개수만큼 나오는데 DUAL을 쓰면 한번만 나옴
--이럴때 쓸려고 만든 테이블이다.


--NULL
SELECT MANAGER FROM PERSONNEL; -- PERSONNEL에서 MANAGER 테이블 찾아오기

SELECT * FROM PERSONNEL
WHERE MANAGER = NULL; -- 이건 안된다(오류뜸)오라클에서는 안되지만 MSSQL에서는 옵션을 바꿀수있는 기능을 넣어둠



--이방법이 NULL을 찾는 방법이다
SELECT * FROM PERSONNEL
WHERE MANAGER IS NULL; --매니저가 NULL인 데이터 찾기

--매니저가 NULL이 아닌 데이터 찾기
SELECT * FROM PERSONNEL
WHERE MANAGER IS NOT NULL;

------------------------------------------------------------------------------------------------------------------------------

--01/24일 시작

--우선 순위

--업무가 MANAGER이고 급여가 1500이상인 사원 또는 업무가 
--SALESMAN 인 사원의 정보를 찾으세요
SELECT * FROM PERSONNEL WHERE (JOB = 'MANAGER') AND PAY >= 1500 OR JOB = 'SALESMAN'; --괄호를 묶은것이 먼저 연산이 된다

--업무가 'PRESIDENT' 또는 'SALESMAN'이며 페이가 1500이상인 사원을 찾으시오
SELECT * FROM PERSONNEL WHERE JOB IN ('PRESIDENT','SALESMAN') AND PAY >= 1500;

--함수

--숫자 함수
--ROUND(반올림)
SELECT ROUND(45.275,1) FROM DUAL; --45.3
SELECT ROUND(45.275,-1) FROM DUAL; --50

--  1  2  3  4  .  5  6  7
-- -4 -3 -2 -1  0  1  2  3

SELECT PNO,PNAME,PAY,ROUND(PAY,-2) FROM PERSONNEL;

--TRUNC(절삭) 그 해당자리에 나머지를 그냥 자른다.
SELECT TRUNC(45.249,2) FROM DUAL; --45.24
SELECT TRUNC(45.245,-1) FROM DUAL; --40

SELECT PNO,PNAME,PAY,TRUNC(PAY,-2) FROM PERSONNEL; --반올림 안하고 다 자름

--CEIL/FLOOR(올림/내림) : 정수만 반환
SELECT CEIF(461.21) FROM DUAL; -- 462
SELECT FLOOR(461.91) FROM DUAL;  -- 461

--MOD(나머지)
SELECT MOD(10,3) FROM DUAL;

--ABS(절대값) - 무조건 양수로 만들어줌
SELECT ABS(-123) FROM DUAL;

--SIGN(반환값이 양수면 1, 음수면 -1, 0이면 0)
SELECT SIGN(100), SIGN(-100), SIGN(0) FROM DUAL;

--지수
SELECT POWER(2,4) FROM DUAL; -- 2의 4승 값이 나옴

--제곱근
SELECT SQRT(9) FROM DUAL; -- 3 (루트)



--문자 함수
--UPPER(소문자 -> 대문자)
SELECT UPPER('oracle') FROM DUAL;

--LOWER(대문자 -> 소문자)
SELECT LOWER('ORACLE') FROM DUAL;

SELECT * FROM DIVISION;

SELECT DNO, DNAME FROM DIVISION
WHERE DNAME = UPPER('sales');

SELECT DNO, DNAME FROM DIVISION
WHERE LOWER(DNAME) = 'sales';

--INITCAP - 첫 글자만 대문자로 출력
SELECT INITCAP('korea fighting') FROM DUAL;

--CONCAT - ||와 동일한 의미( 두 문자열 연결)
SELECT PNAME || DNO FROM PERSONNEL;
SELECT CONCAT(PNAME, DNO) FROM PERSONNEL;

--LENGTH - 문자열의 길이 출력
SELECT LENGTH('KOREA FIGHTING') FROM DUAL; -- 14

--SUBSTR - 부분 문자열을 출력 / x번째 문자부터 y개
SELECT SUBSTR('ABCDEFG', 1, 3) FROM DUAL; --ABC
SELECT SUBSTR('ABCDEFG', 3, 2) FROM DUAL; --CD
SELECT SUBSTR('ABCDEFG', -3, 2) FROM DUAL; --EF
SELECT SUBSTR('ABCDEFG', -4) FROM DUAL; --DEFG


--INSTR - 찾는 문자열의 위치를 반환
SELECT INSTR('ABCDEFG', 'C') FROM DUAL; -- 3

SELECT INSTR('AAAAAAA', 'A') FROM DUAL; -- 1       sql은 index번호가 1부터 시작함 그래서 찾는 데이터가 없으면 0이 나옴
SELECT INSTR('AAAAAAA', 'a') FROM DUAL; -- 0


--RPAD/LPAD
-- RPAD : 주어진 자릿수만큼 오른쪽에 채운다. 
-- LPAD : 주어진 자릿수만큼 왼쪽에 채운다.
SELECT RPAD(PNAME, 15, '*') FROM PERSONNEL;

--RTRIM/LTRIM
-- RTRIM : 반대로
-- LTRIM : 첫번째 문자열 왼쪽부터 두 번째 문자열을 지워줌
SELECT RTRIM('ABBBBB', 'B') FROM DUAL; -- B를 다 지워라
SELECT RTRIM('A     ', ' ') FROM DUAL; --공백지워라

SELECT RTRIM('ABBABB', 'B') FROM DUAL; 


--날짜 함수
--SYSDATE(GETDATE())
SELECT SYSDATE FROM DUAL; -- 현재 날짜(시간까지 포함)를 읽어와라

--SQL에서도 날짜는 JAVA처럼 연산이 가능하다.
SELECT SYSDATE + 4 FROM DUAL; 

SELECT STARTDATE-1, STARTDATE, STARTDATE+1 FROM PERSONNEL; -- 입사 전날 , 당일, 입사 다음날 


--KIM 사원이 오늘까지 근무한 날수(년수)를 구하세요.
SELECT SYSDATE, STARTDATE, ROUND((SYSDATE - STARTDATE)/365) || '년' YEARS
FROM PERSONNEL WHERE PNAME = 'KIM';

SELECT SYSDATE, STARTDATE, CEIL((SYSDATE - STARTDATE)/365) || '년' YEARS
FROM PERSONNEL WHERE PNAME = 'KIM'; --ROUND보다 CEIL를 쓰는게 더 좋다 여기서는


--ROUND   - 날짜에도 적용가능하다
SELECT STARTDATE, ROUND(STARTDATE, 'YEAR') FROM PERSONNEL; -- YEAR로 반올림

SELECT STARTDATE, ROUND(STARTDATE, 'MONTH') FROM PERSONNEL; -- MONTH로 반올림

SELECT STARTDATE, ROUND(STARTDATE, 'DD') FROM PERSONNEL; -- DAY로 반올림

--TRUNC ( 절삭) -- 날짜도 절삭가능
SELECT STARTDATE, TRUNC(STARTDATE, 'MONTH') FROM PERSONNEL; 


--MONTHS_BETWEEN ( 달 수 구하기)
SELECT ROUND(MONTHS_BETWEEN(SYSDATE, '2002/06/01')/12) YEAR FROM DUAL;

--LAST_DAY (입사한 달의 마지막날 구하기)
SELECT STARTDATE, LAST_DAY(STARTDATE) FROM PERSONNEL;

--NEXT_DAY (오늘기준 돌아오는 토요일 구하기) - 돌아오는 날 구하기
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL;

--ADD_MONTHS (오늘 기준으로 4개월 뒤 구하기)
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL;
--ADD_MONTHS  오늘 기준으로 24개월 뒤 구하기
SELECT ADD_MONTHS(SYSDATE, 24) FROM DUAL;



--변환 함수(TO_CHAR)

--대표적인 예는 TO_CHAR  (숫자나 날짜를 문자로 변경해준다)      많이 쓴다  
--MM : 달수(10)
--MON : 3문자 달이름(MAR)
--MONTH : 달의 풀네임(MARCH)
--DD : 달의 날짜수(22)
--D : 주의 일 수(2)
--DY : 3문자 요일이름(MON)
--DAY : 일의 풀네임(화)
--YYYY : 4자리 년도
--YY : 2자리 연도
--RM : 로마식 달수

--문자는 연산이 안된다. 여기선 날짜를 문자로 바뀐 것이다.
SELECT SYSDATE, TO_CHAR(SYSDATE, 'D') FROM DUAL; --2
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DY') FROM DUAL; -- 월
SELECT SYSDATE, TO_CHAR(SYSDATE, 'RM') FROM DUAL; -- 1
SELECT SYSDATE, TO_CHAR(SYSDATE, 'MON') FROM DUAL; --1월
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DAY') FROM DUAL; --월요일
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL; -- 2022-01-24 ------> 이 코딩 많이씀 외우기 !! 중요!! 필수!!
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD-MM-YY') FROM DUAL;



--시간 형식
/*
HH, HH12
HH24
MI : 분
SS : 초
SSSSS : 초의 자릿수
AM, PM : 오전, 오후
A.M, P.M : 오전, 오후 (위와 동일)
*/
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL; -- 현재 시간이 문자로 보여진다.
SELECT TO_CHAR(SYSDATE, 'AMHH:MI:SS') FROM DUAL;



--숫자 형식 
/*
9 : 자릿수(9999 -> 1218)
0 : 자릿수가 비면 0으로 표시(09999 -> 01234) 
PR : 음수(9999, PR -> <1234>) -회계에서 자주 사용
, : 천 자릿수(9,999 -> 1,000)
*/
SELECT TO_CHAR(12506, '$099,999.99') FROM DUAL; -- $012,506.00


-- 서수
-- SP, TH
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DDSP') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DDTH') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DDSPTH') FROM DUAL;


-- TO_DATE  (문자를 날짜로 바꿈)  + 문자를 날짜로 바꾸었기 때문에 연산이 가능함
SELECT TO_DATE('22-01-24', 'YY-MM-DD') + 10 FROM DUAL;
SELECT TO_DATE('13:38', 'HH24:MI') FROM DUAL;

--TO_NUMBER (문자를 숫자로 바꿈)
SELECT TO_NUMBER('123') + 100 FROM DUAL;

SELECT TO_NUMBER('ABC') FROM DUAL; -- 에러! 

--NVL

--보너스가 있으면 쓰고 없으면 0으로 바꾼다.
SELECT BONUS, NVL(BONUS, 0) FROM PERSONNEL;

--MANAGER  값이 있으면 쓰고 없으면 NON MANAGER를 넣어라
SELECT MANAGER FROM PERSONNEL;

DESC PERSONNEL; -- 데이터 타입 보기

SELECT MANAGER, NVL(TO_CHAR(MANAGER), 'NON MANAGER') FROM PERSONNEL;


--DECODE
--각 사원의 급여를 부서번호가 10인 경우 10%를 증가시키고, 부서번호가 20인 경우 20% 증가시키고,
--나머지 부서는 30%를 증가
SELECT PNAME, BONUS, DNO, PAY,
DECODE(DNO,10,PAY*1.1, 20,PAY*1.2, PAY*1.3) 인상분--IF문과 비슷 DNO가 10인경우 PAY를 10%증가
FROM PERSONNEL;


--급여가 3500이상인 경우에는 GRADE를 'GOOD'로 표시하고 3500미만인 경우에는 'POOR'를 출력하시오(SIGN)
SELECT * FROM PERSONNEL;

SELECT PNAME, PAY,
DECODE(SIGN(PAY-3500),1, 'GRADE', 'POOR') GRADE 
FROM PERSONNEL;



--그룹 함수  - 그룹 함수는 결과가 무조건 1개 나옴.
--COUNT
SELECT COUNT(*) FROM PERSONNEL; -- 모든 데이터를 새라 어디? PERSONNEL테이블의

--급여가 3000이상인 사원의 수

SELECT COUNT(*) FROM PERSONNEL
WHERE PAY >= 3000;

SELECT COUNT(MANAGER) FROM PERSONNEL; -- 매너저 라는 컬럼의 인원수를 새라(NULL값은 셀 수 없어서 10개X 9개가 나온다)

SELECT COUNT(BONUS) FROM PERSONNEL; -- 3


--AVG
SELECT AVG(PAY) FROM PERSONNEL; --PAY의 평균

--SUM
SELECT SUM(PAY) FROM PERSONNEL;

--MAX/MIN
SELECT MAX(PAY), MIN(PAY) FROM PERSONNEL;

SELECT * FROM PERSONNEL;
-- 사원 중에 입사한지 가장 오래된 직원을 찾으시오
SELECT MIN(STARTDATE) FROM PERSONNEL;

--입사한지 가장 오래된 사원과 신입사원과의 날 수를 찾으시오
SELECT ROUND((MAX(STARTDATE) - MIN(STARTDATE))/365) AS 년 FROM PERSONNEL;


--분석 함수
--부서별 평균
SELECT DISTINCT DNO, AVG(PAY) OVER(PARTITION BY DNO) -- DISTINCT를 써서 각각 부서별 평균을 구한다.
FROM PERSONNEL;

--월급 1200을 받는 사람 순위 (이건 공식이다)
SELECT * FROM PERSONNEL ORDER BY PAY DESC;

SELECT RANK(1200) WITHIN GROUP (ORDER BY PAY DESC) RANK
FROM PERSONNEL;


SELECT PNAME, PAY, RANK() OVER(ORDER BY PAY DESC) RANK --랭크 구하는 공식( 나중에 씀 꼭 외우기)
FROM PERSONNEL;


--GROUP BY
SELECT PNAME FROM PERSONNEL; -- 이걸 다중값 반환 쿼리라고 한다.

SELECT * FROM PERSONNEL WHERE PAY = 1600; -- 다중값 반환 쿼리


SELECT COUNT(*) FROM PERSONNEL; -- 이걸 단일값 반환 쿼리라고 한다.



SELECT PNAME, MIN(STARTDATE) FROM PERSONNEL; --PNAME은 단일, MIN은 다중값을 반환하는 쿼리라고 에러 뜸!!!


--하위 쿼리 (나중에 배울거임) 쿼리 안에 쿼리가 들어가있음
SELECT PNAME, STARTDATE FROM PERSONNEL
WHERE STARTDATE = (SELECT MIN(STARTDATE) FROM PERSONNEL);


--GROUP BY 문제
--부서별 평균 급여를 구하세요.
SELECT DNO, AVG(PAY) FROM PERSONNEL -- 부서별 평균이기에 SELECT 앞에 DNO(부서)를 적어준다!
GROUP BY DNO;



SELECT STARTDATE, 
EXTRACT(YEAR FROM STARTDATE) 년,
EXTRACT(MONTH FROM STARTDATE) 월,
EXTRACT(DAY FROM STARTDATE) 일         -- FROM 앞에는 쉼표가 있으면 안되서 여기선 지워준다.
FROM PERSONNEL;


-- 각 부서의 평균 급여가 전체 평균급여(2972.5)보다 크면 'GOOD'   ---어렵다.. 공식 자체를 외우기
-- 작으면 'POOR' 를 출력하시오

SELECT AVG(PAY) FROM PERSONNEL;

SELECT DNO, AVG(PAY),
DECODE(SIGN(AVG(PAY) - (SELECT AVG(PAY) FROM PERSONNEL)), 1, 'GOOD', 'POOR') AS GRADE
FROM PERSONNEL
GROUP BY DNO;


--GROUP BY의 조건문은 HAVING이다. 
SELECT AVG(PAY) FROM PERSONNEL;

SELECT DNO, AVG(PAY),
DECODE(SIGN(AVG(PAY) - (SELECT AVG(PAY) FROM PERSONNEL)), 1, 'GOOD', 'POOR') AS GRADE
FROM PERSONNEL
GROUP BY DNO
HAVING DNO = 20;
