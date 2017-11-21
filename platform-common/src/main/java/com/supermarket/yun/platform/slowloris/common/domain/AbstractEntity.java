package com.supermarket.yun.platform.slowloris.common.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 抽象实体基类
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/15 20:38
 */
public abstract class AbstractEntity<ID> extends BaseEntity {

    public abstract ID getId();

    public abstract void setId(ID id);

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Persistable#isNew()
     *
     */
    public boolean isNew() {

        return null == getId();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked")
        AbstractEntity<ID> that = (AbstractEntity<ID>) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
