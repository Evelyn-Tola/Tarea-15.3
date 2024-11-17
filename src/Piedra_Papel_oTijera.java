import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Piedra_Papel_oTijera extends JFrame {
    private JLabel resultLabel, playerChoiceLabel, computerChoiceLabel;
    private JButton rockButton, paperButton, scissorsButton;
    private String[] choices = {"Piedra", "Papel", "Tijera"};
    private Random random = new Random();

    public Piedra_Papel_oTijera() {
        // Configuración de la ventana principal
        setTitle("Piedra, Papel o Tijera");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior: Mostrar resultados
        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel("Elige tu movimiento:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultPanel.add(resultLabel);
        add(resultPanel, BorderLayout.NORTH);

        // Panel central: Mostrar las elecciones
        JPanel choicesPanel = new JPanel();
        playerChoiceLabel = new JLabel("Jugador: ");
        computerChoiceLabel = new JLabel("Máquina: ");
        playerChoiceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        computerChoiceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        choicesPanel.setLayout(new GridLayout(2, 1));
        choicesPanel.add(playerChoiceLabel);
        choicesPanel.add(computerChoiceLabel);
        add(choicesPanel, BorderLayout.CENTER);

        // Panel inferior: Botones para elegir
        JPanel buttonPanel = new JPanel();
        rockButton = new JButton("Piedra");
        paperButton = new JButton("Papel");
        scissorsButton = new JButton("Tijera");
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Agregar acciones a los botones
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Piedra");
            }
        });
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Papel");
            }
        });
        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Tijera");
            }
        });
    }

    // Lógica del juego
    private void playGame(String playerChoice) {
        // Elección de la máquina
        String computerChoice = choices[random.nextInt(choices.length)];
        
        // Mostrar elecciones
        playerChoiceLabel.setText("Jugador: " + playerChoice);
        computerChoiceLabel.setText("Máquina: " + computerChoice);

        // Determinar el resultado
        String result;
        if (playerChoice.equals(computerChoice)) {
            result = "¡Empate!";
        } else if ((playerChoice.equals("Piedra") && computerChoice.equals("Tijera")) ||
                   (playerChoice.equals("Papel") && computerChoice.equals("Piedra")) ||
                   (playerChoice.equals("Tijera") && computerChoice.equals("Papel"))) {
            result = "¡Ganaste!";
        } else {
            result = "¡Perdiste!";
        }

        // Mostrar el resultado
        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Piedra_Papel_oTijera game = new Piedra_Papel_oTijera();
            game.setVisible(true);
        });
    }
}

