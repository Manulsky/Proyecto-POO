public class Flecha extends Sprite
{
	private final int FRAME_WIDTH = 600;
	private final int VELOCIDAD_FLECHA= 3;

	public Flecha(int x, int y)
	{
		super(x, y);
		initFlecha();
	}

	private void initFlecha()
	{
		loadImage("./imagenes/arrow.png");
		getImageDimensions();
	}

	public void moverse()
	{
		x += VELOCIDAD_FLECHA;

		if(x > FRAME_WIDTH)
		
			visible = false;
		
	}
}