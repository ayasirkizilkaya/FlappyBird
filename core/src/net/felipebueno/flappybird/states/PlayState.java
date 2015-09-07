package net.felipebueno.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.felipebueno.flappybird.sprites.Bird;

import static net.felipebueno.flappybird.FlappyBird.HEIGHT;
import static net.felipebueno.flappybird.FlappyBird.WIDTH;

public class PlayState extends State {

	private final Bird bird;
	private final Texture bg;
	private final Texture ground;

	public PlayState(GameStateManager manager) {
		super(manager);
		bird = new Bird(50, 100);
		bg = new Texture("bg.png");
		ground = new Texture("ground.png");

		camera.setToOrtho(false, WIDTH / 2, HEIGHT / 2);

	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
			manager.set(new MenuState(manager));

		if (Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.J))
			bird.jump();
	}

	@Override
	public void update(float dt) {
		handleInput();
		bird.update(dt);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
		batch.draw(ground, camera.position.x - (camera.viewportWidth / 2), 0);
		batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
		batch.end();
	}

	@Override
	public void dispose() {
		bg.dispose();
		ground.dispose();
		bird.getTexture().dispose();
	}
}
