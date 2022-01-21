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

      