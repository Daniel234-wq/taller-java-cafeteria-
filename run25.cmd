@echo off
setlocal
set "JAVA_HOME=C:\Program Files\Microsoft\jdk-25.0.5.21-hotspot"
if not exist "%JAVA_HOME%\bin\java.exe" (
    echo Java 25 no encontrado en %JAVA_HOME%
    exit /b 1
)
set "PATH=%JAVA_HOME%\bin;%PATH%"
set "JAVA_TOOL_OPTIONS=-Dstdout.encoding=UTF-8 -Dnative.encoding=UTF-8 -Dfile.encoding=UTF-8"
java src\Main.java
