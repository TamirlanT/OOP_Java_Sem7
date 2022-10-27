package CodeReView.HumanTree;

public class Tree {
    public static void main(String[] args) {
        // дед
        Human h301 = new Human(301, "Иван", "Иванов", Human.Sex.male);

        // дядя (сын деда (h301))
        Human h211 = new Human(211, "Петр", "Петров", Human.Sex.male, h301);

        // отец (сын деда (h301))
        Human h221 = new Human(221, "Маша", "Федоровна", Human.Sex.female, h301);

        // отец (сын деда (h301))
        Human h201 = new Human(201, "Вася", "Плотов", Human.Sex.male, h301);

        // мать
        Human h202 = new Human(202, "Аня", "Петрова", Human.Sex.female);

        // ребенок 1 (сын отца (h201) и мамы (h202))
        Human h101 = new Human(101, "Егор", "Петров", Human.Sex.male, h201, h202);

        // ребенок 2 (сын отца (h201) и мамы (h202))
        Human h102 = new Human(102, "Нина", "Ветрова", Human.Sex.female, h201, h202);

        System.out.println(h201.getInfo());
        System.out.println(h102.getInfo());

        System.out.println();
        StringBuilder sb = new StringBuilder();
        String str = "";
        View v = new View();
        v.ViewReverse(h301, sb, str);
        System.out.println(sb);
        v.ViewForward(h102, " ");
    }
}
