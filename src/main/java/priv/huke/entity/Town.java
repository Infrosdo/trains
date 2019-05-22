package priv.huke.entity;

public class Town {

    String name;

    public Town() {

    }

    public Town(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!Town.class.isInstance(obj)){
            return false;
        }
        if(this.name.equals(Town.class.cast(obj).name)){
            return true;
        }
        return false;
    }

}
