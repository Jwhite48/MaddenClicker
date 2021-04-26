package com.mygdx.madden04.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.madden04.MaddenClicker;

public class PrestigeScreen implements Screen {
    MaddenClicker game;
    Stage stage;
    TextButton b1;
    ImageButton b2;
    Skin skin;
    Label outputLabel;

    // (0,0) is bottom-left corner
    public PrestigeScreen(MaddenClicker m){
        this.game = m;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        b1 = new TextButton("Prestige", skin, "default");
        b1.setSize(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/12);
        b1.setPosition(Gdx.graphics.getWidth()/3f,Gdx.graphics.getHeight()/2);
        //b2 = new TextButton("X", skin, "default");
        b2 = new ImageButton(skin);
        b2.setSize(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/18);
        b2.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("x.png"))));
        b2.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("badlogic.jpg"))));
        b2.setPosition(Gdx.graphics.getWidth()/1.2f,Gdx.graphics.getHeight()/1.1f);

        b1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Press a Button");
            }
            /*@Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                if(game.score > 1000){ // choose arbitrary number for now
                    outputLabel.setText("Success");
                    game.score = 0;
                }
                else{
                    outputLabel.setText("Score too low");
                }
            }*/
        });

        b2.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                game.setScreen(game.gameScreen);
                return true;
            }
        });

        stage.addActor(b1);
        stage.addActor(b2);
        outputLabel = new Label("Press the button to prestige", skin, "black");
        outputLabel.setFontScale(2f);
        outputLabel.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/5);
        outputLabel.setAlignment(Align.center);
        stage.addActor(outputLabel);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f,0.5f,0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

        game.batch.begin();

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
