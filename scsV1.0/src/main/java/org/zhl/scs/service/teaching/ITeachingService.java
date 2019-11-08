package org.zhl.scs.service.teaching;


import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Course;

import java.util.List;

/**
 * 教学管理模块
 */
public interface ITeachingService {

    //--------班级管理--------

    /**
     * 保存班级对象
     *
     * @param clazz 班级对象
     */
    void saveClazz(Clazz clazz);

    /**
     * 更新班级对象
     *
     * @param clazz 班级对象
     */
    void updateClazz(Clazz clazz);

    /**
     * 删除班级对象
     *
     * @param clazz 班级对象
     */
    void deleteClazz(Clazz clazz);

    /**
     * 根据班级id查询班级
     *
     * @param id 班级id
     * @return
     */
    Clazz selectClazzById(int id);

    /**
     * 根据班级编号查询班级
     *
     * @param num 班级编号
     * @return
     */
    Clazz selectClazzByNum(String num);

    /**
     * 根据教师id查询班级集合
     *
     * @param teacherId 教师id
     * @return 班级集合
     */
    List<Clazz> selectClazzByTeacher(int teacherId);

    /**
     * 备用
     *
     * @param item
     * @return 班级集合
     */
    List<Clazz> selectClazzByAny(Object item);

    //-----------课程管理---------------

    /**
     * 保存课程信息
     *
     * @param course
     */
    void saveCourse(Course course);

    /**
     * 更新课程信息
     *
     * @param course
     */
    void updateCourse(Course course);

    /**
     * 删除课程信息
     *
     * @param course
     */
    void deleteCourse(Course course);

    /**
     * 根据课程id查询课程
     *
     * @param id 课程id
     * @return 课程
     */
    Course selectCourseById(int id);

    /**
     * 根据星期查询课程
     *
     * @param week 星期
     * @return 课程集合
     */
    List<Course> selectCourseByWeek(int week);

    /**
     * 备用
     *
     * @param item
     * @return 课程集合
     */
    List<Course> selectCourseByAny(Object item);

}
