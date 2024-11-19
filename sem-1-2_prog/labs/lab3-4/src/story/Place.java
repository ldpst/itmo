package story;

public enum Place {
    SINK,
    ROAD,
    SCENE;
    @Override
    public String toString() {
        if (this.name().equals("SCENE")){
            return "сцена";
        }
        if (this.name().equals("ROAD")){
            return "дорога";
        }
        if (this.name().equals("SINK")){
            return "раковина";
        }
        return null;
    }
}
