package org.zhl.scs.service.user;


import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.Teacher;
import org.zhl.scs.domain.User;
import org.zhl.scs.domain.vo.StudentVo;
import org.zhl.scs.domain.vo.TeacherVo;
import org.zhl.scs.domain.vo.UserVo;

import java.util.List;

/**
 * 用户管理模块
 */
public interface IUserService {

    //---------------user基本表操作-----------------

    /**
     * 保存用户
     */
    void saveUser(UserVo UserVo);

    /**
     * 更新用户信息
     */
    void updateUser(UserVo UserVo);

    /**
     * 删除用户
     */
    void deleteUser(UserVo UserVo);

    /**
     * 根据id查找用户
     *
     * @return 用户对象
     */
    User selectUserById(int id);

    /**
     * 用于登录，查询用户名和密码
     *
     * @return 用户对象
     */
    User login(String username, String password);

    /**
     * 查询用户集合
     *
     * @return 用户对象集合
     */
    List<User> selectUsers(Object item);

    /**
     * 查询用户
     * @param item
     * @return
     */
    User selectUser(Object item);

    //--------------student表操作--------------

    /**
     * 保存学生信息
     *
     * @param StudentVo
     */
    void saveStudent(StudentVo StudentVo);

    /**
     * 更新学生信息
     *
     * @param StudentVo
     */
    void updateStudent(StudentVo StudentVo);

    /**
     * 删除学生
     *
     * @param StudentVo
     */
    void deleteStudent(StudentVo StudentVo);

    /**
     * 根据id查询学生
     *
     * @param id 学生id
     * @return
     */
    Student selectStudentById(int id);

    /**
     * 查询学生
     *
     * @param item
     * @return
     */
    Student selectStudent(Object item);

    /**
     * 根据学生姓名查找学生
     *
     * @param item
     * @return
     */
    List<Student> selectStudents(Object item);


    //-----------teacher操作-------------

    /**
     * 保存教师对象
     *
     * @param TeacherVo
     */
    void saveTeacher(TeacherVo TeacherVo);

    /**
     * 更新教师对象
     *
     * @param TeacherVo
     */
    void updateTeacher(TeacherVo TeacherVo);

    /**
     * 删除教师对象
     *
     * @param TeacherVo
     */
    void deleteTeacher(TeacherVo TeacherVo);

    /**
     * 根据教师id查询教师
     *
     * @param id 教师id
     * @return
     */
    Teacher selectTeacherById(int id);

    /**
     * 查询教师集合
     *
     * @param item
     * @return
     */
    List<Teacher> selectTeachers(Object item);

    /**
     * 查询教师
     *
     * @param item
     * @return
     */
    Teacher selectTeacher(Object item);


}
