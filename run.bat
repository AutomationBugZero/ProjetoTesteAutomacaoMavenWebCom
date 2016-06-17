start java -jar c:/selenium-server-standalone-2.53.0.jar -role hub
wait 5
start java -jar c:/selenium-server-standalone-2.53.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 6577
wait 10
