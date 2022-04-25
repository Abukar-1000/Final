Main.class: Node.class Board.class AutoTour.class LaunchPage.class
	javac -g Main.java 
Node.class: Node.java
	javac -g Node.java 
Board.class: Board.java Node.java
	javac -g Board.java
AutoTour.class: AutoTour.java Board.java Node.java
	javac -g AutoTour.java
LaunchPage.class: LaunchPage.java AutoTour.java Board.java Node.java
	javac -g LaunchPage.java
run: Main.class
	java Main
clean:
	rm *.class
	rm Main.class