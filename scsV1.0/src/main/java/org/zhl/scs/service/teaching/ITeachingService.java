package org.zhl.scs.service.teaching;


import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.vo.ClazzVo;
import org.zhl.scs.domain.vo.CourseVo;

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
    void updateClazz(ClazzVo ClazzVo);

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
     * @param item
     * @return
     */
    Clazz selectClazz(Object item);

    /**
     * 查询班级集合
     *
     * @param item
     * @return 班级集合
     */
    List<Clazz> selectClazzs(Object item);


    //-----------课程管理---------------

    /**
     * 保存课程信息
     *
     * @param CourseVo
     */
    void saveCourse(CourseVo CourseVo);

    /**
     * 更新课程信息
     *
     * @param CourseVo
     */
    void updateCourse(CourseVo CourseVo);

    /**
     * 删除课程信息
     *
     * @param CourseVo
     */
    void deleteCourse(CourseVo CourseVo);

    /**
     * 查询课程
     *
     * @param item
     * @return 课程
     */
    Course selectCourse(Object item);

    /**
     * 查询课程集合
     *
     * @param item
     * @return 课程集合
     */
    List<Course> selectCourses(Object item);



}
