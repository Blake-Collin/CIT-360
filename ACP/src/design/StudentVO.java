package design;

public class StudentVO {
  private String id;
  private String name;

  //constructor
  public StudentVO(String id, String name) {
    this.id = id;
    this.name = name;
  }

  //setters and getters

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
