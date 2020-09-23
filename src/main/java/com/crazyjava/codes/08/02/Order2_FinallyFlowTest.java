/**
 * try 语句中, 遇到return和throw两个语句时, 先去找有没有finally语句块, 有就执行finally语句块;
 * finally语句块中, 正常是执行完返回return或者throw语句, 但如果里面还有return语句就会直接返回(所以是不建议在finally语句块中写return语句的);
 *
 */
public class Order2_FinallyFlowTest{
    public static void main(String[] args) {
        int result = test();
        System.out.println("result:"+ result);
        result = test2();
        System.out.println("result:"+ result);
        result = test3();
        System.out.println("result:"+ result);
        result = test4();
        System.out.println("result:"+ result);
    }

    /**
     * 请不要在finally中使用return
     *  Inspection info:
     * 不能在finally块中使用return，finally块中的return返回后方法结束执行，不会再执行try块中的return语句。
     *
     * Negative example:
     *     public static Long readFileLength(String fileName) {
     *         try {
     *             File file = new File(fileName);
     *             RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
     *             return randomAccessFile.length();
     *         } catch (Exception e) {
     *             logger.error(e.getMessage(), e);
     *         } finally {
     *             countDownLatch.countDown();
     *             return 0L;
     *         }
     *     }
     * @return
     */
    public static int test(){
        int count = 5;
        try{
            return ++count;
        } finally {
            System.out.println("[test]run finally");
            return 3;
        }
    }

    public static int test2(){
        int count = 5;
        try{
            return ++count;
        } finally {
            System.out.println("[test2]]un finally");
        }
    }


    public static int test3(){
        int count = 5;
        try{
            throw new RuntimeException("test throw exception");
        } finally {
            System.out.println("[test3]run finally");
            return count;
        }
    }


    public static int test4(){
        int count = 5;
        try{
            throw new RuntimeException("test throw exception");
        } finally {
            System.out.println("[test4]run finally");
        }
    }
}