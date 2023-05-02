-- system


-- ������ �� ��(GRANT) - (��������� ����)

GRANT CREATE USER TO kim; -- kim���� ������ �ش�.

SELECT * FROM DBA_USERS;-- � �������� ��������µ� ���� ��ɾ��̴�.(������ ������) -- �̸�ɾ�� DBA�� ������ �� �ִ�.

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO TEST;

ALTER USER TEST ACCOUNT LOCK; -- TEST���� LOCK -> ���

ALTER USER TEST IDENTIFIED BY ABC ACCOUNT UNLOCK; -- TEST���� UNLOCK �ϸ鼭 ��й�ȣ ����(ABC��)


--������ ���� ��(REVOKE)

REVOKE CREATE USER FROM kim; -- KIM���׼� CREATE ������ �����

/*
-- ������ ����

SYSYTEM ���� - DATABASE�� OBJECT���� ����(CREATE), ����(ALTER), ����(DROP) �� �� �ִ� ����
             - DBA -> USER
             
OBJECT ���� - OBJECT ������ �߰�(INSERT), ����(UPDATE), ����(DELETE), �˻�(SELECT) �� �� �ִ� ����
            - USER -> USERS


OBJECT : TABLE, SEQUENCE, VIEW

*/

 -- (SYSTEM)�ý��� ����
SELECT * FROM SYSTEM_PRIVILEGE_MAP; -- (SYSTEM)�ý��� ����


GRANT CREATE SESSION,RESOURCE,UNLIMITED TABLESPACE TO SUZI; -- SUZI���� CREATE ������ �ش�.

REVOKE RESOURCE, UNLIMITED TABLESPACE FROM SUZI; -- SUZI���� ������ ���´�.


GRANT CREATE ROLE TO KIM; -- KIM���� ROLE�� ���� �� �ִ� ������ ��

CREATE ROLE MANAGER;

GRANT CREATE USER,CREATE VIEW TO MANAGER; --MANAGER �ȿ� CREATE USER, CREATE VIEW ������ ��

SELECT * FROM DBA_ROLES; -- ROLES�� ���� �˻�

SELECT * FROM ROLE_SYS_PRIVS; --DBA�� �ɷ�����

--DBA�� �ɷ���������  MANAGER�� ���� ������ �ִ��� �˻�
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'MANAGER';

GRANT MANAGER TO SUZI; -- MANAGER �̶��  ROLE�� SUZI���� �ش�.

REVOKE MANAGER FROM SUZI;

-- (OBJECT) ������Ʈ ����
-- �̰� �Ϲݻ���ڰ� �Ϲ� ��������� �ִ� �����̴�.

