import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame{

    JPanel main;
    int screenHeight;
    int screenWidth;

    JPanel topPnl;
    JLabel title;
    ImageIcon image;

    JPanel displayPnl;
    JTextArea txtArea;
    JScrollPane scroller;

    JPanel controlPnl;
    JButton readBtn;
    JButton quitBtn;

    int i = -1;
    int randIndex;
    Random rnd;


    public FortuneTellerFrame(){
        main = new JPanel();
        main.setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(255, 255, 255));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        FortuneTellerLabel();
        main.add(topPnl, BorderLayout.NORTH);

        FortuneDisplay();
        main.add(displayPnl, BorderLayout.CENTER);

        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void FortuneTellerLabel() {
        topPnl = new JPanel();
        topPnl.setBackground(new Color(255, 255, 255));

        ImageIcon icon = new ImageIcon("src/fortune-teller.png");
        Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        title = new JLabel("FORTUNE TELLER", scaledIcon, JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.ITALIC, 48));
        title.setForeground(new Color(50, 107, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);

        topPnl.add(title);
    }


    private void FortuneDisplay(){
        displayPnl = new JPanel();
        displayPnl.setBackground(new Color(255, 255, 255));
        txtArea = new JTextArea(20, 60);
        txtArea.setFont(new Font("SansSerif", Font.ITALIC, 12));
        scroller = new JScrollPane(txtArea);
        displayPnl.add(scroller);
    }

    private void ControlPanel(){
        controlPnl = new JPanel();
        controlPnl.setBackground(new Color(255, 255, 255));
        controlPnl.setLayout(new GridLayout(1, 2));

        ArrayList<String> fortuneList = new ArrayList<>();
        fortuneList.add("A thrilling time is in your near future.");
        fortuneList.add("Something you lost will turn up soon.");
        fortuneList.add("Your heart is in a place to draw true happiness.");
        fortuneList.add("You will live in interesting times.");
        fortuneList.add("Don't go to the Waffle House tomorrow. It will be better that way.");
        fortuneList.add("You will be betrayed by one of your friends.");
        fortuneList.add("You will soon step on a Lego");
        fortuneList.add("Don't drink the milk in the back of your fridge, it is expired.");
        fortuneList.add("I see nothing in your future... that is... concerning.");
        fortuneList.add("You will enjoy a good quality steak soon.");
        fortuneList.add("I see a lot of sleepless nights ahead.");
        fortuneList.add("You don't want to know....");

        readBtn = new JButton("Read my Fortune!");
        readBtn.addActionListener((ActionEvent ae) ->{
            rnd = new Random();
            do{
                randIndex = rnd.nextInt(11);
            }while(randIndex == i);
            String fortune = fortuneList.get(randIndex);
            i = randIndex;
            txtArea.append("Your fortune: " + fortune + "\n");
        });
        readBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        controlPnl.add(readBtn);
        controlPnl.add(quitBtn);
    }
}