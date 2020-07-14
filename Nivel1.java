import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.sound.midi.*;
import java.util.*;
import javax.swing.*;


public class Nivel1 extends JPanel implements ActionListener
{	

	private Timer timer;
	private Jugador jugador;
	private List<Virus> viruses;
	private boolean ingame;

	private final int IPERSONAJE_X = 40;
	private final int IPERSONAJE_Y = 60;
	private final int F_WIDTH = 800;
	private final int F_HEIGHT = 700;
	private final int DELAY = 20;

	private final int [][] pos =
	{
		{1500,500}, {1600,300}, {1700,400}, {1800,200}, {1900,500}, {2000,300}, {2100,400}, {2200,500}, {2300,300}, {2400,500},

	};

	public Nivel1()
	{
		initNivel();
		System.out.println("Control: Nivel1 Cargado");
	}

	private void initNivel()
	{	
		addKeyListener(new TAdapter());
		setFocusable(true);
		
		ingame = true; 

		setPreferredSize(new Dimension(F_WIDTH, F_HEIGHT));

		jugador = new Jugador(IPERSONAJE_X, IPERSONAJE_Y);

		setBackground(Color.BLACK);

		initViruses();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void initViruses()
	{
		viruses = new ArrayList<>();

		for (int[] p : pos)
		{
			viruses.add(new Virus(p[0], p[1]));
		}		
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (ingame)
		{
			drawObjects(g);
		}
		else
		{
			drawGameOver();
		}

		Toolkit.getDefaultToolkit().sync();
	}

	private void drawObjects(Graphics g)
	{
		if(jugador.isVisible())
		{
			g.drawImage(jugador.getImage(), jugador.getX(), jugador.getY(), this);
		}

		List<Flecha> ms = jugador.getFlechas();

		for(Flecha flecha : ms)
		{
			if(flecha.isVisible())
			{
				g.drawImage(flecha.getImage(), flecha.getX(), flecha.getY(), this);
			}
		}

		for(Virus virus : viruses)
		{
			if(virus.isVisible())
			{
				g.drawImage(virus.getImage(), virus.getX(), virus.getY(), this);
			}
		}

		g.setColor(Color.GREEN);
		g.drawString("Enemigos: " + viruses.size(), 5, 15);
	}

	private void drawGameOver()
	{
		System.out.println("Control: Fin del juego");
		try
		{
			GameOver gm = new GameOver();
		}
		catch(Exception e)
		{
			System.out.println("Error en el GameOver");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		inGame();

		actJugador();
		actFlechas();
		actVirus();

		victoria();


		revCollision();

		repaint();
	}

	private void inGame()
	{
		if(!ingame)
		{
			timer.stop();
		}
	}

	private void actJugador()
	{
		if(jugador.isVisible())
		{
			jugador.moverse();
		}
	}

	private void actFlechas()
	{
		List<Flecha> ms = jugador.getFlechas();

		for(int i =0; i < ms.size(); i++)
		{
			Flecha m = ms.get(i);

			if(m.isVisible())
			{
				m.moverse();
			}
			else
			{
				ms.remove(i);
			}
		}
	}


	private void actVirus()
	{
		if(viruses.isEmpty())
		{
			ingame = true;
			return;
		}

		for(int i = 0; i< viruses.size(); i++)
		{
			Virus a = viruses.get(i);

			if(a.isVisible())
			{
				a.moverse();
			}
			else
			{
				viruses.remove(i);
			}

			if(a.getX() == 0)
			{
				a.setVisible(false);
			}
		}
	}

	public void victoria()
	{
		if(viruses .isEmpty())
		{
			YouWin yw = new YouWin();
		}
	}

	public void revCollision()
	{
		Rectangle r3 = jugador.getBounds();

		for(Virus virus : viruses)
		{
			Rectangle r2 = virus.getBounds();

			if(r3.intersects(r2))
			{
				jugador.setVisible(false);
				virus.setVisible(false);
				ingame = false;
			}
		}

		List<Flecha> ms = jugador.getFlechas();

		for(Flecha m : ms)
		{
			Rectangle r1 = m.getBounds();

			for(Virus virus : viruses)
			{
				Rectangle r2 = virus.getBounds();

				if(r1.intersects(r2))
				{
					m.setVisible(false);
					virus.setVisible(false);
				}
			}
		}
	}

	private class TAdapter extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e)
		{
			jugador.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			jugador.keyPressed(e);
		}
	}

}
