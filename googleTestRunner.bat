echo "Welcome to batch Execution"
cd D:\SynechronBDD_15_03_2021\Eclipse_WS\actitime
d:
set path=%path%;D:\maven\apache-maven-3.6.1\bin
set classpath=D:\SynechronBDD_15_03_2021\Eclipse_WS\actitime\target\*;.
mvn test -Dcucumber.execution.dry-run=false -Dcucumber.filter.tags="@google"