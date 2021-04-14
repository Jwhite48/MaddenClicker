package com.mygdx.madden04;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.madden04.Screens.LeaderBoard;
import com.mygdx.madden04.Screens.MainMenu;
import com.mygdx.madden04.Screens.PrestigeScreen;
import com.mygdx.madden04.Screens.SplashScreen;

public class MaddenClicker extends Game {
	public SpriteBatch batch;
	public MainMenu mainMenu;
	public LeaderBoard leaderBoard;
	public PrestigeScreen prestigeScreen;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new SplashScreen(this));

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
