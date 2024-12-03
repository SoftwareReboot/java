import javax.swing.*;
import java.awt.*;

public class MPGui extends JFrame {

    public MPGui(String SongTitle) {
        setTitle("Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon vinylImage = new ImageIcon("C:\\Users\\Joseph\\Desktop\\uwa\\codingBit(java)\\finals(MusicPlayer);\\vinyl.jpg");

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(vinylImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        JPanel songPanel = new JPanel(new GridLayout(2, 1));
        JLabel songTitle = new JLabel(SongTitle, SwingConstants.CENTER);
        songTitle.setFont(new Font("Arial", Font.BOLD, 18));
        songTitle.setForeground(Color.WHITE);
        songTitle.setOpaque(false);
        songPanel.add(songTitle);

        JSlider progressSlider = new JSlider(0, 100, 0);
        progressSlider.setOpaque(false);
        songPanel.add(progressSlider);
        songPanel.setOpaque(false);
        backgroundPanel.add(songPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setOpaque(false);
        JButton playButton = new JButton("Play");
        JButton prevButton = new JButton("<<");
        JButton nextButton = new JButton(">>");

        controlPanel.add(prevButton);
        controlPanel.add(playButton);
        controlPanel.add(nextButton);
        backgroundPanel.add(controlPanel, BorderLayout.SOUTH);

        add(backgroundPanel);
        setVisible(true);
    }
}
