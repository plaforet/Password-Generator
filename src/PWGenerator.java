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
    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    

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
    
  }
}
