import Frame.Log;

import java.awt.*;


public class Run_CouldFac {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Log log = Log.getInstance();
                    log.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

