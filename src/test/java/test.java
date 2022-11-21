import com.qimu.pojo.Emp;
import com.qimu.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class test {
    @Autowired
    private EmpService empService;

    @Test
    public void getUser() {
        Emp emp = new Emp();
        emp.setEmpName("admin");
        emp.setPassword("admin");
        List<Emp> user = empService.getUser(emp);
        user.forEach(System.out::println);
    }

    @Test
    public void getUserIsExist() {
        Emp user = empService.getUserIsExist("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void findUserByName() {
        Emp user = empService.findUserByName("admin");
        System.out.println(user);
    }

    @Test
    public void updateById() {
        Emp emp = new Emp();
        emp.setEmpId(27);
        emp.setEmpName("QiMu");
        Integer integer = empService.updateById(emp);
        System.out.println(integer > 0 ? "成功" : "失败");
    }

    @Test
    public void deleteById() {
        Integer[] ids = new Integer[]{27,20};
        Integer integer = empService.deleteById(ids);
        System.out.println(integer > 0 ? "成功" : "失败");
    }
}
