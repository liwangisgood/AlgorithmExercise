package cn.ahpu.gitee.lombok.cauchy6317.common.Cleanup;

import lombok.Cleanup;

import java.io.*;

/**
 * Description:
 *
 * @author Cheng Jun
 * @version 1.0
 * @date 2019/10/31 15:06
 */
public class CleanupExample {
    public static void main(String[] args) throws IOException {

        try(InputStream inputStream =
                    new FileInputStream(".\\src\\main\\java\\com\\cauchy6317\\common\\Cleanup\\ForCleanupExample.txt")){
            // to do something
        }
        @Cleanup Reader fileReader =
                new FileReader(".\\src\\main\\java\\com\\cauchy6317\\common\\Cleanup\\ForCleanupExample1.txt");
        // to do something

    }
}
