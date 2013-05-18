#include "exo4-2.h"

int main(int argc, char* argv[]) {
  // On vérifie qu'il y a un argument
  if(argc == 1) {
    perror("Vous devez spécifier un nombre de processus.\n");
    return EXIT_FAILURE;
  }
  // On convertit en nombre. Si c'est autre chose qu'un nombre,
  // atoi renverra 0 et sera considéré comme faux (aucun sens de vouloir créer 0 ici).
  char* number = argv[1];
  int real_number = atoi(number);
  if(real_number <= 0) {
    perror("Vous devez spécifier un nombre entier en argument.\n");
    return EXIT_FAILURE;
  }
  // On crée un tableau qui stockera tous les pids et on met le pid du processus
  // courant
  pid_t pids[++real_number];
  pids[0] = getpid();
  // On démarre la récursivité
  fork_with_pid(0, real_number, pids);
  return EXIT_SUCCESS;
}

void fork_with_pid(int current, const int maximum, pid_t* pids) {
  // Condition d'arrêt, on a bouclé le maximum de fois
  if(current >= maximum - 1) {
    int i;
    // On affiche tous les pids. Le pid courant a été donné par
    // le précédent fork, qui l'a mis dans le tableau.
    for(i = maximum - 1 ; i >= 0 ; i--) {
      printf("%d ", pids[i]);
    }
    printf("\n");
    int tmp_rand = (int)(rand () /(((double) RAND_MAX +1) /100));
    printf("Je suis le processus %d et je génère le random suivant : %d\n", pids[current],tmp_rand);
    exit(tmp_rand);
    return;
  }
  // On doit créer un fils
  pid_t new_pid;
  // On stocke le pid du fils
  new_pid = fork();
  if(new_pid == 0) {
    // Code exécuté par le fils. Il stocke son pid dans le tableau,
    // et ce de manière trié (puisque l'on incrémente à chaque fois, on remplit dans l'ordre 
    // ET on s'assure de ne pas boucler infiniment).
    pids[++current] = getpid();
    // On appelle de manière récursive. Si current == maximum -1 ici, alors on aura fini 
    // dès l'appel à cette méthode par la condition d'arrêt
    fork_with_pid(current, maximum, pids);
  } else {
    // Code exécuté par le père. Il attend que tous ses fils soient morts pour continuer
    int status;
    wait(&status);
    status = WEXITSTATUS(status);
    // Le père affiche le pid de son fils etc...
    printf("Fils %d - Courant %d - Père %d.\n", new_pid, pids[current], getppid());
    if(current == 0) {
      printf("Je suis le processus %d et le random renvoyé par le fils le plus bas est %d.\n", pids[current], status);
    }
    exit(status);
  }
}
