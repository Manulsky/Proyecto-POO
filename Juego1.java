import javax.sound.midi.*;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import javax.imageio.ImageIO;
import java.awt.event.*;


public class Juego1 extends JFrame
{
	public Juego1()
	{
		initUI();
	}

	private void initUI()
	{

		add(new Nivel1());
        
        setResizable(false);
        setVisible(true);
        pack();
        
        setTitle("Nivel 1");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}