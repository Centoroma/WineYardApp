package DB.Object;

/**
 * Created by Cento on 19.04.2017.
 */

public class WineLot {

    private int id;
    private String name ;
    private float surface;
    private Integer numberWineStock;
    private String picture;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getSurface() {
        return surface;
    }

    public int getNumberWineStock() {
        return numberWineStock;
    }

    public String getPicture() {
        return picture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public void setNumberWineStock(int numberWineStock) {
        this.numberWineStock = numberWineStock;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
