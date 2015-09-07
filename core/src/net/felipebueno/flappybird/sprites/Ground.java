package net.felipebueno.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Ground {

	private static final float VELOCITY = 5;
	private final Vector3 position;
	private final Vector3 velocity;
	private final Texture ground;
	private float initialX;

	public Ground(float x) {
		this.initialX = x;
		position = new Vector3(x, 0, 0);
		velocity = new Vector3(0, 0, 0);
		ground = new Texture("ground.png");
	}

	public Vector3 getPosition() {
		return position;
	}

	public Texture getTexture() {
		return ground;
	}

	public void update(float dt) {
		velocity.add(VELOCITY, 0, 0);

//		velocity.scl(dt);
//		position.x = position.x - VELOCITY;
//
//		if (position.x + ground.getWidth() < 0)
//			position.x = initialX;

		velocity.scl(1 / dt);
	}


}
