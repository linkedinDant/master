package tp2.exo3.proc;

public class Processus {

  static private long PID = 1;
  
  private long pid;
  private long ppid;
  private long ttl;

  public Processus() {
  }
  
  public void exec() {
    System.out.println("[" + pid + "] : Je m'exécute...");
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException exception) {
    }
  }

  @Override
  public boolean equals(Object ob) {
    if (ob instanceof Processus) {
      Processus p = (Processus) ob;
      return pid == p.pid;
    }
    return false;
  }

  @Override
  public String toString() {
    return Long.toString(pid);
  }

}
