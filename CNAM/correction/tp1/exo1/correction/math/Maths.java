package tp1.exo1.correction.math;

public class Maths {

  static public int fact(int n) {
    if (n < 2) {
      return 1;
    }
    return n * fact(n - 1);
  }

  static public int factIteratif(int n) {
    int value = 1;
    for (int i = n; i >= 1; i--) {
      value *= i;
    }
    return value;
  }

  static public int pow(int n, int d) {
    if (d == 0) {
      return 1;
    }
    if (d < 1) {
      return n;
    }
    return n * pow(n, d - 1);
  }

  static public int powIteratif(int n, int d) {
    if (d == 0)
      return 1;
    
    int res = 1;
    for (int i = 0; i < d; i++) {
      res = res * n;
    }
    return res;
  }

  static public int abs(int val) {
    if (val < 0) {
      return -val;
    }
    return val;
  }

  static public int min(int a, int b) {
    if (a < b) {
      return a;
    }
    return b;
  }

  static public int max(int a, int b) {
    if (a > b) {
      return a;
    }
    return b;
  }
}
