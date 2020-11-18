package Player;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Paths;
import java.awt.Toolkit;
import java.awt.Font;
import jaco.mp3.player.MP3Player;
//import jaco.mp3.player.MP3Player;

public class PlayerWindow extends JFrame {

	private JPanel contentPane;
	//Define MP3Player Class form jaco
	MP3Player player;
	//Define File for Song
	File songFile;
	//Define Current Direcotry
	String currentDirectory = "home.user";
	String currentPath;
	//For Images of the Song
	String imagePath;
	//Repeat of and check
	Boolean check = false;
	//Check if Window colapsed
	Boolean windowCollapsed = false;
	//Mouse x,y seeds, (do I need them?)
	int xMouse, yMouse;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerWindow frame = new PlayerWindow();
					
					frame.setTitle("Musokify");
					frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-50), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150)); //get screensize and set it up to it
					frame.setMaximizedBounds(new Rectangle(0,0 , 50, 50)); //create max
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //make it to open in the middle

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlayerWindow.class.getResource("/Images/LogoMakr-2AMGq5.png"))); //logomakr.com/2AMGq5
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLoop = new JLabel("");
		lblLoop.setIcon(new ImageIcon(PlayerWindow.class.getResource("/Images/RepeatIcon.png")));
		panel.add(lblLoop);
		
		JLabel lblPause = new JLabel("");
		lblPause.setIcon(new ImageIcon(PlayerWindow.class.getResource("/Images/StopIcon.png")));
		panel.add(lblPause);
		
		JLabel lblPlay = new JLabel("");
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setIcon(new ImageIcon(PlayerWindow.class.getResource("/Images/PlayIcon.png")));
		panel.add(lblPlay);
		
		JLabel lblOpen = new JLabel("");
		lblOpen.setIcon(new ImageIcon(PlayerWindow.class.getResource("/Images/FolderIcon.png")));
		panel.add(lblOpen);
		
		lblOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lblShuffle = new JLabel("");
		lblShuffle.setIcon(new ImageIcon(PlayerWindow.class.getResource("/Images/ShuffleIcon.png")));
		panel.add(lblShuffle);
		
		lblShuffle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lblSongName = new JLabel("");
		lblSongName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSongName.setForeground(Color.WHITE);
		lblSongName.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblSongName, BorderLayout.NORTH);
		
		
		// get File name
		String filename = songFile.getName();
		//set song name
		lblSongName.setText(filename);
		player = mp3Player();
		//song zu einer Playlist hinzuf�gen
		player.addToPlayList(songFile);
		//get img Path in strings
		currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
		imagePath = "\\images";
		
		
		//ActionListener
		
		lblLoop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		lblPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		lblPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
	}
	
	private MP3Player mp3Player(){
		MP3Player mp3Player = new MP3Player();
		return mp3Player;
	}
}
