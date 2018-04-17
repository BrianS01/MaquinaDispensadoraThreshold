package Extras;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Ejemplo extends JFrame
{
	private JPanel contentPane;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Ejemplo()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoComprador = new JLabel("Bienvenido Comprador");
		lblBienvenidoComprador.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 14));
		lblBienvenidoComprador.setBounds(67, 52, 154, 25);
		contentPane.add(lblBienvenidoComprador);
	}
}