package SpringProj;

import java.util.HashMap;

public class Tests {
    public static void main(String[] args) {
        HashMap<Long, Long> map = null;
        map.clear();
        boolean t = false;

    }
}
    // Exception encountered during context initialization - cancelling refresh attempt:
    // org.springframework.beans.factory.BeanCreationException:
    // Error creating bean with name 'newsTypeRepository' defined in SpringProj.EntityETC.NewsTypeRepository defined in
    // @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration:
    // Invocation of init method failed; nested exception is java.lang.IllegalArgumentException:
    // Not a managed type: class SpringProj.EntityETC.NewsType

