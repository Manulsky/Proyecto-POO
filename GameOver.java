import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class GameOver extends JFrame implements ActionListener {

	JButton menuVolver;
	JButton salir;

	JFrame fin;
	JLayeredPane flayered;

	public GameOver()
	{

		JFrame fin = new JFrame("GameOver");
		JLayeredPane flayered = new JLayeredPane();
		menuVolver = new JButton();
		salir = new JButton();


		try
		{
			ImageIcon salirImagen = new ImageIcon("./imagenes/btnSalir.png");
			salir.setBounds(800,400,salirImagen.getIconWidth(),salirImagen.getIconHeight());
			salir.setIcon(salirImagen);
			salir.setOpaque(false);
			salir.setContentAreaFilled(false);
			salir.setBorderPainted(false);

			ImageIcon menuImagen = new ImageIcon("./imagenes/btnMenu.png");
			menuVolver.setBounds(800,100,menuImagen.getIconWidth(),menuImagen.getIconHeight());
			menuVolver.setIcon(menuImagen);
			menuVolver.setOpaque(false);
			menuVolver.setContentAreaFilled(false);
			menuVolver.setBorderPainted(false);


			System.out.println("GameOver cargado");

		}
		catch(Exception e)
		{
			System.out.println("Error al cargar la imagen del boton gm");
		}

		JLabel gfondo = new JLabel();
		ImageIcon gimagen = new ImageIcon("./imagenes/GameOver.png");
		gfondo.setIcon(gimagen);
		gfondo.setSize(gimagen.getIconWidth(), gimagen.getIconHeight());


		flayered.add(gfondo, new Integer(1));
		flayered.add(salir, new Integer(2));
		flayered.add(menuVolver, new Integer(3));

		salir.addActionListener(this);
		menuVolver.addActionListener(this);

		fin.getContentPane().add(flayered);
		fin.setSize(gimagen.getIconWidth(), gimagen.getIconHeight());
		fin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		fin.setVisible(true);

		System.out.println("GameOver Cargado");
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == this.menuVolver)
		{
			System.out.println("Volviendo al Menu");
			Menu mnn = new Menu();
		}

		if(event.getSource() == this.salir)
		{
			System.out.println("FIN");
			System.exit(0);

		}
	}
}