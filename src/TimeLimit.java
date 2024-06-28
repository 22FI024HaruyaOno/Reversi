// テスト用インポート
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TimeLimit extends JProgressBar{
    private Timer timer;
    private int timeAllowed = 100;
    private JFrame frame;

    TimeLimit() {
        super(0,100);
        // テスト用
        frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        setValue(100);
        setStringPainted(false);
        frame.add(this,BorderLayout.NORTH);

        JButton startButton = new JButton("start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        frame.add(startButton, BorderLayout.SOUTH);
    }

    public void Update() {
        if(timer == null) {
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timeAllowed --;
                    setValue(timeAllowed);
                    if(timeAllowed < 0) {
                        timer.stop();
                        timer = null;
                        timeAllowed = 100;
                    }
                }
            });
        }
        timer.start();
    }
    // テスト
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimeLimit timeLimit = new TimeLimit();
            }
        });

    }
}
