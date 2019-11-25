package org.zhl.scs.util;

import org.springframework.context.ApplicationContext;
import org.zhl.scs.domain.Clazz;
import org.zhl.scs.exception.EntityNotFoundException;
import org.zhl.scs.exception.IllegalValueException;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service层工具类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/15
 */
public class ServiceUtil {
    private final static String COUNT="count";
    private final static String SELECT_BY_PAGE="selectByPage";
    private final static String VO_IDS_SUFFIX="Ids";
    private final static String SELECT_BY_IDS="selectByIds";
    private final static String INSERT_NN_ENTITYS_PREFIXX="insert";
    private ApplicationContext applicationContext;//spring 应用上下文
    private DaoUtil daoUtil;//dao层工具实例

    public DaoUtil getDaoUtil() {
        return daoUtil;
    }

    /**
     * 业务层工具类
     * @param applicationContext 应用上下文实例
     * @param daoUtil dao层工具类实例
     */
    public ServiceUtil(ApplicationContext applicationContext, DaoUtil daoUtil) {
        this.applicationContext = applicationContext;
        this.daoUtil = daoUtil;
    }

    /**
     * 根据关联实体id检测关联实体是否存在，存在则赋值；若id为null，结束方法
     * @param entity 主实体实例
     * @param relationDaoClazz 关联实体dao类
     * @param relationEntityClazz 关联实体类
     * @param relationId 关联实体id
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalClassFormatException
     * @throws EntityNotFoundException
     */
    public void checkRelationEntityByIdAndAssignButNull(Object entity, Class<?> relationDaoClazz, Class<?> relationEntityClazz, Integer relationId) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IllegalClassFormatException, EntityNotFoundException {
        if (relationId==null) return;//当关联id为null时结束方法
        Object relationEntity=daoUtil.checkEntityById(relationDaoClazz,
                relationEntityClazz,relationId);//该id关联实体实例
        String setRelationEntityName="set"+relationEntityClazz.getSimpleName();//setter方法名
        Method setRelationEntity=entity.getClass().getMethod(setRelationEntityName,relationEntityClazz);
        setRelationEntity.invoke(entity,relationEntity);//赋值关联实体
    }

    /**
     * 单体查询，单体分页查询
     * @param daoClazz dao类
     * @param entityClazz 实体类
     * @param entityVo 实体vo类实例
     * @param pageModel 分页模型类实例
     * @param <T> 实体类型
     * @return 返回条件的实体List<T>集合
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public <T> List<T> ordinalSelectEntity(Class<?> daoClazz,Class<?> entityClazz,Object entityVo, PageModel pageModel) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map<String,Object> params=new HashMap<>();
        Object entity=entityClazz.getDeclaredConstructor().newInstance();
        Object dao=applicationContext.getBean(daoClazz);
        if (entityVo!=null){
            AssignByFieldName.getInstance().Assign(entityVo,entity);
            String entityInstanceName = getDefaultInstanceName(entityClazz.getSimpleName());
            params.put(entityInstanceName,entity);
        }
        if (pageModel!=null){
            Method count=daoClazz.getMethod(COUNT,Map.class);
            pageModel.setRecordCount((Integer) count.invoke(dao,params));
            params.put("pageModel",pageModel);
        }
        Method selectByPage=daoClazz.getMethod(SELECT_BY_PAGE,Map.class);
        return (List<T>) selectByPage.invoke(dao,params);
    }

    /**
     * 根据简单类名获取默认实例名称（首字母小写）
     * @param simpleName 简单类名
     * @return 默认实例名称
     */
    private String getDefaultInstanceName(String simpleName) {
        return simpleName.substring(0,1).toLowerCase()+simpleName.substring(1);
    }

    public void insertNNRElationEntity(Class<?> daoClazz, Class<?> entityClazz, Object entity,
                                       Class<?> relationDaoCLazz, Class<?> relationEntityClazz,
                                       List<Integer> relationIds) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IllegalValueException {
        if (relationIds==null || relationIds.size()<=0) return;//关联id集合为空或数量小于0，结束方法
        Object dao=applicationContext.getBean(daoClazz);
        Object relationDao=applicationContext.getBean(relationDaoCLazz);
        Map<String,Object> params=new HashMap<>();
        String relationEntityName=getDefaultInstanceName(relationEntityClazz.getSimpleName());
        params.put(relationEntityName+VO_IDS_SUFFIX,relationIds);
        Method selectByIds=relationDaoCLazz.getMethod(SELECT_BY_IDS,Map.class);
        List<Object> relationEntitys= (List<Object>) selectByIds.invoke(relationDao,params);
        if (relationEntitys.size()!=relationIds.size())
            throw new IllegalValueException(relationEntityClazz);//id值不合法
        String setRelationEntityName="set"+relationEntityClazz.getSimpleName()+"s";
        Method setRelationEntity=entityClazz.getMethod(setRelationEntityName,List.class);
        setRelationEntity.invoke(entity,relationEntitys);
        String insertRelationEntitysName
                =INSERT_NN_ENTITYS_PREFIXX+relationEntityClazz.getSimpleName()+"s";
        Method insertRelationEntitys=daoClazz.getMethod(insertRelationEntitysName,entityClazz);
        insertRelationEntitys.invoke(dao,entity);
    }
}
