package viscosityDragReduction;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ViscosityDragReduction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static Scanner input;
	private static JTextArea txtLogsrLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViscosityDragReduction frame = new ViscosityDragReduction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViscosityDragReduction() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1319, 760);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("File");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Data has been saved!!!");
			}
		});
		mntmNewMenuItem_1.setOpaque(true);
		mntmNewMenuItem_1.setBackground(Color.YELLOW);
		menuBar.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Information");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"What we need to do:\n\n" + "We need to measure the probability of the null Hypothesis. P\n"
								+ "The P value; is the probability that the true means of two probability\n"
								+ "distributions are the same.  For us, the first probability distribution\n"
								+ "might be viscosity, and the second distribution might be drag reduction.\n"
								+ "However, of course the mean value of the viscosity can't equal the mean\n"
								+ "value of the drag reduction.   Perhaps we need to normalize the viscosity\n"
								+ "values and drag reduction values first, and then calculate the P value.\n"
								+ "I will look for a paper that tells us the best approach",
						"Information", 1);
			}
		});
		mntmNewMenuItem_2.setOpaque(true);
		mntmNewMenuItem_2.setBackground(Color.CYAN);
		menuBar.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Help");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"This will help in creating an idea of DragReduction VS Viscosity\n\n"
								+ "Efficient operation of aircraft or hydrodynamic vehicles requires that the drag \n"
								+ "forces generated during their motion be as small as possible. Practical means of achieving significant drag \n"
								+ "reductions have long occupied vehicle designers, for such reductions translate directly into increased range, \n"
								+ "speed, and maneuverability, or to decreased fuel consumption. Of the various types of drag forces which arise, \n"
								+ "viscous, or skin friction, drag is one of the most important. For example, it can comprise up to 50% of the \n"
								+ "total drag on an aircraft in the cruise condition. Reduction of viscous drag has therefore been the object of \n"
								+ "many recent studies. In this volume, current work on drag reduction in viscous flows is presented and related \n"
								+ "progress is assessed. The papers are not reviews of particular areas of drag reduction per se, but represent \n"
								+ "summary reports of current research in promising approaches, of continuing fundamental studies of turbulent flows, \n"
								+ "and of attempts towards practical implementation of laboratory proven ideas. They were presented at the Symposium \n"
								+ "on Viscous Drag Reduction held in Dallas, Texas, on November 5-6, 1979. The papers are grouped into six specific \n"
								+ "areas, although there is some overlap among areas for several of the papers. The topics covered are laminar \n"
								+ "boundary layers, turbulent flows, nonplanar geometries, blowing and suction, polymer additives, and compliant \n"
								+ "surfaces. A brief overview of each area is provided by a recognized authority to highlight both relevant prior \n"
								+ " work and the importance of the paper to the drag reduction field.");
			}
		});
		mntmNewMenuItem.setBackground(Color.GREEN);
		mntmNewMenuItem.setOpaque(true);
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Drag Reduction:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));

		JLabel lblNewLabel_1 = new JLabel("Viscosity");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("2000 rpm");

		rdbtnNewRadioButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		buttonGroup.add(rdbtnNewRadioButton);

		JRadioButton rdbtnRpm = new JRadioButton("2300 rpm");
		rdbtnRpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					input = new Scanner(new File("src/files/download.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				StringBuilder text = new StringBuilder("");

				while (input.hasNext()) {
					text.append(input.nextLine() + "\n");
				}

				txtLogsrLog.setText(text + "");
			}
		});
		rdbtnRpm.setFont(new Font("SansSerif", Font.BOLD, 15));
		buttonGroup.add(rdbtnRpm);

		JRadioButton rdbtnRpm_1 = new JRadioButton("2500 rpm");
		rdbtnRpm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					input = new Scanner(new File("src/files/DATA2500RPM.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				StringBuilder text = new StringBuilder("");

				while (input.hasNext()) {
					text.append(input.nextLine() + "\n");
				}

				txtLogsrLog.setText(text + "");
			}
		});
		rdbtnRpm_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		buttonGroup.add(rdbtnRpm_1);

		txtLogsrLog = new JTextArea();
		txtLogsrLog.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtLogsrLog.setText("");

		input = new Scanner(new File("src/files/DATA2000RPM.txt"));
		StringBuilder text = new StringBuilder("");

		while (input.hasNext()) {
			text.append(input.nextLine() + "\n");
		}

		txtLogsrLog.setText(text + "");

		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					input = new Scanner(new File("src/files/DATA2000RPM.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				StringBuilder text = new StringBuilder("");

				while (input.hasNext()) {
					text.append(input.nextLine() + "\n");
				}

				txtLogsrLog.setText(text + "");

			}
		});

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.BLACK);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		try {
			input = new Scanner(new File("src/files/LogSR.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		text = new StringBuilder("");

		while (input.hasNext()) {
			text.append(input.nextLine() + "\n");
		}

		textArea.setText(text + "");

		textArea.setFont(new Font("SansSerif", Font.BOLD, 13));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addGap(20)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 99,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdbtnRpm)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnRpm_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGap(28))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(txtLogsrLog, GroupLayout.PREFERRED_SIZE, 583,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(220).addComponent(lblNewLabel_1,
										GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(26).addComponent(textArea,
										GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)))
						.addGap(34)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(
						gl_contentPane
								.createSequentialGroup().addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
												.createSequentialGroup().addGap(8)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_1)
														.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE,
																29, GroupLayout.PREFERRED_SIZE)
														.addComponent(rdbtnRpm).addComponent(rdbtnRpm_1,
																GroupLayout.PREFERRED_SIZE, 29,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 628,
																Short.MAX_VALUE)
														.addComponent(txtLogsrLog, GroupLayout.DEFAULT_SIZE, 628,
																Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(12).addComponent(
												btnNewButton, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)))
								.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
