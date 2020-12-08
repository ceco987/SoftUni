package orm;

import orm.annotation.Column;
import orm.annotation.Entity;
import orm.annotation.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//TODO: unfinished, copy the instructions when you feel like it
public class EntityManager<E> implements Dbcontext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);
        if (value == null || (int)value <= 0){
            return this.doInsert(entity,primary);
        }
        return this.doUpdate (entity,primary);
    }


    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }

    private Field getId(Class entity){
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(()->new UnsupportedOperationException("Entity does not have a primary key"));
    }

    private boolean doInsert(E entity, Field primary) {
        String tableName = getTableName(entity.getClass());
        List<String> fieldName = getFieldNames (entity);
        List<String> fieldValues = getFieldValues (entity);
        return false;
    }


    private boolean doUpdate(E entity, Field primary) {
        return false;
    }

    private String getTableName(Class<?> entity){
        Entity entityAnnotation = entity.getAnnotation(Entity.class);
        if(entityAnnotation != null && entityAnnotation.name().length()>0){
            return entityAnnotation.name();
        }
        else{
            return entity.getSimpleName();
        }
    }
    private List<String> getFieldValues(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(getFieldValue())
                .collect(Collectors.toList());
    }

    private Function<Field, String> getFieldValue() {
        return field -> {
            field.setAccessible(true);
            return field.getAnnotation(Column.class).name();
        };
    }

    private List<String> getFieldNames(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(getFieldValue())
                .collect(Collectors.toList());
    }

}
