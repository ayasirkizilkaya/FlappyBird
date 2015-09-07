package net.felipebueno.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static net.felipebueno.flappybird.FlappyBird.HEIGHT;
import static net.felipebueno.flappybird.FlappyBird.WIDTH;

public class MenuState extends State {

	private final String TAG = getClass().getSimpleName();
	private final Texture bg;
	private final Texture playbtn;

	public MenuState(GameStateManager manager) {
		super(manager);
		bg = new Texture("bg.png");
		playbtn = new Texture("playbtn.png");
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.J))
			Gdx.app.log(TAG, "handleInput()->J");
	}

	@Override
	public void update(float dt) {
		handleInput();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(bg, 0, 0, WIDTH, HEIGHT);
		batch.draw(playbtn, (Gdx.graphics.getWidth() / 2) - (playbtn.getWidth() / 2), (Gdx.graphics.getHeight() / 2) - (playbtn.getHeight() / 2));
		batch.end();
	}

}
