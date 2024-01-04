import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Typing Tutor");
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem selectPangramItem = new JMenuItem("Select Pangram");
        menu.add(selectPangramItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        String[] pangrams = {
                "El viejo Señor Gómez pedía queso, kiwi y habas, pero le ha tocado un saxofón.",
                "La cigüeña tocaba cada vez mejor el saxofón y el búho pedía kiwi y queso",
                "Borja quiso el extraño menú de gazpacho, kiwi, uva y flan",
                "Fidel exporta gazpacho, jamón, kiwi, viñas y buques"
        };

        JPanel keyboardPanel = new JPanel(new GridLayout(3, 10));
        JButton[] keys = new JButton[30];
        for (int i = 0; i < 30; i++) {
            keys[i] = new JButton(String.valueOf((char)('A' + i)));
            keyboardPanel.add(keys[i]);
            int finalI = i;
            keys[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(String.valueOf((char) ('A' + finalI)));
                }
            });
        }

        selectPangramItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPangram = pangrams[(int) (Math.random() * pangrams.length)];
                JOptionPane.showMessageDialog(frame, selectedPangram);
            }
        });

        frame.add(new JScrollPane(textArea), BorderLayout.NORTH);
        frame.add(keyboardPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
