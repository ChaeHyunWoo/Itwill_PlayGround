select * from tab;
SELECT * FROM PERSONNEL;
/*
1. query
   select data�˻���

2. dml(data maipulation language)
    insert, update, delete
    
3. ddl(data difinition language)
    create, alter, drop, rename
    
4. tcl(transaction control language)
    commit (save�� ����) , rollback (����� ����)
    
5. dcl(data control language)
    grant(������ �� ��), revoke(������ ���� ��)
    */
    
select * from tab;

select * from personnel; 
select * from division;
select * from PAYGRADE; 
select * from BONUS;

SELECT * FROM PERSONNEL; -- ��� �÷��� �ٺ���

SELECT PNO, PNAME, PAY, DNO FROM PERSONNEL; -- �÷����� ���ϴ� �κи� �� ��

SELECT PAY, PNAME, PNO, DNO FROM PERSONNEL;  -- ������ �ٲ��� ��� X

SELECT JOB FROM PERSONNEL; -- JOB�̶�� �÷��� �˻�

SELECT DISTINCT JOB FROM PERSONNEL; -- DISTINCT : �ߺ��Ǵ� ������ ����


SELECT PNO, PNAME, PAY FROM PERSONNEL 
ORDER BY PAY ASC; -- ������������ ����

SELECT PNO, PNAME, PAY FROM PERSONNEL 
ORDER BY PNAME;

SELECT PNO, PNAME, PAY FROM PERSONNEL 
ORDER BY PAY DESC; -- ������������ ����

SELECT * FROM PERSONNEL
ORDER BY STARTDATE; -- ��¥ ��(������ ��������� ����)

--�����ȣ�� ���� ������� �����Ͻÿ�
SELECT * FROM PERSONNEL
ORDER BY PNO DESC;

SELECT * FROM PERSONNEL; -- �츮�� �����Ͱ� ���⿡ �������� ȸ�翡���� �����Ͱ�
						 -- ��û���� ������ �����ϰ� ����Ѵ�.

SELECT * FROM PERSONNEL;
DESC PERSONNEL; -- �÷��� ���� ������ ������ ����ȵǸ� �� ������ ���ش�
						 
SELECT PNO, PNAME, PAY, PAY + 1000 AS ���ʽ� FROM PERSONNEL; -- ������ ������ ����


SELECT PNO, PNAME, PAYM, PAY + 1000  ���ʽ� FROM PERSONNEL -- AS�� ��������
ORDER BY PAY+1000; -- ORDER BY�� ��Ī�� �� �� �ִ�.

SELECT PNO, PNAME, PAY + 1000  ���ʽ� FROM PERSONNEL -- AS�� ��������
ORDER BY ���ʽ�; -- ORDER BY�� ��Ī�� �� �� �ִ�.

SELECT PNO, PNAME, PAY, PAY + 1000  ���ʽ� FROM PERSONNEL -- AS�� ��������
ORDER BY 4; -- 4��° �÷����� �����ض�
--�� 3���� ���� ��

SELECT * FROM PERSONNEL
ORDER BY 4;


SELECT DNO, PNO, PNAME FROM PERSONNEL
ORDER BY DNO DESC, PNO; --ASC�� ��������

--�μ���ȣ(DNO)�� ��������, �����ȣ(PNO)�� �������� ����

SELECT * FROM PERSONNEL
ORDER BY DNO, PNO DESC; -- DNO ��������(ASC)�� �����Ǿ� ����


--NULL
--NULL�� ��� ���� �������൵ ���� NULL�� ���´�. 

SELECT * FROM PERSONNEL --����Ŭ������ ���������� ū�������� �����ϸ� NULL�� ���������� ���´�.
ORDER BY MANAGER ASC;

SELECT * FROM PERSONNEL
ORDER BY MANAGER DESC;


--����� �޿��� 1��ġ ����(ANNUAL)�� ���Ͻÿ�.
SELECT DNO,PNO,PNAME,PAY,(PAY*12) + NVL(BONUS,0) ANNUAL_PAY FROM PERSONNEL;
--NVL(BONUS,0) : ���ʽ��� ������ ���ϰ� ������ 0�� ���Ѵ�.(NULL�� ó�����)


SELECT PAY, PAY-500 FROM PERSONNEL; -- PAY���� 5O0�� �� ��

SELECT PNAME || PNO FROM PERSONNEL; -- �÷� 2���� ������ �� ���

SELECT PNAME || ' ' || PNO FROM PERSONNEL; --�����ּ��Ҷ� ���? ���ڸ� �� ��' ' ���

SELECT * FROM PERSONNEL; --��� �÷����� ������

SELECT PNO, PNAME FROM PERSONNEL; --���� ������� �÷�(��) ������

--�� 
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN'; -- �ҹ��ڷ� �Է��ϸ� �ȳ���.����Ŭ�� ���� �ҹ��ڷ� �Է��ص� ���� �빮�ڷ� ����ȴ�.

--������
-- =, >, <, ,<=, >=, <> --   <> :���� �ʴ�.

--�޿��� 1600�� ����� �˻��Ͻÿ�
SELECT * FROM PERSONNEL
WHERE PAY = 1600;

--�����ȣ�� 1116�� ����� �˻��Ͻÿ�.
SELECT * FROM PERSONNEL
WHERE PNO = 1116;

--����� �޿��� 2000������ ����� �˻��Ͻÿ�.
SELECT * FROM PERSONNEL
WHERE PAY<=2000;

--1990�� 12�� 17�Ͽ� �Ի��� ��� �˻�
SELECT * FROM PERSONNEL
WHERE STARTDATE = '1990/12/17'; -- '1990-12-17'�̷��� �ص������� �ȵɶ��� ���� �׷��� /�� ���ִ°� ���� 

SELECT * FROM NLS_SESSION_PARAMETERS; -- KIM�� ������ �ִ� ȯ�� ��������
-- RR/MM/DD


--������ CLERK�� ����� ã������.
SELECT * FROM PERSONNEL
WHERE JOB = 'CLERK';

--�̸��� JAMES�� ����� ã���ÿ�.
SELECT * FROM PERSONNEL
WHERE PNAME = 'JAMES';


--�� ������
--AND, OR, NOT(!)


--AND
--�μ���ȣ�� 10���̰� �޿��� 3000�̻��� ����� ã���ÿ�
SELECT * FROM PERSONNEL
WHERE DNO = 10 AND PAY >= 3000;

--������ SALESMAN�̰� 90�� ���Ŀ� �Ի��� ������ ã���ÿ�
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN' AND STARTDATE >= '1991/01/01'; -- STARTDATE > '1990/12/31';


--91�� 9���� �Ի��� ������ ã���ÿ�
SELECT * FROM PERSONNEL
WHERE STARTDATE >= '1991/09/01' AND STARTDATE <= '1991/09/30';


--OR
--�μ���ȣ�� 10���̰ų� �޿��� 3000�̻��� ����� ã���ÿ�
SELECT * FROM PERSONNEL
WHERE DNO = 10 OR PAY >= 3000;

--������ MANAGER�̰ų� 90�� ������ �Ի��� ������ ã���ÿ�
SELECT * FROM PERSONNEL
WHERE JOB = 'MANAGER' OR STARTDATE < '1990/01/01';


--NOT(!) -���ڿ� ������
--������ SALESMAN, CLERK�� ������ ã���ÿ�
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN' OR JOB = 'CLERK';

SELECT * FROM PERSONNEL
WHERE JOB IN('SALESMAN', 'CLERK'); -- IN�����ڴ�  JOB�� SALESMAN�̰ų� CLERK�� �����͸� �����Ͷ�  ���� �ڵ��� ����



--������ SALESMAN, CLERK�� �ƴ� ������ ã���ÿ�
SELECT * FROM PERSONNEL
WHERE JOB NOT IN('SALESMAN', 'CLERK'); -- NOT�� NOT�ڽŵ����� �����Ѵ�.

SELECT * FROM PERSONNEL
WHERE JOB<> 'SALESMAN' AND JOB<>'CLERK'; -- ���� ����� ����


--�޿��� 1000���� 2000 ������ ����� ã���ÿ�
SELECT * FROM PERSONNEL
WHERE PAY >=1000 AND PAY<2000;

SELECT * FROM PERSONNEL
WHERE PAY BETWEEN 1000 AND 2000; -- ���� ����  ���������� ����Ѵ� -> ���ڿ� ������ 


--9���޿� �Ի��� ����� ã���ÿ�
SELECT * FROM PERSONNEL
WHERE STARTDATE BETWEEN '1991/09/01' AND '1991/09/30';


--�μ���ȣ�� 20�� 30���̰� �ƴ� ����� ã���ÿ�
SELECT * FROM PERSONNEL
WHERE DNO NOT IN(20,30); -- �ִ� ��Ȯ�� 20�� 30�� ã��


SELECT * FROM DIVISION;

SELECT * FROM PERSONNEL
WHERE DNO NOT BETWEEN 20 AND 30; -- �ִ� 20������ 30�����̸� ã�´�. ����� ���� �ٸ���.


--91�� 5�� 1�Ϻ��� 92�� 2��24�� ���̿� �Ի��� ����� �ƴ� ������ ã���ÿ�
SELECT * FROM PERSONNEL
WHERE STARTDATE NOT BETWEEN '1991/05/01' AND '1992/02/24';


--�̸��� A�� ���۵Ǵ� ��� ������ ã������
SELECT * FROM PERSONNEL
WHERE PNAME LIKE 'A%';  -- = WHERE PNAME = 'A%'; -> �̰Ŵ� A%�� ã�°Ŵ�. 
                        --LIKE�� ���� A�� �����ϴ� �� %�� �ڿ� �������� ������ٴ� �� %A�� �ϸ� �������� A�� ��� �˻�
                        
                        
                        
--�����ȣ�� 111_�� ����� ã���ÿ�. _(�����)�̰Ŵ� �ڸ��� ���Ѵ�. 111_�� 4�ڸ��ε� ������ �ڸ��� � ���ڰ� �͵� ��� X

SELECT * FROM PERSONNEL
WHERE PNO LIKE '111_'; -- �ִ� ���ڸ��� ã����

SELECT * FROM PERSONNEL
WHERE PNO LIKE '11%'; -- �ִ� 11�ڿ� ���ڸ����͵� ������� �� ã�� ���


SELECT * FROM PERSONNEL
WHERE PNO LIKE '1__1'; 


--90�⵵�� �Ի��� ����� ã���ÿ�
SELECT * FROM PERSONNEL
WHERE STARTDATE LIKE '90%';



--����ȭ ǥ����
SELECT * FROM PERSONNEL
WHERE REGEXP_LIKE(PNO, '11[^2]'); --����ȭ ǥ���� - 3°�ڸ��� 2�� �ƴ� �͸� ����

SELECT * FROM PERSONNEL
WHERE REGEXP_LIKE(PNO, '1[1,2]'); -- ����ȭ ǥ���� - ù°�ڸ��� 1�̰� �ι�°�� 1 Ȥ�� 2�� �����ϴ°Ÿ� ���� 


--�̸��Ͽ��� ���̵� �����ϱ� ( ����ȭ ǥ����)
SELECT REGEXP_SUBSTR('SUZI@NAVER.COM', '[^@]+') ���̵� FROM DUAL; -- ^(����) �պκа� �޺κ� �����͸� ������


SELECT * FROM DUAL; -- DUAL���̺� �˻�
 

SELECT 100+300 FROM DUAL; --DUAL�ڸ��� PERSONNEL�� �ٸ��ɾ��� ���̺� ������ŭ �����µ� DUAL�� ���� �ѹ��� ����
--�̷��� ������ ���� ���̺��̴�.


--NULL
SELECT MANAGER FROM PERSONNEL; -- PERSONNEL���� MANAGER ���̺� ã�ƿ���

SELECT * FROM PERSONNEL
WHERE MANAGER = NULL; -- �̰� �ȵȴ�(������)����Ŭ������ �ȵ����� MSSQL������ �ɼ��� �ٲܼ��ִ� ����� �־��



--�̹���� NULL�� ã�� ����̴�
SELECT * FROM PERSONNEL
WHERE MANAGER IS NULL; --�Ŵ����� NULL�� ������ ã��

--�Ŵ����� NULL�� �ƴ� ������ ã��
SELECT * FROM PERSONNEL
WHERE MANAGER IS NOT NULL;

------------------------------------------------------------------------------------------------------------------------------

--01/24�� ����

--�켱 ����

--������ MANAGER�̰� �޿��� 1500�̻��� ��� �Ǵ� ������ 
--SALESMAN �� ����� ������ ã������
SELECT * FROM PERSONNEL WHERE (JOB = 'MANAGER') AND PAY >= 1500 OR JOB = 'SALESMAN'; --��ȣ�� �������� ���� ������ �ȴ�

--������ 'PRESIDENT' �Ǵ� 'SALESMAN'�̸� ���̰� 1500�̻��� ����� ã���ÿ�
SELECT * FROM PERSONNEL WHERE JOB IN ('PRESIDENT','SALESMAN') AND PAY >= 1500;

--�Լ�

--���� �Լ�
--ROUND(�ݿø�)
SELECT ROUND(45.275,1) FROM DUAL; --45.3
SELECT ROUND(45.275,-1) FROM DUAL; --50

--  1  2  3  4  .  5  6  7
-- -4 -3 -2 -1  0  1  2  3

SELECT PNO,PNAME,PAY,ROUND(PAY,-2) FROM PERSONNEL;

--TRUNC(����) �� �ش��ڸ��� �������� �׳� �ڸ���.
SELECT TRUNC(45.249,2) FROM DUAL; --45.24
SELECT TRUNC(45.245,-1) FROM DUAL; --40

SELECT PNO,PNAME,PAY,TRUNC(PAY,-2) FROM PERSONNEL; --�ݿø� ���ϰ� �� �ڸ�

--CEIL/FLOOR(�ø�/����) : ������ ��ȯ
SELECT CEIF(461.21) FROM DUAL; -- 462
SELECT FLOOR(461.91) FROM DUAL;  -- 461

--MOD(������)
SELECT MOD(10,3) FROM DUAL;

--ABS(���밪) - ������ ����� �������
SELECT ABS(-123) FROM DUAL;

--SIGN(��ȯ���� ����� 1, ������ -1, 0�̸� 0)
SELECT SIGN(100), SIGN(-100), SIGN(0) FROM DUAL;

--����
SELECT POWER(2,4) FROM DUAL; -- 2�� 4�� ���� ����

--������
SELECT SQRT(9) FROM DUAL; -- 3 (��Ʈ)



--���� �Լ�
--UPPER(�ҹ��� -> �빮��)
SELECT UPPER('oracle') FROM DUAL;

--LOWER(�빮�� -> �ҹ���)
SELECT LOWER('ORACLE') FROM DUAL;

SELECT * FROM DIVISION;

SELECT DNO, DNAME FROM DIVISION
WHERE DNAME = UPPER('sales');

SELECT DNO, DNAME FROM DIVISION
WHERE LOWER(DNAME) = 'sales';

--INITCAP - ù ���ڸ� �빮�ڷ� ���
SELECT INITCAP('korea fighting') FROM DUAL;

--CONCAT - ||�� ������ �ǹ�( �� ���ڿ� ����)
SELECT PNAME || DNO FROM PERSONNEL;
SELECT CONCAT(PNAME, DNO) FROM PERSONNEL;

--LENGTH - ���ڿ��� ���� ���
SELECT LENGTH('KOREA FIGHTING') FROM DUAL; -- 14

--SUBSTR - �κ� ���ڿ��� ��� / x��° ���ں��� y��
SELECT SUBSTR('ABCDEFG', 1, 3) FROM DUAL; --ABC
SELECT SUBSTR('ABCDEFG', 3, 2) FROM DUAL; --CD
SELECT SUBSTR('ABCDEFG', -3, 2) FROM DUAL; --EF
SELECT SUBSTR('ABCDEFG', -4) FROM DUAL; --DEFG


--INSTR - ã�� ���ڿ��� ��ġ�� ��ȯ
SELECT INSTR('ABCDEFG', 'C') FROM DUAL; -- 3

SELECT INSTR('AAAAAAA', 'A') FROM DUAL; -- 1       sql�� index��ȣ�� 1���� ������ �׷��� ã�� �����Ͱ� ������ 0�� ����
SELECT INSTR('AAAAAAA', 'a') FROM DUAL; -- 0


--RPAD/LPAD
-- RPAD : �־��� �ڸ�����ŭ �����ʿ� ä���. 
-- LPAD : �־��� �ڸ�����ŭ ���ʿ� ä���.
SELECT RPAD(PNAME, 15, '*') FROM PERSONNEL;

--RTRIM/LTRIM
-- RTRIM : �ݴ��
-- LTRIM : ù��° ���ڿ� ���ʺ��� �� ��° ���ڿ��� ������
SELECT RTRIM('ABBBBB', 'B') FROM DUAL; -- B�� �� ������
SELECT RTRIM('A     ', ' ') FROM DUAL; --����������

SELECT RTRIM('ABBABB', 'B') FROM DUAL; 


--��¥ �Լ�
--SYSDATE(GETDATE())
SELECT SYSDATE FROM DUAL; -- ���� ��¥(�ð����� ����)�� �о�Ͷ�

--SQL������ ��¥�� JAVAó�� ������ �����ϴ�.
SELECT SYSDATE + 4 FROM DUAL; 

SELECT STARTDATE-1, STARTDATE, STARTDATE+1 FROM PERSONNEL; -- �Ի� ���� , ����, �Ի� ������ 


--KIM ����� ���ñ��� �ٹ��� ����(���)�� ���ϼ���.
SELECT SYSDATE, STARTDATE, ROUND((SYSDATE - STARTDATE)/365) || '��' YEARS
FROM PERSONNEL WHERE PNAME = 'KIM';

SELECT SYSDATE, STARTDATE, CEIL((SYSDATE - STARTDATE)/365) || '��' YEARS
FROM PERSONNEL WHERE PNAME = 'KIM'; --ROUND���� CEIL�� ���°� �� ���� ���⼭��


--ROUND   - ��¥���� ���밡���ϴ�
SELECT STARTDATE, ROUND(STARTDATE, 'YEAR') FROM PERSONNEL; -- YEAR�� �ݿø�

SELECT STARTDATE, ROUND(STARTDATE, 'MONTH') FROM PERSONNEL; -- MONTH�� �ݿø�

SELECT STARTDATE, ROUND(STARTDATE, 'DD') FROM PERSONNEL; -- DAY�� �ݿø�

--TRUNC ( ����) -- ��¥�� ���谡��
SELECT STARTDATE, TRUNC(STARTDATE, 'MONTH') FROM PERSONNEL; 


--MONTHS_BETWEEN ( �� �� ���ϱ�)
SELECT ROUND(MONTHS_BETWEEN(SYSDATE, '2002/06/01')/12) YEAR FROM DUAL;

--LAST_DAY (�Ի��� ���� �������� ���ϱ�)
SELECT STARTDATE, LAST_DAY(STARTDATE) FROM PERSONNEL;

--NEXT_DAY (���ñ��� ���ƿ��� ����� ���ϱ�) - ���ƿ��� �� ���ϱ�
SELECT NEXT_DAY(SYSDATE, '�����') FROM DUAL;

--ADD_MONTHS (���� �������� 4���� �� ���ϱ�)
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL;
--ADD_MONTHS  ���� �������� 24���� �� ���ϱ�
SELECT ADD_MONTHS(SYSDATE, 24) FROM DUAL;



--��ȯ �Լ�(TO_CHAR)

--��ǥ���� ���� TO_CHAR  (���ڳ� ��¥�� ���ڷ� �������ش�)      ���� ����  
--MM : �޼�(10)
--MON : 3���� ���̸�(MAR)
--MONTH : ���� Ǯ����(MARCH)
--DD : ���� ��¥��(22)
--D : ���� �� ��(2)
--DY : 3���� �����̸�(MON)
--DAY : ���� Ǯ����(ȭ)
--YYYY : 4�ڸ� �⵵
--YY : 2�ڸ� ����
--RM : �θ��� �޼�

--���ڴ� ������ �ȵȴ�. ���⼱ ��¥�� ���ڷ� �ٲ� ���̴�.
SELECT SYSDATE, TO_CHAR(SYSDATE, 'D') FROM DUAL; --2
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DY') FROM DUAL; -- ��
SELECT SYSDATE, TO_CHAR(SYSDATE, 'RM') FROM DUAL; -- 1
SELECT SYSDATE, TO_CHAR(SYSDATE, 'MON') FROM DUAL; --1��
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DAY') FROM DUAL; --������
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL; -- 2022-01-24 ------> �� �ڵ� ���̾� �ܿ�� !! �߿�!! �ʼ�!!
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD-MM-YY') FROM DUAL;



--�ð� ����
/*
HH, HH12
HH24
MI : ��
SS : ��
SSSSS : ���� �ڸ���
AM, PM : ����, ����
A.M, P.M : ����, ���� (���� ����)
*/
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL; -- ���� �ð��� ���ڷ� ��������.
SELECT TO_CHAR(SYSDATE, 'AMHH:MI:SS') FROM DUAL;



--���� ���� 
/*
9 : �ڸ���(9999 -> 1218)
0 : �ڸ����� ��� 0���� ǥ��(09999 -> 01234) 
PR : ����(9999, PR -> <1234>) -ȸ�迡�� ���� ���
, : õ �ڸ���(9,999 -> 1,000)
*/
SELECT TO_CHAR(12506, '$099,999.99') FROM DUAL; -- $012,506.00


-- ����
-- SP, TH
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DDSP') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DDTH') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DDSPTH') FROM DUAL;


-- TO_DATE  (���ڸ� ��¥�� �ٲ�)  + ���ڸ� ��¥�� �ٲپ��� ������ ������ ������
SELECT TO_DATE('22-01-24', 'YY-MM-DD') + 10 FROM DUAL;
SELECT TO_DATE('13:38', 'HH24:MI') FROM DUAL;

--TO_NUMBER (���ڸ� ���ڷ� �ٲ�)
SELECT TO_NUMBER('123') + 100 FROM DUAL;

SELECT TO_NUMBER('ABC') FROM DUAL; -- ����! 

--NVL

--���ʽ��� ������ ���� ������ 0���� �ٲ۴�.
SELECT BONUS, NVL(BONUS, 0) FROM PERSONNEL;

--MANAGER  ���� ������ ���� ������ NON MANAGER�� �־��
SELECT MANAGER FROM PERSONNEL;

DESC PERSONNEL; -- ������ Ÿ�� ����

SELECT MANAGER, NVL(TO_CHAR(MANAGER), 'NON MANAGER') FROM PERSONNEL;


--DECODE
--�� ����� �޿��� �μ���ȣ�� 10�� ��� 10%�� ������Ű��, �μ���ȣ�� 20�� ��� 20% ������Ű��,
--������ �μ��� 30%�� ����
SELECT PNAME, BONUS, DNO, PAY,
DECODE(DNO,10,PAY*1.1, 20,PAY*1.2, PAY*1.3) �λ��--IF���� ��� DNO�� 10�ΰ�� PAY�� 10%����
FROM PERSONNEL;


--�޿��� 3500�̻��� ��쿡�� GRADE�� 'GOOD'�� ǥ���ϰ� 3500�̸��� ��쿡�� 'POOR'�� ����Ͻÿ�(SIGN)
SELECT * FROM PERSONNEL;

SELECT PNAME, PAY,
DECODE(SIGN(PAY-3500),1, 'GRADE', 'POOR') GRADE 
FROM PERSONNEL;



--�׷� �Լ�  - �׷� �Լ��� ����� ������ 1�� ����.
--COUNT
SELECT COUNT(*) FROM PERSONNEL; -- ��� �����͸� ���� ���? PERSONNEL���̺���

--�޿��� 3000�̻��� ����� ��

SELECT COUNT(*) FROM PERSONNEL
WHERE PAY >= 3000;

SELECT COUNT(MANAGER) FROM PERSONNEL; -- �ų��� ��� �÷��� �ο����� ����(NULL���� �� �� ��� 10��X 9���� ���´�)

SELECT COUNT(BONUS) FROM PERSONNEL; -- 3


--AVG
SELECT AVG(PAY) FROM PERSONNEL; --PAY�� ���

--SUM
SELECT SUM(PAY) FROM PERSONNEL;

--MAX/MIN
SELECT MAX(PAY), MIN(PAY) FROM PERSONNEL;

SELECT * FROM PERSONNEL;
-- ��� �߿� �Ի����� ���� ������ ������ ã���ÿ�
SELECT MIN(STARTDATE) FROM PERSONNEL;

--�Ի����� ���� ������ ����� ���Ի������ �� ���� ã���ÿ�
SELECT ROUND((MAX(STARTDATE) - MIN(STARTDATE))/365) AS �� FROM PERSONNEL;


--�м� �Լ�
--�μ��� ���
SELECT DISTINCT DNO, AVG(PAY) OVER(PARTITION BY DNO) -- DISTINCT�� �Ἥ ���� �μ��� ����� ���Ѵ�.
FROM PERSONNEL;

--���� 1200�� �޴� ��� ���� (�̰� �����̴�)
SELECT * FROM PERSONNEL ORDER BY PAY DESC;

SELECT RANK(1200) WITHIN GROUP (ORDER BY PAY DESC) RANK
FROM PERSONNEL;


SELECT PNAME, PAY, RANK() OVER(ORDER BY PAY DESC) RANK --��ũ ���ϴ� ����( ���߿� �� �� �ܿ��)
FROM PERSONNEL;


--GROUP BY
SELECT PNAME FROM PERSONNEL; -- �̰� ���߰� ��ȯ ������� �Ѵ�.

SELECT * FROM PERSONNEL WHERE PAY = 1600; -- ���߰� ��ȯ ����


SELECT COUNT(*) FROM PERSONNEL; -- �̰� ���ϰ� ��ȯ ������� �Ѵ�.



SELECT PNAME, MIN(STARTDATE) FROM PERSONNEL; --PNAME�� ����, MIN�� ���߰��� ��ȯ�ϴ� ������� ���� ��!!!


--���� ���� (���߿� ������) ���� �ȿ� ������ ������
SELECT PNAME, STARTDATE FROM PERSONNEL
WHERE STARTDATE = (SELECT MIN(STARTDATE) FROM PERSONNEL);


--GROUP BY ����
--�μ��� ��� �޿��� ���ϼ���.
SELECT DNO, AVG(PAY) FROM PERSONNEL -- �μ��� ����̱⿡ SELECT �տ� DNO(�μ�)�� �����ش�!
GROUP BY DNO;



SELECT STARTDATE, 
EXTRACT(YEAR FROM STARTDATE) ��,
EXTRACT(MONTH FROM STARTDATE) ��,
EXTRACT(DAY FROM STARTDATE) ��         -- FROM �տ��� ��ǥ�� ������ �ȵǼ� ���⼱ �����ش�.
FROM PERSONNEL;


-- �� �μ��� ��� �޿��� ��ü ��ձ޿�(2972.5)���� ũ�� 'GOOD'   ---��ƴ�.. ���� ��ü�� �ܿ��
-- ������ 'POOR' �� ����Ͻÿ�

SELECT AVG(PAY) FROM PERSONNEL;

SELECT DNO, AVG(PAY),
DECODE(SIGN(AVG(PAY) - (SELECT AVG(PAY) FROM PERSONNEL)), 1, 'GOOD', 'POOR') AS GRADE
FROM PERSONNEL
GROUP BY DNO;


--GROUP BY�� ���ǹ��� HAVING�̴�. 
SELECT AVG(PAY) FROM PERSONNEL;

SELECT DNO, AVG(PAY),
DECODE(SIGN(AVG(PAY) - (SELECT AVG(PAY) FROM PERSONNEL)), 1, 'GOOD', 'POOR') AS GRADE
FROM PERSONNEL
GROUP BY DNO
HAVING DNO = 20;
