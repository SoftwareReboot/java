import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayListGui {
    private JFrame frame;
    private JTextField songInputField;
    private JList<String> songListDisplay;
    private DefaultListModel<String> songListModel;
    private ArrayList<String> songs;
    private int maxSize;

    public PlayListGui() {
        songs = new ArrayList<>();
        songListModel = new DefaultListModel<>();

        String input = JOptionPane.showInputDialog("Enter the size of the playlist:");
        try {
            maxSize = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid size. Setting default size to 10.");
            maxSize = 10;
        }

        frame = new JFrame("Music Playlist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);

        songInputField = new JTextField("Enter Song Title");
        songInputField.setBackground(Color.BLACK);
        songInputField.setForeground(Color.WHITE);
        frame.add(songInputField, BorderLayout.NORTH);

        songListDisplay = new JList<>(songListModel);
        songListDisplay.setBackground(Color.BLACK);
        songListDisplay.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(songListDisplay);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5));
        buttonPanel.setBackground(Color.BLACK);

        JButton addButton = new JButton("Add Song");
        JButton removeButton = new JButton("Remove Song");
        JButton playButton = new JButton("Play Song");
        JButton clearButton = new JButton("Clear Playlist");

        addButton.setBackground(new Color(0,102,102));
        removeButton.setBackground(new Color(0,102,102));
        playButton.setBackground(new Color(0,102,102));
        clearButton.setBackground(new Color(0,102,102));

        addButton.setForeground(Color.WHITE);
        removeButton.setForeground(Color.WHITE);
        playButton.setForeground(Color.WHITE);
        clearButton.setForeground(Color.WHITE);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(playButton);
        buttonPanel.add(clearButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addSong());
        removeButton.addActionListener(e -> removeSong());
        playButton.addActionListener(e -> playSong());
        clearButton.addActionListener(e -> clearPlaylist());

        frame.setVisible(true);
    }

    private void addSong() {
        String song = songInputField.getText();
        if (songs.size() < maxSize && !song.isEmpty()) {
            songs.add(song);
            songListModel.addElement(song);
            songInputField.setText("");
        } else if (songs.size() >= maxSize) {
            JOptionPane.showMessageDialog(frame, "Playlist is full!");
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter a song title.");
        }
    }

    private void removeSong() {
        String selectedSong = songListDisplay.getSelectedValue();
        if (selectedSong != null) {
            songs.remove(selectedSong);
            songListModel.removeElement(selectedSong);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a song to remove.");
        }
    }

    private void playSong() {
        String selectedSong = songListDisplay.getSelectedValue();
        if (selectedSong != null) {
            new MusicPlayerGui(selectedSong);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a song to play.");
        }
    }

    private void clearPlaylist() {
        songs.clear();
        songListModel.clear();
        JOptionPane.showMessageDialog(frame, "Playlist cleared.");
    }
}
