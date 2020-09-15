package java3.homeworkfour;

import java.util.List;

@FunctionalInterface
public interface GenericInter<T> {

    List<?> getValue(List<T> t);
}
