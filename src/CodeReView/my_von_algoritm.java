package CodeReView;

public class my_von_algoritm {
    public static void main (String[] args){
        int [][] arr = new int [8][8];
        fillArr(arr);

        int startPoint = arr[1][1] = 2;
        int iEnd = 6;
        int jEnd = 6;
        int finishPoint = arr[iEnd][jEnd] = 1;
        printArr(arr);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

        checkArr(arr, startPoint, finishPoint);
        printArr(arr);
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

        findWay(arr, startPoint, iEnd,jEnd);
        printArr(arr);

    }
    static void fillArr(int[][] arr){
        int value = -1;
        // вверх
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = value;
        }
        // правая стена
        for (int i =  arr.length -1; i > 0; i--) {
                arr[i][arr[i].length-1] = value;
            }
        // низ
        for (int i = 0; i < arr.length - 1; i++) {
               arr[arr.length-1][i] = value;
            }
        // левая стена
        for (int i = 0; i < arr.length -1; i++){
                arr[i][0] = value;
        }
        arr[3][3] = -1;
        arr[3][4] = -1;
        arr[3][5] = -1;
        arr[3][6] = -1;
        arr[4][3] = -1;
        arr[5][3] = -1;
        arr[5][4] = -1;
    }
    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(" %4d ", arr[i][j]);
            }
            System.out.println("\n");
        }
    }

    static boolean waveArr(int [][] arr, int startPoint, int finishPoint, int i, int j){
        int count = 0;
        if (arr[i + 1][j] == 0 || arr[i + 1][j] == finishPoint) {
            arr[i + 1][j] = startPoint + 1;
            count++;
        }
        if (arr[i][j + 1] == 0 || arr[i][j + 1] == finishPoint) {
            arr[i][j + 1] = startPoint + 1;
            count++;
        }
        if (arr[i - 1][j] == 0 || arr[i - 1][j] == finishPoint) {
            arr[i - 1][j] = startPoint + 1;
            count++;
        }
        if (arr[i][j - 1] == 0 || arr[i][j - 1] == finishPoint) {
            arr[i][j - 1] = startPoint + 1;
            count++;
        }
        if (count == 0) return false;
        else return true;
    }

    static void checkArr(int[][] arr, int startPoint, int finishPoint){
        boolean checkTrue = true;
        while (checkTrue) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == startPoint) {
                        if (waveArr(arr, startPoint, finishPoint, i, j) == false) {
                            checkTrue = false;
                        }
                        else {
                            waveArr(arr, startPoint, finishPoint, i, j);
                            checkTrue = true;
                            count++;
                        }
                    }
                }
            }
            if (count == 0) checkTrue = false;
            else {
                startPoint++;
                checkTrue = true;
            }
        }
    }

    static void findWay(int[][] arr, int startPoint, int i, int j){
        int value = arr[i][j];
        while (value > startPoint) {
            if (arr[i + 1][j] == value - 1) {
                arr[i][j] = 0;
                value--;
                i++;
            }
            else if (arr[i][j + 1] == value - 1) {
                arr[i][j] = 0;
                value--;
                j++;
            }
            else if (arr[i - 1][j] == value - 1) {
                arr[i][j] = 0;
                value--;
                i--;
            }
            else if (arr[i][j - 1] == value - 1) {
                arr[i][j] = 0;
                value--;
                j--;
            }
            if (value == startPoint) {
                arr[i][j] = 0;
            }
        }
    }
}
