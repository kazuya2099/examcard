-- PDBシードのデータファイルの位置を確認
-- SQL> alter session set container=PDB$SEED;
-- セッションが変更されました。
-- SQL> select file_name from dba_data_files;
-- FILE_NAME
--------------------------------------------------------------------------------
-- C:\APP\MHAMA\PRODUCT\21C\ORADATA\XE\PDBSEED\UNDOTBS01.DBF
-- C:\APP\MHAMA\PRODUCT\21C\ORADATA\XE\PDBSEED\SYSAUX01.DBF
-- C:\APP\MHAMA\PRODUCT\21C\ORADATA\XE\PDBSEED\SYSTEM01.DBF

-- PDB作成
CREATE PLUGGABLE DATABASE EXAMCARD ADMIN USER EXAMCARD IDENTIFIED BY password
FILE_NAME_CONVERT = ('C:\APP\MHAMA\PRODUCT\21C\ORADATA\XE\PDBSEED\', 'C:\APP\MHAMA\PRODUCT\21C\ORADATA\XE\EXAMCARD\');

-- SQL> show pdbs
--     CON_ID CON_NAME                       OPEN MODE  RESTRICTED
---------- ------------------------------ ---------- ----------
--          2 PDB$SEED                       READ ONLY  NO
--          3 XEPDB1                         READ WRITE NO
--          4 EXAMCARD                       MOUNTED

-- SQL> alter pluggable database EXAMCARD open;
-- プラガブル・データベースが変更されました。
-- SQL> show pdbs
--     CON_ID CON_NAME                       OPEN MODE  RESTRICTED
---------- ------------------------------ ---------- ----------
--          2 PDB$SEED                       READ ONLY  NO
--          3 XEPDB1                         READ WRITE NO
--          4 EXAMCARD                       READ WRITE NO

-- 表領域EXAMCARDTBS01をC:\app\mhama\product\21c\oradata\XE\EXAMCARD\EXAMCARDTBS01.DBFに作成する
-- サイズは1024M。1024Mを超えたら100Mずつ自動拡張する
CREATE TABLESPACE EXAMCARD_TBS01 DATAFILE
'C:\app\mhama\product\21c\oradata\XE\EXAMCARD\TBS01.DBF' SIZE 1024M
AUTOEXTEND ON NEXT 100M MAXSIZE UNLIMITED;

-- 表領域EXAMCARDTEMP01をC:\app\mhama\product\21c\oradata\XE\EXAMCARD\TEMP01.DBF'に作成する
-- サイズは1024M。1024Mを超えたら100Mずつ自動拡張する
CREATE TABLESPACE EXAMCARD_TEMP01 DATAFILE
'C:\app\mhama\product\21c\oradata\XE\EXAMCARD\TEMP01.DBF' SIZE 1024M
AUTOEXTEND ON NEXT 100M MAXSIZE UNLIMITED;

-- sqlplus EXAMCARD/password@localhost:1521/EXAMCARD
CREATE TABLE DEPARTMENT (
  ID VARCHAR(4) NOT NULL,
  DEP_NAME VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (ID)
) TABLESPACE EXAMCARD_TBS01;

CREATE TABLE EMPLOYEE (
  ID VARCHAR(7) NOT NULL,
  SEI VARCHAR(20) DEFAULT NULL,
  MEI VARCHAR(20) DEFAULT NULL,
  SEI_KANA VARCHAR(20) DEFAULT NULL,
  MEI_KANA VARCHAR(20) DEFAULT NULL,
  DEP_ID VARCHAR(4) DEFAULT NULL,
  LOGIN_LAST_DATE DATE DEFAULT NULL,
  LOGIN_PASSWORD VARCHAR(60) DEFAULT NULL,
  PRIMARY KEY (ID)
) TABLESPACE EXAMCARD_TBS01;

CREATE TABLE EMPLOYEE_ROLE (
  EMP_ID VARCHAR(7) NOT NULL,
  DEP_ID VARCHAR(4) NOT NULL,
  ROLE_ID VARCHAR(4) DEFAULT NULL,
  PRIMARY KEY (EMP_ID,DEP_ID)
) TABLESPACE EXAMCARD_TBS01;

CREATE TABLE INFORMATION (
  ID VARCHAR(10) NOT NULL,
  MESSAGE VARCHAR(1000) DEFAULT NULL,
  START_DATE DATE DEFAULT NULL,
  END_DATE DATE DEFAULT NULL,
  PRIMARY KEY (ID)
) TABLESPACE EXAMCARD_TBS01;

-- 再起動時にDBがOPENしなかった時の対処
-- sqlplus system/manager as sysdba
-- show pdbs;
-- SHUTDOWN IMMEDIATE;
-- startup
-- データベースがマウントされました。
-- ORA-01157: データファイル20を識別/ロックできません -
-- DBWRトレース・ファイルを参照してください
-- ORA-01110: データファイル20:
-- 'C:\APP\MHAMA\PRODUCT\21C\ORADATA\XE\EXAMCARD\EXAMCARDTBS01.DBF'
-- alter database datafile 'C:\APP\MHAMA\PRODUCT\21C\ORADATA\XE\EXAMCARD\EXAMCARDTBS01.DBF' offline drop;
-- alter database open;
--    CON_ID CON_NAME                       OPEN MODE  RESTRICTED
---------- ------------------------------ ---------- ----------
--         2 PDB$SEED                       READ ONLY  NO
--         3 XEPDB1                         READ WRITE NO
--         4 EXAMCARD                       MOUNTED
-- alter pluggable database EXAMCARD open;
-- show pdbs
--    CON_ID CON_NAME                       OPEN MODE  RESTRICTED
---------- ------------------------------ ---------- ----------
--         2 PDB$SEED                       READ ONLY  NO
--         3 XEPDB1                         READ WRITE NO
--         4 EXAMCARD                       READ WRITE NO

-- alter session set container = EXAMCARD;
-- grant select on V_$SESSION to EXAMCARD;
-- grant select on V_$SQL_PLAN to EXAMCARD;
-- grant select on V_$SQL to EXAMCARD;
-- grant select on V_$SQL_PLAN_STATISTICS_ALL to EXAMCARD;
-- alter session set statistics_level=all;
-- select e.ID, e.SEI, e.MEI, e.SEI_KANA, e.MEI_KANA, e.DEP_ID, e.LOGIN_LAST_DATE, e.LOGIN_PASSWORD, r.ROLE_ID, d.DEP_NAME from employee e inner join employee_role r on e.ID = r.EMP_ID inner join department d on e.DEP_ID = d.ID where e.ID = '0000001'
-- select * from TABLE(DBMS_XPLAN.DISPLAY_CURSOR(format=>'ALLSTATS LAST'));

-- alter session set container = EXAMCARD;
-- alter database open;
