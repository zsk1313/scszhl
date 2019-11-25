package org.zhl.scs.util.common;

/**
 * 性别枚举类
 */
public enum Sex {
    MALE("男"),FEMALE("女");
    private String nameZh;
    Sex(String nameZh){
        this.nameZh=nameZh;
    }
    public String getNameZh(){
        return nameZh;
    }
    public static Sex getSexByOrdinal(int ordinal){
        for (Sex sex:Sex.values()
             ) {
            if (sex.ordinal()==ordinal) return sex;
        }
        return null;
    }
}
