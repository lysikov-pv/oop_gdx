package com.mygdx.oop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.oop.creatures.Creature;

import java.util.ArrayList;
import java.util.Random;

public class View extends ApplicationAdapter {
	SpriteBatch batch;
	Texture bg, archer, mage, monk, peasant, pikeman, rouge, sharpshooter;
	Music music;
	Model model;
	
	@Override
	public void create () {
		model = new Model();

		batch = new SpriteBatch();
		bg = new Texture("bg/bg" + new Random().nextInt(5) + ".png");
		archer = new Texture("creatures/archer.png");
		mage = new Texture("creatures/mage.png");
		monk = new Texture("creatures/monk.png");
		peasant = new Texture("creatures/peasant.png");
		pikeman = new Texture("creatures/pikeman.png");
		rouge = new Texture("creatures/rouge.png");
		sharpshooter = new Texture("creatures/sharpshooter.png");

		music = Gdx.audio.newMusic(Gdx.files.internal("music/theme" + new Random().nextInt(4) + ".mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);
		music.play();
	}
	public void drawCreatures () {
		ArrayList<Creature> creaturesVisibility = new ArrayList<>();
		creaturesVisibility.addAll(Model.allCreatures);
		creaturesVisibility.sort((o1, o2) -> o2.getPosition().y - o1.getPosition().y);
		for(Creature creature: creaturesVisibility) {
			if (creature.getHp() <= 0) continue;
			int direct = 1;
			direct = Model.army1.contains(creature)? 1: -1;
			Texture creaturePic = switch (creature.getName()) {
				case "Арбалетчик" -> archer;
				case "Маг" -> mage;
				case "Монах" -> monk;
				case "Крестьянин" -> peasant;
				case "Копейщик" -> pikeman;
				case "Снайпер" -> sharpshooter;
				case "Разбойник" -> rouge;
				default -> peasant;
			};
			int dx = Gdx.graphics.getWidth() / 10;
			int dy = (int) (Gdx.graphics.getHeight() * 0.8 / 8);
			int creatureBiasX = creaturePic.getWidth() / 2;
			int creatureBiasY = creaturePic.getHeight() / 2;
			batch.draw(creaturePic,
					(creature.getPosition().x * dx - creatureBiasX),
					creature.getPosition().y * dy - creatureBiasY,
					creaturePic.getWidth() * direct,
					creaturePic.getHeight());
		}
	}
	@Override
	public void render () {
		if (Gdx.input.justTouched())
			if(model.step()) music.stop();
//		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		drawCreatures();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bg.dispose();
		music.dispose();
		archer.dispose();
		mage.dispose();
		monk.dispose();
		peasant.dispose();
		pikeman.dispose();
		rouge.dispose();
		sharpshooter.dispose();
	}
}
