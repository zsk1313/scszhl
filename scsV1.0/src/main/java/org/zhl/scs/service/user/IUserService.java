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
     * 根据用户名查询用户
     *
     * @return 用户对象集合
     */
    List<User> selectUserByUsername(String username);

    /**
     * 根据用户角色查询用户
     *
     * @return 用户集合对象
     */
    List<User> selectUserByRole(int roleId);

    /**
     * 备用
     *
     * @param item
     * @return
     */
    List<User> selectUserByAny(Object item);

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
     * 根据学生学号查询学生
     *
     * @param uid 学生学号
     * @return
     */
    Student selectStudentByUid(String uid);

    /**
     * 根据学生姓名查找学生
     *
     * @param name 学生姓名
     * @return
     */
    List<Student> selectStudentByName(String name);

    /**
     * 根据班级查询学生
     *
     * @param clazzId 班级id
     * @return
     */
    List<Student> selectStudentByClazz(int clazzId);

    /**
     * 备用
     *
     * @param item
     * @return
     */
    List<Student> selectStudentByAny(Object item);

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
     * 根据教师名字查询教师
     *
     * @param name 教师名字
     * @return
     */
    List<Teacher> selectTeacherByName(String name);

    /**
     * 根据教师编号查询教师
     *
     * @param uid 教师编号
     * @return
     */
    Teacher selectTeacherByUid(String uid);

    /**
     * 备用
     *
     * @param item
     * @return
     */
    List<Teacher> selectTeacherByAny(Object item);

}
