package problem1107;

import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> NC = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            NC.add(i);
        }
        int C = sc.nextInt();
        String SC = String.valueOf(C);
        int[] arr = new int[SC.length() + 1];
        for (int i = SC.length() - 1; i >= 0; i--) {
            arr[i] = (int) ((C % (Math.pow(10, i + 1))) / ((Math.pow(10, i))));
        }
        int I = sc.nextInt();
        for (int i = 0; i < I; i++) {
            NC.remove(sc.nextInt());
        }
        int R;
        if (C == 100) {
            R = 0;
        } else if (I == 10) {
            R = Math.abs(C - 100);
        } else {
            if (SC.length() == 1 && NC.contains(C)) {
                R = 1;
            } else {
                int minN = NC.first();
                int maxN = NC.last();
                NC.add(-1);
                NC.add(10);
                boolean bMin = C > minN;
                boolean bMax = maxN != 0;
                int[] arrP = arr.clone();
                int[] arrM = arr.clone();
                if (bMax || bMin) {
                    for (int i = arr.length - 2; i >= 0; i--) {
                        if (!NC.contains(arr[i])) {
                            if (bMax) {
                                plus(arrP, NC, minN, i);
                            }
                            if (bMin) {
                                minus(arrM, NC, maxN, i);
                            }
                            for (int j = i - 1; j >= 0; j--) {
                                arrP[j] = minN;
                                if (bMin) {
                                    arrM[j] = maxN;
                                }
                            }
                            break;
                        }
                    }
                }
                String arrSP = "0";
                if (bMax) {
                    arrSP = getString(arrP, arrSP);
                }
                String arrSM = "0";
                if (bMin) {
                    arrSM = getString(arrM, arrSM);
                }
                if (bMax && bMin) {
                    R = Math.min(Math.abs(C - 100), Math.min(arrSP.length() + Math.abs(C - Integer.parseInt(arrSP)), arrSM.length() + Math.abs(C - Integer.parseInt(arrSM))));
                } else if (bMax) {
                    R = Math.min(Math.abs(C - 100), arrSP.length() + Math.abs(C - Integer.parseInt(arrSP)));
                } else if (bMin) {
                    R = Math.min(Math.abs(C - 100), arrSM.length() + Math.abs(C - Integer.parseInt(arrSM)));
                } else {
                    R = Math.abs(C - 100);
                }
            }
        }
        System.out.println(R);
    }

    private static String getString(int[] arr, String arrS) {
        for (int i = arr.length - 1; i >= 0; i--) {
            arrS += arr[i];
        }
        return String.valueOf(Integer.parseInt(arrS));
    }

    private static void plus(int[] arr, TreeSet<Integer> nc, int minN, int c) {
        while (true) {
            boolean overTen = false;
            int k = nc.higher(arr[c]);
            if (k == 10) {
                arr[c] = minN;
                overTen = true;
            } else {
                arr[c] = k;
            }
            if (!overTen || c >= arr.length - 2) {
                if (c >= arr.length - 2 && overTen) {
                    arr[arr.length - 1] = nc.higher(0);
                }
                break;
            }
            c++;
        }
    }

    private static void minus(int[] arr, TreeSet<Integer> nc, int maxN, int c) {
        while (true) {
            boolean overTen = false;
            int k = nc.lower(arr[c]);
            if (k < 0) {
                if (c >= arr.length - 2) {
                    arr[c] = 0;
                    break;
                } else {
                    arr[c] = maxN;
                    overTen = true;
                }
            } else {
                arr[c] = k;
            }
            if (!overTen || c >= arr.length - 2) {
                break;
            }
            c++;
        }
    }
}