import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.File;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;

public class MusicPlayerGui extends JFrame {
    private AdvancedPlayer player;
    private Thread playThread, progressThread;
    private boolean isPlaying = false;
    private boolean isSeeking = false;
    private int currentSongIndex = 0;
    private ArrayList<String> songList = new ArrayList<>();
    private JSlider progressSlider;
    private int songDurationInSeconds;
    private FileInputStream songStream;

    public MusicPlayerGui(String SongTitle) {
        setTitle("Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon vinylImage = new ImageIcon("C:\\Users\\Joseph\\Desktop\\uwa\\javaCodes\\test\\imports\\src\\vinyl.jpg");

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

        progressSlider = new JSlider(0, 100, 0);
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
                    stopMusic();
                } else {
                    playMusic(songList.get(currentSongIndex), songTitle);
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                currentSongIndex = (currentSongIndex + 1) % songList.size();
                String[] setTitle = songList.get(currentSongIndex).split("\\\\");
                String title = setTitle[setTitle.length - 1];
                songTitle.setText(title.substring(0, title.length() - 4));
                playMusic(songList.get(currentSongIndex), songTitle);
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                currentSongIndex = (currentSongIndex - 1 + songList.size()) % songList.size();
                String[] setTitle = songList.get(currentSongIndex).split("\\\\");
                String title = setTitle[setTitle.length - 1];
                songTitle.setText(title.substring(0, title.length() - 4));
                playMusic(songList.get(currentSongIndex), songTitle);
            }
        });

        progressSlider.addChangeListener(e -> {
            if (progressSlider.getValueIsAdjusting()) {
                isSeeking = true;
            } else if (isSeeking) {
                int seekPosition = progressSlider.getValue();
                int newStartFrame = (int) ((seekPosition / 100.0) * songDurationInSeconds * 38); // MP3 frames per second (approximate)
                stopMusic(); // Stop current playback
                playMusicFromPosition(songList.get(currentSongIndex), newStartFrame); // Resume from new position
                isSeeking = false;
            }
        });

        controlPanel.add(prevButton);
        controlPanel.add(playButton);
        controlPanel.add(nextButton);
        backgroundPanel.add(controlPanel, BorderLayout.SOUTH);

        add(backgroundPanel);
        setVisible(true);
    }

    private void playMusic(String filePath, JLabel songTitle) {
        try {
            songStream = new FileInputStream(filePath);
            Bitstream bitstream = new Bitstream(songStream);
            Header header = bitstream.readFrame();
            songDurationInSeconds = (int) (header.total_ms(new FileInputStream(filePath).available()) / 1000);
            bitstream.closeFrame();

            playThread = new Thread(() -> {
                try {
                    player = new AdvancedPlayer(songStream);
                    progressThread = new Thread(() -> {
                        progressSlider.setValue(0);
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(songDurationInSeconds * 10); // Update every 1%
                            } catch (InterruptedException ex) {
                                return;
                            }
                            progressSlider.setValue(i + 1);
                        }
                    });
                    progressThread.start();
                    player.play();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            playThread.start();
            isPlaying = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playMusicFromPosition(String filePath, int startFrame) {
        playThread = new Thread(() -> {
            try {
                songStream = new FileInputStream(filePath);
                player = new AdvancedPlayer(songStream);
                player.play(startFrame, Integer.MAX_VALUE); // Start from the specified frame
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        playThread.start();
        isPlaying = true;
    }

    private void stopMusic() {
        if (isPlaying) {
            player.close();
            playThread.interrupt();
            progressThread.interrupt();
            isPlaying = false;
        }
    }

    
}
