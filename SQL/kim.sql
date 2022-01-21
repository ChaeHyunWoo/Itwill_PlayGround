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

      