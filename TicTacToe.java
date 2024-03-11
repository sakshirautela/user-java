import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    private JButton[][] buttons;
    private boolean xTurn;

    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        xTurn = true;

        ActionListener buttonClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (button.getText().isEmpty()) {
                    if (xTurn) {
                        button.setText("c");
                    } else {
                        button.setText("X");
                    }

                    xTurn = !xTurn;

                    if (checkWin()) {
                        String winner = xTurn ? "X" : "O";
                        JOptionPane.showMessageDialog(TicTacToe.this, "Player " + winner + " wins!");
                        resetGame();
                    } else if (checkDraw()) {
                        JOptionPane.showMessageDialog(TicTacToe.this, "It's a draw!");
                        resetGame();
                    }
                }
            }
        };

        // Initialize buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
                buttons[i][j].addActionListener(buttonClickListener);
                add(buttons[i][j]);
            }
        }

        setSize(300, 300);
        setVisible(true);
    }

    private boolean checkWin() {
        String symbol = xTurn ? "X" : "O";

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(symbol) &&
                    buttons[i][1].getText().equals(symbol) &&
                    buttons[i][2].getText().equals(symbol) ||
                    buttons[0][i].getText().equals(symbol) &&
                    buttons[1][i].getText().equals(symbol) &&
                    buttons[2][i].getText().equals(symbol)) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(symbol) &&
                buttons[1][1].getText().equals(symbol) &&
                buttons[2][2].getText().equals(symbol) ||
                buttons[0][2].getText().equals(symbol) &&
                buttons[1][1].getText().equals(symbol) &&
                buttons[2][0].getText().equals(symbol)) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    private void resetGame() {
        xTurn = true;

        for (JButton[] row : buttons) {
            for (JButton button : row) {
                button.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
