.PHONY: test clean

test:
	javac -cp .:junit-platform-console-standalone-1.6.0.jar ija/ija2023/homework1/Homework1Test.java
	java -cp .:junit-platform-console-standalone-1.6.0.jar org.junit.runner.JUnitCore ija.ija2023.homework1.Homework1Test

clean:
	rm `find . -name '*.class'`
