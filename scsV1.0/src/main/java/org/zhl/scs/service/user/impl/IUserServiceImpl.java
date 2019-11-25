package org.zhl.scs.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhl.scs.dao.*;
import org.zhl.scs.domain.*;
import org.zhl.scs.domain.vo.*;
import org.zhl.scs.exception.EntityNotFoundException;
import org.zhl.scs.exception.IllegalValueException;
import org.zhl.scs.service.user.IUserService;
import org.zhl.scs.util.AssignByFieldName;
import org.zhl.scs.util.DaoUtil;
import org.zhl.scs.util.PageModel;
import org.zhl.scs.util.ServiceUtil;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理业务逻辑类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    private final static Logger logger= LoggerFactory.getLogger(IUserService.class);
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    MenuDao menuDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    ClazzDao clazzDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DaoUtil daoUtil;

    @Autowired
    ServiceUtil serviceUtil;

    @Override
    public void saveUser(UserVo userVo) throws InvocationTargetException, IllegalAccessException, IllegalValueException, NoSuchMethodException {
        //如果用户名存在，返回错误
        if (userVo.getUsername()==null || "".equals(userVo.getUsername()) || userDao.loadUserByUsername(userVo.getUsername()) != null) {
            logger.debug("用户名已存在");
            throw new IllegalValueException(UserVo.class);
        }
        User user=new User();
        AssignByFieldName.getInstance().Assign(userVo,user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        logger.debug("新增用户成功："+user);
//        if (userVo.getRoleIds()!=null && userVo.getRoleIds().size()>0){
//            Map<String,Object> params=new HashMap<>();
//            params.put("roleIds",userVo.getRoleIds());
//            List<Role> roles=roleDao.selectByIds(params);
//            if (roles.size()!=userVo.getRoleIds().size()){//角色id值不合法
//                throw new IllegalValueException(UserVo.class);
//            }
//            user.setRoles(roles);
//            userDao.insertRoles(user);
//            logger.debug("添加用户角色成功："+user.getUsername()+"的角色信息："+user.getRoles());
//        }
        serviceUtil.insertNNRElationEntity(UserDao.class,User.class,user,RoleDao.class,Role.class,userVo.getRoleIds());
    }

    @Override
    public void updateUser(UserVo userVo) throws IllegalValueException, EntityNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, IllegalClassFormatException {
        //验证userVo数据合法性
//        if ((userVo.getId()==null || userVo.getId()<0)//无id参数
////            || (userVo.getStudentId()!=null &&userVo.getStudentId()<0)//学生id!=null 且 id<0
////            || (userVo.getTeacherId()!=null && userVo.getTeacherId()<0)//教师id!+null 且 id<0
////            || (userVo.getStudentId()!=null && userVo.getTeacherId()!=null)//学生id 与教师id都!=null
//        ){//不合理参数值
//            throw new IllegalValueException(UserVo.class);
//        }
        User user=daoUtil.checkEntityById(UserDao.class,User.class,userVo.getId());//userDao.selectById(userVo.getId());
//        if (user==null){//无该id实体
//            throw new EntityNotFoundException(userVo.getId(),User.class);
//        }
        AssignByFieldName.getInstance().Assign(userVo,user);
        userDao.update(user);
        logger.debug("修改用户成功："+user);
    }

    @Override
    public void deleteUser(UserVo userVo) throws IllegalValueException, EntityNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, InvocationTargetException {
//        if (userVo.getId()==null || userVo.getId()<0){//无id参数
//            throw new IllegalValueException(UserVo.class);
//        }
        User user=daoUtil.checkEntityById(UserDao.class,User.class,userVo.getId());//userDao.selectById(userVo.getId());
//        if (user==null){//无该id实体
//            throw new EntityNotFoundException(userVo.getId(),User.class);
//        }
        //用户修改为不可用
        user.setEnable(false);
        userDao.update(user);
        logger.debug("注销用户成功："+user);
    }


    @Override
    public User selectUserById(int id) throws IllegalValueException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
//        if (id<0){
//            throw new IllegalValueException(User.class);
//        }
        return daoUtil.checkEntityById(UserDao.class,User.class,id);//userDao.selectById(id);
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public List<User> selectUsers(UserVo userVo, PageModel pageModel) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
//        Map<String,Object> params=new HashMap<>();
//        User user=new User();
//        if (userVo!=null){
//            AssignByFieldName.getInstance().Assign(userVo,user);
//            params.put("user",user);
//        }
//        if (pageModel!=null){
//            pageModel.setRecordCount(userDao.count(params));
//            params.put("pageModel",pageModel);
//        }
//        return userDao.selectByPage(params);
        return serviceUtil.ordinalSelectEntity(UserDao.class,User.class,userVo,pageModel);
    }

    @Override
    public User selectUser(UserVo userVo) {
        return null;
    }

    @Override
    public void deleteUsers(List<Integer> idList) throws EntityNotFoundException, InvocationTargetException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException {
        for (Integer id:
             idList) {
            UserVo userVo=new UserVo();
            userVo.setId(id);
            deleteUser(userVo);
        }
    }

    @Override
    public void saveStudent(StudentVo studentVo) throws InvocationTargetException, IllegalAccessException, IllegalValueException, EntityNotFoundException, NoSuchMethodException, IllegalClassFormatException {
//        if ((studentVo.getUserId()==null || studentVo.getUserId()<0)
//                || (studentVo.getClazzId()==null || studentVo.getClazzId()<0)
//        ){
//            throw new IllegalValueException(StudentVo.class);
//        }
        User user=daoUtil.checkEntityById(UserDao.class,User.class,studentVo.getUserId());//userDao.selectById(studentVo.getUserId());
        Clazz clazz=daoUtil.checkEntityById(ClazzDao.class,Clazz.class,studentVo.getClazzId());//clazzDao.selectById(studentVo.getClazzId());
//        if (user==null){
//            throw new EntityNotFoundException(studentVo.getUserId(),User.class);
//        }else if (clazz == null){
//            throw new EntityNotFoundException(studentVo.getClazzId(),Clazz.class);
//        }
        Student student=new Student();
        AssignByFieldName.getInstance().Assign(studentVo,student);
        student.setUser(user);
        student.setClazz(clazz);
        studentDao.save(student);
        logger.debug("新增学生成功："+student);
    }

    @Override
    public void updateStudent(StudentVo studentVo) throws IllegalValueException, EntityNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, IllegalClassFormatException {
//        if (studentVo.getId()==null || studentVo.getId()<0){
//            throw new IllegalValueException(StudentVo.class);
//        }
        Student student=daoUtil.checkEntityById(StudentDao.class,Student.class,studentVo.getId());//studentDao.selectById(studentVo.getId());
//        if (student==null){
//            throw new EntityNotFoundException(studentVo.getId(),Student.class);
//        }
        AssignByFieldName.getInstance().Assign(studentVo,student);
//        if (studentVo.getClazzId()!=null){
////            if (studentVo.getClazzId()<0) throw new IllegalValueException(StudentVo.class);
//            Clazz clazz=daoUtil.checkEntityById(ClazzDao.class,Clazz.class,studentVo.getClazzId());//clazzDao.selectById(studentVo.getClazzId());
////            if (clazz==null){
////
////            }
//            student.setClazz(clazz);
//        }
        serviceUtil.checkRelationEntityByIdAndAssignButNull(student,ImageDao.class,Image.class,studentVo.getImageId());
        serviceUtil.checkRelationEntityByIdAndAssignButNull(student,ClazzDao.class,Clazz.class,studentVo.getClazzId());

        studentDao.update(student);
    }

    @Override
    public void deleteStudent(StudentVo studentVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        Student student=daoUtil.checkEntityById(StudentDao.class,Student.class,studentVo.getId());
        //注销该学生用户
        student.getUser().setEnable(false);
        userDao.update(student.getUser());
    }

    @Override
    public Student selectStudentById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        return daoUtil.checkEntityById(StudentDao.class,Student.class,id);
    }

    @Override
    public Student selectStudent(Object item) {
        return null;
    }

    @Override
    public List<Student> selectStudents( StudentVo studentVo,  PageModel pageModel) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
//        Map<String,Object> params=new HashMap<>();
//        Student student=new Student();
//        if (studentVo!=null){
//            AssignByFieldName.getInstance().Assign(studentVo,student);
//            params.put("student",student);
//        }
//        if (pageModel!=null){
//            pageModel.setRecordCount(studentDao.count(params));
//            params.put("pageModel",pageModel);
//        }
//        return studentDao.selectByPage(params);
        return serviceUtil.ordinalSelectEntity(StudentDao.class,Student.class,studentVo,pageModel);
    }

    @Override
    public Integer getUserCountByKeywords(UserVo userVo) throws InvocationTargetException, IllegalAccessException {
        Map<String,Object> params=new HashMap<>();
        User user=new User();
        AssignByFieldName.getInstance().Assign(userVo, user);
        params.put("user",user);
        return userDao.count(params);
    }

    @Override
    public void saveTeacher(TeacherVo teacherVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        User user=daoUtil.checkEntityById(UserDao.class,User.class,teacherVo.getUserId());
        Job job=daoUtil.checkEntityById(JobDao.class,Job.class,teacherVo.getJobId());
        Teacher teacher=new Teacher();
        AssignByFieldName.getInstance().Assign(teacherVo,teacher);
        teacher.setUser(user);
        teacher.setJob(job);
        teacherDao.save(teacher);
    }

    @Override
    public void updateTeacher(TeacherVo teacherVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        Teacher teacher=daoUtil.checkEntityById(TeacherDao.class,Teacher.class,teacherVo.getId());
        AssignByFieldName.getInstance().Assign(teacherVo,teacher);
        serviceUtil.checkRelationEntityByIdAndAssignButNull(teacher,JobDao.class,Job.class,teacherVo.getJobId());
        serviceUtil.checkRelationEntityByIdAndAssignButNull(teacher,ImageDao.class,Image.class,teacherVo.getImageId());
        teacherDao.update(teacher);
    }

    @Override
    public void deleteTeacher(TeacherVo teacherVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        Teacher teacher=daoUtil.checkEntityById(TeacherDao.class,Teacher.class,teacherVo.getId());
        //注销该教师用户
        teacher.getUser().setEnable(false);
        userDao.update(teacher.getUser());
    }

    @Override
    public Teacher selectTeacherById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        return daoUtil.checkEntityById(TeacherDao.class,Teacher.class,id);
    }

    @Override
    public List<Teacher> selectTeachers(TeacherVo teacherVo,PageModel pageModel) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return serviceUtil.ordinalSelectEntity(TeacherDao.class,Teacher.class,teacherVo,pageModel);
    }

    @Override
    public Teacher selectTeacher(Object item) {
        return null;
    }

    @Override
    public User updateUserRoles(UserVo userVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException, IllegalValueException {
        //验证数据
        if (userVo.getRoleIds()==null || userVo.getRoleIds().size()<=0){
            throw new IllegalValueException(UserVo.class);
        }
        User user=daoUtil.checkEntityById(UserDao.class,User.class,userVo.getId());
        List<Role> roles=new ArrayList<>();
        for (int roleId:userVo.getRoleIds()
             ) {
            Role role=new Role();
            role.setId(roleId);
            roles.add(role);
        }
        userDao.deleteRoles(user);
        user.setRoles(roles);
        userDao.insertRoles(user);
        return user;
    }

    @Override
    public void saveRole(RoleVo roleVo) throws InvocationTargetException, IllegalAccessException, IllegalValueException, NoSuchMethodException {
        Role role=new Role();
        AssignByFieldName.getInstance().Assign(roleVo,role);
        roleDao.save(role);
        logger.debug("新增角色成功："+role);
//        if (roleVo.getMenuIds()!=null && roleVo.getMenuIds().size()>0){
//            Map<String,Object> params=new HashMap<>();
//            params.put("menuIds",roleVo.getMenuIds());
//            List<Menu> menus = menuDao.selectByIds(params);
//            if (menus.size()!=roleVo.getMenuIds().size()){//资源id值不合法
//                throw new IllegalValueException(RoleVo.class);
//            }
//            role.setMenus(menus);
//            roleDao.insertMenus(role);
//            logger.debug("添加角色资源成功："+role.getName()+"的资源信息："+role.getMenus());
//        }
        serviceUtil.insertNNRElationEntity(RoleDao.class,Role.class,role,MenuDao.class,Menu.class,roleVo.getMenuIds());
//        logger.debug("添加角色资源成功："+role.getName()+"的资源信息："+role.getMenus());
    }

    @Override
    public void updateRole(RoleVo roleVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        Role role=daoUtil.checkEntityById(RoleDao.class,Role.class,roleVo.getId());
        AssignByFieldName.getInstance().Assign(roleVo,role);
        roleDao.update(role);
        logger.debug("修改角色成功");

    }

    @Override
    public void deleteRole(RoleVo roleVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        Role role=daoUtil.checkEntityById(RoleDao.class,Role.class,roleVo.getId());
        roleDao.deleteUsers(role);
        roleDao.deleteMenus(role);
        roleDao.deleteById(role.getId());
    }

    @Override
    public Role selectRoleById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        return daoUtil.checkEntityById(RoleDao.class,Role.class,id);
    }

    @Override
    public List<Role> selectRoles(RoleVo roleVo, PageModel pageModel) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return serviceUtil.ordinalSelectEntity(RoleDao.class,Role.class,roleVo,pageModel);
    }

    @Override
    public void saveMenu(MenuVo menuVo) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IllegalValueException {
        Menu menu=new Menu();
        AssignByFieldName.getInstance().Assign(menuVo,menu);
        menuDao.save(menu);
        serviceUtil.insertNNRElationEntity(MenuDao.class,Menu.class,menu,RoleDao.class,Role.class,menuVo.getRoleIds());
    }

    @Override
    public void updateMenu(MenuVo menuVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        Menu menu=daoUtil.checkEntityById(MenuDao.class,Menu.class,menuVo.getId());
        AssignByFieldName.getInstance().Assign(menuVo,menu);
        menuDao.update(menu);
    }

    @Override
    public void deleteMenu(MenuVo menuVo) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        Menu menu=daoUtil.checkEntityById(MenuDao.class,Menu.class,menuVo.getId());
        menuDao.deleteRoles(menu);
        menuDao.deleteById(menu.getId());

    }

    @Override
    public Menu selectMenuById(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        return daoUtil.checkEntityById(MenuDao.class,Menu.class,id);
    }

    @Override
    public List<Menu> selectMenus(MenuVo menuVo, PageModel pageModel) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return serviceUtil.ordinalSelectEntity(MenuDao.class,Menu.class,menuVo,pageModel);
    }

    @Override
    public Role updateRoleMenus(RoleVo roleVo) throws IllegalValueException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        //验证数据
        if (roleVo.getMenuIds()==null || roleVo.getMenuIds().size()<=0){
            throw new IllegalValueException(RoleVo.class);
        }
        Role role=daoUtil.checkEntityById(RoleDao.class,Role.class,roleVo.getId());
        List<Menu> menus=new ArrayList<>();
        for (int menuId:roleVo.getMenuIds()
        ) {
            Menu menu=new Menu();
            menu.setId(menuId);
            menus.add(menu);
        }
        roleDao.deleteMenus(role);
        role.setMenus(menus);
        roleDao.insertMenus(role);
        return role;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在!");
        }
        user.setRoles(roleDao.selectByUserId(user.getId()));
        return user;
    }
}
