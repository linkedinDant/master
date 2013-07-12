package tp2.exo3.correction.proc;

public class Processus {

  static private long PID = 1;
  
  private long pid;
  private long ppid;
  private long ttl;
  
  public Processus() {
  }

  public long getPid() {
    return this.pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }

  public long getPpid() {
    return this.ppid;
  }

  public void setPpid(long ppid) {
    this.ppid = ppid;
  }
  
  public long getTTL() {
    return ttl;
  }
  
  public void setTTL(long ttl) {
    this.ttl = ttl;
  }
  
  public boolean isDead() {
    return canDie() && ttl <= 0L;
  }
  
  public boolean canDie() {
    return pid != 1 && ppid != 0;
  }
  
  public Processus fork() {
    Processus child = new Processus();
    child.setPpid(pid);
    child.setPid(++PID);
    child.setTTL(child.getPid());
    return child;
  }
  
  public void exec() {
    System.out.println("[" + pid + "] : Je m'exécute...");
    try {
      Thread.sleep(1000L);
      ttl--;
    } catch (InterruptedException exception) {}
  }
  
  @Override
  public boolean equals(Object ob) {
    if(ob instanceof Processus) {
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
