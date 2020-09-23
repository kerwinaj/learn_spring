import java.io.FileOutputStream;
import java.io.IOException;


public class Order1_ExitFinally {
    public static void main(String[] args) throws IOException {
//        exit();
        exitWithHook();
    }

    /**
     * System.exit(0); 会直接退出虚拟机, 所以finally块都没办法执行了
     */
    public static void exit() throws IOException{
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("aaa.bin");
            System.out.println("[exit]open the resources");
            System.exit(0);
        } finally {
            System.out.println("[exit]coming into finally");
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[exit]close the resources");
        }
    }

    /**
     * 关闭钩子在程序退出时执行, 回收系统资源.
     * @throws IOException
     */
    public static void exitWithHook() throws IOException{
        final FileOutputStream fos = new FileOutputStream("aaa.bin");
        System.out.println("[exitWithHook]open the resources");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("[exitWithHook]coming into finally");
                if (null != fos) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("[exitWithHook]close the resources");
            }
        });
        System.exit(0);
    }
}