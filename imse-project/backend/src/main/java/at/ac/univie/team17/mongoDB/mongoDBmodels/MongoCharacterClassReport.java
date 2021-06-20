package at.ac.univie.team17.mongoDB.mongoDBmodels;

public class MongoCharacterClassReport {
    private int classId;
    private int counter;

    public MongoCharacterClassReport(int classId, int counter) {
        this.classId = classId;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "MongoCharacterClassReport{" +
                "classId=" + classId +
                ", counter=" + counter +
                '}';
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
