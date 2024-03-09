.PHONY: test clean submit

test:
	javac -cp .:junit-platform-console-standalone-1.6.0.jar ija/ija2023/homework1/Homework1Test.java
	java -cp .:junit-platform-console-standalone-1.6.0.jar org.junit.runner.JUnitCore ija.ija2023.homework1.Homework1Test

submit:
	zip xstigl00.zip \
		ija/ija2023/homework1/common/*.java \
		ija/ija2023/homework1/room/*.java

clean:
	rm `find . -name '*.class'`
