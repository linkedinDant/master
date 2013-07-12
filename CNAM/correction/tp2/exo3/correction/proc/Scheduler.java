package tp2.exo3.correction.proc;


public class Scheduler {

  private LinkedList list;

  public Scheduler() {
    list = new LinkedList();
    Processus processus = new Processus();
    processus.setPid(1L);
    processus.setPpid(0L);
    list.addFirst(processus);
  }

  public boolean executeNext() {
    Processus p = list.removeFirst();
    if (p == null)
      return false;
    // Si le processus ne peut pas mourir, on le remet à la fin
    if(p.canDie() == false) {
      list.addLast(p);
    }
    // Si ce n'est pas init, on l'exécute
    if (p.getPid() > 1) {
      p.exec();
      boolean isDead = p.isDead();
      // Si le processus n'est pas mort, on le remet à la fin
      if (isDead == false) {
        list.addLast(p);
      } else {
        // Si le processus est mort, on lance init. Si ce processus avait des fils,
        // ces-derniers sont orphelins, donc il faut leur mettre init comme père
        executeInit();
      }
    }    
    return true;
  }

  
  public Processus addProcessus() {
    // Le processus créé est un fils de init. Donc il faut faire un fork sur init
    Processus init = list.search(1L);
    Processus fork = init.fork();
    addProcessus(fork);
    return fork;
  }

  public void addProcessus(Processus p) {
    list.addLast(p);
  }

  public void executeInit() {
    System.out.println("Lancement de init...");
    int size = list.size();
    // On parcourt tous les processus
    for (int i = 0; i < size; i++) {
      Processus processus = list.get(i);
      // Si ce n'est pas init
      if (processus.getPid() != 1L) {
        // Si le père du processus courant n'existe pas, cela signifie qu'il est mort
        // Donc que le processus est orphelin
        Processus search = list.search(processus.getPpid());
        // S'il est orphelin
        if (search == null) {
          // On met comme ppid 1 car le processus est orphelin
          processus.setPpid(1);
          System.out.println("[1] : Le processus [" + processus.getPid() + "] devient mon fils.");
        }
      }
    }
  }

  public void start() {
    // Tant que la liste contient plus d'un seul processus, on exécute
    while (list.size() > 1) {
      this.executeNext();
    }
    System.out.println("Plus de processus à gérer.");
  }

  @Override
  public String toString() {
    return list.toString();
  }

}
