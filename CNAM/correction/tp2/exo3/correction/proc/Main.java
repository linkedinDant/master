package tp2.exo3.correction.proc;

public class Main {
  public static void main(String[] args) {
    Scheduler sc = new Scheduler();
    Processus first = sc.addProcessus();
    Processus second = sc.addProcessus();
    Processus third = first.fork();
    Processus fourth = second.fork();
    sc.addProcessus(third);
    sc.addProcessus(fourth);
    System.out.println(sc);
    sc.start();
  }

}
