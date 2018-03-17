package game;

public class Game {
    int[][] vector = new int[4][4];

    public Game() {
        reload();
    }

    public void reload(){
        //initialize with 0
        for(int i=1; i<=3; i++)
            for(int j =1; j<=3; j++)
                vector[i][j]=0;
    }

    public int setPozitie(int x, int y, String move){
        if(move.equals("X")){
            vector[x][y] = 1;
            return checkWin(1);
        }
        else{
            vector[x][y] = 2;
            return checkWin(2);
        }
    }

    /**
     * Check win in the matrix for a specific value
     * @param value 1 if it is X, 2 otherwise
     * @return 1 if X/O win, 0 otherwise
     */
    private int checkWin(int value){
        int i;
        //lines
        for(i=1;i<=3; i++)
            if(vector[i][1]==vector[i][2])
                if(vector[i][2]==vector[i][3])
                    if(vector[i][3]==value)
                        return 1;
        //colums
        for(i=1;i<=3; i++)
            if(vector[1][i]==vector[2][i])
                if(vector[2][i]==vector[3][i])
                    if(vector[3][i]==value)
                        return 1;

        //diagonals
        if(vector[1][1]==vector[2][2])
            if(vector[2][2]==vector[3][3])
                if(vector[3][3]==value)
                    return 1;

        if(vector[1][3]==vector[2][2])
            if(vector[2][2]==vector[3][1])
                if(vector[3][1]==value)
                    return 1;

        int contor=0;

        for(i=1;i<=3;i++)
            for(int j =1; j<=3; j++)
                if(vector[i][j]!=0)
                    contor++;
        if(contor==3*3)
            return 2;

        return 0;
    }
}
