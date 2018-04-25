package controller;

import entity.Account;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
//@RequestMapping(value="/hello")
public class HelloController {

    @RequestMapping(value = "/test1")
    public String test1() {
        System.out.println("进入方法!");
        return "index";
    }

    // 使用@RequestParam的好处在于可以设定默认值(当参数不存在的时候触发), 如果不设置并且参数不存在的情况下会报400 Created by YC.
    @RequestMapping(value = "/test2")
    @ResponseBody
    public String test2(@RequestParam(value = "name", defaultValue = "YangChen") String name) {
        return name;
    }

    // 占位符的作用{}、@PathVariable
    // 识别的资源（Spittle）应该通过URL路径进行标示，而不是通过查询参数。对“/spittles/12345”发起GET请求要优于对“/spittles/show?spittle_id=12345”发起请求. Created by YC.
    @RequestMapping(value = "/test3/{param}")
    @ResponseBody
    public String test3(@PathVariable("param") String param) {
        return param;
    }

    // 如果返回的是集合或者对象,需要映射路径对应视图名称便可正常访问. Created by YC.
    // model属性名称有返回对象类型隐含表示，model属性对象就是方法的返回值
    @RequestMapping(value = "/index")
    public User test4() {
        User user = new User();
        user.setName("YangChen");
        user.setSex("男");
        return user;
    }

    // ModelAndView的使用 Created by YC.
    // 常规写法
    @RequestMapping(value = "/test5")
    public ModelAndView test5() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("param1", "param1");
        return modelAndView;
    }

    // 构造写法
    @RequestMapping(value = "/test6")
    public ModelAndView test6() {
        // 返回视图名称
        ModelAndView modelAndView = new ModelAndView("index");
        // 返回视图名称、Map集合数据
        Map map = new HashMap();
        map.put("a", "a");
        ModelAndView modelAndView1 = new ModelAndView("index", map);
        // 返回视图满城、参数名称、参数值
        ModelAndView modelAndView2 = new ModelAndView("index", "a", "a");
        return modelAndView;
    }

    // @ModelAttribute注解的方法会在映射方法执行之前执行
    // 无返回值的情况使用
//    @ModelAttribute
//    public void modelAttribute_test1(Model model) {
//        model.addAttribute("modelAttribute1", "modelAttribute-test1");
//    }

    // 有返回值的情况使用(效果同上, 写法更方便)
//    @ModelAttribute("modelAttribute2")
//    public String modelAttribute_test2(Model model) {
//        return "modelAttribute-test2";
//    }

    // @ModelAttribute(value="test")在参数中的情况
    // 链接: http://localhost:8080/spring-mvc/test7?test=123456
    // 效果: 先向模型中获取属性名为test的数据,如果存在将数据给后面的参数,如果不存在把URL请求中的参数给后面参数.
//    @RequestMapping(value = "/test7")
//    public String test7(@ModelAttribute("test") String test) {
//        return "index";
//    }

//    @ModelAttribute("test")
//    public String testMethod() {
//        return "good";
//    }

    // 注册页面
    @RequestMapping("/home")
    public String home() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture, @Valid Account account, Errors errors, HttpServletRequest request) throws IOException {
        // 获取编码格式
        // 结果: 无效
        /*String characterEncoding = request.getCharacterEncoding();
        System.out.println("获取编码:\t" + characterEncoding);
        if (characterEncoding == null) {
            request.setCharacterEncoding("UTF-8");
        }*/

        // 结果: 无效
        /*String profilePictureName = new String(profilePicture.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("获取文件名:\t" + profilePictureName);*/
//        profilePicture.transferTo(new File("/" + profilePicture.getOriginalFilename()));
//        System.out.println("获取上传文件名:\t" + profilePicture.getOriginalFilename());
        System.out.println(profilePicture.getSize());
        File tempFile = new File("C:\\User\\ceek");
        try {
            // transferTo()方法指定生成文件
            profilePicture.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        if (errors.hasErrors()) {
            System.out.println("不符合条件!");
            return "register";
        }
        return "index";
    }

    // 重定向携带数据的使用
    // 使用model模型,{}占位符,相当于后缀,没使用占位符的数据存入model中,已参数的形式拼接
    // 下面拼接结果为http://localhost:8080/spring-mvc/redirect/testData/?select=1
    // 注意: redirect: /和没有/的区别,没有/的情况是项目名下拼接,有/的情况为去掉项目名拼接
    @RequestMapping("/redirect")
    public String testRedirect(Model model) {
        String testData = "testData";
        model.addAttribute("testData", testData);
        model.addAttribute("select", 1);
        return "redirect: redirect/{testData}";
    }

    // flash属性的使用
    // 注: 一直获取不到addFlashAttribute添加的属性值原因是return "redirect:(多了个空格)redirect2"所致;
    @RequestMapping(value = "/redirect1")
    public String testRedirect1(RedirectAttributes redirectAttributes) {
        // 指定属性名的情况
        User user = new User();
        user.setSex("男");
        user.setName("YangChen");
        redirectAttributes.addFlashAttribute("user1", user);

        // 不指定名称的情况
        // 默认为首字母小写的对象名称
        User user1 = new User();
        user1.setName("YangChen1");
        user1.setSex("男1");
        redirectAttributes.addFlashAttribute(user1);

        return "redirect:redirect2";
    }

    // 获取flash属性的值
    @RequestMapping(value = "/redirect2")
    public String testRedirect2(Model model) {
        System.out.println("返回状态user:\t" + model.containsAttribute("user"));
        System.out.println("返回状态user1:\t" + model.containsAttribute("user1"));
        return "redirect";
    }

    // 异常的使用
    @RequestMapping(value = "/no")
    public String spittleNotFoundException() {
        throw new DuplicateSpittleException();
    }

    // 此全局方案已在AppWideExceptionHandler类统一管理,而此方法之作用在当前类.
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        System.out.println("行走的方法");
        return "error";
    }

    @ExceptionHandler(DuplicateSpittleException1.class)
    public String handleDuplicateSpittle1() {
        System.out.println("行走的方法");
        return "error";
    }

    @RequestMapping(value = "/no1")
    public String duplicateSpittleException() throws DuplicateSpittleException1 {
        throw new DuplicateSpittleException1();
    }

}
