javac *.java
jar cfe rps.jar GUITutorial *.class
del /S *.class
java -jar rps.jar