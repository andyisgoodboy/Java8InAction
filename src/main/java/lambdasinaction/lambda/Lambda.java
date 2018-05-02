package lambdasinaction.lambda;

import java.util.function.Function;

public class Lambda {
    Function<Object, String> f = obj -> obj.toString();
}



class InnerClass {
    Function<Object, String> f = new Function<Object, String>() {
        @Override
        public String apply(Object obj) {
            return obj.toString();
        }
    };
}