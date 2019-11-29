package org.zhl.scs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.dao.ClazzDao;
import org.zhl.scs.dao.RoleDao;
import org.zhl.scs.dao.StudentDao;
import org.zhl.scs.dao.UserDao;
import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Role;
import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.User;
import org.zhl.scs.domain.vo.*;
import org.zhl.scs.exception.EntityNotFoundException;
import org.zhl.scs.exception.IllegalValueException;
import org.zhl.scs.service.user.IUserService;
import org.zhl.scs.util.DaoUtil;
import org.zhl.scs.util.PageModel;
import org.zhl.scs.util.ServiceUtil;
import org.zhl.scs.util.common.Sex;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 用户Service测试类
 */
@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {Application.class})
public class IUserServiceTests {
    @Autowired
    IUserService iUserService;

    @Autowired
    DaoUtil daoUtil;

    @Autowired
    ServiceUtil serviceUtil;

    @Autowired
    UserDao userDao;

    @Test
    public void testSaveUser(){
        UserVo userVo=new UserVo();
        userVo.setPassword("123");
        userVo.setRoleIds(Arrays.asList(3));
        userVo.setUsername("hyp8");
        try {
            iUserService.saveUser(userVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalValueException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateUser(){
        UserVo userVo=new UserVo();
        userVo.setId(12);
        userVo.setUsername("ljj4");
        try {
            iUserService.updateUser(userVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException | NoSuchMethodException | IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser(){
        UserVo userVo=new UserVo();
        userVo.setId(12);
        try {
            iUserService.deleteUser(userVo);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectUserById() throws IllegalValueException, NoSuchMethodException, EntityNotFoundException, IllegalAccessException, IllegalClassFormatException, InvocationTargetException {
        iUserService.selectUserById(12);
    }

    @Test
    public void testSelectUsers() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        UserVo userVo=new UserVo();
        userVo.setUsername("l");
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(2);
        iUserService.selectUsers(userVo,pageModel);
    }

    @Test
    public void testUpdateUserRoles(){
        UserVo userVo=new UserVo();
        userVo.setId(12);
        List<Integer> roleIds=new ArrayList<>(Arrays.asList(3,4));
        userVo.setRoleIds(roleIds);
        try {
            iUserService.updateUserRoles(userVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveStudent(){
        StudentVo studentVo=new StudentVo();
        studentVo.setAddress("test");
        studentVo.setAdmissiontime(new Date());
        studentVo.setBirthday(new Date());
        studentVo.setClazzId(1);
        studentVo.setName("ljj5");
        studentVo.setSex(Sex.MALE);
        studentVo.setNativeplace("test");
        studentVo.setPostcode("518116");
        studentVo.setProfession("test");
        studentVo.setUid("2666666");
        studentVo.setUserId(12);
        studentVo.setClazzId(1);
        try {
            iUserService.saveStudent(studentVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdateStudent(){
        StudentVo studentVo=new StudentVo();
        studentVo.setId(6);
        studentVo.setAddress("test");
        studentVo.setAdmissiontime(new Date());
        studentVo.setBirthday(new Date());
        studentVo.setClazzId(1);
        studentVo.setName("ljj5");
        studentVo.setSex(Sex.MALE);
        studentVo.setNativeplace("test");
        studentVo.setPostcode("518116");
        studentVo.setProfession("test");
        studentVo.setUid("2666666");
        studentVo.setUserId(12);
        studentVo.setClazzId(2);
        try {
            iUserService.updateStudent(studentVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStudentDelete(){
        StudentVo studentVo=new StudentVo();
        studentVo.setId(6);
        try {
            iUserService.deleteStudent(studentVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectStudents(){
        StudentVo studentVo=new StudentVo();
        studentVo.setName("l");
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(2);
        try {
            iUserService.selectStudents(studentVo,pageModel);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testSaveTeacher(){
        TeacherVo teacherVo=new TeacherVo();
        teacherVo.setAddress("test");
        teacherVo.setEntertime(new Date());
        teacherVo.setBirthday(new Date());
        teacherVo.setJobId(1);
        teacherVo.setName("ljj6");
        teacherVo.setSex(Sex.MALE);
        teacherVo.setDescription("Java 10年工作经验");
        teacherVo.setUid("266666655");
        teacherVo.setUserId(17);
        try {
            iUserService.saveTeacher(teacherVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdateTeacher(){
        TeacherVo teacherVo=new TeacherVo();
        teacherVo.setId(6);
        teacherVo.setAddress("test");
        teacherVo.setBirthday(new Date());
        teacherVo.setName("ljj6");
        teacherVo.setSex(Sex.MALE);
        teacherVo.setUid("26666666");
        teacherVo.setJobId(2);
//        teacherVo.setImageId(5);
        try {
            iUserService.updateTeacher(teacherVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTeacherDelete(){
        TeacherVo teacherVo=new TeacherVo();
        teacherVo.setId(6);
        try {
            iUserService.deleteTeacher(teacherVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectTeachers(){
        TeacherVo teacherVo=new TeacherVo();
        teacherVo.setName("l");
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(2);
        try {
            iUserService.selectTeachers(teacherVo,pageModel);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveRole(){
        RoleVo roleVo=new RoleVo();
        roleVo.setName("Role_test5");
        roleVo.setDescription("测试");
        roleVo.setMenuIds(Arrays.asList(8,9,10));
        try {
            iUserService.saveRole(roleVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateRole(){
        RoleVo roleVo=new RoleVo();
        roleVo.setId(8);
        roleVo.setName("Role_test5");
        roleVo.setDescription("测试2");
        try {
            iUserService.updateRole(roleVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteRole(){
        RoleVo roleVo=new RoleVo();
        roleVo.setId(8);
        try {
            iUserService.deleteRole(roleVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectRoles(){
        RoleVo roleVo=new RoleVo();
        roleVo.setName("R");
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(5);
        try {
            iUserService.selectRoles(roleVo,pageModel);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveMenu(){
        MenuVo menuVo=new MenuVo();
        menuVo.setPattern("test5/**");
        menuVo.setRoleIds(Arrays.asList(1,2,3));
        try {
            iUserService.saveMenu(menuVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateMenu(){
        MenuVo menuVo=new MenuVo();
        menuVo.setId(11);
        menuVo.setPattern("/test8/**");
        try {
            iUserService.updateMenu(menuVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteMenu(){
        MenuVo menuVo=new MenuVo();
        menuVo.setId(11);
        try {
            iUserService.deleteMenu(menuVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectMenus(){
        MenuVo menuVo=new MenuVo();
        menuVo.setPattern("/");
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(5);
        try {
            iUserService.selectMenus(menuVo,pageModel);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateRoleMenus(){
        RoleVo roleVo=new RoleVo();
        roleVo.setId(7);
        roleVo.setMenuIds(Arrays.asList(3,4));
        try {
            iUserService.updateRoleMenus(roleVo);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testServiceUtil(){
        try {
            Student student=daoUtil.checkEntityById(StudentDao.class,
                    Student.class,5);
            serviceUtil.checkRelationEntityByIdAndAssignButNull(student,
                    ClazzDao.class, Clazz.class,null);
            System.out.println(student.getClazz());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testServiceUtilOrdinalSelectEntity()  {
        StudentVo studentVo=new StudentVo();
        studentVo.setName("l");
        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(2);
        try {
            List<Student> students=serviceUtil.ordinalSelectEntity(StudentDao.class,Student.class,studentVo,pageModel);
            students=serviceUtil.ordinalSelectEntity(StudentDao.class,Student.class,null,null);
            System.out.println(students);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testServiceUtilInsertNNRElationEntity(){
        User user=new User();
        user.setPassword("123");
        user.setUsername("hyp5");
        userDao.save(user);
        try {
            serviceUtil.insertNNRElationEntity(UserDao.class,User.class,user, RoleDao.class, Role.class,null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

}
