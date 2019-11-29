package org.zhl.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.vo.CourseVo;
import org.zhl.scs.reponse.RespBean;
import org.zhl.scs.service.teaching.ITeachingService;
import org.zhl.scs.util.PageModel;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
  @Autowired
    ITeachingService iTeachingService;
    /**
     * 分页查询
     * 接受Vo返回实体类
     */
    @GetMapping(value = "/course")
    public Map<String,Object> findCourseByPage(CourseVo courseVo, PageModel pageModel) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        List<Course> courses=iTeachingService.selectCourses(courseVo,pageModel);
        map.put("courses",courses);
        map.put("count",pageModel.getRecordCount());
        System.out.println("?");
        return map;
    }
    @PostMapping(value = "/addCourse")
    public RespBean addCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
        RespBean respBean = RespBean.build();
        iTeachingService.saveCourse(courseVo);
        respBean.setMsg("添加成功");
        return respBean;
    }

}
