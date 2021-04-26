package com.mygdx.madden04.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.madden04.MaddenClicker;

public class GameScreen implements Screen {

    private final String SCOREBOARD = "MADDENS: ";

    Preferences prefs;
    long score;

    FreeTypeFontGenerator fontGenerator;
    FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
    BitmapFont font;

    int screen_width, screen_height;

    Texture maddenNeutralFace, maddenSmileFace;
    int maddenX, maddenY;
    boolean maddenTouch;

    Texture plusOne, additional, moreMaddens;

    Texture background;

    MaddenClicker game;

    public GameScreen(MaddenClicker m){
        this.game = m;

        prefs = Gdx.app.getPreferences("game preferences");
        score = prefs.getLong("score");

        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 80; fontParameter.color = Color.WHITE;
        font = fontGenerator.generateFont(fontParameter);

        maddenNeutralFace = new Texture("maddenNeutral.png");
        maddenSmileFace = new Texture("maddenSmile.png");
        maddenX = (Gdx.graphics.getWidth()/2)-(maddenNeutralFace.getWidth()/2); maddenY = (Gdx.graphics.getHeight()/2)-(maddenNeutralFace.getHeight()/2);
        maddenTouch = false;

        plusOne = new Texture("plusOneClick.png");
        additional = new Texture("additionalClicker.png");
        moreMaddens = new Texture("maddenNeutralDup.png");

        background = new Texture("background.jpg");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(background, 0, 0, screen_width, screen_height);

        font.draw(game.batch, SCOREBOARD + score, 10, screen_height-10);

        game.batch.draw(plusOne, 0, 0);
        game.batch.draw(additional, plusOne.getWidth(), 0);
        game.batch.draw(moreMaddens, plusOne.getWidth()+additional.getWidth(), 0);

        if(Gdx.input.justTouched()){
            int x = Gdx.input.getX();
            int y = screen_height-Gdx.input.getY();

            if(x>maddenX && x<maddenX+maddenNeutralFace.getWidth()
                    && y>maddenY && y<maddenY+maddenNeutralFace.getHeight())   {
                maddenTouch = !maddenTouch;

                prefs.putLong("score", ++score);
                prefs.flush();
            }else if(x>0 && x<plusOne.getWidth()
                        && y>0 && y<plusOne.getHeight()){
                score -=15;

                prefs.putLong("score", score);
                prefs.flush();
            }else if(x>plusOne.getWidth() && x<plusOne.getWidth()+additional.getWidth()
                        && y>0 && y<additional.getHeight()){
                score -=30;

                prefs.putLong("score", score);
                prefs.flush();
            }else if(x>plusOne.getWidth()+additional.getWidth() &&
                        x<plusOne.getWidth()+additional.getWidth()+moreMaddens.getWidth()
                            && y>0 && y<moreMaddens.getHeight()){
                score -=50;

                prefs.putLong("score", score);
                prefs.flush();
            }
        }

        if(maddenTouch){
            game.batch.draw(maddenSmileFace, maddenX, maddenY);
        }else{
            game.batch.draw(maddenNeutralFace, maddenX, maddenY);
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        screen_width = width;
        screen_height = height;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
