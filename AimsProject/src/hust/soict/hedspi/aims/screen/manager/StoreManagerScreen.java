package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private JPanel centerPanel;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View Store"));
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        addBook.addActionListener(e -> new AddBookToStoreScreen(store, this));
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store, this));
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store, this));

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        // Create a panel with a 3x3 grid layout and 2px horizontal/vertical gaps
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 2, 2));
        updateCenterPanel();
        return centerPanel;
    }

    public void updateCenterPanel() {
        centerPanel.removeAll(); // clear old content

        ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < 9 && i < mediaInStore.size(); i++) {
            MediaStore mediaCell = new MediaStore(mediaInStore.get(i));
            centerPanel.add(mediaCell);
        }

        centerPanel.revalidate(); // re-layout
        centerPanel.repaint();    // refresh UI
    }

    public static void main(String[] args) {
        Store store = new Store(); // assuming Store has a no-arg constructor
        new StoreManagerScreen(store);
    }
}
