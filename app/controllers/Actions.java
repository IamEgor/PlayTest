package controllers;

import models.DB_Row;
import play.Logger;
import play.Routes;
import play.api.db.DB;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Egor on 07.07.2015.
 */
public class Actions extends Controller {

    private static final Form<DB_Row>   mainForm    = Form.form(DB_Row.class);

    public static Result getAllFields() {

        List<DB_Row> rows = DB_Row.finder.all();

        Form<DB_Row> rowForm = Form.form(DB_Row.class).bindFromRequest();
        return ok(views.html.TEMP_view_fields.render(rows, rowForm));
    }

    public static Result editField(Long id) {

        DB_Row row = DB_Row.finder.byId(id);

        Form<DB_Row> rowForm = Form.form(DB_Row.class).fill(row);

        Logger.info(rowForm.bindFromRequest().name());
        return ok(views.html.TEMP_fields_uu_id.render(rowForm));
    }

    public static Result newField() {
        return ok(views.html.TEMP_fields_uu_id.render(mainForm));
    }

    public static Result createFieldHolder() {

        DynamicForm requestData = Form.form().bindFromRequest();
        Logger.info(requestData.name());
        String propsList = requestData.data().get("propsList");
        String[] strings = request().body().asFormUrlEncoded().get("propsList[]");
        // inside strings you will have the item!

        Form<DB_Row> rowForm = Form.form(DB_Row.class).bindFromRequest();

        if (rowForm.hasErrors())
            return badRequest(views.html.TEMP_fields_uu_id.render(mainForm.bindFromRequest()));
        else {
            DB_Row row = rowForm.get();
            Logger.info("row.id = " + rowForm.value().toString());
            if(row.id == null)
                row.save();
            else {
                DB_Row row2 = DB_Row.finder.byId(row.id);
                row2.setDb_rows(row);
                row2.save();
                Logger.info("else");
            }
            return redirect(routes.Actions.getAllFields());
        }
    }

    public static Result deleteField(Long id) {

        DB_Row.finder.byId(id).delete();
        return redirect(routes.Actions.getAllFields());
    }


    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
                Routes.javascriptRouter("myJsRoutes",
                        routes.javascript.Actions.newField(),
                        routes.javascript.Actions.createFieldHolder(),
                        routes.javascript.Actions.deleteField(),
                        //inside somepackage
                        controllers.routes.javascript.Actions.deleteField()
                )
        );
    }
}
