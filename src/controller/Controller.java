package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.AlertBox;
import game.Game;

import java.util.Objects;


public class Controller {
    private String setChar = "X";
    private int score_x = 0;
    private int score_o = 0;
    private Game game = new Game();

    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button b9;
    @FXML
    Label ScorX;
    @FXML
    Label ScorO;


    private void action(Button b, int x, int y){
        if(Objects.equals(b.getText(), "")){
            b.setText(setChar);

            if(game.setPozitie(x,y, setChar)==1){
                new AlertBox("Castigator","A castigat "+setChar);
                refresh_score();
                refresh_table();
            }
            if(game.setPozitie(x,y, setChar)==2){
                new AlertBox("No winner", "There is no winner");
                refresh_table();
            }

            schimba_char();
        }
    }

    private void schimba_char(){
        if(Objects.equals(setChar, "X"))
            setChar = "O";
        else
            setChar="X";
    }

    private void refresh_score(){
        if(setChar.equals("X"))
            score_x++;
        else
            score_o++;
        String scor = "Scor X: "+String.valueOf(score_x);
        ScorX.setText(scor);

        scor = "Scor O: "+ String.valueOf(score_o);
        ScorO.setText(scor);
    }


    private void refresh_table(){
        setChar = "X";
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        game.reload();
    }


    public void click_b1(){
        action(b1,1,1);
    }

    public void click_b2(){
        action(b2,1,2);
    }

    public void click_b3(){
        action(b3,1,3);
    }

    public void click_b4(){
        action(b4,2,1);
    }

    public void click_b5(){
        action(b5,2,2);
    }

    public void click_b6(){
        action(b6,2,3);
    }

    public void click_b7(){
        action(b7,3,1);
    }

    public void click_b8(){
        action(b8,3,2);
    }

    public void click_b9(){
        action(b9,3,3);
    }
}
