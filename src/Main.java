import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import parent.ParentConfiguration;
import child.ChildContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext(
				ParentConfiguration.class);
		AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
		childContext.setParent(parentContext);
		childContext.register(ChildContext.class);
		childContext.refresh();
		childContext.close();
	}

}
