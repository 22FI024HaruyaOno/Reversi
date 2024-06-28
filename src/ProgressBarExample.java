import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarExample extends JFrame {
    private JProgressBar progressBar;
    private Timer timer;
    private int count = 0;

    public ProgressBarExample() {
        super("Progress Bar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        add(progressBar, BorderLayout.NORTH);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer == null) {
                    timer = new Timer(100, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            count++;
                            progressBar.setValue(count);
                            if (count >= 100) {
                                timer.stop();
                                timer = null;
                                count = 0;
                            }
                        }
                    });
                }
                timer.start();
            }
        });
        add(startButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProgressBarExample example = new ProgressBarExample();
                example.setVisible(true);
            }
        });
    }
}

