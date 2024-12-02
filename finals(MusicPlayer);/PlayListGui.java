import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayListGui {
    private JFrame frame;  // Main window for the playlist GUI
    private JTextField songInputField;  // Input field for song title
    private JList<String> songListDisplay;  // List to display songs
    private DefaultListModel<String> songListModel;  // Model to hold songs for the JList
    private ArrayList<String> songs;  // ArrayList to store song titles
    private int maxSize;  // Maximum number of songs allowed in the playlist

    // Constructor to set up the GUI
    public PlayListGui() {
        songs = new ArrayList<>();  // Initialize the list of songs
        songListModel = new DefaultListModel<>();  // Initialize the model for JList

        // Ask user for maximum size of the playlist
        String input = JOptionPane.showInputDialog("Enter the size of the playlist:");
        try {
            maxSize = Integer.parseInt(input);  // Convert input to an integer
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid size. Setting default size to 10.");
            maxSize = 10;  // Set a default size if input is invalid
        }

        // Create and set up the main frame
        frame = new JFrame("Music Playlist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close application on window close
        frame.setSize(400, 400);  // Set window size
        frame.setLayout(new BorderLayout());  // Set layout to BorderLayout
        frame.getContentPane().setBackground(Color.BLACK);  // Set background color to black

        // Create the song input field
        songInputField = new JTextField("Enter Song Title");
        songInputField.setBackground(Color.BLACK);  // Set background to black
        songInputField.setForeground(Color.WHITE);  // Set text color to white
        frame.add(songInputField, BorderLayout.NORTH);  // Add to the north section of the frame

        // Create and set up the song list display
        songListDisplay = new JList<>(songListModel);  // JList to display songs
        songListDisplay.setBackground(Color.BLACK);  // Set background color to black
        songListDisplay.setForeground(Color.WHITE);  // Set text color to white
        JScrollPane scrollPane = new JScrollPane(songListDisplay);  // Add scrolling functionality
        frame.add(scrollPane, BorderLayout.CENTER);  // Add to the center section of the frame

        // Create the button panel with a grid layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5));  // Set grid layout with 2 rows and 3 columns
        buttonPanel.setBackground(Color.BLACK);  // Set background color to black

        // Create the buttons
        JButton addButton = new JButton("Add Song");
        JButton removeButton = new JButton("Remove Song");
        JButton displayButton = new JButton("Display Songs");
        JButton playButton = new JButton("Play Song");
        JButton clearButton = new JButton("Clear Playlist");
        JButton exitButton = new JButton("Exit");

        // Set the background color of buttons to orange and text color to white
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

        // Add buttons to the button panel
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(playButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);  // Add the button panel to the bottom of the frame

        // Action listeners for the buttons
        addButton.addActionListener(e -> addSong());  // Add song to the playlist
        removeButton.addActionListener(e -> removeSong());  // Remove song from the playlist
        displayButton.addActionListener(e -> displaySongs());  // Display all songs in the playlist
        playButton.addActionListener(e -> playSong());  // Play selected song
        clearButton.addActionListener(e -> clearPlaylist());  // Clear the entire playlist
        exitButton.addActionListener(e -> System.exit(0));  // Exit the application

        frame.setVisible(true);  // Make the frame visible
    }

    // Method to add a song to the playlist
    private void addSong() {
        String song = songInputField.getText();  // Get the song title from the input field
        if (songs.size() < maxSize && !song.isEmpty()) {  // Check if the playlist isn't full and the song isn't empty
            songs.add(song);  // Add song to the list
            songListModel.addElement(song);  // Add song to the JList model
            songInputField.setText("");  // Clear the input field
        } else if (songs.size() >= maxSize) {
            JOptionPane.showMessageDialog(frame, "Playlist is full!");  // Show error if playlist is full
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter a song title.");  // Show error if input is empty
        }
    }

    // Method to remove a song from the playlist
    private void removeSong() {
        String selectedSong = songListDisplay.getSelectedValue();  // Get the selected song from the list
        if (selectedSong != null) {
            songs.remove(selectedSong);  // Remove the selected song from the list
            songListModel.removeElement(selectedSong);  // Remove the song from the JList model
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a song to remove.");  // Show error if no song is selected
        }
    }

    // Method to display all songs in the playlist
    private void displaySongs() {
        if (songs.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "The playlist is empty.");  // Show error if playlist is empty
        } else {
            JOptionPane.showMessageDialog(frame, "Songs in Playlist: \n" + String.join("\n", songs));  // Show all songs
        }
    }

    // Method to play a song from the playlist
    private void playSong() {
        String selectedSong = songListDisplay.getSelectedValue();  // Get the selected song from the list
        if (selectedSong != null) {
            JOptionPane.showMessageDialog(frame, "Now Playing: " + selectedSong);  // Show a message indicating the song is playing
            new MusicPlayerGUI(selectedSong);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a song to play.");  // Show error if no song is selected
        }
    }

    // Method to clear the playlist
    private void clearPlaylist() {
        songs.clear();  // Clear the song list
        songListModel.clear();  // Clear the JList model
        JOptionPane.showMessageDialog(frame, "Playlist cleared.");  // Show confirmation message
    }
}
