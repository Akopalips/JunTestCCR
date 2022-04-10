package SpringProj;

import SpringProj.EntityETC.News;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRawValue;


public class Tests {
    public static void main(String[] args) {
        Tests main = new Tests();
        System.out.println("Love to Powder".split("o", 3)[2]);
    }
}
    // Exception encountered during context initialization - cancelling refresh attempt:
    // org.springframework.beans.factory.BeanCreationException:
    // Error creating bean with name 'newsTypeRepository' defined in SpringProj.EntityETC.NewsTypeRepository defined in
    // @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration:
    // Invocation of init method failed; nested exception is java.lang.IllegalArgumentException:
    // Not a managed type: class SpringProj.EntityETC.NewsType

