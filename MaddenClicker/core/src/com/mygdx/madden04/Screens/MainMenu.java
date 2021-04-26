package com.mygdx.madden04.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.madden04.MaddenClicker;

public class MainMenu implements Screen {
    MaddenClicker game;
    Button leaderboardButton, gameButton, prestigeButton;
    Stage stage;


    public MainMenu(MaddenClicker m){
        this.game = m;
        Skin mySkin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
        ScreenViewport viewport = new ScreenViewport();
        stage = new Stage(viewport);;


        //libGDX Stage will be the closest thing to an input processor
        /*
        Buttons will be Actor(s), can pass in Button
        Gdx.input.setInputProcessor
         */
        leaderboardButton = new TextButton("Leaderboard", mySkin, "small");
        leaderboardButton.addListener(new ClickListener()
        {


            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.leaderBoard);
            }
        });

        gameButton = new TextButton("Game", mySkin, "small");
        gameButton.addListener(new ClickListener()
        {


            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.gameScreen);
            }
        });

        prestigeButton = new TextButton("Prestige", mySkin, "small");
        prestigeButton.addListener(new ClickListener()
        {


            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.prestigeScreen);
            }
        });
        //breakpoint
        leaderboardButton.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 8);
        leaderboardButton.setSize(400, 400);
        gameButton.setPosition(Gdx.graphics.getWidth() / 2, 3 * (Gdx.graphics.getHeight() / 8));
        gameButton.setSize(400, 400);
        prestigeButton.setPosition(Gdx.graphics.getWidth() / 2, 5 * (Gdx.graphics.getHeight() / 8));
        prestigeButton.setSize(400, 400);

        stage.addActor(this.leaderboardButton);
        stage.addActor(this.gameButton);
        stage.addActor(this.prestigeButton);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

    }

    //RENDER FUNCTION IS ONLY FOR DRAWING!!@!!!!
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        leaderboardButton.draw(game.batch, 1);
        gameButton.draw(game.batch, 1);
        prestigeButton.draw(game.batch, 1);
        game.batch.end();


    }

    @Override
    public void resize(int width, int height) {

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
