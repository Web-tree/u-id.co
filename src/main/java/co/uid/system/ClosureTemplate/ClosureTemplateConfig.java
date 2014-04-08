package co.uid.system.ClosureTemplate;

import org.springframework.core.io.Resource;


public interface ClosureTemplateConfig {

	Resource getTemplatesLocation();
	boolean isRecursive();
	boolean isDevMode();
}
