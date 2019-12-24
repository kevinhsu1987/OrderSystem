import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderWindow {
    static JFrame frame;
    public OrderWindow() {
        menu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Intent intent = new Intent(this, ComboMeal.class);
                JPanel a2 = new ComboMeal(frame);
                frame.setVisible(false);
                frame.add(a2);
                //frame.setVisible(true);

            }
        });
    }
    

    public static void main(String[] args) {
        frame = new JFrame("OrderWindow");
        frame.setContentPane(new OrderWindow().OrderWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton menu1;
    private JButton menu2;
    private JButton menu3;
    private JButton menu4;
    private JButton menu5;
    private JButton menu10;
    private JButton menu9;
    private JButton menu8;
    private JButton menu7;
    private JButton menu11;
    private JButton menu12;
    private JButton menu13;
    private JButton menu14;
    private JButton comfirm;
    private JButton menu6;
    private JPanel OrderWindow;
    private JButton 早餐店Button;
}
