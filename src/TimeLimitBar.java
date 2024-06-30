
// テスト用インポート
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TimeLimitBar extends JProgressBar {
    private Timer timer;
    private int timeAllowed = 100;
    private JFrame frame;
    private boolean isTimeLimit;
    private boolean isMyTurn;

    TimeLimitBar() {
        super(0, 100);
        isTimeLimit = false;
        isMyTurn = true;
        // テスト用
        frame = new JFrame("TimeLimitBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        setValue(100);
        setStringPainted(false);
        frame.add(this, BorderLayout.NORTH);

        // 自分のターンかつタイマーが動いていないとき反応する。
        // プログレスバーの開始ボタン。Update関数を動かす
        JButton startButton = new JButton("start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isMyTurn == true) {
                    Update();
                }
            }
        });
        frame.add(startButton, BorderLayout.SOUTH);

        // 置く場所選ぶと制限時間切れ待たずに、相手ターンにする。
        // 自分のターンかつタイマーが動いているときに限り反応する。
        JButton selectButton = new JButton("select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer != null && isMyTurn == true) {
                    reset();
                    // setValue(0);
                    // timer.stop();
                    // timer = null;
                    // timeAllowed = 100;
                    // isTimeLimit = true;
                    // isMyTurn = !isMyTurn;
                }
            }
        });
        frame.add(selectButton, BorderLayout.CENTER);

        // （デバッグ用）isMyTurnを変えるボタン
        JButton turnChangeButton = new JButton("TurnChange");
        turnChangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isMyTurn = !isMyTurn;
            }
        });
        frame.add(turnChangeButton, BorderLayout.EAST);

        // （デバッグ用）isMyTurnの状態確認用
        JButton turnCheckButton = new JButton("TurnCheck");
        turnCheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(isMyTurn);
            }
        });
        frame.add(turnCheckButton, BorderLayout.WEST);
    }

    public boolean checkTimeLimit() {
        return this.isTimeLimit;
    }

    public void Update() {
        if (timer == null) {
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timeAllowed--;
                    setValue(timeAllowed);
                    if (timeAllowed < 0) {
                        reset();
                        // timer.stop();
                        // timer = null;
                        // timeAllowed = 100;
                        // isTimeLimit = true;
                        // isMyTurn = !isMyTurn;
                    }
                }
            });
        }
        timer.start();
    }

    public void reset() {
        timer.stop();
        timer = null;
        timeAllowed = 100;
        isTimeLimit = true;
        isMyTurn = !isMyTurn;
    }

    // テスト
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimeLimitBar TimeLimitBar = new TimeLimitBar();
            }
        });

    }
}