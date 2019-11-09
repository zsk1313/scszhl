package org.zhl.scs.service.user;


import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.Teacher;
import org.zhl.scs.domain.User;

import java.util.List;

/**
 * 用户管理模块
 */
public interface IUserService {

    //---------------user基本表操作-----------------

    /**
     * 保存用户
     */
    void saveUser(User user);

    /**
     * 更新用户信息
     */
    void updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(User user);

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
     * @param student
     */
    void saveStudent(Student student);

    /**
     * 更新学生信息
     *
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 删除学生
     *
     * @param student
     */
    void deleteStudent(Student student);

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
     * @param teacher
     */
    void saveTeacher(Teacher teacher);

    /**
     * 更新教师对象
     *
     * @param teacher
     */
    void updateTeacher(Teacher teacher);

    /**
     * 删除教师对象
     *
     * @param teacher
     */
    void deleteTeacher(Teacher teacher);

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
