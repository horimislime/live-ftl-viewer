package controllers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result json(String source){
        String result=null;
        try {
            Configuration config = new Configuration();
            Reader reader = new InputStreamReader(new ByteArrayInputStream(source.getBytes()));
            Template template = new Template("sample", reader, config);

            result=FreeMarkerTemplateUtils.processTemplateIntoString(template, null);
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            result=e.getMessage();
        }
        return ok(result);
    }

    public static Result render() {
        return null;
    }
}
