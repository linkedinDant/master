#define N      3    /* Number of processes */ 
#define L     10    /* Buffer size */
#define NIL (N+1)   /* for an undefined value */

#define TOKEN 0
#define REQUEST 1

mtype = {req, tk};

/* le processus i recoit ses messages dans canal[i] */ 
chan canal[N] = [L] of {mtype, byte};    /* pour un message de type tk, 
                                            on mettra la valeur associee a 0 */

byte SharedVar = 0;                      /* la variable partagee */ 

inline Initialisation ( ) {
   requesting = false;
   token = (id == Initial_Token_Holder);
   next = NIL;
   if
    :: (token == true) ->
       father = NIL;
    :: else -> father = Initial_Token_Holder;
   fi;
}

inline Request_CS ( ) {
  mtype t;
  requesting = true;
  if
     :: (father != NIL) -> 
        canal[father]! REQUEST, id;
        father = NIL;
     :: else -> skip;
  fi;
  
}

inline Release_CS ( ) {
    requesting = false;
    if
      :: (next != NIL) ->
          canal[next]! TOKEN, id;
          token = false;
          next = NIL;
      :: else -> skip;
    fi;
}

inline Receive_Request_CS ( ) {
  mtype t;
  if
    :: (father == NIL) ->
      if
        :: (requesting == true) ->
            next = val;
        :: else ->
            token = false;
            canal[val]!TOKEN, id;
      fi;
    :: else ->
      canal[father]!REQUEST, val;
  fi;
  father = val;
}

inline Receive_Token () {
  token = true;
}


proctype node(byte id; byte Initial_Token_Holder){
    
   bit requesting;    /* indique si le processus a demande la SC ou pas  */
   bit token;         /* indique si le processus possede le jeton ou non */

   byte father;       /* probable owner */
   byte next;         /* next node to whom send the token */
   byte val;          /* la valeur contenue dans le message */
   mtype typ_mes;     /* le type du message recu */
   byte reqId;        /* l'Id du demandeur, pour une requete */

   chan canal_rec = canal[id];     /* un alias pour mon canal de reception */
   xr canal_rec;                   /* je dois etre le seul a le lire */

   /* Chaque processus execute une boucle infinie */

   Initialisation ( );
   do
       :: ((token == true) && empty(canal_rec) && (requesting == true)) ->
	      /* on oblige le detenteur du jeton a consulter les messages recus */
	      in_SC :
	           SharedVar++;
	           assert(SharedVar == 1);
	           printf("[%d] est en SC\n", id);
 	           SharedVar--;
 	           Release_CS ( );
       :: canal_rec ? typ_mes(val) ->
             if
                :: (typ_mes == REQUEST) -> Receive_Request_CS ( );
                :: else -> Receive_Token ( );
             fi;
       :: (requesting == false) -> /* demander la SC */
               Request_CS ( );
   od ;
}

/* Cree un ensemble de N processus */ 

init {
   byte proc; 
   atomic {
      proc=0;
      do
         :: proc <N ->
            run node(proc, 0); 
            proc++
         :: proc == N -> break 
      od
   }
}
