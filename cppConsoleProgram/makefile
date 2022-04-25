myProgram: node.o board.o main.o
	g++ -g -std=c++11 node.o board.o main.o -o myProgram
node.o: node.cpp node.h
	g++ -c -std=c++11 node.cpp
board.o: board.cpp board.h node.h
	g++ -c -std=c++11 board.cpp
main.o: main.cpp board.h node.h
	g++ -c -std=c++11 main.o
valgrind:
	valgrind -s --leak-check=full ./myProgram
run: myProgram
	./myProgram
clean:
	del *.o
	del myProgram
