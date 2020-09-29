
cd /d/A_TeachingMaterial/6.JspSpring/deploy/jsp

git pull

mvn clean

mvn package

파일명 바꾸기
mv ./target/jsp-0.0.1-SNAPSHOT.war ./target/jsp.war
톰켓 셧다운
/d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/bin/shutdown.sh
jsp.war삭제
rm /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps/jsp.war
jsp 폴더 삭제
rm -rf /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps/jsp
target에 jsp.war tomcat에 복사
cp ./target/jsp.war /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps
서버 열기
/d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/bin/startup.sh




