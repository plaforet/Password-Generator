import components.Password;

public class PWGenerator extends JPanel
		implements ActionListener, WindowListener, ChangeListener {

  	static final int PW_MIN = 4;
	static final int PW_MAX = 32;
	static final int PW_INIT = 8;
	private int pwLen = PW_INIT;
	static Password p = new Password(PW_INIT);
	private JTextField passwordField;
	private JLabel sliderLabel;
	private JSlider passwordLength;
	private JButton generateButton;
  
	public PWGenerator(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		// Create slider label
		sliderLabel = new JLabel("Password Length", JLabel.CENTER);
		sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Create slider
		passwordLength = new JSlider(JSlider.HORIZONTAL, PW_MIN, PW_MAX,
				PW_INIT);

		passwordLength.addChangeListener(this);

		// Tick Marks & Labels
		passwordLength.setMajorTickSpacing(4);
		passwordLength.setMinorTickSpacing(1);
		passwordLength.setPaintTicks(true);
		passwordLength.setPaintLabels(true);
		passwordLength
				.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font1 = new Font("Serif", Font.ITALIC, 15);
		passwordLength.setFont(font1);

		// Create button to generate new Password
		generateButton = new JButton("Generate");
		generateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		generateButton.setActionCommand("generate");
		generateButton.addActionListener(this);

		// Create label that displays generated password
		passwordField = new JTextField(32);
		passwordField.setEditable(false);
		passwordField.setHorizontalAlignment(JTextField.CENTER);
		Font font2 = new Font("Serif", Font.BOLD, 24);
		passwordField.setFont(font2);
		passwordField.setText(p.getPassword());

		// Put everything together
		add(sliderLabel);
		add(passwordLength);
		add(generateButton);
		add(passwordField);
	  }
  
	/** Add a listener for window events. */
	void addWindowListener(Window w) {
		w.addWindowListener(this);
	}

	// React to window events.
	public void windowIconified(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			pwLen = (int) source.getValue();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("generate")) {
			p.setPassword(pwLen);
			passwordField.setText(p.getPassword());
		}
	}

	private static void createAndShowGUI() {
		// Create window
		JFrame frame = new JFrame("Password Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PWGenerator animator = new PWGenerator();

		// Add content to the window
		frame.add(animator, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
