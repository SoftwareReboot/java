import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import java.util.ArrayList;

public class MusicPlayerGui extends JFrame {
    private Player player;
    private Thread playThread;
    private boolean isPlaying = false;
    private int currentSongIndex = 0;
    private ArrayList<String> songList = new ArrayList<>();

    public MusicPlayerGui(String SongTitle) {
        setTitle("Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon vinylImage = new ImageIcon("C:\\Users\\Joseph\\Desktop\\uwa\\codingBit(java)\\test\\imports\\src\\vinyl.jpg");

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
        JButton playButton = new JButton(">||");
        JButton prevButton = new JButton("<<");
        JButton nextButton = new JButton(">>");

        songList.add("C:\\Users\\Joseph\\Downloads\\tuyo.mp3");
        songList.add("C:\\Users\\Joseph\\Downloads\\Lucid Dreams.mp3");
        songList.add("C:\\Users\\Joseph\\Downloads\\ayawtanduga.mp3");
        songList.add("C:\\Users\\Joseph\\Downloads\\How to fly.mp3");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    player.close();
                    playThread.interrupt();
                    isPlaying = false;
                } else {
                    playThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                player = new Player(new FileInputStream(songList.get(currentSongIndex)));
                                player.play();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    playThread.start();
                    isPlaying = true;
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    player.close();
                    playThread.interrupt();
                    isPlaying = false;
                }
                currentSongIndex = (currentSongIndex + 1) % songList.size();
                songTitle.setText(songList.get(currentSongIndex));
                playThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            player = new Player(new FileInputStream(songList.get(currentSongIndex)));
                            player.play();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                playThread.start();
                isPlaying = true;
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    player.close();
                    playThread.interrupt();
                    isPlaying = false;
                }
                currentSongIndex = (currentSongIndex - 1 + songList.size()) % songList.size();
                songTitle.setText(songList.get(currentSongIndex));
                playThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            player = new Player(new FileInputStream(songList.get(currentSongIndex)));
                            player.play();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                playThread.start();
                isPlaying = true;
            }
        });

        controlPanel.add(prevButton);
        controlPanel.add(playButton);
        controlPanel.add(nextButton);
        backgroundPanel.add(controlPanel, BorderLayout.SOUTH);

        add(backgroundPanel);
        setVisible(true);
    }
}
