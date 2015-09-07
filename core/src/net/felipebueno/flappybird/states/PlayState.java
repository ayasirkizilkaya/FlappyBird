package net.felipebueno.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.felipebueno.flappybird.sprites.Bird;
import net.felipebueno.flappybird.sprites.Ground;
import net.felipebueno.flappybird.sprites.Tube;

import static net.felipebueno.flappybird.FlappyBird.HEIGHT;
import static net.felipebueno.flappybird.FlappyBird.WIDTH;

public class PlayState extends State {

	private final Bird bird;
	private final Texture bg;
	private final Ground ground;
	private final Tube tube;

	public PlayState(GameStateManager manager) {
		super(manager);
		bird = new Bird(50, 100);
		bg = new Texture("bg.png");

		tube = new Tube(100);

		camera.setToOrtho(false, WIDTH / 2, HEIGHT / 2);

		ground = new Ground(camera.position.x - (camera.viewportWidth / 2));

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
		ground.update(dt);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
		batch.draw(ground.getTexture(), ground.getPosition().x, 0);
		batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);

		batch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
		batch.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
		batch.end();
	}

	@Override
	public void dispose() {
		bg.dispose();
		ground.getTexture().dispose();
		bird.getTexture().dispose();
	}
}
