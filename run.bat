start java -jar c:/selenium-server-standalone-2.53.0.jar -role hub
ECHO WScript.sleep 10000 > temp.vbs && cscript temp.vbs
start java -jar c:/selenium-server-standalone-2.53.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 6577
ECHO WScript.sleep 10000 > temp.vbs && cscript temp.vbs
