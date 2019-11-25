package org.zhl.scs.service.teaching;


import org.zhl.scs.domain.Attenance;
import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.vo.ClazzVo;
import org.zhl.scs.domain.vo.CourseVo;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * 教学管理模块
 * @author lzs
 * @version v1.1
 */
public interface ITeachingService {

    //--------班级管理--------

    /**
     * 保存班级对象
     *
     * @param ClazzVo 班级对象
     */
    void saveClazz(ClazzVo ClazzVo);

    /**
     * 更新班级对象
     *
     * @param ClazzVo 班级对象
     */
    void updateClazz(ClazzVo ClazzVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 删除班级对象
     *
     * @param ClazzVo 班级对象
     */
    void deleteClazz(ClazzVo ClazzVo);

    /**
     * 根据班级id查询班级
     *
     * @param id 班级id
     * @return
     */
    Clazz selectClazzById(int id);

    /**
     * 查询班级
     *
     * @param clazzVo
     * @return
     */
    Clazz selectClazz(ClazzVo clazzVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 查询班级集合
     *
     * @param clazzVo
     * @return 班级集合
     */
    List<Clazz> selectClazzs(ClazzVo clazzVo) throws InvocationTargetException, IllegalAccessException;


    //-----------课程管理---------------

    /**
     * 保存课程信息
     *
     * @param CourseVo
     */
    void saveCourse(CourseVo CourseVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 更新课程信息
     *
     * @param CourseVo
     */
    void updateCourse(CourseVo CourseVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 删除课程信息
     *
     * @param CourseVo
     */
    void deleteCourse(CourseVo CourseVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 查询课程
     *
     * @param courseVo
     * @return 课程
     */
    Course selectCourse(CourseVo courseVo);
    /**
     *
     */
    Course selectCourseById(Integer id);
    /**
     * 查询课程集合
     *
     * @param courseVo
     * @return 课程集合
     */
    List<Course> selectCourses(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 查询一个班级里的所有学生信息
     * @author ljj
     * @return 学生集合
     */
    List<Student> findAllStudentByClazzId(Integer id);
    /**
     * 查询一个课程里的所有学生
     * @author ljj
     * @return 学生集合
     *
     */
    List<Student> findAllStudentByCoursersid(Integer id);
    /**
     * 查询一个课程的所有考勤信息
     * @author ljj
     * @return List<Attenance>
     */
    List<Attenance> findAllAttenanceByCoursersid(Integer id);
    /**
     * 查询学分大于a,小于b，的所有课程
     * @author ljj
     * @return 课程集合
     *
     */
    List<Course> findCourseByFilterOfScore(Double a,Double b);
    /**
     * 查询学分大于a的所有课程
     * @author ljj
     * @return 课程集合
     *
     */
    List<Course> findCourseByGreaterThanScore(Double a);
    /**
     * 查询学分小于a的所有课程
     * @author ljj
     * @return 课程集合
     *
     */
    List<Course> findCourseByLessThanScore(Double a);
    /**
     * 查询课时大于a,小于b，的所有课程
     * @author ljj
     * @return 课程集合
     *
     */
    List<Course> findCourseByFilterOfDateorder(Integer a,Integer b);
    /**
     * 查询课时大于a,的所有课程
     * @author ljj
     * @return 课程集合
     *
     */
    List<Course> findCourseByGreaterThanDateorder(Integer a);
    /**
     * 查询课时小于b,的所有课程
     * @author ljj
     * @return 课程集合
     *
     */
    List<Course> findCourseByLessThanDateorder(Integer b);

    /**
     * 已上课程
     * @param id
     * @return
     */
    boolean ifTaken(Integer id) throws InvocationTargetException, IllegalAccessException;
    /**
     * 当前课程
     */
    Course findCurrentCourse(Date date) throws InvocationTargetException, IllegalAccessException;
    /**
     * 课程评分
     */
    }
