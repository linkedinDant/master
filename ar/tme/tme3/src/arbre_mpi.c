#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

#define min(a,b) ((a) > (b)) ? (b) : (a)

#define TAGINIT 0
#define TAGRESPONSE 1
#define NB_SITE 6

int nb_voisin, minimum, msg_recv;
int final_min;
int* voisins;
int* didrecv;
int last, fin, a_envoye, rang;

void simulateur(void) {
  int i;

  /* nb_voisins[i] est le nombre de voisins du site i */
  int nb_voisins[NB_SITE+1] = {-1, 2, 3, 2, 1, 1, 1};
  int min_local[NB_SITE+1] = {-1, 3, 11, 8, 14, 5, 17};

  /* liste des voisins */
  int voisins[NB_SITE+1][3] = {{-1, -1, -1},
			       {2, 3, -1}, {1, 4, 5}, 
			       {1, 6, -1}, {2, -1, -1},
			       {2, -1, -1}, {3, -1, -1}};
                               
  for(i=1; i<=NB_SITE; i++){
    MPI_Send(&nb_voisins[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);    
    MPI_Send(voisins[i],nb_voisins[i], MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
    MPI_Send(&min_local[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD); 
  }
}


void decide() {
  int i;
  printf("[%d] est decideur minimum = %d\n", rang, final_min);

  for(i=0; i<nb_voisin; i++)
    if(voisins[i] != last) 
      MPI_Send(&final_min, 1, MPI_INT, voisins[i], TAGRESPONSE, MPI_COMM_WORLD);
  fin = 1;
}

void recoit() {
  MPI_Status status;
  int flag, i;
  
  MPI_Iprobe(MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &flag, &status);
  if (!flag)
    return;
  
  
  MPI_Recv(&minimum, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
  msg_recv++;
  last =  status.MPI_SOURCE;
  final_min = min(final_min, minimum);
  
  if (status.MPI_TAG == TAGINIT) {
    for(i=0; i<nb_voisin; i++)
      if(status.MPI_SOURCE == voisins[i])
	didrecv[i] = 1;
    
    if(msg_recv == nb_voisin)
      decide();

  } else {
    printf("[%d] minimum = %d\n", rang, final_min);
    for(i=0; i<nb_voisin; i++) 
      if(voisins[i] != last) {
	MPI_Send(&final_min, 1, MPI_INT, voisins[i], TAGRESPONSE, MPI_COMM_WORLD);
      }
    fin = 1;
  }
}


  void envoie() {
    int i, j, sd;
    int is_present = 0;
  
    if (msg_recv < nb_voisin-1 || a_envoye)
      return;
  
    for(i=0; i<nb_voisin; i++) {
      if(didrecv[i] == 0)
	sd = voisins[i];
    }
    MPI_Send(&final_min, 1, MPI_INT, sd, TAGINIT, MPI_COMM_WORLD);
    a_envoye = 1;
  }

  void calcul_min(int rang) {
    MPI_Status status;
    // Initialisation des valeurs
    MPI_Recv(&nb_voisin, 1, MPI_INT, MPI_ANY_SOURCE, TAGINIT, MPI_COMM_WORLD,
	     &status);
    voisins = malloc(nb_voisin * sizeof(int));
    MPI_Recv(voisins, nb_voisin, MPI_INT, MPI_ANY_SOURCE, TAGINIT,
	     MPI_COMM_WORLD, &status);
    MPI_Recv(&minimum, 1, MPI_INT, MPI_ANY_SOURCE, TAGINIT, MPI_COMM_WORLD,
	     &status);
    int i;

    didrecv = malloc(sizeof(int)*nb_voisin);
    for(i=0; i<nb_voisin;i++)
      didrecv[i] = 0;
    last = -1;
    msg_recv = 0;
    fin = 0;
    a_envoye = 0;
    final_min = minimum;

    while (!fin) {
      recoit();
      envoie();
    }
  }
  int main (int argc, char* argv[]) {
    int nb_proc;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);

    if (nb_proc != NB_SITE+1) {
      printf("Nombre de processus incorrect !\n");
      MPI_Finalize();
      exit(2);
    }
  
    MPI_Comm_rank(MPI_COMM_WORLD, &rang);
  
    if (rang == 0) {
      simulateur();
    } else {
      calcul_min(rang);
    }
  
    MPI_Finalize();
    return 0;
  }
