import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import javax.imageio.ImageIO;
import java.awt.event.*;



public class Menu extends JFrame implements ActionListener {

	JButton btnJugar1;
	JButton btnJugar2;
	JButton btnJugar3;

	JFrame v;
	JLayeredPane layered;

	public Menu()
	{

		JFrame v = new JFrame("Hanzo-shots-virus-boy The Game");
		JLayeredPane layered = new JLayeredPane();
		btnJugar1 = new JButton();
		btnJugar2 = new JButton();
		btnJugar3 = new JButton();


		try
		{
			ImageIcon jugarImagen = new ImageIcon("./imagenes/pNivel1.png");
			btnJugar1.setBounds(700,315,jugarImagen.getIconWidth(),jugarImagen.getIconHeight());
			btnJugar1.setIcon(jugarImagen);
			btnJugar1.setOpaque(false);
			btnJugar1.setContentAreaFilled(false);
			btnJugar1.setBorderPainted(false);

			ImageIcon jugarImagen2 = new ImageIcon("./imagenes/pNivel2.png");
			btnJugar2.setBounds(900,305,jugarImagen2.getIconWidth(),jugarImagen2.getIconHeight());
			btnJugar2.setIcon(jugarImagen2);
			btnJugar2.setOpaque(false);
			btnJugar2.setContentAreaFilled(false);
			btnJugar2.setBorderPainted(false);

			ImageIcon jugarImagen3 = new ImageIcon("./imagenes/pNivel3.png");
			btnJugar3.setBounds(1100,295,jugarImagen3.getIconWidth(),jugarImagen3.getIconHeight());
			btnJugar3.setIcon(jugarImagen3);
			btnJugar3.setOpaque(false);
			btnJugar3.setContentAreaFilled(false);
			btnJugar3.setBorderPainted(false);

			System.out.println("Imagenes Cargadas");

		}
		catch(Exception e)
		{
			System.out.println("Error al cargar la imagen del boton");
		}

		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon("./imagenes/fondo.png");
		fondo.setIcon(imagen);
		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

		JLabel title = new JLabel();
		ImageIcon aTitle = new ImageIcon("./imagenes/titulo.png");
		title.setIcon(aTitle);
		title.setSize(aTitle.getIconWidth(), aTitle.getIconHeight());

		layered.add(fondo, new Integer(1));
		layered.add(title, new Integer(2));
		layered.add(btnJugar1, new Integer(3));
		layered.add(btnJugar2, new Integer(4));
		layered.add(btnJugar3, new Integer(5));

		btnJugar1.addActionListener(this);
		btnJugar2.addActionListener(this);
		btnJugar3.addActionListener(this);

		v.getContentPane().add(layered);
		v.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		v.setVisible(true);

		System.out.println("Menu Cargado");
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == this.btnJugar1)
		{
			System.out.println("Nivel 1");

			Juego1 jg = new Juego1();
		}

		if(event.getSource() == this.btnJugar2)
		{
			System.out.println("Nivel 2");

			Juego2 jg2 = new Juego2();
		}

		if(event.getSource() == this.btnJugar3)
		{
			System.out.println("Nivel 3");

			Juego3 jg3 = new Juego3();
		}
	}
}