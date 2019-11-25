package org.zhl.scs.service.user;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.zhl.scs.domain.*;
import org.zhl.scs.domain.vo.*;
import org.zhl.scs.exception.EntityNotFoundException;
import org.zhl.scs.exception.IllegalValueException;
import org.zhl.scs.util.PageModel;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 用户管理模块
 */
public interface IUserService  extends UserDetailsService {

    //---------------user基本表操作-----------------

    /**
     * 保存用户
     */
    void saveUser(UserVo userVo) throws InvocationTargetException, IllegalAccessException, IllegalValueException, NoSuchMethodException;

    /**
     * 更新用户信息
     */
    void updateUser(UserVo userVo) throws IllegalValueException, EntityNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, IllegalClassFormatException;

    /**
     * 删除用户
     */
    void deleteUser(UserVo userVo) throws IllegalValueException, EntityNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, InvocationTargetException;

    /**
     * 根据id查找用户
     *
     * @return 用户对象
     */
    User selectUserById(int id) throws IllegalValueException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

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
    List<User> selectUsers(UserVo userVo, PageModel pageModel) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;

    /**
     * 查询用户
     * @param userVo
     * @return
     */
    User selectUser(UserVo userVo);

    /**
     * 批量删除用户
     * @param idList
     */
    void deleteUsers(List<Integer> idList) throws EntityNotFoundException, InvocationTargetException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException;

    //--------------student表操作--------------

    /**
     * 保存学生信息
     *
     * @param studentVo
     */
    void saveStudent(StudentVo studentVo) throws InvocationTargetException, IllegalAccessException, IllegalValueException, EntityNotFoundException, NoSuchMethodException, IllegalClassFormatException;

    /**
     * 更新学生信息
     *
     * @param studentVo
     */
    void updateStudent(StudentVo studentVo) throws IllegalValueException, EntityNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, IllegalClassFormatException;

    /**
     * 删除学生
     *
     * @param studentVo
     */
    void deleteStudent(StudentVo studentVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 根据id查询学生
     *
     * @param id 学生id
     * @return
     */
    Student selectStudentById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

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
     * @param studentVo
     * @param
     * @return
     */
    List<Student> selectStudents(StudentVo studentVo,PageModel pageModel) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;

    /**
     * 根据学生信息查找学生数量
     * @param userVo 学生vo实例
     * @return 符合该条件的学生数量
     */
    Integer getUserCountByKeywords(UserVo userVo) throws InvocationTargetException, IllegalAccessException;

    //-----------teacher操作-------------

    /**
     * 保存教师对象
     *
     * @param teacherVo
     */
    void saveTeacher(TeacherVo teacherVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 更新教师对象
     *
     * @param teacherVo
     */
    void updateTeacher(TeacherVo teacherVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 删除教师对象
     *
     * @param teacherVo
     */
    void deleteTeacher(TeacherVo teacherVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 根据教师id查询教师
     *
     * @param id 教师id
     * @return
     */
    Teacher selectTeacherById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 查询教师集合
     *
     * @param teacherVo
     * @param pageModel
     * @return
     */
    List<Teacher> selectTeachers(TeacherVo teacherVo,PageModel pageModel) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    /**
     * 查询教师
     *
     * @param item
     * @return
     */
    Teacher selectTeacher(Object item);

    /**
     * 修改用户角色
     * @param userVo 用户vo类实例
     * @return 修改后的用户信息
     */
    User updateUserRoles(UserVo userVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException, IllegalValueException;

    /**
     * 添加角色
     * @param roleVo 角色vo实例
     */
    void saveRole(RoleVo roleVo) throws InvocationTargetException, IllegalAccessException, IllegalValueException, NoSuchMethodException;

    /**
     * 修改角色
     * @param roleVo
     */
    void updateRole(RoleVo roleVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 删除角色
     * @param roleVo
     */
    void deleteRole(RoleVo roleVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    Role selectRoleById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 分页查询角色
     * @param roleVo
     * @param pageModel
     * @return
     */
    List<Role> selectRoles(RoleVo roleVo,PageModel pageModel) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    /**
     * 添加角色
     * @param menuVo 资源vo实例
     */
    void saveMenu(MenuVo menuVo) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IllegalValueException;

    /**
     * 修改角色
     * @param menuVo
     */
    void updateMenu(MenuVo menuVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 删除角色
     * @param menuVo
     */
    void deleteMenu(MenuVo menuVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    Menu selectMenuById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;

    /**
     * 分页查询角色
     * @param menuVo
     * @param pageModel
     * @return
     */
    List<Menu> selectMenus(MenuVo menuVo,PageModel pageModel) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    /**
     * 修改角色资源
     * @param roleVo 角色vo类实例
     * @return 修改后的角色信息
     */
    Role updateRoleMenus(RoleVo roleVo) throws IllegalValueException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException;
}
