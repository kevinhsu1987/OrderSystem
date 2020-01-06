import javax.swing.*;
import java.awt.*;

public class ComboMeal extends JPanel {

    JTextField text;

    JFrame frame = null;
    public ComboMeal(){
        this.frame=frame;
    }

    public ComboMeal(JPanel comboMeal) {
        init();
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    private void init() {
        JDBCmysql menu = new JDBCmysql();
        menu.SelectTable();

        /*setLayout(new FlowLayout()); // 設定佈局

       JLabel n1 = new JLabel("起司豬排潛艇堡");
        text = new JTextField(10);
        text.setBounds(20,20,100,40);
        add(n1);
        add(text);*/
        setLayout(null);
        JLabel m1=new JLabel("起司豬排潛艇堡");
        text = new JTextField(10);
        m1.setBounds(20,20,100,40);
        text.setBounds(150,20,50,20);
        add(m1);
        add(text);
        JLabel m2=new JLabel("辣味雞腿美式堡");
        m2.setBounds(20,40,100,40);
        add(m2);
        JLabel m3=new JLabel("匈牙利辣雞美式堡");
        m3.setBounds(20,60,100,40);
        add(m3);
        JLabel m4=new JLabel("藍莓乳酪紐約貝果");
        m4.setBounds(20,80,100,40);
        add(m4);
        JLabel m5=new JLabel("快樂兒童餐");
        m5.setBounds(20,100,100,40);
        add(m5);
    }
    }
