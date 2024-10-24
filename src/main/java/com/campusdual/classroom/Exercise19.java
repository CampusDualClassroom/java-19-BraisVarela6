package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int depth = intArrayTri.length;
        int rows = intArrayTri[0].length;
        int columns = intArrayTri[0][0].length;

        int[][] flatMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                flatMatrix[i][j] = 0;

                for (int k = 0; k < depth; k++) {
                    flatMatrix[i][j] += intArrayTri[k][i][j];
                }
            }

        }
        return flatMatrix;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder uni = new StringBuilder();

        for (int i = 0; i < intArrayBi.length; i++) {
            uni.append(stringFlatMatrixRow(intArrayBi,i));
            if (i < intArrayBi.length - 1) {
                uni.append("\n");
            }
        }
        return uni.toString();


    }

    // TODO
        public static String getUnidimensionalString(int[] uniArray) {
            StringBuilder uni = new StringBuilder();

            for (int i = 0; i < uniArray.length; i++) {
                uni.append(uniArray[i]);
                if (i < uniArray.length - 1) {
                    uni.append(" ");
                }
            }
            return uni.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int value = 0;
        int[] unidimensionalArray = new int[columns];

        for (int i = 0; i < columns; i++) {
                value++;
                unidimensionalArray[i] = value;
        }
        for (int i = 0; i < columns; i++) {
                System.out.print(unidimensionalArray[i] + " ");

        }
        return unidimensionalArray;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {

        int value = 0;
        int[][] bidimensionalArray = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                value++;
                bidimensionalArray[i][j] = value;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(bidimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        return bidimensionalArray;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int value = 0;
        int[][][] tridimensionalArray = new int[depth][rows][columns];
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    value++;
                    tridimensionalArray[i][j][k] = value;
                }
            }
        }
        for(int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    System.out.print(tridimensionalArray[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        return tridimensionalArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
