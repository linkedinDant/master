.SUFFIXES: .c .o
CLNT = server
SRVR = server_svc
CFLAGS = -g -Wall

SRVR_OBJ = server_svc_proc.o server_xdr.o server_svc.o
CLNT_OBJ = server.o server_xdr.o server_clnt.o

.c.o:; gcc -c -o $@ $(CFLAGS) $<

default: $(CLNT) $(SRVR)

$(CLNT): $(CLNT_OBJ)
	gcc -o $(CLNT) $(CLNT_OBJ)

$(SRVR): $(SRVR_OBJ)
	gcc -o $(SRVR) $(SRVR_OBJ)