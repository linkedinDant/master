CC=gcc
CFLAGS=-W -Wall -ansi -pedantic -O3
LDFLAGS=
EXEC=jacobi
BIN=bin
SRC=src
ARCHIVE=projet_PPAR_voron_pitton.tar.gz

all: jacobi

exec:
	./jacobi 10 #Todo a faire 

archive: 
	tar -cf $(ARCHIVE) $(SRC) Makefile

jacobi:jacobi.o
	$(CC) -o $@ $(BIN)/$^ $(LDFLAGS)

jacobi.o:$(SRC)/jacobi.c
	@mkdir -p $(BIN)
	$(CC) -o $(BIN)/$@ -c $< $(CFLAGS)

clean:
	@rm -rf $(BIN)/* $(EXEC) $(ARCHIVE)
	@echo "Projet nettoyé"
