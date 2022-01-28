select * from tab;
SELECT * FROM PERSONNEL;
/*
1. query
   select data�˻���

2. dml(data maipulation language)
    insert, update, delete
    
3. ddl(data difinition language)
    create, alter(ADD,MODIFY,DROP), drop, rename
    
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
SELECT * FROM PERSONNEL WHERE (JOB = 'MANAGER') AND PAY >=1500 OR JOB = 'SALESMAN'; --��ȣ�� �������� ���� ������ �ȴ�

--������ 'PRESIDENT'�̰ų� 'SALESMAN'�̸� ���̰� 1500�̻��� ����� ã���ÿ�
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

SELECT DNO, DNAME FROM DIVISION
WHERE DNAME = UPPER('sales');

SELECT DNO, DNAME FROM DIVISION
WHERE LOWER(DNAME) = 'sales';

--INITCAP
SELECT INITCAP('korea fighting') FROM DUAL;

--CONCAT
SELECT PNAME || DNO FROM PERSONNEL;
SELECT CONCAT(PNAME, DNO) FROM PERSONNEL;

--LENGTH
SELECT LENGTH('KOREA FIGHTING') FROM DUAL; -- 14

--SUBSTR
SELECT SUBSTR('ABCDEFG', 1, 3) FROM DUAL; --ABC
SELECT SUBSTR('ABCDEFG', 3, 2) FROM DUAL; --CD
SELECT SUBSTR('ABCDEFG', -3, 2) FROM DUAL; --EF
SELECT SUBSTR('ABCDEFG', -4) FROM DUAL; --DEFG


--INSTR
SELECT INSTR('ABCDEFG', 'C') FROM DUAL;

SELECT INSTR('AAAAAAA', 'A') FROM DUAL; -- 1       sql�� index��ȣ�� 1���� ������ �׷��� ã�� �����Ͱ� ������ 0�� ����
SELECT INSTR('AAAAAAA', 'a') FROM DUAL; -- 0


--RPAD/LPAD
SELECT RPAD(PNAME, 15, '*') FROM PERSONNEL;

--RTRIM/LTRIM
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

--LAST_DATY (�Ի��� ���� �������� ���ϱ�)
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



----------1��25��---------------------------------------------

--SELF JOIN

SELECT * FROM PERSONNEL;

SELECT A.PNO �����ȣ, A.PNAME ����,B.PNO �����ڹ�ȣ, B.PNAME ������
FROM PERSONNEL A, PERSONNEL B
WHERE A.MANAGER = B.PNO;



--NON EQUI JOIN
--��Ȯ�� ��ġ�ϴ� �����͸� ã�� ���� �ƴ϶� Ư�� ������ �ִ� �����͸� ã�� �� ���

SELECT * FROM PERSONNEL;
SELECT * FROM PAYGRADE;

SELECT PNAME, PAY, GRADE
FROM PERSONNEL, PAYGRADE
WHERE PAY BETWEEN LOWPAY AND HIGHPAY;



--��Ÿ(OPERATION)

/*
A = [1,2,5,6]  B = [1,2,4]

A UNION ALL B = [1,2,5,6,1,2,4]
A UNION B = [1,2,4,5,6]
A MINUS B = [5,6]
A INTERSECT B = [1,2]
*/

--UNION/ALL
SELECT * FROM PERSONNEL
UNION ALL
SELECT * FROM PERSONNEL;

--UNION
SELECT * FROM PERSONNEL
UNION
SELECT * FROM PERSONNEL;

--MINUS
SELECT DNO FROM DIVISION -- 10, 20, 30, 40
MINUS
SELECT DNO FROM PERSONNEL; -- 10, 20, 30

--INTERSECT(������)
SELECT DNO FROM DIVISION -- 10, 20, 30, 40
INTERSECT
SELECT DNO FROM PERSONNEL; -- 10, 20, 30


--PAREWISE(���ϴ� �÷��� ������ ���� �� ��)
SELECT PNAME, DNO, PAY, BONUS FROM PERSONNEL
WHERE (PAY,BONUS) IN (SELECT PAY,BONUS FROM PERSONNEL WHERE DNO=30);

SELECT PNAME, DNO, PAY, NVL(BONUS,-1) FROM PERSONNEL
WHERE (PAY,NVL(BONUS, -1)) IN (SELECT PAY,NVL(BONUS, -1) FROM PERSONNEL WHERE DNO=30);


SELECT PNAME,DNO,PAY,BONUS FROM PERSONNEL
WHERE (PAY=1600 AND BONUS=500) OR (PAY=1450 AND BONUS=300)
OR (PAY=1200 AND BONUS=0) OR (PAY=3550 AND BONUS IS NULL);



------------------------------ 1��26�� ������ -------------------------------------------------------------------------

--dml(date mipulation language)

--insert(����), update(����), delete(����)


SELECT * FROM DIVISION;
DESC DIVISION;

--MSSQL������ INTO�� �����ص������� ����Ŭ������ �ݵ�� �����
INSERT INTO DIVISION VALUES (50, 'OPERATION', '031-111-222', 'DAEGU');

INSERT INTO DIVISION VALUES (60); --������ WHY? �� 60�� �÷��߿� ��� ������ �������� �ʾƼ� ������

INSERT INTO DIVISION (DNO) VALUES (60); -- ���� �������� �̷��� �ؾ���

INSERT INTO DIVISION (DNAME, POSITION) VALUES ('ACCOUNT', 'DAEJUN'); -- ���� NOT NULL�̶� ���� �ȵ� 
                                                                     -- NOT NULL�� �������� �ݵ�� ���� �����

INSERT INTO PERSONNEL (PNO,PNAME, PAY, DNO)
VALUES (7711, 'YOUNG', 4000, 20);

SELECT * FROM PERSONNEL; --����ִ� ������ �Ͻ��� NULL ����
DESC PERSONNEL;

INSERT INTO DIVISION VALUES(70, 'PLANNING', '012-333-4444', NULL); -- NULL ��� ''�ᵵ �ȴ�. -- �̰� ����� NULL����

SELECT * FROM DIVISION;

INSERT INTO PERSONNEL (PNO, PNAME, JOB, STARTDATE, DNO)
VALUES (1300, 'CHO', 'SALESMAN',SYSDATE, 10);

SELECT * FROM PERSONNEL;

SELECT STARTDATE, TO_CHAR(STARTDATE, 'YYYY-MM-DD') NALJJA FROM PERSONNEL;
--INSERT�� NOT NULL�� �������� �ݵ�� ���� �־���� �Ѵ�.


--ġȯ ����( �̰� ����Ŭ���� �ִ�.)
SELECT PNO, PNAME, JOB, STARTDATE, DNO
FROM PERSONNEL
WHERE DNO = &DIV_DNO; -- &�� �Ἥ ġȯ�Լ��ΰ� �˷���


SELECT * FROM MANAGER; -- PERSONNEL�� ������ �״�� ī���ؼ� �������µ� �����ʹ� �Ȱ������.
SELECT * FROM SALESMAN;
SELECT * FROM BUSEO; -- ������ �����Ͱ� ������ �ʴ´�. -���̺갡 ���� �ʾұ� ������
SELECT * FROM DIVISION; -- ������ �����Ͱ� ���δ�.

COMMIT;-- SAVE

SELECT * FROM SAWON; -- SAWON�� PERSONNEL���̺��� ��� �����Ͱ� �� ������.

SELECT * FROM TAB;

/*
CREATE TABLE MANAGER
AS 
	SELECT * FROM PERSONNEL
	WHERE 1=2;                ---������ �������� �ؼ� ������ �������� �����ʹ� �Ȱ�����´�.

CREATE TABLE BUSEO
AS SELECT * FROM DIVISION;

CREATE TABLE SAWON
AS SELECT * FROM PERSONNEL;

CREATE TABLE EXAM1
AS SELECT * FROM PERSONNEL;

CREATE TABLE EXAM2
AS SELECT * FROM DIVISION;
*/

--SUBQUERY
SELECT * FROM MANAGER;
DESC MANAGER;

SELECT * FROM PERSONNEL
WHERE JOB = 'MANAGER';

INSERT INTO MANAGER(PNO, PNAME, PAY, STARTDATE)
SELECT PNO, PNAME, PAY, STARTDATE FROM PERSONNEL
WHERE JOB = 'MANAGER';

SELECT * FROM MANAGER;

--������ SALESMAN�� ����� ��� ������ SALESMAN ���̺�� �����ϱ�
SELECT * FROM SALESMAN;

INSERT INTO SALESMAN
SELECT * FROM PERSONNEL
WHERE JOB = 'SALESMAN';

COMMIT;


--UPDATE

--��� ��ȣ�� 1111�� ����� �μ��� 30���� ����
SELECT * FROM PERSONNEL WHERE PNO=1111;
--UPDATE���� �ݵ�� ���ǹ��� �;��� �Ⱦ��� ��� �����Ͱ� �ٲ�
UPDATE PERSONNEL SET DNO=30  -- ���̺� �̸��� �������ְ�, ���� �־�����ϴ� SET���� �μ���ȣ�� �ٲ���ؼ� DNO=30
WHERE PNO=1111;

UPDATE PERSONNEL SET JOB='SALESMAN',MANAGER=1111, STARTDATE=SYSDATE,BONUS=200 
WHERE PNO=7711;

SELECT * FROM PERSONNEL;

COMMIT; --UPDATE�� �ݵ�� COMMIT�� ����� �Ѵ�. COMMIT�� �ϱ� ������ �޸� �󿡸� ����.COMMIT�� �ؾ� DB�� �ݿ�


SELECT * FROM SAWON;

UPDATE SAWON SET DNO=20; -- SAWON DNO�� 20���� �ٲܰŴ�. �̷��Ը� �����ϸ� ��� DNO�� 20���� �ٲ� ������ �����.

ROLLBACK; -- �ֱ� COMMIT������ ��ҵȴ�.(����)



--UPDATE�� SUBQUERY�� ���� ����
SELECT * FROM PERSONNEL
WHERE DNO = (SELECT DNO FROM DIVISION WHERE DNAME='SALES'); --SELECT�غ��� UPDATE�ϱ�

UPDATE PERSONNEL SET JOB='SALESMAN'
WHERE DNO = (SELECT DNO FROM DIVISION WHERE DNAME='SALES'); -- MANAGER�� SALESMAN���� �ٲٱ�


/*
SELECT * FROM PERSONNEL
WHERE DNO = (SELECT DNO FROM DIVISION WHERE DNAME='SALES'); --SELECT�غ��� UPDATE�ϱ�

���� SELECT���� JOIN������ �ٲٱ�
*/
SELECT A.* -- PERSONNEL�� ��� �����͸� �����ðŴ� A.*
FROM PERSONNEL A, DIVISION B
WHERE A.DNO = B.DNO AND DNAME = 'SALES'; 

--UPDATE�� �ٲٱ�
UPDATE PERSONNEL SET JOB='SALESMAN'		--����! -> ����Ŭ������ JOIN������ UPDATE ����.
FROM PERSONNEL A, DIVISION B
WHERE A.DNO = B.DNO AND DNAME = 'SALES'; -- ����Ŭ������ X , MS-SQL������ �ȴ�.


COMMIT;


--DELETE

-- DELETE�� UPDATE�� ����. �պκ��� �ٲٸ�ȴ�.
--�����ȣ�� 1300�� ����� �����Ͻÿ�.         -> �����ҷ��� 1300�� ����� �˻��� �����ؾ���

SELECT * FROM PERSONNEL WHERE PNO=1300;
DELETE FROM PERSONNEL WHERE PNO=1300; -- DELETE ���� FROM ������ �����ϴ�.


SELECT * FROM SAWON;

DELETE SAWON; -- �̷��� �ϸ� SAWON���̺��� �� �����ȴ�. �̰ŵ� �޸� �󿡼��� �����ȰŶ� ROLLBACK����ؼ� ����

ROLLBACK;


-- �μ����� BUSAN�� �μ��� �μ���ȣ�� ã�� �� �μ��� �ش��ϴ� ������ ������ �����Ͻÿ�.

SELECT * FROM DIVISION;

SELECT * FROM PERSONNEL 
WHERE DNO=(SELECT DNO FROM DIVISION WHERE POSITION='BUSAN');


DELETE PERSONNEL 
WHERE DNO=(SELECT DNO FROM DIVISION WHERE POSITION='BUSAN');

COMMIT;


--DML ���� ���� �� ����

--SELECT ����
SELECT * FROM PERSONNEL;
DESC PERSONNEL; -- PNO�� NOT NULL�̶� �ϴ� �ڵ�� ������ ��
--unique constraint (KIM.PERSONNEL_PNO_PK) violated -> PK�� �������� : �ߺ�X, NULL X, ���̺�� 1���� �÷��� ���� �� �ִ�.

INSERT INTO PERSONNEL (PNO,PNAME,DNO) VALUES(1300,'SONG',99);

SELECT * FROM USER_CONSTRAINTS; --���������� �����س��� ���̺��� �ִµ� ���� ���

--UPDATE ����
SELECT * FROM DIVISION; --DIVISION ���̺��� DNO�� PERSONNEL���̺��� DNO�� �����ϰ� �ִ�.
SELECT * FROM PERSONNEL;

UPDATE PERSONNEL SET DNO=90 -- ����! DIVISION���� DNO 90�� ���⶧���� 

--DELETE ����
DELETE DIVISION WHERE DNO=30;  -- DIVISION�� �����ؼ� PERSONNEL�� 30�� ������⿡ DIVISION�� �ִ� DNO=30�� ���� �� ����.



-- 4. tcl(transaction control language)
--    commit (save�� ����) , rollback (����� ����)     --DB������ �ſ� �߿��ϴ�!!!!

--AUTO COMMIT
--DDL(CREATE, ALTER, DROP,RENAME)
--DCL(GRANT, REVOKE)

SELECT * FROM TAB;

SELECT * FROM DIVISION;


-- 3. ddl(data difinition language)
--    create, alter, drop, rename

-- OBJECT : TABLE, INDEX, SYNONYM, SEQUENCE, VIEW

/*
TABLE
DATA TYPE
CHAR : ����(��������) -- ������ ������ �����϶��� CHAR ���
VARCHAR2 : ����(��������) -- ���ڱ��̰� ��Ȯ���ϸ� ���� ���� VARCHAR2 ���
NUMBER(P,S) : ����
DATE : ��¥(��������)
LONG : ����(��������, 2GB)
*/


--���� TABLE �����

CREATE TABLE BUSE01  -- CREATE�� ����Ŀ���̶� ROLLBACK ��?
(DNO NUMBER(2),
DNAME VARCHAR(14),
ZIPCODE CHAR(7));

SELECT * FROM BUSE01;
DESC BUSE01;

INSERT INTO BUSE01 VALUES (10, 'AAA', '123-123'); -- ���̺� ������ �ֱ� -> �̰��ϰ� SELECT �����ϸ� �������

INSERT INTO BUSE01 VALUES (20, 'BBB', '222-333');

/*
CREATE ��Ģ
1.������ ����(30��)
2.������,���� ��밡��(����������)
3.Ư�����ڴ� _,$,#�� ��밡��
4.�̸��� �ߺ�������
5.�÷����� Ʋ������
6.����� ������

--��밡���� �̸�
Sawon,P_NO,Division10,Name_Rule

--���Ұ����� �̸�
10division, $sal, p-no, Alter

*/

CREATE TABLE CUSTOM
(ID CHAR(5) CONSTRAINT CUSTOM_ID_PK PRIMARY KEY, -- PRIMARY KEY�� �� ���̺� 1���� ����� �ִ�.
PWD CHAR(3),
NAME CHAR(6),
ADDR VARCHAR2(50),
ZIP CHAR(5),
BIRTH DATE,
JUMIN CHAR(14),
AGE NUMBER, -- �ڿ� ���� �������ָ� �� ������� ��
TEL CHAR(10));

DESC CUSTOM;
INSERT INTO CUSTOM VALUES ('A001','123','SUZI','����','12345','94-10-10',
'941010-2123456','27','0101231234');

SELECT * FROM CUSTOM;
INSERT INTO CUSTOM VALUES (NULL,'123','INNA','����','12345','94-10-10',
'941010-2123456','40','0101231234'); -- NULL�̶� ������(������ �ȵ�)

INSERT INTO CUSTOM VALUES ('A001','123','INA','����','12345',SYSDATE,
'941010-2123456','40','0101231234'); -- ������ !   -> ���� �����Ͷ� �ȵ�

DROP TABLE CUSTOM; -- DROP��  ���̺� ����

SELECT * FROM CUSTOM;

SELECT * FROM USER_CONSTRAINTS; -- ��ųʸ� ��� �θ���.

COMMIT; -- ����


----------------------------- 1�� 27�� ----------------------------------------------------------------------------------------


CREATE TABLE SALESMAN1
AS 
SELECT PNO,PNAME,JOB,PAY FROM PERSONNEL
WHERE JOB='SALESMAN';


SELECT * FROM SALESMAN1;



CREATE TABLE MANAGER1
AS
SELECT * FROM PERSONNEL WHERE JOB='MANAGER';

SELECT * FROM MANAGER1;


CREATE TABLE PAY3000
AS
SELECT * FROM PERSONNEL WHERE PAY>=3000; -- PAY 3000�̻��� ����� ã�Ƽ� ���̺��� �����.

SELECT * FROM PAY3000; --���


-- PERSONNEL ���̺��� 12���޿� �Ի��� �������� �����͸� 
-- MON12�̶� ���̺�� ����

CREATE TABLE MON12
AS
SELECT * FROM PERSONNEL 
WHERE TO_CHAR(STARTDATE, 'MM') = 12;

SELECT * FROM MON12; -- ��� Ȯ���ϱ�

--���̺� ����� ��� -> DROP TABLE MON12 PURGE; -> �̷��� ����� ���� �츱 �� ����.(������ �����ϴ� ���)
--PURGE�� �Ƚ��൵������ �Ⱦ��� �����뿡 ��. ����� ������ �����ȴ�.

--ANALYST ���̺��� �״�� �����ϴµ� �÷����� �����ؼ� �����ϴ� �����
CREATE TABLE ANALYST (NUM,NAME,JOB,DNUM)
AS
SELECT PNO,PNAME,JOB,DNO FROM PERSONNEL
WHERE JOB='ANALYST';

SELECT * FROM ANALYST;


-- �μ���ȣ�� 10�� �μ��� �� �޿��� ������ DIV10 ���̺�� ����ÿ�.
CREATE TABLE DIV10
AS
SELECT DNO, SUM(PAY) �ѱ޿� FROM PERSONNEL
GROUP BY DNO
HAVING DNO=10;

SELECT * FROM DIV10;


-- PERSONNEL ���̺��� ����(�÷�)�� �����ؼ� SAWON1 ���̺� �����
SELECT * FROM PERSONNEL;

CREATE TABLE SAWON1
AS
SELECT * FROM PERSONNEL
WHERE 0=1; ---���� ���� ���� ���൵ �ȴ�.

SELECT * FROM SAWON1;

DESC PERSONNEL; 
DESC SAWON1; -- P.K�� ���簡 �ȵǼ� ���� �������� �Ѵ�!!


SELECT * FROM SALESMAN1;
DESC SALESMAN1;


--ALTER----------------------

--�÷� �߰� 
ALTER TABLE SALESMAN1  -- TABLE�� �ٲܶ��� ALTER
ADD (DNO NUMBER(2));           -- DNO �÷��� (�߰�) ALTER + ADD

SELECT * FROM SALESMAN1;


--�÷� 2�� �߰��ϱ�
ALTER TABLE SALESMAN1
ADD (JUMIN CHAR(14), ZIP CHAR(7)); -- ��ȣ�� �� �Ἥ ���������

SELECT * FROM SALESMAN1;                               -- L���̺�� ����� �־��� DB.


ALTER TABLE SALESMAN1
ADD BIGI VARCHAR2(10) DEFAULT('AA'); --���� ���� : ���� �־����� �⺻���� 'AA'�� �־��ش�.


--MARRIAGE �÷��� ����ǵ� CHECK ���� ������ �ش�.
--CHECK �������� : �׳� CHECK��� ����ǰ� CONSTRAINT�� �Ἥ (CK)���ϴ��̸� ����
ALTER TABLE SALESMAN1
ADD (MARRIAGE CHAR(8) CONSTRAINT SALESMAN1_MARRIAGE_CK
CHECK (MARRIAGE IN ('SINGLE', 'MARRIED'))); -- MARRIAGE�� SINGLE Ȥ�� MARRIED �� �� �� �ְ� IN ���

SELECT * FROM SALESMAN1;

--Ȯ���ϱ�
INSERT INTO SALESMAN1 VALUES 
(111,'CHO','SALESMAN',2000,10,'11111','123-123','BB','SINGLE');


INSERT INTO SALESMAN1 VALUES 
(111,'CHO','SALESMAN',2000,10,'11111','123-123','BB','SOLO'); -- ���������� �༭ SOLO�ȵ� -- ����!!!


SELECT * FROM USER_CONSTRAINTS; -- �������� ����Ʈ ( ��ųʸ� )


--����ȭ : ���̺��� �ɰ��� �۾��̴�.
--������ȭ : �ɰ� ���̺��� ���̴� �۾��̴�.


DESC SALESMAN1;

ALTER TABLE SALESMAN1
ADD CONSTRAINT SALESMAN1_PNO_PK PRIMARY KEY(PNO);

SELECT * FROM SALESMAN1; -- PNO�� �������� ������ �ٷ� ���� ������


-- MANAGER1 ���̺� COMM �÷��� NUMBER(5)�� �߰�
SELECT * FROM MANAGER1;

ALTER TABLE MANAGER1
ADD COM NUMBER(5);

-- MANAGER1 ���̺� PNO �÷��� PK�� �߰�
ALTER TABLE MANAGER1
ADD PRIMARY KEY(PNO);        --ADD�� ���̺� ������ ���

SELECT * FROM USER_CONSTRAINTS;

------------------------------------------------------------------
-- MODIFY(�÷��� ����)               ALTER(���̺� ����)
SELECT * FROM MANAGER1;
DESC MANAGER1;

ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(16); -- PNAME�� ������ Ÿ���� 16���� �÷���


ALTER TABLE MANAGER1
MODIFY PNAME VARCHAR2(7); -- PNAME�� ������ Ÿ���� 7�� �ٿ���

SELECT * FROM MANAGER1;


--DROP(�÷�, ��������)

SELECT * FROM USER_CONSTRAINTS;

ALTER TABLE MANAGER1
DROP CONSTRAINT SYS_C007039; -- ���� ���� ��� -> DROP CONSTRAINT �̸�

ALTER TABLE SALESMAN1
DROP CONSTRAINT SALESMAN1_PNO_PK; -- ���� ���� ���

ALTER TABLE SALESMAN1
DROP PRIMARY KEY; -- ���� ���� ���


ALTER TABLE DIVISION
DROP PRIMARY KEY; --����! -> �����Ǿ��־ ���� ����


SELECT * FROM USER_CONSTRAINTS;

ALTER TABLE DIVISION
DROP PRIMARY KEY CASCADE; -- ���� ���� ����!


--�÷� ����

DESC SALESMAN1;

SELECT * FROM SALESMAN1;

ALTER TABLE SALESMAN1
DROP COLUMN MARRIAGE;


-- SET UNUSED (�̰� DBA�� ���� ��ɾ�� �����常 ������)

--�����ð��� ������ �ϸ� �ð��� �����ɸ��⶧���� FLAG�� �ȾƳ��� �����Ȱ�ó�� ���̰��ϰ� �㿡 ��¥�� �����Ѵ�.
ALTER TABLE SALESMAN1
SET UNUSED COLUMN DNO;  --���� �����ϰ� �Ʒ��� �����ϸ� DNO�÷��� �Ⱥ��δ�.(�����Ȱ� �ƴϰ� �Ⱥ��̴� ��)

SELECT * FROM SALESMAN1;


ALTER TABLE SALESMAN1
DROP UNUSED COLUMNS; -- UNUSED�� �÷��� ��¥ �����ض�

---------

SELECT * FROM TAB;

--MANAGER1 ���̺���  ����
DROP TABLE MANAGER1;

SELECT * FROM RECYCLEBIN; -- ������ �˻�

SELECT OBJECT_NAME, ORIGINAL_NAME, DROPTIME FROM RECYCLEBIN;


--�����뿡 ������ �����ϱ�! (���� MANAGER1 ���̺� ����)

FLASHBACK TABLE MANAGER1 TO BEFORE DROP;  -- �̸��� ���൵�ǰ�

FLASHBACK TABLE "BIN$fqX45UgXT26v9u+DKZqoTQ==$0" TO BEFORE DROP; --OBJECT_NAME�� �ᵵ�ȴ�.


--���������� �ʰ� ������ ���̺� � ������ �־����� Ȯ���ϱ�
SELECT * FROM "BIN$vnhmvvp7R1Cq7A5e2qaNeQ==$0";


SELECT * FROM TAB;

DROP TABLE SALESMAN1 PURGE; -- �������� �н��ϰ� �ٷ� ��������(�̰� ��������)

PURGE RECYCLEBIN; --������ ����


--TRUNCATE/DELETE

SELECT * FROM PERSONNEL;

DELETE PERSONNEL; -- ���� (�����ϸ� Ʈ����� ����)

SELECT * FROM PERSONNEL; -- �����Ͱ� ��ü ������

ROLLBACK;

SELECT * FROM PERSONNEL; -- ������ ����
---------------------------------------------

-- TRUNCATE TABLE : �ִ� ���̺��� ����°� �ƴϰ� �����͸� ����� ���̴�

TRUNCATE TABLE PERSONNEL;

SELECT * FROM PERSONNEL;

ROLLBACK;

SELECT * FROM PERSONNEL; -- �ִ� DB�� �ٷ� �ݿ��̵Ǽ� ROLLBACK���� ������ �ȵȴ�. �����ϰ� ����ؾ���!!!!!

COMMIT;


-- RENAME   (���̺� �̸� �����ϱ�)

SELECT * FROM TAB; -- TAB�� �⺻������ �����ְ� S�� �ٿ� TABS�� ���� ���� ���� ������ ������ �ַ� DBA�� �����

SELECT * FROM PAY3000; -- �� ���̺� �̸��� �ٲٱ�


RENAME PAY3000 TO HIGHPAY;-- PAY3000���� HIGHTPAY�� �̸� ����

SELECT * FROM HIGHPAY; --  ���� PAY3000���� �˻��ϸ� ������! HIGHPAY�� �˻��ؾ���!




---------------------------------------------------------

-- 5. dcl(data control language)
--    grant(������ �� ��), revoke(������ ���� ��)


/*
GRANT : USER�� OBJECT�� ������ �ο��� �� ���
REVOKE : USER�� OBJECT�� ������ ȸ���� �� ���
*/


CREATE USER TEST
IDENTIFIED BY TEST
DEFAULT TABLESPACE USERS      --> ������ �ְ� �ٽ� �����ϸ� �ȴ�.!!!!!
TEMPORARY TABLESPACE TEMP; -- �Ϲ� ������ ������ ������ WHY? -> ������ ���� ������ ������ ��� ���� �� ����


CREATE USER SUZI
IDENTIFIED BY SUZI
DEFAULT TABLESPACE USERS     
TEMPORARY TABLESPACE TEMP; -- SYSTEM���� KIM�� CREATE ������ ��� �������. ������ �ָ� �ٽ� ���� ����ȴ�.

SELECT * FROM DBA_USERS; -- � �������� ��������µ� ���� ��ɾ��̴�.(������ ������) -- �̸�ɾ�� DBA�� ������ �� �ִ�.
					     --SYSTEM�� ���� ����


-- (OBJECT) ������Ʈ ���� : �������� ���̺��� �ٸ� ������ ����� �� �ְԲ� ���ִ� ����
-- �̰� �Ϲݻ���ڰ� �Ϲ� ��������� �ִ� �����̴�.

GRANT SELECT ON PERSONNEL TO SUZI; 
GRANT SELECT,INSERT,DELETE ON DIVISION TO SUZI;

SELECT * FROM PERSONNEL;


COMMIT;


SELECT * FROM USER_TAB_PRIVS_MADE; -- ���������� ����� ������@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


--��� ��������� KIM�� DIVISION���̺��� SELECT ������ �ִ� ���

GRANT SELECT ON KIM.DIVISION TO PUBLIC; -- PUBLIC���� ������ �ָ� ���� ���� PUBLIC���� ����;���.

/* --> TEST������ ������ ���µ�KIM�� DIVISION���̺��� �˻��� �� �ְ� �ȴ�.

TEST@XE> SELECT * FROM KIM.DIVISION;

       DNO DNAME                          PHONE                          POSITION
---------- ------------------------------ ------------------------------ --------------------
        10 FINANCE                        032-277-0411                   INCHON
        20 RESEARCH                       061-535-1212                   BUSAN
        30 SALES                          02-555-4985                    SEOUL
        40 MARKETING                      031-284-3800                   SUWON
*/

------------------------------------------------------

--OBJECT ���� ȸ��

--TEST���� �� PUBLIC ���� ȸ��
REVOKE SELECT ON DIVISION FROM PUBLIC; -- PUBLIC���� ������ ������ PUBLIC���� ����;���.
                                       -- PUBLIC���� TEST���� �� ���Ѱ� SUZI���� �� ���Ѱ� �ٸ��� ������ SUZI������ �˻�����
                         
                         
-- SUZI���� �� ���� ȸ���ϱ�
REVOKE SELECT ON PERSONNEL FROM SUZI;   -- ������ ��� CDM���� �˻��� ����. �ٽ� ������ ��� �˻� ������
            
REVOKE SELECT,INSERT,DELETE ON DIVISION FROM SUZI;    --������ ��� ������ �˻��� ����.       



--ROLE : ROLE�� ���ѵ��� ��Ƴ��� �׸��̶�� �����ϸ� �ȴ�. (ROLE�� �ݵ�� ������ ���;� ����ȴ�)

--ROLE�� DBA���� ��ɾ�� �˰� ����!
����
CREATE ROLE MANAGER; --���� �� WHY? ������ ��� SYSTEM������ �־����.  


--DBA�� �ɷ���������  MANAGER�̶� CONNECT���� ���� ������ �ִ��� �˻�
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'MANAGER' OR ROLE='CONNECT' OR ROLE='RESOURCE'; -- CONNECT, RESOURCE������ KIM���� ������ KIM���� �˻�




------------------------------1�� 28�� --------------------------------------------------------------------------------------

/*
-- ���������� �ִ� ������ ���Ἲ �����̴�.

-- ����Ŭ DB �������� ����

PRIMARY KEY
FOREIGN KEY
UNIQUE KEY
NOT NULL
CHECK

*/

--���̺��� ����鼭 PRIMARY KEY�� ����� ���
CREATE TABLE CUSTOMER
(ID NUMBER(4) CONSTRAINT CUSTOMER_ID_PK PRIMARY KEY, -- �÷��� �޺κп� ���� COLUMN LEVEL�̶� �Ѵ�.
NAME VARCHAR2(10),
NO NUMBER(4));

SELECT * FROM USER_CONSTRAINTS; --���������� ����  CUSTOMER�� ���ִ�.


CREATE TABLE ORDERS
(NO NUMBER(4),
SNO NUMBER(4),
NAME VARCHAR2(10),
COUNT NUMBER(7),
CONSTRAINT ORDERS_NO_PK PRIMARY KEY(NO)); -- �̷��� ����� ���� TABLE LEVEL�̶� �Ѵ�.


SELECT * FROM ORDERS;
SELECT * FROM CUSTOMER;


 ALTER TABLE CUSTOMER
ADD CONSTRAINT CUSTOMER_NO_FK FOREIGN KEY(NO) -- ���������� ����ǵ� FOREIGN KEY�� ���? NO�� 
REFERENCES ORDERS(NO);    -- �̰� REFERENCES�� ORDERS�� �����Ѵ�.

SELECT * FROM USER_CONSTRAINTS;


CREATE TABLE CATALOGS
(CATALOGNO NUMBER(4) CONSTRAINT CATALOGS_CATALOGNO_PK PRIMARY KEY, -- PRIMARY KEY�� � �÷��̵� �ݵ�� �־������
NAME VARCHAR2(10),
NO NUMBER(4) CONSTRAINT CATALOGS_NO_FK REFERENCES ORDERS(NO));


SELECT * FROM ORDERS;

INSERT INTO ORDERS VALUES (10,1111,'AAA',11);
INSERT INTO ORDERS VALUES (20,2222,'BBB',22);
INSERT INTO ORDERS VALUES (30,3333,'CCC',33);
COMMIT;


SELECT * FROM CUSTOMER;

INSERT INTO CUSTOMER VALUES (111,'SUZI',10);
INSERT INTO CUSTOMER VALUES (222,'INNA',30);
INSERT INTO CUSTOMER VALUES (333,'INSUN',40); -- X         40���� �ϸ� FK �������� ������ ���. 

SELECT * FROM CATALOGS;

INSERT INTO CATALOGS VALUES (777,'SUZI',20);
INSERT INTO CATALOGS VALUES (888,'INNA',30);
INSERT INTO CATALOGS VALUES (999,'SUZI',40); -- X   -- NO�� �����Ǳ� ������ ������ ��� 10���� ����� �ȴ�.


DELETE ORDERS WHERE NO=20; -- NO�� 20�� ������ ���� -> ������! -> NO 20�� �����ϰ� �ִ� �����Ͱ� �־ ���� ��?

DELETE CATALOGS WHERE NO=20; -- CATALOGS �� NO 20 ������ ���� -> �̰� ���������ϰ� ������ �����ϸ� ���� ������

SELECT * FROM CATALOGS;

COMMIT;




-- UNIQUE

-- ORACLE ������ NULL�� ����ϰ� / MS-SQL ������ 1�ո� ����Ѵ�.
SELECT * FROM ORDERS;
DESC ORDERS; -- SNO�� NULL�� �־ ����

ALTER TABLE ORDERS
ADD CONSTRAINT ORDERS_SNO_UK UNIQUE(SNO);

SELECT * FROM ORDERS;

INSERT INTO ORDERS VALUES (40,'','DDD',44);
INSERT INTO ORDERS VALUES (50,'','EEE',55);
INSERT INTO ORDERS VALUES (60,'333','FFF',66); -- �̹� 333�� ���־� ����! �ߺ��� ���X  -> PK�������� ����


--CHECK

SELECT * FROM ORDERS;

ALTER TABLE ORDERS
ADD CONSTRAINT ORDERS_SNO_CK CHECK(SNO BETWEEN 100 AND 500);
INSERT INTO ORDERS VALUES (60, 501,'FFF',66); -- X

--NOT NULL
ALTER TABLE ORDERS
ADD CONSTRAINT ORDERS_NAME_NN CHECK(NAME IS NOT NULL);

DESC ORDERS;

SELECT * FROM USER_CONSTRAINTS;

CREATE TABLE TEST1
(NO NUMBER(4) CONSTRAINT TEST1_NO_NN NOT NULL);


-- ���� ���� ���� ���
ALTER TABLE TEST1
DROP CONSTRAINT TEST1_NO_NN; 

SELECT * FROM USER_CONSTRAINTS; --���� ?���� Ȯ��

ALTER TABLE ORDERS
DROP CONSTRAINT ORDERS_NO_PK; --����! � FOREIGN KEY�� �����ǰ� �־ �������. -> �׷��� ���������� CASCADE�Ἥ ����


-- DICTIONARY

SELECT COUNT(*) FROM DICTIONARY; -- KIM�� ����Ҽ��ִ� DICTIONARY ���� Ȯ�� - 804��

SELECT * FROM DICTIONARY;

SELECT * FROM USER_CONSTRAINTS; -- ���������� �����ϰ��ִ� ��ųʸ�

--USER�� ����

--USER_�� �����ϴ¾ְ� �ְ�, ALL_, DBA_, V$�� �����ϴ� �ְ� �ִ�.

--USER_ : USER ������ OBJECT ����
--ALL_ : USER���� ACCESS�� ���� OBJECT����
--DBA_ : DBA ������ ���� USER�� ACCESS �� �� �ִ� ����
--V$ : SERVER�� ���ɿ� ���� ����

SELECT * FROM V$VERSION; --����Ŭ�� ������ �˻��ȴ�.

SELECT * FROM ALL_CONSTRAINTS; -- ���� ���� ���� ���ǵ��� �����ش�.
SELECT * FROM ALL_CONS_COLUMNS WHERE TABLE_NAME='ORDERS'; -- � ���������� � ���̺�&�÷��� ������ �����ش�. �̰� ������ ��밡��

SELECT * FROM DBA_CONS_COLUMNS; -- ����! --> �̰� DBA�� �� ���־ ������ ���.
SELECT * FROM USER_TABLES;
SELECT * FROM USER_SYS_PRIVS; -- KIM�� ������ �ִ� SYS�� ����




--VIEW (���� ���̺�)

--VIEW�� ����̴� ���� : ���� �����̴�.

CREATE VIEW PER10_V
AS
SELECT * FROM PERSONNEL WHERE DNO=10;

SELECT * FROM USER_VIEWS;

SELECT * FROM PER10_V; -- ���� ���̺� - SELECT�Ҷ��� �����Ǵ� ���� ���̺��̴�.


--VIEW�� ���� : ������ ��밡��
SELECT * FROM PER10_V WHERE PNO=111; --�Ϲ������� SELECT�� �������� ���


CREATE VIEW PER20_V
AS
SELECT PNO,PNAME,MANAGER,PAY,DNO FROM PERSONNEL;

SELECT * FROM PER20_V;

CREATE VIEW PER_AVG
AS
SELECT DNO, AVG(PAY) ���, SUM(PAY) �հ�
FROM PERSONNEL
GROUP BY DNO;

SELECT * FROM PER_AVG;

SELECT * FROM PER_AVG WHERE DNO=10;
SELECT * FROM PER_AVG WHERE �հ�>8000;

INSERT INTO PER20_V VALUES (1234,'JJJ',1001,2000,20);

SELECT * FROM PERSONNEL;

UPDATE PER20_V SET PNAME='AAA' WHERE PNO=1234;

DELETE PER20_V WHERE PNO=1234;

--SIMPLE VIEW
--�ϳ��� ���̺��� ���� VIEW
--INSERT,UPDATE,DELETE�� ����

SELECT * FROM PERSONNEL;

CREATE VIEW PER
AS
SELECT PNAME,JOB,PAY FROM PERSONNEL;

SELECT * FROM PER;

INSERT INTO PER VALUES ('BBB', 'ACCOUNT',3000);


SELECT * FROM PER_AVG;

INSERT INTO PER_AVG VALUES (40,1234,5000); --������!! WHY? -> 40���� �ƴ϶� ���� �����Ͱ� �����Ѵ�.


--����
-- CREATE -> ALTER  : CREATE�� ALTER�� �����ϴµ� VIEW������ ��?��.

SELECT * FROM USER_VIEWS;

SELECT * FROM PER20_V;

-- VIEW �о�ö��� �÷��� �����ؼ� �ҷ�����
CREATE OR REPLACE VIEW PER20_V 
(��ȣ,�̸�,����,�μ���ȣ)
AS
SELECT PNO,PNAME,JOB,DNO FROM PERSONNEL
WHERE DNO=20;

SELECT * FROM PER20_V; -- ���
----------------------------------


-- ����
-- CREATE�� �����  DROP

DROP VIEW PER_AVG; --����

SELECT * FROM PER_AVG; -- ����! -> �����߱⶧��

--------------------------------------------------------

--COMPLEX VIEW

--JOIN(����)������ ���� VIEW
--�ִ� INSERT,UPDATE,DELETE�� �Ұ���

CREATE TABLE ������
(����ȣ CHAR(10),
�̸� CHAR(10));

CREATE TABLE ȸ������
(����ȣ CHAR(10),
ȸ��� CHAR(10));


INSERT INTO ������ VALUES ('A001','ȫ�浿');
INSERT INTO ������ VALUES ('A002','�̼���');
INSERT INTO ȸ������ VALUES ('A001','LG');
INSERT INTO ȸ������ VALUES ('A002','KAKAO');

COMMIT;

SELECT * FROM ������;
SELECT * FROM ȸ������;

CREATE OR REPLACE VIEW ����
AS
SELECT K.����ȣ,�̸�,ȸ���
FROM ������ K, ȸ������ H
WHERE K.����ȣ = H.����ȣ;

SELECT * FROM ����; --JOIN���� ���� VIEW�� ���


INSERT INTO ���� VALUES ('A003','�����','SAMSUNG'); --����!

UPDATE ���� SET �̸�='�����' WHERE ����ȣ='A001'; --����!

DELTE ���� WHERE ����ȣ='A001'; -- ����!


-- TOP-N 

--���� �ֱٿ� �Ի��� 5���� ����� �̸��� �Ի糯¥�� ����Ͻÿ�.


SELECT ROWNUM,PNAME,STARTDATE FROM (SELECT STARTDATE, PNAME FROM PERSONNEL
ORDER BY STARTDATE DESC)
WHERE ROWNUM <=5;


SELECT PNAME, STARTDATE FROM PERSONNEL WHERE ROWNUM<=5
ORDER BY STARTDATE DESC;



--@@@@@@@@�ſ� �߿�!!!!!! Web �Խ��ǿ��� �����@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

--������ ���ϱ� (�̰� �ܿ��)      --ROWNUM�� ��ȣ�� �� �����ָ� ��Ī�� ������Ѵ�.
-- 3~6������ ��������
SELECT RNUM,PNAME,STARTDATE FROM
(SELECT ROWNUM RNUM,PNAME,STARTDATE FROM 
(SELECT STARTDATE, PNAME FROM PERSONNEL
ORDER BY STARTDATE DESC))
WHERE RNUM >=3 AND RNUM<=6;


-- MS-SQL
SELECT TOP 5 PNAME,STARTDATE FROM PERSONNEL ORDERBY STARTDATE DESC; --�̰� MS-SQL���� ROWNUM��� TOP-N����
SELECT TOP 5 PERCENT PNAME,STARTDATE FROM PERSONNEL ORDER BY STARTDATE DESC; -- ���� 5�� �����Ͷ�


--SYNONYM(���Ǿ�)
CREATE OR REPLACE SYNONYM INSA
FOR PERSONNEL; -- kim���� ���� �ֱ� : GRANT CREATE SYNONYM TO kim;

SELECT * FROM INSA; -- �̰� SELECT * FROM KIM.PERSONNEL;�� ������ ���̶� ����.
SELECT * FROM KIM.PERSONNEL;
SELECT * FROM PERSONNEL;

SELECT ROWID,PNAME FROM PERSONNEL;

SELECT * FROM PERSONNEL WHERE PNO=1111;

SELECT * FROM PERSONNEL;

CREATE INDEX PER_PAY_IDX
ON PERSONNEL(PAY);

SELECT * FROM USER_INDEXES;

CREATE TABLE AAA
(ID NUMBER CONSTRAINT AAA_ID_IDX PRIMARY KEY,
NAME CHAR(10));

SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_INDEXES;


-- SEQUENCE(�ϷĹ�ȣ) -�������� �ϷĹ�ȣ ó�� �ִ� �� 

/*
CREATE SEQUENCE DIV_NO
INCREMENT BY 1
START WITH 1
MAXVALUE 100 || NOMAXVALUE
CYCLE || NOCYCLE
CACHE 20 || NOCACHE
*/

CREATE SEQUENCE PER_PNO
START WITH 90
INCREMENT BY 1
MAXVALUE 99
NOCYCLE
NOCACHE;

SELECT * FROM USER_SEQUENCES;

-- NEXTVAL : SEQUENCE�� ����� ��ȣ      ����� : (SEQUENCE�̸�.NEXTVAL)
-- CURRVAL : SEQUENCE�� ���� ��ȣ        ����� : (SEQUENCE�̸�.CURRVAL)


SELECT PER_PNO.NEXTVAL FROM DUAL;

INSERT INTO DIVISION (DNO,DNAME,POSITION)
VALUES (PER_PNO.NEXTVAL,'DEV','KOREA');

SELECT * FROM DIVISION;

SELECT PER_PNO.CURRVAL FROM DUAL;

--����
ALTER SEQUENCE PER_PNO
INCREMENT BY 1
MAXVALUE 999
CACHE 10
NOCYCLE;

SELECT * FROM USER_SEQUENCES; -- �����ϰ� Ȯ�� CACHE�� 10�� ���� MAX_VALUE�� 999, LAST_NUMBER�� 92�� �ٲ�










