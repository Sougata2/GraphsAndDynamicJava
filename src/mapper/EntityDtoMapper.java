package mapper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;


/**
 * Entity to Dto | Dto to Entity [one-many]
 */
public class EntityDtoMapper {
    private record ChildParentPair<C, P>(C child, P parent) {

    }


    public static MasterEntity mapToEntity(MasterDto dto, Map<Class<? extends MasterDto>, Class<? extends MasterEntity>> dtoEntityMap) {
        try {

            // no adj required as the entity already have the node.
            Queue<ChildParentPair<MasterDto, MasterEntity>> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            visited.add(dto.hashCode());

            queue.offer(new ChildParentPair<>(dto, null));
            MasterEntity convertedEntity = null;

            while (!queue.isEmpty()) {
                ChildParentPair<MasterDto, MasterEntity> u = queue.poll();
                System.out.println(u.child);
                Class<? extends MasterEntity> entityClass = dtoEntityMap.get(u.child.getClass());
                MasterEntity v = entityClass.getDeclaredConstructor().newInstance();

                for (Field df : u.child.getClass().getDeclaredFields()) {
                    df.setAccessible(true);
                    Field vfield = v.getClass().getDeclaredField(df.getName());
                    vfield.setAccessible(true);

                    if (Collection.class.isAssignableFrom(df.getType())) {
                        Object relation = df.get(u.child);
                        Collection<?> list = (Collection<?>) relation;
                        for (Object ele : list) {
                            if (ele instanceof MasterDto) {
                                if (!visited.contains(ele.hashCode())) {
                                    visited.add(ele.hashCode());
                                    queue.offer(new ChildParentPair<>((MasterDto) ele, v));
                                }
                            }
                        }
                        vfield.set(v, new ArrayList<MasterEntity>());
                    } else if (!isSimpleType(df)) {
                        // set the parent object in the child v.
                        if (u.parent != null && u.parent.getClass().isAssignableFrom(vfield.getType())) {
                            vfield.set(v, u.parent);
                        }
                    } else {
                        Object uValue = df.get(u.child);
                        vfield.set(v, uValue);
                    }
                }

                // set the child in the relation list of parent
                if (u.parent != null) {
                    for (Field parentField : u.parent.getClass().getDeclaredFields()) {
                        parentField.setAccessible(true);

                        if (Collection.class.isAssignableFrom(parentField.getType())) {
                            Type genericType = parentField.getGenericType();
                            if (genericType instanceof ParameterizedType) {
                                Type actualType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                                if (actualType == v.getClass()) {
                                    Collection<MasterEntity> relation = (Collection<MasterEntity>) parentField.get(u.parent);
                                    relation.add(v);
                                }
                            }
                        }
                    }
                } else {
                    convertedEntity = v;
                }
            }
            return convertedEntity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static MasterDto mapToDto(MasterEntity entity, Map<Class<? extends MasterEntity>, Class<? extends MasterDto>> entityDtoMap) {
        try {

            // no adj required as the entity already have the node.
            Queue<ChildParentPair<MasterEntity, MasterDto>> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            visited.add(entity.hashCode());

            queue.offer(new ChildParentPair<>(entity, null));
            MasterDto convertedDto = null;

            while (!queue.isEmpty()) {
                ChildParentPair<MasterEntity, MasterDto> u = queue.poll();
                //System.out.println(u.child);
                Class<? extends MasterDto> dtoClass = entityDtoMap.get(u.child.getClass());
                MasterDto v = dtoClass.getDeclaredConstructor().newInstance();

                for (Field df : u.child.getClass().getDeclaredFields()) {
                    df.setAccessible(true);
                    Field vfield = v.getClass().getDeclaredField(df.getName());
                    vfield.setAccessible(true);

                    if (Collection.class.isAssignableFrom(df.getType())) {
                        Object relation = df.get(u.child);
                        Collection<?> list = (Collection<?>) relation;
                        for (Object ele : list) {
                            if (ele instanceof MasterEntity) {
                                if (!visited.contains(ele.hashCode())) {
                                    visited.add(ele.hashCode());
                                    queue.offer(new ChildParentPair<>((MasterEntity) ele, v));
                                }
                            }
                        }
                        vfield.set(v, new ArrayList<MasterEntity>());
                    } else if (!isSimpleType(df)) {
                        // set the parent object in the child v.
                        if (u.parent != null && u.parent.getClass().isAssignableFrom(vfield.getType())) {
                            vfield.set(v, u.parent);
                        }
                    } else {
                        Object uValue = df.get(u.child);
                        vfield.set(v, uValue);
                    }
                }

                // set the child in the relation list of parent
                if (u.parent != null) {
                    for (Field parentField : u.parent.getClass().getDeclaredFields()) {
                        parentField.setAccessible(true);

                        if (Collection.class.isAssignableFrom(parentField.getType())) {
                            Type genericType = parentField.getGenericType();
                            if (genericType instanceof ParameterizedType) {
                                Type actualType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                                if (actualType == v.getClass()) {
                                    Collection<MasterDto> relation = (Collection<MasterDto>) parentField.get(u.parent);
                                    relation.add(v);
                                }
                            }
                        }
                    }
                } else {
                    convertedDto = v;
                }
            }
            return convertedDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    private static boolean isSimpleType(Field f) {
        return Integer.class.isAssignableFrom(f.getType()) || Long.class.isAssignableFrom(f.getType()) ||
                Double.class.isAssignableFrom(f.getType()) || Boolean.class.isAssignableFrom(f.getType()) ||
                Float.class.isAssignableFrom(f.getType()) || String.class.isAssignableFrom(f.getType());
    }
}




