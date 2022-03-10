import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Созадем класс
public class MyFrame extends Frame {
    private Button calc;//Кнопка для нажатые
    private Button clear;//Кнопка очистит
    private Label status;
    public MyFrame(String title)
    {
        super(title);
        try
        {
            setBounds(250,250,400,300);
            //Создаем панел для TextField
            Panel editPanel=new Panel(new GridLayout(3,2,2,2));
            Label a=new Label("a=");
            TextField a_text=new TextField();
            Label b=new Label("b=");
            TextField b_text=new TextField();
            Label c=new Label("c=");
            TextField c_text=new TextField();
            editPanel.add(a);
            editPanel.add(a_text);
            editPanel.add(b);
            editPanel.add(b_text);
            editPanel.add(c);
            editPanel.add(c_text);
            Panel butPanel=new Panel(new GridLayout(3,1,2,2));
            calc=new Button("Вычисление ");
            clear=new Button("Очистить ");
            status=new Label("Статус:");
            calc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ans =(sum_Two(a_text.getText(), b_text.getText()));
                    c_text.setText(ans);
                }
            }) ;
            //Обработка нажатые на Очистить
            clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    a_text.setText("");
                    b_text.setText("");
                    c_text.setText("");
                }
            });
            butPanel.add(calc);
            butPanel.add(clear);
            butPanel.add(status);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            setVisible(true);
            Panel con=new Panel(new GridLayout(2,1,2,2));
            con.add(editPanel);
            con.add(butPanel);
            add(con);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    //Реализуем отдельный метод
    public String sum_Two(String a,String b)
    {
        //Сначало нужно проверит число ли там
        a=a.trim();
        b=b.trim();
        if(a.length()==0||b.length()==0)
        {
            status.setText("Один из поля пустая!!");
            return "-";
        }
        for(int i=0;i<a.length();i++)
        {
            if(!(Character.isDigit(a.charAt(i))||a.charAt(i)=='.'))
            {
                status.setText("Ошибка ввода данных");
                return String.valueOf(a.charAt(i));
            }
        }
        for(int i=0;i<b.length();i++)
        {
            if(!(Character.isDigit(b.charAt(i))||b.charAt(i)=='.'))
            {
                status.setText("Ошибка ввода данных");
                return String.valueOf(b.charAt(i));
            }
        }
        double aa=Double.parseDouble(a);
        double bb=Double.parseDouble(b);
        return String.valueOf(aa+bb);
    }
}
