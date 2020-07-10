package homeworkfour;

import java.util.Arrays;
import java.util.Scanner;

public class homeWorkFourTasks {

    private static Scanner scn = new Scanner(System.in);

    private static int turnNum;

    private static final char DOT_EMPTY = '*';
    private static final char DOT_O = 'O';
    private static final char DOT_X = 'X';

    private static final int fieldSIZE = 5;

    private static final int winCharCount = 4;

    private static int [] winOffSet = new int [winCharCount];

    private static char [][] field;

    public void startGame() {
        if (winCharCount > fieldSIZE) {
            System.out.println("Размер поля меньше, чем выигрышная комбинация");
            return;
        }
        for (int i = 0; i < winCharCount; i++) {
            winOffSet[i] = i;
        }
        field = initField();
        printField();
        turnNum = 1;
        do {
            userTurn();
            turnNum++;
            if (isWin(field, DOT_X)) {
                System.out.println("Поздравляю, Вы выиграли!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            turnNum++;
            if (isWin(field, DOT_O)) {
                System.out.println("Вы ПРОИГРАЛИ!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
        } while (true);
        scn.close();
    }

    private static char [][] createCopyCharArr(char [][] arr) {
        char [][] retArr = new char[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                retArr[i][j] = arr[i][j];
            }
        }
        return retArr;
    }

    private static char [][] initField() {
        char [][] arr = new char[fieldSIZE][fieldSIZE];
        for (int i = 0; i < fieldSIZE; i++) {
            for (int j = 0; j < fieldSIZE; j++) {
                arr[i][j] = DOT_EMPTY;
            }
        }
        return arr;
    }

    private static void printField() {
        System.out.print("  ");
        for (int i = 0; i < fieldSIZE; i++) {            //первая строка, номера столбцов Х
            System.out.print("  " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < fieldSIZE; i++) {
            System.out.print((i + 1) + " ");            // номера строк У
           for (int j = 0; j < fieldSIZE; j++) {
                System.out.print("  " + field[i][j]);  // содержимое поля
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidTurn(int column, int row) {
        if ((row) < fieldSIZE && (row) >= 0 && (column) < fieldSIZE && (column) >= 0) {
            return field[row][column] == DOT_EMPTY;
        }
        return  false;
    }

    private static boolean isDraw() {
        return turnNum == fieldSIZE * fieldSIZE;
    }

    private static void userTurn() {
        int myCol, myRow;

        do {
            System.out.println("Введите координаты хода, в формате Х У (Х - столбец, У - строка)");
            myCol = scn.nextInt() - 1;
            myRow = scn.nextInt() - 1;
            if (isValidTurn(myCol, myRow)) {
                break;
            } else {
                System.out.println("Не правильные координаты, попробуйте еще раз.");
            }
        } while (true);

        field[myRow][myCol] = DOT_X;
        printField();
    }

    private static boolean isWin(char [][] checkField, char whoTurn) {
        int winCounterH, winCounterV, winCounterDR, winCounterDL;

        for (int i = 0; i < fieldSIZE; i++) {
            for (int j = 0; j < fieldSIZE; j++) {
                if (checkField[i][j] == whoTurn){                    // в ячейке нужный символ
                    winCounterH = winCounterV = winCounterDR = winCounterDL = 1; // инит счетчиков победной комбинации
                    for (int k = 1; k < winCharCount; k++) {                     // цикл по массиву смещений
                        // горизонтальные комбинации
                        if (j + winOffSet[k] <= fieldSIZE - 1) {
                            if (winCounterH > 0) {
                                if (checkField[i][j + winOffSet[k]] == whoTurn) {
                                    winCounterH++;
                                } else {
                                    winCounterH = 0;      // в клетке не нужный символ, счетчик в ноль
                                }
                            }
                        }
                        // вертикальные комбинации
                        if (i + winOffSet[k] <= fieldSIZE - 1) {
                            if (winCounterV > 0) {
                                if (checkField[i + winOffSet[k]][j] == whoTurn) {
                                    winCounterV++;
                                } else {
                                    winCounterV = 0;
                                }
                            }
                        }
                        // диагональ слева на право вниз
                        if ((i + winOffSet[k] <= fieldSIZE - 1) && (j + winOffSet[k] <= fieldSIZE - 1)) {
                            if (winCounterDR > 0) {
                                if (checkField[i + winOffSet[k]][j + winOffSet[k]] == whoTurn) {
                                    winCounterDR++;
                                } else {
                                    winCounterDR = 0;
                                }
                            }
                        }
                        // диагональ справа на лево вниз
                        if ((i + winOffSet[k] <= fieldSIZE - 1) && (j + (winOffSet[k] * -1) >= 0)) {
                            if (winCounterDL > 0) {
                                if (checkField[i + winOffSet[k]][j + (winOffSet[k] * -1)] == whoTurn) {
                                    winCounterDL++;
                                } else {
                                    winCounterDL = 0;
                                }
                            }
                        }

                    }
                    if (winCounterH == winCharCount || winCounterV == winCharCount ||
                            winCounterDR == winCharCount || winCounterDL == winCharCount) {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }

    private static void aiTurn() {
        int aiCol, aiRow;

        int [] blockTurn, myTurn;

        myTurn = nextTurnToWin(DOT_O);
        if (myTurn != null) {                     // если след.ход ai победный, то ходим туда
            aiRow = myTurn[0];
            aiCol = myTurn[1];
        } else {
            blockTurn = nextTurnToWin(DOT_X);
            if (blockTurn != null) {        // след.ход игрока победит, блокируем
                aiRow = blockTurn[0];
                aiCol = blockTurn[1];
            } else {
                blockTurn = findFork(DOT_X);
                if (blockTurn != null) {             // если противник может поставить вилку, бокируем
                    aiRow = blockTurn[0];
                    aiCol = blockTurn[1];
                } else {
                    myTurn = findFork(DOT_O);
                    if (myTurn != null) {       // если ai может создать вилку след.ходом, то создаем
                        aiRow = myTurn[0];
                        aiCol = myTurn[1];
                    } else {
                        myTurn = tryCreateFork(DOT_O);
                        if (myTurn != null) {   // если ai может сделать потенциальную вилку, создаем
                            aiRow = myTurn[0];
                            aiCol = myTurn[1];
                        } else {
                            do {                // без вариантов, ходим куда попало...
                                aiCol = (int) (Math.random() * fieldSIZE);
                                aiRow = (int) (Math.random() * fieldSIZE);
                            } while (!isValidTurn(aiCol, aiRow));
                        }
                    }
                }
            }
        }

        field[aiRow][aiCol] = DOT_O;
        printField();
    }

    private static int [] nextTurnToWin(char whoCheck) {
        int [] colOffSet = { 0,  1, 1, 1, 0, -1, -1, -1}; // смещение по столбцам
        int [] rowOffSet = {-1, -1, 0, 1, 1,  1,  0, -1}; // смещение по колонкам
        int [] nextWinCoord = new int [2];
        char [][] tempField;

        tempField = createCopyCharArr(field);

        for (int i = 0; i < fieldSIZE; i++) {
            for (int j = 0; j < fieldSIZE; j++) {
                if (tempField[i][j] == whoCheck) {  // надена ячейка с нужным символом
                    for (int k = 0; k < colOffSet.length; k++) {    // проверяем окрестности
                        if (isValidTurn(j + colOffSet[k], i + rowOffSet[k])) {  // можно ли ходить?
                            tempField[i + rowOffSet[k]][j + colOffSet[k]] = whoCheck;
                            if (isWin(tempField, whoCheck)) {   // ход был последним и выиграл
                                nextWinCoord[0] = i + rowOffSet[k];
                                nextWinCoord[1] = j + colOffSet[k];
                                return nextWinCoord;
                            } else {
                                tempField[i + rowOffSet[k]][j + colOffSet[k]] = DOT_EMPTY;
                            }
                        }

                    }
                }
            }
        }
        return null;
    }

    private static int [] findFork(char whoCheck) {
        char [][] tempField;
        int charInRow, charInCol;
        int otherCharInRow, otherCharInCol;
//        byte [] forkMask = { 0, 1, 1, 1, 0};

//        charInRow = charInCol = 0;


        tempField = createCopyCharArr(field);
        int [] forkCoord = new int[2];

        for (int i = 0; i < fieldSIZE; i++) {
            charInRow = charInCol = 0;
            otherCharInRow = otherCharInCol = 0;
            for (int j = 0; j < fieldSIZE; j++) {
                // проверям строки
                if (tempField[i][j] == whoCheck) {      // искомый символ
                    charInRow++;
                } else  if (tempField[i][j] != DOT_EMPTY){  //другой символ
                    otherCharInRow++;
                }
                // проверяем столбцы
                if (tempField[j][i] == whoCheck) {
                    charInCol++;
                } else if (tempField[j][i] != DOT_EMPTY) {
                    otherCharInCol++;
                }
            }
            if (charInRow > 1 && otherCharInRow == 0 && (fieldSIZE - 1 == winCharCount)) {          // возможная вилка в строке
                if (tempField[i][0] == DOT_EMPTY && tempField[i][fieldSIZE - 1] == DOT_EMPTY) {     // вилка
                    for (int k = 1; k < winCharCount; k++) {
                        if (tempField[i][k] == DOT_EMPTY) { // свободное поле для блока вилки
                            forkCoord[0] = i;
                            forkCoord[1] = k;
                            return forkCoord;
                        }
                    }
                }
            }
            if (charInCol > 1 && otherCharInCol == 0 && (fieldSIZE - 1 == winCharCount)) { // возможная вилка в столбце
                if (tempField[0][i] == DOT_EMPTY && tempField[fieldSIZE - 1][i] == DOT_EMPTY) {     // вилка
                    for (int k = 1; k < winCharCount; k++) {
                        if (tempField[k][i] == DOT_EMPTY) {
                            forkCoord[0] = k;
                            forkCoord[1] = i;
                            return forkCoord;
                        }
                    }
                }
            }
        }

        return null;
    }

    private static int [] tryCreateFork(char whoCreate) {
        int charInRow, charInCol;
        int otherCharInRow, otherCharInCol;

        char [][] tempField;
        int [] forkCoord = new int[2];

        tempField = createCopyCharArr(field);

        for (int i = 0; i < fieldSIZE; i++) {
            charInRow = charInCol = 0;
            otherCharInRow = otherCharInCol = 0;
            for (int j = 0; j < fieldSIZE; j++) {
                // строки
                if (tempField[i][j] == whoCreate) {
                    charInRow++;
                } else if (tempField[i][j] != DOT_EMPTY) {
                    otherCharInRow++;
                }
                //столбцы
                if (tempField[j][i] == whoCreate) {
                    charInCol++;
                } else if (tempField[j][i] != DOT_EMPTY) {
                    otherCharInCol++;
                }
            }
            if (charInRow >= 1 && otherCharInRow == 0 && (fieldSIZE - 1 == winCharCount)) {          // вариант для вилки в строке
                if (tempField[i][0] == DOT_EMPTY && tempField[i][fieldSIZE - 1] == DOT_EMPTY) {     // места для вилки хватает
                    for (int k = 1; k < winCharCount; k++) {
                        if (tempField[i][k] == DOT_EMPTY) { // место для хода под потенциальную вилку
                            forkCoord[0] = i;
                            forkCoord[1] = k;
                            return forkCoord;
                        }
                    }
                }
            }
            if (charInCol >= 1 && otherCharInCol == 0 && (fieldSIZE - 1 == winCharCount)) { // возможная вилка в столбце
                if (tempField[0][i] == DOT_EMPTY && tempField[fieldSIZE - 1][i] == DOT_EMPTY) {     // вилка
                    for (int k = 1; k < winCharCount; k++) {
                        if (tempField[k][i] == DOT_EMPTY) {
                            forkCoord[0] = k;
                            forkCoord[1] = i;
                            return forkCoord;
                        }
                    }
                }
            }
        }

        return null;
    }

}
