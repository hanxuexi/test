import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

public class GoBang {

    private int boardsize = 9;

    private String[][] board_init;

    public void initboard() {

        board_init = new String[boardsize][boardsize];

        for (int i = 0; i < boardsize; i++) {

            for (int j = 0; j < boardsize; j++) {

                board_init[i][j] = "+";

            }

        }

    }

//打印出

    public void printboard() {

        for (int i = 0; i < boardsize; i++) {

            for (int j = 0; j < boardsize; j++) {

                System.out.print(board_init[i][j]);

            }

            System.out.println("");

        }

    }

//判断竖五子

    public boolean get_xpos(int x, int y) {

        int count = 1;

        for (int i = x + 1; boardsize > i; i++) {

            if (board_init[x][y] == board_init[i][y]) {

                count++;

            } else {

                break;

            }

        }

        for (int i = x - 1; i >= 0; i--) {

            if (board_init[x][y] == board_init[i][y]) {

                count++;

            } else {

                break;

            }

        }

        if (count >= 5) {

            return true;

        } else {

            return false;

        }

    }

//判断横五子

    public boolean get_ypos(int x, int y) {

        int count = 1;

        if ((board_init[x][y] == "o") | (board_init[x][y] == "x")) {

            for (int i = y + 1; boardsize > i; i++) {

                if (board_init[x][y] == board_init[x][i]) {

                    count++;

                } else {

                    break;

                }

            }

            for (int i = y - 1; i >= 0; i--) {

                if (board_init[x][y] == board_init[x][i]) {

                    count++;

                } else {

                    break;

                }

            }

        }

        if (count >= 5) {

            System.out.println(count);

            return true;

        } else {

            return false;

        }

    }

//判断胜负

    public int winner(int x, int y) {

        if (get_xpos(x, y) || get_ypos(x, y)) {

            if (board_init[x][y] == "o") {

                return 1;

            } else if (board_init[x][y] == "x") {

                return -1;

            } else {

                return -2;

            }

        }

        return 0;

    }

    public static void main(String[] args) throws Exception {

        GoBang gb = new GoBang();

        gb.initboard();

        gb.printboard();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String inputstr = null;

        while ((inputstr = br.readLine()) != null) {


            String[] posstr = inputstr.split(",");

            int xpos;

            int ypos;

            try {

                xpos = Integer.parseInt(posstr[0]);

                ypos = Integer.parseInt(posstr[1]);

            } catch (Exception e) {

                System.out.println("the number is not int:");

                continue;

            }

            if ((gb.board_init[xpos][ypos] == "o") | (gb.board_init[xpos][ypos] == "x")) {

                System.out.println("the seat is exit:");

                continue;

            }

            int posx;

            int posy;

            while (true) {

                posx = new java.util.Random().nextInt(8) + 1;

                posy = new java.util.Random().nextInt(8) + 1;

                if ((gb.board_init[xpos][ypos] == "o") | (gb.board_init[xpos][ypos] == "x")) {

                    continue;

                } else {

                    break;

                }

            }

            gb.board_init[xpos][ypos] = "o";

            gb.board_init[posx][posy] = "x";

            gb.printboard();

            System.out.println("enter x,and y:");

            if (gb.winner(xpos, ypos) == 1) {

                System.out.println("o is winner!");

                break;

            }

            if (gb.winner(posx, posy) == -1) {

                System.out.println("x is winner!");

                break;

            }


        }


    }

}
