package cayenne.note.project.model.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.ListProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;

import cayenne.note.project.model.CarBrand;
import cayenne.note.project.model.Feedback;

/**
 * Class _CarModel was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CarModel extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final StringProperty<String> NAME = PropertyFactory.createString("name", String.class);
    public static final EntityProperty<CarBrand> CAR_BRAND = PropertyFactory.createEntity("carBrand", CarBrand.class);
    public static final ListProperty<Feedback> FEEDBACKS = PropertyFactory.createList("feedbacks", Feedback.class);

    protected String name;

    protected Object carBrand;
    protected Object feedbacks;

    public void setName(String name) {
        beforePropertyWrite("name", this.name, name);
        this.name = name;
    }

    public String getName() {
        beforePropertyRead("name");
        return this.name;
    }

    public void setCarBrand(CarBrand carBrand) {
        setToOneTarget("carBrand", carBrand, true);
    }

    public CarBrand getCarBrand() {
        return (CarBrand)readProperty("carBrand");
    }

    public void addToFeedbacks(Feedback obj) {
        addToManyTarget("feedbacks", obj, true);
    }

    public void removeFromFeedbacks(Feedback obj) {
        removeToManyTarget("feedbacks", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<Feedback> getFeedbacks() {
        return (List<Feedback>)readProperty("feedbacks");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "name":
                return this.name;
            case "carBrand":
                return this.carBrand;
            case "feedbacks":
                return this.feedbacks;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "name":
                this.name = (String)val;
                break;
            case "carBrand":
                this.carBrand = val;
                break;
            case "feedbacks":
                this.feedbacks = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.name);
        out.writeObject(this.carBrand);
        out.writeObject(this.feedbacks);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.name = (String)in.readObject();
        this.carBrand = in.readObject();
        this.feedbacks = in.readObject();
    }

}