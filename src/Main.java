import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        int rowCount = 21;
        int columnCount = 19;
        int titleSize = 32;
        int boardWidth = columnCount * titleSize;
        int boardHeight = rowCount * titleSize;

        JFrame frame = new JFrame("PacMan");
//       frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(boardWidth, boardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PacMan pacnamGame = new PacMan(rowCount, columnCount, titleSize, boardWidth, boardHeight);
        frame.add(pacnamGame);
        frame.pack();
        pacnamGame.requestFocus();
        frame.setVisible(true);
    }
}