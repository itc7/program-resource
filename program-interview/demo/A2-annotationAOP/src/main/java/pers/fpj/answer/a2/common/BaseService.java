package pers.fpj.answer.a2.common;

import java.util.List;

/**
 * created by fpj on 2017/11/18 23:02.
 */
public interface BaseService<Domain, Id> {
    boolean add(Domain domain);
    Domain get(Id id);
    List<Domain> list();
    boolean delete(Id id);
    boolean update(Domain domain);
}
