import javax.swing.*;
import java.awt.*;

public class MusicPlayerGUI extends JFrame {

    public MusicPlayerGUI(String SongTitle) {
        // Set frame properties
        setTitle("Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

       

        //load the vinyl record image
         ImageIcon vinylImage = new ImageIcon("C:\\\\Users\\\\Joseph\\\\Desktop\\\\uwa\\\\codingBit(java)\\\\log-in\\\\vinyl.jpg");
         Image scaledImage = vinylImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
         JLabel recordLabel = new JLabel(new ImageIcon(scaledImage));

         JPanel recordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         recordPanel.add(recordLabel);
         add(recordPanel, BorderLayout.WEST);

        // Song information panel
        JPanel songPanel = new JPanel(new GridLayout(2, 1));
        JLabel songTitle = new JLabel(SongTitle, SwingConstants.CENTER);
        songTitle.setFont(new Font("Arial", Font.BOLD, 18));
        songPanel.add(songTitle);

        // Slider for progress
        JSlider progressSlider = new JSlider(0, 100, 0);
        songPanel.add(progressSlider);
        add(songPanel, BorderLayout.CENTER);

        // Control panel with buttons
        JPanel controlPanel = new JPanel();
        JButton playButton = new JButton("Play");
        JButton prevButton = new JButton("<<");
        JButton nextButton = new JButton(">>");

        controlPanel.add(prevButton);
        controlPanel.add(playButton);
        controlPanel.add(nextButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Make frame visible
        setVisible(true);
    }

    
}
