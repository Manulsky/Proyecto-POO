import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Jugador extends Sprite
{
	private int dx;
	private int dy;
	private List<Flecha> flechas;

	public Jugador(int x, int y)
	{
		super(x, y);
		initPersonaje();
	}

	private void initPersonaje()
	{
		flechas = new ArrayList<>();
		loadImage("./imagenes/hanzo.png");
		getImageDimensions();
	}

	public void moverse()
	{
		y += dy;
		x += dx;

		if(x < 1)
		{
			x = 1;
		}

		if(y < 1)
		{
			y = 1;
		}
	}

	public List<Flecha> getFlechas()
	{
		return flechas;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_SPACE)
		{
			disparar();
		}

		if(key == KeyEvent.VK_LEFT)
		{
			dx = -3;
		}

		if(key == KeyEvent.VK_RIGHT)
		{
			dx = 3;
		}

		if(key == KeyEvent.VK_UP)
		{
			dy = -3;
		}

		if(key == KeyEvent.VK_DOWN)
		{
			dy = 3;
		}
	}

	public void disparar()
	{
		flechas.add(new Flecha(x + width, y + height /2));
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_LEFT) 
		{
            dx = 0;
        }

        if(key == KeyEvent.VK_RIGHT) 
        {
            dx = 0;
        }

        if(key == KeyEvent.VK_UP) 
        {
            dy = 0;
        }

        if(key == KeyEvent.VK_DOWN) 
        {
            dy = 0;
        }
	}
}