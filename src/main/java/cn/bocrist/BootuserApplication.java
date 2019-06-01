package cn.bocrist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan(value = "cn.bocrist.dao")
public class BootuserApplication {

   public static void main(String[] args) {
      SpringApplication.run(BootuserApplication.class, args);
   }
}
