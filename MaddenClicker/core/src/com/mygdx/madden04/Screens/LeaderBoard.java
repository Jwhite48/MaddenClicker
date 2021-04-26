package com.mygdx.madden04.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.madden04.MaddenClicker;
import com.mygdx.madden04.MyShapeRenderer;

public class LeaderBoard implements Screen {
    MaddenClicker game;

    private Stage stage;
    private Texture leaderboard, metal, backtexture;
    private ImageButton backBtn;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private BitmapFont bitmapFont;
    ShapeRenderer shapeRenderer;
    MyShapeRenderer myShapeRenderer;

    public LeaderBoard(MaddenClicker m) {
        this.game = m;

        stage = new Stage(new ScreenViewport());
        leaderboard = new Texture("leaderboardicon.png");
        metal = new Texture("oneicon.png");
        backtexture = new Texture(Gdx.files.internal("backbtn.png"));
        myTextureRegion = new TextureRegion(backtexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);

        backBtn = new ImageButton(myTexRegionDrawable);
        backBtn.setSize(Gdx.graphics.getWidth()/7, Gdx.graphics.getHeight()/7);
        backBtn.setPosition(0,0);
        backBtn.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.setScreen(game.mainMenu);
                return false;
            }
        });
        stage.addActor(backBtn);

        bitmapFont = new BitmapFont();
        bitmapFont.setColor(Color.WHITE);
        bitmapFont.getData().setScale(5);

        shapeRenderer = new ShapeRenderer();
        myShapeRenderer = new MyShapeRenderer();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(26/255f, 134/255f, 135/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        myShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        myShapeRenderer.setColor(8/255f, 107/255f, 138/255f, 1);
        myShapeRenderer.roundedRect(Gdx.graphics.getWidth()/17, Gdx.graphics.getHeight()/6 + metal.getHeight()/10, metal.getWidth()/2+metal.getWidth()/4, metal.getHeight()/2 + metal.getHeight()/4 , 100);

        myShapeRenderer.setColor(0,0,1,1);
        myShapeRenderer.roundedRect(Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/2+metal.getHeight()/8, metal.getWidth()/2+metal.getWidth()/5, metal.getHeight()/6, 100);
        myShapeRenderer.roundedRect(Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/3+metal.getHeight()/8, metal.getWidth()/2+metal.getWidth()/5, metal.getHeight()/6, 100);
        myShapeRenderer.roundedRect(Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/6 + metal.getHeight()/8, metal.getWidth()/2+metal.getWidth()/5, metal.getHeight()/6, 100);




        myShapeRenderer.setColor(35/255f, 135/255f, 26/255f, 1);
        myShapeRenderer.roundedRect(Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/7,Gdx.graphics.getHeight()/2+metal.getHeight()/6, 250, 100, 50);
        myShapeRenderer.roundedRect(Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/7,Gdx.graphics.getHeight()/3+metal.getHeight()/6, 250, 100, 50);
        myShapeRenderer.roundedRect(Gdx.graphics.getWidth()/2+Gdx.graphics.getWidth()/7,Gdx.graphics.getHeight()/6+metal.getHeight()/6, 250, 100, 50);

        myShapeRenderer.end();


        game.batch.begin();

        stage.act();
        stage.draw();
        game.batch.draw(leaderboard, Gdx.graphics.getWidth()-leaderboard.getHeight()-leaderboard.getHeight()/2,Gdx.graphics.getHeight()-leaderboard.getHeight()-leaderboard.getHeight()/8);
        game.batch.draw(metal, Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/2+metal.getHeight()/10, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/7);
        game.batch.draw(metal, Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/3+metal.getHeight()/10, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/7);
        game.batch.draw(metal, Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/6 + metal.getHeight()/12, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/7);



        //bitmapFont.draw(game.batch, "test", 300, 300);

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
        stage.dispose();
        leaderboard.dispose();
        metal.dispose();
        myShapeRenderer.dispose();
    }

}