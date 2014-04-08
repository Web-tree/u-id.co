package co.uid.system.ClosureTemplate;

import com.google.gson.Gson;
import com.google.template.soy.tofu.SoyTofu;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClosureTemplateView extends AbstractTemplateView {

    private SoyTofu compiledTemplates;
    private String templateName;

    private Gson gson = new Gson();

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model,
                                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rendition;
        if ("json".equals(request.getParameter("view"))) {
            rendition = buildJson(model);
        } else {
            Map<String, Object> content = new HashMap<>(1);
            content.put("content", compiledTemplates.render(templateName, model, null));
            rendition = compiledTemplates.render("co.uid.index", content, null);
        }
        response.getWriter().write(rendition);
    }

    public void setCompiledTemplates(SoyTofu compiledTemplates) {
        this.compiledTemplates = compiledTemplates;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    private String buildJson(Map<String, Object> model) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("template", templateName);
        result.put("data", model);
        return gson.toJson(result);
    }

}
