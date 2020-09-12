package cayenne.note.project;

import cayenne.note.project.model.CarBrand;
import cayenne.note.project.model.CarModel;
import cayenne.note.project.model.Feedback;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.cayenne.query.ObjectSelect;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ServerRuntime cayenneRuntime = ServerRuntime.builder()
                .dataSource(DataSourceBuilder
                        .url("jdbc:mysql://127.0.0.1:3306/cars_demo")
                        .driver("com.mysql.cj.jdbc.Driver")
                        .userName("root") // Need to change to your username
                        .password("root") // Need to change to your password
                        .build())
                .addConfig("cayenne/cayenne-project.xml")
                .build();
        ObjectContext context = cayenneRuntime.newContext();

        initModel(context);

        List<CarBrand> carBrands = getBrands(context);
    }

    private static void initModel(ObjectContext context) {
        CarBrand carBrand = context.newObject(CarBrand.class);
        carBrand.setName("BMW");
        carBrand.setCountry("Germany");

        CarModel carModel = context.newObject(CarModel.class);
        carModel.setName("3-series");
        carModel.setCarBrand(carBrand);

        Feedback feedback = context.newObject(Feedback.class);
        feedback.setFeedback("Like");
        feedback.setCarModel(carModel);

        context.commitChanges();
    }

    private static List<CarBrand> getBrands(ObjectContext context) {
        return ObjectSelect.query(CarBrand.class)
                .select(context);
    }
}
