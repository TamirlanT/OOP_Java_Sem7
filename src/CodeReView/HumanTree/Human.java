package CodeReView.HumanTree;

import java.util.ArrayList;

public class Human {
    public String firstName;
    public String lastName;
    public int id;
    Human dad;
    Human mom;
    Human wife;
    Human husband;
    Sex sex;
    ArrayList<Human> childs = new ArrayList<>();
    ArrayList<Human> sisters = new ArrayList<>();
    ArrayList<Human> brothers = new ArrayList<>();

    enum Sex {male, female}

    public Human(int id, String firstName, String lastName, Sex sex, Human dad, Human mom) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dad = dad;
        this.mom = mom;
        this.sex = sex;
        if (dad != null) {
            dad.childs.add(this);
            if (dad.childs.size() > 1) {
                for (Human child : dad.childs) {
                    if (child == this) {
                    } else if (child.sex == Sex.female) this.sisters.add(child);
                    else this.brothers.add(child);
                }
            }
        }
        if (dad != null && mom != null) {
            dad.wife = mom;
            mom.husband = dad;

        }
    }

    // Создание человека с указанием отца:
    public Human(int id, String firstName, String lastName, Sex sex, Human dad) {
        this(id, firstName, lastName, sex, dad, null);
    }

    // Создание человека без указания отца и матери:
    public Human(int id, String firstName, String lastName, Sex sex) {
        this(id, firstName, lastName, sex, null, null);
    }
    // Получение информации о человеке
    public StringBuilder getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s (%s)\n", this.firstName, this.lastName, this.sex));
        if (this.dad != null) sb.append(String.format("Dad: %s %s\n", this.dad.firstName, this.dad.lastName));
        if (this.mom != null) sb.append(String.format("Mom: %s %s\n", this.mom.firstName, this.mom.lastName));
        if (this.brothers != null) {
            for (Human child : this.brothers) {
                sb.append(String.format("Brother: %s %s\n", child.firstName, child.lastName));
            }
        }
        if (this.sisters != null) {
            for (Human child : this.sisters) {
                sb.append(String.format("Sister: %s %s\n", child.firstName, child.lastName));
            }
        }
        if (this.wife != null)
            sb.append(String.format("Wife: %s %s\n", this.wife.firstName, this.wife.lastName));
        if (this.husband != null)
            sb.append(String.format("Husband: %s %s\n", this.husband.firstName, this.husband.lastName));
        if (this.childs != null) {
            for (Human child : this.childs) {
                sb.append(String.format("Child: %s %s (%s)\n", child.firstName, child.lastName, child.sex));
            }
        }
        return sb;
    }
}

