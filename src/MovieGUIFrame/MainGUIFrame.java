package MovieGUIFrame;

import javax.swing.*;

public class MainGUIFrame extends JFrame {
    public MainGUIFrame() {
        setTitle("나의 영화 리뷰");
        setSize(1000, 600);
        setLocation(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        setVisible(true);
    }

    //run 했을때 실행순서가 시작되는 main 메소드
    public static void main(String[] args) {
        new MainGUIFrame();
    }
}
