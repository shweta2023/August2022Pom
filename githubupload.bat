@echo off
cd "C:\Users\shwet\eclipse-workspace\SeleniumAutomationFramework2POM"
git add .
set /p commitm="Commit Msg: "
git commit -m %commitm%
git push origin2