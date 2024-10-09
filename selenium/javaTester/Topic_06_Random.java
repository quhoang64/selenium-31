package javaTester;

import java.util.Random;

public class Topic_06_Random {
    // Java builtin ( cung cấp sẵn - lấy ra sử dụng)
    // Java libraries ( do 1 cá nhân/ tổ chức họ tự viết )

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("automation" + new Random().nextInt(1000) + "@gmail.com");
    }
}
