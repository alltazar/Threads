import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static int i = 0;

    public static void main(String[] args) {

        JTextArea text = new JTextArea();
        MyButton button = new MyButton(text);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(button, BorderLayout.NORTH);
        contentPanel.add(text, BorderLayout.CENTER);

        JFrame frame = new JFrame("Paint Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPanel);
        frame.setBounds(0, 0, 200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        int myList[] = {5,5};

    }
}

//        for (int j = 0; j < 10000; j++){
//            new MyThread2().start();
//        }
//        try {
//            MyThread2.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(i);
//    }

//    static class MyThread2 extends Thread{
//        @Override
//        public void run(){
//            plus();
//        }
//    }
//
//    static synchronized void plus(){
//        i++;
//    }


class MyButton extends JButton{
    JTextArea text_;

    MyButton(JTextArea text){
        super("Посчитать");
        text_ = text;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyThread myThread = new MyThread(text);
                //MyThread myThread2 = new MyThread(text);
                myThread.start();
                //myThread2.doSmth(text);
                //text.append("OK");
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

        int export = 0;

        for (int j = 0; j < arr.length - 1; j++) {
            export += arr[j];
        }

        text_.append(""+export);
    }

    public void doSmth(JTextArea text){
        text.append("OK");
    }
}