1. 작업환경
Java = jdk 1.7_80
IDE = Intellij
Tomcat version = 7.0
DB = Mysql

2.사전작업
document/createTable.sql 사용하여 스키마 생성하면 됩니다.
C://fileMap 가 파일 경로 입니다. ( 없으면 자동으로 생성합니다. )

3. 배포
미리 빌드하여 생성된 target/nxapp-1.0.0-BUILD-SNAPSHOT.war 를 복사하여 배포하면 됩니다.

4. 빌드
intellij & eclipse
4-1) 프로젝트 import (intellij->open)
4-2) maven clean -> maven instll
4-3) success 확인 후  target/nxapp-1.0.0-BUILD-SNAPSHOT.war 를 확인
4-4) target/nxapp-1.0.0-BUILD-SNAPSHOT.war를 톰캣으로 배포
