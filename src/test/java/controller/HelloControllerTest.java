package controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HelloControllerTest {

    // 测试访问test1()方法返回字符串为index Created by YC.
    // 为方法添加测试用例的快捷键为Ctrl+Shift+t Created by YC.
    @Test
    public void test1() throws Exception {
        // 断言返回包含“home”值的String。它完全没有站在Spring MVC控制器的视角进行测试. Created by YC.
//        pojo();

        // 发起了对“/”的GET请求，并断言结果视图的名称为home. Created by YC.
        // 不用运行服务器即可测试,屌! Created by YC.
        mvc();
    }

    private void mvc() throws Exception {
        HelloController controller = new HelloController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/hello/test1")).andExpect(view().name("index"));
    }

    private void pojo() {
        HelloController controller = new HelloController();
        assertEquals("index", controller.test1());
    }
}