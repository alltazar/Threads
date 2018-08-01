import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){

        JTextArea text = new JTextArea();
        MyButton button = new MyButton(text);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(button, BorderLayout.NORTH);
        contentPanel.add(text, BorderLayout.CENTER);

        JFrame frame = new JFrame("Paint Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPanel);
        frame.setBounds(0,0,200,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class MyButton extends JButton{
    JTextArea text_;

    MyButton(JTextArea text){
        super("Посчитать");
        text_ = text;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyThread myThread = new MyThread(text);
                MyThread myThread2 = new MyThread(text);
                myThread.start();
                myThread2.doSmth(text);
            }
        });
    }
}

class MyThread extends Thread{

    JTextArea text_;

    MyThread(JTextArea text){
        text_ = text;
    }

    @Override
    public void run(){
        int result = 50000;
        int[] arr = new int[result];

        for (int i = 1; i < result; i ++){
            arr[i] = (int) Math.round((Math.random() * 30));
        }

        for (int j = 0; j < arr.length - 1; j++) {
            if (arr.length > 1) {
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] > arr[i+1]) {
                        int a = arr[i];
                        int b = arr[i+1];
                        arr[i] = b;
                        arr[i+1] = a;
                    }
                }
            }
        }

        text_.append("End with array");
    }

    public void doSmth(JTextArea text){
        text.append("OK");
    }
}