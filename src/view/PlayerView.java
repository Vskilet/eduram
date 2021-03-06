package view;

import controller.PlayerSelectControler;
import javafx.event.EventHandler;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Game;
import model.Player;

/**
 * Created by victor on 06/01/16.
 */
public class PlayerView {
    protected ImageView imagePlayer;
    protected Player player;
    protected Game game;

    public PlayerView(int i, Game g, Player crtPlayer){
        player = crtPlayer;
        this.game = g;
        imagePlayer = new ImageView(new Image("file:img/gamePlayer.png"));
        imagePlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PlayerSelectControler.selectPlayer(game, player);
            }
        });
        imagePlayer.setFitWidth(30);
        imagePlayer.setFitHeight(40);

        imagePlayer.setX(crtPlayer.getPositionRoom().getPositionX()+i*20);
        imagePlayer.setY(crtPlayer.getPositionRoom().getPositionY()+10);
    }
    public void setSelectPlayer(){
        imagePlayer.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.WHITE.deriveColor(0, 0, 0, 0.75), 25, 0, 10, 10));
    }
    public void unselectedPlayer(){
        imagePlayer.setEffect(new GaussianBlur(15));
    }
    public ImageView getImagePlayer(){
        return imagePlayer;
    }
}
