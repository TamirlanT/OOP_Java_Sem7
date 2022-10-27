package CodeReView.HumanTree;

public class View {

     //Создание дереве от младшего к старшему

    void ViewForward(Human n, String space) {
        if (n != null) {
            System.out.printf("%s%s %s %s\n", space, n.id, n.firstName, n.lastName);
            if (n.dad != null) ViewForward(n.dad, space + "  ");
            if (n.mom != null) ViewForward(n.mom, space + "  ");
        }
    }


     //Создание дерева от старшего к младшему


    void ViewReverse(Human n, StringBuilder sb, String str) {
        if (n != null) {
            if (n.sex == Human.Sex.male && n.wife != null) {
                sb.append(String.format("%sid: %d, name: %s, surname: %s (wife: %s %s)\n",
                        str, n.id, n.firstName, n.lastName, n.wife.firstName, n.wife.lastName));
            }
            else if (n.sex == Human.Sex.female && n.husband != null) {
                sb.append(String.format("%sid: %d, name: %s, surname: %s (husband: %s %s)\n",
                        str, n.id, n.firstName, n.lastName, n.husband.firstName, n.husband.lastName));
            }
            else sb.append(String.format("%sid: %d, name: %s, surname: %s\n",
                        str, n.id, n.firstName, n.lastName));
            if (!n.childs.isEmpty()) {
                str += "  ";
                for (Human child : n.childs) {
                    ViewReverse(child, sb, str);
                }
            }
        }
    }
}

