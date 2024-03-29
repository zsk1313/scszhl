package org.zhl.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zhl.scs.domain.Menu;
import org.zhl.scs.domain.Role;
import org.zhl.scs.domain.User;
import org.zhl.scs.domain.vo.MenuVo;
import org.zhl.scs.domain.vo.RoleVo;
import org.zhl.scs.domain.vo.UserVo;
import org.zhl.scs.exception.EntityNotFoundException;
import org.zhl.scs.exception.IllegalValueException;
import org.zhl.scs.reponse.RespBean;
import org.zhl.scs.service.user.IUserService;
import org.zhl.scs.util.PageModel;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 前台用户控制器类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @RequestMapping("/basic")
    public String basic() {
        System.out.println("basic");
        return "basic";
    }
//    @RequestMapping("/")
//    public String  hello() {
//        return "Hello";
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)

    /**
     * 分页搜索用户
     * @param userVo 用户vo实例
     * @param pageModel 分页模型实例
     * @return
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @GetMapping(value = "/user")
    public Map<String,Object> getUserByPage(UserVo userVo,PageModel pageModel) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println(userVo);
        Map<String, Object> map = new HashMap<>();
        List<User> users=iUserService.selectUsers(userVo,pageModel);
        map.put("users",users);
        map.put("count",pageModel.getRecordCount());
        return map;
    }

    /**
     * 批量删除用户
     * @param ids 用户id集合字符串，用","分隔（1,2,3)
     * @return
     * @throws EntityNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalClassFormatException
     * @throws IllegalAccessException
     * @throws IllegalValueException
     * @throws NoSuchMethodException
     */
    @DeleteMapping(value = "/{ids}")
    public RespBean deleteUserByIds(@PathVariable String ids) throws EntityNotFoundException, InvocationTargetException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException {
        System.out.println(ids);
        String[] split = ids.split(",");
        List<Integer> idList=new ArrayList<>();
        for (String id:split
             ) {
            idList.add(Integer.valueOf(id));
        }
        iUserService.deleteUsers(idList);
        return RespBean.ok("批量删除用户成功");
    }

    /**
     * 添加用户
     * @param userVo 用户vo实例
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalValueException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @PostMapping(value = "/add")
    public RespBean addUser(UserVo userVo) throws NoSuchMethodException, IllegalValueException, IllegalAccessException, InvocationTargetException {
        System.out.println(userVo.getRoleIds());
        iUserService.saveUser(userVo);
        return RespBean.ok("添加用户成功");
    }

    /**
     * 修改用户
     * @param userVo 用户vo实例
     * @return
     * @throws EntityNotFoundException
     * @throws IllegalClassFormatException
     * @throws IllegalAccessException
     * @throws IllegalValueException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @PutMapping(value = "/update")
    public RespBean updateUser(UserVo userVo) throws EntityNotFoundException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException, InvocationTargetException {
        iUserService.updateUser(userVo);
        System.out.println(userVo);
        return RespBean.ok("更新用户成功");
    }

    /**
     * 分页搜索角色
     * @param roleVo 角色vo实例
     * @param pageModel 分页模型实例
     * @return
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @GetMapping(value = "/role")
    public Map<String,Object> getRoleByPage(RoleVo roleVo, PageModel pageModel) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println((roleVo==null)+" "+roleVo);
        Map<String, Object> map = new HashMap<>();
        List<Role> roles=iUserService.selectRoles(roleVo,pageModel);
        map.put("roles",roles);
        map.put("count",pageModel.getRecordCount());
        return map;
    }

    /**
     * 批量删除角色
     * @param ids 角色id集合字符串，用","分隔（1,2,3)
     * @return
     * @throws EntityNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalClassFormatException
     * @throws IllegalAccessException
     * @throws IllegalValueException
     * @throws NoSuchMethodException
     */
    @DeleteMapping(value = "/role/{ids}")
    public RespBean deleteURoleByIds(@PathVariable String ids) throws EntityNotFoundException, InvocationTargetException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException {
        String[] split = ids.split(",");
        List<Integer> idList=new ArrayList<>();
        for (String id:split
        ) {
            idList.add(Integer.valueOf(id));
        }
        iUserService.deleteRoles(idList);
        return RespBean.ok("批量删除角色成功");
    }

    /**
     * 添加角色
     * @param roleVo 角色vo实例
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalValueException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @PostMapping(value = "/role/add")
    public RespBean addRole(RoleVo  roleVo) throws NoSuchMethodException, IllegalValueException, IllegalAccessException, InvocationTargetException {
        iUserService.saveRole(roleVo);
        return RespBean.ok("添加角色成功");
    }

    /**
     * 修改角色
     * @param roleVo 角色vo实例
     * @return
     * @throws EntityNotFoundException
     * @throws IllegalClassFormatException
     * @throws IllegalAccessException
     * @throws IllegalValueException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @PutMapping(value = "/role/update")
    public RespBean updateRole(RoleVo roleVo) throws EntityNotFoundException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException, InvocationTargetException {
        iUserService.updateRole(roleVo);
        return RespBean.ok("更新角色成功");
    }


    /**
     * 分页搜索资源
     * @param menuVo 资源vo实例
     * @param pageModel 分页模型实例
     * @return
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @GetMapping(value = "/menu")
    public Map<String,Object> getRoleByPage(MenuVo menuVo, PageModel pageModel) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> map = new HashMap<>();
        List<Menu> menus=iUserService.selectMenus(menuVo,pageModel);
        map.put("menus",menus);
        map.put("count",pageModel.getRecordCount());
        return map;
    }

    /**
     * 批量删除资源
     * @param ids 资源id集合字符串，用","分隔（1,2,3)
     * @return
     * @throws EntityNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalClassFormatException
     * @throws IllegalAccessException
     * @throws IllegalValueException
     * @throws NoSuchMethodException
     */
    @DeleteMapping(value = "/menu/{ids}")
    public RespBean deleteMenuByIds(@PathVariable String ids) throws EntityNotFoundException, InvocationTargetException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException {
        String[] split = ids.split(",");
        List<Integer> idList=new ArrayList<>();
        for (String id:split
        ) {
            idList.add(Integer.valueOf(id));
        }
        iUserService.deleteMenus(idList);
        return RespBean.ok("批量删除资源成功");
    }

    /**
     * 添加角色
     * @param menuVo 资源vo实例
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalValueException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @PostMapping(value = "/menu/add")
    public RespBean addMenu(MenuVo  menuVo) throws NoSuchMethodException, IllegalValueException, IllegalAccessException, InvocationTargetException {
        iUserService.saveMenu(menuVo);
        return RespBean.ok("添加资源成功");
    }

    /**
     * 修改资源
     * @param menuVo 资源vo实例
     * @return
     * @throws EntityNotFoundException
     * @throws IllegalClassFormatException
     * @throws IllegalAccessException
     * @throws IllegalValueException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @PutMapping(value = "/menu/update")
    public RespBean updateMenu(MenuVo menuVo) throws EntityNotFoundException, IllegalClassFormatException, IllegalAccessException, IllegalValueException, NoSuchMethodException, InvocationTargetException {
        iUserService.updateMenu(menuVo);
        return RespBean.ok("更新资源成功");
    }
}
