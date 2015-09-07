package net.felipebueno.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.felipebueno.flappybird.sprites.Bird;

import static net.felipebueno.flappybird.FlappyBird.HEIGHT;
import static net.felipebueno.flappybird.FlappyBird.WIDTH;

public class PlayState extends State {

	private final Bird bird;

	public PlayState(GameStateManager manager) {
		super(manager);
		bird = new Bird(50, 100);

		camera.setToOrtho(false, WIDTH / 2, HEIGHT / 2);

	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
			manager.set(new MenuState(manager));
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
		batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
		batch.end();
	}

	@Override
	public void dispose() {
		bird.getTexture().dispose();
	}
}
