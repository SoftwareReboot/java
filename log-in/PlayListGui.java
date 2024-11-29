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

        // Set max size for the playlist
        String input = JOptionPane.showInputDialog("Enter the size of the playlist:");
        try {
            maxSize = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid size. Setting default size to 10.");
            maxSize = 10;
        }

        // Create the main frame
        frame = new JFrame("Music Playlist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);  // Set background color to black

        // Song input field
        songInputField = new JTextField("Enter Song Title");
        songInputField.setBackground(Color.BLACK);  // Set background color to black
        songInputField.setForeground(Color.WHITE);  // Set text color to white
        frame.add(songInputField, BorderLayout.NORTH);

        // Song list display
        songListDisplay = new JList<>(songListModel);
        songListDisplay.setBackground(Color.BLACK);  // Set background color to black
        songListDisplay.setForeground(Color.WHITE);  // Set text color to white
        JScrollPane scrollPane = new JScrollPane(songListDisplay);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel with GridLayout to display all buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5)); // 2 rows, 3 columns, with gaps between buttons
        buttonPanel.setBackground(Color.BLACK); // Set button panel background to black

        JButton addButton = new JButton("Add Song");
        JButton removeButton = new JButton("Remove Song");
        JButton displayButton = new JButton("Display Songs");
        JButton playButton = new JButton("Play Song");
        JButton clearButton = new JButton("Clear Playlist");
        JButton exitButton = new JButton("Exit");

        // Set the buttons' background color to orange and text color to white
        addButton.setBackground(Color.ORANGE);
        removeButton.setBackground(Color.ORANGE);
        displayButton.setBackground(Color.ORANGE);
        playButton.setBackground(Color.ORANGE);
        clearButton.setBackground(Color.ORANGE);
        exitButton.setBackground(Color.ORANGE);

        addButton.setForeground(Color.WHITE);
        removeButton.setForeground(Color.WHITE);
        displayButton.setForeground(Color.WHITE);
        playButton.setForeground(Color.WHITE);
        clearButton.setForeground(Color.WHITE);
        exitButton.setForeground(Color.WHITE);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(playButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button action listeners
        addButton.addActionListener(e -> addSong());
        removeButton.addActionListener(e -> removeSong());
        displayButton.addActionListener(e -> displaySongs());
        playButton.addActionListener(e -> playSong());
        clearButton.addActionListener(e -> clearPlaylist());
        exitButton.addActionListener(e -> System.exit(0));

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

    private void displaySongs() {
        if (songs.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "The playlist is empty.");
        } else {
            JOptionPane.showMessageDialog(frame, "Songs in Playlist: \n" + String.join("\n", songs));
        }
    }

    private void playSong() {
        String selectedSong = songListDisplay.getSelectedValue();
        if (selectedSong != null) {
            JOptionPane.showMessageDialog(frame, "Now Playing: " + selectedSong);
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
