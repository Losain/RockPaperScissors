package rockPaperScissor;

/*
 * Nathan Clawson
 * Assignment Rock Paper Scissors
 * CSIS 1410 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class RpsGui extends JFrame
{
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					RpsGui frame = new RpsGui();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RpsGui()
	{
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RpsGui.class.getResource("/rockPaperScissor/images/scissors.png")));
		setTitle("Rock Paper Scissors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = createPanel();
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		JLabel lblChooseYourWeapon = new JLabel("Choose Your Weapon");
		panel.add(lblChooseYourWeapon);
		
		JButton btnRock = createBtnRock();
		panel.add(btnRock);
		
		JButton btnPaper = createBtnPaper();
		panel.add(btnPaper);
		
		JButton btnScissors = createBtnScissors();
		panel.add(btnScissors);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblTxtfield = new JLabel("Who will win . . . ?");
		panel_1.add(lblTxtfield);
		
		JPanel panel_2 = createPanel2();
		panel_2.setLayout(new GridLayout(2, 1, 10, 10));
		
		JLabel lblYourOpponentChooses = createLblOpponentChooses();
		panel_2.add(lblYourOpponentChooses);
		
		JLabel lblOpponentImage = createLblOpponentImage();
		panel_2.add(lblOpponentImage);
		
		createActionListeners(btnRock, btnPaper, btnScissors, lblTxtfield, lblOpponentImage);
	}

	private void createActionListeners(JButton btnRock, JButton btnPaper, JButton btnScissors, JLabel lblTxtfield,
			JLabel lblOpponentImage)
	{
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RPS player2 = RPS.values()[new Random().nextInt(RPS.values().length)];
				
				RPS.evaluate(RPS.ROCK, player2);
				lblTxtfield.setText(RPS.evaluate(RPS.ROCK, player2));
				lblOpponentImage.setIcon(player2.image);
			}
		});
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RPS player2 = RPS.values()[new Random().nextInt(RPS.values().length)];
				
				RPS.evaluate(RPS.PAPER, player2);
				lblTxtfield.setText(RPS.evaluate(RPS.PAPER, player2));
				lblOpponentImage.setIcon(player2.image);
			}
		});
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RPS player2 = RPS.values()[new Random().nextInt(RPS.values().length)];
				
				RPS.evaluate(RPS.SCISSORS, player2);
				lblTxtfield.setText(RPS.evaluate(RPS.SCISSORS, player2));
				lblOpponentImage.setIcon(player2.image);
			}
		});
	}

	private JLabel createLblOpponentImage()
	{
		JLabel lblOpponentImage = new JLabel("\r\n");
		lblOpponentImage.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOpponentImage.setHorizontalAlignment(SwingConstants.CENTER);
		return lblOpponentImage;
	}

	private JLabel createLblOpponentChooses()
	{
		JLabel lblYourOpponentChooses = new JLabel("Your Opponent Chooses . . . ");
		lblYourOpponentChooses.setVerticalTextPosition(SwingConstants.TOP);
		lblYourOpponentChooses.setHorizontalTextPosition(SwingConstants.CENTER);
		lblYourOpponentChooses.setHorizontalAlignment(SwingConstants.CENTER);
		return lblYourOpponentChooses;
	}

	private JPanel createPanel2()
	{
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		return panel_2;
	}

	private JButton createBtnScissors()
	{
		JButton btnScissors = new JButton("");
		btnScissors.setIcon(new ImageIcon(RpsGui.class.getResource("/rockPaperScissor/images/scissors.png")));
		return btnScissors;
	}

	private JButton createBtnPaper()
	{
		JButton btnPaper = new JButton("\r\n");
		btnPaper.setIcon(new ImageIcon(RpsGui.class.getResource("/rockPaperScissor/images/paper.png")));
		return btnPaper;
	}

	private JButton createBtnRock()
	{
		JButton btnRock = new JButton("");
		btnRock.setIcon(new ImageIcon(RpsGui.class.getResource("/rockPaperScissor/images/rock.png")));
		return btnRock;
	}

	private JPanel createPanel()
	{
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		return panel;
	}

}
