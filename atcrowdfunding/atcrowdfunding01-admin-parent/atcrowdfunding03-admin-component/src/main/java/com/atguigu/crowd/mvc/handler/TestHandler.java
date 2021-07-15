
package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestHandler {

  @Autowired
  private AdminService adminService;

  private final Logger logger = LoggerFactory.getLogger(TestHandler.class);


  @RequestMapping("/test/ssm.html")
  public String testSsm(ModelMap modelMap, HttpServletRequest request) {

    boolean judgeResult = CrowdUtil.judgeRequestType(request);
    logger.info("judgeResult = " + judgeResult);

    List<Admin> adminList = adminService.getAll();
    System.out.println(10/0);

    modelMap.addAttribute("adminList", adminList);

    return "target";
  }


  @ResponseBody
  @RequestMapping("/send/array1.html")
  public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
    // 接收参数时需要在参数名后面加[]
    for (Integer number : array) {
      System.out.println("number=" + number);

    }
    return "success";
  }

  @ResponseBody
  @RequestMapping("/send/array2.html")
  public String testReceiveArrayTwo(@RequestBody List<Integer> array) {
    for (Integer number : array) {
      logger.info("number=" + number);

    }
    return "success";
  }

  @ResponseBody
  @RequestMapping("/send/compose/object.json")
  public ResultEntity<Student> testReceiveComplicatedObject(@RequestBody Student student, HttpServletRequest request){
    boolean judgeResult = CrowdUtil.judgeRequestType(request);
    logger.info("judgeResult = "+judgeResult);
    logger.info(student.toString());
    return ResultEntity.successWithData(student);
  }

}
