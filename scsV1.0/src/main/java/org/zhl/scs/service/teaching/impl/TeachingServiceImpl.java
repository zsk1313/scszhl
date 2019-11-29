package org.zhl.scs.service.teaching.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhl.scs.dao.*;
import org.zhl.scs.domain.*;
import org.zhl.scs.domain.vo.ClazzVo;
import org.zhl.scs.domain.vo.CourseVo;
import org.zhl.scs.service.teaching.ITeachingService;
import org.zhl.scs.util.AssignByFieldName;
import org.zhl.scs.util.PageModel;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * service层实现类
 * @author ljj
 * @version 1.0
 * Great on 2019/11/15
 */
@Service("ITeachingService")
public class TeachingServiceImpl implements ITeachingService {
    @Autowired
    ImageDao imageDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ClazzDao clazzDao;
    @Autowired
    CourseDao courseDao;
    /**
     * 插入班级信息
     * @param clazzVo 班级对象
     */
    @Override
    public void saveClazz(ClazzVo clazzVo) {
        Clazz clazz=new Clazz();
        //给实体类赋值
        clazz.setId(clazzVo.getId());
        clazz.setDescription(clazzVo.getDescription());
        clazz.setClazzNum(clazzVo.getClazzNum());
//        List<Student> student_list=new ArrayList<>();//初始化Studentlist
//        List<Integer> i=ClazzVo.getStudentIds();//获得intlist
//        for (int a=0;a<i.size();a++){//给studentlist赋值
//             student_list.add(studentDao.selectById(i.get(a)));
//        }
//
//        clazz.setStudents(student_list);
       // clazz.setImage();
          Image image=imageDao.selectById(clazzVo.getImageId());
          clazz.setImage(image);
          Teacher teacher= teacherDao.selectById(clazzVo.getTeacherId());//获得teacher实体类对象
          clazz.setTeacher(teacher);//必须实现的方法
          clazzDao.save(clazz);
    }

    /**
     * 修改班级表
     * @param clazzVo 班级对象
     */
    @Override
    public void updateClazz(ClazzVo clazzVo) throws InvocationTargetException, IllegalAccessException {
        Clazz clazz=new Clazz();
        AssignByFieldName.getInstance().Assign(clazzVo,clazz);
        //获得teacher实体类对象
        Teacher teacher= teacherDao.selectById(clazzVo.getTeacherId());
        clazzDao.update(clazz);
    }

    /**
     * 通过ClazzVo删除班级信息
     * @param clazzVo 班级对象
     */
    @Override
    public void deleteClazz(ClazzVo clazzVo) {
        clazzDao.deleteById(clazzVo.getId());
    }

    /**
     * 通过id查询班级信息
     * @param id 班级id
     * @return 班级对象
     */
    @Override
    public Clazz selectClazzById(int id) {
        Clazz  clazz=clazzDao.selectById(id);
        return clazz;
    }

    /**
     * 不合理
     * @param clazzVo
     * @return
     */
    @Override
    public Clazz selectClazz(ClazzVo clazzVo)  {
        return null;
    }

    /**
     * 分页查询
     * @param clazzVo
     * @return list<Clazz>
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public List<Clazz> selectClazzs(ClazzVo clazzVo,PageModel pageModel) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> params = new HashMap<>();
        List<Clazz> list=new ArrayList<>();
        Clazz clazz = new Clazz();
        AssignByFieldName.getInstance().Assign(clazzVo,clazz);
        params.put("clazz", clazz);
        int count = clazzDao.count(params);
        System.out.println(count);
        pageModel.setRecordCount(count);


        params.put("pageModel", pageModel);
        for (Clazz clazz1 : clazzDao.selectByPage(params)) {
            list.add(clazz1);
        }
        return list ;
    }

    /**
     * 保存课程信息
      * @param courseVo
     */
    @Override
    public void saveCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
        Course course=new Course();
        AssignByFieldName.getInstance().Assign(courseVo,course);
        Teacher teacher=  teacherDao.selectById(courseVo.getId());
        course.setTeacher(teacher);
        courseDao.save(course);
    }

    /**
     * 更新课程信息
     * @param courseVo
     */
    @Override
    public void updateCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
        Course course=new Course();
        AssignByFieldName.getInstance().Assign(courseVo,course);
        Teacher teacher=  teacherDao.selectById(courseVo.getId());
        course.setTeacher(teacher);
        courseDao.update(course);
    }

    /**
     * 删除课程信息
     * @param courseVo
     */
    @Override
    public void deleteCourse(CourseVo courseVo) {
        courseDao.deleteById(courseVo.getId());
    }

    /**
     * 查询课程信息
     * @param courseVo
     * @return
     */
    @Override
    public Course selectCourse(CourseVo courseVo) {
        return null;
    }

    /**
     * 通过id查询课程信息
     * @param id
     * @return course
     */
    @Override
    public Course selectCourseById(Integer id) {
        Course course=new Course();
        course=courseDao.selectById(id);
        return course;
    }

    /**
     * 分页查询课程信息
     * @param courseVo
     * @return list
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public List<Course> selectCourses(CourseVo courseVo,PageModel pageModel) throws InvocationTargetException, IllegalAccessException {

        Map<String, Object> params = new HashMap<>();
        List<Course> list=new ArrayList<>();
        Course course=new Course();
        AssignByFieldName.getInstance().Assign(courseVo,course);
        params.put("course", course);
        int count = courseDao.count(params);
        pageModel.setRecordCount(count);
        params.put("pageModel", pageModel);
        for (Course course1 : courseDao.selectByPage(params)) {
            list.add(course1);
        }
        return list ;
    }

    /**
     * 通过班级id查该班级的所有学生集合
     * @param id
     * @return list<Student>
     */
    @Override
    public List<Student> findAllStudentByClazzId(Integer id) {
        List<Student> students=clazzDao.selectById(id).getStudents();
        return students;
    }

    /**
     * 通过课程id查询所有选该课程的学生集合
     * @param id
     * @return List<Student>
     */
    @Override
    public List<Student> findAllStudentByCoursersid(Integer id) {
        List<Student> students=courseDao.selectById(id).getStudents();
        return students;
    }

    /**
     * 通过课程id查询所该课程的所有考勤信息
     * @param id
     * @return  List<Attenance>
     */
    @Override
    public List<Attenance> findAllAttenanceByCoursersid(Integer id) {
        List<Attenance> attenances=courseDao.selectById(id).getAttenances();
        return attenances;
    }

    /**
     * 查询学分介于ab之间的所有课程信息
     * @param a
     * @param b
     * @return 课程集合
     */
    @Override
    public List<Course> findCourseByFilterOfScore(Double a, Double b) {
        List<Course> courses=courseDao.findCourseByFilterOfScore(a,b);
        return courses;
    }

    /**
     * 查询学分大于a的所有课程
     * @param a
     * @return
     */
    @Override
    public List<Course> findCourseByGreaterThanScore(Double a) {
        List<Course> courses=courseDao.findCourseByGreaterThanScore(a);
        return courses;
    }

    /**
     * 查询学分小于b的所有课程
     * @param b
     * @return
     */
    @Override
    public List<Course> findCourseByLessThanScore(Double b) {
        List<Course> courses=courseDao.findCourseByLessThanScore(b);
        return courses;
    }

    /**
     * 查询每周课时介于a和b之间的所有课程
     * @param a
     * @param b
     * @return
     */
    @Override
    public List<Course> findCourseByFilterOfDateorder(Integer a, Integer b) {
        List<Course> courses=courseDao.findCourseByFilterOfDateorder(a,b);
        return courses;
    }

    /**
     * 查询课时数大于a的所有课程
     * @param a
     * @return
     */
    @Override
    public List<Course> findCourseByGreaterThanDateorder(Integer a) {
        List<Course> courses=courseDao.findCourseByGreaterThanDateorder(a);
        return courses;
    }

    /**
     * 查询课程数小于b的所有课程
     * @param b
     * @return
     */
    @Override
    public List<Course> findCourseByLessThanDateorder( Integer b) {
        List<Course> courses=courseDao.findCourseByLessThanDateorder(b);
        return courses;
    }

    /**
     * 查询当前时间课程是否已上
     * @param id
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public boolean ifTaken(Integer id) throws InvocationTargetException, IllegalAccessException {
        Date date=  new Date();
        Course course=new Course();
        course=courseDao.selectById(id);
        if (course.getEndTime().before(date))
            return true;
        else
            return false;
    }

    @Override
    public Course findCurrentCourse(Date date) throws InvocationTargetException, IllegalAccessException {
        int[] weekDays = { 7, 1, 2, 3, 4, 5,6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        int weekday=weekDays[w];
        int  nocourse=0;
  SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String dateString=formatter.format(date);
        int courseNum=Integer.parseInt(dateString);
        if (courseNum<10&&courseNum>=8){
            nocourse=1;
        }else if (courseNum>=10&&courseNum<12){
            nocourse=2;
        }else if (courseNum>=14&&courseNum<16){
            nocourse=3;
        }
        else if (courseNum>=16&&courseNum<18){
            nocourse=4;
        }
        else if (courseNum>=19&&courseNum<=21){
            nocourse=5;
        }
        CourseVo courseVo=new CourseVo();
        courseVo.setWeek(weekday);
        courseVo.setDateorder(nocourse);
        Map<String, Object> params = new HashMap<>();
        List<Course> list=new ArrayList<>();
        Course course=new Course();
        AssignByFieldName.getInstance().Assign(courseVo,course);
        params.put("course", course);
        int count = courseDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);
        params.put("pageModel", pageModel);
        for (Course course1 : courseDao.selectByPage(params)) {
            list.add(course1);
        }
        return list.get(0) ;
    }
}
