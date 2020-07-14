public class Virus extends Sprite
{
	private final int INICIAL_X = 800;

	public Virus(int x, int y)
	{
		super(x, y);
		initVirus();
	}

	private void initVirus()
	{
		loadImage("./imagenes/virus.png");
		getImageDimensions();
	}

	public void moverse()
	{
		x -= 3;
	}
}