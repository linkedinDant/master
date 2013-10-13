CC=gcc
CFLAGS=-W -Wall -ansi -pedantic -O3
LDFLAGS=
EXEC=jacobi
BIN=bin

all: jacobi

jacobi:jacobi.o
	$(CC) -o $@ $(BIN)/$^ $(LDFLAGS)

jacobi.o:src/jacobi.c
	mkdir -p $(BIN)
	$(CC) -o $(BIN)/$@ -c $< $(CFLAGS)

clean:
	@rm -rf $(BIN)/* $(EXEC)
	@echo "Projet nettoyé"

exec:
	./jacobi 10 #Todo a faire 
